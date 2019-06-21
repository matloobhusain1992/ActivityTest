package jagran.zmq.com.activitytest.HandlerLooper;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/**
 * Created by zmq181 on 24/4/19.
 */

public class WorkerThread extends Thread {

    public Handler handler;
    @Override
    public void run() {
        Looper.prepare();
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                System.out.println("handleMessage "+Thread.currentThread().getName());
            }
        };
        Looper.loop();
        System.out.println("End thread "+Thread.currentThread().getName());
    }
}
