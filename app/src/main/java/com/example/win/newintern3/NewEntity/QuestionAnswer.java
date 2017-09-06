package com.example.win.newintern3.NewEntity;

public class QuestionAnswer implements java.io.Serializable {
    public QuestionAnswer() {

    }

    public QuestionAnswer(Integer answerId, Integer questionId, String answerDes, Integer answerUserId, String answerUserName, String answerTime, Integer answerLikeNum, Integer answerToUserId, String answerToUserName) {
        this.answerId = answerId;
        this.questionId = questionId;
        this.answerDes = answerDes;
        this.answerUserId = answerUserId;
        this.answerUserName = answerUserName;
        this.answerTime = answerTime;
        this.answerLikeNum = answerLikeNum;
        this.answerToUserId = answerToUserId;
        this.answerToUserName = answerToUserName;
    }

    private Integer answerId;
    /** 问题ID */
    private Integer questionId;

    /** 回答描述 */
    private String answerDes;

    /** 回答者Id */
    private Integer answerUserId;

    /** 评论者名 */
    private String answerUserName;

    /** 回答时间 */
    private String answerTime;

    /** AnswerLikeNum */
    private Integer answerLikeNum = 0;

    /** 回答对应者ID */
    private Integer answerToUserId;

    /** 回答对应者名 */
    private String answerToUserName;



    /**
     * 获取 回答Id 的值
     * @return Integer
     */
    public Integer getAnswerId() {
        return answerId;
    }
    
    /**
     * 设置回答Id 的值
     *
     */
    public QuestionAnswer setAnswerId(Integer answerId) {
        this.answerId = answerId;
        return this;
    }

    /**
     * 获取 问题ID 的值
     * @return Integer
     */
    public Integer getQuestionId() {
        return questionId;
    }
    
    /**
     * 设置问题ID 的值
     *
     */
    public QuestionAnswer setQuestionId(Integer questionId) {
        this.questionId = questionId;
        return this;
    }

    /**
     * 获取 回答描述 的值
     * @return String
     */
    public String getAnswerDes() {
        return answerDes;
    }
    
    /**
     * 设置回答描述 的值
     *
     */
    public QuestionAnswer setAnswerDes(String answerDes) {
        this.answerDes = answerDes;
        return this;
    }

    /**
     * 获取 回答者Id 的值
     * @return Integer
     */
    public Integer getAnswerUserId() {
        return answerUserId;
    }
    
    /**
     * 设置回答者Id 的值
     *
     */
    public QuestionAnswer setAnswerUserId(Integer answerUserId) {
        this.answerUserId = answerUserId;
        return this;
    }

    /**
     * 获取 评论者名 的值
     * @return String
     */
    public String getAnswerUserName() {
        return answerUserName;
    }
    
    /**
     * 设置评论者名 的值
     *
     */
    public QuestionAnswer setAnswerUserName(String answerUserName) {
        this.answerUserName = answerUserName;
        return this;
    }

    /**
     * 获取 回答时间 的值
     * @return String
     */
    public String getAnswerTime() {
        return answerTime;
    }
    
    /**
     * 设置回答时间 的值
     *
     */
    public QuestionAnswer setAnswerTime(String answerTime) {
        this.answerTime = answerTime;
        return this;
    }

    /**
     * 获取 AnswerLikeNum 的值
     * @return Integer
     */
    public Integer getAnswerLikeNum() {
        return answerLikeNum;
    }
    
    /**
     * 设置AnswerLikeNum 的值
     *
     */
    public QuestionAnswer setAnswerLikeNum(Integer answerLikeNum) {
        this.answerLikeNum = answerLikeNum;
        return this;
    }

    /**
     * 获取 回答对应者ID 的值
     * @return Integer
     */
    public Integer getAnswerToUserId() {
        return answerToUserId;
    }
    
    /**
     * 设置回答对应者ID 的值
     *
     */
    public QuestionAnswer setAnswerToUserId(Integer answerToUserId) {
        this.answerToUserId = answerToUserId;
        return this;
    }

    /**
     * 获取 回答对应者名 的值
     * @return String
     */
    public String getAnswerToUserName() {
        return answerToUserName;
    }
    
    /**
     * 设置回答对应者名 的值
     *
     */
    public QuestionAnswer setAnswerToUserName(String answerToUserName) {
        this.answerToUserName = answerToUserName;
        return this;
    }


    @Override
    public String toString() {
        return "QuestionAnswer{" +
                "answerId=" + answerId +
                ", questionId=" + questionId +
                ", answerDes=" + answerDes +
                ", answerUserId=" + answerUserId +
                ", answerUserName='" + answerUserName + '\'' +
                ", answerTime='" + answerTime + '\'' +
                ", answerLikeNum=" + answerLikeNum +
                ", answerToUserId=" + answerToUserId +
                ", answerToUserName='" + answerToUserName + '\'' +
                '}';
    }
}