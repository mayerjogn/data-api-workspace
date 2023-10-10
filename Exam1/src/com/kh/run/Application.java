package com.kh.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;



public class Application {

	// serviceKey 값 무죄껀 필요
	public static final String serviceKey ="vndFmS3pdnairl%2F%2BxozXzh%2B4sgJ6xnWtDTZMzS2aPJIPAczaSDH%2FEiwAj68HCYt7HdO3GjM3TGz5lNHDZBtQ%2Fg%3D%3D";
	
	public static void main(String[] args) throws IOException {
		

		// URL
		String url ="https://apis.data.go.kr/1543061/animalShelterSrvc/shelterInfo";
		
		url += "?serviceKey="+ serviceKey;
		url += "&numOfRows=215"; // 한 페이지 결과 수 
		url += "&_type=json"; // 기본값 : xml 이렇게 지정 시 json 방식으로
		
		URL requestUrl = new URL(url);
		HttpURLConnection urlConnection = (HttpURLConnection) requestUrl.openConnection();
		urlConnection.setRequestMethod("GET");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		String line = null;
		
		StringBuffer responseBuffer = new StringBuffer();
		
		while((line = br.readLine())!=null) {
//			System.out.println(line);아래는 JSON 파싱
			responseBuffer.append(line);
		}
		br.close();
		urlConnection.disconnect();
		
		// JSON 파싱 시작
		String responseData = responseBuffer.toString();
		JSONObject jsonResponse = new JSONObject(responseData);
		
		// 구조 파악
		JSONObject response = jsonResponse.getJSONObject("response");
		JSONObject body = response.getJSONObject("body");
		JSONObject items = body.getJSONObject("items");
		JSONArray item = items.optJSONArray("item");
		
//		System.out.println(response);
//		System.out.println(body);
//		System.out.println(item);
		
		for(int i=0; i<item.length(); i++) {
			JSONObject result = item.getJSONObject(i);
//			System.out.println(result);
			String careNm = result.getString("careNm");
			String careAddr = result.getString("careAddr");
			System.out.println("동물보호센터명 : "+careNm);
			System.out.println("주소 : "+careAddr);
			System.out.println();
		}
		
	}

}
