package com.example.cshaoshao.litepalbase.entities;

import java.util.List;

/**
 * Created by cshaoshao on 2017/6/21.
 */

public class Message {


    /**
     * flag : Success
     * msg : 1
     * data : [{"id":"1","mid":"1","name":"平台管理","describe":"用于管理用户相关","url":"Platform","mpower":"0","power":"1","rpower":"1","function":[{"id":"2","mid":"1.1","name":"模块注册","describe":"用于注册模块的信息","url":"Platform/Index","mpower":"1","power":"1","rpower":"1"},{"id":"3","mid":"1.2","name":"模块启用","describe":"用于启用模块和功能","url":"Platform/Moduleinstall","mpower":"1","power":"1","rpower":"1"},{"id":"4","mid":"1.3","name":"模块禁用","describe":"用于启用模块和功能","url":"Platform/Moduleuninstall","mpower":"1","power":"1","rpower":"1"},{"id":"5","mid":"1.4","name":"模块绑定","describe":"用于角色与模块的绑定","url":"Platform/Modulebind","mpower":"1","power":"1","rpower":"1"}]},{"id":"6","mid":"2","name":"用户管理","describe":"支持管理系统的用户和设置角色","url":"User","mpower":"0","power":["2","3","5","1"],"rpower":"1","function":[{"id":"7","mid":"2.1","name":"用户列表","describe":"用于显示系统下用户的列表","url":"User/Index","mpower":"1","power":["3","2","5","1"],"rpower":"1"},{"id":"8","mid":"2.2","name":"用户注册","describe":"用于审核注册的用户","url":"User/Userregistry","mpower":"1","power":["5","1"],"rpower":"1"},{"id":"9","mid":"2.3","name":"权限管理","describe":"查看编辑管理的权限","url":"User/Powermanager","mpower":"1","power":"1","rpower":"1"},{"id":"10","mid":"2.4","name":"角色绑定","describe":"用于将用户角色与权限进行绑定","url":"User/Userpower","mpower":"1","power":["5","1"],"rpower":"1"}]},{"id":"11","mid":"3","name":"培养管理","describe":"支持培养系统","url":"Develop","mpower":"0","power":["5","2","1"],"rpower":"1","function":[{"id":"12","mid":"3.1","name":"任务管理","describe":"用于任务管理index","url":"Mission/Index","mpower":"1","power":["2","5","1"],"rpower":["5","1"]},{"id":"13","mid":"3.2","name":"通知管理","describe":"用于通知管理","url":"Notice/Index","mpower":"1","power":["5","2","1"],"rpower":["5","1"]},{"id":"14","mid":"3.3","name":"通信管理","describe":"用于任务管理index","url":"Communion/Index","mpower":"1","power":["5","2","1"],"rpower":["5","1"]},{"id":"15","mid":"3.4","name":"例会管理","describe":"用于通知管理","url":"Conference/Index","mpower":"1","power":["2","5","1"],"rpower":["5","1"]}]},{"id":"16","mid":"4","name":"论坛管理","describe":"支持论坛系统","url":"Forum","mpower":"0","power":["3","5","4","2","1"],"rpower":"1","function":[{"id":"17","mid":"4.1","name":"论坛index","describe":"用于论坛index","url":"Forum/ForumPersonalCenter/personalcenter","mpower":"1","power":["2","3","5","4","1"],"rpower":"1"}]},{"id":"18","mid":"5","name":"资源管理","describe":"支持资源系统","url":"Resource","mpower":"0","power":["2","3","5","1"],"rpower":"1","function":[{"id":"19","mid":"5.1","name":"资源index","describe":"用于资源index","url":"Resource/Index","mpower":"1","power":["5","3","2","1"],"rpower":"1"}]},{"id":"20","mid":"6","name":"项目管理","describe":"支持项目系统","url":"Project","mpower":"0","power":["2","5","1"],"rpower":"1","function":[{"id":"21","mid":"6.1","name":"项目index","describe":"用于项目index","url":"Project/Index","mpower":"1","power":["2","5","1"],"rpower":["5","1"]}]}]
     */

    private String flag;
    private String msg;
    private List<DataBean> data;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * mid : 1
         * name : 平台管理
         * describe : 用于管理用户相关
         * url : Platform
         * mpower : 0
         * power : 1
         * rpower : 1
         * function : [{"id":"2","mid":"1.1","name":"模块注册","describe":"用于注册模块的信息","url":"Platform/Index","mpower":"1","power":"1","rpower":"1"},{"id":"3","mid":"1.2","name":"模块启用","describe":"用于启用模块和功能","url":"Platform/Moduleinstall","mpower":"1","power":"1","rpower":"1"},{"id":"4","mid":"1.3","name":"模块禁用","describe":"用于启用模块和功能","url":"Platform/Moduleuninstall","mpower":"1","power":"1","rpower":"1"},{"id":"5","mid":"1.4","name":"模块绑定","describe":"用于角色与模块的绑定","url":"Platform/Modulebind","mpower":"1","power":"1","rpower":"1"}]
         */

        private String id;
        private String mid;
        private String name;
        private String describe;
        private String url;
        private String mpower;
        private String power;
        private String rpower;
        private List<FunctionBean> function;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMid() {
            return mid;
        }

        public void setMid(String mid) {
            this.mid = mid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescribe() {
            return describe;
        }

        public void setDescribe(String describe) {
            this.describe = describe;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getMpower() {
            return mpower;
        }

        public void setMpower(String mpower) {
            this.mpower = mpower;
        }

        public String getPower() {
            return power;
        }

        public void setPower(String power) {
            this.power = power;
        }

        public String getRpower() {
            return rpower;
        }

        public void setRpower(String rpower) {
            this.rpower = rpower;
        }

        public List<FunctionBean> getFunction() {
            return function;
        }

        public void setFunction(List<FunctionBean> function) {
            this.function = function;
        }

        public static class FunctionBean {
            /**
             * id : 2
             * mid : 1.1
             * name : 模块注册
             * describe : 用于注册模块的信息
             * url : Platform/Index
             * mpower : 1
             * power : 1
             * rpower : 1
             */

            private String id;
            private String mid;
            private String name;
            private String describe;
            private String url;
            private String mpower;
            private String power;
            private String rpower;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getMid() {
                return mid;
            }

            public void setMid(String mid) {
                this.mid = mid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDescribe() {
                return describe;
            }

            public void setDescribe(String describe) {
                this.describe = describe;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getMpower() {
                return mpower;
            }

            public void setMpower(String mpower) {
                this.mpower = mpower;
            }

            public String getPower() {
                return power;
            }

            public void setPower(String power) {
                this.power = power;
            }

            public String getRpower() {
                return rpower;
            }

            public void setRpower(String rpower) {
                this.rpower = rpower;
            }
        }
    }
}
