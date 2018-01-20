package com.hbandroid.fragmentactivitydemo.ui.util.toast;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hbandroid.fragmentactivitydemo.R;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

/**
 * Title:SingleActivityDemo
 * <p>
 * Description:
 * <p>
 * <p>
 * Author: baigege(baigegechen@gmail.com)
 * <p>
 * Date：2018-01-18
 */

public class UniversalToast {
    @NonNull
    private final Toast toast;
    @NonNull
    private final Context context;
    @NonNull
    private final String text;
    private final int type;
    private static final String TAG = UniversalToast.class.getSimpleName();
    public static final int UNIVERSAL = 0;
    public static final int EMPHASIZE = 1;
    public static final int CLICKABLE = 2;
    public static final int LENGTH_LONG = 1;
    public static final int LENGTH_SHORT = 0;
    private static final int TIME_LONG = 3500;
    private static final int TIME_SHORT = 2000;
    private WindowManager.LayoutParams params;
    private WindowManager windowManager;
    private View view;
    private int duration;
    private Handler handler;
    private View.OnClickListener listener = null;

    private UniversalToast(@NonNull Context context, @NonNull Toast toast, @NonNull String text, int type) {
        this.context = context;
        this.toast = toast;
        this.text = text;
        this.type = type;
        if (type == 2) {
            this.windowManager = (WindowManager) context.getSystemService("window");
            this.view = toast.getView();
            this.duration = toast.getDuration() == 1 ? 3500 : 2000;
            this.params = new WindowManager.LayoutParams();
            this.params.height = -2;
            this.params.width = -2;
            this.params.format = -3;
            this.params.windowAnimations = 16973828;
            this.params.type = 2002;
            this.params.setTitle("Toast");
            this.params.flags = 131264;
            this.handler = new Handler();
        }

    }

    public static UniversalToast makeText(@NonNull Context context, @NonNull String text, int duration) {
        return makeText(context, text, duration, 0);
    }

    public static UniversalToast makeText(@NonNull Context context, @NonNull String text, int duration, int type) {
        Toast toast = Toast.makeText(context, text, duration);
        int layoutId = R.layout.toast_universal;
        switch (type) {
            case 0:
            default:
                break;
            case 1:
                layoutId = R.layout.toast_emphasize;
                toast.setGravity(17, 0, 0);
                break;
            case 2:
                layoutId = R.layout.toast_clickable;
        }

        View view = LayoutInflater.from(context).inflate(layoutId, (ViewGroup) null);
        ((TextView) view.findViewById(R.id.text)).setText(text);
        toast.setView(view);
        if (Build.VERSION.SDK_INT < 26 && type != 2) {
            setContext(view, new SafeToastContext(context));
        }

        return new UniversalToast(context, toast, text, type);
    }

    private static void setContext(@NonNull View view, @NonNull Context context) {
        try {
            Field field = View.class.getDeclaredField("mContext");
            field.setAccessible(true);
            field.set(view, context);
        } catch (NoSuchFieldException var3) {
            var3.printStackTrace();
        } catch (IllegalAccessException var4) {
            var4.printStackTrace();
        }

    }

    /**
     * @deprecated
     */
    @Deprecated
    public UniversalToast setDuration(int duration) {
        if (this.type != 2) {
            this.toast.setDuration(duration);
        } else {
            this.duration = duration;
        }

        return this;
    }

    public UniversalToast setIcon(@DrawableRes int resId) {
        ImageView imageView;
        if (this.type == 2) {
            imageView = (ImageView) this.view.findViewById(R.id.icon);
        } else {
            imageView = (ImageView) this.toast.getView().findViewById(R.id.icon);
        }

        imageView.setBackgroundResource(resId);
        imageView.setVisibility(0);
        return this;
    }

    /**
     * @deprecated
     */
    @Deprecated
    public UniversalToast setAnimations(@StyleRes int animations) {
        Log.d(TAG, "method:setAnimations is Deprecated , animations must be a system resource , considering the window manager does not have access to applications.");
        if (this.type == 2) {
            this.params.windowAnimations = animations;
        } else {
            try {
                Field tnField = this.toast.getClass().getDeclaredField("mTN");
                tnField.setAccessible(true);
                Object mTN = tnField.get(this.toast);
                Field tnParamsField = mTN.getClass().getDeclaredField("mParams");
                tnParamsField.setAccessible(true);
                WindowManager.LayoutParams params = (WindowManager.LayoutParams) tnParamsField.get(mTN);
                params.windowAnimations = animations;
            } catch (NoSuchFieldException var6) {
                var6.printStackTrace();
            } catch (IllegalAccessException var7) {
                var7.printStackTrace();
            }
        }

        return this;
    }

