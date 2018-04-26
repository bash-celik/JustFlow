package com.gengar.justflow.network;


import com.gengar.justflow.pojo.com.gengar.justflow.Search;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("/search/artist/")
    Call<Search> getSearchArtist(@Query("q") String q,
                                 @Query("output") String output
                                 );


}
