package jagran.zmq.com.activitytest.drawerlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import jagran.zmq.com.activitytest.R;

public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    @Override
    public void onBackPressed() {
        MainActivity.user.setName(((EditText)findViewById(R.id.data)).getText().toString());
        super.onBackPressed();

    }
}
