package rs.ac.bg.fon.np.mvn_jsonApiCaller.main;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import rs.ac.bg.fon.np.mvn_jsonApiCaller.domain.Location;

public class Main2 {
	public static final String BASE_URL = "http://polen.sepa.gov.rs";

	public static void main(String[] args) throws IOException, JsonSyntaxException, JsonIOException {
		// TODO Auto-generated method stub
		try {
			URL url = new URL(BASE_URL + "/api/opendata/locations/");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			con.setRequestMethod("GET");

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

			Gson gson = new GsonBuilder().setPrettyPrinting().create();

			JsonArray jsonResult = gson.fromJson(in, JsonArray.class);

			List<Location> locations = new ArrayList<>();
			if (jsonResult != null) {
				for (int i = 0; i < jsonResult.size(); i++) {
					JsonObject myObject = (JsonObject) jsonResult.get(i);
					Location myLocation = gson.fromJson(myObject, Location.class);
					locations.add(myLocation);
				}
			}
			for (Location l : locations) {
				System.out.println(l);

			}

			in.close();
			try (PrintWriter out = new PrintWriter(new FileWriter("niz_objekata.json"))) {

				out.print(gson.toJson(locations));
			} catch (IOException e) {
				e.printStackTrace();
			}

//			System.out.println(myLocation);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
