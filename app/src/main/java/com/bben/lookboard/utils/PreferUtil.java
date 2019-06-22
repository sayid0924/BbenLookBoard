/**
 * Copyright(C)2012-2013 深圳市掌星立意科技有限公司版权所有
 * 创 建 人:Jacky
 * 修 改 人:
 * 创 建日期:2013-7-25
 * 描    述:xml储存数据
 * 版 本 号:
 */
package com.bben.lookboard.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.bben.lookboard.R;
import com.bben.lookboard.base.BaseApplication;


public final class PreferUtil {

    private static Context context;

    public static PreferUtil INSTANCE;
    private static SharedPreferences mPrefer;
    private static final String APP_NAME = "com.bben.bedside";

    private static final String BASE_URL = "base_url";
    private static final String SERVER_PORT = "server_port";
    private static final String SOCKET_PORT = "socket_port";
    private static final String SOCKET_IP = "socket_ip";
    private static final String IS_FIRST = "is_first";
    private static final String RABBITMQ_IP = "rabbitmq_ip";
    private static final String RABBITMQ_PORT = "rabbitmq_port";
    private static final String LOCATION_INFO = "Location_Info";
    private static final String DEVICE_NAME = "device_name";
    private static final String QUEUE_NAME = "queue_name";
    private static final String LOOK_IP = "look_ip";
    private static final String THEME_TYPE = "theme_type";
    private static final String ITEM_VALUE = "item_value";
    private static final String ITEM_SPACING_VALUE = "item_spacing_value";
    private static final String TYPEFACE_VALUE = "typeface_value";
    private static final String TYPEFACE_NAME_VALUE = "typeface_name_value";
    private static final String WIDTH_VALUE = "width_value";
    private static final String HIGHT_VALUE = "hight_value";
    private static final String DEPTCODE = "deptCode";
    private static final String DEPTNAME = "deptName";
    private static final String TYPEFACE_INFUSION_VALUE = "typeface_infusion_value";

    public  void  setDeptName(String fag){
        putString(DEPTNAME, fag);
    }

    public  String getDeptName(){
        return getString(DEPTNAME,"");
    }


    public  void  setDeptCode(String fag){
        putString(DEPTCODE, fag);
    }

    public  String getDeptCode(){
        return getString(DEPTCODE,"");
    }

    public void setItemSpacingValue(int fag){
        putInt(ITEM_SPACING_VALUE,fag);
    }

    public  int getItemSpacingValue(){
        return  getInt(ITEM_SPACING_VALUE,10);
    }

    public  void setHightValue(int fag){
        putInt(HIGHT_VALUE,fag);
    }

    public int getHightValue(){
        return getInt(HIGHT_VALUE,300);
    }

    public  void setWidthValue(int fag){
        putInt(WIDTH_VALUE,fag);
    }

    public int getWidthValue(){
        return  getInt(WIDTH_VALUE,200);
    }

    public  void  setTypefaceNmeValue(int fag){
        putInt(TYPEFACE_NAME_VALUE,fag);
    }

    public int getTypefaceNameValue(){
        return  getInt(TYPEFACE_NAME_VALUE,23);
    }
    public  void  setTypefaceValue(int fag){
        putInt(TYPEFACE_VALUE,fag);
    }

    public int getTypefaceValue(){
        return  getInt(TYPEFACE_VALUE,18);
    }

    public  void  setInfusionTypefaceValue(int fag){
        putInt(TYPEFACE_INFUSION_VALUE,fag);
    }

    public int getInfusionTypefaceValue(){
        return  getInt(TYPEFACE_INFUSION_VALUE,15);
    }

    public void setItemValue(int fag){
        putInt(ITEM_VALUE,fag);
    }

    public  int getItemValue(){
        return  getInt(ITEM_VALUE,10);
    }

    public void setThemeType(String fag) {
        putString(BASE_URL, fag);
    }

    public String getThemeType() {
        return getString(BASE_URL, "def");
    }


    public void setBaseUrl(String fag) {
        putString(BASE_URL, fag);
    }

    public String getBaseUrl() {
        return getString(BASE_URL, context.getResources().getString(R.string.default_server_url));
    }

    public void setServerPort(String fag) {
        putString(SERVER_PORT, fag);
    }

    public String getServerPort() {
        return getString(SERVER_PORT, context.getResources().getString(R.string.server_port));
    }

    public void setSocketPort(String fag) {
        putString(SOCKET_PORT, fag);
    }

    public String getSoketPort() {
        return getString(SOCKET_PORT, context.getResources().getString(R.string.socket_port));
    }


    public void setLookIp(String fag) {
        putString(LOOK_IP, fag);
    }

    public String getLookIp() {
        return getString(LOOK_IP, context.getResources().getString(R.string.look_ip));
    }


    public void setSocketIp(String fag) {
        putString(SOCKET_IP, fag);
    }

    public String getSoketIp() {
        return getString(SOCKET_IP, context.getResources().getString(R.string.socket_ip));
    }


    public void setRabbitmqIp(String fag) {
        putString(RABBITMQ_IP, fag);
    }

    public String getRabbitmqIp() {
        return getString(RABBITMQ_IP, context.getResources().getString(R.string.rabbit_ip) );
    }

    public void setRabbitmqPort(String fag) {
        putString(RABBITMQ_PORT, fag);
    }

    public String getRabbitmqPort() {
        return getString(RABBITMQ_PORT, context.getResources().getString(R.string.rabbit_port) );
    }


    public void setQueueName(String fag) {
        putString(QUEUE_NAME, fag);
    }

    public String getQueueName() {
        return getString(QUEUE_NAME, context.getResources().getString(R.string.queue_name) );
    }

    public void setDeviceName(String fag) {
        putString(DEVICE_NAME, fag);
    }

    public String getDeviceName() {
        return getString(DEVICE_NAME, context.getResources().getString(R.string.device_name) );
    }

    public void setIsFirst(boolean fag) {
        putBoolean(IS_FIRST, fag);
    }

    public boolean getIsFirst() {
        return getBoolean(IS_FIRST, false);
    }

    public void setLocationInfo(String fag) {
        putString(LOCATION_INFO, fag);
    }

    public String getLocationInfo() {
        return getString(LOCATION_INFO, "");
    }



    private PreferUtil() {
    }

    public static PreferUtil getInstance() {

        if (INSTANCE == null) {
            context = BaseApplication.getContext();
            return new PreferUtil();
        }
        return INSTANCE;
    }

    public void init(Context ctx) {
        mPrefer = ctx.getSharedPreferences(APP_NAME, Context.MODE_PRIVATE
                | Context.MODE_PRIVATE);
        mPrefer.edit().commit();
    }


    public String getString(String key, String defValue) {
        return mPrefer.getString(key, defValue);
    }

    public int getInt(String key, int defValue) {
        return mPrefer.getInt(key, defValue);
    }

    public boolean getBoolean(String key, boolean defValue) {
        return mPrefer.getBoolean(key, defValue);
    }

    public void putString(String key, String value) {
        mPrefer.edit().putString(key, value).commit();
    }




    public void putInt(String key, int value) {
        mPrefer.edit().putInt(key, value).commit();
    }

    public void putBoolean(String key, boolean value) {
        mPrefer.edit().putBoolean(key, value).commit();
    }

    public void putLong(String key, long value) {
        mPrefer.edit().putLong(key, value).commit();
    }

    public long getLong(String key, long defValue) {
        return mPrefer.getLong(key, defValue);
    }

    public void removeKey(String key) {
        mPrefer.edit().remove(key).commit();
    }


}
