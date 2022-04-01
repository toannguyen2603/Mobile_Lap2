package uit.lap2.ex2_18521507.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import uit.lap2.ex2_18521507.R;

public class ViewContactInfoActivity extends AppCompatActivity {

    TextView text_name, text_email, text_project;
    Button btn_ViewFinish;
    String name, email, project;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_get_contact_info);

        text_name = findViewById(R.id.text_name);
        text_email = findViewById(R.id.text_email);
        text_project = findViewById(R.id.text_project);

        btn_ViewFinish = findViewById(R.id.btn_ViewFinish);
        getBundle();

        btn_ViewFinish.setOnClickListener((View view) -> {
            finish();
        });

//        hide actionBar
        getSupportActionBar().hide();
        statusBarColor();
    }

    private void getBundle() {
        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("nameKey");
        email = bundle.getString("emailKey");
        project = bundle.getString("projectKey");

        text_name.setText(name);
        text_email.setText(email);
        text_project.setText(project);
    }

    //    change color status bar
    public final void statusBarColor(){
        getWindow().setStatusBarColor(getResources().getColor(R.color.blue,getTheme()));
    }
}
