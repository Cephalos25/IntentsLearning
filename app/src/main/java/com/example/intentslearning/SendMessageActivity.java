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
                Intent sendMessageIntent = new Intent(SendMessageActivity.this, ReceiveMessageActivity.class);
                // package text to intent
                sendMessageIntent.putExtra(EXTRA_MESSAGE, message);
                // start the new activity
                startActivity(sendMessageIntent);
            }
        });
    }

    private void wireWidgets() {
        editTextMessage = findViewById(R.id.editText_sendmessage_msg);
        buttonSendMessage = findViewById(R.id.button_sendmessage_send);
    }
}
