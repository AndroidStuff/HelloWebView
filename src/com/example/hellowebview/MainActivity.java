package com.example.hellowebview;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final WebView myWebView = (WebView) findViewById(R.id.helloWebView);
		//Without this line, the default browser loads the page instead of embedded-web-view-client
		myWebView.setWebViewClient(new WebViewClient());
		//Web pages don't load if Javascript is not enabled
		myWebView.getSettings().setJavaScriptEnabled(true);
		//Load Web page..
		myWebView.loadUrl("http://www.google.com/");
		
		final EditText editTextUrl = (EditText) findViewById(R.id.urlText);
		Button goToURL = (Button) findViewById(R.id.hitURL);
		
		goToURL.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				String url = editTextUrl.getText().toString();
				if( ! url.startsWith("http://") ) {
					url = "http://" + url;
				}
				Log.i("URL: ", url);
				myWebView.loadUrl(url);
			}
		});
	}
}
