package uit.lap2.ex2_18521507.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import uit.lap2.ex2_18521507.Fragment.FragmentCallPhone;
import uit.lap2.ex2_18521507.Fragment.FragmentInternet;
import uit.lap2.ex2_18521507.Fragment.FragmentWebView;
import uit.lap2.ex2_18521507.R;

public class IntentActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_filter);

        // call layout
        bottomNavigation = findViewById(R.id.bottom_navigation);

//        run fragment home first when show UI
        getSupportFragmentManager().beginTransaction().replace(R.id.mainViewPager2, new FragmentCallPhone()).commit();

//        get event when click navigation
        bottomNavigation.setOnItemSelectedListener(onItemSelectedListener);
    }

    @SuppressLint("NonConstantResourceId")
    private final NavigationBarView.OnItemSelectedListener onItemSelectedListener = (item -> {
        Log.d("AAA", "Check select navigation");
        int id = item.getItemId();
        Fragment selectedFragment =  null;
        switch (id) {
            case R.id.home_page:
                selectedFragment = new FragmentCallPhone();
                break;
            case R.id.internet_page:
                selectedFragment = new FragmentInternet();
                break;
            case R.id.google_page:
                selectedFragment = new FragmentWebView();
                break;
        }
        assert selectedFragment != null;
        getSupportFragmentManager().beginTransaction().replace(R.id.mainViewPager2, selectedFragment).commit();
        return true;
    });
}
