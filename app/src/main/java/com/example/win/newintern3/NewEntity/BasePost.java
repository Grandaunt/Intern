package com.example.win.newintern3.NewEntity;




public class BasePost implements java.io.Serializable {
    public BasePost() {

    }

    public BasePost(Integer postId, Integer baseId, String postName, Integer postNum, String postPay, Object postOrder, Object postDes, Object postDuty, Object isTrue, String welfare) {
        this.postId = postId;
        this.baseId = baseId;
        this.postName = postName;
        this.postNum = postNum;
        this.postPay = postPay;
        this.postOrder = postOrder;
        this.postDes = postDes;
        this.postDuty = postDuty;
        this.isTrue = isTrue;
        this.welfare = welfare;
    }

    public BasePost(Integer postId, Integer baseId, String postName, Integer postNum, String postPay, Object postOrder, Object postDes, Object postDuty, Object isTrue) {
        this.postId = postId;
        this.baseId = baseId;
        this.postName = postName;
        this.postNum = postNum;
        this.postPay = postPay;
        this.postOrder = postOrder;
        this.postDes = postDes;
        this.postDuty = postDuty;
        this.isTrue = isTrue;
    }

    private Integer postId;
    /** 基地ID */
    private Integer baseId;

    /** 职位名称 */
    private String postName;

    /** 岗位人数 */
    private Integer postNum;

    /** 实习补助 */
    private String postPay;

    /** 职位要求 */
    private Object postOrder;

    /** 实习说明 */
    private Object postDes;

    /** 职位职责 */
    private Object postDuty;

    /** 是否可用 */
    private Object isTrue;

    /** 福利*/
    private String welfare;

    public String getWelfare() {
        return welfare;
    }

    public void setWelfare(String welfare) {
        this.welfare = welfare;
    }

    /**
     * 获取 PostId 的值
     * @return Integer
     */
    public Integer getPostId() {
        return postId;
    }
    
    /**
     * 设置PostId 的值
     *
     */
    public BasePost setPostId(Integer postId) {
        this.postId = postId;
        return this;
    }

    /**
     * 获取 基地ID 的值
     * @return Integer
     */
    public Integer getBaseId() {
        return baseId;
    }
    
    /**
     * 设置基地ID 的值
     *
     */
    public BasePost setBaseId(Integer baseId) {
        this.baseId = baseId;
        return this;
    }

    /**
     * 获取 职位名称 的值
     * @return String
     */
    public String getPostName() {
        return postName;
    }
    
    /**
     * 设置职位名称 的值
     *
     */
    public BasePost setPostName(String postName) {
        this.postName = postName;
        return this;
    }

    /**
     * 获取 岗位人数 的值
     * @return Integer
     */
    public Integer getPostNum() {
        return postNum;
    }
    
    /**
     * 设置岗位人数 的值
     *
     */
    public BasePost setPostNum(Integer postNum) {
        this.postNum = postNum;
        return this;
    }

    /**
     * 获取 实习补助 的值
     * @return String
     */
    public String getPostPay() {
        return postPay;
    }
    
    /**
     * 设置实习补助 的值
     *
     */
    public BasePost setPostPay(String postPay) {
        this.postPay = postPay;
        return this;
    }

    /**
     * 获取 职位要求 的值
     * @return Object
     */
    public Object getPostOrder() {
        return postOrder;
    }
    
    /**
     * 设置职位要求 的值
     *
     */
    public BasePost setPostOrder(Object postOrder) {
        this.postOrder = postOrder;
        return this;
    }

    /**
     * 获取 实习说明 的值
     * @return Object
     */
    public Object getPostDes() {
        return postDes;
    }
    
    /**
     * 设置实习说明 的值
     *
     */
    public BasePost setPostDes(Object postDes) {
        this.postDes = postDes;
        return this;
    }

    /**
     * 获取 职位职责 的值
     * @return Object
     */
    public Object getPostDuty() {
        return postDuty;
    }
    
    /**
     * 设置职位职责 的值
     *
     */
    public BasePost setPostDuty(Object postDuty) {
        this.postDuty = postDuty;
        return this;
    }

    /**
     * 获取 是否可用 的值
     * @return Object
     */
    public Object getIsTrue() {
        return isTrue;
    }
    
    /**
     * 设置是否可用 的值
     *
     */
    public BasePost setIsTrue(Object isTrue) {
        this.isTrue = isTrue;
        return this;
    }

    @Override
    public String toString() {
        return "BasePost{" +
                "postId=" + postId +
                ", baseId=" + baseId +
                ", postName='" + postName + '\'' +
                ", postNum=" + postNum +
                ", postPay='" + postPay + '\'' +
                ", postOrder=" + postOrder +
                ", postDes=" + postDes +
                ", postDuty=" + postDuty +
                ", isTrue=" + isTrue +
                ", welfare='" + welfare + '\'' +
                '}';
    }
//	public String toString() {
//        StringBuffer sb = new StringBuffer();
//        sb.append(this.getClass().getName());
//        sb.append("; postId=" + (postId == null ? "null" : postId.toString()));
//        sb.append("; baseId=" + (baseId == null ? "null" : baseId.toString()));
//        sb.append("; postName=" + (postName == null ? "null" : postName.toString()));
//        sb.append("; postNum=" + (postNum == null ? "null" : postNum.toString()));
//        sb.append("; postPay=" + (postPay == null ? "null" : postPay.toString()));
//        sb.append("; postOrder=" + (postOrder == null ? "null" : postOrder.toString()));
//        sb.append("; postDes=" + (postDes == null ? "null" : postDes.toString()));
//        sb.append("; postDuty=" + (postDuty == null ? "null" : postDuty.toString()));
//        sb.append("; isTrue=" + (isTrue == null ? "null" : isTrue.toString()));
//
//        return sb.toString();
//    }
}