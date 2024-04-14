package com.example.kiemtra.Product.Register_Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kiemtra.MainActivity;
import com.example.kiemtra.R;

public class LoginActivity extends AppCompatActivity {

    AccountDatabaseHelper databaseHelper;
    TextView tvSignup;
    EditText txtUsername, txtPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView tv = findViewById(R.id.tvSignUp);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });

        databaseHelper=new AccountDatabaseHelper(this);
        txtUsername=findViewById(R.id.lgUsername);
        txtPassword=findViewById(R.id.lgPassword);
        btnLogin=findViewById(R.id.btnLogin);
        tvSignup=findViewById(R.id.tvSignUp);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=txtUsername.getText().toString();
                String password=txtPassword.getText().toString();
                if(username.equals("")|| password.equals("")){
                    Toast.makeText(LoginActivity.this, "Vui lòng nhập tài khoản và mật khẩu", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(databaseHelper.checkUsernamePassword(username,password)==true){
                        Intent intent=new Intent(LoginActivity.this, MainActivity.class);
                        autoDatabase();
                        startActivity(intent);

                    }
                    else
                        Toast.makeText(LoginActivity.this, "Tài khoản hoặc mật khẩu không đúng!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    void autoDatabase(){
        for (int i = 1; i <= 10; i++) {
            String name="Xe  "+i;
            String description="Mô tả xe "+i;
            double price=999.9;
            String imageId="h"+i;
            Boolean insert =databaseHelper.insertProduct(name,description,price,imageId);

        }
    }
}