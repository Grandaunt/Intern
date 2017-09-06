package com.example.win.newintern3.NewEntity;


public class PracticePlanStudent implements java.io.Serializable {
    public PracticePlanStudent() {

    }

    public PracticePlanStudent(Integer practicePlanStudentId, Integer planId, Integer studentId) {
        this.practicePlanStudentId = practicePlanStudentId;
        this.planId = planId;
        this.studentId = studentId;
    }

    private Integer practicePlanStudentId;
    /** PlanId */
    private Integer planId = 0;

    /** StudentId */
    private Integer studentId = 0;



    /**
     * 获取 PracticePlanStudentId 的值
     * @return Integer
     */
    public Integer getPracticePlanStudentId() {
        return practicePlanStudentId;
    }
    
    /**
     * 设置PracticePlanStudentId 的值
     *
     */
    public PracticePlanStudent setPracticePlanStudentId(Integer practicePlanStudentId) {
        this.practicePlanStudentId = practicePlanStudentId;
        return this;
    }

    /**
     * 获取 PlanId 的值
     * @return Integer
     */
    public Integer getPlanId() {
        return planId;
    }
    
    /**
     * 设置PlanId 的值
     *
     */
    public PracticePlanStudent setPlanId(Integer planId) {
        this.planId = planId;
        return this;
    }

    /**
     * 获取 StudentId 的值
     * @return Integer
     */
    public Integer getStudentId() {
        return studentId;
    }
    
    /**
     * 设置StudentId 的值
     *
     */
    public PracticePlanStudent setStudentId(Integer studentId) {
        this.studentId = studentId;
        return this;
    }

    @Override
    public String toString() {
        return "PracticePlanStudent{" +
                "practicePlanStudentId=" + practicePlanStudentId +
                ", planId=" + planId +
                ", studentId=" + studentId +
                '}';
    }

//	public String toString() {
//        StringBuffer sb = new StringBuffer();
//        sb.append(this.getClass().getName());
//        sb.append("; practicePlanStudentId=" + (practicePlanStudentId == null ? "null" : practicePlanStudentId.toString()));
//        sb.append("; planId=" + (planId == null ? "null" : planId.toString()));
//        sb.append("; studentId=" + (studentId == null ? "null" : studentId.toString()));
//
//        return sb.toString();
//    }
}