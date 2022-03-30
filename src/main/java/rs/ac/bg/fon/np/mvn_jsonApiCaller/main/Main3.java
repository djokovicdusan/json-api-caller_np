package rs.ac.bg.fon.np.mvn_jsonApiCaller.main;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import rs.ac.bg.fon.np.mvn_jsonApiCaller.domain.Location;

public class Main3 {

	public static void main(String[] args) {

		try (FileReader in = new FileReader("niz_objekata.json")) {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();

			List<Location> locations = Arrays.asList(gson.fromJson(in, Location[].class));

			for (Location l : locations) {
				System.out.println(l);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
