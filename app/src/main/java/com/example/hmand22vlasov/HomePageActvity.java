package com.example.hmand22vlasov;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class HomePageActvity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_actvity);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_open_notes) {
            Toast.makeText(HomePageActvity.this, "Открыть записную книжку", Toast.LENGTH_LONG).show();
            Intent intentNotes = new Intent(HomePageActvity.this,MainActivity.class);
            startActivity(intentNotes);
            return true;

        }
        if (id == R.id.action_open_mail) {
            Toast.makeText(HomePageActvity.this, "Рассылка Эл.письма", Toast.LENGTH_LONG).show();
            Intent intentNotes = new Intent(HomePageActvity.this,EmailDiscribution.class);
            startActivity(intentNotes);
            return true;

        }
        if (id == R.id.action_open_calendar) {
            Toast.makeText(HomePageActvity.this, "Календарь задач", Toast.LENGTH_LONG).show();
            Intent intentNotes = new Intent(HomePageActvity.this,Calendar_Activity.class);
            startActivity(intentNotes);
            return true;

        }
        if (id == R.id.action_open_payment) {
            Toast.makeText(HomePageActvity.this, "Выбор способа оплаты", Toast.LENGTH_LONG).show();
            Intent intentNotes = new Intent(HomePageActvity.this,Payment_Activity.class);
            startActivity(intentNotes);
            return true;

        }

        return super.onOptionsItemSelected(item);
    }





}