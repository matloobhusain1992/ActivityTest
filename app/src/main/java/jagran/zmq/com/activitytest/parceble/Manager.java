package jagran.zmq.com.activitytest.parceble;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import jagran.zmq.com.activitytest.R;

public class Manager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
        Contact contact = (Contact) getIntent().getExtras().getParcelable("info");
        System.out.println(contact);
    }
}
