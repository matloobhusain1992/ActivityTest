package jagran.zmq.com.activitytest;

import android.content.Context;
import android.database.ContentObserver;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {

    int framesPerSecond = 60;
    long animationDuration = 10000; // 10 seconds

    Matrix matrix = new Matrix(); // transformation matrix

    Path path = new Path();       // your path
    Paint paint = new Paint();    // your paint

    long startTime;

    public MyView(Context context) {
        super(context);

        // start the animation:
        this.startTime = System.currentTimeMillis();
        this.postInvalidate();
    }

    public MyView(Context context, AttributeSet set) {
        super(context,set);

        // start the animation:
        this.startTime = System.currentTimeMillis();
        this.postInvalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        long elapsedTime = System.currentTimeMillis() - startTime;

        matrix.postRotate(30 * elapsedTime/1000);        // rotate 30° every second
        matrix.postTranslate(100 * elapsedTime/1000, 0); // move 100 pixels to the right
        // other transformations...

        canvas.concat(matrix);        // call this before drawing on the canvas!!

        canvas.drawPath(path, paint); // draw on canvas

        if(elapsedTime < animationDuration)
            this.postInvalidateDelayed( 1000 / framesPerSecond);
    }

}