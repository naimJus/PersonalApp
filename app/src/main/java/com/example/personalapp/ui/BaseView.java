package com.example.personalapp.ui;

import android.content.DialogInterface;

public interface BaseView {
    void showProgressBar(boolean isCancelable);

    void hideProgressBar();

    void showDefaultError();

    void showTwoButtonsDialog(Integer title, Integer message, boolean cancelable,
                              Integer positiveBtn, Integer negativeBtn,
                              DialogInterface.OnClickListener clickListener);

    void showInfoDialog(Integer title, Integer message, boolean cancelable, Integer buttonTxt, DialogInterface.OnDismissListener onDismissListener);
}
