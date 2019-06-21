package jagran.zmq.com.activitytest.surface;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by zmq181 on 3/4/19.
 */

public abstract class BaseSurface extends SurfaceView {

    private Game game;

    public BaseSurface(Context context) {
        super(context);
        getHolder().addCallback(callback);
    }

    SurfaceHolder.Callback callback = new SurfaceHolder.Callback() {
        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            System.out.println("surfaceCreated");
            if(game == null){
                game = new Game(holder);
                game.start();
            }

        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            System.out.println("surfaceChanged");
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            System.out.println("surfaceDestroyed");
            game.run = false;
            holder.removeCallback(callback);
        }
    };

    public class Game extends Thread{
        public boolean run = true;
        private SurfaceHolder holder;

        public Game(SurfaceHolder holder) {
            this.holder = holder;
        }

        @Override
        public void run() {
            while (run){
                System.out.println("Thread run");
                try {
                    Canvas canvas = holder.lockCanvas();
                    drawCanvas(canvas);
                    holder.unlockCanvasAndPost(canvas);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public abstract void drawCanvas(Canvas c);
}
