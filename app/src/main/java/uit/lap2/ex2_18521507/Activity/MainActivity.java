package uit.lap2.ex2_18521507.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import uit.lap2.ex2_18521507.R;


public class MainActivity extends AppCompatActivity {

    Button btnMenu, btnColor, btnCalculator, btnInfo, btnIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getID();

        btnMenu.setOnClickListener((View view) -> RedirectToMenu());
        btnColor.setOnClickListener((View view) -> RedirectToChangeColor());
        btnCalculator.setOnClickListener((View view) -> RedirectToCalculator());
        btnInfo.setOnClickListener((View view) -> RedirectToContactInfo());
        btnIntent.setOnClickListener((View view) -> RedirectToIntent());
//        hide actionBar
        getSupportActionBar().hide();
    }

    private void RedirectToIntent() {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, IntentActivity.class);
        startActivity(intent);
    }

    private void RedirectToContactInfo() {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, InformationActivity.class);
        startActivity(intent);
    }

    private void RedirectToCalculator() {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, CalculatorActivity.class);
        startActivity(intent);
    }

    private void RedirectToChangeColor() {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ColorActivity.class);
        startActivity(intent);
    }
    private void RedirectToMenu() {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, MenuActivity.class);
        startActivity(intent);
    }

    private void getID(){
        btnMenu = findViewById(R.id.btnMenu);
        btnColor = findViewById(R.id.btnColor);
        btnCalculator = findViewById(R.id.btnCalculator);
        btnInfo = findViewById(R.id.btnContact);
        btnIntent = findViewById(R.id.btnIntent);
    }





}