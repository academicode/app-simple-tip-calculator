package org.academicode.tipcalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main extends Activity implements OnClickListener{

	private static final String TAG_DEBUG = Main.class.getName();
	
	public static final String TAG_TIP = "tag";
	public static final String TAG_GRAND_TOTAL = "total";
	
	private EditText et;
	
	private Button button10;
	private Button button15;
	private Button button20;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main);
		
		et = (EditText) findViewById(R.id.editText1);
		
		button10 = (Button) findViewById(R.id.tip10);
		button15 = (Button) findViewById(R.id.tip15);
		button20 = (Button) findViewById(R.id.tip20);
		
		button10.setOnClickListener(this);
		button15.setOnClickListener(this);
		button20.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		
		double tipPercent = 0.0d;
		
		switch(v.getId()){
		
			case R.id.tip10 :{
				
				tipPercent = 0.10d;
				
				break;
			}
			case R.id.tip15 :{
				
				tipPercent = 0.15d;
				
				break;
			}
			case R.id.tip20 :{
				
				tipPercent = 0.20d;
				
				break;
			}
			default :{
				
				break;
			}
		}
		
		String text = et.getText().toString();
		
		if(text.equals("")){
			
			Toast.makeText(Main.this, getResources().getString(R.string.error_et), Toast.LENGTH_LONG).show();
			return;
		}
		
		launchResultActivity(Double.parseDouble(et.getText().toString()), tipPercent);
	}
	
	private void launchResultActivity(double total, double tipPercent){
		
		double tip = total * tipPercent;
		double grandTotal = total + tip;
		
		Intent resultActivity = new Intent(Main.this, Result.class);
		
		resultActivity.putExtra(TAG_TIP, tip);
		resultActivity.putExtra(TAG_GRAND_TOTAL, grandTotal);
		
		Log.d(TAG_DEBUG, "Tip: " + tip);
		Log.d(TAG_DEBUG, "Grand Total: " + grandTotal);
		
		startActivity(resultActivity);
	}
}
