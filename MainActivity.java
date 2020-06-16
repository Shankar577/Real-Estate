package com.example.hp.realestateapp;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.hp.realestateapp.SQLiteHelper.KEY_ID;
import static com.example.hp.realestateapp.SQLiteHelper.KEY_fnm;
import static com.example.hp.realestateapp.SQLiteHelper.KEY_lnm;
import static com.example.hp.realestateapp.SQLiteHelper.KEY_pwd;
import static com.example.hp.realestateapp.SQLiteHelper.KEY_unm;
import static com.example.hp.realestateapp.SQLiteHelper.TABLE_NAME;

public class MainActivity extends AppCompatActivity {
    EditText eid,pwd;
    Button cont;
    String q;
    SQLiteDatabase SQLITEDATABASE;
    Boolean CheckEditTextEmpty;
    SQLiteHelper db;
    TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eid=(EditText)findViewById(R.id.editText);
        pwd=(EditText)findViewById(R.id.editText2);
        cont=(Button)findViewById(R.id.button);
       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }


    public void cont(View view) {
        String email=eid.getText().toString();
        String password=pwd.getText().toString();
        db=new SQLiteHelper(this);
        SQLITEDATABASE=db.getWritableDatabase();
        Cursor c=SQLITEDATABASE.rawQuery("select * from login where unm='"+email+"' and pwd='"+password+"'",null);

        if(c.getCount()>0 && c.moveToNext()){
            Toast.makeText(getApplicationContext(),"login successfully",Toast.LENGTH_LONG).show();
            Intent in = new Intent(this,Navigation.class);
            startActivity(in);

        }
        else{


            Toast.makeText(getApplicationContext(),"invalid credentials",Toast.LENGTH_LONG).show();

        }
        /*while(c.moveToNext())
        {
            str[0]=c.getString(1);
            str[1]=c.getString(2);
            str[2]=Integer.toString(c.getInt(0));
        }*/
    }

    public void goreg(View view) {
        Intent in=new Intent(this,signup.class);

        startActivity(in);
    }
/*
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

*/

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }
}
