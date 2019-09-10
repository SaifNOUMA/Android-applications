package com.example.e5dembadnek;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Nutrition extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private CheckBox chkIos, chkAndroid ;
    private int ok = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition);
        Spinner spinner = findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.ACTIVITY_LEVEL,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        EditText weight = findViewById(R.id.editText10) ;

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.button3) {
                    addListenerOnChkIos();
                    Intent intent;
                    EditText editText = findViewById(R.id.editText10)  ;
                    intent = new Intent(Nutrition.this,Macros.class);
                    intent.putExtra("weight",editText.getText().toString());

                    intent.putExtra("height" , findViewById(R.id.editText11).toString()) ;
                    intent.putExtra("goal" , String.valueOf(ok) ) ;
                    startActivity(intent);
                    finish(); }
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

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
                    Toast.makeText(Nutrition.this,
                            "Lose", Toast.LENGTH_LONG).show();
                }


            }
        });
        chkAndroid.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //is chkIos checked?
                if (   ok==0 && ((CheckBox) v).isChecked()) {
                    Toast.makeText(Nutrition.this,
                            "Gain", Toast.LENGTH_LONG).show();
                }
                else Toast.makeText(Nutrition.this,
                        "Please check just one option", Toast.LENGTH_LONG).show();
            }
        });


    }
}