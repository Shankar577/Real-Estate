package com.example.hp.realestateapp;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    EditText lnm,fnm,eid,pwd;
    Button cont;
    String q;
    SQLiteDatabase SQLITEDATABASE;
    Boolean CheckEditTextEmpty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        lnm=(EditText)findViewById(R.id.editText3);
        fnm=(EditText)findViewById(R.id.editText4);
        eid=(EditText)findViewById(R.id.editText5);
        pwd=(EditText)findViewById(R.id.editText6);
    }

    public void clr(View view) {
        eid.setText("");
        pwd.setText("");
        lnm.setText("");
        fnm.setText("");
    }

    public void reg(View view) {
        DBCreate();

        SubmitData2SQLiteDB();



    }


    public void DBCreate(){

        SQLITEDATABASE = openOrCreateDatabase("examDataBase", Context.MODE_PRIVATE, null);

        SQLITEDATABASE.execSQL("CREATE TABLE IF NOT EXISTS login(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, lnm VARCHAR, fnm VARCHAR, unm VARCHAR , pwd VARCHAR);");
    }


    public void SubmitData2SQLiteDB(){

        String ln=lnm.getText().toString();
        String fn=fnm.getText().toString();
        String email=eid.getText().toString();
        String password=pwd.getText().toString();

        CheckEditTextIsEmptyOrNot(ln,fn,email,password);

        if(CheckEditTextEmpty == true)
        {

            q = "INSERT INTO login  (lnm,fnm,unm,pwd) VALUES('"+ln+"','"+fn+"','"+email+"','"+password+"');";

            SQLITEDATABASE.execSQL(q);

            Toast.makeText(this,"Registerd Successfully", Toast.LENGTH_LONG).show();

            ClearEditTextAfterDoneTask();

            Intent in = new Intent(this,MainActivity.class);
            startActivity(in);

        }
        else {

            Toast.makeText(this,"Please Fill All the Fields", Toast.LENGTH_LONG).show();
        }
    }

    public void CheckEditTextIsEmptyOrNot( String lnm,String fnm,String eid , String pwd){

        if(TextUtils.isEmpty(eid) || TextUtils.isEmpty(pwd)|| TextUtils.isEmpty(lnm) || TextUtils.isEmpty(fnm)){

            CheckEditTextEmpty = false ;

        }
        else {
            CheckEditTextEmpty = true ;
        }
    }
    public void ClearEditTextAfterDoneTask(){

        eid.setText("");
        pwd.setText("");
        lnm.setText("");
        fnm.setText("");

    }
}
