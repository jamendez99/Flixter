package com.example.j053.flixter.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Config {
    // base url for loading images
    String imageBaseUrl;
    // poster size
    String posterSize;
    // backdrop size
    String backdropSize;

    public Config(JSONObject object) throws JSONException {
        JSONObject images = object.getJSONObject("images");
        // get the image base url
        imageBaseUrl = images.getString("secure_base_url");
        // get the poster size
        JSONArray posterSizeOptions = images.getJSONArray("poster_sizes");
        // use the option at index 3, or w342 as a fallback
        posterSize = posterSizeOptions.optString(3, "w342");
        // get the backdrop size
        JSONArray backdropSizeOptions = images.getJSONArray("backdrop_sizes");
        // use the option at index 1, or w780 as a fallback
        backdropSize = backdropSizeOptions.optString(1, "w780");
    }

    // helper function that creates urls
    public String getImageUrl(String size, String path) {
        return String.format("%s%s%s", imageBaseUrl, size, path);
    }

    public String getImageBaseUrl() {
        return imageBaseUrl;
    }

    public String getPosterSize() {
        return posterSize;
    }

    public String getBackdropSize() {
        return backdropSize;
    }
}
