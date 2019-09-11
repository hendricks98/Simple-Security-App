package com.example.simplesecurityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private final int UNLOCK_REQUEST = 123;
    public String pin = "";
    public boolean correct = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickUnlock(View view) {
        Intent intent = new Intent(this,UnlockActivity.class);
        startActivityForResult(intent, UNLOCK_REQUEST);

        TextView welcomeText = findViewById(R.id.welcomeTextView);
        welcomeText.setText("Welcome to the App! The app is LOCKED!");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == UNLOCK_REQUEST) {
            if (resultCode == RESULT_OK) {

                pin = data.getExtras().getString("pin");
                if( pin.compareTo("1234") == 0){
                    Toast t = Toast.makeText(this, "Your pin was CORRECT, app unlocked: " + pin, Toast.LENGTH_LONG);
                    t.show();
                    TextView welcomeText = findViewById(R.id.welcomeTextView);
                    welcomeText.setText("Welcome to the App! The app is UNLOCKED!");

                } else {
                    Toast t = Toast.makeText(this, "Your pin was INCORRECT, app still locked: " + pin, Toast.LENGTH_LONG);
                    t.show();
                }
            }
        }
    }
}
