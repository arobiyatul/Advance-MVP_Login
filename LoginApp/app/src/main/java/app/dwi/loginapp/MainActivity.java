package app.dwi.loginapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import app.dwi.loginapp.presenter.LoginPresenter;
import app.dwi.loginapp.presenter.LoginPresenterImp;
import app.dwi.loginapp.view.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView{

    private LoginPresenter loginPresenter;
    private EditText edtUsername;
    private EditText edtPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsername = (EditText) findViewById(R.id.edt_username);
        edtPassword = (EditText) findViewById(R.id.edt_password);
        btnLogin = (Button) findViewById(R.id.btn_login);

        loginPresenter = new LoginPresenterImp(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.login(edtUsername.getText().toString(), edtPassword.getText().toString());
            }
        });

    }

    @Override
    public void showValidation() {
        Toast.makeText(this, "Plese Enter Username and Password!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "Login Succesfully!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginError() {
        Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show();
    }
}
