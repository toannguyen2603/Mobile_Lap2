package uit.lap2.ex2_18521507.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import uit.lap2.ex2_18521507.R;

public class FragmentCallPhone extends Fragment {
    Button btn_call, btn_contact, btn_send;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_call_phone, container, false);

        btn_call = view.findViewById(R.id.btn_call);
        btn_contact = view.findViewById(R.id.btn_contact);
        btn_send = view.findViewById(R.id.btn_send);

//        intent call phone
        btn_call.setOnClickListener((View view) -> {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:" + "8802177690"));//change the number
            startActivity(callIntent);
        });

//        intent send SMS
        btn_contact.setOnClickListener((View view) -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(android.content.Intent.EXTRA_TEXT,"News for you!");
            startActivity(intent);
        });

//        intent google maps
        btn_send.setOnClickListener((View view) -> {
            String url = "https://www.google.com/maps/place/Tr%C6%B0%E1%BB%9Dng+%C4%90%E1%BA%A1i+h%E1%BB%8Dc+C%C3%B4ng+ngh%E1%BB%87+Th%C3%B4ng+tin+-+%C4%90HQG+TP.HCM/@10.8700089,106.8008654,17z/data=!3m1!4b1!4m5!3m4!1s0x317527587e9ad5bf:0xafa66f9c8be3c91!8m2!3d10.8700089!4d106.8030541?hl=vi-VN";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        });
        return view;

    }
}
