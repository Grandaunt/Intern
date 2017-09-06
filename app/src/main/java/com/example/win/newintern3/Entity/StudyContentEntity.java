package com.example.win.newintern3.Entity;

import java.util.List;

/**
 * Created by TAO_SX on 2016/5/23/023.
 */
public class StudyContentEntity {

    /**
     * code : 200
     * comment : [{"commentContent":"ceshi","commentId":1,"commentScore":0,"commentTime":"2016-05-06 17:45:41","commentUserId":1,"educationId":1,"icon":"http://114.55.2.134:8080/images/Icon/icon50074ff55f5747bd8d7fd2aa1a221a13","nickName":"牡丹园梁朝伟","trueName":"陶世雄"}]
     * education : [{"categoryTitle":"创业与敬业","dictionaryUserId":1,"educationContentType":1,"educationId":1,"educationNum":3,"educationPath":"http://114.55.2.134:8080/images/education/创业与战略设计.mp4","educationPic":"http://114.55.2.134:8080/images/education/images/C10421世界五百强管理方法工具原则-3.gif","educationTime":"2015-5-1","educationTitle":"创业与战略设计","educationType":1,"isRecommend":1,"isTrue":1,"rootcategoryId":2}]
     * start : 1
     */

    private String code;
    private int start;
    /**
     * commentContent : ceshi
     * commentId : 1
     * commentScore : 0
     * commentTime : 2016-05-06 17:45:41
     * commentUserId : 1
     * educationId : 1
     * icon : http://114.55.2.134:8080/images/Icon/icon50074ff55f5747bd8d7fd2aa1a221a13
     * nickName : 牡丹园梁朝伟
     * trueName : 陶世雄
     */

    private List<CommentEntity> comment;
    /**
     * categoryTitle : 创业与敬业
     * dictionaryUserId : 1
     * educationContentType : 1
     * educationId : 1
     * educationNum : 3
     * educationPath : http://114.55.2.134:8080/images/education/创业与战略设计.mp4
     * educationPic : http://114.55.2.134:8080/images/education/images/C10421世界五百强管理方法工具原则-3.gif
     * educationTime : 2015-5-1
     * educationTitle : 创业与战略设计
     * educationType : 1
     * isRecommend : 1
     * isTrue : 1
     * rootcategoryId : 2
     */

    private List<EducationEntity> education;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public List<CommentEntity> getComment() {
        return comment;
    }

    public void setComment(List<CommentEntity> comment) {
        this.comment = comment;
    }

    public List<EducationEntity> getEducation() {
        return education;
    }

    public void setEducation(List<EducationEntity> education) {
        this.education = education;
    }

    public static class CommentEntity {
        private String commentContent;
        private int commentId;
        private int commentScore;
        private String commentTime;
        private int commentUserId;
        private int educationId;
        private String icon;
        private String nickName;
        private String trueName;

        public String getCommentContent() {
            return commentContent;
        }

        public void setCommentContent(String commentContent) {
            this.commentContent = commentContent;
        }

        public int getCommentId() {
            return commentId;
        }

        public void setCommentId(int commentId) {
            this.commentId = commentId;
        }

        public int getCommentScore() {
            return commentScore;
        }

        public void setCommentScore(int commentScore) {
            this.commentScore = commentScore;
        }

        public String getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(String commentTime) {
            this.commentTime = commentTime;
        }

        public int getCommentUserId() {
            return commentUserId;
        }

        public void setCommentUserId(int commentUserId) {
            this.commentUserId = commentUserId;
        }

        public int getEducationId() {
            return educationId;
        }

        public void setEducationId(int educationId) {
            this.educationId = educationId;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getTrueName() {
            return trueName;
        }

        public void setTrueName(String trueName) {
            this.trueName = trueName;
        }
    }

    public static class EducationEntity {
        private String categoryTitle;
        private int dictionaryUserId;
        private int educationContentType;
        private int educationId;
        private int educationNum;
        private String educationPath;
        private String educationPic;
        private String educationTime;
        private String educationTitle;
        private int educationType;
        private int isRecommend;
        private int isTrue;
        private int rootcategoryId;
        private String educationDes;

        public String getEducationDes() {
            return educationDes;
        }

        public void setEducationDes(String educationDes) {
            this.educationDes = educationDes;
        }

        public String getCategoryTitle() {
            return categoryTitle;
        }

        public void setCategoryTitle(String categoryTitle) {
            this.categoryTitle = categoryTitle;
        }

        public int getDictionaryUserId() {
            return dictionaryUserId;
        }

        public void setDictionaryUserId(int dictionaryUserId) {
            this.dictionaryUserId = dictionaryUserId;
        }

        public int getEducationContentType() {
            return educationContentType;
        }

        public void setEducationContentType(int educationContentType) {
            this.educationContentType = educationContentType;
        }

        public int getEducationId() {
            return educationId;
        }

        public void setEducationId(int educationId) {
            this.educationId = educationId;
        }

        public int getEducationNum() {
            return educationNum;
        }

        public void setEducationNum(int educationNum) {
            this.educationNum = educationNum;
        }

        public String getEducationPath() {
            return educationPath;
        }

        public void setEducationPath(String educationPath) {
            this.educationPath = educationPath;
        }

        public String getEducationPic() {
            return educationPic;
        }

        public void setEducationPic(String educationPic) {
            this.educationPic = educationPic;
        }

        public String getEducationTime() {
            return educationTime;
        }

        public void setEducationTime(String educationTime) {
            this.educationTime = educationTime;
        }

        public String getEducationTitle() {
            return educationTitle;
        }

        public void setEducationTitle(String educationTitle) {
            this.educationTitle = educationTitle;
        }

        public int getEducationType() {
            return educationType;
        }

        public void setEducationType(int educationType) {
            this.educationType = educationType;
        }

        public int getIsRecommend() {
            return isRecommend;
        }

        public void setIsRecommend(int isRecommend) {
            this.isRecommend = isRecommend;
        }

        public int getIsTrue() {
            return isTrue;
        }

        public void setIsTrue(int isTrue) {
            this.isTrue = isTrue;
        }

        public int getRootcategoryId() {
            return rootcategoryId;
        }

        public void setRootcategoryId(int rootcategoryId) {
            this.rootcategoryId = rootcategoryId;
        }
    }
}
