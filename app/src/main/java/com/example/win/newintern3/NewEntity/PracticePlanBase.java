package com.example.win.newintern3.NewEntity;




public class PracticePlanBase implements java.io.Serializable {
    public PracticePlanBase() {

    }

    public PracticePlanBase(Integer practicePlanBaseId, Integer baseId, Integer planId) {
        this.practicePlanBaseId = practicePlanBaseId;
        this.baseId = baseId;
        this.planId = planId;
    }

    private Integer practicePlanBaseId;
    /** BaseId */
    private Integer baseId = 0;

    /** PlanId */
    private Integer planId = 0;



    /**
     * 获取 PracticePlanBaseId 的值
     * @return Integer
     */
    public Integer getPracticePlanBaseId() {
        return practicePlanBaseId;
    }
    
    /**
     * 设置PracticePlanBaseId 的值
     * @param
     */
    public PracticePlanBase setPracticePlanBaseId(Integer practicePlanBaseId) {
        this.practicePlanBaseId = practicePlanBaseId;
        return this;
    }

    /**
     * 获取 BaseId 的值
     * @return Integer
     */
    public Integer getBaseId() {
        return baseId;
    }
    
    /**
     * 设置BaseId 的值
     * @param
     */
    public PracticePlanBase setBaseId(Integer baseId) {
        this.baseId = baseId;
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
     * @param
     */
    public PracticePlanBase setPlanId(Integer planId) {
        this.planId = planId;
        return this;
    }

    @Override
    public String toString() {
        return "PracticePlanBase{" +
                "practicePlanBaseId=" + practicePlanBaseId +
                ", baseId=" + baseId +
                ", planId=" + planId +
                '}';
    }
//	public String toString() {
//        StringBuffer sb = new StringBuffer();
//        sb.append(this.getClass().getName());
//        sb.append("; practicePlanBaseId=" + (practicePlanBaseId == null ? "null" : practicePlanBaseId.toString()));
//        sb.append("; baseId=" + (baseId == null ? "null" : baseId.toString()));
//        sb.append("; planId=" + (planId == null ? "null" : planId.toString()));
//
//        return sb.toString();
//    }
}