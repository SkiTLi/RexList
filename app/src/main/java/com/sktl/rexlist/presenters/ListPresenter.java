package com.sktl.rexlist.presenters;


import android.util.Log;


import com.sktl.rexlist.models.Film;

import com.sktl.rexlist.models.MyPojo;
import com.sktl.rexlist.services.FilmService;
import com.sktl.rexlist.views.ListActivity;


import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by USER-PC on 08.03.2018.
 */

public class ListPresenter {

    ListActivity mListActivity;
    FilmService mFilmService;

    public ListPresenter(ListActivity view, FilmService filmService) {
        mListActivity = view;
        this.mFilmService = filmService;
    }


    public void loadFilms() {
        mFilmService.getApi()
                .getFilms()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyPojo>() {
                    @Override
                    public void onCompleted() {
                        Log.d("sss", "class ListPresenter, method loadTextPosts() .." +
                                " onCompleted()");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("sss", "class ListPresenter, method loadTextPosts() .." +
                                " onError(Throwable e) .." +
                                " e=" + e);
                    }

                    @Override
                    public void onNext(MyPojo myPojo) {
                        mListActivity.displayFilms(myPojo.list);
                    }
                });
    }
}
