package com.example.hmand22vlasov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button btnSave;
    private SharedPreferences myNoteSharedPref;
    private static String NOTE_TEXT = "note_text";
    String noteTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        getDateSharedPref();
    }

    private void initView() {
        editText = findViewById(R.id.editText);
        btnSave = findViewById(R.id.btnSave);

        myNoteSharedPref = getSharedPreferences("MyNote",MODE_PRIVATE);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor myEditor = myNoteSharedPref.edit();
                 noteTxt = editText.getText().toString();
                myEditor.putString(NOTE_TEXT,noteTxt);
                myEditor.apply();
                Toast.makeText(MainActivity.this,"Данные сохранены",Toast.LENGTH_LONG).show();
            }
        });
    }
    private void getDateSharedPref () {
        noteTxt = myNoteSharedPref.getString(NOTE_TEXT,noteTxt);
        editText.setText(noteTxt);
    }
}