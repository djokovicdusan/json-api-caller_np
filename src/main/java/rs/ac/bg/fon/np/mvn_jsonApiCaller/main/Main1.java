package rs.ac.bg.fon.np.mvn_jsonApiCaller.main;

import rs.ac.bg.fon.np.mvn_jsonApiCaller.domain.Location;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Main1 {
	public static final String BASE_URL = "http://polen.sepa.gov.rs";
	public static final String PARAM = "1";
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try {
			URL url = new URL(BASE_URL + "/api/opendata/locations/?id=" + PARAM);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("GET");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

			Gson gson = new GsonBuilder().create();
			
			JsonArray jsonResult = gson.fromJson(in, JsonArray.class);
			JsonObject myObject = (JsonObject) jsonResult.get(0);
			Location myLocation = new Location();
			//UserIdentifier userIdentifier = gson.fromJson(jsonResponse.getJSONObject("userIdentifier").toString(), UserIdentifier.class);
			myLocation = gson.fromJson(myObject, Location.class);
			
			in.close();
			
			
			System.out.println(myLocation);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
