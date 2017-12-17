package com.android.chophi5;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * Created by ILENWABOR DAVID on 13/12/2017.
 */

public class WebViewClientClass extends WebViewClient {

    private ProgressBar dialog;
    private Context context;
    private  WebView webView;
    private View view;

    public WebViewClientClass(ProgressBar dialog, Context context, WebView webView, View view){
        this.dialog = dialog;
        this.context = context;
        this.webView = webView;
        this.view = view;
    }
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return false;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        return false;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        if(view.canGoBack())dialog.setVisibility(View.GONE);
        dialog.setIndeterminate(true);
        dialog.setVisibility(View.VISIBLE);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        dialog.setVisibility(View.GONE);
    }

    @Override
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        super.onReceivedError(view, errorCode, description, failingUrl);
        if (errorCode == ERROR_HOST_LOOKUP){
            webView.setVisibility(View.INVISIBLE);
            //Toast.makeText(context, "Error Loading...\n Check Internet Connection",Toast.LENGTH_SHORT).show();
            Snackbar.make(view, "Error Loading...\n Check Internet Connection", Snackbar.LENGTH_LONG).show();
        }
        else {
            webView.setVisibility(View.INVISIBLE);
            Snackbar.make(view, "Check Internet Connection", Snackbar.LENGTH_LONG).show();
            //Toast.makeText(context, "Check Internet Connection", Toast.LENGTH_SHORT).show();

        }
    }
}
