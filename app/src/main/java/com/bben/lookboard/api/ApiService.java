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
package com.bben.lookboard.api;


import com.bben.lookboard.base.Constant;
import com.bben.lookboard.bean.DeptCodeListBean;
import com.bben.lookboard.bean.PatientListBean;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface ApiService {



    /**
     * 根据条件查询床位信息
     */
//    @GET(Constant.BED_GETTBEDVOBYCONDITION)
//    Observable<BedInfoBean> bedcardGetbedinfo(@QueryMap Map<String, String> map);

    /**
     * test
     */
    @GET(Constant.MtTypeService)
    Observable<ResponseBody> test(@QueryMap Map<String, String> map);

    /**
     * 获取病人列表
     */
    @GET(Constant.API_PATIENT_LIST)
    Observable<PatientListBean> FetchPatientList(@QueryMap Map<String, String> map);

    /**
     * 获取科室列表
     */
    @GET(Constant.API_DEPT_CODELIST)
    Observable<DeptCodeListBean> FetchDeptCodeList(@QueryMap Map<String, String> map);




}