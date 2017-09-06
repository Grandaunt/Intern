package com.example.win.newintern3.NewEntity;
import java.util.List;




public class QuestionInfo implements java.io.Serializable {

    public QuestionInfo() {

    }

    public QuestionInfo(Integer questionId, String questionTitle, String questionContent, Integer questionUserId, String questionTime, Integer isOver, Integer questionLevel, Integer questionToUserId, Integer questionType, List<QuestionAnswer> questionAnswerList) {
        this.questionId = questionId;
        this.questionTitle = questionTitle;
        this.questionContent = questionContent;
        this.questionUserId = questionUserId;
        this.questionTime = questionTime;
        this.isOver = isOver;
        this.questionLevel = questionLevel;
        this.questionToUserId = questionToUserId;
        this.questionType = questionType;
        this.questionAnswerList = questionAnswerList;
    }


    private Integer questionId;
    /** 问题标题 */
    private String questionTitle;

    /** 问题描述 */
    private String questionContent;

    /** 问题提出者 */
    private Integer questionUserId;

    /** 问题提出时间 */
    private String questionTime;

    /** 是否解决	0：否1是 */
    private Integer isOver;

    /** 问题难度	1：普通；2：重要 */
    private Integer questionLevel;

    /** 指定教师ID */
    private Integer questionToUserId;

    /** 问题类型 */
    private Integer questionType;


    private List<QuestionAnswer> questionAnswerList;

    
    public List<QuestionAnswer> getQuestionAnswerList() {
		return questionAnswerList;
	}

	public void setQuestionAnswerList(List<QuestionAnswer> questionAnswerList) {
		this.questionAnswerList = questionAnswerList;
	}

	/**
     * 获取 QuestionId 的值
     * @return Integer
     */
    public Integer getQuestionId() {
        return questionId;
    }
    
    /**
     * 设置QuestionId 的值
     *
     */
    public QuestionInfo setQuestionId(Integer questionId) {
        this.questionId = questionId;
        return this;
    }

    /**
     * 获取 问题标题 的值
     * @return String
     */
    public String getQuestionTitle() {
        return questionTitle;
    }
    
    /**
     * 设置问题标题 的值
     *
     */
    public QuestionInfo setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
        return this;
    }

    /**
     * 获取 问题描述 的值
     * @return String
     */
    public String getQuestionContent() {
        return questionContent;
    }
    
    /**
     * 设置问题描述 的值
     *
     */
    public QuestionInfo setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
        return this;
    }

    /**
     * 获取 问题提出者 的值
     * @return Integer
     */
    public Integer getQuestionUserId() {
        return questionUserId;
    }
    
    /**
     * 设置问题提出者 的值
     *
     */
    public QuestionInfo setQuestionUserId(Integer questionUserId) {
        this.questionUserId = questionUserId;
        return this;
    }

    /**
     * 获取 问题提出时间 的值
     * @return String
     */
    public String getQuestionTime() {
        return questionTime;
    }
    
    /**
     * 设置问题提出时间 的值
     *
     */
    public QuestionInfo setQuestionTime(String questionTime) {
        this.questionTime = questionTime;
        return this;
    }

    /**
     * 获取 是否解决	0：否1是 的值
     * @return Integer
     */
    public Integer getIsOver() {
        return isOver;
    }
    
    /**
     * 设置是否解决	0：否1是 的值
     *
     */
    public QuestionInfo setIsOver(Integer isOver) {
        this.isOver = isOver;
        return this;
    }

    /**
     * 获取 问题难度	1：普通；2：重要 的值
     * @return Integer
     */
    public Integer getQuestionLevel() {
        return questionLevel;
    }
    
    /**
     * 设置问题难度	1：普通；2：重要 的值
     *
     */
    public QuestionInfo setQuestionLevel(Integer questionLevel) {
        this.questionLevel = questionLevel;
        return this;
    }

    /**
     * 获取 指定教师ID 的值
     * @return Integer
     */
    public Integer getQuestionToUserId() {
        return questionToUserId;
    }
    
    /**
     * 设置指定教师ID 的值
     *
     */
    public QuestionInfo setQuestionToUserId(Integer questionToUserId) {
        this.questionToUserId = questionToUserId;
        return this;
    }

    /**
     * 获取 问题类型 的值
     * @return Integer
     */
    public Integer getQuestionType() {
        return questionType;
    }
    
    /**
     * 设置问题类型 的值
     *
     */
    public QuestionInfo setQuestionType(Integer questionType) {
        this.questionType = questionType;
        return this;
    }


    @Override
    public String toString() {
        return "QuestionInfo{" +
                "questionId=" + questionId +
                ", questionTitle='" + questionTitle + '\'' +
                ", questionContent=" + questionContent +
                ", questionUserId=" + questionUserId +
                ", questionTime='" + questionTime + '\'' +
                ", isOver=" + isOver +
                ", questionLevel=" + questionLevel +
                ", questionToUserId=" + questionToUserId +
                ", questionType=" + questionType +
                ", questionAnswerList=" + questionAnswerList +
                '}';
    }
}