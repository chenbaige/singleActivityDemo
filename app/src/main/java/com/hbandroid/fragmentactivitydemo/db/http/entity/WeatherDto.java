package com.hbandroid.fragmentactivitydemo.db.http.entity;

import java.util.List;

/**
<<<<<<< HEAD
 * Title: RxCacheDemo
=======
 * Title: singleActivityDemo
>>>>>>> 4bb38b8fbd891b6d352d16ecf932baedc6cb12c9
 * <p>
 * Description:
 * <p>
 * Author:baigege (baigegechen@gmail.com)
 * <p>
<<<<<<< HEAD
 * Date:2018-01-02
=======
 * Date:2018-01-09
>>>>>>> 4bb38b8fbd891b6d352d16ecf932baedc6cb12c9
 */

public class WeatherDto {


    /**
<<<<<<< HEAD
     * date : 20180102
=======
     * date : 20180109
>>>>>>> 4bb38b8fbd891b6d352d16ecf932baedc6cb12c9
     * message : Success !
     * status : 200
     * city : 广元
     * count : 1
<<<<<<< HEAD
     * data : {"shidu":"49%","pm25":28,"pm10":103,"quality":"良","wendu":"7","ganmao":"极少数敏感人群应减少户外活动","yesterday":{"date":"01日星期一","sunrise":"07:58","high":"高温 12.0℃","low":"低温 1.0℃","sunset":"18:02","aqi":96,"fx":"无持续风向","fl":"<3级","type":"多云","notice":"今日多云，骑上单车去看看世界吧"},"forecast":[{"date":"02日星期二","sunrise":"07:58","high":"高温 8.0℃","low":"低温 2.0℃","sunset":"18:02","aqi":80,"fx":"无持续风向","fl":"<3级","type":"小雨","notice":"下雨了不要紧，撑伞挡挡就行"},{"date":"03日星期三","sunrise":"07:59","high":"高温 4.0℃","low":"低温 0.0℃","sunset":"18:03","aqi":45,"fx":"无持续风向","fl":"<3级","type":"小雨","notice":"雾蒙蒙的雨天，最喜欢一个人听音乐"},{"date":"04日星期四","sunrise":"07:59","high":"高温 5.0℃","low":"低温 0.0℃","sunset":"18:04","aqi":33,"fx":"无持续风向","fl":"<3级","type":"阴","notice":"阴天没有晴天的明朗，却依然明亮"},{"date":"05日星期五","sunrise":"07:59","high":"高温 3.0℃","low":"低温 0.0℃","sunset":"18:05","aqi":46,"fx":"无持续风向","fl":"<3级","type":"小雨","notice":"下雨了不要紧，撑伞挡挡就行"},{"date":"06日星期六","sunrise":"07:59","high":"高温 4.0℃","low":"低温 -2.0℃","sunset":"18:05","aqi":32,"fx":"无持续风向","fl":"<3级","type":"小雨","notice":"雾蒙蒙的雨天，最喜欢一个人听音乐"}]}
=======
     * data : {"shidu":"69%","pm25":21,"pm10":71,"quality":"良","wendu":"-3","ganmao":"极少数敏感人群应减少户外活动","yesterday":{"date":"08日星期一","sunrise":"07:59","high":"高温 9.0℃","low":"低温 -1.0℃","sunset":"18:07","aqi":58,"fx":"无持续风向","fl":"<3级","type":"晴","notice":"lovely sunshine，尽情享受阳光的温暖吧"},"forecast":[{"date":"09日星期二","sunrise":"07:59","high":"高温 11.0℃","low":"低温 -2.0℃","sunset":"18:08","aqi":50,"fx":"无持续风向","fl":"<3级","type":"晴","notice":"lovely sunshine，尽情享受阳光的温暖吧"},{"date":"10日星期三","sunrise":"07:59","high":"高温 12.0℃","low":"低温 -2.0℃","sunset":"18:09","aqi":98,"fx":"无持续风向","fl":"<3级","type":"晴","notice":"晴空万里，去沐浴阳光吧"},{"date":"11日星期四","sunrise":"07:59","high":"高温 12.0℃","low":"低温 -2.0℃","sunset":"18:09","aqi":97,"fx":"无持续风向","fl":"<3级","type":"晴","notice":"lovely sunshine，尽情享受阳光的温暖吧"},{"date":"12日星期五","sunrise":"07:59","high":"高温 11.0℃","low":"低温 2.0℃","sunset":"18:10","aqi":99,"fx":"无持续风向","fl":"<3级","type":"多云","notice":"今日多云，骑上单车去看看世界吧"},{"date":"13日星期六","sunrise":"07:59","high":"高温 8.0℃","low":"低温 2.0℃","sunset":"18:11","aqi":93,"fx":"无持续风向","fl":"<3级","type":"小雨","notice":"外出时请注意关好门窗，防止雨水飘入"}]}
>>>>>>> 4bb38b8fbd891b6d352d16ecf932baedc6cb12c9
     */

