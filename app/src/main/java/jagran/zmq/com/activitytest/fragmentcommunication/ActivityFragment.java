package jagran.zmq.com.activitytest.fragmentcommunication;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import jagran.zmq.com.activitytest.R;

public class ActivityFragment extends AppCompatActivity implements FragmentOne.FragmentOneInterf,FragmentTwo.FragmentTwoInterf{

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private FragmentOne fragmentOne;
    private FragmentTwo fragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        System.out.println("onCreate ActivityLifeCycleTwo called");
        addFragment();
    }

    private void addFragment(){
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentOne = new FragmentOne();
        fragmentTransaction.add(R.id.fragment_container,fragmentOne);
        fragmentTransaction.commit();
    }

    private void singleFragment(){
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentOne = new FragmentOne();
        fragmentTransaction.add(R.id.fragment_one,fragmentOne);
        fragmentTransaction.addToBackStack(FragmentOne.class.getName());
        fragmentTransaction.commit();
    }

    private void parallelFragment(){
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentOne = new FragmentOne();
        fragmentTwo = new FragmentTwo();
        fragmentTransaction.add(R.id.fragment_one,fragmentOne);
        fragmentTransaction.add(R.id.fragment_two,fragmentTwo);
        fragmentTransaction.commit();





    }

    @Override
    public void setDataSecond(String s) {
        fragmentOne.setText(s);
    }

    @Override
    public void setData(String s) {
//        fragmentTwo.setText(s);
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTwo = new FragmentTwo();
        fragmentTransaction.add(R.id.fragment_container,fragmentTwo);
        fragmentTransaction.commit();
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

}
