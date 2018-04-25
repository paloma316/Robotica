package com.example.paloma.sqlite1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


}
    public void ButtonClick(View v){

        EditText editTextName = (EditText) findViewById(R.id.editText);
        EditText editTextSurname = (EditText) findViewById(R.id.editText2);
        DatabaseHelper myDb = new DatabaseHelper(this);

     //   boolean insert = myDb.insertData(editTextName.getText().toString(), editTextSurname.getText().toString());
        boolean insert = myDb.insertData("Paulo","Anna");
        if (insert) {
            Toast.makeText(this, "Inserted", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Nada so!!", Toast.LENGTH_SHORT).show();
        }
    }
}
