package com.example.win.newintern3.Entity;

import java.util.List;

/**
 * Created by TAO_SX on 2016/8/10/010.
 */
public class SchoolRecruimentEntity {

    /**
     * code : 200
     * start : 3
     * fairlist : [{"fairEndTime":"2016-08-17","fairStartTime":"2016-08-02","fairPic":"http://114.55.2.134:8080/images/schoolfair/gaodangchuangyizhaopinhaibaoshejipsd_6154483.jpg","fairId":"692d75fd000000c0","fairTitle":"才聚汇智招聘会0","fairTime":"2016-08-08 16:03:22"},{"fairEndTime":"2016-08-17","fairStartTime":"2016-08-02","fairPic":"http://114.55.2.134:8080/images/schoolfair/gaodangchuangyizhaopinhaibaoshejipsd_6154483.jpg","fairId":"692d75fd000002c0","fairTitle":"才聚汇智招聘会2","fairTime":"2016-08-08 16:03:22"},{"fairEndTime":"2016-08-17","fairStartTime":"2016-08-02","fairPic":"http://114.55.2.134:8080/images/schoolfair/gaodangchuangyizhaopinhaibaoshejipsd_6154483.jpg","fairId":"692d75fd000001c0","fairTitle":"才聚汇智招聘会1","fairTime":"2016-08-08 16:03:22"}]
     */

    private String code;
    private int start;
    /**
     * fairEndTime : 2016-08-17
     * fairStartTime : 2016-08-02
     * fairPic : http://114.55.2.134:8080/images/schoolfair/gaodangchuangyizhaopinhaibaoshejipsd_6154483.jpg
     * fairId : 692d75fd000000c0
     * fairTitle : 才聚汇智招聘会0
     * fairTime : 2016-08-08 16:03:22
     */

    private List<FairlistEntity> fairlist;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public List<FairlistEntity> getFairlist() {
        return fairlist;
    }

    public void setFairlist(List<FairlistEntity> fairlist) {
        this.fairlist = fairlist;
    }

    public static class FairlistEntity {
        private String fairEndTime;
        private String fairStartTime;
        private String fairPic;
        private String fairId;
        private String fairTitle;
        private String fairTime;

        public String getFairEndTime() {
            return fairEndTime;
        }

        public void setFairEndTime(String fairEndTime) {
            this.fairEndTime = fairEndTime;
        }

        public String getFairStartTime() {
            return fairStartTime;
        }

        public void setFairStartTime(String fairStartTime) {
            this.fairStartTime = fairStartTime;
        }

        public String getFairPic() {
            return fairPic;
        }

        public void setFairPic(String fairPic) {
            this.fairPic = fairPic;
        }

        public String getFairId() {
            return fairId;
        }

        public void setFairId(String fairId) {
            this.fairId = fairId;
        }

        public String getFairTitle() {
            return fairTitle;
        }

        public void setFairTitle(String fairTitle) {
            this.fairTitle = fairTitle;
        }

        public String getFairTime() {
            return fairTime;
        }

        public void setFairTime(String fairTime) {
            this.fairTime = fairTime;
        }
    }
}
