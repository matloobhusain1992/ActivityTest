package jagran.zmq.com.activitytest.activity_flag;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import jagran.zmq.com.activitytest.R;

public class C extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        System.out.println("C onCreate");
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Alert");
        dialog.setMessage("Welcome Dear");
        dialog.show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("C onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("C onResume");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        System.out.println("C onNewIntent");
    }


    public void activityCClick(View view) {
        Intent intent = new Intent(this , D.class);
        startActivity(intent);
    }
}
