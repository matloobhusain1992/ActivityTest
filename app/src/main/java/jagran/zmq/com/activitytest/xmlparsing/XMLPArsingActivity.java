package jagran.zmq.com.activitytest.xmlparsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Xml;

import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import jagran.zmq.com.activitytest.R;

public class XMLPArsingActivity extends AppCompatActivity {
    int a;

    private List<Employee> employeeList;
    private Employee employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xmlparsing);
        InputStream in = getResources().openRawResource(R.raw.eployee);
        parsing(in);
        System.out.println(employeeList);
    }

    private void parsing(InputStream in) {
        XmlPullParser xmlPullParser;
        try {
            XmlPullParserFactory xmlPullParserFactory = XmlPullParserFactory.newInstance();
            xmlPullParser = xmlPullParserFactory.newPullParser();
            xmlPullParser.setInput(in, null);
            String text="";
            while (xmlPullParser.getEventType() != XmlPullParser.END_DOCUMENT) {

                switch (xmlPullParser.getEventType()) {
                    case XmlPullParser.START_DOCUMENT:
                        System.out.println("START_DOCUMENT");
                    case XmlPullParser.START_TAG:
                        String name = xmlPullParser.getName();
                        if ("Employees".equalsIgnoreCase(name)) {
                            employeeList = new ArrayList<>();
                        } else if ("Employee".equalsIgnoreCase(name)) {
                            employee = new Employee();
                        }
                        //System.out.println("START_TAG " + name);
                        break;

                    case XmlPullParser.TEXT:
                        text = xmlPullParser.getText();
                        //System.out.println("TEXT " + text);
                        break;
                    case XmlPullParser.END_TAG:
                        name = xmlPullParser.getName();
                        if("name".equalsIgnoreCase(name)){
                            employee.setName(text);
                        }else if("age".equalsIgnoreCase(name)){
                            employee.setAge(Integer.valueOf(text));
                        }else if("role".equalsIgnoreCase(name)){
                            employee.setRole(text);
                        }else if("gender".equalsIgnoreCase(name)){
                            employee.setGender(text);
                        }else if("Employee".equalsIgnoreCase(name)){
                            employeeList.add(employee);
                        }
                        //System.out.println("END_TAG " + name);
                        break;
                }
                xmlPullParser.next();
            }
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }
    }
}
