package jagran.zmq.com.activitytest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Locale;

public class Main2Activity extends Activity {

    PowerManager.WakeLock mwWakeLock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        System.out.println("onCreate Main2Activity  method id called");
    }


    @Override
    protected void onStart() {
        super.onStart();
        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        mwWakeLock = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK,"MainActivity");
        mwWakeLock.acquire();
        System.out.println("onStart Main2Activity  method id called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("onResume  Main2Activity method id called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("onPause  Main2Activity method id called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mwWakeLock.isHeld()) {
            mwWakeLock.release();
            System.out.println("onStop  Main2Activity method id called");
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy  Main2Activity method id called");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("onRestart  Main2Activity method id called");
    }

    public void onStartService(View view){
        Intent intent = new Intent(getBaseContext(),MyService.class);
        startService(intent);

    }


    public void onBindService(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
        builder.setTitle("select language");
        // Add the buttons
        builder.setPositiveButton("English", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                String languageToLoad = "en"; // your language
                Locale locale = new Locale(languageToLoad);
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());
                dialog.dismiss();


//                rEditor.putString("language", languageToLoad);
//                rEditor.commit();



                Intent refresh = new Intent(Main2Activity.this, Main2Activity.class);
                startActivity(refresh);
                finish();

            }
        });
        builder.setNegativeButton("Gujrati", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog

                String languageToLoad = "hi_IN"; // your language
                Locale locale = new Locale(languageToLoad);
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());
                dialog.dismiss();
//                rEditor.putString("language", languageToLoad);
//                rEditor.commit();


                Intent refresh = new Intent(Main2Activity.this, Main2Activity.class);
                startActivity(refresh);
                finish();

            }
        });

        builder.create().show();
//        Intent intent11 = new Intent(getBaseContext(),MySecondService.class);
//        startService(intent11);
    }

    public void onUnBindService(View view){
        Camera camera11 = Camera.open(2);
        Camera.Parameters parameters = camera11.getParameters();
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
        camera11.setParameters(parameters);
        camera11.stopPreview();
        camera11.release();
        Intent intent = new Intent(getBaseContext(),MyService.class);
//        unbindService(intent);
    }

    public void onStopService(View view){
        Intent intent = new Intent(getBaseContext(),MyService.class);
        stopService(intent);
    }


}
