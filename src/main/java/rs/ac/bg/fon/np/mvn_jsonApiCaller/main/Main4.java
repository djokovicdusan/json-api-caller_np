package rs.ac.bg.fon.np.mvn_jsonApiCaller.main;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class Main4 {

	public static void main(String[] args) {

		JsonObject jsonObjectLocation = new JsonObject();

		jsonObjectLocation.addProperty("description", "Fon");
		jsonObjectLocation.addProperty("id", 1606);
		jsonObjectLocation.addProperty("name", "Beograd - Vozdovac");

		try (FileWriter out = new FileWriter("rucni_upis.json")) {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();

			out.write(gson.toJson(jsonObjectLocation));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
