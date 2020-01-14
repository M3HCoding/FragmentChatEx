package dev.zmq.fragmentchat;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

public class MainActivity extends Activity
{
    FragmentOne fragmentOne;
    FragmentTwo fragmentTwo;


   FragmentManager fragmentManager=getFragmentManager();
   FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        fragmentOne=new FragmentOne();
        fragmentTransaction.replace( R.id.frameLayoutContainerOne,fragmentOne );
        fragmentTwo=new FragmentTwo();
        fragmentTransaction.replace( R.id.frameLayoutContainerTwo,fragmentTwo );
        fragmentTransaction.addToBackStack( null );
        fragmentTransaction.commit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode==KeyEvent.KEYCODE_BACK)
        {
            finish();
        }
        return super.onKeyDown( keyCode, event );
    }
}
