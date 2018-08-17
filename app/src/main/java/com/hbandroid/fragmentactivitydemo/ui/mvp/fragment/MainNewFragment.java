package com.hbandroid.fragmentactivitydemo.ui.mvp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.hbandroid.fragmentactivitydemo.R;
import com.hbandroid.fragmentactivitydemo.ui.base.BaseFragment;
import com.hbandroid.fragmentactivitydemo.ui.listener.OnChangeActivityStatusListener;
import com.hbandroid.fragmentactivitydemo.ui.mvp.fragment.chat.ChatFragment;
import com.hbandroid.fragmentactivitydemo.ui.mvp.fragment.favorite.FavoriteFragment;
import com.hbandroid.fragmentactivitydemo.ui.mvp.fragment.home.HomeFragment;
import com.hbandroid.fragmentactivitydemo.ui.mvp.fragment.mine.MineFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.ISupportFragment;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by YoKeyword on 16/6/30.
 */
public class MainNewFragment extends SupportFragment implements BottomNavigationBar.OnTabSelectedListener {
    private static final int REQ_MSG = 10;

    // 再点一次退出程序时间设置
    private static final long WAIT_TIME = 2000L;
    private long TOUCH_TIME = 0;

    private OnChangeActivityStatusListener mStatusListener;

    private String[] mTitles = {"首页", "消息", "收藏", "我"};

    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;
    public static final int Fouth = 3;
    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar mBottomNavigationBar;
    @BindView(R.id.id_content)
    FrameLayout mIdContent;
    Unbinder unbinder;

    private int currFragmentPos;

    private BaseFragment[] mFragments = new BaseFragment[4];


    public static MainNewFragment newInstance() {
        Bundle args = new Bundle();
        MainNewFragment fragment = new MainNewFragment();
        fragment.setArguments(args);
        return fragment;
    }

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        //绑定fragment
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        ISupportFragment firstFragment = findChildFragment(HomeFragment.class);
        if (firstFragment == null) {
            mFragments[FIRST] = HomeFragment.newInstance();
            mFragments[SECOND] = ChatFragment.newInstance();
            mFragments[THIRD] = FavoriteFragment.newInstance();
            mFragments[Fouth] = MineFragment.newInstance();
            mStatusListener.setTitle(mTitles[FIRST]);
            loadMultipleRootFragment(R.id.id_content, FIRST, mFragments[FIRST], mFragments[SECOND], mFragments[THIRD], mFragments[Fouth]);
            currFragmentPos = FIRST;
        } else {
            // 这里库已经做了Fragment恢复工作，不需要额外的处理
            // 这里我们需要拿到mFragments的引用，用下面的方法查找更方便些，也可以通过getSupportFragmentManager.getFragments()自行进行判断查找(效率更高些)
            mFragments[FIRST] = findFragment(HomeFragment.class);
            mFragments[SECOND] = findFragment(ChatFragment.class);
            mFragments[THIRD] = findFragment(FavoriteFragment.class);
            mFragments[Fouth] = findFragment(MineFragment.class);
        }
    }

    private void initView() {
        mBottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.viewgallery, "Home"))
                .addItem(new BottomNavigationItem(R.mipmap.atm, "Chat"))
                .addItem(new BottomNavigationItem(R.mipmap.favorite, "Favorite"))
                .addItem(new BottomNavigationItem(R.mipmap.personal_center, "Mine"))
                .initialise();
        mBottomNavigationBar.setTabSelectedListener(this);
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
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onTabSelected(int position) {
        mStatusListener.setTitle(mTitles[position]);
        showHideFragment(mFragments[position], mFragments[currFragmentPos]);
        currFragmentPos = position;
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {
        // 在FirstPagerFragment,FirstHomeFragment中接收, 因为是嵌套的Fragment
        // 主要为了交互: 重选tab 如果列表不在顶部则移动到顶部,如果已经在顶部,则刷新
//        EventBusActivityScope.getDefault(_mActivity).post(new TabSelectedEvent(position));
    }

    /**
     * 处理回退事件
     *
     * @return
     */
    @Override
    public boolean onBackPressedSupport() {
        if (System.currentTimeMillis() - TOUCH_TIME < WAIT_TIME) {
            _mActivity.finish();
        } else {
            TOUCH_TIME = System.currentTimeMillis();
            Toast.makeText(_mActivity, R.string.press_again_exit, Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
