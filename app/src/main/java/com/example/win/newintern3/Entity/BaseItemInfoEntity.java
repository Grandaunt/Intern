package com.example.win.newintern3.Entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by TAO_SX on 2016/7/4/004.
 */
public class BaseItemInfoEntity implements Serializable {

    /**
     * code : 200
     * postlist : [{"postDuty":"1；","postPay":"8000~10000","postNum":2,"postId":1,"postDes":"1、熟部分技巧；","basePlanId":1,"postOrder":"1、负责关键技术设计；"},{"postDuty":"-有互压能力","postPay":"8000~10000","postNum":3,"postId":2,"postDes":"-有备快速学习能力和抗压能力","basePlanId":1,"postOrder":"-破"},{"postDuty":"-1年力","postPay":"8000-9999/月","postNum":1,"postId":3,"postDes":"-1年的数据呈现能力，包括PPT展示和讲解能力","basePlanId":1,"postOrder":"-根据会点"}]
     * baseinfo : {"applyEndTime":"2016-06-09","basePlanDes":"京胜世纪实习","basePlanAddrees":"北京海淀","companyName":"北京京胜世纪科技有限公司","basePlanEndTime":"2016-09-10","scale":"50~100人","basePlanStartTime":"2016-06-10","baseId":1,"applyNum":1,"isCanApply":1,"baseWeal":"京胜世纪实习福利测试\r\n","basePlanNum":"3","isApply":1,"basePlanConnector":"闫德龙","practiceName":"京胜世纪实习计划","baseIcon":null,"basePlanConnection":"18310138472","basePlanCityId":1,"clickNum":0,"planId":1,"companyIcon":"http://114.55.2.134:8080/images/kingvcn.jpg","basePlanId":1}
     */

    private String code;
    /**
     * applyEndTime : 2016-06-09
     * basePlanDes : 京胜世纪实习
     * basePlanAddrees : 北京海淀
     * companyName : 北京京胜世纪科技有限公司
     * basePlanEndTime : 2016-09-10
     * scale : 50~100人
     * basePlanStartTime : 2016-06-10
     * baseId : 1
     * applyNum : 1
     * isCanApply : 1
     * baseWeal : 京胜世纪实习福利测试

     * basePlanNum : 3
     * isApply : 1
     * basePlanConnector : 闫德龙
     * practiceName : 京胜世纪实习计划
     * baseIcon : null
     * basePlanConnection : 18310138472
     * basePlanCityId : 1
     * clickNum : 0
     * planId : 1
     * companyIcon : http://114.55.2.134:8080/images/kingvcn.jpg
     * basePlanId : 1
     */

    private BaseinfoEntity baseinfo;
    /**
     * postDuty : 1；
     * postPay : 8000~10000
     * postNum : 2
     * postId : 1
     * postDes : 1、熟部分技巧；
     * basePlanId : 1
     * postOrder : 1、负责关键技术设计；
     */

    private List<PostlistEntity> postlist;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BaseinfoEntity getBaseinfo() {
        return baseinfo;
    }

    public void setBaseinfo(BaseinfoEntity baseinfo) {
        this.baseinfo = baseinfo;
    }

    public List<PostlistEntity> getPostlist() {
        return postlist;
    }

    public void setPostlist(List<PostlistEntity> postlist) {
        this.postlist = postlist;
    }

    public static class BaseinfoEntity implements Serializable {
        private String applyEndTime;
        private String basePlanDes;
        private String basePlanAddrees;
        private String companyName;
        private String basePlanEndTime;
        private String scale;
        private String basePlanStartTime;
        private int baseId;
        private int applyNum;
        private int isCanApply;
        private String baseWeal;
        private String basePlanNum;
        private int isApply;
        private String basePlanConnector;
        private String practiceName;
        private Object baseIcon;
        private String basePlanConnection;
        private int basePlanCityId;
        private int clickNum;
        private int planId;
        private String companyIcon;
        private int basePlanId;

        public String getApplyEndTime() {
            return applyEndTime;
        }

        public void setApplyEndTime(String applyEndTime) {
            this.applyEndTime = applyEndTime;
        }

        public String getBasePlanDes() {
            return basePlanDes;
        }

        public void setBasePlanDes(String basePlanDes) {
            this.basePlanDes = basePlanDes;
        }

        public String getBasePlanAddrees() {
            return basePlanAddrees;
        }

