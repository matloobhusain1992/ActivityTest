package jagran.zmq.com.activitytest.activity_flag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import jagran.zmq.com.activitytest.R;

public class D extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d);
        System.out.println("D onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("D onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("D onResume");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        System.out.println("D onNewIntent");
    }


    public void activityDClick(View view) {
        Intent intent = new Intent(this , B.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
