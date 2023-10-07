package com.example.nasa_project.Utils;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class JsonReader {

    private final Context context;
    private final String jsonPath;

    public JsonReader(Context context, String jsonPath){
        this.context = context;
        this.jsonPath = jsonPath;
    }

    private String loadJSONFromAsset() {
        String json;
        try {
            InputStream is = context.getAssets().open(jsonPath);

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public JSONObject getJsonObject(){
        try {
            return new JSONObject(loadJSONFromAsset());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

}
