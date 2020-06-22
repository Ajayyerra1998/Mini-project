package com.example.ajay.jbietnotebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener {
    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mainGrid=findViewById(R.id.mainGrid);
        FirstEvent(mainGrid);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    private void FirstEvent(GridLayout mainGrid) {
        //looping all child items in card
        for (int i = 0; i < mainGrid.getChildCount(); i++)
        {
            //create a cardview object
            CardView cardView = (CardView)mainGrid.getChildAt(i);
            final int f = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {

                    if(f == 0)//open cse activity
                    {

                        Intent intent =new Intent(MainActivity.this,cse.class);
                        startActivity(intent);
                    }


                    if(f == 1)//open ecm activity
                    {

                        Intent intent =new Intent(MainActivity.this,ecm.class);
                        startActivity(intent);
                    }


                    if(f == 2)//open it activity
                    {

                        Intent intent =new Intent(MainActivity.this,it.class);
                        startActivity(intent);
                    }

                    if(f == 3)//open eee activity
                    {

                        Intent intent =new Intent(MainActivity.this,eee.class);
                        startActivity(intent);
                    }


                    if(f == 4)//open ece activity
                    {

                        Intent intent =new Intent(MainActivity.this,ece.class);
                        startActivity(intent);
                    }

                    if(f == 5)//open mech activity
                    {

                        Intent intent =new Intent(MainActivity.this,mech.class);
                        startActivity(intent);
                    }

                    if(f == 6)//open civil activity
                    {

                        Intent intent =new Intent(MainActivity.this,civil.class);
                        startActivity(intent);
                    }


                    if(f == 7)//open mining activity
                    {

                        Intent intent =new Intent(MainActivity.this,mining.class);
                        startActivity(intent);
                    }

                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
