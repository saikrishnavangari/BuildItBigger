package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNotNull;

/**
 * Created by krrish on 31/12/2016.
 */
@RunWith(AndroidJUnit4.class)
public class EndPointCallerTest {
    private static final String LOG_TAG=EndPointCallerTest.class.getSimpleName();

    @Test
    public void testEndpoint() throws Exception{
        try {
            MainActivity mainActivity = new MainActivity();
            EndPointsCaller EndPointsCaller = new EndPointsCaller(mainActivity);
            EndPointsCaller.execute();
            String result = EndPointsCaller.get();
            assertNotNull(result);
        } catch (Exception e){
            Log.e(LOG_TAG, e.getMessage());
        }
    }

}
