package com.hbandroid.fragmentactivitydemo.common.rx;

import android.content.Context;

import com.hbandroid.fragmentactivitydemo.R;

import dmax.dialog.SpotsDialog;

/**
 * Title: basicmvpframwork
 * <p>
 * Description:
 * <p>
 * Author:baigege (baigegechen@gmail.com)
 * <p>
 * Date:2017-05-25
 */
public class ProgressDialogHandler {

    public static final int SHOW_PROGRESS_DIALOG = 1;
    public static final int DISMISS_PROGRESS_DIALOG = 0;

//    private SweetAlertDialog mDialog;

    SpotsDialog mSpotsDialog;

    private Context mContext;

    private boolean cancelable;

    private onProgressCancelistener mCancelistener;

    public ProgressDialogHandler(Context context) {
        this(context, true, null);
    }

    public ProgressDialogHandler(Context context, boolean cancelable, onProgressCancelistener cancelistener) {
        mContext = context;
        this.cancelable = cancelable;
        mCancelistener = cancelistener;
        initDialog();
    }

    public interface onProgressCancelistener {
        void onProgressCancel();
    }

    public void initDialog() {
//        if (mDialog == null) {
//            mDialog = new SweetAlertDialog(mContext, SweetAlertDialog.PROGRESS_TYPE);
//            mDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
//            mDialog.setTitleText("Loading");
//            if (cancelable) {
//                mDialog.setCancelText("");
//                mDialog.setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                    @Override
//                    public void onClick(SweetAlertDialog sweetAlertDialog) {
//
//                    }
//                });
//            }
//            mDialog.setCancelable(cancelable);
//        }

        if (null == mSpotsDialog) {
            mSpotsDialog = new SpotsDialog(mContext, "Loading", R.style.Custom);
        }
    }

    public void showDialog() {
//        if (mDialog != null && !mDialog.isShowing())
//            mDialog.show();
        if (null != mSpotsDialog && !mSpotsDialog.isShowing())
            mSpotsDialog.show();
    }

    public void dismissDialog() {
//        if (mDialog != null)
//            mDialog.dismiss();
        if (null != mSpotsDialog && mSpotsDialog.isShowing())
            mSpotsDialog.dismiss();

    }
}
