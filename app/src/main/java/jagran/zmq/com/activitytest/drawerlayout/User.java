package jagran.zmq.com.activitytest.drawerlayout;

import android.databinding.BaseObservable;
import android.databinding.Bindable;


import java.io.Serializable;

import jagran.zmq.com.activitytest.BR;

/**
 * Created by zmq181 on 27/6/19.
 */

public class User extends BaseObservable{

    private String name;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }
}