    private String date;
    private String message;
    private int status;
    private String city;
    private int count;
    /**
<<<<<<< HEAD
     * shidu : 49%
     * pm25 : 28
     * pm10 : 103
     * quality : 良
     * wendu : 7
     * ganmao : 极少数敏感人群应减少户外活动
     * yesterday : {"date":"01日星期一","sunrise":"07:58","high":"高温 12.0℃","low":"低温 1.0℃","sunset":"18:02","aqi":96,"fx":"无持续风向","fl":"<3级","type":"多云","notice":"今日多云，骑上单车去看看世界吧"}
     * forecast : [{"date":"02日星期二","sunrise":"07:58","high":"高温 8.0℃","low":"低温 2.0℃","sunset":"18:02","aqi":80,"fx":"无持续风向","fl":"<3级","type":"小雨","notice":"下雨了不要紧，撑伞挡挡就行"},{"date":"03日星期三","sunrise":"07:59","high":"高温 4.0℃","low":"低温 0.0℃","sunset":"18:03","aqi":45,"fx":"无持续风向","fl":"<3级","type":"小雨","notice":"雾蒙蒙的雨天，最喜欢一个人听音乐"},{"date":"04日星期四","sunrise":"07:59","high":"高温 5.0℃","low":"低温 0.0℃","sunset":"18:04","aqi":33,"fx":"无持续风向","fl":"<3级","type":"阴","notice":"阴天没有晴天的明朗，却依然明亮"},{"date":"05日星期五","sunrise":"07:59","high":"高温 3.0℃","low":"低温 0.0℃","sunset":"18:05","aqi":46,"fx":"无持续风向","fl":"<3级","type":"小雨","notice":"下雨了不要紧，撑伞挡挡就行"},{"date":"06日星期六","sunrise":"07:59","high":"高温 4.0℃","low":"低温 -2.0℃","sunset":"18:05","aqi":32,"fx":"无持续风向","fl":"<3级","type":"小雨","notice":"雾蒙蒙的雨天，最喜欢一个人听音乐"}]
=======
     * shidu : 69%
     * pm25 : 21.0
     * pm10 : 71.0
     * quality : 良
     * wendu : -3
     * ganmao : 极少数敏感人群应减少户外活动
     * yesterday : {"date":"08日星期一","sunrise":"07:59","high":"高温 9.0℃","low":"低温 -1.0℃","sunset":"18:07","aqi":58,"fx":"无持续风向","fl":"<3级","type":"晴","notice":"lovely sunshine，尽情享受阳光的温暖吧"}
     * forecast : [{"date":"09日星期二","sunrise":"07:59","high":"高温 11.0℃","low":"低温 -2.0℃","sunset":"18:08","aqi":50,"fx":"无持续风向","fl":"<3级","type":"晴","notice":"lovely sunshine，尽情享受阳光的温暖吧"},{"date":"10日星期三","sunrise":"07:59","high":"高温 12.0℃","low":"低温 -2.0℃","sunset":"18:09","aqi":98,"fx":"无持续风向","fl":"<3级","type":"晴","notice":"晴空万里，去沐浴阳光吧"},{"date":"11日星期四","sunrise":"07:59","high":"高温 12.0℃","low":"低温 -2.0℃","sunset":"18:09","aqi":97,"fx":"无持续风向","fl":"<3级","type":"晴","notice":"lovely sunshine，尽情享受阳光的温暖吧"},{"date":"12日星期五","sunrise":"07:59","high":"高温 11.0℃","low":"低温 2.0℃","sunset":"18:10","aqi":99,"fx":"无持续风向","fl":"<3级","type":"多云","notice":"今日多云，骑上单车去看看世界吧"},{"date":"13日星期六","sunrise":"07:59","high":"高温 8.0℃","low":"低温 2.0℃","sunset":"18:11","aqi":93,"fx":"无持续风向","fl":"<3级","type":"小雨","notice":"外出时请注意关好门窗，防止雨水飘入"}]
>>>>>>> 4bb38b8fbd891b6d352d16ecf932baedc6cb12c9
     */

