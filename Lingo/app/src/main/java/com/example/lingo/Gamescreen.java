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

        String[] slotName = {"","","","",
                "","","","","",""};
        int[] slotImages = {R.drawable.a0,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,
                R.drawable.h,R.drawable.i,R.drawable.j};

        GridAdapter gridAdapter = new GridAdapter(Gamescreen.this,slotName,slotImages);
        binding.gridView.setAdapter(gridAdapter);


        binding.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(Gamescreen.this,"You Clicked on "+ slotName[position],Toast.LENGTH_SHORT).show();

            }
        });

    }

}
