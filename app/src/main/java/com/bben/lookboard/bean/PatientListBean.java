package com.bben.lookboard.bean;

import java.util.List;

public class PatientListBean {


    /**
     * code : 0
     * status : 0
     * message : 成功
     * msg : 成功
     * count : 0
     * timestamp : 2019-04-25T10:49:44.918Z
     * data : [{"bedId":1,"bedCode":"L01","bedName":"L01床","bedName2":"L01床","patientId":1,"code":"3000854","cureNo":"098170","name":"刘四媛","sex":1,"sexText":"女","age":"20","inTime":"2018-09-27","diagnose":"诊断测试1","allergy":"过敏测试1","doctorCode":"00262","doctorName":"欧阳善聪","nurseCode":"00133","nurseName":"何苗","nurseLevelCode":"1","nurseLevelName":"Ⅰ级护理","nurseLevelBgColor":"#ae0502","nurseLevelFontColor":"#FFF"},{"bedId":2,"bedCode":"L02","bedName":"L02床","bedName2":"L02床","patientId":2,"code":"3001913","cureNo":"098149","name":"骆宇轩","sex":1,"sexText":"女","age":"1岁 6月","inTime":"2018-09-28","diagnose":"诊断测试4","allergy":"过敏测试3","doctorCode":"00263","doctorName":"靳爱莉","nurseCode":"00119","nurseName":"鲍晓敏","nurseLevelCode":"2","nurseLevelName":"Ⅱ级护理","nurseLevelBgColor":"#2eb827","nurseLevelFontColor":"#FFF"},{"bedId":3,"bedCode":"L03","bedName":"L03床","bedName2":"L03床","patientId":3,"code":"3002609","cureNo":"098282","name":"彭晓慧","sex":1,"sexText":"女","age":"1岁 6月","inTime":"2018-09-29","diagnose":null,"allergy":null,"doctorCode":"00266","doctorName":"赵立奇","nurseCode":null,"nurseName":null,"nurseLevelCode":"3","nurseLevelName":"Ⅲ级护理","nurseLevelBgColor":"#009688","nurseLevelFontColor":"#FFF"},{"bedId":4,"bedCode":"L04","bedName":"L04床","bedName2":"L04床","patientId":4,"code":"3003266","cureNo":"098289","name":"叶觉英","sex":1,"sexText":"女","age":"1岁 6月","inTime":"2018-09-30","diagnose":null,"allergy":null,"doctorCode":"00267","doctorName":"熊琪","nurseCode":null,"nurseName":null,"nurseLevelCode":"1","nurseLevelName":"Ⅰ级护理","nurseLevelBgColor":"#ae0502","nurseLevelFontColor":"#FFF"},{"bedId":5,"bedCode":"L05","bedName":"L05床","bedName2":"L05床","patientId":5,"code":"3003711","cureNo":"098243","name":"钟雯清","sex":1,"sexText":"女","age":"1岁 6月","inTime":"2018-10-01","diagnose":null,"allergy":null,"doctorCode":"00272","doctorName":"高倩","nurseCode":null,"nurseName":null,"nurseLevelCode":"2","nurseLevelName":"Ⅱ级护理","nurseLevelBgColor":"#2eb827","nurseLevelFontColor":"#FFF"},{"bedId":6,"bedCode":"M1501","bedName":"M1501床","bedName2":"01床","patientId":6,"code":"3004031","cureNo":"098221","name":"高婵","sex":1,"sexText":"女","age":"1岁 6月","inTime":"2018-10-02","diagnose":"诊断测试6","allergy":"过敏测试6","doctorCode":"00274","doctorName":"王新","nurseCode":"00119","nurseName":"鲍晓敏","nurseLevelCode":"3","nurseLevelName":"Ⅲ级护理","nurseLevelBgColor":"#009688","nurseLevelFontColor":"#FFF"},{"bedId":7,"bedCode":"M1502","bedName":"M1502床","bedName2":"02床","patientId":7,"code":"3007063","cureNo":"098293","name":"周慧欢","sex":1,"sexText":"女","age":"1岁 6月","inTime":"2018-10-03","diagnose":null,"allergy":null,"doctorCode":"00275","doctorName":"吴学祥","nurseCode":null,"nurseName":null,"nurseLevelCode":"1","nurseLevelName":"Ⅰ级护理","nurseLevelBgColor":"#ae0502","nurseLevelFontColor":"#FFF"},{"bedId":8,"bedCode":"M1503","bedName":"M1503床","bedName2":"03床","patientId":8,"code":"3007933","cureNo":"098190","name":"文杏环","sex":1,"sexText":"女","age":"1岁 6月","inTime":"2018-10-04","diagnose":null,"allergy":null,"doctorCode":"00281","doctorName":"戴玉婷","nurseCode":null,"nurseName":null,"nurseLevelCode":"2","nurseLevelName":"Ⅱ级护理","nurseLevelBgColor":"#2eb827","nurseLevelFontColor":"#FFF"},{"bedId":9,"bedCode":"M1504","bedName":"M1504床","bedName2":"04床","patientId":9,"code":"3008097","cureNo":"098247","name":"何玉玲","sex":0,"sexText":"男","age":"6月","inTime":"2018-10-05","diagnose":null,"allergy":null,"doctorCode":"00284","doctorName":"蔡慧","nurseCode":null,"nurseName":null,"nurseLevelCode":"3","nurseLevelName":"Ⅲ级护理","nurseLevelBgColor":"#009688","nurseLevelFontColor":"#FFF"},{"bedId":10,"bedCode":"M1505","bedName":"M1505床","bedName2":"05床","patientId":10,"code":"3008244","cureNo":"098192","name":"李水珍","sex":0,"sexText":"男","age":"6月","inTime":"2018-10-06","diagnose":null,"allergy":null,"doctorCode":"00285","doctorName":"陈雷","nurseCode":null,"nurseName":null,"nurseLevelCode":"1","nurseLevelName":"Ⅰ级护理","nurseLevelBgColor":"#ae0502","nurseLevelFontColor":"#FFF"},{"bedId":11,"bedCode":"M1506","bedName":"M1506床","bedName2":"06床","patientId":11,"code":"3008610","cureNo":"098244","name":"黄秀芳","sex":0,"sexText":"男","age":"6月","inTime":"2018-10-07","diagnose":null,"allergy":null,"doctorCode":"00286","doctorName":"吴俊超","nurseCode":null,"nurseName":null,"nurseLevelCode":"2","nurseLevelName":"Ⅱ级护理","nurseLevelBgColor":"#2eb827","nurseLevelFontColor":"#FFF"},{"bedId":12,"bedCode":"M1507","bedName":"M1507床","bedName2":"07床","patientId":12,"code":"3009292","cureNo":"098134","name":"陈素巧","sex":1,"sexText":"女","age":"6月","inTime":"2018-10-08","diagnose":null,"allergy":null,"doctorCode":"00289","doctorName":"张佳月","nurseCode":null,"nurseName":null,"nurseLevelCode":"3","nurseLevelName":"Ⅲ级护理","nurseLevelBgColor":"#009688","nurseLevelFontColor":"#FFF"},{"bedId":13,"bedCode":"M1508","bedName":"M1508床","bedName2":"08床","patientId":13,"code":"3010161","cureNo":"097695","name":"朱君","sex":1,"sexText":"女","age":"6月","inTime":"2018-10-09","diagnose":null,"allergy":null,"doctorCode":"00291","doctorName":"许脉","nurseCode":null,"nurseName":null,"nurseLevelCode":"1","nurseLevelName":"Ⅰ级护理","nurseLevelBgColor":"#ae0502","nurseLevelFontColor":"#FFF"},{"bedId":14,"bedCode":"M1509","bedName":"M1509床","bedName2":"09床","patientId":14,"code":"3011326","cureNo":"098246","name":"黄惠琼","sex":0,"sexText":"男","age":"6月","inTime":"2018-10-10","diagnose":null,"allergy":null,"doctorCode":"00296","doctorName":"黄星华","nurseCode":null,"nurseName":null,"nurseLevelCode":"2","nurseLevelName":"Ⅱ级护理","nurseLevelBgColor":"#2eb827","nurseLevelFontColor":"#FFF"},{"bedId":15,"bedCode":"M1510","bedName":"M1510床","bedName2":"10床","patientId":15,"code":"3012450","cureNo":"098196","name":"张莉","sex":0,"sexText":"男","age":"6月","inTime":"2018-10-11","diagnose":null,"allergy":null,"doctorCode":"00297","doctorName":"孙菲","nurseCode":null,"nurseName":null,"nurseLevelCode":"3","nurseLevelName":"Ⅲ级护理","nurseLevelBgColor":"#009688","nurseLevelFontColor":"#FFF"},{"bedId":16,"bedCode":"M1511","bedName":"M1511床","bedName2":"11床","patientId":16,"code":"3014265","cureNo":"098263","name":"刘洁丽","sex":1,"sexText":"女","age":"6月","inTime":"2018-10-12","diagnose":null,"allergy":null,"doctorCode":"00300","doctorName":"侯延平","nurseCode":null,"nurseName":null,"nurseLevelCode":"1","nurseLevelName":"Ⅰ级护理","nurseLevelBgColor":"#ae0502","nurseLevelFontColor":"#FFF"},{"bedId":17,"bedCode":"M1512","bedName":"M1512床","bedName2":"12床","patientId":17,"code":"3020432","cureNo":"098295","name":"陈朝维","sex":0,"sexText":"男","age":"6月","inTime":"2018-10-13","diagnose":null,"allergy":null,"doctorCode":"00310","doctorName":"崔洪涛","nurseCode":null,"nurseName":null,"nurseLevelCode":"2","nurseLevelName":"Ⅱ级护理","nurseLevelBgColor":"#2eb827","nurseLevelFontColor":"#FFF"},{"bedId":18,"bedCode":"M1513","bedName":"M1513床","bedName2":"13床","patientId":18,"code":"3021811","cureNo":"098157","name":"陈金兰","sex":0,"sexText":"男","age":"6月","inTime":"2018-10-14","diagnose":null,"allergy":null,"doctorCode":"00311","doctorName":"邝钻娣","nurseCode":null,"nurseName":null,"nurseLevelCode":"3","nurseLevelName":"Ⅲ级护理","nurseLevelBgColor":"#009688","nurseLevelFontColor":"#FFF"},{"bedId":19,"bedCode":"M1514","bedName":"M1514床","bedName2":"14床","patientId":19,"code":"3021983","cureNo":"098276","name":"林明婷","sex":1,"sexText":"女","age":"6月","inTime":"2018-10-15","diagnose":null,"allergy":null,"doctorCode":"00313","doctorName":"赵冰倩","nurseCode":null,"nurseName":null,"nurseLevelCode":"1","nurseLevelName":"Ⅰ级护理","nurseLevelBgColor":"#ae0502","nurseLevelFontColor":"#FFF"},{"bedId":20,"bedCode":"M1515","bedName":"M1515床","bedName2":"15床","patientId":20,"code":"3022231","cureNo":"097846","name":"孙俊芳","sex":1,"sexText":"女","age":"6月","inTime":"2018-10-16","diagnose":null,"allergy":null,"doctorCode":"00323","doctorName":"陈黎丽","nurseCode":null,"nurseName":null,"nurseLevelCode":"2","nurseLevelName":"Ⅱ级护理","nurseLevelBgColor":"#2eb827","nurseLevelFontColor":"#FFF"}]
     */

