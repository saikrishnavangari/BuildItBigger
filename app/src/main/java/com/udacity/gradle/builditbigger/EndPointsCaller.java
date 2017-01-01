package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.jokesupplier.backend.myApi.MyApi;

import java.io.IOException;

import sai.com.jokedisplay.JokeDisplay;

/**
 * Created by krrish on 29/12/2016.
 */

public class EndPointsCaller extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;

    private Context mContext;

    public EndPointsCaller (Context context){
        mContext = context;
    }

    @Override
    protected String doInBackground(Void... params){
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("https://buildbig-154116.appspot.com/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        try {
            return myApiService.getJokes().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {

        Intent intent = new Intent(mContext, JokeDisplay.class);

        intent.putExtra(JokeDisplay.JOKE_KEY, result);
        mContext.startActivity(intent);
    }
}
