package jagran.zmq.com.activitytest.HandlerLooper;

import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import jagran.zmq.com.activitytest.R;

public class HandlerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        System.out.println("Looper "+ Thread.currentThread().getName());
        WorkerThread thread = new WorkerThread();
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Message message = thread.handler.obtainMessage();
        message.what = 1;
        thread.handler.sendMessage(message);
        thread.handler.post(new Runnable() {
            @Override
            public void run() {
                System.out.println("Matloob hUSain "+Thread.currentThread().getName());
            }
        });

        Message message1 = thread.handler.obtainMessage();
        message.what = 1;
        thread.handler.sendMessage(message1);
        thread.handler.post(new Runnable() {
            @Override
            public void run() {
                System.out.println("Matloob hUSain "+Thread.currentThread().getName());
            }
        });

        Message message2 = thread.handler.obtainMessage();
        message.what = 1;
        thread.handler.sendMessage(message2);
        thread.handler.post(new Runnable() {
            @Override
            public void run() {
                System.out.println("Matloob hUSain "+Thread.currentThread().getName());
            }
        });

        Message message3 = thread.handler.obtainMessage();
        message.what = 1;
        thread.handler.sendMessage(message3);
        thread.handler.post(new Runnable() {
            @Override
            public void run() {
                System.out.println("Matloob hUSain "+Thread.currentThread().getName());
            }
        });
    }
}
