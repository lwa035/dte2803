package com.example.client_application;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class DataServicePatients {
    private static DataServicePatients instance;
    private RequestQueue requestQueue;
    private static Context ctx;

    private DataServicePatients(Context context) {
        ctx = context;
        requestQueue = getRequestQueue();
    }

    public static synchronized DataServicePatients getInstance(Context context) {
        if (instance == null) {
            instance = new DataServicePatients(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }
}
