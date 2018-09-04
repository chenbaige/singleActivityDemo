package com.hbandroid.fragmentactivitydemo.ui.mvp.fragment.chat;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hbandroid.fragmentactivitydemo.R;
import com.hbandroid.fragmentactivitydemo.di.component.AppComponent;
import com.hbandroid.fragmentactivitydemo.ui.base.BaseFragment;
import com.hbandroid.fragmentactivitydemo.ui.util.popup.DialogPopupWindow;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Title:fragmentActivityDemo
 * <p>
 * Description:
 * <p>
 * <p>
 * Author: baigege(baigegechen@gmail.com)
 * <p>
 * Date：2017-12-22
 */
public class ChatFragment extends BaseFragment {

    @BindView(R.id.tv_chat)
    TextView tvChat;

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    protected void onLazyRequest() {

    }

    @Override
    public int setContentViewId() {
        return R.layout.fragment_chat;
    }

    public static ChatFragment newInstance() {
        return new ChatFragment();
    }

    @Override
    public void init() {
        System.out.println(this.getClass().getName() + "调用了:init");
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        //懒加载方法 在可见的时候才调用  可用于网络访问的接口调用
        System.out.println(this.getClass().getName() + "调用了:onLazyInitView");
    }

    @Override
    public void onSupportInvisible() {
        super.onSupportInvisible();
        System.out.println(this.getClass().getName() + "调用了:onSupportInvisible");
    }

    @Override
    public void onSupportVisible() {
        super.onSupportVisible();
        System.out.println(this.getClass().getName() + "调用了:onSupportVisible");
    }

    @OnClick(R.id.tv_chat)
    public void onClick() {
        DialogPopupWindow popupWindow = new DialogPopupWindow(_mActivity);
        popupWindow.showPopupWindow(tvChat);
    }
}
