/*
Author: Santiago Franco
Teacher: Professor Andrew Nuxoll
Assignment: Custom Coloring Assignment (Unique Frog)
Date Completed: February 10th, 2022
 */


package com.example.customcoloringassignment;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class Controller implements SeekBar.OnSeekBarChangeListener, View.OnTouchListener{

    private Drawing drawing;
    private TextView name;
    private SeekBar red;
    private SeekBar green;
    private SeekBar blue;
    private CustomCircle customCircle = null;


    //controller constructor
    public Controller(Drawing initView, TextView viewName, SeekBar red, SeekBar green, SeekBar blue) {
        this.drawing = initView;
        this.name = viewName;
        this.red = red;
        this.green = green;
        this.blue = blue;
    }


    //changes the color of the current object based on the seekbar values
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if (customCircle != null){
            int redVal = red.getProgress();
            int greenVal = green.getProgress();
            int blueVal = blue.getProgress();
            int newColor = Color.rgb(redVal,greenVal,blueVal);
            customCircle.setColor(newColor);
            drawing.invalidate();
        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }


    //checks if touch is inside of an element and changes the current element to that object
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int currColor;
        int numRed;
        int numGreen;
        int numBlue;

        if (drawing.getBody().containsPoint(x,y)) {
            name.setText(drawing.getBody().getName());
            this.customCircle = drawing.getBody();
        }
        else if (drawing.getFin().containsPoint(x,y)) {
            this.customCircle = drawing.getFin();
            name.setText(customCircle.getName());
        }
        else if (drawing.getTopEye().containsPoint(x,y)) {
            name.setText(drawing.getTopEye().getName());
            this.customCircle = drawing.getTopEye();
        }
        else if (drawing.getBottomEye().containsPoint(x,y)) {
            name.setText(drawing.getBottomEye().getName());
            this.customCircle = drawing.getBottomEye();
        }
        else if (drawing.getTopArm().containsPoint(x,y)) {
            name.setText(drawing.getTopArm().getName());
            this.customCircle = drawing.getTopArm();
        }
        else if (drawing.getBottomArm().containsPoint(x,y)) {
            name.setText(drawing.getBottomArm().getName());
            this.customCircle = drawing.getBottomArm();
        }
        else{
            this.customCircle = null;
            return true;
        }

        //gets the current color of the circle and changes the seekbars
        currColor = customCircle.getColor();
        numRed = Color.red(currColor);
        numGreen = Color.green(currColor);
        numBlue = Color.blue(currColor);
        red.setProgress(numRed);
        green.setProgress(numGreen);
        blue.setProgress(numBlue);
        drawing.invalidate();
        return true;
    }

}
