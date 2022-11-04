package com.e.mademvvm.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2018/7/24.
 */

public class SharePreUril {
    SharedPreferences share;
    SharedPreferences shareAPK;    // 此处保存的不因退出而删除
    Context ctx;

    public SharePreUril(Context ctx) {
        super();
        this.ctx = ctx;
        share = ctx.getSharedPreferences("sp_demo", Context.MODE_PRIVATE);// share为存储名称
        shareAPK = ctx.getSharedPreferences("sp_demo_apk", Context.MODE_PRIVATE);// shareAPK为存储名称
        System.out.print(share);

    }

    public void clear(){
        share.edit().clear().commit();
    }

    /**
     * 存
     *
     * @param firstUse
     */
    public void putFirstUse(int firstUse) {
        share.edit().putInt("firstUse", firstUse).commit();
    }

    public void putToken(String Token) {
        share.edit().putString("Token", Token).commit();
    }

    public void putRefreshToken(String RefreshToken) {
        share.edit().putString("RefreshToken", RefreshToken).commit();
    }
    // 2019/11/8 保存 apk 是否下载 true - 下载成功
    public void putAPK(boolean apkNew) {
        shareAPK.edit().putBoolean("apkNew", apkNew).commit();
    }


    /**
     * 存token的时间
     */
    public void putTokenTime(String TokenTime) {
        share.edit().putString("TokenTime", TokenTime).commit();
    }


    public void putRefreshTokenTime(String RefreshTokenTime) {
        share.edit().putString("RefreshTokenTime", RefreshTokenTime).commit();
    }

    public void putloginState(int loginState) {

        try {
            share.edit().putInt("loginState", loginState).commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e);
        }
    }

    /****
     * 存储组织下的人员名称
     * @param orguserName
     */
    public void putOrgUserName(String orguserName) {
        share.edit().putString("orguserName", orguserName).commit();
    }

    /***
     * 存储机构的级别
     * @param orglevel
     */
    public void putOrglevel(String orglevel) {
        share.edit().putString("orglevel", orglevel).commit();
    }

    /****
     * 存储用户的EXTRA_REGISTRATION_ID
     */
    public void putregistration_id(String registration_id) {
        share.edit().putString("registration_id", registration_id).commit();

    }

    /***
     * 存orgid
     */
    public void putorgid(String orgid) {

        share.edit().putString("orgid", orgid).commit();
    }

    /***
     * 得到
     */
    public String getrRegistration_id() {
        String registration_id;
        registration_id = share.getString("registration_id", "");
        return registration_id;

    }

    /**
     * 获取相关的数据
     *
     * @return
     */
    public int getFirstUse() {
        int firstUse = share.getInt("firstUse", 0);
        return firstUse;

    }

    public String getToken() {
        String userToken;
        userToken = share.getString("Token", "");

        return userToken;
    }

    public String getRefreshToken() {
        String mRefreshToken = share.getString("RefreshToken", "");
        return mRefreshToken;
    }

    public int getloginState() {
        int mloginState;


        ;
        mloginState = share.getInt("loginState", 0);


        return mloginState;
    }

    public String getTokenTime() {


        String userTokenTime = share.getString("TokenTime", "");


        return userTokenTime;
    }

    public String getRefreshTokenTime() {

        String userRefreshTokenTime = share.getString("RefreshTokenTime", "");


        return userRefreshTokenTime;
    }

    /****
     * 获取组织下的人员名称
     * @return
     */
    public String getOrgUserName() {
        String orguserName = share.getString("orguserName", "");
        return orguserName;
    }

    public String getOrglevel() {
        String orglevel = share.getString("orglevel", "2");
        return orglevel;
    }

    /***
     * 获取org的id
     */
    public String getorgid() {
        String getorgid = share.getString("orgid", "");
        return getorgid;
    }

    public void putUserName(String username) {
        share.edit().putString("username", username).commit();
    }

    public String getUserName() {
        String userName = share.getString("username", "");
        return userName;
    }
    // 2019/11/8 获得 apk 是否下载 true - 下载成功
    public boolean getAPK() {
        return shareAPK.getBoolean("apkNew", false);
    }
}