package com.example.myemail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button send;
EditText email,message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send = findViewById(R.id.send);
        email = findViewById(R.id.email);
        message = findViewById(R.id.message);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

         if (email.getText().toString().isEmpty()){
             email.setError("REQUIRED");
             return;
         }
      if (message.getText().toString().isEmpty()){
          message.setError(("REQUIRED"));
          return;
      }

      else {

          String[] TO = {email.getText().toString()};
          Intent emailIntent = new Intent(Intent.ACTION_SEND);
          emailIntent.setData(Uri.parse("mailto:"));
          emailIntent.setType("text/plain");
          emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
          emailIntent.putExtra(Intent.EXTRA_SUBJECT, "SENDING THIS FOR DEMO PURPOSES");
          emailIntent.putExtra(Intent.EXTRA_TEXT, message.getText().toString());

          try {
              startActivity(Intent.createChooser(emailIntent, "Send mail..."));
              finish();
              Log.i("Finished Sending Email","");


          }
          catch (android.content.ActivityNotFoundException ex) {
              Toast.makeText(MainActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
          }
      }


            }
        });
    }
}