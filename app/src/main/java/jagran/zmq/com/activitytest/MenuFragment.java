package jagran.zmq.com.activitytest;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by zmq181 on 6/6/17.
 */

public class MenuFragment extends Fragment {

Communicator communicator;
    public void setCommunicator(Communicator communicator){
        this.communicator = communicator;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        System.out.println("onAttach  MenuFragment method called");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("onCreate  MenuFragment method called");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        System.out.println("onCreateView  MenuFragment method called");
        return inflater.inflate(R.layout.activity_main_a,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("onActivityCreated  MenuFragment method called");
        Button button = (Button) getActivity().findViewById(R.id.buttonPanel);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
communicator.touch();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        System.out.println("onStart  MenuFragment method called");
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("onResume  MenuFragment method called");
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("onPause  MenuFragment method called");
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("onStop  MenuFragment method called");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println("onDestroyView  MenuFragment method called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy  MenuFragment method called");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        System.out.println("onDetach  MenuFragment method called");
    }

    public interface Communicator{
        public void touch();
    }
}
