package com.hbandroid.fragmentactivitydemo.db.http.entity;

import java.util.List;

/**
 * Title: singleActivityDemo
 * <p>
 * Description:
 * <p>
 * Author:baigege (baigegechen@gmail.com)
 * <p>
 * Date:2018-01-09
 */

public class WeatherDto {


    /**
     * date : 20180109
     * message : Success !
     * status : 200
     * city : 广元
     * count : 1
     * data : {"shidu":"69%","pm25":21,"pm10":71,"quality":"良","wendu":"-3","ganmao":"极少数敏感人群应减少户外活动","yesterday":{"date":"08日星期一","sunrise":"07:59","high":"高温 9.0℃","low":"低温 -1.0℃","sunset":"18:07","aqi":58,"fx":"无持续风向","fl":"<3级","type":"晴","notice":"lovely sunshine，尽情享受阳光的温暖吧"},"forecast":[{"date":"09日星期二","sunrise":"07:59","high":"高温 11.0℃","low":"低温 -2.0℃","sunset":"18:08","aqi":50,"fx":"无持续风向","fl":"<3级","type":"晴","notice":"lovely sunshine，尽情享受阳光的温暖吧"},{"date":"10日星期三","sunrise":"07:59","high":"高温 12.0℃","low":"低温 -2.0℃","sunset":"18:09","aqi":98,"fx":"无持续风向","fl":"<3级","type":"晴","notice":"晴空万里，去沐浴阳光吧"},{"date":"11日星期四","sunrise":"07:59","high":"高温 12.0℃","low":"低温 -2.0℃","sunset":"18:09","aqi":97,"fx":"无持续风向","fl":"<3级","type":"晴","notice":"lovely sunshine，尽情享受阳光的温暖吧"},{"date":"12日星期五","sunrise":"07:59","high":"高温 11.0℃","low":"低温 2.0℃","sunset":"18:10","aqi":99,"fx":"无持续风向","fl":"<3级","type":"多云","notice":"今日多云，骑上单车去看看世界吧"},{"date":"13日星期六","sunrise":"07:59","high":"高温 8.0℃","low":"低温 2.0℃","sunset":"18:11","aqi":93,"fx":"无持续风向","fl":"<3级","type":"小雨","notice":"外出时请注意关好门窗，防止雨水飘入"}]}
     */

    private String date;
    private String message;
    private int status;
    private String city;
    private int count;
    /**
     * shidu : 69%
     * pm25 : 21.0
     * pm10 : 71.0
     * quality : 良
     * wendu : -3
     * ganmao : 极少数敏感人群应减少户外活动
     * yesterday : {"date":"08日星期一","sunrise":"07:59","high":"高温 9.0℃","low":"低温 -1.0℃","sunset":"18:07","aqi":58,"fx":"无持续风向","fl":"<3级","type":"晴","notice":"lovely sunshine，尽情享受阳光的温暖吧"}
     * forecast : [{"date":"09日星期二","sunrise":"07:59","high":"高温 11.0℃","low":"低温 -2.0℃","sunset":"18:08","aqi":50,"fx":"无持续风向","fl":"<3级","type":"晴","notice":"lovely sunshine，尽情享受阳光的温暖吧"},{"date":"10日星期三","sunrise":"07:59","high":"高温 12.0℃","low":"低温 -2.0℃","sunset":"18:09","aqi":98,"fx":"无持续风向","fl":"<3级","type":"晴","notice":"晴空万里，去沐浴阳光吧"},{"date":"11日星期四","sunrise":"07:59","high":"高温 12.0℃","low":"低温 -2.0℃","sunset":"18:09","aqi":97,"fx":"无持续风向","fl":"<3级","type":"晴","notice":"lovely sunshine，尽情享受阳光的温暖吧"},{"date":"12日星期五","sunrise":"07:59","high":"高温 11.0℃","low":"低温 2.0℃","sunset":"18:10","aqi":99,"fx":"无持续风向","fl":"<3级","type":"多云","notice":"今日多云，骑上单车去看看世界吧"},{"date":"13日星期六","sunrise":"07:59","high":"高温 8.0℃","low":"低温 2.0℃","sunset":"18:11","aqi":93,"fx":"无持续风向","fl":"<3级","type":"小雨","notice":"外出时请注意关好门窗，防止雨水飘入"}]
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
        private double pm25;
        private double pm10;
        private String quality;
        private String wendu;
        private String ganmao;
        /**
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
         */

        private YesterdayBean yesterday;
        /**
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
         */

        private List<ForecastBean> forecast;

        public String getShidu() {
            return shidu;
        }

        public void setShidu(String shidu) {
            this.shidu = shidu;
        }

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
            private double aqi;
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

            public double getAqi() {
                return aqi;
            }

            public void setAqi(double aqi) {
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
            private double aqi;
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

            public double getAqi() {
                return aqi;
            }

            public void setAqi(double aqi) {
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
