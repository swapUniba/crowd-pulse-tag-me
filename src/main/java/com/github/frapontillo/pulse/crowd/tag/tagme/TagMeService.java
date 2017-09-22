package com.github.frapontillo.pulse.crowd.tag.tagme;

import retrofit.http.GET;
import retrofit.http.Query;

/**
 * @author Francesco Pontillo
 */
public interface TagMeService {
    @GET("/tag")
    TagMeResponse tag(@Query("text") String text, @Query("lang") String language);
}
