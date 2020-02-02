package com.example.personalapp.ui;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.personalapp.R;

public class BaseActivity extends AppCompatActivity implements BaseView {

    private AlertDialog mAlertDialog;

    @Override
    public void showProgressBar(boolean isCancelable) {
        mAlertDialog = new ProgressDialog.Builder(this)
                .setView(R.layout.dialog_progress)
                .setCancelable(isCancelable)
                .create();
        mAlertDialog.show();
    }

    @Override
    public void hideProgressBar() {
        runOnUiThread(() -> {
            if (mAlertDialog != null) {
                mAlertDialog.hide();
            }
        });

    }

    @Override
    public void showDefaultError() {
        runOnUiThread(() -> showInfoDialog(R.string.title_something_wrong,
                R.string.msg_something_wrong,
                true,
                android.R.string.ok,
                null));

    }

    @Override
    public void showTwoButtonsDialog(Integer title, Integer message, boolean cancelable,
                                     Integer positiveBtn, Integer negativeBtn,
                                     DialogInterface.OnClickListener clickListener) {

        runOnUiThread(() -> {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(BaseActivity.this);
            dialogBuilder.setTitle(title)
                    .setMessage(message)
                    .setCancelable(cancelable)
                    .setPositiveButton(positiveBtn, clickListener)
                    .setNegativeButton(negativeBtn, clickListener);
            mAlertDialog = dialogBuilder.create();
            mAlertDialog.show();
        });

    }


    @Override
    public void showInfoDialog(Integer title, Integer message, boolean cancelable, Integer buttonTxt, DialogInterface.OnDismissListener onDismissListener) {
        runOnUiThread(() -> {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(BaseActivity.this);
            if (title != null) {
                dialogBuilder.setTitle(title);
            }
            if (title != null) {
                dialogBuilder.setMessage(message);
            }
            if (onDismissListener != null) {
                dialogBuilder.setOnDismissListener(onDismissListener);
            }

            dialogBuilder
                    .setCancelable(cancelable)
                    .setPositiveButton(buttonTxt, (dialog, which) -> dialog.dismiss());

            mAlertDialog = dialogBuilder.create();
            mAlertDialog.show();//
        });
    }

    @Override
    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
