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

public class TestBaseEntity {

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
    private TestEntity.DataBean.BonusBean bonus;
    private String GameLogoSmall;
    private String MatchRule;
    private String GameSystemIdCorps;
    private String MatchId;
    private List<TestEntity.DataBean.TypeNamesBean> TypeNames;
    private List<TestEntity.DataBean.ArrangeBean> arrange;

    public int getMatchType() {
        return MatchType;
    }

    public void setMatchType(int matchType) {
        MatchType = matchType;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getGameSystemId() {
        return GameSystemId;
    }

    public void setGameSystemId(String gameSystemId) {
        GameSystemId = gameSystemId;
    }

    public String getMatchImage() {
        return MatchImage;
    }

    public void setMatchImage(String matchImage) {
        MatchImage = matchImage;
    }

    public String getTerrace() {
        return Terrace;
    }

    public void setTerrace(String terrace) {
        Terrace = terrace;
    }

    public String getMatchInfo() {
        return MatchInfo;
    }

    public void setMatchInfo(String matchInfo) {
        MatchInfo = matchInfo;
    }

    public String getGameName() {
        return GameName;
    }

    public void setGameName(String gameName) {
        GameName = gameName;
    }

    public String getIsend() {
        return Isend;
    }

    public void setIsend(String isend) {
        Isend = isend;
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

    public void setAddress(String address) {
        Address = address;
    }

    public String getMatchName() {
        return MatchName;
    }

    public void setMatchName(String matchName) {
        MatchName = matchName;
    }

    public TestEntity.DataBean.BonusBean getBonus() {
        return bonus;
    }

    public void setBonus(TestEntity.DataBean.BonusBean bonus) {
        this.bonus = bonus;
    }

    public String getGameLogoSmall() {
        return GameLogoSmall;
    }

    public void setGameLogoSmall(String gameLogoSmall) {
        GameLogoSmall = gameLogoSmall;
    }

    public String getMatchRule() {
        return MatchRule;
    }

    public void setMatchRule(String matchRule) {
        MatchRule = matchRule;
    }

    public String getGameSystemIdCorps() {
        return GameSystemIdCorps;
    }

    public void setGameSystemIdCorps(String gameSystemIdCorps) {
        GameSystemIdCorps = gameSystemIdCorps;
    }

    public String getMatchId() {
        return MatchId;
    }

    public void setMatchId(String matchId) {
        MatchId = matchId;
    }

    public List<TestEntity.DataBean.TypeNamesBean> getTypeNames() {
        return TypeNames;
    }

    public void setTypeNames(List<TestEntity.DataBean.TypeNamesBean> typeNames) {
        TypeNames = typeNames;
    }

    public List<TestEntity.DataBean.ArrangeBean> getArrange() {
        return arrange;
    }

    public void setArrange(List<TestEntity.DataBean.ArrangeBean> arrange) {
        this.arrange = arrange;
    }
}
