package com.example.e5dembadnek;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Macros extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macros);
        String weight = getIntent().getStringExtra("weight") ;
        String goal = getIntent().getStringExtra("goal") ;
        findViewById(R.id.button4).setOnClickListener(this); ;
        TextView prot = findViewById(R.id.textView2);
        TextView carbs = findViewById(R.id.textView4);
        TextView fats = findViewById(R.id.textView6);

        if (goal=="1") {
            prot.setText("Protein " +String.valueOf((int) 2.5*Integer.parseInt(weight)));
            carbs.setText("Carbs "+ weight) ;
            fats.setText("Fats " + String.valueOf((int) 0.5*Integer.parseInt(weight)));

        }
        else {
            prot.setText("Protein :" +String.valueOf((int) 2*Integer.parseInt(weight)) + " g per day");
            carbs.setText("Carbs :"+ String.valueOf((int) 3*Integer.parseInt(weight)) + " g per day") ;
            fats.setText("Fats :" + String.valueOf((int) 2*Integer.parseInt(weight)) +" g per day");
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.button4) {
            Intent intent;
            intent = new Intent(Macros.this,menu_.class);
            intent.putExtra("email","aaaa@aaaa.aaa");
            startActivity(intent);
            finish();
        }
    }
}

  /*  private CheckBox chkIos, chkAndroid ;
    private  int prot , fats , carbs , ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macros);

        EditText editText = findViewById(R.id.editText10);
        String weight = editText.getText().toString();
        EditTeé xt editText1 = findViewById(R.id.editText11);
        String height = editText1.getText().toString();
        TextView prot_ = findViewById(R.id.textView2);
        TextView carbs_ = findViewById(R.id.textView4);
        TextView fats_ = findViewById(R.id.textView6);
        int Weight = Integer.parseInt(weight);
        int Height = Integer.parseInt(height);
        addListenerOnChkIos();
        if(ok==0){
            prot = 2*Weight;
            carbs = 3*Weight;
            fats = 2*Weight;
        }
        else {
            prot = (int) (2.5*Weight);
            carbs = 1*Weight;
            fats = (int) 0.5*Weight;
        }
        prot_.setText("Protein : "+ String.valueOf(prot));
        carbs_.setText("Protein : "+ String.valueOf(carbs));
        fats_.setText("Protein : "+ String.valueOf(fats));



    }

    private void addListenerOnChkIos() {
        chkIos = (CheckBox) findViewById(R.id.checkBox);
        chkAndroid = findViewById(R.id.checkBox2)  ;
        ok=0;
        chkIos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //is chkIos checked?
                if (((CheckBox) v).isChecked()) {
                    ok=1;
                    Toast.makeText(Macros.this,
                            "Lose", Toast.LENGTH_LONG).show();
                }


            }
        });
        chkAndroid.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //is chkIos checked?
                if (   ok==0 && ((CheckBox) v).isChecked()) {
                    Toast.makeText(Macros.this,
                            "Gain", Toast.LENGTH_LONG).show();
                }
                else Toast.makeText(Macros.this,
                        "Please check just one option", Toast.LENGTH_LONG).show();
            }
        });


    }
} */