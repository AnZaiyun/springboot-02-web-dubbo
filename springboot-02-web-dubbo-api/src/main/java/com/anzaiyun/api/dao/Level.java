package com.anzaiyun.api.dao;

import com.anzaiyun.api.conf.ChineseNamesAnno;

public class Level {

    private Integer l_id;
    private String vc_name;

    @ChineseNamesAnno(ChineseName = "积分上限")
    private Integer l_jfsx;

    @ChineseNamesAnno(ChineseName = "积分下限")
    private Integer l_jfxx;

    public Level() {
    }

    public Level(String vc_name, Integer l_jfsx, Integer l_jfxx) {
        this.vc_name = vc_name;
        this.l_jfsx = l_jfsx;
        this.l_jfxx = l_jfxx;
    }

    public Integer getL_id() {
        return l_id;
    }

    public void setL_id(Integer l_id) {
        this.l_id = l_id;
    }

    public String getVc_name() {
        return vc_name;
    }

    public void setVc_name(String vc_name) {
        this.vc_name = vc_name;
    }

    public Integer getL_jfsx() {
        return l_jfsx;
    }

    public void setL_jfsx(Integer l_jfsx) {
        this.l_jfsx = l_jfsx;
    }

    public Integer getL_jfxx() {
        return l_jfxx;
    }

    public void setL_jfxx(Integer l_jfxx) {
        this.l_jfxx = l_jfxx;
    }
}
