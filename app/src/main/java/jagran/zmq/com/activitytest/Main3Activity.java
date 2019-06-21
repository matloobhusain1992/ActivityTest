package jagran.zmq.com.activitytest;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import jagran.zmq.com.activitytest.fragmentcommunication.FragmentOne;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        System.out.println("onCreate Main3Activity  method id called");
        FragmentOne loginFragment = new FragmentOne();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.activity_main3,loginFragment,"loginfragment");
        fragmentTransaction.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("onStart Main3Activity  method id called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("onResume  Main3Activity method id called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("onPause  Main3Activity method id called");
    }

    @Override
    protected void onStop() {
        super.onStop();
            System.out.println("onStop  Main3Activity method id called");

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy  Main3Activity method id called");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("onRestart  Main3Activity method id called");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        System.out.println("onBackPressed  Main3Activity method id called");
    }

    public void click1(View view){
        System.out.println("click1  Main3Activity method id called");
    }

}
