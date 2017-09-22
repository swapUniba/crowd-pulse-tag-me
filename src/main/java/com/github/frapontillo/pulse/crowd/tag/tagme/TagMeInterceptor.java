package com.github.frapontillo.pulse.crowd.tag.tagme;

import com.github.frapontillo.pulse.util.PulseLogger;
import retrofit.RequestInterceptor;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author Francesco Pontillo
 */
public class TagMeInterceptor implements RequestInterceptor {
    private static final String PROP_API_KEY = "tagme.key";
    private static String API_KEY;

    static {
        InputStream configInput = TagMeInterceptor.class.getClassLoader().getResourceAsStream("tagme.properties");
        Properties prop = new Properties();

        try {
            prop.load(configInput);
            API_KEY = prop.getProperty(PROP_API_KEY);
        } catch (Exception exception) {
            PulseLogger.getLogger(TagMeInterceptor.class).error("Error while loading TagMe configuration", exception);
            API_KEY = "";
        }
    }

    @Override public void intercept(RequestFacade request) {
        request.addEncodedQueryParam("gcube-token", API_KEY);
    }
}
