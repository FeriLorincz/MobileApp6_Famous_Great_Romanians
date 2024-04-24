package com.example.famousgreatromanians;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonalitatiAdaptor.MyClickInterface {

    RecyclerView recyclerView;
    ArrayList<Personalitate> personalitati;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycle_view);
        personalitati = new ArrayList<>();

        personalitati.add(new Personalitate("Mihai Eminescu", R.drawable.eminescu));
        personalitati.add(new Personalitate("Mircea Eliade", R.drawable.eliade));
        personalitati.add(new Personalitate("Constantin Brancusi", R.drawable.brancusi));
        personalitati.add(new Personalitate("Nadia Comaneci", R.drawable.comanecialb));
        personalitati.add(new Personalitate("Henri Coanda", R.drawable.coanda));
        personalitati.add(new Personalitate("George Enescu", R.drawable.enescu));
        personalitati.add(new Personalitate("Iuliu Hossu", R.drawable.hossu));
        personalitati.add(new Personalitate("Emil Cioran", R.drawable.cioran));
        personalitati.add(new Personalitate("Petre Tutea", R.drawable.tutea));
        personalitati.add(new Personalitate("George Palade", R.drawable.palade));
        personalitati.add(new Personalitate("Ana Aslan", R.drawable.aslan));
        personalitati.add(new Personalitate("Emil Racovita", R.drawable.racovita));

        //crearea lui recyclerViewAdaptor ce l-am creat anterior

        PersonalitatiAdaptor personalitatiAdaptor = new PersonalitatiAdaptor(personalitati, this, this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this)); //setarea lui Layout Manager pt recyclerView
        recyclerView.setAdapter(personalitatiAdaptor); //adaugand in final acest adaptor la reclycle view)


    }

    @Override
    public void onItemClick(int positionOfThePersonalitate) {
        Toast.makeText(this, "Clicked "+personalitati.get(positionOfThePersonalitate).getName(), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, PersonalitateInfo.class);
        intent.putExtra("image",personalitati.get(positionOfThePersonalitate).getImage());
        intent.putExtra("name",personalitati.get(positionOfThePersonalitate).getName());
        startActivity(intent);
    }
}