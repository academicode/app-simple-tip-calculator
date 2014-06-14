package org.academicode.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Result extends Activity {

	private TextView tipTextView;
	private TextView totalTextView;
	
	private Button finished;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.result);
		
		tipTextView = (TextView) findViewById(R.id.tip);
		totalTextView = (TextView) findViewById(R.id.total);
		
		initializeTextViews();
		
		finished = (Button) findViewById(R.id.confirm);
		
		finished.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				finish();
			}
		});
	}
	
	private void initializeTextViews(){
		
		double tip = getIntent().getExtras().getDouble(Main.TAG_TIP);
		double total = getIntent().getExtras().getDouble(Main.TAG_GRAND_TOTAL);
		
		String currentTipText = tipTextView.getText().toString();
		
		currentTipText = currentTipText + "$" + tip;
		
		String currentTotalText = totalTextView.getText().toString();
		 
		currentTotalText = currentTotalText + "$" + total;
		
		tipTextView.setText(currentTipText);
		totalTextView.setText(currentTotalText);
	}
}
