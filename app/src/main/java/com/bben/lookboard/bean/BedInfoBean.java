package com.bben.lookboard.bean;

import java.util.List;

/**
 * Created by Bben on 2018/11/10.
 */

public class BedInfoBean {


    /**
     * code : 0
     * message : 处理成功
     * data : {"wardName":"妇科病区","bedCount":42,"patientCount":42,"freeLocationCount":1,
     * "patientVos":[
     *                     {
     *                      "hasMore":false,
     *                       "bedId":null,
     *                       "id":null,
     *                       "name":null,
     *                       "birthday":null,
     *                       "age":0,
     *                       "cureNo":null,
     *                       "nurseLevel":null,
     *                       "nurseLevelColor":null,
     *                       "nurseName":null
     *                       },
     *                       {
     *                       "hasMore":true,
     *                       "bedId":2,
     *                       "id":2,
     *                       "name":"颜晓娟",
     *                       "birthday":"1984-05-04 12:00:00",
     *                       "age":0,
     *                       "cureNo":"11",
     *                       "nurseLevel":"Ⅰ级护理",
     *                       "nurseLevelColor":"#FF0000",
     *                       "nurseName":"何聪"
     *                       },{"hasMore":true,"bedId":3,"id":3,"name":"李雪静","birthday":"1981-03-17 11:00:00","age":0,"cureNo":"333","nurseLevel":"Ⅱ级护理","nurseLevelColor":"#00EE00","nurseName":"张静韬"},{"hasMore":true,"bedId":4,"id":4,"name":"徐华荣","birthday":"1973-02-11 11:00:00","age":0,"cureNo":"222","nurseLevel":"特级护理","nurseLevelColor":"#FF7256","nurseName":"徐丽"},{"hasMore":true,"bedId":5,"id":5,"name":"付振坤","birthday":"1964-12-20 11:00:00","age":0,"cureNo":"333","nurseLevel":"Ⅰ级护理","nurseLevelColor":"#FF0000","nurseName":"王鹤澎"},{"hasMore":true,"bedId":6,"id":6,"name":"吴镜明","birthday":"1938-09-01 12:00:00","age":0,"cureNo":"444","nurseLevel":"Ⅱ级护理","nurseLevelColor":"#00EE00","nurseName":"贺燕娇"},{"hasMore":true,"bedId":7,"id":7,"name":"利征","birthday":"1969-11-09 11:00:00","age":0,"cureNo":"333","nurseLevel":"特级护理","nurseLevelColor":"#FF7256","nurseName":"林宏君"},{"hasMore":true,"bedId":8,"id":8,"name":"牛云","birthday":"1956-10-12 12:00:00","age":0,"cureNo":"333","nurseLevel":"Ⅰ级护理","nurseLevelColor":"#FF0000","nurseName":"黄育琳"},{"hasMore":true,"bedId":9,"id":9,"name":"霍博文","birthday":"1936-02-17 11:00:00","age":0,"cureNo":"CURE-NO-10","nurseLevel":"Ⅱ级护理","nurseLevelColor":"#00EE00","nurseName":"谢北云"},{"hasMore":true,"bedId":10,"id":10,"name":"王纯娟","birthday":"1956-04-20 11:00:00","age":0,"cureNo":"CURE-NO-11","nurseLevel":"特级护理","nurseLevelColor":"#FF7256","nurseName":"卢敏娟"},{"hasMore":true,"bedId":11,"id":11,"name":"杨忠琴","birthday":"1956-10-31 11:00:00","age":0,"cureNo":"CURE-NO-12","nurseLevel":"Ⅰ级护理","nurseLevelColor":"#FF0000","nurseName":"姜宇"},{"hasMore":true,"bedId":12,"id":12,"name":"郭宠斌","birthday":"1969-06-30 12:00:00","age":0,"cureNo":"CURE-NO-13","nurseLevel":"Ⅱ级护理","nurseLevelColor":"#00EE00","nurseName":"徐红霞"},{"hasMore":true,"bedId":13,"id":13,"name":"曾晓燕","birthday":"1971-10-08 12:00:00","age":0,"cureNo":"CURE-NO-14","nurseLevel":"特级护理","nurseLevelColor":"#FF7256","nurseName":"李秋明"},{"hasMore":true,"bedId":14,"id":14,"name":"周永利","birthday":"1978-09-14 12:00:00","age":0,"cureNo":"CURE-NO-15","nurseLevel":"Ⅰ级护理","nurseLevelColor":"#FF0000","nurseName":"蓬勃"},{"hasMore":true,"bedId":15,"id":15,"name":"唐奉章","birthday":"1938-05-04 12:00:00","age":0,"cureNo":"CURE-NO-16","nurseLevel":"Ⅱ级护理","nurseLevelColor":"#00EE00","nurseName":"叶利平"},{"hasMore":true,"bedId":16,"id":16,"name":"罗建勇","birthday":"1973-07-16 12:00:00","age":0,"cureNo":"CURE-NO-17","nurseLevel":"特级护理","nurseLevelColor":"#FF7256","nurseName":"曾柳青"},{"hasMore":true,"bedId":17,"id":17,"name":"陈汉明","birthday":"1994-04-12 12:00:00","age":0,"cureNo":"CURE-NO-18","nurseLevel":"Ⅰ级护理","nurseLevelColor":"#FF0000","nurseName":"张梓童"},{"hasMore":true,"bedId":18,"id":18,"name":"马美花","birthday":"1972-12-26 11:00:00","age":0,"cureNo":"CURE-NO-19","nurseLevel":"Ⅱ级护理","nurseLevelColor":"#00EE00","nurseName":"黄春平"},{"hasMore":true,"bedId":19,"id":19,"name":"王玉金","birthday":"1951-11-08 11:00:00","age":0,"cureNo":"CURE-NO-20","nurseLevel":"特级护理","nurseLevelColor":"#FF7256","nurseName":"谢晓芳"},{"hasMore":true,"bedId":20,"id":20,"name":"王文晖","birthday":"1968-08-14 12:00:00","age":0,"cureNo":"CURE-NO-21","nurseLevel":"Ⅰ级护理","nurseLevelColor":"#FF0000","nurseName":"罗燕柳"},{"hasMore":true,"bedId":21,"id":21,"name":"王头春","birthday":"1953-03-04 11:00:00","age":0,"cureNo":"CURE-NO-22","nurseLevel":"Ⅱ级护理","nurseLevelColor":"#00EE00","nurseName":"陈巧"},{"hasMore":true,"bedId":22,"id":22,"name":"张丽琴","birthday":"1957-08-09 12:00:00","age":0,"cureNo":"CURE-NO-23","nurseLevel":"特级护理","nurseLevelColor":"#FF7256","nurseName":"丁欣"},{"hasMore":true,"bedId":23,"id":23,"name":"李振宏","birthday":"1963-11-02 11:00:00","age":0,"cureNo":"CURE-NO-24","nurseLevel":"Ⅰ级护理","nurseLevelColor":"#FF0000","nurseName":"白倩倩"},{"hasMore":true,"bedId":24,"id":24,"name":"彭金凤","birthday":"1953-05-28 12:00:00","age":0,"cureNo":"CURE-NO-25","nurseLevel":"Ⅱ级护理","nurseLevelColor":"#00EE00","nurseName":"万李丹"},{"hasMore":true,"bedId":25,"id":25,"name":"张永胜","birthday":"1971-12-29 11:00:00","age":0,"cureNo":"CURE-NO-26","nurseLevel":"特级护理","nurseLevelColor":"#FF7256","nurseName":"蔺洋洋"},{"hasMore":true,"bedId":26,"id":26,"name":"廖影红","birthday":"1975-12-14 11:00:00","age":0,"cureNo":"CURE-NO-27","nurseLevel":"Ⅰ级护理","nurseLevelColor":"#FF0000","nurseName":"鲍晓敏"},{"hasMore":true,"bedId":27,"id":27,"name":"测试","birthday":"2013-06-26 12:00:00","age":0,"cureNo":"CURE-NO-28","nurseLevel":"Ⅱ级护理","nurseLevelColor":"#00EE00","nurseName":"姚梦煜"},{"hasMore":true,"bedId":28,"id":28,"name":"徐志仁","birthday":"1951-01-11 11:00:00","age":0,"cureNo":"CURE-NO-29","nurseLevel":"特级护理","nurseLevelColor":"#FF7256","nurseName":"魏丽娟"},{"hasMore":true,"bedId":29,"id":29,"name":"周海田","birthday":"1965-05-25 12:00:00","age":0,"cureNo":"CURE-NO-30","nurseLevel":"Ⅰ级护理","nurseLevelColor":"#FF0000","nurseName":"方雨霞"},{"hasMore":true,"bedId":30,"id":30,"name":"罗军","birthday":"1966-02-09 11:00:00","age":0,"cureNo":"CURE-NO-31","nurseLevel":"Ⅱ级护理","nurseLevelColor":"#00EE00","nurseName":"崔雄"},{"hasMore":true,"bedId":31,"id":31,"name":"张群容","birthday":"1927-11-17 11:00:00","age":0,"cureNo":"CURE-NO-32","nurseLevel":"特级护理","nurseLevelColor":"#FF7256","nurseName":"温容珍"},{"hasMore":true,"bedId":32,"id":32,"name":"郭煜","birthday":"2009-08-27 12:00:00","age":0,"cureNo":"CURE-NO-33","nurseLevel":"Ⅰ级护理","nurseLevelColor":"#FF0000","nurseName":"张小雪"},{"hasMore":true,"bedId":33,"id":33,"name":"朱敬华","birthday":"1956-10-11 12:00:00","age":0,"cureNo":"CURE-NO-34","nurseLevel":"Ⅱ级护理","nurseLevelColor":"#00EE00","nurseName":"肖殷"},{"hasMore":true,"bedId":34,"id":34,"name":"杨芳梅","birthday":"1959-03-05 11:00:00","age":0,"cureNo":"CURE-NO-35","nurseLevel":"特级护理","nurseLevelColor":"#FF7256","nurseName":"唐思祺"},{"hasMore":true,"bedId":35,"id":35,"name":"陈雨欣","birthday":"1987-01-02 11:00:00","age":0,"cureNo":"CURE-NO-36","nurseLevel":"Ⅰ级护理","nurseLevelColor":"#FF0000","nurseName":"郑海珊"},{"hasMore":true,"bedId":36,"id":36,"name":"徐海红","birthday":"1977-10-27 12:00:00","age":0,"cureNo":"CURE-NO-37","nurseLevel":"Ⅱ级护理","nurseLevelColor":"#00EE00","nurseName":"宁慧"},{"hasMore":true,"bedId":37,"id":37,"name":"陈福秀","birthday":"1981-03-11 11:00:00","age":0,"cureNo":"CURE-NO-38","nurseLevel":"特级护理","nurseLevelColor":"#FF7256","nurseName":"冯一吟"},{"hasMore":true,"bedId":38,"id":38,"name":"吴海曼","birthday":"1984-12-29 11:00:00","age":0,"cureNo":"CURE-NO-39","nurseLevel":"Ⅰ级护理","nurseLevelColor":"#FF0000","nurseName":"梁敬萍"},{"hasMore":true,"bedId":39,"id":39,"name":"罗小宁","birthday":"1986-02-28 11:00:00","age":0,"cureNo":"CURE-NO-40","nurseLevel":"Ⅱ级护理","nurseLevelColor":"#00EE00","nurseName":"何苗"},{"hasMore":true,"bedId":40,"id":40,"name":"测试","birthday":"1985-12-26 11:00:00","age":0,"cureNo":"CURE-NO-41","nurseLevel":"特级护理","nurseLevelColor":"#FF7256","nurseName":"张波"},{"hasMore":true,"bedId":41,"id":41,"name":"刘广来","birthday":"1962-01-19 11:00:00","age":0,"cureNo":"CURE-NO-42","nurseLevel":"Ⅰ级护理","nurseLevelColor":"#FF0000","nurseName":"郭倩"},{"hasMore":true,"bedId":42,"id":42,"name":"吴美霞","birthday":"1964-05-08 12:00:00","age":0,"cureNo":"CURE-NO-43","nurseLevel":"Ⅱ级护理","nurseLevelColor":"#00EE00","nurseName":"黄裕娜"}]}
     */

    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * wardName : 妇科病区
         * bedCount : 42
         * patientCount : 42
         * freeLocationCount : 1
         * patientVos : [{"hasMore":false,"bedId":null,"id":null,"name":null,"birthday":null,"age":0,"cureNo":null,"nurseLevel":null,"nurseLevelColor":null,"nurseName":null},{"hasMore":true,"bedId":2,"id":2,"name":"颜晓娟","birthday":"1984-05-04 12:00:00","age":0,"cureNo":"11","nurseLevel":"Ⅰ级护理","nurseLevelColor":"#FF0000","nurseName":"何聪"},{"hasMore":true,"bedId":3,"id":3,"name":"李雪静","birthday":"1981-03-17 11:00:00","age":0,"cureNo":"333","nurseLevel":"Ⅱ级护理","nurseLevelColor":"#00EE00","nurseName":"张静韬"},{"hasMore":true,"bedId":4,"id":4,"name":"徐华荣","birthday":"1973-02-11 11:00:00","age":0,"cureNo":"222","nurseLevel":"特级护理","nurseLevelColor":"#FF7256","nurseName":"徐丽"},{"hasMore":true,"bedId":5,"id":5,"name":"付振坤","birthday":"1964-12-20 11:00:00","age":0,"cureNo":"333","nurseLevel":"Ⅰ级护理","nurseLevelColor":"#FF0000","nurseName":"王鹤澎"},{"hasMore":true,"bedId":6,"id":6,"name":"吴镜明","birthday":"1938-09-01 12:00:00","age":0,"cureNo":"444","nurseLevel":"Ⅱ级护理","nurseLevelColor":"#00EE00","nurseName":"贺燕娇"},{"hasMore":true,"bedId":7,"id":7,"name":"利征","birthday":"1969-11-09 11:00:00","age":0,"cureNo":"333","nurseLevel":"特级护理","nurseLevelColor":"#FF7256","nurseName":"林宏君"},{"hasMore":true,"bedId":8,"id":8,"name":"牛云","birthday":"1956-10-12 12:00:00","age":0,"cureNo":"333","nurseLevel":"Ⅰ级护理","nurseLevelColor":"#FF0000","nurseName":"黄育琳"},{"hasMore":true,"bedId":9,"id":9,"name":"霍博文","birthday":"1936-02-17 11:00:00","age":0,"cureNo":"CURE-NO-10","nurseLevel":"Ⅱ级护理","nurseLevelColor":"#00EE00","nurseName":"谢北云"},{"hasMore":true,"bedId":10,"id":10,"name":"王纯娟","birthday":"1956-04-20 11:00:00","age":0,"cureNo":"CURE-NO-11","nurseLevel":"特级护理","nurseLevelColor":"#FF7256","nurseName":"卢敏娟"},{"hasMore":true,"bedId":11,"id":11,"name":"杨忠琴","birthday":"1956-10-31 11:00:00","age":0,"cureNo":"CURE-NO-12","nurseLevel":"Ⅰ级护理","nurseLevelColor":"#FF0000","nurseName":"姜宇"},{"hasMore":true,"bedId":12,"id":12,"name":"郭宠斌","birthday":"1969-06-30 12:00:00","age":0,"cureNo":"CURE-NO-13","nurseLevel":"Ⅱ级护理","nurseLevelColor":"#00EE00","nurseName":"徐红霞"},{"hasMore":true,"bedId":13,"id":13,"name":"曾晓燕","birthday":"1971-10-08 12:00:00","age":0,"cureNo":"CURE-NO-14","nurseLevel":"特级护理","nurseLevelColor":"#FF7256","nurseName":"李秋明"},{"hasMore":true,"bedId":14,"id":14,"name":"周永利","birthday":"1978-09-14 12:00:00","age":0,"cureNo":"CURE-NO-15","nurseLevel":"Ⅰ级护理","nurseLevelColor":"#FF0000","nurseName":"蓬勃"},{"hasMore":true,"bedId":15,"id":15,"name":"唐奉章","birthday":"1938-05-04 12:00:00","age":0,"cureNo":"CURE-NO-16","nurseLevel":"Ⅱ级护理","nurseLevelColor":"#00EE00","nurseName":"叶利平"},{"hasMore":true,"bedId":16,"id":16,"name":"罗建勇","birthday":"1973-07-16 12:00:00","age":0,"cureNo":"CURE-NO-17","nurseLevel":"特级护理","nurseLevelColor":"#FF7256","nurseName":"曾柳青"},{"hasMore":true,"bedId":17,"id":17,"name":"陈汉明","birthday":"1994-04-12 12:00:00","age":0,"cureNo":"CURE-NO-18","nurseLevel":"Ⅰ级护理","nurseLevelColor":"#FF0000","nurseName":"张梓童"},{"hasMore":true,"bedId":18,"id":18,"name":"马美花","birthday":"1972-12-26 11:00:00","age":0,"cureNo":"CURE-NO-19","nurseLevel":"Ⅱ级护理","nurseLevelColor":"#00EE00","nurseName":"黄春平"},{"hasMore":true,"bedId":19,"id":19,"name":"王玉金","birthday":"1951-11-08 11:00:00","age":0,"cureNo":"CURE-NO-20","nurseLevel":"特级护理","nurseLevelColor":"#FF7256","nurseName":"谢晓芳"},{"hasMore":true,"bedId":20,"id":20,"name":"王文晖","birthday":"1968-08-14 12:00:00","age":0,"cureNo":"CURE-NO-21","nurseLevel":"Ⅰ级护理","nurseLevelColor":"#FF0000","nurseName":"罗燕柳"},{"hasMore":true,"bedId":21,"id":21,"name":"王头春","birthday":"1953-03-04 11:00:00","age":0,"cureNo":"CURE-NO-22","nurseLevel":"Ⅱ级护理","nurseLevelColor":"#00EE00","nurseName":"陈巧"},{"hasMore":true,"bedId":22,"id":22,"name":"张丽琴","birthday":"1957-08-09 12:00:00","age":0,"cureNo":"CURE-NO-23","nurseLevel":"特级护理","nurseLevelColor":"#FF7256","nurseName":"丁欣"},{"hasMore":true,"bedId":23,"id":23,"name":"李振宏","birthday":"1963-11-02 11:00:00","age":0,"cureNo":"CURE-NO-24","nurseLevel":"Ⅰ级护理","nurseLevelColor":"#FF0000","nurseName":"白倩倩"},{"hasMore":true,"bedId":24,"id":24,"name":"彭金凤","birthday":"1953-05-28 12:00:00","age":0,"cureNo":"CURE-NO-25","nurseLevel":"Ⅱ级护理","nurseLevelColor":"#00EE00","nurseName":"万李丹"},{"hasMore":true,"bedId":25,"id":25,"name":"张永胜","birthday":"1971-12-29 11:00:00","age":0,"cureNo":"CURE-NO-26","nurseLevel":"特级护理","nurseLevelColor":"#FF7256","nurseName":"蔺洋洋"},{"hasMore":true,"bedId":26,"id":26,"name":"廖影红","birthday":"1975-12-14 11:00:00","age":0,"cureNo":"CURE-NO-27","nurseLevel":"Ⅰ级护理","nurseLevelColor":"#FF0000","nurseName":"鲍晓敏"},{"hasMore":true,"bedId":27,"id":27,"name":"测试","birthday":"2013-06-26 12:00:00","age":0,"cureNo":"CURE-NO-28","nurseLevel":"Ⅱ级护理","nurseLevelColor":"#00EE00","nurseName":"姚梦煜"},{"hasMore":true,"bedId":28,"id":28,"name":"徐志仁","birthday":"1951-01-11 11:00:00","age":0,"cureNo":"CURE-NO-29","nurseLevel":"特级护理","nurseLevelColor":"#FF7256","nurseName":"魏丽娟"},{"hasMore":true,"bedId":29,"id":29,"name":"周海田","birthday":"1965-05-25 12:00:00","age":0,"cureNo":"CURE-NO-30","nurseLevel":"Ⅰ级护理","nurseLevelColor":"#FF0000","nurseName":"方雨霞"},{"hasMore":true,"bedId":30,"id":30,"name":"罗军","birthday":"1966-02-09 11:00:00","age":0,"cureNo":"CURE-NO-31","nurseLevel":"Ⅱ级护理","nurseLevelColor":"#00EE00","nurseName":"崔雄"},{"hasMore":true,"bedId":31,"id":31,"name":"张群容","birthday":"1927-11-17 11:00:00","age":0,"cureNo":"CURE-NO-32","nurseLevel":"特级护理","nurseLevelColor":"#FF7256","nurseName":"温容珍"},{"hasMore":true,"bedId":32,"id":32,"name":"郭煜","birthday":"2009-08-27 12:00:00","age":0,"cureNo":"CURE-NO-33","nurseLevel":"Ⅰ级护理","nurseLevelColor":"#FF0000","nurseName":"张小雪"},{"hasMore":true,"bedId":33,"id":33,"name":"朱敬华","birthday":"1956-10-11 12:00:00","age":0,"cureNo":"CURE-NO-34","nurseLevel":"Ⅱ级护理","nurseLevelColor":"#00EE00","nurseName":"肖殷"},{"hasMore":true,"bedId":34,"id":34,"name":"杨芳梅","birthday":"1959-03-05 11:00:00","age":0,"cureNo":"CURE-NO-35","nurseLevel":"特级护理","nurseLevelColor":"#FF7256","nurseName":"唐思祺"},{"hasMore":true,"bedId":35,"id":35,"name":"陈雨欣","birthday":"1987-01-02 11:00:00","age":0,"cureNo":"CURE-NO-36","nurseLevel":"Ⅰ级护理","nurseLevelColor":"#FF0000","nurseName":"郑海珊"},{"hasMore":true,"bedId":36,"id":36,"name":"徐海红","birthday":"1977-10-27 12:00:00","age":0,"cureNo":"CURE-NO-37","nurseLevel":"Ⅱ级护理","nurseLevelColor":"#00EE00","nurseName":"宁慧"},{"hasMore":true,"bedId":37,"id":37,"name":"陈福秀","birthday":"1981-03-11 11:00:00","age":0,"cureNo":"CURE-NO-38","nurseLevel":"特级护理","nurseLevelColor":"#FF7256","nurseName":"冯一吟"},{"hasMore":true,"bedId":38,"id":38,"name":"吴海曼","birthday":"1984-12-29 11:00:00","age":0,"cureNo":"CURE-NO-39","nurseLevel":"Ⅰ级护理","nurseLevelColor":"#FF0000","nurseName":"梁敬萍"},{"hasMore":true,"bedId":39,"id":39,"name":"罗小宁","birthday":"1986-02-28 11:00:00","age":0,"cureNo":"CURE-NO-40","nurseLevel":"Ⅱ级护理","nurseLevelColor":"#00EE00","nurseName":"何苗"},{"hasMore":true,"bedId":40,"id":40,"name":"测试","birthday":"1985-12-26 11:00:00","age":0,"cureNo":"CURE-NO-41","nurseLevel":"特级护理","nurseLevelColor":"#FF7256","nurseName":"张波"},{"hasMore":true,"bedId":41,"id":41,"name":"刘广来","birthday":"1962-01-19 11:00:00","age":0,"cureNo":"CURE-NO-42","nurseLevel":"Ⅰ级护理","nurseLevelColor":"#FF0000","nurseName":"郭倩"},{"hasMore":true,"bedId":42,"id":42,"name":"吴美霞","birthday":"1964-05-08 12:00:00","age":0,"cureNo":"CURE-NO-43","nurseLevel":"Ⅱ级护理","nurseLevelColor":"#00EE00","nurseName":"黄裕娜"}]
         */

