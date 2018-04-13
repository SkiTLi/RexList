package com.sktl.rexlist.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.sktl.rexlist.BuildConfig;
import com.sktl.rexlist.R;
import com.sktl.rexlist.adapters.FilmsAdapter;
import com.sktl.rexlist.models.Film;
import com.sktl.rexlist.presenters.ListPresenter;
import com.sktl.rexlist.services.FilmService;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnItemClick;

public class ListActivity extends Activity {
    @InjectView(R.id.version)
    TextView mTextVersion;
    @InjectView(R.id.listViewPosts)
    ListView mListViewPosts;
    FilmsAdapter mFilmsAdapter;
    ListPresenter mListPresenter;
    FilmService mFilmService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ButterKnife.inject(this);
        mTextVersion.setText(BuildConfig.VERSION_NAME);


        ArrayList<Film> dummyFilms = new ArrayList<Film>();

        mFilmsAdapter = new FilmsAdapter(this, dummyFilms);
        mListViewPosts.setAdapter(mFilmsAdapter);

        mFilmService = new FilmService();
        mListPresenter = new ListPresenter(this, mFilmService);

        mListPresenter.loadFilms();

    }

    @OnItemClick(R.id.listViewPosts)
    public void onFilmSelect(int position) {
        Film f = mFilmsAdapter.getItem(position);

        String filmImage = f.getImage();
        String filmName = f.getName();
        String filmName_eng = f.getName_eng();
        String filmPremiere = f.getPremiere();
        String filmDescription = f.getDescription();

        Intent detailIntent = new Intent(this, DetailActivity.class);
        detailIntent.putExtra("filmImage", filmImage);
        detailIntent.putExtra("filmName", filmName);
        detailIntent.putExtra("filmName_eng", filmName_eng);
        detailIntent.putExtra("filmPremiere", filmPremiere);
        detailIntent.putExtra("filmDescription", filmDescription);

        startActivity(detailIntent);
    }

    public void displayFilms(List<Film> posts) {
        mFilmsAdapter.clear();

        mFilmsAdapter.addAll(posts);
        mFilmsAdapter.notifyDataSetInvalidated();

    }

}
