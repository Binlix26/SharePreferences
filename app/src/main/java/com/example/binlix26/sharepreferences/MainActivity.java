package com.example.binlix26.sharepreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usernameInput;
    EditText passwordInput;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameInput = (EditText) findViewById(R.id.username_input);
        passwordInput = (EditText) findViewById(R.id.password_input);
        result = (TextView) findViewById(R.id.text_result);
    }

    // save the user's login information
    public void saveInfo(View view) {
        // create and set privacy
        SharedPreferences sharedPre = getSharedPreferences("userInfo", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPre.edit();
        editor.putString("username", usernameInput.getText().toString());
        editor.putString("password", passwordInput.getText().toString());
        editor.apply(); // commit

        usernameInput.setText("");
        passwordInput.setText("");

        Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show();
    }

    // print out the saved data
    public void displayData(View view) {
        SharedPreferences sharePre = getSharedPreferences("userInfo", MODE_PRIVATE);

        // the second parameter will be returned if it cannot find anything by the key
        String name = sharePre.getString("username", "");
        String pw = sharePre.getString("password", "");

        result.setText(name + " " + pw);
    }
}
