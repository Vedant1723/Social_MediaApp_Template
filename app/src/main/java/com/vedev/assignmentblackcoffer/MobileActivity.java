package com.vedev.assignmentblackcoffer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MobileActivity extends AppCompatActivity {

    private EditText mobileNumber;
    private CardView submitNumber;
    public static String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mobile_login);

        mobileNumber=(EditText) findViewById(R.id.mobileNumber);
        submitNumber=(CardView)findViewById(R.id.submitNumber);


        submitNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mobileNumber.getText().toString().length()<10 || mobileNumber.getText().toString().isEmpty()){
                    Toast.makeText(MobileActivity.this, "Valid Mobile Number Required!", Toast.LENGTH_SHORT).show();
                }else {
                    number="+91"+mobileNumber.getText().toString();
                    verifyPhoneIntent();
                }
            }
        });


    }

    public void verifyPhoneIntent(){
        Intent intent = new Intent(getApplicationContext(),VerifyPhoneActivity.class);
        startActivity(intent);
    }
}
