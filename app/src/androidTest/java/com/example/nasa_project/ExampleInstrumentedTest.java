package com.example.nasa_project;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.example.nasa_project.Utils.JsonReader;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void waterPlacesTest() throws JSONException {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        JsonReader reader = new JsonReader(appContext,"data/water-places.json");
        JSONObject object = reader.getJsonObject();
        assertTrue(object.has("marine-places"));
        JSONArray array = (JSONArray) object.get("marine-places");
        JSONObject firstObject = (JSONObject) array.get(0);
        assertTrue(firstObject.has("id"));
        assertTrue(firstObject.has("wave_height"));
        assertTrue(firstObject.has("wave_direction"));
        assertTrue(firstObject.has("wave_period"));
        assertTrue(firstObject.has("wind_waves"));
        assertTrue(firstObject.has("wind"));
        assertTrue(firstObject.has("water_temperature"));
        assertTrue(firstObject.has("ice_coverage"));
        assertTrue(firstObject.has("visibility"));
    }

    @Test
    public void animalsTest() throws JSONException {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        JsonReader reader = new JsonReader(appContext,"data/animals.json");
        JSONObject object = reader.getJsonObject();
        assertTrue(object.has("animals"));
        JSONArray array = (JSONArray) object.get("animals");
        for (int i = 0; i < array.length(); i++) {
            JSONObject arrayObject = (JSONObject) array.get(i);
            assertEquals(i+1,arrayObject.get("id"));
        }
    }
}