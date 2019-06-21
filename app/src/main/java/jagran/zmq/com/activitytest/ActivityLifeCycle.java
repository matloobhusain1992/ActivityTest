package jagran.zmq.com.activitytest;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class ActivityLifeCycle extends AppCompatActivity {

    private MyAsyn asyn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        System.out.println("onCreate ActivityLifeCycle called");
        asyn = new MyAsyn();
        asyn.execute();
    }




    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("onStart ActivityLifeCycle called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("onResume ActivityLifeCycle called ");
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
    protected void onRestart() {
        super.onRestart();
        System.out.println("onRestart ActivityLifeCycle called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy ActivityLifeCycle called");
    }

    public void save(View view) {
        Intent intent = new Intent();
        intent.setClass(ActivityLifeCycle.this , ActivityLifeCycleTwo.class);
        intent.putExtra("student",new Student(1,"Matloob","A+"));
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawer,menu);
        System.out.println("onCreateOptionsMenu ActivityLifeCycle called");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        System.out.println("onCreateOptionsMenu ActivityLifeCycle called");
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        System.out.println("onSaveInstanceState 11 ActivityLifeCycle called");

        outState.putString("a","Matloob Husain");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        System.out.println("onRestoreInstanceState 11 ActivityLifeCycle called   "+savedInstanceState.get("a"));
    }

    public void start(View view) {
        asyn.cancel(true);
    }


    public class MyAsyn extends AsyncTask<Void,Void,String>{

        @Override
        protected void onPreExecute() {
            System.out.println("onPreExecute ActivityLifeCycle called");
        }

        @Override
        protected String doInBackground(Void... voids) {
            System.out.println("doInBackground ActivityLifeCycle called");
            for(int i = 0;i<5;i++){
                if(isCancelled()){
                    return "Failed";
                }
                System.out.println("Value of i "+i);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "Succes";
        }

        @Override
        protected void onPostExecute(String s) {
            System.out.println("onPostExecute ActivityLifeCycle called  "+s);
        }

        @Override
        protected void onCancelled(String s) {
            System.out.println("onCancelled ActivityLifeCycle called   "+s);
        }
    }

}
