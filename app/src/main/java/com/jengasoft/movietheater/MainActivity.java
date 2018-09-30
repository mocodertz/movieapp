package com.jengasoft.movietheater;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SnapHelper;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.rbrooks.indefinitepagerindicator.IndefinitePagerIndicator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private Toolbar mToolbar;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private IndefinitePagerIndicator mIndefinitePagerIndicator;
    private RecyclerView mRecyclerViewLatestMovie;
    private RecyclerView mRecyclerViewBestFilmSeries;
    private RecyclerView mRecyclerViewAvailableMovieTheater;
    private MovieAdapter mMovieAdapter;
    private TabLayout mTabLayout;
    private CustomViewPager mViewPager;
    private MovieCategoryPagerAdapter mMovieCategoryPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = findViewById(R.id.toolbar);
        mSwipeRefreshLayout = findViewById(R.id.layoutRefresher);
        mIndefinitePagerIndicator = findViewById(R.id.latest_movie_pager_indicator);
        mRecyclerViewLatestMovie = findViewById(R.id.latest_movie);
        mRecyclerViewBestFilmSeries = findViewById(R.id.best_movie_film);
        mRecyclerViewAvailableMovieTheater = findViewById(R.id.available_movie_theater);
        mTabLayout = findViewById(R.id.movie_categories);
        mViewPager = findViewById(R.id.movie_categories_content);

        setSupportActionBar(mToolbar);
        SnapHelper snapHelper = new PagerSnapHelper();
        SnapHelper snapHelperCinema = new PagerSnapHelper();
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(this, R.dimen.itemOffset);
        //mRecyclerViewLatestMovie.addItemDecoration(itemDecoration);

        snapHelper.attachToRecyclerView(mRecyclerViewLatestMovie);
        mRecyclerViewLatestMovie.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mRecyclerViewLatestMovie.setAdapter(new MovieAdapter(this, getMovies(), "latestmovie"));
        mIndefinitePagerIndicator.attachToRecyclerView(mRecyclerViewLatestMovie);

        mRecyclerViewBestFilmSeries.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mRecyclerViewBestFilmSeries.setAdapter(new MovieAdapter(this, getMovies(), "bestfilmandseries"));
        mRecyclerViewBestFilmSeries.addItemDecoration(itemDecoration);

        //snapHelperCinema.attachToRecyclerView(mRecyclerViewAvailableMovieTheater);
        mRecyclerViewAvailableMovieTheater.setNestedScrollingEnabled(false);
        mRecyclerViewAvailableMovieTheater.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerViewAvailableMovieTheater.setAdapter(new CinemaAdapter(this, getCinema()));
        //mRecyclerViewAvailableMovieTheater.addItemDecoration(itemDecoration);

        mMovieCategoryPagerAdapter = new MovieCategoryPagerAdapter(this, getSupportFragmentManager());
        mViewPager.setAdapter(mMovieCategoryPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.search_menu, menu);
        final MenuItem menuItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) menuItem.getActionView();
        AppCompatImageView searchClose = searchView.findViewById(android.support.v7.appcompat.R.id.search_close_btn);
        searchClose.setImageResource(R.drawable.ic_clear_white_24dp);
        SearchView.SearchAutoComplete searchField = searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        searchField.setTextColor(Color.WHITE);
        searchView.setOnQueryTextListener(this);
        menuItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem menuItem) {
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    private List<Movie> getMovies() {

        ArrayList<Movie> movieArrayList = new ArrayList<>();
        movieArrayList.add(new Movie("Jumanji: Welcome to the Jungle", "Four high school kids discover an old video game console and are drawn into the game's jungle setting, literally becoming the adult avatars they chose. What they discover is that you don't just play Jumanji - you must survive it. To beat the game and return to the real world, they'll have to go on the most dangerous adventure of their lives, discover what Alan Parrish left 20 years ago, and change the way they think about themselves - or they'll be stuck in the game forever.",
                "1h 59m", "December 20, 2017 (USA)", "http://t2.gstatic.com/images?q=tbn:ANd9GcSGLiKxLm4FSbjNzysaI8xVoUEE27RDObZg9pSiP28nvSEwy7Mb",
                "https://cdn.vox-cdn.com/thumbor/5BgCc5b9K6CoskdDFst6cr2eGxk=/0x0:2040x1360/920x613/filters:focal(1014x428:1340x754):format(webp)/cdn.vox-cdn.com/uploads/chorus_image/image/58088717/DF_05153_R_2040.0.jpg",
                "latestmovie", "900k"));
        movieArrayList.add(new Movie("13 Hours: The Secret Soldiers of Benghazi", "On Sept. 11, 2012, Islamic militants attack the U.S. Consulate in Benghazi, Libya, killing Ambassador J. Christopher Stevens and Sean Smith, an officer for the Foreign Service. Stationed less than one mile away are members (James Badge Dale, John Krasinski, Max Martini) of the Annex Security Team, former soldiers assigned to protect operatives and diplomats in the city. As the assault rages on, the six men engage the combatants in a fierce firefight to save the lives of the remaining Americans.",
                "2h 24m", "January 12, 2016 (USA)", "http://t1.gstatic.com/images?q=tbn:ANd9GcQUPbVNaGTVi4oE2ih22NQZKCQQtbhksrpolxS1fwYyVD8RrwGR",
                "https://www.telegraph.co.uk/content/dam/film/13hours/krasinski2-xlarge.jpg", "latestmovie", "1.1M"));
        movieArrayList.add(new Movie("We Were Soldiers", "Based upon the best-selling book \"We Were Soldiers Once ... and Young\" by Lt. Gen. Harold G. Moore (Ret.) and journalist Joseph L. Galloway, this compelling war drama depicts the true story of the first major battle between the United States and North Vietnamese forces. It is a film about uncommon valor and nobility under fire, loyalty among soldiers, and the heroism and sacrifice of men and women both home and abroad.",
                "2h 23m", "February 25, 2002 (USA)", "http://t1.gstatic.com/images?q=tbn:ANd9GcSx3Js_-nEne8cJ1PGKIy1HAzmyaAL-rotizbXXXc6FDBOsa5b5",
                "http://www.tvovermind.com/wp-content/uploads/2018/02/We-Were-Soldiers-DI-2-640x360.jpg", "latestmovie", "206K"));
        movieArrayList.add(new Movie("Django Unchained", "Two years before the Civil War, Django (Jamie Foxx), a slave, finds himself accompanying an unorthodox German bounty hunter named Dr. King Schultz (Christoph Waltz) on a mission to capture the vicious Brittle brothers. Their mission successful, Schultz frees Django, and together they hunt the South's most-wanted criminals. Their travels take them to the infamous plantation of shady Calvin Candie (Leonardo DiCaprio), where Django's long-lost wife (Kerry Washington) is still a slave.",
                "2h 45m", "December 25, 2012 (Canada)", "http://t3.gstatic.com/images?q=tbn:ANd9GcSnm2FczCxSnt69XUZqqI5-sfy66SvjiV0du9mfUKRRCGqVAurt",
                "http://cdn-static.denofgeek.com/sites/denofgeek/files/styles/main_wide/public/django_lead_0.jpg?itok=ZpVJN-_m", "latestmovie", "1.2B"));
        movieArrayList.add(new Movie("Jumanji: Welcome to the Jungle", "Four high school kids discover an old video game console and are drawn into the game's jungle setting, literally becoming the adult avatars they chose. What they discover is that you don't just play Jumanji - you must survive it. To beat the game and return to the real world, they'll have to go on the most dangerous adventure of their lives, discover what Alan Parrish left 20 years ago, and change the way they think about themselves - or they'll be stuck in the game forever.",
                "1h 59m", "December 20, 2017 (USA)", "http://t2.gstatic.com/images?q=tbn:ANd9GcSGLiKxLm4FSbjNzysaI8xVoUEE27RDObZg9pSiP28nvSEwy7Mb",
                "https://cdn.vox-cdn.com/thumbor/5BgCc5b9K6CoskdDFst6cr2eGxk=/0x0:2040x1360/920x613/filters:focal(1014x428:1340x754):format(webp)/cdn.vox-cdn.com/uploads/chorus_image/image/58088717/DF_05153_R_2040.0.jpg",
                "latestmovie", "900k"));
        return movieArrayList;
    }

    private List<Cinema> getCinema() {
        ArrayList<Cinema> cinemaArrayList = new ArrayList<>();
        cinemaArrayList.add(new Cinema("Century Cinemax - Mkuki House", "https://mms.businesswire.com/media/20130711005372/en/375651/5/07_11_13_-_RGC_Christiana_-_Image_-_FINAL.jpg"));
        cinemaArrayList.add(new Cinema("Suncrest Cineplex", "https://static.panoramio.com.storage.googleapis.com/photos/large/69516724.jpg"));
        cinemaArrayList.add(new Cinema("Grip and Sparks Tanzania Limited", "https://cdn.movieweb.com/img.news.tops/NE9U0dfrR69Ucc_1_b/Regal-Cinemas-Backpack-Ban-Theater-Shootings.jpg"));
        cinemaArrayList.add(new Cinema("Reglaz Cinema", "http://d13ezvd6yrslxm.cloudfront.net/wp/wp-content/images/regal-movie-theaters-700x394.jpg"));
        return cinemaArrayList;
    }
}
