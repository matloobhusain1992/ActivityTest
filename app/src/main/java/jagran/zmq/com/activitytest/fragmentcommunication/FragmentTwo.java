package jagran.zmq.com.activitytest.fragmentcommunication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import jagran.zmq.com.activitytest.R;

/**
 * Created by zmq181 on 8/8/17.
 */

public class FragmentTwo extends Fragment{

    private ListView lv;
    private EditText et;
    private Button btn;
    private FragmentTwoInterf interf;
    private ArrayList<String> arrayList = new ArrayList<>();
    private ArrayAdapter adapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        System.out.println("onAttach  FragmentTwo method called");
        interf = (FragmentTwoInterf) getActivity();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("onCreate  FragmentTwo method called");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        System.out.println("onCreateView  FragmentTwo method called");
        return inflater.inflate(R.layout.activity_main_a,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        System.out.println("onViewCreated  FragmentTwo method called");
        lv = (ListView) view.findViewById(R.id.fragment_two_text);
        adapter = new ArrayAdapter(getActivity(),R.layout.support_simple_spinner_dropdown_item,arrayList);
        lv.setAdapter(adapter);
        et = (EditText) view.findViewById(R.id.fragment_two_edit);
        btn = (Button) view.findViewById(R.id.fragment_two_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interf.setDataSecond(et.getText().toString());
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("onActivityCreated  FragmentTwo method called");
    }

    @Override
    public void onStart() {
        super.onStart();
        System.out.println("onStart  FragmentTwo method called");
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("onResume  FragmentTwo method called");
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("onPause  FragmentTwo method called");
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("onStop  FragmentTwo method called");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println("onDestroyView  FragmentTwo method called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy  FragmentTwo method called");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        System.out.println("onDetach  FragmentTwo method called");
    }

    public void setText(String s){
        arrayList.add(s);
        adapter.notifyDataSetChanged();
    }

    public interface FragmentTwoInterf{
        void setDataSecond(String s);
    }
}
