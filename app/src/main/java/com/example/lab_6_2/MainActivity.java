package com.example.lab_6_2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText text_editor;
    static final String SHARED_PREF_FILE = "MyApp";
    static final String SHARED_PREF_EDITOR_TEXT_KEY = "textInTheEditor";  

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_editor = findViewById(R.id.text_editor);
    }

    protected SharedPreferences getPref(){
        return getSharedPreferences(SHARED_PREF_FILE,MODE_PRIVATE);
    }

    @Override
    protected void onStop() {
        super.onStop();

        String text = text_editor.getText().toString();
        SharedPreferences sharedPreferences = getPref();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SHARED_PREF_EDITOR_TEXT_KEY,text);
        editor.commit();


    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPreferences = getPref();

        String savedText = sharedPreferences.getString(SHARED_PREF_EDITOR_TEXT_KEY,null);
        text_editor.setText(savedText);
    }
}
