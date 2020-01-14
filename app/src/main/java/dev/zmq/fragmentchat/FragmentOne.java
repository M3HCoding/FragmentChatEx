package dev.zmq.fragmentchat;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class FragmentOne extends Fragment implements View.OnClickListener
{
     private List<String> data1;
     private  ArrayAdapter<String> adapter1;
     private ListView listView_one_msg;
     private EditText editText_one_msg;
     private Button button_one_msg;
     private View view;
        FragmentTwo fragmentTwo;
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach( activity );
        fragmentManager=getFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate( R.layout.fragment_one, container, false );
        editText_one_msg = (EditText) view.findViewById( R.id.editText_one );
        button_one_msg = (Button) view.findViewById( R.id.btn_one );
        button_one_msg.setOnClickListener( this );

        if (getArguments() != null) {
            data1 = new ArrayList<>();
            listView_one_msg = (ListView) view.findViewById( R.id.listView_one );
            adapter1 = new ArrayAdapter<String>( getActivity(), R.layout.simple_item_list_1, data1 );
            listView_one_msg.setAdapter( adapter1 );
            String msg_one_listView = getArguments().getString( "Two_msg" );
            data1.add( msg_one_listView );
            adapter1.notifyDataSetChanged();
        }

        return view;

    }

    @Override
    public void onClick(View v)
    {
        String msg_one=editText_one_msg.getText().toString();
        Bundle bundle_one=new Bundle(  );
        bundle_one.putString( "One_msg",msg_one );
        fragmentTwo=new FragmentTwo();
        fragmentTwo.setArguments( bundle_one );
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace( R.id.frameLayoutContainerTwo,fragmentTwo );
        fragmentTransaction.addToBackStack(null).commit();
    }
}
