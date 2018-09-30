package com.jengasoft.movietheater;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by MoCoder#1956# on 4/2/2018.
 */

public class MovieCategoryPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public MovieCategoryPagerAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return  AdventureMoviesFragment.newInstance();
        } else if (position == 1) {
            return AdventureMoviesFragment.newInstance();
        } else if (position == 2) {
            return AdventureMoviesFragment.newInstance();
        } else if(position == 3) {
            return AdventureMoviesFragment.newInstance();
        }else{
            return AdventureMoviesFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.adventure);
            case 1:
                return mContext.getString(R.string.drama);
            case 2:
                return mContext.getString(R.string.war);
            case 3:
                return mContext.getString(R.string.criminal);
            default:
                return null;
        }
    }

}