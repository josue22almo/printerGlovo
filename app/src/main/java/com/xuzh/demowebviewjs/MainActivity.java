package com.xuzh.demowebviewjs;

import woyou.aidlservice.jiuiv5.IWoyouService;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;


import com.drivers.MPrinterDriver;

import com.javascript.interfaces.PrinterInterface;
import com.services.MServiceConnection;
import com.web.clients.WebViewClientDemo;


public class MainActivity extends Activity {

	private WebView mWebView;
	private PrinterInterface printerInterface;

	//private String url = "http://stagepartners.glovoapp.com";
	//private String url = "http://localhost:3000";
	private String url = "http://d9bec4d4.ngrok.io";
	private IWoyouService woyouService;
	private MServiceConnection connService = new MServiceConnection(woyouService);


	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initViews();
		initObjects();
		loadWebView();
		printerInterface.pushIntent();

	}

	private void loadWebView() {
		mWebView.setWebChromeClient(new WebChromeClient());
		mWebView.setWebViewClient(new WebViewClientDemo(mWebView, printerInterface));
		mWebView.clearHistory();
		mWebView.clearCache(true);
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
		mWebView.getSettings().setDomStorageEnabled(true);
		mWebView.getSettings().setDefaultTextEncodingName("utf-8");
		mWebView.loadData("", "text/html", null);

		if (Build.VERSION.SDK_INT >= 21) {
			mWebView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
		} else {
			mWebView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
		}
		mWebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
		mWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);

		mWebView.loadUrl(url);
	}


	public void initViews() {
		mWebView = (WebView) findViewById(R.id.wv_view);
	}

	public void initObjects() {
		printerInterface = new PrinterInterface(this);
		printerInterface.setConnService(connService);
	}
}
