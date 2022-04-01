package uit.lap2.ex2_18521507.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import uit.lap2.ex2_18521507.R;

public class InformationActivity extends AppCompatActivity {
    EditText edit_email, edit_name, edit_project;
    Button btn_ShowContactInfo;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);

//        hide actionBar
        getSupportActionBar().hide();
        statusBarColor();

        edit_email = findViewById(R.id.edit_email);
        edit_name = findViewById(R.id.edit_name);
        edit_project = findViewById(R.id.edit_project);

        btn_ShowContactInfo = findViewById(R.id.btn_ViewInfo);

        btn_ShowContactInfo.setOnClickListener((View view) -> {
            Intent intent = new Intent(getApplicationContext(), ViewContactInfoActivity.class);
            Bundle i = putBundle();
            intent.putExtras(i);
            startActivity(intent);
        });
    }

    private Bundle putBundle(){
        Bundle bundle = new Bundle();
        bundle.putString("nameKey", edit_name.getText().toString());
        bundle.putString("emailKey", edit_email.getText().toString());
        bundle.putString("projectKey", edit_project.getText().toString());

        return bundle;
    }
//    change color status bar
    public final void statusBarColor(){
        getWindow().setStatusBarColor(getResources().getColor(R.color.blue,getTheme()));
    }
}
