package com.example.win.newintern3.Entity;

/**
 * Created by TAO_SX on 2016/8/12/012.
 */
public class PartTimeInfoEntity {

    /**
     * partTimePostTime : 2016-08-08 15:48:22
     * publisherTel : 18310138472
     * companyName : 北京京胜世纪科技有限公司
     * partTimePostTitle : 软件工程师0
     * partTimePostNum : 2
     * partTimePostEndTime : 2016年9月
     * isApply : 0
     * companyId : 1
     * partTimePostMoney : 10000-14999/月
     * partTimePostStartTime : 2016年8月
     * partTimePostDes : 职位描述：
     岗位职责：
     1、熟练使用Visual Studio 2010或更高版本开发环境，精通C#4.0或以上版本语言；
     2、熟悉使用C#进行窗体界面的开发；
     3、熟悉C/C++的实习生优先考虑；
     岗位要求：
     1、计算机相关专业，统招大学本科或以上学历，大学英语四级以上；
     2、对技术有浓厚兴趣，喜欢钻研，具有较强的逻辑和学习能力；
     3、担当负责，积极主动，能承担一定压力；
     * postInvalidTime : null
     * publisher : 1
     * partTimePostId : 691fbc35000000c0
     * companyIcon : http://114.55.2.134:8080/images/kingvcn.jpg
     * partTimePostAddress : 北京-昌平区
     */

    private ParttimepostinfoEntity parttimepostinfo;
    /**
     * parttimepostinfo : {"partTimePostTime":"2016-08-08 15:48:22","publisherTel":"18310138472","companyName":"北京京胜世纪科技有限公司","partTimePostTitle":"软件工程师0","partTimePostNum":2,"partTimePostEndTime":"2016年9月","isApply":0,"companyId":1,"partTimePostMoney":"10000-14999/月","partTimePostStartTime":"2016年8月","partTimePostDes":"职位描述：\n岗位职责： \n  1、熟练使用Visual Studio 2010或更高版本开发环境，精通C#4.0或以上版本语言；\n2、熟悉使用C#进行窗体界面的开发；\n3、熟悉C/C++的实习生优先考虑；\n岗位要求：\n1、计算机相关专业，统招大学本科或以上学历，大学英语四级以上；\n2、对技术有浓厚兴趣，喜欢钻研，具有较强的逻辑和学习能力；\n3、担当负责，积极主动，能承担一定压力；","postInvalidTime":null,"publisher":1,"partTimePostId":"691fbc35000000c0","companyIcon":"http://114.55.2.134:8080/images/kingvcn.jpg","partTimePostAddress":"北京-昌平区"}
     * code : 200
     */

    private String code;

    public ParttimepostinfoEntity getParttimepostinfo() {
        return parttimepostinfo;
    }

    public void setParttimepostinfo(ParttimepostinfoEntity parttimepostinfo) {
        this.parttimepostinfo = parttimepostinfo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static class ParttimepostinfoEntity {
        private String partTimePostTime;
        private String publisherTel;
        private String companyName;
        private String partTimePostTitle;
        private int partTimePostNum;
        private String partTimePostEndTime;
        private int isApply;
        private int companyId;
        private String partTimePostMoney;
        private String partTimePostStartTime;
        private String partTimePostDes;
        private Object postInvalidTime;
        private int publisher;
        private String partTimePostId;
        private String companyIcon;
        private String partTimePostAddress;

        public String getPartTimePostTime() {
            return partTimePostTime;
        }

        public void setPartTimePostTime(String partTimePostTime) {
            this.partTimePostTime = partTimePostTime;
        }

        public String getPublisherTel() {
            return publisherTel;
        }

        public void setPublisherTel(String publisherTel) {
            this.publisherTel = publisherTel;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getPartTimePostTitle() {
            return partTimePostTitle;
        }

        public void setPartTimePostTitle(String partTimePostTitle) {
            this.partTimePostTitle = partTimePostTitle;
        }

        public int getPartTimePostNum() {
            return partTimePostNum;
        }

        public void setPartTimePostNum(int partTimePostNum) {
            this.partTimePostNum = partTimePostNum;
        }

        public String getPartTimePostEndTime() {
            return partTimePostEndTime;
        }

        public void setPartTimePostEndTime(String partTimePostEndTime) {
            this.partTimePostEndTime = partTimePostEndTime;
        }

        public int getIsApply() {
            return isApply;
        }

        public void setIsApply(int isApply) {
            this.isApply = isApply;
        }

        public int getCompanyId() {
            return companyId;
        }

        public void setCompanyId(int companyId) {
            this.companyId = companyId;
        }

        public String getPartTimePostMoney() {
            return partTimePostMoney;
        }

        public void setPartTimePostMoney(String partTimePostMoney) {
            this.partTimePostMoney = partTimePostMoney;
        }

        public String getPartTimePostStartTime() {
            return partTimePostStartTime;
        }

        public void setPartTimePostStartTime(String partTimePostStartTime) {
            this.partTimePostStartTime = partTimePostStartTime;
        }

        public String getPartTimePostDes() {
            return partTimePostDes;
        }

        public void setPartTimePostDes(String partTimePostDes) {
            this.partTimePostDes = partTimePostDes;
        }

        public Object getPostInvalidTime() {
            return postInvalidTime;
        }

        public void setPostInvalidTime(Object postInvalidTime) {
            this.postInvalidTime = postInvalidTime;
        }

        public int getPublisher() {
            return publisher;
        }

        public void setPublisher(int publisher) {
            this.publisher = publisher;
        }

        public String getPartTimePostId() {
            return partTimePostId;
        }

        public void setPartTimePostId(String partTimePostId) {
            this.partTimePostId = partTimePostId;
        }

        public String getCompanyIcon() {
            return companyIcon;
        }

        public void setCompanyIcon(String companyIcon) {
            this.companyIcon = companyIcon;
        }

        public String getPartTimePostAddress() {
            return partTimePostAddress;
        }

        public void setPartTimePostAddress(String partTimePostAddress) {
            this.partTimePostAddress = partTimePostAddress;
        }
    }
}
