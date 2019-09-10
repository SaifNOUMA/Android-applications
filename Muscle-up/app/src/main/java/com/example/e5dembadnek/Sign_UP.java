package com.example.e5dembadnek;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e5dembadnek.Models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Sign_UP extends AppCompatActivity implements View.OnClickListener  {

    private FirebaseAuth mAuth;
    private FirebaseDatabase mDatabase;
    private EditText email, password, username, age;
    private Button singup;
    private DatabaseReference usersRef;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up);

        email = findViewById(R.id.editText5);
        password = findViewById(R.id.editText6);
        singup = findViewById(R.id.button);
        age = findViewById(R.id.editText3);
        username = findViewById(R.id.editText2);
        singup.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance();

        usersRef = mDatabase.getReference("user");



    }


    public void onClick(View v) {
        if(R.id.button == v.getId()){
            mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(Sign_UP.this, mAuth.getCurrentUser().getEmail(), Toast.LENGTH_SHORT).show();
                        saveUser(mAuth.getCurrentUser().getUid());
                        Intent intent;
                        intent = new Intent(Sign_UP.this, Sign_in.class);
                        intent.putExtra("email",email.getText().toString());
                        startActivity(intent);
                    }else{
                        Log.e("TAG", "onComplete: "+ task.getException().getMessage() );
                    }
                }
            });
        }
    }

    private void saveUser(String uid) {
        User user = new User();

        user.setEmail(email.getText().toString());
        user.setfName(username.getText().toString());
        user.setlName("Last Name");
        usersRef.child(uid).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()) {
                    Toast.makeText(Sign_UP.this, mAuth.getCurrentUser().getEmail(), Toast.LENGTH_SHORT).show();
                }else{
                    Log.e("TAG", "onComplete: "+ task.getException().getMessage() );
                }
            }
        });
    }
}
