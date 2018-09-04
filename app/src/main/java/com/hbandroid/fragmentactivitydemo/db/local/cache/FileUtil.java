package com.hbandroid.fragmentactivitydemo.db.local.cache;

import android.content.Context;

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

    public static File getcacheDirectory(Context context) {
        File cacheFile = null;
        File CachefileParent = context.getCacheDir();
        //缓存目录路径 /data/data/包名/cache/包名/IConstant.cacheFileName
        String path = CachefileParent.getAbsolutePath() + "/" + context.getPackageName() + "/" + IConstant.cacheFileName;
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
