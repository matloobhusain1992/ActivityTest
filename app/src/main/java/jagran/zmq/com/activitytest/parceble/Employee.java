package jagran.zmq.com.activitytest.parceble;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import jagran.zmq.com.activitytest.R;

public class Employee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
    }

    public void sendContact(View view) {
        Contact.Address address = new Contact.Address("masjid","shakurpur",556);
        Contact contact = new Contact("Matloob",27,12345,address);
        Intent intent = new Intent(this,Manager.class);
        intent.putExtra("info",contact);
        startActivity(intent);
    }
}
