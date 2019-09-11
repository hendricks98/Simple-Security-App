package com.example.simplesecurityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class UnlockActivity extends AppCompatActivity {

    public String pin = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unlock);
    }

    public void checkPinLength(){

        if (pin.length() == 4){
            Intent intent = new Intent();
            intent.putExtra("pin", pin);
            setResult(RESULT_OK, intent);
            finish();
        } else {
            Toast t = Toast.makeText(this,"Error: please type 4 numbers. Clearing entry!", Toast.LENGTH_LONG);
            t.show();
            pin = "";
        }
    }

    public void clickSubmit(View view){
        checkPinLength();
        System.out.print("Pin entered: '" + pin + "'");
    }

    public void clickOne(View view) {
        pin = pin + "1";
        System.out.println(pin.length());
    }

    public void clickTwo(View view) {
        pin = pin + "2";
        System.out.println(pin.length());
    }

    public void clickThree(View view) {
        pin = pin + "3";
        System.out.println(pin.length());
    }

    public void clickFour(View view) {
        pin = pin + "4";
        System.out.println(pin.length());
    }
}
