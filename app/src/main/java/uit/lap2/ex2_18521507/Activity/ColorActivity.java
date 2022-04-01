package uit.lap2.ex2_18521507.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import uit.lap2.ex2_18521507.R;

public class ColorActivity extends AppCompatActivity {
    RadioButton radio_red, radio_green, radio_blue, radio_gray;
    View view_color;
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_color);

        //  hide actionBar
        Objects.requireNonNull(getSupportActionBar()).hide();

        radio_red = findViewById(R.id.radio_red);
        radio_green = findViewById(R.id.radio_green);
        radio_blue = findViewById(R.id.radio_blue);
        radio_gray = findViewById(R.id.radio_gray);

        view_color = findViewById(R.id.view_color);

        radio_red.setOnClickListener((View view) -> view_color.setBackgroundResource(R.color.red));
        radio_green.setOnClickListener((View view) -> view_color.setBackgroundResource(R.color.green));
        radio_blue.setOnClickListener((View view) -> view_color.setBackgroundResource(R.color.blue));
        radio_gray.setOnClickListener((View view) -> view_color.setBackgroundResource(R.color.gray));
    }
}
