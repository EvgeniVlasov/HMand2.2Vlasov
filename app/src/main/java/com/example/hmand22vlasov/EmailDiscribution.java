package com.example.hmand22vlasov;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EmailDiscribution extends AppCompatActivity {
    private EditText editName;
    private EditText editMail;
    private TextView txtComplite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_discribution);
        editName = findViewById(R.id.editName);
        editMail = findViewById(R.id.editMail);
        txtComplite = findViewById(R.id.txtComplite);
    }
    public void clickButtonOK(View view) {
         String name = editName.getText().toString();
        String mail = editMail.getText().toString();
        txtComplite.setText("");
        if (name.isEmpty() || mail.isEmpty()) {
            return;
        }
        txtComplite.setText(String.format(getString(R.string.txtresult), name, mail));

    }

    public void clickButtonClear(View view) {
        editName.setText("");
        editMail.setText("");
        txtComplite.setText("");
    }
}