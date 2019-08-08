package jagran.zmq.com.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;

import java.util.ArrayList;

public class DemoActivity extends Activity implements RecognitionListener {

    SpeechRecognizer speech;
    Intent recognizerIntent;
    Camera camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        speech = SpeechRecognizer.createSpeechRecognizer(getApplicationContext());
        speech.setRecognitionListener(this);
        recognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
//        recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE,en);
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getApplicationContext().getPackageName());
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 3);
        speech.startListening(recognizerIntent);
    }

    @Override
    public void onReadyForSpeech(Bundle bundle) {
        System.out.println(" result  onReadyForSpeech");

    }

    @Override
    public void onBeginningOfSpeech() {
        System.out.println(" result  onBeginningOfSpeech");

    }

    @Override
    public void onRmsChanged(float v) {
        System.out.println(" result  onRmsChanged");

    }

    @Override
    public void onBufferReceived(byte[] bytes) {
        System.out.println(" result  onBufferReceived");

    }

    @Override
    public void onEndOfSpeech() {
        System.out.println(" result  onEndOfSpeech");

    }

    @Override
    public void onError(int i) {
        System.out.println(" result  onError");
        Intent intent = getIntent();
        finish();
        startActivity(intent);
        switch (i) {
            case SpeechRecognizer.ERROR_AUDIO:
                //message = R.string.error_audio_error;
                break;
            case SpeechRecognizer.ERROR_CLIENT:
              //  message = R.string.error_client;
                break;
            case SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS:
             //   message = R.string.error_permission;
                break;
            case SpeechRecognizer.ERROR_NETWORK:
             //   message = R.string.error_network;
                break;
            case SpeechRecognizer.ERROR_NETWORK_TIMEOUT:
              //  message = R.string.error_timeout;
                break;
            case SpeechRecognizer.ERROR_NO_MATCH:
              //  message = R.string.error_no_match;
                break;
            case SpeechRecognizer.ERROR_RECOGNIZER_BUSY:
             //   message = R.string.error_busy;
                break;
            case SpeechRecognizer.ERROR_SERVER:
               // message = R.string.error_server;
                break;
            case SpeechRecognizer.ERROR_SPEECH_TIMEOUT:
              //  message = R.string.error_timeout;
                break;
            default:
                //message = R.string.error_understand;
                break;
        }
    }

    @Override
    public void onResults(Bundle bundle) {
        ArrayList<String> matches = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
        System.out.println(" result  = "+matches.get(0));
        if(matches.get(0).equalsIgnoreCase("on")){
            Camera camera = Camera.open();
            Camera.Parameters parameters = camera.getParameters();
            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            camera.setParameters(parameters);
            camera.startPreview();
        }

        if(matches.get(0).equalsIgnoreCase("of")||matches.get(0).equalsIgnoreCase("off")){
            try {
                Camera camera11 = Camera.open();
                Camera.Parameters parameters = camera11.getParameters();
                parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                camera11.setParameters(parameters);
                camera11.stopPreview();
                camera11.release();
            }
            catch (Exception e){
                System.out.println("Error in program = "+e.getMessage());
            }

        }


        speech = SpeechRecognizer.createSpeechRecognizer(getApplicationContext());
        speech.setRecognitionListener(this);
        recognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
//        recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE,en);
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getApplicationContext().getPackageName());
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 3);
        speech.startListening(recognizerIntent);
//        Intent intent = getIntent();
//        finish();
//        startActivity(intent);

    }

    @Override
    public void onPartialResults(Bundle bundle) {
        System.out.println(" result  onPartialResults");

    }

    @Override
    public void onEvent(int i, Bundle bundle) {
        System.out.println(" result  onEvent");

    }
}
