package com.example.android.bounce;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {
    private int finX = 612;
    private int finY = 1060;
    private Vibrator v;
    CustomDrawableView cv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        cv = new CustomDrawableView(this);
        setContentView(cv);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        ///initial values////
        int x = (int)event.getX();
        int y = (int)event.getY();
        double d = Math.pow(Math.pow(y-finY, 2) + Math.pow(x-finX, 2), .5);
        //////////////////////Find Color Values////////////////////
        //View rootView = (View) findViewById(R.id.activity_main);
        Log.i("my tag",x + " " + y + " " + d);
        if(d>1224) d = 1224;
        int g = 51;
        int r = 51;
        int b = 255;
        /////adjusted for one color///////
        int j = 6;
        r+=(1224-d)/j;
        int RGB = android.graphics.Color.rgb(r, g, b);
        ///////////////////////////////////
        if(d < 50){
            v.vibrate(100);
        }
        //rootView.setBackgroundColor(RGB);
        ////////set Background Color///////
        cv.changeColor(RGB);
        cv.changeBounds(x,y,10,10);
        setContentView(cv);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
        }


        return false;
    }
}
//adjusted for two colors//////////
        /*int j = 3; ///so i tried the two color thing it doesn't flow well, but it works. uncomment to see
        if(d > 612){
            b = 51;
            r+= (1224-d)/j;
        }else{
            r = 255;
            b -= (612-d)/j;
        }*/
/////////////////////////////////
