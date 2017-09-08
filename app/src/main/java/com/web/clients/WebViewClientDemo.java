package com.web.clients;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.javascript.interfaces.PrinterInterface;

public class WebViewClientDemo extends WebViewClient {
    private WebView mWebView;
    private PrinterInterface printerInterface;

    public WebViewClientDemo(WebView mWebView, PrinterInterface printerInterface) {
        this.mWebView = mWebView;
        this.printerInterface = printerInterface;
    }


    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        mWebView.addJavascriptInterface(printerInterface, "Android");
    }
}
