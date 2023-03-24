package com.indiafrominside.population.populationAPI.service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import java.io.IOException;
@Service
public class PopulationService {

    private final String apiKey = "ef6192a2e6msha282b3785fd8e59p111408jsnd8df5c77c593";

    public int getPopulation(String city) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://wft-geo-db.p.rapidapi.com/v1/geo/cities?name=" + city)
                .get()
                .addHeader("X-RapidAPI-Key", apiKey)
                .addHeader("X-RapidAPI-Host", "wft-geo-db.p.rapidapi.com")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                JSONObject json = new JSONObject(responseBody);
                JSONArray data = json.getJSONArray("data");
                if (data.length() > 0) {
                    System.out.println(data);
                    JSONObject cityData = data.getJSONObject(0);
                    return cityData.getInt("population");
                }
            }

            System.out.println(city +" " + response);
            return 0;
        }
    }
}
