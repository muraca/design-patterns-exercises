package strategy_translate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class GoogleTranslator extends TranslatorStrategy {

	private String from;
	private String to;

	public GoogleTranslator(String from, String to) {
		super(from, to);
	}
	
	@Override
	public String getTranslatedText(String text) {
		String urlStr = null;
		try {
			urlStr = "https://script.google.com/macros/s/AKfycbwq6iC2o50zLArXvra2jkucx8Gs4jTtItJRcFqhzmYLIfZHlDU/exec" +
			        "?q=" + URLEncoder.encode(text, "UTF-8") +
			        "&target=" + to +
			        "&source=" + from;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        URL url = null;
		try {
			url = new URL(urlStr);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = null;
		try {
			con = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String inputLine = null;
        try {
			while ((inputLine = in.readLine()) != null) {
			    response.append(inputLine);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return response.toString();
	}
}
