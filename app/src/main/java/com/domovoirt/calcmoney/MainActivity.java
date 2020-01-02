package com.domovoirt.calcmoney;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnAdd, btnRead, btnClear;
    EditText etName, etEmail;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //region
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //endregion
        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
        Button btnRead = findViewById(R.id.btnRead);
        btnRead.setOnClickListener(this);
        Button btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);

        EditText etName = findViewById(R.id.etName);
        EditText etEmail = findViewById(R.id.etEmail);

        dbHelper = new DBHelper(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onClick(View view) {
        String name, email;
        name = etName.getText().toString();
        email = etEmail.getText().toString();

        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        switch (view.getId()) {
            case (R.id.btnAdd):
                contentValues.put(dbHelper.KEY_NAME, name);
                contentValues.put(dbHelper.KEY_MAIL, email);

                database.insert(DBHelper.TABLE_CONTACTS,null,
                        contentValues);
                break;
            case (R.id.btnRead):
                //
                break;
            case (R.id.btnClear):
                //
                break;

        }
    }
}
