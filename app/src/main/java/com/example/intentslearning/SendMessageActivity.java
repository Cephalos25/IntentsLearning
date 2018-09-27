package com.example.intentslearning;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendMessageActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.intentslearning.eiuflahe1";

    private EditText editTextMessage;
    private Button buttonSendMessage;
    private Button buttonShareMessage;

    ConstraintLayout bgelement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        wireWidgets();

        buttonSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get the text
                String message = editTextMessage.getText().toString();
                // create the intent
                Intent sendIntent = new Intent(SendMessageActivity.this, ReceiveMessageActivity.class);
                // package text to intent
                sendIntent.putExtra(EXTRA_MESSAGE, message);
                // start the new activity
                startActivity(sendIntent);
            }
        });
        buttonShareMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // make intent w/ desired action
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                // set data type of stuff to be packaged
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, editTextMessage.getText().toString());
                startActivity(shareIntent);
            }
        });
    }

    private void wireWidgets() {
        editTextMessage = findViewById(R.id.editText_sendmessage_msg);
        buttonSendMessage = findViewById(R.id.button_sendmessage_send);
        buttonShareMessage = findViewById(R.id.button_sendmessage_share);
    }
}
