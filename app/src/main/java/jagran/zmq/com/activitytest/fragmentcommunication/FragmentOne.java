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
import java.util.Arrays;

import jagran.zmq.com.activitytest.R;

/**
 * Created by zmq181 on 8/8/17.
 */

public class FragmentOne extends Fragment{

    private ListView lv;
    private EditText et;
    private Button btn;
    private FragmentOneInterf interf;
    private ArrayList<String> arrayList = new ArrayList<>();
    private ArrayAdapter adapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        System.out.println("onAttach  FragmentOne method called");
        interf = (FragmentOneInterf) getActivity();
    }
    

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("onCreate  FragmentOne method called");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        System.out.println("onCreateView  FragmentOne method called");
        return inflater.inflate(R.layout.activity_main_b,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("onActivityCreated  FragmentOne method called");
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        System.out.println("onViewCreated  FragmentOne method called");
        lv = (ListView) view.findViewById(R.id.fragment_one_text);
        adapter = new ArrayAdapter(getActivity(),R.layout.support_simple_spinner_dropdown_item,arrayList);
        lv.setAdapter(adapter);
        et = (EditText) view.findViewById(R.id.fragment_one_edit);
        btn = (Button) view.findViewById(R.id.fragment_one_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interf.setData(et.getText().toString());
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        System.out.println("onStart  FragmentOne method called");
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("onResume  FragmentOne method called");
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("onPause  FragmentOne method called");
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("onStop  FragmentOne method called");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println("onDestroyView  FragmentOne method called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy  FragmentOne method called");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        System.out.println("onDetach  FragmentOne method called");
    }

    public void setText(String s){
        arrayList.add(s);
        adapter.notifyDataSetChanged();
    }

    public interface FragmentOneInterf{
        void setData(String s);
    }

}
