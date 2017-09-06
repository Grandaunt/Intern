package com.example.win.newintern3.Entity;

import java.io.Serializable;
import java.util.List;

/**
 * 院系数据实体类
 * Created by TAO_SX on 2016/7/13/013.
 */
public class SchoolDepartmentEntity implements Serializable {

    /**
     * departmentId : 1
     * departmentName : 计算机学院
     */

    private List<DepartmentEntity> department;

    public List<DepartmentEntity> getDepartment() {
        return department;
    }

    public void setDepartment(List<DepartmentEntity> department) {
        this.department = department;
    }

    public static class DepartmentEntity implements Serializable {
        private int departmentId;
        private String departmentName;

        public int getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(int departmentId) {
            this.departmentId = departmentId;
        }

        public String getDepartmentName() {
            return departmentName;
        }

        public void setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
        }
    }
}
