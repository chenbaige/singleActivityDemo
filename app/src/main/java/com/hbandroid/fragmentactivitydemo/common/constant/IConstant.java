package com.hbandroid.fragmentactivitydemo.common.constant;

/**
 * Title: BasicMvpFramwork
 * <p/>
 * Description:
 * <p/>
 * Author:baigege (baigegechen@gmail.com)
 * <p/>
 * Date:2017-05-24
 */
public interface IConstant {

    //默认倒计时的时长(单位/秒)
    int TIMER_DOWN = 60;

    //按钮防抖默认时间间隔(单位/秒)
    int DEFALUT_THROTTLE_TIMER = 2;

    //网络请求连接超时时间(单位/毫秒)
    int HTTP_CONNECT_TIMEOUT = 5000;

    //文本框搜索事件触发事件间隔(单位/毫秒)
    int ET_INTER_TIME = 300;

    //缓存的文件名
    String cacheFileName = "cacheDir";

    String LOG_DESC = "requestLog-->";

}
