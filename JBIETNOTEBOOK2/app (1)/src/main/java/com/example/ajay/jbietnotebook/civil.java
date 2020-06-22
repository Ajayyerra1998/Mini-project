package com.example.ajay.jbietnotebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridLayout;

public class civil extends AppCompatActivity {

    GridLayout secondGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_civil);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        secondGrid=findViewById(R.id.secondGrid);
        SubEvent(secondGrid);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void SubEvent(GridLayout secondGrid) {
        //looping all child items in card
        for (int i = 0; i < secondGrid.getChildCount(); i++)
        {
            //create a cardview object
            CardView cardView = (CardView)secondGrid.getChildAt(i);
            final int f = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {

                    {

                        Intent intent =new Intent(civil.this,Civil_1stYear.class);
                        startActivity(intent);

                    }
                    if(f == 1)//open Subjects activity
                    {

                        Intent intent =new Intent(civil.this,Cse_2ndYear.class);
                        startActivity(intent);
                    }
                    if(f == 2)//open Subjects activity
                    {

                        Intent intent =new Intent(civil.this,Cse_3rdYear.class);
                        startActivity(intent);
                    }
                    if(f == 3)//open Subjects activity
                    {

                        Intent intent =new Intent(civil.this,Cse_4thYear.class);
                        startActivity(intent);
                    }










                }
            });
        }
    }

}
