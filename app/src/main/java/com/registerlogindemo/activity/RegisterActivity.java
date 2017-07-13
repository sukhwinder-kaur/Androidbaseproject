package com.registerlogindemo.activity;

import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.registerlogindemo.R;

public class RegisterActivity extends BaseActivity {

    private EditText usernameET, emailET, passwordET, confirmPasswordET;
    private Button registerBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //------------------------------set action bar and action bar title-------------//
        setToolbar(getString(R.string.register));
        initUI();
    }

    private void initUI() {
        usernameET = (EditText) findViewById(R.id.usernameET);
        emailET = (EditText) findViewById(R.id.emailET);
        passwordET = (EditText) findViewById(R.id.passwordET);
        confirmPasswordET = (EditText) findViewById(R.id.confirmPasswordET);

        registerBT = (Button) findViewById(R.id.registerBT);

        registerBT.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.registerBT:
                setValiadtion();
                break;
            default:
                break;
        }
    }

    private void setValiadtion() {
        //----------------get the value from edittext-----------------//

        String userName = usernameET.getText().toString().trim();
        String email = emailET.getText().toString().trim();
        String password = passwordET.getText().toString().trim();
        String confirmPassword = confirmPasswordET.getText().toString().trim();

        // --------------------- check validations--------------------///
        if (userName.isEmpty()) {
            showToast("Please enter user name");
        } else if (email.isEmpty()) {
            showToast("Please enter email");
        } else if (!email.contains("@") ||!email.contains(".")) {
            showToast("Please enter valid email");
        } else if (password.isEmpty()) {
            showToast("Please enter password");
        } else if (confirmPassword.isEmpty()) {
            showToast("Please enter confirm password");
        } else if (!confirmPassword.equals(password)) {
            showToast("Password does not match");
        } else {
            finish();
        }
    }
}
