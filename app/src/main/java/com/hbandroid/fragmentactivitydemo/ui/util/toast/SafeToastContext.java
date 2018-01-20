package com.hbandroid.fragmentactivitydemo.ui.util.toast;

import android.content.Context;
import android.content.ContextWrapper;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

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

public class SafeToastContext extends ContextWrapper {
    SafeToastContext(@NonNull Context base) {
        super(base);
    }

    @Override
    public Context getApplicationContext() {
        return new SafeToastContext.ApplicationContextWrapper(this.getBaseContext().getApplicationContext());
    }

    private final class WindowManagerWrapper implements WindowManager {
        private static final String TAG = "WindowManagerWrapper";
        @NonNull
        private final WindowManager base;

        private WindowManagerWrapper(@NonNull WindowManager base) {
            this.base = base;
        }

        @Override
        public Display getDefaultDisplay() {
            return this.base.getDefaultDisplay();
        }

        @Override
        public void removeViewImmediate(View view) {
            this.base.removeViewImmediate(view);
        }

        public void addView(View view, LayoutParams params) {
            try {
                Log.d("WindowManagerWrapper", "WindowManager's addView(view, params) has been hooked.");
                this.base.addView(view, params);
            } catch (BadTokenException var4) {
                Log.d("WindowManagerWrapper", "BadTokenException ignored");
            } catch (Throwable var5) {
                Log.e("WindowManagerWrapper", "[addView]", var5);
            }

        }

        public void updateViewLayout(View view, LayoutParams params) {
            this.base.updateViewLayout(view, params);
        }

        @Override
        public void addView(View view, ViewGroup.LayoutParams params) {

        }

        @Override
        public void updateViewLayout(View view, ViewGroup.LayoutParams params) {

        }

        @Override
        public void removeView(View view) {
            this.base.removeView(view);
        }
    }

    private final class ApplicationContextWrapper extends ContextWrapper {
        private ApplicationContextWrapper(@NonNull Context base) {
            super(base);
        }

        @Override
        public Object getSystemService(@NonNull String name) {
            return "window".equals(name)?new WindowManagerWrapper((WindowManager)this.getBaseContext().getSystemService(name)):super.getSystemService(name);
        }
    }
}
