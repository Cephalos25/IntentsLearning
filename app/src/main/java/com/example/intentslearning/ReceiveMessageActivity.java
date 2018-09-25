package com.example.intentslearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReceiveMessageActivity extends AppCompatActivity {

    private TextView textViewDisplayMessage;
    private Button buttonSendAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);
        Intent receivedIntent = getIntent();
        String message = receivedIntent.getStringExtra(SendMessageActivity.EXTRA_MESSAGE);

        wireWidgets();

        textViewDisplayMessage.setText(message);
        buttonSendAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendAgainIntent = new Intent(ReceiveMessageActivity.this, SendMessageActivity.class);
            }
        });
    }

    private void wireWidgets() {
        textViewDisplayMessage = findViewById(R.id.textView_receivemessage_displaymsg);
        buttonSendAgain = findViewById(R.id.button_receivemessage_backtossend);
    }
}
