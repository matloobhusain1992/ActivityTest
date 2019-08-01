package jagran.zmq.com.activitytest.activity_flag;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import jagran.zmq.com.activitytest.MyReceiver;
import jagran.zmq.com.activitytest.R;

public class A extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("A onRestart");
        System.out.println("master 1");
        System.out.println("Child 1");
        System.out.println("master 2");
        System.out.println("Child 2");
        System.out.println("master 3");
        System.out.println("master 4");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("A onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("A onResume");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        System.out.println("A onNewIntent");
    }

    public void activityClick(View view) {
        Intent intent = new Intent(this , B.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println("A onActivityResult");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("onPause ActivityLifeCycle called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("onStop ActivityLifeCycle called");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy ActivityLifeCycle called");
    }
}
