package com.hbandroid.fragmentactivitydemo.db.local.cache;

import android.os.Environment;

import com.hbandroid.fragmentactivitydemo.common.constant.IConstant;

import java.io.File;

/**
 * Title:singleActivityDemo
 * <p>
 * Description:
 * <p>
 * <p>
 * Author: baigege(baigegechen@gmail.com)
 * <p>
 * Date：2017-12-29
 */

public class FileUtil {

    public static File getcacheDirectory() {
        File cacheFile = null;
        boolean sdCardExist = Environment.getExternalStorageState()
                .equals(android.os.Environment.MEDIA_MOUNTED); //判断sd卡是否存在
        if (sdCardExist) {
            File dir = Environment.getExternalStorageDirectory();
            cacheFile = new File(dir, IConstant.cacheFileName);
            if (!cacheFile.exists()) {
                cacheFile.mkdir();
            }
        }
        return cacheFile;
    }
}
