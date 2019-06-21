package jagran.zmq.com.activitytest;

//
//import java.util.ArrayList;
//import java.util.Locale;
//
//import android.app.Activity;
//import android.content.ActivityNotFoundException;
//import android.content.Intent;
//import android.os.Bundle;
//import android.speech.RecognizerIntent;
//import android.view.Menu;
//import android.view.View;
//import android.widget.ImageButton;
//import android.widget.TextView;
//import android.widget.Toast;
//
//public class MainActivity extends Activity {
//
//    private TextView txtSpeechInput;
//    private ImageButton btnSpeak;
//    private final int REQ_CODE_SPEECH_INPUT = 100;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        txtSpeechInput = (TextView) findViewById(R.id.txtSpeechInput);
//        btnSpeak = (ImageButton) findViewById(R.id.btnSpeak);
//
//        // hide the action bar
////        getActionBar().hide();
//
//        btnSpeak.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                promptSpeechInput();
//            }
//        });
//
//    }
//
//    /**
//     * Showing google speech input dialog
//     * */
//    private void promptSpeechInput() {
//        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
//        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
//                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
//        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
//        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
//                getString(R.string.speech_prompt));
//        try {
//            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
//        } catch (ActivityNotFoundException a) {
//            Toast.makeText(getApplicationContext(),
//                    getString(R.string.speech_not_supported),
//                    Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    /**
//     * Receiving speech input
//     * */
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        System.out.println("matloob husain");
//        switch (requestCode) {
//            case REQ_CODE_SPEECH_INPUT: {
//
//                if (resultCode == RESULT_OK && null != data) {
//
//                    ArrayList<String> result = data
//                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
//                    txtSpeechInput.setText(result.get(0));
//                }
//                break;
//            }
//
//        }
//    }
//
//}


import android.app.DatePickerDialog;
import android.os.Message;
import android.os.PowerManager;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import java.util.Calendar;

import jagran.zmq.com.activitytest.fragmentcommunication.FragmentOne;

public class MainActivity extends AppCompatActivity implements MenuFragment.Communicator,Runnable{

    PowerManager.WakeLock mwWakeLock;
    EditText editText;
    DatePickerDialog datePickerDialog;
    Calendar myCalendar;
    int mYear,mMonth,mDay;
    Calendar dateSelected;
    DatePickerDialog.OnDateSetListener date;
    Thread thread;
    int a = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        System.out.println("onCreate  method id called  = "+this +"      \n"+getApplicationContext());

//        Intent intent = new Intent();
//        intent.setClass(MainActivity.this,Main2Activity.class);
//        startActivity(intent);

        if(savedInstanceState==null){
            FragmentManager manager = getSupportFragmentManager();
            MenuFragment menuFragment = new MenuFragment();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.activity_main3,menuFragment,"aaa");
            transaction.addToBackStack("aaa");
            transaction.commit();
            menuFragment.setCommunicator(this);
        }


//        String filename = "myfile";
//        String string = "My name is matloob";
//        FileOutputStream outputStream;
//
//        try {
//            File file = new File(getApplicationContext().getFilesDir(), filename);
//            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
//            outputStream.write(string.getBytes());
//            outputStream.close();
//            Intent intent = new Intent(Intent.ACTION_SEND);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//
//        FileOutputStream out = null;
//        String fileName = "MyFile";
//        String content = "hello,world";
//        try {
//            File mediaStorageDir = new File(Environment.getExternalStorageDirectory()+"/Arduino");
//            if (! mediaStorageDir.exists()){
//                mediaStorageDir.mkdirs();
//                System.out.println("Edit text => ");
//            }
//            File mediaFile = new File(mediaStorageDir ,fileName + ".csv" );
////                                out = openFileOutput(fileName, getApplicationContext().MODE_PRIVATE);
////                                out.write(content.getBytes());
////                                out.close();
//            out = new FileOutputStream(mediaFile);
//            out.write(content.getBytes());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (out != null) {
//                    out.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

//        editText = (EditText) findViewById(R.id.edit);
//
//        Calendar c = Calendar.getInstance();

//        try {
//            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//            Date date = df.parse("2017-09-30");
//            SimpleDateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
//            String formattedDate = df1.format(date);
//            System.out.println("Current time => " +formattedDate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

//        editText.setText("");
//        System.out.println("Edit text => " +editText.getText().length());

