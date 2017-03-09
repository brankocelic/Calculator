package com.example.bane_.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tekst;
    String result;
    boolean condition;
    char operation;
    boolean firstNumber;
    boolean newCalculation;
    char lastOperation;
    boolean usedEqual;
    String lastNubmer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tekst = (TextView) findViewById(R.id.Text);

        lastNubmer = "";
        result = "";
        condition = false;
        firstNumber = true;
        operation = 'p';
        lastOperation = 'l';
        newCalculation = false;
        usedEqual = true;

    }

    public void onClic(View view) {

        usedEqual = false;

        if (condition) { //it is used to restart TextView after using some operations;
            tekst.setText("");
            condition = false;
        }

        if (newCalculation && operation == 'p') { //it is used to restart a result afrer using a equal sign;
            result = "";
            newCalculation = false;
        }

        Button button = (Button) view;

        if (tekst.getText().toString().equals("0") && button.getText().toString().equals("0"))
            return; //if a TextView is a zero and we click on zero button dont do anything;

        else if (tekst.getText().toString().equals("0") && tekst.getText().toString().length() == 1 && !button.getText().toString().equals("0")) {
            tekst.setText(button.getText().toString()); //if a TextView is equal to zero and we click on other button change;
        } else {                                        //TextView to that buttons name;
            tekst.setText(tekst.getText().toString() + button.getText().toString()); //in all other cases just add button text on TextView;
        }

    }

    public void plus(View view) {
        if (!tekst.getText().equals("")) {
            if (tekst.getText().equals(("-"))) return;

            if (firstNumber && !condition) result += tekst.getText().toString();

            if (!tekst.getText().toString().equals("Error")) doOperation();

            operation = '+';

            if (tekst.getText().toString().equals("Error")) return;

            else if (Double.parseDouble(result) % 1 == 0)
                tekst.setText(String.format("%.0f", Double.parseDouble(result)));

            else tekst.setText(result);

            condition = true;

            firstNumber = false;
        }

    }

    public void minus(View view) {
        if (!tekst.getText().equals("")) {
            if (tekst.getText().equals(("-"))) return;

            if (firstNumber && !condition) result = tekst.getText().toString();

            if (!tekst.getText().toString().equals("Error")) doOperation();

            operation = '-';

            if (tekst.getText().toString().equals("Error")) return;

            else if (Double.parseDouble(result) % 1 == 0)
                tekst.setText(String.format("%.0f", Double.parseDouble(result)));

            else tekst.setText(result);

            condition = true;

            firstNumber = false;
        } else {
            tekst.setText("-");

            condition = false;
        }
    }

    public void times(View view) {
        if (!tekst.getText().equals("")) {
            if (tekst.getText().equals(("-"))) return;

            if (firstNumber && !condition) result += tekst.getText().toString();

            if (!tekst.getText().toString().equals("Error")) doOperation();

            operation = '*';

            if (tekst.getText().toString().equals("Error")) return;

            else if (Double.parseDouble(result) % 1 == 0)
                tekst.setText(String.format("%.0f", Double.parseDouble(result)));

            else tekst.setText(result);

            condition = true;

            firstNumber = false;
        }
    }

    public void divide(View view) {
        if (!tekst.getText().equals("")) {
            if (tekst.getText().equals(("-"))) return;

            if (firstNumber && !condition) result = tekst.getText().toString();

            if (!tekst.getText().toString().equals("Error")) doOperation();

            operation = '/';

            if (tekst.getText().toString().equals("Error")) return;

            else if (Double.parseDouble(result) % 1 == 0)
                tekst.setText(String.format("%.0f", Double.parseDouble(result)));

            else tekst.setText(result);

            condition = true;

            firstNumber = false;
        }
    }

    public void equal(View view) {
        if (!tekst.getText().equals("")) {

            if (tekst.getText().equals("-")) return;

            if (usedEqual) {
                if (tekst.getText().toString().equals("Error")) return;

                else lastOperation();

                if (Double.parseDouble(result) % 1 == 0)
                    tekst.setText(String.format("%.0f", Double.parseDouble(result)));

                else tekst.setText(result);

                return;
            }

            lastNubmer = tekst.getText().toString();

            if (firstNumber) result = tekst.getText().toString();

            if (!tekst.getText().toString().equals("Error")) doOperation();

            if (tekst.getText().toString().equals("Error")) {
                condition = true;
                operation = 'p';
                firstNumber = true;
                newCalculation = true;
                usedEqual = true;
                return;
            } else if (Double.parseDouble(result) % 1 == 0)
                tekst.setText(String.format("%.0f", Double.parseDouble(result)));

            else tekst.setText(result);

            condition = true;

            firstNumber = true;

            newCalculation = true;

            lastOperation = operation;

            operation = 'p';

            usedEqual = true;
        }
    }

    public void point(View view) {
        if (!tekst.getText().toString().equals("Error")) {
            if (tekst.getText().equals(("-"))) {
                tekst.setText(tekst.getText().toString() + "0.");
                return;
            }

            if (usedEqual) {
                tekst.setText("0.");
                condition = false;
            }

            if (operation != 'p' && !tekst.getText().toString().contains(".") && condition) {
                tekst.setText("0.");
                condition = false;
            }

            if (tekst.getText().toString().equals("")) tekst.setText("0.");

            if (tekst.getText().toString().contains(".")) return;

            else tekst.setText(tekst.getText().toString() + ".");

        } else {
            tekst.setText("");

            tekst.setText("0.");

            condition = false;

        }
    }

    public void del(View view) {
        if (!tekst.getText().toString().equals("Error")) {
            if (!usedEqual) {
                if (tekst.getText().toString().equals("")) return;
                else
                    tekst.setText(tekst.getText().toString().substring(0, tekst.getText().toString().length() - 1));
            } else {
                tekst.setText("");
            }
        } else {
            tekst.setText("");
        }
    }

    public void delAll(View view) {
        tekst.setText("");

        result = "";

        firstNumber = true;

        operation = 'p';
    }

    public void doOperation() {
        if (!condition) {
            if (operation == '+')
                result = "" + (Double.parseDouble(result) + Double.parseDouble(tekst.getText().toString()));


            if (operation == '-')
                result = "" + (Double.parseDouble(result) - Double.parseDouble(tekst.getText().toString()));


            if (operation == '*')
                result = "" + (Double.parseDouble(result) * Double.parseDouble(tekst.getText().toString()));

            if (operation == '/') {
                if (tekst.getText().toString().equals("0")) {
                    tekst.setText("Error");
                    condition = true;
                    firstNumber = true;
                    operation = 'p';
                    usedEqual = true;
                } else
                    result = "" + (Double.parseDouble(result) / Double.parseDouble(tekst.getText().toString()));
            }
        }
    }

    public void lastOperation() {
        if (lastOperation == '+')
            result = "" + (Double.parseDouble(result) + Double.parseDouble(lastNubmer));


        if (lastOperation == '-')
            result = "" + (Double.parseDouble(result) - Double.parseDouble(lastNubmer));


        if (lastOperation == '*')
            result = "" + (Double.parseDouble(result) * Double.parseDouble(lastNubmer));

        if (lastOperation == '/') {
            // if (tekst.getText().toString().equals("0")) {
               /*     tekst.setText("Error");
                    condition = true;
                    firstNumber = true;
                    operation = 'p';
                    usedEqual = true;
                } else*/
            result = "" + (Double.parseDouble(result) / Double.parseDouble(lastNubmer));
        }
    }


}

