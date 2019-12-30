package com.example.myarchitecture.network.flickr;

import com.example.myarchitecture.data.photo.model.ApiResult;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FlickrPhotoApiService {

    @GET("services/rest")
    Single<ApiResult> getRecent(
            @Query("method") String method,
            @Query("api_key") String apiKey,
            @Query("format") String format,
            @Query("nojsoncallback") String noJsonCallback,
            @Query("per_page") int perPage,
            @Query("page") int pageNumber,
            @Query("extras") String extras);

    @GET("services/rest")
    Single<ApiResult> getRecentText(
            @Query("method") String method,
            @Query("api_key") String apiKey,
            @Query("format") String format,
            @Query("nojsoncallback") String noJsonCallback,
            @Query("per_page") int perPage,
            @Query("page") int pageNumber,
            @Query("text") String text,
            @Query("extras") String extras);
}
