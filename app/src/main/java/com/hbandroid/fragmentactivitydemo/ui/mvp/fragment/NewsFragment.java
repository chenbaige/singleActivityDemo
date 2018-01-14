package com.hbandroid.fragmentactivitydemo.ui.mvp.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.hbandroid.fragmentactivitydemo.R;
import com.hbandroid.fragmentactivitydemo.di.component.AppComponent;
import com.hbandroid.fragmentactivitydemo.ui.base.BaseFragment;
import com.hbandroid.fragmentactivitydemo.ui.listener.OnChangeActivityStatusListener;
import com.hbandroid.fragmentactivitydemo.ui.mvp.adapter.news.NewsPageAdapter;
import com.hbandroid.fragmentactivitydemo.ui.mvp.adapter.news.NewsTabItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import devlight.io.library.ntb.NavigationTabBar;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by YoKeyword on 16/6/30.
 */
public class NewsFragment extends BaseFragment implements ViewPager.OnPageChangeListener {
    private static final int REQ_MSG = 10;
    @BindView(R.id.bottomNavigationBar)
    NavigationTabBar mBottomNavigationBar;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;


    private OnChangeActivityStatusListener mStatusListener;

    private List<NewsTabItem> mTabs = new ArrayList<>();

    private String[] mTitles = {"首页", "消息", "收藏", "我"};

//    private String[] colors = new String[]{"#FFD700", "#BFEFFF", "#8B4C39", "#1874CD"};
    private String[] colors = new String[]{"#FFD700", "#FFD700", "#FFD700", "#FFD700"};

    private NewsPageAdapter mPagerAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mStatusListener = (OnChangeActivityStatusListener) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.mStatusListener = null;
    }

    public static NewsFragment newInstance() {
        Bundle args = new Bundle();
        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public int setContentViewId() {
        return R.layout.fragment_news;
    }

    @Override
    public void init() {
        for (int i = 0; i < mTitles.length; i++) {
            mTabs.add(new NewsTabItem(mTitles[i], colors[i]));
        }
        initViewPager();
        initView();
    }

    private void initViewPager() {
        mPagerAdapter = new NewsPageAdapter(getChildFragmentManager(), mTabs);
        mViewpager.setAdapter(mPagerAdapter);
//        mViewpager.setOnPageChangeListener(this);
    }

    private void initView() {
        final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.mipmap.viewgallery),
                        Color.parseColor(colors[0])
                ).title(mTabs.get(0).getTitle())
                        .badgeTitle("NTB")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.mipmap.atm),
                        Color.parseColor(colors[1])
                ).title(mTabs.get(1).getTitle())
                        .badgeTitle("with")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.mipmap.favorite),
                        Color.parseColor(colors[2])
                ).title(mTabs.get(2).getTitle())
                        .badgeTitle("state")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.mipmap.personal_center),
                        Color.parseColor(colors[3])
                ).title(mTabs.get(3).getTitle())
                        .badgeTitle("icon")
                        .build()
        );
        mBottomNavigationBar.setModels(models);
        mBottomNavigationBar.setViewPager(mViewpager);

        mBottomNavigationBar.setTitleMode(NavigationTabBar.TitleMode.ACTIVE);
        mBottomNavigationBar.setBadgeGravity(NavigationTabBar.BadgeGravity.BOTTOM);
        mBottomNavigationBar.setBadgePosition(NavigationTabBar.BadgePosition.CENTER);
        mBottomNavigationBar.setTypeface("fonts/custom_font.ttf");
        mBottomNavigationBar.setIsBadged(true);
        mBottomNavigationBar.setIsTitled(true);
        mBottomNavigationBar.setIsTinted(true);
        mBottomNavigationBar.setIsBadgeUseTypeface(true);
        mBottomNavigationBar.setBadgeBgColor(Color.RED);
        mBottomNavigationBar.setBadgeTitleColor(Color.WHITE);
        mBottomNavigationBar.setIsSwiped(true);
        mBottomNavigationBar.setBgColor(Color.BLACK);
        mBottomNavigationBar.setBadgeSize(10);
        mBottomNavigationBar.setTitleSize(10);
        mBottomNavigationBar.setIconSizeFraction(0.5f);
        mBottomNavigationBar.setOnPageChangeListener(this);
    }

    @Override
    public void onFragmentResult(int requestCode, int resultCode, Bundle data) {
        super.onFragmentResult(requestCode, resultCode, data);
        if (requestCode == REQ_MSG && resultCode == RESULT_OK) {

        }
    }

    /**
     * start other BrotherFragment
     */
    public void startBrotherFragment(SupportFragment targetFragment) {
        start(targetFragment);
    }


    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int position) {
        mStatusListener.setTitle(mTitles[position]);
        mBottomNavigationBar.setModelIndex(position);
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

}
