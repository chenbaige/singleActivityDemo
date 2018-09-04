package com.hbandroid.fragmentactivitydemo.ui.mvp.adapter.news;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.hbandroid.fragmentactivitydemo.ui.mvp.fragment.news.NewsDetailFragment;

/**
 * Title: singleActivityDemo
 * <p>
 * Description:
 * <p>
 * Author:baigege (baigegechen@gmail.com)
 * <p>
 * Date:2018-01-14
 */

public class NewsTabItem {

    public Fragment mContentFragment;

    public NewsTabItem(String title, int imageRes) {
        this.title = title;
        this.imageRes = imageRes;
    }

    public NewsTabItem(String title, String imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    private String title;

    private int imageRes;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    private String imageUrl;

    private boolean select;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public Fragment createNewsFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("content", title);
        return NewsDetailFragment.newInstance(bundle);
    }
}
