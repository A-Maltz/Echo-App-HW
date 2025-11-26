package com.example.hw1echoapp;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hw1echoapp.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private static void onClick(View view, EditText edittext, TextView textview) {
        String text = edittext.getText().toString();

        textview.setText(text);

        Snackbar.make(view, "Text echoed", Snackbar.LENGTH_LONG)
                .setAnchorView(R.id.efab).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        ExtendedFloatingActionButton efab = findViewById(R.id.efab);

        EditText editText = findViewById(R.id.edit_text);

        TextView textView = findViewById(R.id.text2);

        efab.setOnClickListener(v ->
                MainActivity.onClick(v, editText, textView)
        );
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
}