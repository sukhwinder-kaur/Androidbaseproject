package com.registerlogindemo.activity;


import android.app.Dialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;


import com.registerlogindemo.R;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by win 7 on 5/26/2017.
 */

public class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    public Context mContext;
    private Dialog dialog;
    private TextView txtMsgTV;
    private Toolbar toolbar;
    private TextView titleTV;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = BaseActivity.this;
        progressDialog();
    }

    public void showToast(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }


    private void progressDialog() {
        dialog = new Dialog(this);
        View view = View.inflate(this, R.layout.progress_dialog, null);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(view);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        txtMsgTV = (TextView) view.findViewById(R.id.txtMsgTV);
        dialog.setCancelable(false);
    }

    public void startProgressDialog() {
        if (dialog != null && !dialog.isShowing()) {
            try {
                dialog.show();
            } catch (Exception e) {
            }
        }
    }

    public void stopProgressDialog() {
        if (dialog != null && dialog.isShowing()) {
            try {
                dialog.dismiss();
            } catch (Exception e) {
            }
        }
    }

    public void setToolbar(String title) {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        titleTV = (TextView) findViewById(R.id.titleTV);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            titleTV.setText(title);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
    }

    public static void hideSoftKeyboard(BaseActivity activity) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) activity
                    .getSystemService(BaseActivity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void log(String string) {
        Log.e("BaseActivity", string);
    }

    @Override
    public void onClick(View v) {

    }

    public void gotoLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
