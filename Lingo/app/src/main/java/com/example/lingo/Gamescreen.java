package com.example.lingo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.lingo.databinding.ActivityGridBinding;
import com.example.lingo.databinding.ActivityInstructionBinding;
import com.example.lingo.databinding.ActivityMainBinding;

public class Gamescreen extends AppCompatActivity{

    //ActivityMainBinding binding;
    ActivityGridBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGridBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //setContentView(R.layout.grid_item);

        //have slots for yellow letters on top, representing goal word. then guesses get new rows of slots with blue for wrong place yellow for right place and white for wrong letter
        //first row should start with underlines filling slots and letters filling it should also be underlined.

        String[] slotName = {"","","",""};
        int[] slotImages = {R.drawable.a0,R.drawable.zero,R.drawable.b0,R.drawable.c0};

        GridAdapter gridAdapter = new GridAdapter(Gamescreen.this,slotName,slotImages);
        binding.gridView.setAdapter(gridAdapter);


//        binding.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                Toast.makeText(Gamescreen.this,"You Clicked on "+ slotName[position],Toast.LENGTH_SHORT).show();
//
//            }
//        });

    }

}
