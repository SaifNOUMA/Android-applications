package com.example.e5dembadnek;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Exercices extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercices);
        findViewById(R.id.abs).setOnClickListener(this);
        findViewById(R.id.back).setOnClickListener(this);
        findViewById(R.id.biceps).setOnClickListener(this);
        findViewById(R.id.chest).setOnClickListener(this);
        findViewById(R.id.legs).setOnClickListener(this);
        findViewById(R.id.triceps).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.abs){
            Intent intent;
            intent = new Intent(Exercices.this,abs.class);
            startActivity(intent);

        }
        if(v.getId() == R.id.back){
            Intent intent;
            intent = new Intent(Exercices.this,back.class);
            startActivity(intent);

        }
        if(v.getId() == R.id.biceps){
            Intent intent;
            intent = new Intent(Exercices.this,biceps.class);
            startActivity(intent);

        }
        if(v.getId() == R.id.chest){
            Intent intent;
            intent = new Intent(Exercices.this,chest.class);
            startActivity(intent);

        }
        if(v.getId() == R.id.legs){
            Intent intent;
            intent = new Intent(Exercices.this,legs.class);
            startActivity(intent);

        }
        if(v.getId() == R.id.triceps){
            Intent intent;
            intent = new Intent(Exercices.this,triceps.class);
            startActivity(intent);

        }
    }
}
