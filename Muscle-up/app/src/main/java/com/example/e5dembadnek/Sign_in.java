package com.example.e5dembadnek;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Sign_in extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private EditText email, password;
    private Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mAuth = FirebaseAuth.getInstance();
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button).setOnClickListener(this);
        email = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button) {
            mAuth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Intent intent;
                        intent = new Intent(Sign_in.this,menu_.class);
                        startActivity(intent);
                        finish();
                    }
                }
            });


        }
        if (v.getId() == R.id.button2) {
            Intent intent;
            intent = new Intent(Sign_in.this, Sign_UP.class);
            startActivity(intent);

        }
    }
}
