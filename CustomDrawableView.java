package com.example.android.bounce;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.view.View;

/**
 * Created by sagarsaxena on 3/24/17.
 */

public class CustomDrawableView extends View {
    private ShapeDrawable mDrawable;
    private ShapeDrawable mDrawable2;
    public int x = 612;
    public int y = 1060-250;
    public int h = 20;
    public int w = 20;
    public CustomDrawableView(Context context) {
        super(context);
        mDrawable2 = new ShapeDrawable(new RectShape());
        mDrawable2.getPaint().setColor(Color.parseColor("#303F9F"));
        mDrawable2.setBounds(0,0,3000,3000);
        mDrawable = new ShapeDrawable(new OvalShape());
        mDrawable.getPaint().setColor(Color.parseColor("#9c27b0"));
        mDrawable.setBounds(x, y, x + w, y + h);
    }
    public void changeBounds(int a, int b, int c, int d){
        x = a;
        y = b-250;
        h = c;
        w = d;
        mDrawable.setBounds(x, y, x + w, y + h);
    }
    public void changeColor(int color){
        mDrawable2.getPaint().setColor(color);
    }
    protected void onDraw(Canvas canvas) {
        mDrawable2.draw(canvas);
        mDrawable.draw(canvas);
    }
}
