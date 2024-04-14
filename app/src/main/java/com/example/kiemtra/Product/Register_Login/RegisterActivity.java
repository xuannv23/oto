package com.example.kiemtra.Product.Register_Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kiemtra.R;

public class RegisterActivity extends AppCompatActivity {
    AccountDatabaseHelper databaseHelper;
    EditText txtName,txtUsername,txtPassword,txtDate;
    TextView tvLogin;
    Button btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        TextView tv = findViewById(R.id.haveAnAccount);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        databaseHelper=new AccountDatabaseHelper(this);
        txtName = findViewById(R.id.inputName);
        txtUsername = findViewById(R.id.inputUsername);
        txtPassword = findViewById(R.id.password);
        txtDate = findViewById(R.id.inputDate);
        btnSignUp = findViewById(R.id.btnRegster);
        tvLogin = findViewById(R.id.haveAnAccount);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtName.getText().toString();
                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();
                String date = txtDate.getText().toString();
                if(name.equals("")||username.equals("")||password.equals("")||date.equals("")){
                    Toast.makeText(RegisterActivity.this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkUsername= databaseHelper.checkUsername(username);
                    if(checkUsername==false){
                        Boolean insert =databaseHelper.insertData(name,username,password,date);
                        if(insert==true) {
                            Toast.makeText(RegisterActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }
                        else Toast.makeText(RegisterActivity.this, "Username đã tồn tại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}