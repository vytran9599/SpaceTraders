package edu.gatech.cs2340.spacetraders.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import edu.gatech.cs2340.spacetraders.R;

public class addNewPerson extends AppCompatActivity {
    public static final String EXTRA_NAME =
            "edu.gatech.cs2340.spacetraders.views.EXTRA_NAME";
    private EditText editPlayerName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_person);
        editPlayerName = findViewById(R.id.nameText);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add New Person");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();

        menuInflater.inflate(R.menu.add_player_menu, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.save_person:
                savePerson();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }

    }

    private void savePerson() {
        String name   = editPlayerName.getText().toString();

        Log.d("APP", "Making intent");
        Log.d("APP", "Data - " + name);
        Intent intent = new Intent();
        intent.putExtra(EXTRA_NAME, name);

        setResult(RESULT_OK, intent);

        finish();

    }
}