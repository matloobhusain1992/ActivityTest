package jagran.zmq.com.activitytest;


//import android.app.Activity;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.graphics.RectF;
//import android.os.Bundle;
//import android.view.SurfaceHolder;
//import android.view.SurfaceView;
//import android.view.Window;
//import android.view.WindowManager;
//
//public class StringSizeActivity
//        extends Activity
//        implements SurfaceHolder.Callback
//{
//    /** Activity is created */
//    @Override
//    public void onCreate( Bundle state )
//    {
//        super.onCreate( state );
//
//        SurfaceView v = new SurfaceView( this );
//        SurfaceHolder h = v.getHolder();
//        h.addCallback( this );
//
//        requestWindowFeature( Window.FEATURE_NO_TITLE );
//        setContentView( v );
//        getWindow().addFlags(
//                WindowManager.LayoutParams.FLAG_FULLSCREEN );
//    }
//
//    /** Surface changed */
//    public void surfaceChanged(
//            SurfaceHolder holder,
//            int format,
//            int width,
//            int height )
//    {
//    }
//
//    /** Surface created */
//    public void surfaceCreated( SurfaceHolder holder )
//    {
//        if( holder == null )
//            return;
//
//        Canvas c = null;
//
//        try
//        {
//            if( (c = holder.lockCanvas()) != null )
//                drawBubbles( c );
//        }
//        finally
//        {
//            if( c != null )
//                holder.unlockCanvasAndPost( c );
//        }
//    }
//
//    /** Surface destroyed */
//    public void surfaceDestroyed( SurfaceHolder holder )
//    {
//    }
//
//    /** Draw bubbles */
//    private void drawBubbles( final Canvas c )
//    {
//        final String texts[] = new String[]{
//                "Hi there, I'm a blue bubble.",
//                "Me too!",
//                "There are a lot of bubbles around here. And all of them are blue.",
//                "And now for something compeletly different. According to en.wikipedia.org, the origin of this phrase \" is credited to Christopher Trace, founding presenter of the children's television programme Blue Peter, who used it (in all seriousness) as a link between segments\". Interesting, isn't it?",
//                "Lorem ipsum is so boring.",
//                "Draw text in a given rectangle and automatically wrap lines.",
//                "This class is designed to be used in games and therefore tries to minimize allocations after instantiation because those will trigger the GC more often which causes a slight but noticeable delay.",
//                "So, if you want to use this in a game, you should make the instance a class member, allocate it once and reuse it.",
//
//        };
//        final int cells = (int) Math.ceil( Math.sqrt( texts.length ) );
//        final int margin = 8;
//        final int totalMargin = (cells + 1) * margin;
//        final int w = (c.getWidth() - totalMargin) / cells;
//        final int h = (c.getHeight() - totalMargin) / cells;
//
//        for( int n = 0, l = texts.length, x = margin, y = margin;
//             n < l; )
//        {
//            drawBubble(
//                    c,
//                    x,
//                    y,
//                    w,
//                    h,
//                    texts[n] );
//
//            if( ++n % cells == 0 )
//            {
//                x = margin;
//                y += h + margin;
//            }
//            else
//                x += w + margin;
//        }
//    }
//
//    /** Draw a text bubble */
//    private void drawBubble(
//            final Canvas c,
//            final int x,
//            final int y,
//            final int width,
//            final int height,
//            final String text )
//    {
//        final TextRect textRect;
//
//        // set up font
//        {
//            final Paint fontPaint = new Paint();
//            fontPaint.setColor( Color.WHITE );
//            fontPaint.setAntiAlias( true );
//            fontPaint.setTextSize( 30 );
//
//            textRect = new TextRect( fontPaint );
//        }
//
//        final int h = textRect.prepare(
//                text,
//                width - 8,
//                height - 8 );
//
//        // draw bubble
//        {
//            final Paint p = new Paint();
//            p.setColor( Color.BLUE );
//            p.setStyle( Paint.Style.FILL );
//            p.setAntiAlias( true );
//
//            c.drawRoundRect(
//                    new RectF( x, y, x + width, y + h + 8 ),
//                    4,
//                    4,
//                    p );
//        }
//
//        textRect.draw( c, x + 4, y + 4 );
//    }
//}

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class StringSizeActivity extends AppCompatActivity {
    public static final String TAG = "StringSizeActivity";
//    char matter[] = {'अ','आ','इ','ई','उ','ऊ','ऋ','ए','ऐ','ऑ','ओ','औ','क','ख','ग','घ','च','छ','ज','झ','ञ','ट','ठ','ड',
//    'ढ','ण','त','थ','द','ध','न','प','फ','ब','भ','म','य','र','ल','व','श','ष','स','ह'};
//    String latter = "दीपावली, भारत में हिन्दुओं द्वारा मनाया जाने वाला सबसे बड़ा त्योहार है। दीपों का खास पर्व होने के कारण इसे दीपावली या दिवाली नाम दिया गया। दीपावली का मतलब होता है, दीपों की अवली यानि पंक्ति। इस प्रकार दीपों की पंक्तियों से सुसज्ज इस त्योहार को दीपावली कहा जाता है। कार्तिक माह की अमावस्या को मनाया जाने वाला यह महापर्व, अंधेरी रात को असंख्य दीपों की रौशनी से प्रकाशमय कर देता है";
//    String latter = "दीप जलाने की प्रथा के पीछे अलग-अलग कारण या कहानियां हैं। हिंदू मान्यताओं में राम भक्तों के अनुसार कार्तिक अमावस्या को भगवान श्री रामचंद्रजी चौदह वर्ष का वनवास काटकर तथा असुरी वृत्तियों के प्रतीक रावणादि का संहार करके अयोध्या लौटे थे";
//    String latter = "We have provided short paragraphs on Diwali festival in order to help students as they generally get assigned to write some paragraphs in the classroom. All the paragraphs are written using very simple words under various words limits according to the need and requirement of the students. Paragraph writing competition is generally organized by the class teacher anytime in order to check student’s skill and knowledge about the subject";
//    String latter = "Houses get decorated using real or artificial flowers and other decorative materials. Everywhere looks very dazzling because of the lighting small earthen lamps and electric bulbs. It is considered that Goddess Lakshmi makes a visit to each houses in the night of Diwali that’s why everyone lights their houses to welcome the Goddess. In return, Goddess gives her blessings to her devotees for healthy and prosperous life. At this day, everyone performs puja of Goddess Lakshmi and God Ganesha and then distributes gifts and sweets to their friends, neighbors and relatives";
    String latter = "त";
    Paint paint;
    Rect bound;
    int matterHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string_size);
