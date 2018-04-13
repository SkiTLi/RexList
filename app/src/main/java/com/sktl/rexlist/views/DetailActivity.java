package com.sktl.rexlist.views;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.sktl.rexlist.R;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by USER-PC on 05.03.2018.
 */


public class DetailActivity extends Activity {

    @InjectView(R.id.textViewName)
    TextView mTextViewName;

    @InjectView(R.id.textViewNameEng)
    TextView mTextViewNameEng;

    @InjectView(R.id.textViewPremiere)
    TextView mTextViewPremiere;

    @InjectView(R.id.imageViewPhoto)
    ImageView mImageViewPhotos;


    @InjectView(R.id.textViewDescription)
    TextView mTextViewDescription;

    protected String mFilmImage;
    protected String mFilmName;
    protected String mFilmName_eng;
    protected String mFilmPremiere;
    protected String mFilmDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.inject(this);

        mFilmImage = getIntent().getStringExtra("filmImage");
        mFilmName = getIntent().getStringExtra("filmName");
        mFilmName_eng = getIntent().getStringExtra("filmName_eng");
        mFilmPremiere = getIntent().getStringExtra("filmPremiere");
        mFilmDescription = getIntent().getStringExtra("filmDescription");


        displayPost();
    }


    public void displayPost() {
        Glide.with(this).load(mFilmImage).into(mImageViewPhotos);

        mTextViewName.setText(mFilmName);
        mTextViewNameEng.setText(mFilmName_eng);
        mTextViewPremiere.setText(mFilmPremiere);
        mTextViewDescription.setText(mFilmDescription);
    }

}
