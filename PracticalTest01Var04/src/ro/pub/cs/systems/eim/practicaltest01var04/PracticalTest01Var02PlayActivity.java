package ro.pub.cs.systems.eim.practicaltest01var04;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var02PlayActivity extends Activity {
	

	  private EditText guessEditText = null;
	  private EditText scoreEditText = null;
	  private Button checkButton = null;
	  private Button generateButton = null;
	  private Button backButton = null;

	 private ButtonClickListener buttonClickListener = new ButtonClickListener();
	private class ButtonClickListener implements View.OnClickListener {
		    @Override
		    public void onClick(View view) {
		      switch(view.getId()) {
		        case R.id.guess_edittext:
		    	    Intent intent = getIntent();
		    	    if (intent != null && intent.getExtras().containsKey("number")) {
		    	      int number = intent.getIntExtra("number", -1);
		    	      guessEditText.setText(String.valueOf(number));
		    	    }
		        	break;
		        case R.id.generate_button:
		        	Random rand = new Random();

		        	int  n = rand.nextInt(9) + 0;
		        	guessEditText.setText(String.valueOf(n));
		        	break;
		  
		      case R.id.check_button:
		    	  if(guessEditText.getText().toString().equals(generateButton.getText().toString())) {
		    		  int score = Integer.parseInt(scoreEditText.getText().toString());
		    		  score++;
		    		  scoreEditText.setText(String.valueOf(score));
		    	  }
		    	  break;
		      case R.id.back_button:
//		    	  onDestroy();
		    	  finish();
		    	  break;
		      }
		    }
		  }
	  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var02_play);
		
	    //gue= (TextView)findViewById(R.id.number_of_clicks_text_view);
	    
		
		guessEditText = (EditText)findViewById(R.id.guess_edittext);
	    scoreEditText = (EditText)findViewById(R.id.score_edittext);
	    guessEditText.setText(String.valueOf(0));
	    scoreEditText.setText(String.valueOf(0));
	    

	    
	 
	    checkButton = (Button)findViewById(R.id.check_button);
	    generateButton = (Button)findViewById(R.id.generate_button);
	    backButton = (Button)findViewById(R.id.back_button);
		
	    checkButton.setOnClickListener(buttonClickListener);
	   generateButton.setOnClickListener(buttonClickListener);
	   backButton.setOnClickListener(buttonClickListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_var02_play, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
}
