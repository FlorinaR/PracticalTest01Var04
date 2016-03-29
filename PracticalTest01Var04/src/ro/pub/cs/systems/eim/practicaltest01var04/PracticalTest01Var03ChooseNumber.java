package ro.pub.cs.systems.eim.practicaltest01var04;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class PracticalTest01Var03ChooseNumber extends Activity {
	private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;
	
	private Button playButton = null;
	private EditText numberEditText = null;
	
	private ButtonClickListener buttonClickListener = new ButtonClickListener();
	  private class ButtonClickListener implements View.OnClickListener {
	    @Override
	    public void onClick(View view) {
	      switch(view.getId()) {
	        case R.id.play_button:
	          Intent intent = new Intent(getApplicationContext(), PracticalTest01Var02PlayActivity.class);
	          intent.putExtra("number", numberEditText.getText().toString());
	          startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
	          break;
	      }
	    }
	  }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_choose_number);
        
        playButton = (Button)findViewById(R.id.play_button);
        numberEditText = (EditText)findViewById(R.id.number_edittext);
        
      
        numberEditText.setText(String.valueOf(0));
        
        playButton.setOnClickListener(buttonClickListener);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.practical_test01_var03_choose_number, menu);
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
}
