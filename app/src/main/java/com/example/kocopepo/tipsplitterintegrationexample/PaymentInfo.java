package com.example.kocopepo.tipsplitterintegrationexample;

import android.database.Cursor;

import tipsplitter.TipSplitterContract;

/**
 * @author Martin Kocour
 *         created on 10.5.17
 */

public class PaymentInfo {

    Double receipt;
    Double tip;
    String employee;


    public void loadFromCursor(Cursor cursor) {
        receipt = cursor.getDouble(cursor.getColumnIndex(TipSplitterContract.PaymentInfo.COL_AMOUNT));
        tip = cursor.getDouble(cursor.getColumnIndex(TipSplitterContract.PaymentInfo.COL_TIP));
        employee = cursor.getString(cursor.getColumnIndex(TipSplitterContract.PaymentInfo.COL_EMPLOYEE_NAME));
    }
}
