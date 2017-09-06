package com.example.win.newintern3.Entity;

import java.io.Serializable;
import java.util.List;

/**
 * 班级数据实体类
 * Created by TAO_SX on 2016/7/13/013.
 */
public class SchoolGradesEntity {

    /**
     * gradesName : 电子商务（1）
     * gradesId : 1
     */

    private List<GradesEntity> grades;

    public List<GradesEntity> getGrades() {
        return grades;
    }

    public void setGrades(List<GradesEntity> grades) {
        this.grades = grades;
    }

    public static class GradesEntity implements Serializable {
        private String gradesName;
        private int gradesId;

        public String getGradesName() {
            return gradesName;
        }

        public void setGradesName(String gradesName) {
            this.gradesName = gradesName;
        }

        public int getGradesId() {
            return gradesId;
        }

        public void setGradesId(int gradesId) {
            this.gradesId = gradesId;
        }
    }
}
