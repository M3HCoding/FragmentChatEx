package dev.zmq.fragmentchat;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class FragmentTwo extends Fragment implements View.OnClickListener
{
    private List<String> data2;
    private ArrayAdapter<String> adapter2;
    private View view;
    private ListView listView_two_mag;
    private EditText editText_two_msg;
    private Button button_two_msg;
    FragmentOne fragmentOne;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        view=inflater.inflate( R.layout.fragment_two,container,false );
        editText_two_msg=(EditText)view.findViewById( R.id.editText_two );
        button_two_msg=(Button)view.findViewById( R.id.btn_two );
        button_two_msg.setOnClickListener( this );

        if(getArguments() != null)
        {
            data2=new ArrayList<>();
            listView_two_mag=(ListView)view.findViewById( R.id.listView_two );
            adapter2=new ArrayAdapter<>(getActivity(), R.layout.simple_item_list_2,data2);
            listView_two_mag.setAdapter( adapter2 );
            String msg_two_listView = getArguments().getString( "One_msg" );
            data2.add( msg_two_listView );
            adapter2.notifyDataSetChanged();
        }

        return  view;
    }
    @Override
    public void onClick(View v)
    {
        String msg_two=editText_two_msg.getText().toString();
        Bundle bundle_two=new Bundle(  );
        bundle_two.putString( "Two_msg",msg_two );
        fragmentOne=new FragmentOne();
        fragmentOne.setArguments( bundle_two );
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace( R.id.frameLayoutContainerOne,fragmentOne);
        fragmentTransaction.addToBackStack( null).commit();
    }

}
