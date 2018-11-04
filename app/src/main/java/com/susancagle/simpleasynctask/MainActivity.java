package com.susancagle.simpleasynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
//import android.widget.ProgressBar;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    // The TextView where we will show results
    private TextView mTextView;
  //  ProgressBar mProgressBar;

    // Constant for the key for the current text in the state bundle
    private static final String TEXT_STATE = "currentText";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textView1);
     //   mProgressBar = findViewById(R.id.determinateBar);

        // Restore TextView if there is a savedInstanceState
        if(savedInstanceState!=null){
            mTextView.setText(savedInstanceState.getString(TEXT_STATE));
        }
    }

    public void startTask(View view) {
        // Put a message in the text view
        mTextView.setText(R.string.napping);
        new SimpleAsyncTask(mTextView).execute();


    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save the state of the TextView
        outState.putString(TEXT_STATE, mTextView.getText().toString());
    }


}
