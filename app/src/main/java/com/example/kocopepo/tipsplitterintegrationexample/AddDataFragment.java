package com.example.kocopepo.tipsplitterintegrationexample;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import tipsplitter.TipSplitterContract.PaymentInfo;

/**
 * @author Martin Kocour
 *         created on 13.4.17
 */

public class AddDataFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {


    String[] employees;
    String selectedEmployee;
    long[] ids;
    long employeeId;

    EditText tip;
    EditText spending;
    EditText receipt;
    Spinner employee;

    public static AddDataFragment newInstance() {

        Bundle args = new Bundle();

        AddDataFragment fragment = new AddDataFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        employees = new String[] {"Martin", "Dusan", "Andrej", "Noro", "Jano", "Sebo", "Mirjana"};
        ids = new long[] {1L, 2L, 3L, 4L, 5L, 6L, 7L};
        selectedEmployee = employees[0];
        employeeId = ids[0];
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.add_data, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item,
                employees);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        employee = (Spinner) view.findViewById(R.id.spinner);
        employee.setAdapter(adapter);
        employee.setOnItemSelectedListener(this);

        receipt = (EditText) view.findViewById(R.id.receipt);
        spending = (EditText) view.findViewById(R.id.spending);
        tip = (EditText) view.findViewById(R.id.tip);
        view.findViewById(R.id.done).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // On done clicked
        ContentValues contentValues = PaymentInfo.createDefault(true);
        contentValues.put(PaymentInfo.COL_AMOUNT, receipt.getText().toString());
        contentValues.put(PaymentInfo.COL_SPENDING, spending.getText().toString());
        contentValues.put(PaymentInfo.COL_TIP, tip.getText().toString());
        contentValues.put(PaymentInfo.COL_EMPLOYEE_NAME, selectedEmployee);
        contentValues.put(PaymentInfo.COL_EMPLOYEE_ID, employeeId);

        ContentResolver cr = getContext().getContentResolver();
        cr.insert(Uri.parse(PaymentInfo.URI), contentValues);

        clear();
    }

    private void clear() {
        employee.setSelection(0, true);
        selectedEmployee = employees[0];
        employeeId = ids[0];
        tip.setText("");
        spending.setText("");
        receipt.setText("");
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedEmployee = employees[position];
        employeeId = ids[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
