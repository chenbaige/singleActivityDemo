package com.hbandroid.fragmentactivitydemo.db.http.entity;

import java.util.List;

/**
 * Title:singleActivityDemo
 * <p>
 * Description:
 * <p>
 * <p>
 * Author: baigege(baigegechen@gmail.com)
 * <p>
 * Date：2017-12-25
 */

public class TestEntity {


    /**
     * status : 1
     * data : {"MatchType":100,"Type":"1|2|3|6","GameSystemId":"knockout match","TypeNames":[{"TypeName":"Warfare Team"},{"TypeName":"Individuals"},{"TypeName":"Online"},{"TypeName":"Water Friendly"}],"MatchImage":"/Public/upload/matchs/2017-12-15/5a339c556a753.jpeg","Terrace":"0","MatchInfo":"","GameName":"League of Legends","arrange":[{"Time":"12-15 17:56","status":0,"msg":"Create Game"},{"status":0,"msg":"Passed Audit"},{"Time":"12-15 18:05","status":0,"msg":"Registration Time"},{"Time":"12-15 19:15","status":1,"msg":"Registration Deadline"},{"Time":"12-15 19:16","status":0,"msg":"Tournament Starts"},{"Time":"12-16 17:56","status":0,"msg":"Game Over"}],"Isend":"1","time":"2017-12-16 17:56","Address":" ","MatchName":"测3","bonus":{"countBonus":0,"personagePrice":"5.00","personageCount":0,"MaxForTheDreamCount":"16","ForTheDreamCount":0,"MaxpersonageCount":"8","ForTheDreamPrice":"5.00"},"GameLogoSmall":"/Public/upload/gamelogo/5a338f8e65314.png","MatchRule":"","GameSystemIdCorps":"knockout match","MatchId":"128"}
     */

    private int status;
    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * MatchType : 100
         * Type : 1|2|3|6
         * GameSystemId : knockout match
         * TypeNames : [{"TypeName":"Warfare Team"},{"TypeName":"Individuals"},{"TypeName":"Online"},{"TypeName":"Water Friendly"}]
         * MatchImage : /Public/upload/matchs/2017-12-15/5a339c556a753.jpeg
         * Terrace : 0
         * MatchInfo :
         * GameName : League of Legends
         * arrange : [{"Time":"12-15 17:56","status":0,"msg":"Create Game"},{"status":0,"msg":"Passed Audit"},{"Time":"12-15 18:05","status":0,"msg":"Registration Time"},{"Time":"12-15 19:15","status":1,"msg":"Registration Deadline"},{"Time":"12-15 19:16","status":0,"msg":"Tournament Starts"},{"Time":"12-16 17:56","status":0,"msg":"Game Over"}]
         * Isend : 1
         * time : 2017-12-16 17:56
         * Address :
         * MatchName : 测3
         * bonus : {"countBonus":0,"personagePrice":"5.00","personageCount":0,"MaxForTheDreamCount":"16","ForTheDreamCount":0,"MaxpersonageCount":"8","ForTheDreamPrice":"5.00"}
         * GameLogoSmall : /Public/upload/gamelogo/5a338f8e65314.png
         * MatchRule :
         * GameSystemIdCorps : knockout match
         * MatchId : 128
         */

        private int MatchType;
        private String Type;
        private String GameSystemId;
        private String MatchImage;
        private String Terrace;
        private String MatchInfo;
        private String GameName;
        private String Isend;
        private String time;
        private String Address;
        private String MatchName;
        private BonusBean bonus;
        private String GameLogoSmall;
        private String MatchRule;
        private String GameSystemIdCorps;
        private String MatchId;
        private List<TypeNamesBean> TypeNames;
        private List<ArrangeBean> arrange;

        public int getMatchType() {
            return MatchType;
        }

        public void setMatchType(int MatchType) {
            this.MatchType = MatchType;
        }

        public String getType() {
            return Type;
        }

        public void setType(String Type) {
            this.Type = Type;
        }

        public String getGameSystemId() {
            return GameSystemId;
        }

        public void setGameSystemId(String GameSystemId) {
            this.GameSystemId = GameSystemId;
        }

        public String getMatchImage() {
            return MatchImage;
        }

        public void setMatchImage(String MatchImage) {
            this.MatchImage = MatchImage;
        }

        public String getTerrace() {
            return Terrace;
        }

        public void setTerrace(String Terrace) {
            this.Terrace = Terrace;
        }

