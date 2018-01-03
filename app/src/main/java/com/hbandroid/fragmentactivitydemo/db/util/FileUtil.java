package com.hbandroid.fragmentactivitydemo.db.util;

import android.content.Context;

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

    private static String cacheFileName = "rxcache_dictionary";

    public static File getcacheDirectory(Context context) {
        File cacheFile = null;
        File CachefileParent = context.getCacheDir();
        String path = CachefileParent.getAbsolutePath() + "/" + context.getPackageName() + "/" + cacheFileName;
        cacheFile = new File(path);
        try {
            //如果文件不存在，则创建新的文件
            if (!cacheFile.exists()) {
                cacheFile.mkdirs();
                //创建文件成功后，写入内容到文件里
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cacheFile;
    }

}
