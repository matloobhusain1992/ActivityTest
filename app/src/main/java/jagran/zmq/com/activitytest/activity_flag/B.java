package jagran.zmq.com.activitytest.activity_flag;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import jagran.zmq.com.activitytest.R;

public class B extends Activity implements TaskListener{

    EditText editText;
    TextView textView;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        System.out.println("B onCreate ");
        editText = (EditText) findViewById(R.id.edit_text);
        textView = (TextView) findViewById(R.id.text_view);

        //new AsyncTaskExample(this).execute();
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("B onStart");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        System.out.println("B onRestoreInstanceState "+savedInstanceState.getString("Name"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("B onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("B onPause");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("Name","Matloob Husain");
        super.onSaveInstanceState(outState);
        System.out.println("B onSaveInstanceState");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        System.out.println("B onNewIntent");
    }

    public void activityBClick(View view) {
        /*Intent intent = new Intent(this , C.class);
        startActivity(intent);*/
        setResult(RESULT_OK);

    }

    @Override
    public void onTaskStarted() {
        progressDialog = ProgressDialog.show(B.this, "Loading", "Please wait a moment!");
    }

    @Override
    public void onTaskFinished(String result) {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    public class AsyncTaskExample extends AsyncTask<String, Integer, String> {

        private final TaskListener listener;

        public AsyncTaskExample(TaskListener listener) {
            this.listener = listener;
        }

        @Override
        protected void onPreExecute() {
            listener.onTaskStarted();
        }

        @Override
        protected String doInBackground(String... params) {
            for (int i = 1; i <= 10; i++) {
                Log.d("GREC", "AsyncTask is working: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "All Done!";
        }

        @Override
        protected void onPostExecute(String result) {
            listener.onTaskFinished(result);
        }
    }


}
 interface TaskListener {
    void onTaskStarted();

    void onTaskFinished(String result);
}