//        char a[] = latter.toCharArray();
//        paint = new Paint();
//        paint.setTextSize(46);
//        bound = new Rect();
////        for(int i =0;i<matter.length;i++){
////            paint.getTextBounds(matter, i, 1, bound);
////            matterHeight = bound.height();
////            Log.d(TAG,"Size = "+matter[i]+"  "+matterHeight);
////        }
////        for(int i =0;i<a.length;i++){
////            paint.getTextBounds(a, i, 1, bound);
////            matterHeight = bound.height();
////            Log.d(TAG,"Size = "+a[i]+"  "+matterHeight);
////        }
//        paint.getTextBounds(latter, 0, latter.length(), bound);
//        matterHeight = bound.height();
//        Log.d(TAG,"Size = "+matterHeight+"    "+bound.width());


        WifiManager wifiManager = (WifiManager)(getSystemService(Context.WIFI_SERVICE));
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        if(wifiInfo != null){
//            Integer speed = wifiInfo.getLinkSpeed();
//
//            Toast toast = new Toast(this);
//            toast.setDuration(Toast.LENGTH_LONG);
//            toast.setGravity(Gravity.CENTER_HORIZONTAL,0,0);
//            LayoutInflater inflater = getLayoutInflater();
////            View view = inflater.inflate(,(ViewGroup)(findViewById(R.id.lll)));
//            toast.setView(view);
//            toast.show();

            //Toast.makeText(getApplicationContext(),"Speed = "+speed,Toast.LENGTH_LONG).show();
        }

    }
}
