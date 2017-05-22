package app.dwi.loginapp.presenter;

import android.text.TextUtils;

import app.dwi.loginapp.view.LoginView;

/**
 * Created by Dwira on 22/05/2017.
 */

public class LoginPresenterImp implements LoginPresenter {

    private LoginView loginView;
    public LoginPresenterImp(LoginView loginView){
        this.loginView = loginView;
    }

    @Override
    public void login(String username, String password) {
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            loginView.showValidation();
        }else {
            if (username.equals("admin") || password.equals("1234")){
                loginView.loginSuccess();
            }else {
                loginView.loginError();
            }
        }
    }
}
