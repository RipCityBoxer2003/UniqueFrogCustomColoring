/*
Author: Santiago Franco
Teacher: Professor Andrew Nuxoll
Assignment: Custom Coloring Assignment (Unique Frog)
Date Completed: February 10th, 2022
 */

package com.example.customcoloringassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Drawing drawingView = findViewById(R.id.SurfaceView);
        TextView name = (TextView)findViewById(R.id.name);
        SeekBar red = findViewById(R.id.redHandler);
        SeekBar green = findViewById(R.id.greenHandler);
        SeekBar blue = findViewById(R.id.blueHandler);

        //created controller
        Controller viewController = new Controller(drawingView, name, red, green, blue);

        //set up listeners
        red.setOnSeekBarChangeListener(viewController);
        green.setOnSeekBarChangeListener(viewController);
        blue.setOnSeekBarChangeListener(viewController);
        drawingView.setOnTouchListener(viewController);


    }


}