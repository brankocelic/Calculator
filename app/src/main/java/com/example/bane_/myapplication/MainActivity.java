package com.example.bane_.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tekst; String result; boolean condition; char operation; boolean firstNumber; boolean newCalculation;

    boolean usedEqual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tekst = (TextView) findViewById(R.id.Text);

        result="";  condition = false; firstNumber = true; operation = 'p';  newCalculation=false; usedEqual=true;

       }
    public void onClic(View view)
    {

        usedEqual=false;

        if(condition){ tekst.setText(""); condition=false; }

        if(newCalculation && operation=='p') { result=""; newCalculation=false;}

        Button button = (Button) view;

        if(tekst.getText().toString().equals("0") && button.getText().toString().equals("0")) return;

        else if(tekst.getText().toString().equals("0") && tekst.getText().toString().length() == 1 && !button.getText().toString().equals("0"))
        {
            tekst.setText(button.getText().toString());

            if(firstNumber) result=button.getText().toString();

        }
        else {
            tekst.setText(tekst.getText().toString() + button.getText().toString());

            if(firstNumber) result+=button.getText().toString();
             }

    }

    public void plus(View view)
    {
        if (!result.equals("")) {
            if (!tekst.getText().toString().equals("Error")) doOperation();

            operation = '+';

            if (tekst.getText().toString().equals("Error")) return;

            else if (Double.parseDouble(result) % 1 == 0)
                tekst.setText("" + ((int) Double.parseDouble(result)));

            else tekst.setText(result);

            condition = true;

            firstNumber = false;
        }

    }

    public void minus(View view)
    {
        if (!result.equals("")) {
            if (!tekst.getText().toString().equals("Error")) doOperation();

            operation = '-';

            if (tekst.getText().toString().equals("Error")) return;

            else if (Double.parseDouble(result) % 1 == 0)
                tekst.setText("" + ((int) Double.parseDouble(result)));

            else tekst.setText(result);

            condition = true;

            firstNumber = false;
        }
    }
    public void times(View view)
    {
        if (!result.equals("")) {
            if (!tekst.getText().toString().equals("Error")) doOperation();

            operation = '*';

            if (tekst.getText().toString().equals("Error")) return;

            else if (Double.parseDouble(result) % 1 == 0)
                tekst.setText("" + ((int) Double.parseDouble(result)));

            else tekst.setText(result);

            condition = true;

            firstNumber = false;
        }
    }
    public void divide(View view)
    {
        if (!result.equals("")) {
            if (!tekst.getText().toString().equals("Error")) doOperation();

            operation = '/';

            if (tekst.getText().toString().equals("Error")) return;

            else if (Double.parseDouble(result) % 1 == 0)
                tekst.setText("" + ((int) Double.parseDouble(result)));

            else tekst.setText(result);

            condition = true;

            firstNumber = false;
        }
    }
    public void equal(View view)
    {
        if(tekst.getText().equals("")) return;
        else {
            if (!tekst.getText().toString().equals("Error")) doOperation();

            if (tekst.getText().toString().equals("Error")) return;

            else if (Double.parseDouble(result) % 1 == 0)
                tekst.setText("" + ((int) Double.parseDouble(result)));
            
            else tekst.setText(result);

            condition = true;

            firstNumber = true;

            newCalculation = true;

            operation = 'p';

            usedEqual = true;
        }
    }
    public void point(View view)
    {
        if(!tekst.getText().toString().equals("Error"))
        {
            if(tekst.getText().toString().equals(""))
            {
                tekst.setText("0.");

                if(firstNumber) result+="0.";
            }

            if(firstNumber && !tekst.getText().toString().contains(".")) result+=".";

            if(tekst.getText().toString().contains(".")) return;

            else tekst.setText(tekst.getText().toString() + ".");
        }
    }
    public void del(View view)
    {
        if(!tekst.getText().toString().equals("Error"))
        {
            if(!usedEqual) {
                if (tekst.getText().toString().equals("")) return;
                else
                    tekst.setText(tekst.getText().toString().substring(0, tekst.getText().toString().length() - 1));
            }
        }
    }
    public void delAll(View view)
    {
        tekst.setText("");

        result="";

        condition = true;

        firstNumber = true;

        newCalculation=true;

        operation='p';
    }
    public void doOperation()
    {
        if(!condition)
        {
            if(operation == '+') result = "" + (Double.parseDouble(result) + Double.parseDouble(tekst.getText().toString()) );



            if(operation == '-')  result = "" + (Double.parseDouble(result) - Double.parseDouble(tekst.getText().toString()));


            if(operation == '*') result = "" + (Double.parseDouble(result) * Double.parseDouble(tekst.getText().toString()));

            }

            if(operation == '/')
            {
                if(tekst.getText().toString().equals("0")) { tekst.setText("Error"); result = ""; condition=true; firstNumber = true;}

                else result = "" + (Double.parseDouble(result) / Double.parseDouble(tekst.getText().toString()) );
            }
        }

    }

