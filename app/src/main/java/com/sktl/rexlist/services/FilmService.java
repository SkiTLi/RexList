package com.sktl.rexlist.services;

import com.sktl.rexlist.models.MyPojo;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.http.GET;
import rx.Observable;

/**
 * Created by USER-PC on 13.04.2018.
 */

public class FilmService {

    private static final String FILM_SERVER_URL = "http://www.mocky.io/v2";


    private FilmApi mFilmApi;


    public FilmService() {
        RequestInterceptor requestInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addHeader("SkTL", "app/json");
            }
        };

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(FILM_SERVER_URL)
                .setRequestInterceptor(requestInterceptor)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        mFilmApi = restAdapter.create(FilmApi.class);
    }

    public FilmApi getApi() {

        return mFilmApi;
    }

    public interface FilmApi {

        @GET("/57cffac8260000181e650041")
        public Observable<MyPojo>
        getFilms();

    }

}