    private DataBean data;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String shidu;
<<<<<<< HEAD
        private int pm25;
        private int pm10;
=======
        private double pm25;
        private double pm10;
>>>>>>> 4bb38b8fbd891b6d352d16ecf932baedc6cb12c9
        private String quality;
        private String wendu;
        private String ganmao;
        /**
<<<<<<< HEAD
         * date : 01日星期一
         * sunrise : 07:58
         * high : 高温 12.0℃
         * low : 低温 1.0℃
         * sunset : 18:02
         * aqi : 96
         * fx : 无持续风向
         * fl : <3级
         * type : 多云
         * notice : 今日多云，骑上单车去看看世界吧
=======
         * date : 08日星期一
         * sunrise : 07:59
         * high : 高温 9.0℃
         * low : 低温 -1.0℃
         * sunset : 18:07
         * aqi : 58.0
         * fx : 无持续风向
         * fl : <3级
         * type : 晴
         * notice : lovely sunshine，尽情享受阳光的温暖吧
>>>>>>> 4bb38b8fbd891b6d352d16ecf932baedc6cb12c9
         */

        private YesterdayBean yesterday;
        /**
<<<<<<< HEAD
         * date : 02日星期二
         * sunrise : 07:58
         * high : 高温 8.0℃
         * low : 低温 2.0℃
         * sunset : 18:02
         * aqi : 80
         * fx : 无持续风向
         * fl : <3级
         * type : 小雨
         * notice : 下雨了不要紧，撑伞挡挡就行
=======
         * date : 09日星期二
         * sunrise : 07:59
         * high : 高温 11.0℃
         * low : 低温 -2.0℃
         * sunset : 18:08
         * aqi : 50.0
         * fx : 无持续风向
         * fl : <3级
         * type : 晴
         * notice : lovely sunshine，尽情享受阳光的温暖吧
>>>>>>> 4bb38b8fbd891b6d352d16ecf932baedc6cb12c9
         */

        private List<ForecastBean> forecast;

        public String getShidu() {
            return shidu;
        }

        public void setShidu(String shidu) {
            this.shidu = shidu;
        }

<<<<<<< HEAD
        public int getPm25() {
            return pm25;
        }

        public void setPm25(int pm25) {
            this.pm25 = pm25;
        }

        public int getPm10() {
            return pm10;
        }

        public void setPm10(int pm10) {
=======
        public double getPm25() {
            return pm25;
        }

        public void setPm25(double pm25) {
            this.pm25 = pm25;
        }

        public double getPm10() {
            return pm10;
        }

        public void setPm10(double pm10) {
>>>>>>> 4bb38b8fbd891b6d352d16ecf932baedc6cb12c9
            this.pm10 = pm10;
        }

        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }

        public String getWendu() {
            return wendu;
        }

        public void setWendu(String wendu) {
            this.wendu = wendu;
        }

        public String getGanmao() {
            return ganmao;
        }

        public void setGanmao(String ganmao) {
            this.ganmao = ganmao;
        }

        public YesterdayBean getYesterday() {
            return yesterday;
        }

        public void setYesterday(YesterdayBean yesterday) {
            this.yesterday = yesterday;
        }

        public List<ForecastBean> getForecast() {
            return forecast;
        }

        public void setForecast(List<ForecastBean> forecast) {
            this.forecast = forecast;
        }

        public static class YesterdayBean {
            private String date;
            private String sunrise;
            private String high;
            private String low;
            private String sunset;
<<<<<<< HEAD
            private int aqi;
=======
            private double aqi;
>>>>>>> 4bb38b8fbd891b6d352d16ecf932baedc6cb12c9
            private String fx;
            private String fl;
            private String type;
            private String notice;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getSunset() {
                return sunset;
            }

            public void setSunset(String sunset) {
                this.sunset = sunset;
            }

<<<<<<< HEAD
            public int getAqi() {
                return aqi;
            }

            public void setAqi(int aqi) {
=======
            public double getAqi() {
                return aqi;
            }

            public void setAqi(double aqi) {
>>>>>>> 4bb38b8fbd891b6d352d16ecf932baedc6cb12c9
                this.aqi = aqi;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }
        }

        public static class ForecastBean {
            private String date;
            private String sunrise;
            private String high;
            private String low;
            private String sunset;
<<<<<<< HEAD
            private int aqi;
=======
            private double aqi;
>>>>>>> 4bb38b8fbd891b6d352d16ecf932baedc6cb12c9
            private String fx;
            private String fl;
            private String type;
            private String notice;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getSunset() {
                return sunset;
            }

            public void setSunset(String sunset) {
                this.sunset = sunset;
            }

<<<<<<< HEAD
            public int getAqi() {
                return aqi;
            }

            public void setAqi(int aqi) {
=======
            public double getAqi() {
                return aqi;
            }

            public void setAqi(double aqi) {
>>>>>>> 4bb38b8fbd891b6d352d16ecf932baedc6cb12c9
                this.aqi = aqi;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }
        }
    }
}
