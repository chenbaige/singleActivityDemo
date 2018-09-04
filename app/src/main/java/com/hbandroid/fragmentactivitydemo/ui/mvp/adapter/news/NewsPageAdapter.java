package com.hbandroid.fragmentactivitydemo.ui.mvp.adapter.news;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * Title: singleActivityDemo
 * <p>
 * Description:
 * <p>
 * Author:baigege (baigegechen@gmail.com)
 * <p>
 * Date:2018-01-14
 */

public class NewsPageAdapter extends FragmentStatePagerAdapter {

    private List<NewsTabItem> mNewsTabItems;

    public NewsPageAdapter(FragmentManager fm, List<NewsTabItem> list) {
        super(fm);
        this.mNewsTabItems = list;
    }

    @Override
    public Fragment getItem(int pos) {
        Fragment fragment = null;
        if (mNewsTabItems != null && pos < mNewsTabItems.size()) {
            NewsTabItem tab = mNewsTabItems.get(pos);
            if (tab == null)
                return null;
            fragment = tab.createNewsFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        if (mNewsTabItems != null && mNewsTabItems.size() > 0) {
            return mNewsTabItems.size();
        }
        return 0;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        NewsTabItem tab = mNewsTabItems.get(position);
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        tab.mContentFragment = fragment;
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mNewsTabItems.get(position).getTitle();
    }

//    @Override
//    public View getSelectTabView(int position, View convertView) {
//        if (convertView == null){
//            convertView = mInflater.inflate(R.layout.custom_select_tab, null);
//        }
//
//        TextView tv = ViewHolder.get(convertView, R.id.match_moregeme_name);
//        CircleImageView icon = ViewHolder.get(convertView, R.id.match_moregeme_icon);
//        ImageUtils.downloadIcon(context,mNewsTabItems.get(position).getPicurl(),icon);
//        tv.setText(getPageTitle(position));
//
//        return convertView;
//    }
//
//    @Override
//    public View getDisSelectTabView(int position, View convertView) {
//        if (convertView == null){
//            convertView = mInflater.inflate(R.layout.custom_disselect_tab, null);
//        }
//
//        TextView tv = ViewHolder.get(convertView, R.id.match_moregeme_name);
//        CircleImageView icon = ViewHolder.get(convertView, R.id.match_moregeme_icon);
//        ImageUtils.downloadIcon(context,mNewsTabItems.get(position).getPicurl(),icon);
//        tv.setText(getPageTitle(position));
//
//        return convertView;
//    }
}
