package com.example.win.newintern3.Entity;

import java.io.Serializable;
import java.util.List;

/**
 * 专业数据实体类
 * Created by TAO_SX on 2016/7/13/013.
 */
public class SchoolMajorEntity {

    /**
     * majorId : 1
     * majorName : 电子商务
     */

    private List<MajorEntity> major;

    public List<MajorEntity> getMajor() {
        return major;
    }

    public void setMajor(List<MajorEntity> major) {
        this.major = major;
    }

    public static class MajorEntity implements Serializable {
        private int majorId;
        private String majorName;

        public int getMajorId() {
            return majorId;
        }

        public void setMajorId(int majorId) {
            this.majorId = majorId;
        }

        public String getMajorName() {
            return majorName;
        }

        public void setMajorName(String majorName) {
            this.majorName = majorName;
        }
    }
}
