package uit.lap2.ex2_18521507.Activity;


import android.graphics.Bitmap;
import android.webkit.WebView;
import android.widget.EditText;


public class WebViewClient extends android.webkit.WebViewClient {

    private EditText addressBar;

    public WebViewClient(EditText addressBar) {
        this.addressBar= addressBar;
    }

    // When you click on any interlink on webview.
    @SuppressWarnings("deprecation")
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        addressBar.setText(url);
        return super.shouldOverrideUrlLoading(view, url);
    }

    // When page loading
    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
    }

    // When page load finish.
    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
    }

    @Override
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
    }

}
