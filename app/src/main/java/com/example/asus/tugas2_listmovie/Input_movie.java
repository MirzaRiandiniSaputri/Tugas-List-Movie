package com.example.asus.tugas2_listmovie;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Input_movie extends AppCompatActivity {
    ArrayList<String> Nama;
    ArrayList<String> Rating;
    ArrayList<String> Status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_movie);
        addItemsOnSpinner2();
    }

    public void addItemsOnSpinner2() {

        Spinner spinner2 = (Spinner) findViewById(R.id.opsi);
        List<String> list = new ArrayList<String>();
        list.add("NOW PLAYING");
        list.add("COMING SOON");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);
    }

    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.O)

    public void AddMovie (View view) {
        Double temp;
        String rating, nama, status;
        EditText edit;
        Nama = getIntent().getStringArrayListExtra("nama");
        Rating = getIntent().getStringArrayListExtra("rating");
        Status = getIntent().getStringArrayListExtra("status");
        try{
            edit = findViewById(R.id.judul);
            nama = edit.getText().toString();
            edit = findViewById(R.id.rate);
            rating = edit.getText().toString();
            Spinner spn = findViewById(R.id.opsi);
            status = String.valueOf(spn.getSelectedItem());
        }
        catch(Error e){
            nama = "";
            rating = "0";
            status = "";
        }
        if(nama != "" && status != "") {
            Nama.add(nama);
            Rating.add(rating);
            Status.add(status);
        }
        Intent intent = new Intent(this, MainActivity.class);
        intent.putStringArrayListExtra("nama",Nama);
        intent.putStringArrayListExtra("rating",Rating);
        intent.putStringArrayListExtra("status",Status);
        view.getContext().startActivity(intent);
    }
}
