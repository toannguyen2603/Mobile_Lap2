package uit.lap2.ex2_18521507.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import uit.lap2.ex2_18521507.R;

public class CalculatorActivity extends AppCompatActivity {
    TextView InputText, OutputResult;
    Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, btnMinus, btnPercent, btnDivisor, btnMultiple, btnPlus, btnDot;
    Button btnAc, btnEqual;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        getLayout();
        getEvent();
        statusBarColor();
    }
    public void getLayout() {
        b0 = findViewById(R.id.btn_Zero);
        b1 = findViewById(R.id.btn_One);
        b2 =findViewById(R.id.btn_Two);
        b3 =findViewById(R.id.btn_Three);
        b4 =findViewById(R.id.btn_Four);
        b5 =findViewById(R.id.btn_Five);
        b6 =findViewById(R.id.btn_Six);
        b7 =findViewById(R.id.btn_Seven);
        b8 =findViewById(R.id.btn_Eight);
        b9 =findViewById(R.id.btn_Nine);
        btnMinus =findViewById(R.id.btn_Minus);
        btnMultiple =findViewById(R.id.btn_Multiply);
        btnPlus =findViewById(R.id.btn_Plus);
        btnDot =findViewById(R.id.btn_Dot);
        btnDivisor =findViewById(R.id.btn_Divide);
        btnAc =findViewById(R.id.btn_Clear);
        btnEqual =findViewById(R.id.btn_Equal);
        btnPercent = findViewById(R.id.btn_Percent);
        InputText = findViewById(R.id.textInput);
        OutputResult = findViewById(R.id.textResult);
    }

    //    method
    public void getTextInput(Button x ,String n) {
        x.setOnClickListener((View view) -> InputText.setText(InputText.getText() + n));
    }
    //    get listener
    public  void getEvent(){

        getTextInput(b0,"0");
        getTextInput(b1,"1");
        getTextInput(b2,"2");
        getTextInput(b3,"3");
        getTextInput(b4,"4");
        getTextInput(b5,"5");
        getTextInput(b6,"6");
        getTextInput(b7,"7");
        getTextInput(b8,"8");
        getTextInput(b9,"9");
        getTextInput(btnPlus,"+");
        getTextInput(btnMinus,"-");
        getTextInput(btnMultiple,"×");
        getTextInput(btnDivisor,"÷");

        btnDot.setOnClickListener((View view) -> {
            String val = InputText.getText().toString();
            if(val.isEmpty()) {
                String dot = "0" + ".";
                InputText.setText(dot);
            } else {
                InputText.setText(InputText.getText() + ".");
            }
        });

        btnAc.setOnClickListener((View view) -> {
            InputText.setText("");
            OutputResult.setText("0");
        });

        btnEqual.setOnClickListener((View view) -> {
            String val = InputText.getText().toString();
            if (val.isEmpty()) {
                return;
            }
            String replace = val.replace('÷','/').replace('×','*');
            double result = eval(replace);
            OutputResult.setText(String.valueOf(result));
            InputText.setText(val);

        });
    }

    //eval function
    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }
            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }
            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }
            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
               if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }
                return x;
            }
        }.parse();
    }

    public final void statusBarColor(){
        getWindow().setStatusBarColor(getResources().getColor(R.color.buttonFuncDark,getTheme()));
    }

}
