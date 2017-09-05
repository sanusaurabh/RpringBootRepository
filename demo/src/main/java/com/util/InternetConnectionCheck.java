package com.util;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

public class InternetConnectionCheck {
	private   boolean flagConnection;
	
	public   boolean isFlagConnection() {
		return flagConnection;
	}

	public   void maincheckInternet() throws UnknownHostException,
	IOException {
try {
	try {
		URL url = new URL("http://www.google.com");
		System.out.println(url.getHost());
		HttpURLConnection con = (HttpURLConnection) url
				.openConnection();
		con.connect();
		if (con.getResponseCode() == 200){
			flagConnection=true;
			System.out.println("Connection established!!");
		}
	} catch (Exception exception) {
		System.out.println("No Connection");
	}
} catch (Exception e) {
	e.printStackTrace();
}
}
}