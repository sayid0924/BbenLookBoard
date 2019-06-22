/**
 * Copyright 2016 JustWayward Team
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bben.lookboard.base;

import android.os.Build;

public class Constant {
    public static boolean IS_RING = false; //是否正在呼叫护士
    public static boolean IS_VIDEO = false; //是否正在音视频呼叫护士


    public static final int STATE_UNKNOWN = 0;
    public static final int STATE_LOADING = 1;
    public static final int STATE_ERROR = 2;
    public static final int STATE_EMPTY = 3;
    public static final int STATE_SUCCESS = 4;


    public static final String ClientId = Build.SERIAL;   //设备号码
    public static final String EquipmentType = "2";    //设备类型

    public static boolean canPickupVoip = true;

    public static final String ENCOD="gbk";

    /**文本消息端口*/
    public static final int MESSAGE_PORT=42836;
    /**语音消息端口*/
    public static final int VOICE_PORT=42837;
    /**文件消息端口*/
    public static final int FILE_PORT=42838;
    /**视屏流端口*/
    public static final int VIDEO_PORT=42839;
    /**局域网内所有ip*/
    public static final String ALL_ADDRESS="255.255.255.255";

    public static final String ACTION_ADD_USER="com.ty.winchat.adduser";

    public static final String id="d6228819a8cca82a";
    public static final String key="bc72c19fc590f2bc";


    //生产环境
    public static final String API_BASE_URL = "http://yspsj.885505.com/";
    public static final String BaseImgUrl = "http://yspsj.885505.com";



    // 根据病区id查询病区所在病人的信息
//    public static final String BED_GETTBEDVOBYCONDITION = "/nurseboard-service/nurseBoard/selectAllPatientByWard";

    public static final String BED_GETTBEDVOBYCONDITION = "/JKList.ashx";

    // test
    public static final String MtTypeService = "/WebService.asmx";

    /**
     * 获取病人列表
     */
    public static final String API_PATIENT_LIST = "api/patient/list";

    /**
     * 获取科室列表
     */
    public static final String API_DEPT_CODELIST = "api/dept/codeList";





}
