package cn.edu.gdmec.s07131038.servicethreaddemo;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	Button myBtn1,myBtn2;
	static TextView myTv;
	Intent myIt=new Intent("cn.edu.gdmec.s07131038.service");
	static Handler myHandler=new Handler();
	
	private static double randomDouble;
	
	private static Runnable Refreshlabel=new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			myTv.setText(String.valueOf(randomDouble));
		}
	};
	
	public static void UpdateGUI(double refreshDouble){
		randomDouble=refreshDouble;
		myHandler.post(Refreshlabel);
	}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myBtn1=(Button) findViewById(R.id.button1);
        myBtn2=(Button) findViewById(R.id.button2);
        myTv=(TextView) findViewById(R.id.textView1);
        myBtn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startService(myIt);
			}
		});
        myBtn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				stopService(myIt);
			}
		});
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
