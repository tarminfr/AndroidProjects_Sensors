package com.cnam.tarmin.sensors;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;
import android.view.View;

public class CompassView extends View {

    static final String OBJECT_TAG = "CompassView";
    float x, y;

    public CompassView(Context context) {
        super(context);
    }

    public void setValues(float x, float y) {
        this.x = x;
        this.y = y;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float xCenter = getMeasuredWidth() / 2;
        float yCenter = getMeasuredHeight() / 2;
        float radius = Math.min(xCenter, yCenter);
        float degree =(float) Math.toDegrees(Math.atan(x / y));

        Paint linePaint = new Paint();
        linePaint.setColor(Color.RED);
        linePaint.setStrokeWidth(5);

        Log.i(OBJECT_TAG, "onDraw called. x=" + x + ", y=" + y + ", degree=" + degree);
        Log.i(OBJECT_TAG, "drawLine values > xStart=" + xCenter + ", yStart=" + yCenter + ", xEnd=" + xCenter + radius + ", yEnd=" + yCenter + radius);

        canvas.drawCircle(xCenter, yCenter, radius, new Paint());
        canvas.drawLine(xCenter, yCenter, xCenter + radius, yCenter + radius, linePaint);
        canvas.save();
        canvas.rotate(degree);
    }
}
