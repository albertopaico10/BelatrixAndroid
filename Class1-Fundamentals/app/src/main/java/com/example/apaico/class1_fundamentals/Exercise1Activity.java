package com.example.apaico.class1_fundamentals;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import java.util.ArrayList;
import java.util.List;

public class Exercise1Activity extends AppCompatActivity implements OnItemSelectedListener {

    private EditText etMonth;
    private TextView tvMonthValue;

    private Spinner spOperation;
    private int positionSpinner;
    private EditText etNumber1;
    private EditText etNumber2;
    private TextView tvResult;

    private EditText etNumberLines;
    private TextView tvShowLines;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise1);

        etMonth = (EditText)findViewById(R.id.etMonthNumber);
        tvMonthValue = (TextView)findViewById(R.id.textView);
        spOperation = (Spinner)findViewById(R.id.spOperation);

        etNumber1 = (EditText)findViewById(R.id.etNumber1);
        etNumber2 = (EditText)findViewById(R.id.etNumber2);
        tvResult = (TextView)findViewById(R.id.tvResult);

        etNumberLines = (EditText)findViewById(R.id.etNumberLines);
        tvShowLines = (TextView)findViewById(R.id.tvShowLines);

        spOperation.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("-- Elige una Operacion --");
        categories.add("Suma");
        categories.add("Resta");
        categories.add("Multiplicacion");
        categories.add("Division");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spOperation.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        positionSpinner = position;
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        tvResult.setText("");
        // Showing selected spinner item
        //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void processLines(View view){
        String value="";
        for (int i=0;i<Integer.parseInt(etNumberLines.getText().toString());i++){
            value+="Linea N : "+i+" \n";
        }
        tvShowLines.setText(value);
    }

    public void calculateOperation(View view){
        if(positionSpinner == 0){
            Toast.makeText(this, "Tiene que elegir una operador", Toast.LENGTH_LONG).show();
        }else{
            double result=0;
            switch (positionSpinner){
                case 1:
                    result=Integer.parseInt(etNumber1.getText().toString())+Integer.parseInt(etNumber2.getText().toString());
                    tvResult.setText(String.valueOf(result));
                    break;
                case 2:
                    result=Integer.parseInt(etNumber1.getText().toString())-Integer.parseInt(etNumber2.getText().toString());
                    tvResult.setText(String.valueOf(result));
                    break;
                case 3:
                    result=Integer.parseInt(etNumber1.getText().toString())*Integer.parseInt(etNumber2.getText().toString());
                    tvResult.setText(String.valueOf(result));
                    break;
                case 4:
                    result=Integer.parseInt(etNumber1.getText().toString())/Integer.parseInt(etNumber2.getText().toString());
                    tvResult.setText(String.valueOf(result));
                    break;
            }
        }
    }

    public void showMonth(View view){
        System.out.print("Entrooooo!!!");
        //Toast.makeText(this,"Emtro", Toast.LENGTH_LONG).show();
        tvMonthValue.setText("");
        switch (etMonth.getText().toString()){
            case "1":
                tvMonthValue.setText(" Enero");
                break;
            case "2":
                tvMonthValue.setText(" Febrero");
                break;
            case "3":
                tvMonthValue.setText(" Marzo");
                break;
            case "4":
                tvMonthValue.setText(" Abril");
                break;
            case "5":
                tvMonthValue.setText(" Mayo");
                break;
            case "6":
                tvMonthValue.setText(" Junio");
                break;
            case "7":
                tvMonthValue.setText(" Julio");
                break;
            case "8":
                tvMonthValue.setText(" Agosto");
                break;
            case "9":
                tvMonthValue.setText(" Septiembre");
                break;
            case "10":
                tvMonthValue.setText(" Octubre");
                break;
            case "11":
                tvMonthValue.setText(" Noviembre");
                break;
            case "12":
                tvMonthValue.setText(" Diciembre");
                break;
            default:
                tvMonthValue.setText("No es un valor correcto");
        }
    }
}
