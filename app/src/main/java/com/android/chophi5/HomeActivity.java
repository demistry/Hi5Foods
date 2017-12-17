package com.android.chophi5;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

public class HomeActivity extends AppCompatActivity {

    private WebView webview;
    private WebSettings webSettings;
    private ProgressBar progressBar;
    public static final String ROOT_URL = "http://chop.hi5group.org.ng/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        webview = (WebView) findViewById(R.id.web_view);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);

        webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webview.setWebViewClient(new WebViewClientClass(progressBar, this, webview, findViewById(R.id.frame_root)));

        webview.loadUrl(ROOT_URL);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.webview.canGoBack()){
            this.webview.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
