package com.vedev.assignmentblackcoffer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SignUpActivity extends AppCompatActivity {


    private TextView signUpLoginTV;
    private CardView submitBtn;
    private FirebaseAuth mAuth;
    private EditText emailEdit, passwordEdit;
    private RadioButton privacyRadioBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();
        signUpLoginTV = (TextView) findViewById(R.id.sign_up_loginTV);

        submitBtn = (CardView) findViewById(R.id.signUpSubmitBtn);
        emailEdit = (EditText) findViewById(R.id.signUpEmailEdit);
        passwordEdit = (EditText) findViewById(R.id.passwordSignUp);
        privacyRadioBtn = (RadioButton) findViewById(R.id.privacyRadioBtn);
        emailEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailEdit.setText(" ");
            }
        });

        signUpLoginTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginIntent();
            }
        });
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEdit.getText().toString().trim();
                String password = passwordEdit.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    emailEdit.setError("Enter Email Address!");
                    emailEdit.setFocusable(true);

                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    passwordEdit.setError("Enter Password");
                    passwordEdit.setFocusable(true);
                }

                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    emailEdit.setError("Enter Email Address!");
                    emailEdit.setFocusable(true);
                    passwordEdit.setError("Enter Password");
                    passwordEdit.setFocusable(true);
                    return;

                }
                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                }
                if (privacyRadioBtn.isChecked()) {
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(SignUpActivity.this, "Sign Up Successful", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        Toast.makeText(SignUpActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                } else {
                    Toast.makeText(SignUpActivity.this, "Please Confirm that you have read the Privacy Conditions", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    public void loginIntent() {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }

}
