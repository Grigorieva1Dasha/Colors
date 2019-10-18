package com.example.user.color;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class colorgame extends AppCompatActivity {

    View[][] titles = new View[4][4];
    int color1, color2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colorgame);
        Resources r = getResources();
        color1 = r.getColor(R.color.col1);
        color2 = r.getColor(R.color.col2);
        titles[0][0] = findViewById(R.id.b00);
        titles[0][1] = findViewById(R.id.b01);
        titles[0][2] = findViewById(R.id.b02);
        titles[0][3] = findViewById(R.id.b03);
        titles[1][0] = findViewById(R.id.b10);
        titles[1][1] = findViewById(R.id.b11);
        titles[1][2] = findViewById(R.id.b12);
        titles[1][3] = findViewById(R.id.b13);
        titles[2][0] = findViewById(R.id.b20);
        titles[2][1] = findViewById(R.id.b21);
        titles[2][2] = findViewById(R.id.b22);
        titles[2][3] = findViewById(R.id.b23);
        titles[3][0] = findViewById(R.id.b30);
        titles[3][1] = findViewById(R.id.b31);
        titles[3][2] = findViewById(R.id.b32);
        titles[3][3] = findViewById(R.id.b33);
        fillField();
    }

    public void fillField(){
        double random;
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                random = Math.random();
                if (random < 0.5){
                    changeColor(titles[i][j]);
                }
            }
        }
    }

    public void changeColor(View v) {
        ColorDrawable d = (ColorDrawable) v.getBackground();
        if (d.getColor() == color1) {
            v.setBackgroundColor(color2);
        } else {
            v.setBackgroundColor(color1);
        }
    }

    public void onClick(View v){
        String tag = v.getTag().toString();
        String[] coord = tag.split(" ");
        int x = Integer.parseInt(coord[0]);
        int y = Integer.parseInt(coord[1]);
        changeColor(v);
        for (int k = 0; k < 4; k++){
            changeColor(titles[x][k]);
            changeColor(titles[k][y]);
        }
        int wincol1 = 0;
        int wincol2 = 0;
        for ( int i = 0; i < 4; i++ ){
            for ( int j = 0; j < 4; j++ ){
                ColorDrawable cd = (ColorDrawable)titles[i][j].getBackground();
                if (cd.getColor() == color1){
                    wincol1++;
                }
                else {
                    wincol2++;
                }
            }
        }
        if (wincol1 == 16 || wincol2 == 16){
            Toast end = Toast.makeText(this, "Ура! Победа!", Toast.LENGTH_LONG);
            end.show();
        }
    }
}
