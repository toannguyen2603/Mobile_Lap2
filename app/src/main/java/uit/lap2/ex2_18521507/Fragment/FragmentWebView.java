package uit.lap2.ex2_18521507.Fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import uit.lap2.ex2_18521507.Activity.WebViewClient;
import uit.lap2.ex2_18521507.R;

public class FragmentWebView extends Fragment {
    View view;
    private EditText addressBar;
    private WebView webView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_web_view, container, false);
        Button buttonGo = view.findViewById(R.id.button_go);

        addressBar =view.findViewById(R.id.editText_addressBar);
        webView = view.findViewById(R.id.webView);

//       Customize WebViewClient to control the events in WebView
        webView.setWebViewClient(new WebViewClient(addressBar));

        buttonGo.setOnClickListener((View view) -> goUrl());
        return view;
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void goUrl()  {
        String url = addressBar.getText().toString().trim();
        if(url.isEmpty())  {
            return;
        }
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl(url);
    }

}

