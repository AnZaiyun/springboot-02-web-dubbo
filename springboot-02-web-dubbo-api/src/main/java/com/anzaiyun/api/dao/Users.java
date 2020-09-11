package com.anzaiyun.api.dao;

import com.anzaiyun.api.conf.ChineseNamesAnno;

import java.io.Serializable;
import java.util.Date;

public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @ChineseNamesAnno(ChineseName = "唯一标识符")
    private int l_id;

    @ChineseNamesAnno(ChineseName = "用户名")
    private String vc_name;

    @ChineseNamesAnno(ChineseName = "性别（1：男；2：女）")
    private int l_sex;

    @ChineseNamesAnno(ChineseName = "电话")
    private String l_tel;

    @ChineseNamesAnno(ChineseName = "邮箱")
    private String vc_mail;

    @ChineseNamesAnno(ChineseName = "地址")
    private String vc_address;

    @ChineseNamesAnno(ChineseName = "时间")
    private Date d_jrsj;

    @ChineseNamesAnno(ChineseName = "状态")
    private int l_state;

    public Users() {
    }

    public Users(String vc_name, String l_TEL, String VC_MAIL) {
        this.vc_name = vc_name;
        l_tel = l_TEL;
        this.vc_mail = VC_MAIL;
    }

    public Users(int l_id, String vc_name, int l_sex, String l_tel, String vc_mail, String vc_address, Date d_jrsj, int l_state) {
        this.l_id = l_id;
        this.vc_name = vc_name;
        this.l_sex = l_sex;
        this.l_tel = l_tel;
        this.vc_mail = vc_mail;
        this.vc_address = vc_address;
        this.d_jrsj = d_jrsj;
        this.l_state = l_state;
    }

    public int getL_id() {
        return l_id;
    }

    public void setL_id(int l_id) {
        this.l_id = l_id;
    }

    public String getVc_name() {
        return vc_name;
    }

    public void setVc_name(String vc_name) {
        this.vc_name = vc_name;
    }

    public int getL_sex() {
        return l_sex;
    }

    public void setL_sex(int l_sex) {
        this.l_sex = l_sex;
    }

    public String getL_tel() {
        return l_tel;
    }

    public void setL_tel(String l_tel) {
        this.l_tel = l_tel;
    }

    public String getVc_mail() {
        return vc_mail;
    }

    public void setVc_mail(String vc_mail) {
        this.vc_mail = vc_mail;
    }

    public String getVc_address() {
        return vc_address;
    }

    public void setVc_address(String vc_address) {
        this.vc_address = vc_address;
    }

    public Date getD_jrsj() {
        return d_jrsj;
    }

    public void setD_jrsj(Date d_jrsj) {
        this.d_jrsj = d_jrsj;
    }

    public int getL_state() {
        return l_state;
    }

    public void setL_state(int l_state) {
        this.l_state = l_state;
    }
}
