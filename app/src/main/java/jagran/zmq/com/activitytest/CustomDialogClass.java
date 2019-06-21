package jagran.zmq.com.activitytest;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by zmq181 on 31/8/17.
 */

public class CustomDialogClass extends Dialog implements View.OnClickListener {

    public Activity c;
    public Dialog d;
    public Button yes, no;
    ImageButton button;
    public static Handler handler;


    public CustomDialogClass(Activity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog);
//        yes = (Button) findViewById(R.id.btn_yes);
        no = (Button) findViewById(R.id.btn_no);
        button = (ImageButton) findViewById(R.id.aaaa);
//        yes.setOnClickListener(this);
        no.setOnClickListener(this);


        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                int i = (int)msg.obj;
                if(i==1){
                    button.setBackgroundResource(R.drawable.vol_one);
                }else if(i==2){
                    button.setBackgroundResource(R.drawable.vol_two);
                }else if(i==3){
                    button.setBackgroundResource(R.drawable.vol_three);
                }
            }
        };


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.btn_yes:
//                c.finish();
//                break;
            case R.id.btn_no:
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }

}