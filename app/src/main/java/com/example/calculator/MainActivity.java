package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    float inputValue1, inputValue2;
    String operator;
    boolean newNumber;
    static TextView resultDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onNumberBtnClick (View view)
    {
        resultDisplay = findViewById(R.id.txtResult);
        if (resultDisplay.getText().toString().equals("0") || newNumber)
        {
            resultDisplay.setText("");
            newNumber = false;
        }

        switch (view.getId())
        {
            case R.id.btn0:
                resultDisplay.setText(resultDisplay.getText().toString() + "0");
                break;
            case R.id.btn1:
                resultDisplay.setText(resultDisplay.getText().toString() + "1");
                break;
            case R.id.btn2:
                resultDisplay.setText(resultDisplay.getText().toString() + "2");
                break;
            case R.id.btn3:
                resultDisplay.setText(resultDisplay.getText().toString() + "3");
                break;
            case R.id.btn4:
                resultDisplay.setText(resultDisplay.getText().toString() + "4");
                break;
            case R.id.btn5:
                resultDisplay.setText(resultDisplay.getText().toString() + "5");
                break;
            case R.id.btn6:
                resultDisplay.setText(resultDisplay.getText().toString() + "6");
                break;
            case R.id.btn7:
                resultDisplay.setText(resultDisplay.getText().toString() + "7");
                break;
            case R.id.btn8:
                resultDisplay.setText(resultDisplay.getText().toString() + "8");
                break;
            case R.id.btn9:
                resultDisplay.setText(resultDisplay.getText().toString() + "9");
                break;
        }
    }

    public void onOperatorBtnClick (View view)
    {
        newNumber = true;
        switch (view.getId())
        {
            case R.id.btnPlus:
                inputValue1 = Float.parseFloat(resultDisplay.getText().toString());
                operator = "add";
                break;
            case R.id.btnMinus:
                inputValue1 = Float.parseFloat(resultDisplay.getText().toString());
                operator = "subtract";
                break;
            case R.id.btnMultiply:
                inputValue1 = Float.parseFloat(resultDisplay.getText().toString());
                operator = "multiply";
                break;
            case R.id.btnDivide:
                inputValue1 = Float.parseFloat(resultDisplay.getText().toString());
                operator = "divide";
                break;
            case R.id.btnEquals:
                inputValue2 = Float.parseFloat(resultDisplay.getText().toString());
                setResult(calculateResult());
                break;
        }
    }

    public void onMiscBtnClick (View view)
    {
        switch (view.getId())
        {
            case R.id.btnDecimal:
                newNumber = false;
                if(resultDisplay.getText().toString().indexOf('.') == -1)
                    resultDisplay.setText(resultDisplay.getText().toString() + ".");
                break;
            case R.id.btnClear:
                resultDisplay.setText("0");
                inputValue1 = 0;
                inputValue2 = 0;
                operator = "";
                newNumber = false;
                break;
            case R.id.btnPercent:
                newNumber = true;
                setResult(Float.parseFloat(resultDisplay.getText().toString()) / 100);
                break;
            case R.id.btnPlusMinus:
                newNumber = false;
                setResult(Float.parseFloat(resultDisplay.getText().toString()) * -1);
                break;
        }
    }

    private float calculateResult()
    {
        float result;
        switch (operator)
        {
            case "add":
                result = inputValue1 + inputValue2;
                break;
            case "subtract":
                result = inputValue1 - inputValue2;
                break;
            case "multiply":
                result = inputValue1 * inputValue2;
                break;
            case "divide":
                result = inputValue1 / inputValue2;
                break;
            default:
                result = inputValue1;
        }
        return result;
    }

    private void setResult(float result)
    {
        if (result - (int)result == 0)
            resultDisplay.setText(String.valueOf((int)result));
        else
            resultDisplay.setText(String.valueOf(result));
    }
}