        private String wardName;
        private int bedCount;
        private int patientCount;
        private int freeLocationCount;
        private List<PatientVosBean> patientVos;

        public String getWardName() {
            return wardName;
        }

        public void setWardName(String wardName) {
            this.wardName = wardName;
        }

        public int getBedCount() {
            return bedCount;
        }

        public void setBedCount(int bedCount) {
            this.bedCount = bedCount;
        }

        public int getPatientCount() {
            return patientCount;
        }

        public void setPatientCount(int patientCount) {
            this.patientCount = patientCount;
        }

        public int getFreeLocationCount() {
            return freeLocationCount;
        }

        public void setFreeLocationCount(int freeLocationCount) {
            this.freeLocationCount = freeLocationCount;
        }

        public List<PatientVosBean> getPatientVos() {
            return patientVos;
        }

        public void setPatientVos(List<PatientVosBean> patientVos) {
            this.patientVos = patientVos;
        }

        public static class PatientVosBean {
            /**
             * hasMore : false
             * bedId : null
             * id : null
             * name : null
             * birthday : null
             * age : 0
             * cureNo : null
             * nurseLevel : null
             * nurseLevelColor : null
             * nurseName : null
             */

            private boolean hasMore;
            private int bedId;
            private int id;
            private String name;
            private String birthday;
            private String age;
            private String cureNo;
            private String nurseLevel;
            private String nurseLevelColor;
            private String nurseName;
            private int sex;


            public int getSex() {
                return sex;
            }

            public void setSex(int sex) {
                this.sex = sex;
            }

            public boolean isHasMore() {
                return hasMore;
            }

            public void setHasMore(boolean hasMore) {
                this.hasMore = hasMore;
            }

            public int getBedId() {
                return bedId;
            }

            public void setBedId(int bedId) {
                this.bedId = bedId;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getBirthday() {
                return birthday;
            }

            public void setBirthday(String birthday) {
                this.birthday = birthday;
            }

            public String getAge() {
                return age;
            }

            public void setAge(String age) {
                this.age = age;
            }

            public String getCureNo() {
                return cureNo;
            }

            public void setCureNo(String cureNo) {
                this.cureNo = cureNo;
            }

            public String getNurseLevel() {
                return nurseLevel;
            }

            public void setNurseLevel(String nurseLevel) {
                this.nurseLevel = nurseLevel;
            }

            public String getNurseLevelColor() {
                return nurseLevelColor;
            }

            public void setNurseLevelColor(String nurseLevelColor) {
                this.nurseLevelColor = nurseLevelColor;
            }

            public String getNurseName() {
                return nurseName;
            }

            public void setNurseName(String nurseName) {
                this.nurseName = nurseName;
            }
        }
    }
}
