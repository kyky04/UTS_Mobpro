package com.example.infonegara;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by kyky on 03/11/2016.
 */

public class LoginActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        final EditText name = (EditText)findViewById(R.id.name);
        final EditText pass = (EditText)findViewById(R.id.pass);
        TextView forgot = (TextView) findViewById(R.id.forgot);
        Button go = (Button)findViewById(R.id.go);

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Username : admin dan Password : admin", Toast.LENGTH_SHORT).show();
            }
        });

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nama = String.valueOf(name.getText());
                String password = String.valueOf(pass.getText());

                if(nama.equals("admin")&&password.equals("admin")){
                    Intent i = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(LoginActivity.this, "Nama atau Passwor Anda salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