    private int code;
    private int status;
    private String message;
    private String msg;
    private int count;
    private String timestamp;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * bedId : 1
         * bedCode : L01
         * bedName : L01床
         * bedName2 : L01床
         * patientId : 1
         * code : 3000854
         * cureNo : 098170
         * name : 刘四媛
         * sex : 1
         * sexText : 女
         * age : 20
         * inTime : 2018-09-27
         * diagnose : 诊断测试1
         * allergy : 过敏测试1
         * doctorCode : 00262
         * doctorName : 欧阳善聪
         * nurseCode : 00133
         * nurseName : 何苗
         * nurseLevelCode : 1
         * nurseLevelName : Ⅰ级护理
         * nurseLevelBgColor : #ae0502
         * nurseLevelFontColor : #FFF
         * bedStatus  床位占用状态：0空闲 1使用
         */

        private int bedId;
        private String bedCode;
        private String bedName;
        private String bedName2;
        private int patientId;
        private String code;
        private String cureNo;
        private String name;
        private int sex;
        private String sexText;
        private String age;
        private String inTime;
        private String diagnose;
        private String allergy;
        private String doctorCode;
        private String doctorName;
        private String nurseCode;
        private String nurseName;
        private String nurseLevelCode;
        private String nurseLevelName;
        private String nurseLevelBgColor;
        private String nurseLevelFontColor;
        private int bedStatus;