    public UniversalToast setColor(@ColorRes int colorRes) {
        GradientDrawable drawable;
        if (this.type == 2) {
            drawable = (GradientDrawable) this.view.getBackground();
        } else {
            drawable = (GradientDrawable) this.toast.getView().getBackground();
        }

        drawable.setColor(this.context.getResources().getColor(colorRes));
        return this;
    }

    public UniversalToast setBackground(Drawable drawable) {
        if (this.type == 2) {
            this.view.setBackground(drawable);
        } else {
            this.toast.getView().setBackground(drawable);
        }

        return this;
    }

    public UniversalToast setGravity(int gravity, int xOffset, int yOffset) {
        if (this.type == 2) {
            Configuration config = this.view.getContext().getResources().getConfiguration();
            int g = Gravity.getAbsoluteGravity(gravity, config.getLayoutDirection());
            this.params.gravity = g;
            if ((g & 7) == 7) {
                this.params.horizontalWeight = 1.0F;
            }

            if ((g & 112) == 112) {
                this.params.verticalWeight = 1.0F;
            }

            this.params.x = xOffset;
            this.params.y = yOffset;
        } else {
            this.toast.setGravity(gravity, xOffset, yOffset);
        }

        return this;
    }

    public UniversalToast setMargin(float horizontalMargin, float verticalMargin) {
        if (this.type == 2) {
            this.params.verticalMargin = verticalMargin;
            this.params.horizontalMargin = horizontalMargin;
        } else {
            this.toast.setMargin(horizontalMargin, verticalMargin);
        }

        return this;
    }

    public UniversalToast setText(@StringRes int resId) {
        if (this.type == 2) {
            ((TextView) this.view.findViewById(R.id.text)).setText(resId);
        } else {
            this.toast.setText(resId);
        }

        return this;
    }

    public UniversalToast setText(@NonNull CharSequence s) {
        if (this.type == 2) {
            ((TextView) this.view.findViewById(R.id.text)).setText(s);
        } else {
            this.toast.setText(s);
        }

        return this;
    }

    public void show() {
        if (this.type != 2) {
            this.toast.show();
        } else {
            if (this.listener == null) {
                Log.e(TAG, "the listener of clickable toast is null,have you called method:setClickCallBack?");
                return;
            }

            if (this.view.getParent() != null) {
                this.windowManager.removeView(this.view);
            }

            this.windowManager.addView(this.view, this.params);
            this.handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    UniversalToast.this.cancel();
                }
            }, (long) this.duration);
        }

    }

    private void cancel() {
        if (this.type == 2) {
            this.windowManager.removeView(this.view);
            this.params = null;
            this.windowManager = null;
            this.view = null;
            this.handler = null;
            this.listener = null;
        }
    }

    public void showSuccess() {
        this.setIcon(this.type == 1 ? R.drawable.ic_check_circle_white_24dp : R.drawable.ic_done_white_24dp);
        this.show();
    }

    public void showError() {
        this.setIcon(R.drawable.ic_clear_white_24dp);
        this.show();
    }

    public void showWarning() {
        this.setIcon(R.drawable.ic_error_outline_white_24dp);
        this.show();
    }

    public UniversalToast setClickCallBack(@NonNull String text, @NonNull View.OnClickListener listener) {
        return this.setClickCallBack(text, R.drawable.ic_play_arrow_white_24dp, listener);
    }

    public UniversalToast setClickCallBack(@NonNull String text, @DrawableRes int resId, @NonNull View.OnClickListener listener) {
        if (this.type != 2) {
            Log.d(TAG, "only clickable toast has click callback!!!");
            return this;
        } else {
            this.listener = listener;
            LinearLayout layout = (LinearLayout) this.view.findViewById(R.id.btn);
            layout.setVisibility(0);
            layout.setOnClickListener(listener);
            TextView textView = (TextView) layout.findViewById(R.id.btn_text);
            textView.setText(text);
            ImageView imageView = (ImageView) layout.findViewById(R.id.btn_icon);
            imageView.setBackgroundResource(resId);
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Duration {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }
}
