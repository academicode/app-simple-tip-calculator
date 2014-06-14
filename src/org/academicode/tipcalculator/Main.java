package org.academicode.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Main extends Activity implements OnClickListener{

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
		
		// Calculate the tip
		
		// Pass tip information to result Activity.
		
		// Launch the result Activity.
	}
}
