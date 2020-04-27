package com.vedev.assignmentblackcoffer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class LoginActivity extends AppCompatActivity {

    private TextView loginSignUpTv, mobileLogin;
    private FirebaseAuth mAuth;
    private EditText inputEmail, inputPassword;
    private CardView submitBtn;
    private RadioButton rememberMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        loginSignUpTv = (TextView) findViewById(R.id.login_SignUpTv);
        mobileLogin = (TextView) findViewById(R.id.login_mob);

        inputEmail=(EditText)findViewById(R.id.loginEmail);
        inputPassword=(EditText)findViewById(R.id.loginPassword);
        submitBtn=(CardView)findViewById(R.id.loginSubmit);
        rememberMe=(RadioButton)findViewById(R.id.rememberMeBtn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = inputEmail.getText().toString();
                final String password = inputPassword.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    inputEmail.setError("Enter Email Address!");
                    inputEmail.setFocusable(true);
                    inputPassword.setError("Enter Password");
                    inputPassword.setFocusable(true);
                    return;

                }

                mAuth.signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                                    startActivity(intent);
                                    finish();

                                }else {
                                    Toast.makeText(LoginActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });


        mobileLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MobileActivity.class);
                startActivity(intent);
            }
        });

        loginSignUpTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpIntent();
            }
        });
    }

    public void signUpIntent() {
        Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }


}

