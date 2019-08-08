package jagran.zmq.com.activitytest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by zmq181 on 7/9/17.
 */

public class MySecondService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("Service onCreate 222");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("Service onStartCommand 22222"+intent+"   "+flags+"   "+startId);
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
        System.out.println("Service onDestroy 22222");
    }
}
