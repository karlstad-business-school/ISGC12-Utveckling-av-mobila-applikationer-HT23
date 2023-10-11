package com.example.exempel_api_json_volley;

import org.json.JSONObject;

public interface VolleyCallback <T>{
    public void onSuccess(JSONObject object);
    public void onFailure(Exception e);
}
