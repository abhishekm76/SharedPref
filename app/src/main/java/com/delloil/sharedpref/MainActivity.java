package com.delloil.sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText editText;
    private TextView textView;
    public static final String MESSAGE_ID ="sharedprefname";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        editText= findViewById(R.id.editText);
        textView=findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText.getText().toString().trim();

                SharedPreferences sharedPreferences = getSharedPreferences(MESSAGE_ID,MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("keyfortext",message);
                editor.apply(); // saving to disk
            }
        });
                // get saved preferences
                SharedPreferences getSavedData = getSharedPreferences(MESSAGE_ID,MODE_PRIVATE);
                String savedVal = getSavedData.getString("keyfortext","Nothing saved");
                textView.setText(savedVal);
    }



}
