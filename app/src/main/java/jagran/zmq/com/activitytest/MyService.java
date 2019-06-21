package jagran.zmq.com.activitytest;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by zmq181 on 6/9/17.
 */

public class MyService extends Service {



//    Handler mHandler = new Handler(Looper.getMainLooper()) {
//        @Override
//        public void handleMessage(Message message) {
//            // This is where you do your work in the UI thread.
//            // Your worker tells you in the message what to do.
////            System.out.println("value of i ="+message.toString());
////            Toast.makeText(getBaseContext(),"value of i ="+message.toString(),Toast.LENGTH_SHORT).show();
//        }
//    };

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            System.out.println("value of i ="+msg.what);
//            byte[] writeBuf = (byte[]) msg.obj;
//            String writeMessage = new String(writeBuf);
            Toast.makeText(getBaseContext(),"value of i ="+msg.obj,Toast.LENGTH_SHORT).show();
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Service onCreate");
                for(int i=0;i<5;i++){
                    try {
                        Message message = mHandler.obtainMessage(1, new String(String.valueOf(i)));
                        message.sendToTarget();
                       // System.out.println("value of i ="+i);
//                        Toast.makeText(getBaseContext(),"value of i ="+i,Toast.LENGTH_SHORT).show();
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("Service onStartCommand "+intent+"   "+flags+"   "+startId);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        System.out.println("Service onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        System.out.println("Service onRebind");
    }

    @Override
    public void onDestroy() {
       super.onDestroy();
        System.out.println("Service onDestroy");
    }
}
