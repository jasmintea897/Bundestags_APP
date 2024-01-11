package de.eahjena.app.wi.bundestags_app;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button_plenarprotokolle);
        Button button2 = findViewById(R.id.button_personen);
        Button button3 = findViewById(R.id.button_drei);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_plenarprotokolle();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_personen();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_drei();
            }
        });

/*
        {
            private void openactivity_drei() {
            Intent intent = new Intent(this, drei.class);
            startActivity(intent);
        }

        }
        {
            private void openActivity_plenarprotokolle() {
            Intent intent = new Intent(this, plaenarprotokolleActivity.class);

            startActivity(intent);
        }
        }

        private void openactivity_personen()  {
            Intent intent = new Intent(this, Personen.class);
            startActivity(intent);
        }

        {
            private void openactivity_drei() {
            Intent intent = new Intent(this, drei.class);
            startActivity(intent);
        }
        }

*/



   /* {  binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);


    }*/


   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }*/

    /*@Override
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
    }*/

   /* @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }*/


}

    private void openActivity_drei() { Intent intent = new Intent(this, drei.class);
        startActivity(intent);
    }

    private void openActivity_personen() {Intent intent = new Intent(this, PersonenActivity.class);
        startActivity(intent);
    }

    private void openActivity_plenarprotokolle() {
        Intent intent = new Intent(this, plaenarprotokolleActivity.class);

        startActivity(intent);
    }
    }