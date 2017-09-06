package com.example.win.newintern3.NewEntity;

public class TeacherInfo implements java.io.Serializable {
    public TeacherInfo() {

    }

    public TeacherInfo(Integer teacherId, String teacherName, Integer schoolId, Integer departmentId, String teacherTel) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.schoolId = schoolId;
        this.departmentId = departmentId;
        this.teacherTel = teacherTel;
    }

    private Integer teacherId;
    /** 教师名称 */
    private String teacherName;

    /** 所属学校 */
    private Integer schoolId;

    /** 所属院系 */
    private Integer departmentId;

    /** 教师手机号 */
    private String teacherTel;



    /**
     * 获取 教师ID 的值
     * @return Integer
     */
    public Integer getTeacherId() {
        return teacherId;
    }
    
    /**
     * 设置教师ID 的值

     */
    public TeacherInfo setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
        return this;
    }

    /**
     * 获取 教师名称 的值
     * @return String
     */
    public String getTeacherName() {
        return teacherName;
    }
    
    /**
     * 设置教师名称 的值
     *
     */
    public TeacherInfo setTeacherName(String teacherName) {
        this.teacherName = teacherName;
        return this;
    }

    /**
     * 获取 所属学校 的值
     * @return Integer
     */
    public Integer getSchoolId() {
        return schoolId;
    }
    
    /**
     * 设置所属学校 的值
     *
     */
    public TeacherInfo setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
        return this;
    }

    /**
     * 获取 所属院系 的值
     * @return Integer
     */
    public Integer getDepartmentId() {
        return departmentId;
    }
    
    /**
     * 设置所属院系 的值
     *
     */
    public TeacherInfo setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
        return this;
    }

    /**
     * 获取 教师手机号 的值
     * @return String
     */
    public String getTeacherTel() {
        return teacherTel;
    }
    
    /**
     * 设置教师手机号 的值
     *
     */
    public TeacherInfo setTeacherTel(String teacherTel) {
        this.teacherTel = teacherTel;
        return this;
    }


    @Override
    public String toString() {
        return "TeacherInfo{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", schoolId=" + schoolId +
                ", departmentId=" + departmentId +
                ", teacherTel='" + teacherTel + '\'' +
                '}';
    }
}