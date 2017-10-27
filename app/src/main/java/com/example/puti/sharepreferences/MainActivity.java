package com.example.puti.sharepreferences;

import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_red, btn_green, btn_yellow;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        btn_red = (Button) findViewById(R.id.btn_red);
        btn_green = (Button) findViewById(R.id.btn_green);
        btn_yellow = (Button) findViewById(R.id.btn_yellow);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        if(getcolor() != getResources().getColor(R.color.colorPrimary)){
            toolbar.setBackgroundColor(getcolor());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(getcolor());
            }
        }
        btn_red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toolbar.setBackgroundColor(getResources().getColor(R.color.colorRed));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.colorRed));
                }
                setcolor(getResources().getColor(R.color.colorRed));
            }
        });
        btn_green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toolbar.setBackgroundColor(getResources().getColor(R.color.colorGreen));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.colorGreen));
                }
                setcolor(getResources().getColor(R.color.colorGreen));
            }
        });
        btn_yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toolbar.setBackgroundColor(getResources().getColor(R.color.colorYellow));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.colorYellow));
                }
                setcolor(getResources().getColor(R.color.colorYellow));
            }
        });
    }
    private void setcolor(int color){
        SharedPreferences sharedPreferences = getSharedPreferences("Color",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("color", color);
        editor.apply();
    }
    private int getcolor(){
        SharedPreferences sharedPreferences = getSharedPreferences("Color",MODE_PRIVATE);
        int selectedColor = sharedPreferences.getInt("color",getResources().getColor(R.color.colorPrimary));
        return selectedColor;
    }
}
