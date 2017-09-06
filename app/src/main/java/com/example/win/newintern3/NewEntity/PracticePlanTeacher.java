package com.example.win.newintern3.NewEntity;


public class PracticePlanTeacher implements java.io.Serializable {
    public PracticePlanTeacher() {

    }

    public PracticePlanTeacher(Integer practicePlanTeacherId, Integer planId, Integer teacherId) {
        this.practicePlanTeacherId = practicePlanTeacherId;
        this.planId = planId;
        this.teacherId = teacherId;
    }

    private Integer practicePlanTeacherId;
    /** PlanId */
    private Integer planId = 0;

    /** TeacherId */
    private Integer teacherId = 0;



    /**
     * 获取 PracticePlanTeacherId 的值
     * @return Integer
     */
    public Integer getPracticePlanTeacherId() {
        return practicePlanTeacherId;
    }
    
    /**
     * 设置PracticePlanTeacherId 的值
     *
     */
    public PracticePlanTeacher setPracticePlanTeacherId(Integer practicePlanTeacherId) {
        this.practicePlanTeacherId = practicePlanTeacherId;
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
    public PracticePlanTeacher setPlanId(Integer planId) {
        this.planId = planId;
        return this;
    }

    /**
     * 获取 TeacherId 的值
     * @return Integer
     */
    public Integer getTeacherId() {
        return teacherId;
    }
    
    /**
     * 设置TeacherId 的值
     *
     */
    public PracticePlanTeacher setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
        return this;
    }

    @Override
    public String toString() {
        return "PracticePlanTeacher{" +
                "practicePlanTeacherId=" + practicePlanTeacherId +
                ", planId=" + planId +
                ", teacherId=" + teacherId +
                '}';
    }
//
//	public String toString() {
//        StringBuffer sb = new StringBuffer();
//        sb.append(this.getClass().getName());
//        sb.append("; practicePlanTeacherId=" + (practicePlanTeacherId == null ? "null" : practicePlanTeacherId.toString()));
//        sb.append("; planId=" + (planId == null ? "null" : planId.toString()));
//        sb.append("; teacherId=" + (teacherId == null ? "null" : teacherId.toString()));
//
//        return sb.toString();
//    }
}