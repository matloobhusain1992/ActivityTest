package jagran.zmq.com.activitytest;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.goodiebag.pinview.Pinview;

public class MpinActivity extends AppCompatActivity implements View.OnTouchListener {

    RelativeLayout one,two,three,four,five,six,seven,eight,nine,zero,cancel;
    ImageView circle1,circle2,circle3,circle4;
    int count = 0;
    String pin = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpin);

        one = (RelativeLayout) findViewById(R.id.one2);
        two = (RelativeLayout) findViewById(R.id.two2);
        three = (RelativeLayout) findViewById(R.id.three2);
        four = (RelativeLayout) findViewById(R.id.four2);
        five = (RelativeLayout) findViewById(R.id.five2);
        six = (RelativeLayout) findViewById(R.id.six2);
        seven = (RelativeLayout) findViewById(R.id.seven2);
        eight = (RelativeLayout) findViewById(R.id.eight2);
        nine = (RelativeLayout) findViewById(R.id.nine2);
        zero = (RelativeLayout) findViewById(R.id.zero2);
        cancel = (RelativeLayout) findViewById(R.id.cancel2);
        one.setOnTouchListener(this);
        two.setOnTouchListener(this);
        three.setOnTouchListener(this);
        four.setOnTouchListener(this);
        five.setOnTouchListener(this);
        six.setOnTouchListener(this);
        seven.setOnTouchListener(this);
        eight.setOnTouchListener(this);
        nine.setOnTouchListener(this);
        zero.setOnTouchListener(this);
        cancel.setOnTouchListener(this);

        circle1 = (ImageView) findViewById(R.id.imageview_circle1);
        circle2 = (ImageView) findViewById(R.id.imageview_circle2);
        circle3 = (ImageView) findViewById(R.id.imageview_circle3);
        circle4 = (ImageView) findViewById(R.id.imageview_circle4);


    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // PRESSED
                v.setBackground(getDrawable(R.drawable.circle));
                return true; // if you want to handle the touch event
            case MotionEvent.ACTION_UP:
                // RELEASED
                v.setBackground(getDrawable(R.drawable.selection));
                System.out.println("Button id = "+v.getId());
                int id = v.getId();
                switch (id){
                    case R.id.one2:
                        if(count<4) {
                            count++;
                            pin = pin+"1";
                        }
                        break;
                    case R.id.two2:
                        if(count<4) {
                            count++;
                            pin = pin+"2";
                        }
                        break;
                    case R.id.three2:
                        if(count<4) {
                            count++;
                            pin = pin+"3";
                        }
                        break;
                    case R.id.four2:
                        if(count<4) {
                            count++;
                            pin = pin+"4";
                        }
                        break;
                    case R.id.five2:
                        if(count<4) {
                            count++;
                            pin = pin+"5";
                        }
                        break;
                    case R.id.six2:
                        if(count<4) {
                            count++;
                            pin = pin+"6";
                        }
                        break;
                    case R.id.seven2:
                        if(count<4) {
                            count++;
                            pin = pin+"7";
                        }
                        break;
                    case R.id.eight2:
                        if(count<4) {
                            count++;
                            pin = pin+"8";
                        }
                        break;
                    case R.id.nine2:
                        if(count<4) {
                            count++;
                            pin = pin+"9";
                        }
                        break;
                    case R.id.zero2:
                        if(count<4) {
                            count++;
                            pin = pin+"0";
                        }
                        break;
                    case R.id.cancel2:
                        if(count>0)
                        count--;

                        break;
                    default:
                        break;

                }
                if(count==0){
                    circle1.setBackground(getDrawable(R.drawable.circle_blank));
                    circle2.setBackground(getDrawable(R.drawable.circle_blank));
                    circle3.setBackground(getDrawable(R.drawable.circle_blank));
                    circle4.setBackground(getDrawable(R.drawable.circle_blank));
                }
                if(count==1){
                    circle1.setBackground(getDrawable(R.drawable.circle));
                    circle2.setBackground(getDrawable(R.drawable.circle_blank));
                    circle3.setBackground(getDrawable(R.drawable.circle_blank));
                    circle4.setBackground(getDrawable(R.drawable.circle_blank));
                }else if(count==2){
                    circle1.setBackground(getDrawable(R.drawable.circle));
                    circle2.setBackground(getDrawable(R.drawable.circle));
                    circle3.setBackground(getDrawable(R.drawable.circle_blank));
                    circle4.setBackground(getDrawable(R.drawable.circle_blank));
                }else if(count==3){
                    circle1.setBackground(getDrawable(R.drawable.circle));
                    circle2.setBackground(getDrawable(R.drawable.circle));
                    circle3.setBackground(getDrawable(R.drawable.circle));
                    circle4.setBackground(getDrawable(R.drawable.circle_blank));

                }else if(count==4){
                    circle1.setBackground(getDrawable(R.drawable.circle));
                    circle2.setBackground(getDrawable(R.drawable.circle));
                    circle3.setBackground(getDrawable(R.drawable.circle));
                    circle4.setBackground(getDrawable(R.drawable.circle));

                    if(pin.equals("1092")){
                        Toast.makeText(getApplicationContext(),"Your Pin is Correct",Toast.LENGTH_SHORT).show();
                        pin="";
                    }else{
                        Toast.makeText(getApplicationContext(),"Your Pin is Incorrect",Toast.LENGTH_SHORT).show();
                        pin="";
                        count=0;
                        circle1.setBackground(getDrawable(R.drawable.circle_blank));
                        circle2.setBackground(getDrawable(R.drawable.circle_blank));
                        circle3.setBackground(getDrawable(R.drawable.circle_blank));
                        circle4.setBackground(getDrawable(R.drawable.circle_blank));
                    }


                }
                return true; // if you want to handle the touch event
        }
        return false;
    }
}
