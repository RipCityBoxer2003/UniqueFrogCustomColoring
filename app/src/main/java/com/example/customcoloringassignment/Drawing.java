/*
Author: Santiago Franco
Teacher: Professor Andrew Nuxoll
Assignment: Custom Coloring Assignment (Unique Frog)
Date Completed: February 10th, 2022
 */


package com.example.customcoloringassignment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class Drawing extends SurfaceView {

    private CustomCircle body;
    private CustomCircle fin;
    private CustomCircle topEye;
    private CustomCircle bottomEye;
    private CustomCircle topArm;
    private CustomCircle bottomArm;
    private Paint myPaint;

    public CustomCircle getBody() {return body;}
    public CustomCircle getFin() {return fin;}
    public CustomCircle getTopEye() {return topEye;}
    public CustomCircle getBottomEye(){return bottomEye ;}
    public CustomCircle getTopArm(){return topArm;}
    public CustomCircle getBottomArm(){return bottomArm;}

    public Drawing(Context context, AttributeSet attrs) {
        super(context, attrs);
        body = new CustomCircle("Body", Color.GREEN, 1000, 400, 200);
        fin = new CustomCircle("Fin", Color.GREEN, 735, 400, 75);
        topEye= new CustomCircle("Top Eye", Color.WHITE, 1200, 300, 30);
        bottomEye = new CustomCircle("Bottom Eye", Color.WHITE, 1200, 425, 30);
        topArm= new CustomCircle("Top Arm", Color.YELLOW, 1000, 175, 50);
        bottomArm = new CustomCircle("Bottom Arm", Color.YELLOW, 1000, 625, 50);
        setWillNotDraw(false);
    }

    @Override
    public void onDraw(Canvas canvas){
        body.drawMe(canvas);
        fin.drawMe(canvas);
        topEye.drawMe(canvas);
        bottomEye.drawMe(canvas);
        topArm.drawMe(canvas);
        bottomArm.drawMe(canvas);
    }

}