        public void setBasePlanAddrees(String basePlanAddrees) {
            this.basePlanAddrees = basePlanAddrees;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getBasePlanEndTime() {
            return basePlanEndTime;
        }

        public void setBasePlanEndTime(String basePlanEndTime) {
            this.basePlanEndTime = basePlanEndTime;
        }

        public String getScale() {
            return scale;
        }

        public void setScale(String scale) {
            this.scale = scale;
        }

        public String getBasePlanStartTime() {
            return basePlanStartTime;
        }

        public void setBasePlanStartTime(String basePlanStartTime) {
            this.basePlanStartTime = basePlanStartTime;
        }

        public int getBaseId() {
            return baseId;
        }

        public void setBaseId(int baseId) {
            this.baseId = baseId;
        }

        public int getApplyNum() {
            return applyNum;
        }

        public void setApplyNum(int applyNum) {
            this.applyNum = applyNum;
        }

        public int getIsCanApply() {
            return isCanApply;
        }

        public void setIsCanApply(int isCanApply) {
            this.isCanApply = isCanApply;
        }

        public String getBaseWeal() {
            return baseWeal;
        }

        public void setBaseWeal(String baseWeal) {
            this.baseWeal = baseWeal;
        }

        public String getBasePlanNum() {
            return basePlanNum;
        }

        public void setBasePlanNum(String basePlanNum) {
            this.basePlanNum = basePlanNum;
        }

        public int getIsApply() {
            return isApply;
        }

        public void setIsApply(int isApply) {
            this.isApply = isApply;
        }

        public String getBasePlanConnector() {
            return basePlanConnector;
        }

        public void setBasePlanConnector(String basePlanConnector) {
            this.basePlanConnector = basePlanConnector;
        }

        public String getPracticeName() {
            return practiceName;
        }

        public void setPracticeName(String practiceName) {
            this.practiceName = practiceName;
        }

        public Object getBaseIcon() {
            return baseIcon;
        }

        public void setBaseIcon(Object baseIcon) {
            this.baseIcon = baseIcon;
        }

        public String getBasePlanConnection() {
            return basePlanConnection;
        }

        public void setBasePlanConnection(String basePlanConnection) {
            this.basePlanConnection = basePlanConnection;
        }

        public int getBasePlanCityId() {
            return basePlanCityId;
        }

        public void setBasePlanCityId(int basePlanCityId) {
            this.basePlanCityId = basePlanCityId;
        }

        public int getClickNum() {
            return clickNum;
        }

        public void setClickNum(int clickNum) {
            this.clickNum = clickNum;
        }

        public int getPlanId() {
            return planId;
        }

        public void setPlanId(int planId) {
            this.planId = planId;
        }

        public String getCompanyIcon() {
            return companyIcon;
        }

        public void setCompanyIcon(String companyIcon) {
            this.companyIcon = companyIcon;
        }

        public int getBasePlanId() {
            return basePlanId;
        }

        public void setBasePlanId(int basePlanId) {
            this.basePlanId = basePlanId;
        }
    }

    public static class PostlistEntity implements Serializable {
        private String postDuty;
        private String postPay;
        private int postNum;
        private int postId;
        private String postDes;
        private int basePlanId;
        private String postOrder;
        private String postName;

        public String getPostName() {
            return postName;
        }

        public void setPostName(String postName) {
            this.postName = postName;
        }

        public String getPostDuty() {
            return postDuty;
        }

        public void setPostDuty(String postDuty) {
            this.postDuty = postDuty;
        }

        public String getPostPay() {
            return postPay;
        }

        public void setPostPay(String postPay) {
            this.postPay = postPay;
        }

        public int getPostNum() {
            return postNum;
        }

        public void setPostNum(int postNum) {
            this.postNum = postNum;
        }

        public int getPostId() {
            return postId;
        }

        public void setPostId(int postId) {
            this.postId = postId;
        }

        public String getPostDes() {
            return postDes;
        }

        public void setPostDes(String postDes) {
            this.postDes = postDes;
        }

        public int getBasePlanId() {
            return basePlanId;
        }

        public void setBasePlanId(int basePlanId) {
            this.basePlanId = basePlanId;
        }

        public String getPostOrder() {
            return postOrder;
        }

        public void setPostOrder(String postOrder) {
            this.postOrder = postOrder;
        }
    }
}