//         myCalendar = Calendar.getInstance();
//
//        editText.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                //To show current date in the datepicker
//                Calendar mcurrentDate=Calendar.getInstance();
//                mYear=mcurrentDate.get(Calendar.YEAR);
//                mMonth=mcurrentDate.get(Calendar.MONTH);
//                mDay=mcurrentDate.get(Calendar.DAY_OF_MONTH);
//
//                DatePickerDialog mDatePicker=new DatePickerDialog(getApplicationContext(), new DatePickerDialog.OnDateSetListener() {
//                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
//                    }
//                },mYear, mMonth, mDay);
//                mDatePicker.setTitle("Select date");
//                mDatePicker.show();  }
//        });

    }

    private void updateLabel() {

        String myFormat = "MM/dd/yy"; //In which you need put here
       // SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        //edittext.setText(sdf.format(myCalendar.getTime()));
    }

//    public void second(View view){
//        Intent intent = new Intent();
//        intent.setClass(MainActivity.this,Main2Activity.class);
//        startActivity(intent);
//    }

    @Override
    protected void onStart() {
        super.onStart();


//        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
//        mwWakeLock = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK,"MainActivity");
//        mwWakeLock.acquire();
        System.out.println("onStart  method id called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("onResume  method id called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("onPause  method id called");
    }

    @Override
    protected void onStop() {
        super.onStop();
//        if(mwWakeLock.isHeld()) {
//            mwWakeLock.release();
            System.out.println("onStop  method id called");
//        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy  method id called");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("onRestart  method id called");
    }

    @Override
    public void touch() {

        FragmentManager manager = getSupportFragmentManager();
        FragmentOne menuFragment = new FragmentOne();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.activity_main,menuFragment,"bbb");
        transaction.addToBackStack("aaa");
        transaction.commit();
    }

    public void click1(View view){
        System.out.println("click1  MainActivity method id called");
//        Intent calendarIntent = new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);
//        Calendar beginTime = Calendar.getInstance();
//        beginTime.set(2012, 0, 19, 7, 30);
//        Calendar endTime = Calendar.getInstance();
//        endTime.set(2012, 0, 19, 10, 30);
//        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis());
//        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis());
//        calendarIntent.putExtra(CalendarContract.Events.TITLE, "Ninja class");
//        calendarIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Secret dojo");
//        startActivity(calendarIntent);
//        Uri location = Uri.parse("https://www.facebook.com");
//        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
//
//// Verify it resolves
//        PackageManager packageManager = getPackageManager();
//        List<ResolveInfo> activities = packageManager.queryIntentActivities(mapIntent, PackageManager.MATCH_DEFAULT_ONLY);
//        boolean isIntentSafe = activities.size() > 0;
//
//// Start an activity if it's safe
//        if (isIntentSafe) {
//            startActivity(mapIntent);
//        }


    }

//    @Override
//    public void onBackPressed() {
//        CustomDialogClass cdd=new CustomDialogClass(MainActivity.this);
//        cdd.show();
//        thread = new Thread(this);
//        thread.start();
////        AlertDialog.Builder b = new AlertDialog.Builder(this);
////        b.setTitle("Write on NFC Tag");
////        b.setMessage("Approach an NFC Tag");
////        b.setIcon(R.drawable.icon);
////        b.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
////            @Override
////            public void onClick(DialogInterface dialogInterface, int i) {
////                dialogInterface.dismiss();
////            }
////        });
////        b.show();
//    }

    @Override
    public void run() {
        while(true){
            System.out.println("Thread of matloob");
            if(a == 1) {
                Message message = Message.obtain();
                message.obj = 1;
                CustomDialogClass.handler.sendMessage(message);
                System.out.println("Thread of matloob  111");
//                button.setBackgroundResource(R.drawable.vol_one);
                try {
                    thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                a=2;
            }else if(a == 2){
                Message message = Message.obtain();
                message.obj = 2;
                CustomDialogClass.handler.sendMessage(message);
//                button.setBackgroundResource(R.drawable.vol_two);
                try {
                    thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                a=3;
            }else if(a == 3){
                Message message = Message.obtain();
                message.obj = 3;
                CustomDialogClass.handler.sendMessage(message);
//                button.setBackgroundResource(R.drawable.vol_three);
                try {
                    thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                a=1;
            }
        }
    }
}
