package com.susancagle.simpleasynctask;

import android.os.AsyncTask;
//import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask <Void, Integer, String>{
    private WeakReference<TextView> mTextView;
  //  private WeakReference<ProgressBar> mProgressBar;

        SimpleAsyncTask(TextView tv) {
            mTextView = new WeakReference<>(tv);
        }
    //    SimpleAsyncTask(ProgressBar pb) {
      //      mProgressBar = new WeakReference<>(pb);
        //}

        @Override
        protected String doInBackground(Void... voids) {

            // Generate a random number between 0 and 10
            Random r = new Random();
            int n = r.nextInt(11);
            // Make the task take long enough that we have time to rotate the phone while it is running
            int s = n * 200;

                try {
                    Thread.sleep(s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            // Sleep for the random amount of time


            return "Awake at last after sleeping for " + s + "milliseconds!";
        }

 /*   @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mProgressBar.setMax(100);
    }

    @Override
    protected void onProgressUpdate(Integer...progress) {
        super.onProgressUpdate(progress);
        mProgressBar.get()
      //  mProgressBar.setProgress(progress[0]);
    }
*/
        protected void onPostExecute(String result) {
            mTextView.get().setText(result);
        }
    }

