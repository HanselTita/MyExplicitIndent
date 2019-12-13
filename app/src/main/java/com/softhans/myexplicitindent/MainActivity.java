package com.softhans.myexplicitindent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.LogPrinter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    TextView mTextView, texviewR;
    EditText mEditText;
    Button mButton;
    public static final String EXTRA_MESSAGE ="com.softhans.myexplicitindent.extra.MESSAGE";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText =findViewById(R.id.textView);
        mButton =findViewById(R.id.button1);
        mTextView =findViewById(R.id.messagetv);
        texviewR =findViewById(R.id.text_message);



        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");

        Intent intent = getIntent();
        String message = intent.getStringExtra(SecondActivity.EXTRA_REPLY);
        texviewR.setText(message);


        if(texviewR.getText() != "")
        {
            mButton.setText(R.string.reply_message);
            mTextView.setVisibility(View.VISIBLE);
        }

// Restore the saved state.
        // See onSaveInstanceState() for what gets saved.
        if (savedInstanceState != null) {
            boolean isVisible =
                    savedInstanceState.getBoolean("reply_visible");
            // Show both the header and the message views. If isVisible is
            // false or missing from the bundle, use the default layout.
            if (isVisible) {
                texviewR.setVisibility(View.VISIBLE);
                mTextView.setText(savedInstanceState
                        .getString("reply_text"));
                mTextView.setVisibility(View.VISIBLE);
            }
        }




    }




    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d(LOG_TAG, "onResume");
    }

    public void launchSecondActivity(View view) {

        Log.d (LOG_TAG, "Button clicked");

        Intent intent = new Intent(this, SecondActivity.class);
        String message = mEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    //TODO see if you can adapt a screen to have both activities see each their chats like messaging apps.
}