        public String getMatchInfo() {
            return MatchInfo;
        }

        public void setMatchInfo(String MatchInfo) {
            this.MatchInfo = MatchInfo;
        }

        public String getGameName() {
            return GameName;
        }

        public void setGameName(String GameName) {
            this.GameName = GameName;
        }

        public String getIsend() {
            return Isend;
        }

        public void setIsend(String Isend) {
            this.Isend = Isend;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String Address) {
            this.Address = Address;
        }

        public String getMatchName() {
            return MatchName;
        }

        public void setMatchName(String MatchName) {
            this.MatchName = MatchName;
        }

        public BonusBean getBonus() {
            return bonus;
        }

        public void setBonus(BonusBean bonus) {
            this.bonus = bonus;
        }

        public String getGameLogoSmall() {
            return GameLogoSmall;
        }

        public void setGameLogoSmall(String GameLogoSmall) {
            this.GameLogoSmall = GameLogoSmall;
        }

        public String getMatchRule() {
            return MatchRule;
        }

        public void setMatchRule(String MatchRule) {
            this.MatchRule = MatchRule;
        }

        public String getGameSystemIdCorps() {
            return GameSystemIdCorps;
        }

        public void setGameSystemIdCorps(String GameSystemIdCorps) {
            this.GameSystemIdCorps = GameSystemIdCorps;
        }

        public String getMatchId() {
            return MatchId;
        }

        public void setMatchId(String MatchId) {
            this.MatchId = MatchId;
        }

        public List<TypeNamesBean> getTypeNames() {
            return TypeNames;
        }

        public void setTypeNames(List<TypeNamesBean> TypeNames) {
            this.TypeNames = TypeNames;
        }

        public List<ArrangeBean> getArrange() {
            return arrange;
        }

        public void setArrange(List<ArrangeBean> arrange) {
            this.arrange = arrange;
        }

        public static class BonusBean {
            /**
             * countBonus : 0
             * personagePrice : 5.00
             * personageCount : 0
             * MaxForTheDreamCount : 16
             * ForTheDreamCount : 0
             * MaxpersonageCount : 8
             * ForTheDreamPrice : 5.00
             */

            private int countBonus;
            private String personagePrice;
            private int personageCount;
            private String MaxForTheDreamCount;
            private int ForTheDreamCount;
            private String MaxpersonageCount;
            private String ForTheDreamPrice;

            public int getCountBonus() {
                return countBonus;
            }

            public void setCountBonus(int countBonus) {
                this.countBonus = countBonus;
            }

            public String getPersonagePrice() {
                return personagePrice;
            }

            public void setPersonagePrice(String personagePrice) {
                this.personagePrice = personagePrice;
            }

            public int getPersonageCount() {
                return personageCount;
            }

            public void setPersonageCount(int personageCount) {
                this.personageCount = personageCount;
            }

            public String getMaxForTheDreamCount() {
                return MaxForTheDreamCount;
            }

            public void setMaxForTheDreamCount(String MaxForTheDreamCount) {
                this.MaxForTheDreamCount = MaxForTheDreamCount;
            }

            public int getForTheDreamCount() {
                return ForTheDreamCount;
            }

            public void setForTheDreamCount(int ForTheDreamCount) {
                this.ForTheDreamCount = ForTheDreamCount;
            }

            public String getMaxpersonageCount() {
                return MaxpersonageCount;
            }

            public void setMaxpersonageCount(String MaxpersonageCount) {
                this.MaxpersonageCount = MaxpersonageCount;
            }

            public String getForTheDreamPrice() {
                return ForTheDreamPrice;
            }

            public void setForTheDreamPrice(String ForTheDreamPrice) {
                this.ForTheDreamPrice = ForTheDreamPrice;
            }
        }

        public static class TypeNamesBean {
            /**
             * TypeName : Warfare Team
             */

            private String TypeName;

            public String getTypeName() {
                return TypeName;
            }

            public void setTypeName(String TypeName) {
                this.TypeName = TypeName;
            }
        }

        public static class ArrangeBean {
            /**
             * Time : 12-15 17:56
             * status : 0
             * msg : Create Game
             */

            private String Time;
            private int status;
            private String msg;

            public String getTime() {
                return Time;
            }

            public void setTime(String Time) {
                this.Time = Time;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getMsg() {
                return msg;
            }

            public void setMsg(String msg) {
                this.msg = msg;
            }
        }
    }
}
