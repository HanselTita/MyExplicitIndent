package com.softhans.myexplicitindent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView receivedTV;
    EditText mEditText2;
    Button mButton;
    public static final String EXTRA_REPLY =
            "com.softhans.myexplicitindent.extra.REPLY";

    private static final String LOG_TAG = SecondActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mEditText2 = findViewById(R.id.message2);
        receivedTV = findViewById(R.id.text_message);
        mButton = findViewById(R.id.button2);

        if(mButton.getText() != "")
        {
           mButton.setText(R.string.reply_message);
        }

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        receivedTV.setText(message);
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



    public void sendReply(View view) {

        Log.d(LOG_TAG, "Button2 clicked");

        String message = mEditText2.getText().toString();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(EXTRA_REPLY, message);
         startActivity(intent);
        finish();
    }
}
