package jagran.zmq.com.activitytest;

import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Environment;
import android.os.Parcelable;
import android.support.v4.content.IntentCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.Serializable;

public class ActivityLifeCycleTwo extends AppCompatActivity {

    static Context c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle_two);
        System.out.println("onCreate ActivityLifeCycleTwo called");

       /* c = getApplicationContext();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        registerReceiver(new MyReceiver(),intentFilter);
*/

       Intent intent = getIntent();
       Student s = intent.getExtras().getParcelable("student");
       System.out.println(s.toString());


    }

    @Override
    protected void onStart() {
        super.onStart();
//        finish();
        System.out.println("onStart ActivityLifeCycleTwo called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("onResume ActivityLifeCycleTwo called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("onPause ActivityLifeCycleTwo called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("onStop ActivityLifeCycleTwo called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("onRestart ActivityLifeCycleTwo called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy ActivityLifeCycleTwo called");
    }

    public void save2(View view) {
        /*Intent intent = new Intent();
        intent.setClass(ActivityLifeCycleTwo.this,ActivityLifeCycle.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);*/
//        Intent intent = new Intent();
//        intent.setAction("com.husain");
//        sendBroadcast(intent);

    }



    public static class MyReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(c , "Batry = "+intent.getAction().toString(),Toast.LENGTH_LONG).show();
        }
    }
}