        public int getBedStatus() {
            return bedStatus;
        }

        public void setBedStatus(int bedStatus) {
            this.bedStatus = bedStatus;
        }

        public int getBedId() {
            return bedId;
        }

        public void setBedId(int bedId) {
            this.bedId = bedId;
        }

        public String getBedCode() {
            return bedCode;
        }

        public void setBedCode(String bedCode) {
            this.bedCode = bedCode;
        }

        public String getBedName() {
            return bedName;
        }

        public void setBedName(String bedName) {
            this.bedName = bedName;
        }

        public String getBedName2() {
            return bedName2;
        }

        public void setBedName2(String bedName2) {
            this.bedName2 = bedName2;
        }

        public int getPatientId() {
            return patientId;
        }

        public void setPatientId(int patientId) {
            this.patientId = patientId;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getCureNo() {
            return cureNo;
        }

        public void setCureNo(String cureNo) {
            this.cureNo = cureNo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getSexText() {
            return sexText;
        }

        public void setSexText(String sexText) {
            this.sexText = sexText;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getInTime() {
            return inTime;
        }

        public void setInTime(String inTime) {
            this.inTime = inTime;
        }

        public String getDiagnose() {
            return diagnose;
        }

        public void setDiagnose(String diagnose) {
            this.diagnose = diagnose;
        }

        public String getAllergy() {
            return allergy;
        }

        public void setAllergy(String allergy) {
            this.allergy = allergy;
        }

        public String getDoctorCode() {
            return doctorCode;
        }

        public void setDoctorCode(String doctorCode) {
            this.doctorCode = doctorCode;
        }

        public String getDoctorName() {
            return doctorName;
        }

        public void setDoctorName(String doctorName) {
            this.doctorName = doctorName;
        }

        public String getNurseCode() {
            return nurseCode;
        }

        public void setNurseCode(String nurseCode) {
            this.nurseCode = nurseCode;
        }

        public String getNurseName() {
            return nurseName;
        }

        public void setNurseName(String nurseName) {
            this.nurseName = nurseName;
        }

        public String getNurseLevelCode() {
            return nurseLevelCode;
        }

        public void setNurseLevelCode(String nurseLevelCode) {
            this.nurseLevelCode = nurseLevelCode;
        }

        public String getNurseLevelName() {
            return nurseLevelName;
        }

        public void setNurseLevelName(String nurseLevelName) {
            this.nurseLevelName = nurseLevelName;
        }

        public String getNurseLevelBgColor() {
            return nurseLevelBgColor;
        }

        public void setNurseLevelBgColor(String nurseLevelBgColor) {
            this.nurseLevelBgColor = nurseLevelBgColor;
        }

        public String getNurseLevelFontColor() {
            return nurseLevelFontColor;
        }

        public void setNurseLevelFontColor(String nurseLevelFontColor) {
            this.nurseLevelFontColor = nurseLevelFontColor;
        }
    }
}
