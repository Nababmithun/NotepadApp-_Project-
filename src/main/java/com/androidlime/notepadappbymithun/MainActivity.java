package com.androidlime.notepadappbymithun;

import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity {

    EditText et_memo;

    Button b_clear, b_save;
   String memo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_memo = (EditText) findViewById(R.id.et_memo);

        b_save = (Button) findViewById(R.id.b_save);
        b_clear = (Button) findViewById((R.id.b_clear));

        SharedPreferences preferences=getSharedPreferences("PREFS",0);
        memo=preferences.getString("memo","");

        et_memo.setText(memo);
        b_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               memo=" ";
                et_memo.setText(memo);

            }
        });

        b_clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                memo=et_memo.getText().toString();

                SharedPreferences preferences=getSharedPreferences("PREFS",0);
                SharedPreferences.Editor editor=preferences.edit();
                editor.putString("memo",memo);
                editor.commit();


                Toast.makeText(MainActivity.this,"Memo Saved",Toast.LENGTH_SHORT).show();

            }

        });

    }
}
