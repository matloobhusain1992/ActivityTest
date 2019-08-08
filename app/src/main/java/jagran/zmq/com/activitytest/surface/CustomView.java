package jagran.zmq.com.activitytest.surface;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by zmq181 on 3/4/19.
 */

public class CustomView extends BaseSurface{

    private Paint paint;

    public CustomView(Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(Color.RED);
    }

    @Override
    public void drawCanvas(Canvas c) {
        c.drawRect(0,0,500,500,paint);
    }
}
