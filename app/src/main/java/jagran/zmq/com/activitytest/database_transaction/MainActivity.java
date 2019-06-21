package jagran.zmq.com.activitytest.database_transaction;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import jagran.zmq.com.activitytest.R;

public class MainActivity extends Activity {

    EditText editTextRecordNum;
    TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_database);

        SharedPreferences preferences1 = getSharedPreferences("a",MODE_PRIVATE);
        SharedPreferences preferences2 = getSharedPreferences("c",MODE_PRIVATE);
        SharedPreferences preferences3 = getSharedPreferences("b",MODE_PRIVATE);

        System.out.println("SharedPreferences =  "+preferences1);
        System.out.println("SharedPreferences =  "+preferences2);
        System.out.println("SharedPreferences =  "+preferences3);

        View.OnClickListener handler = new View.OnClickListener() {
            public void onClick(View v) {

                switch (v.getId()) {

                    case R.id.buttonNormalInsert:
                        new AsyncInsertData("normal").execute();
                        break;
                    case R.id.buttonFastInsert:
                        new AsyncInsertData("fast").execute();
                        break;
                }
            }
        };

        // EditText for entering desired number of records to be inserted
        editTextRecordNum = (EditText) findViewById(R.id.editTextRecordNum);

        // Button for normal and fast insert
        findViewById(R.id.buttonNormalInsert).setOnClickListener(handler);
        findViewById(R.id.buttonFastInsert).setOnClickListener(handler);

        // status TextView
        tvStatus = (TextView) findViewById(R.id.textViewStatus);

    }

    // we used AsyncTask so it won't block the UI thread during inserts.
    class AsyncInsertData extends AsyncTask<String, String, String> {

        DatabaseHandler databaseHandler;
        String type;
        long timeElapsed;

        protected AsyncInsertData(String type){
            this.type  = type;
            this.databaseHandler = new DatabaseHandler(MainActivity.this);
        }

        // @type - can be 'normal' or 'fast'
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tvStatus.setText("Inserting " + editTextRecordNum.getText() + " records...");
        }

        @Override
        protected String doInBackground(String... aurl) {

            try {

                // get number of records to be inserted
                int insertCount = Integer.parseInt(editTextRecordNum.getText().toString());

                // empty the table
                databaseHandler.deleteRecords();

                // keep track of execution time
                long lStartTime = System.nanoTime();

                if (type.equals("normal")) {
                    databaseHandler.insertNormal(insertCount);
                } else {
                    databaseHandler.insertFast(insertCount);
                }

                // execution finised
                long lEndTime = System.nanoTime();

                // display execution time
                timeElapsed = lEndTime - lStartTime;

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(String unused) {
            tvStatus.setText("Done inserting " + databaseHandler.countRecords() + " records. Time elapsed: " + timeElapsed / 1000000 + " ms.");
        }

    }
}