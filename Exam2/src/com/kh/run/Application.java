package com.kh.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Application {

	public static final String serviceKey="vndFmS3pdnairl%2F%2BxozXzh%2B4sgJ6xnWtDTZMzS2aPJIPAczaSDH%2FEiwAj68HCYt7HdO3GjM3TGz5lNHDZBtQ%2Fg%3D%3D" ;
	
	public static void main(String[] args) throws IOException {
		
		String url = "http://apis.data.go.kr/1741000/getTsunamiShelter1List";
		
		url += "?serviceKey"+serviceKey;
		url += "&sidoName="+URLEncoder.encode("서울", "UTF-8");
		url += "&numOfRows=2";
		url += "&_type=json";
		
		URL requestUrl = new URL(url);
		HttpURLConnection urlConnection =(HttpURLConnection) requestUrl.openConnection();
		urlConnection.setRequestMethod("GET");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		String line = null;
		
		StringBuffer responseBuffer = new StringBuffer();	
		while((line = br.readLine())!=null) {
//			responseBuffer.append(line);
			System.out.println(line);
		}
		br.close();
		urlConnection.disconnect();
		
	}
}
