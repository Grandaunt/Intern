package com.example.win.newintern3.Utils;

/**
 * Created by TAO_SX on 2016/6/28/028.
 */
public class URLConfig {
    public static final String weatherAPI = "http://api.map.baidu.com/telematics/v3/weather?location=%1$s&output=json&ak=7Ff4GL9wdGDOFkILauVBFgGRsNS5VrS4";

    //-----------------------------------------API--------------------------------------------------
   //    private static final String URL = "http://192.168.1.120:8089/";
    public static final String URL = "http://114.55.2.134:8080/";
    public static final String URL2 = "http://182.92.173.223:8080/mainStudentWeb/";
    //    public static final String URL2 = "http://172.16.10.242:8080/mainStudentWeb/";
    //通知-通知列表
    public static final String NoticePracticeAPI = URL + "trial/noticeinfo.do";
    //基地-基地列表-基地详情-筛选菜单数据
    public static final String BasePracticeAPI = URL + "trial/practicebase.do";
    //自主实习-计划获取
    public static final String NewPracticeAPI = URL + "trial/autonomy.do";
    //我的
    public static final String MyAPI = URL + "trial/myselfinfo.do";
    //找实习
    public static final String FindPracticeAPI = "http://172.16.10.242:8080/mainStudentWeb/practiceInterface/getRecommendPostList.do";
    //用户头像
    public static final String UPICONAPI = URL + "trial/userinfo_icon.do";
    //用户相关
    public static final String UserInfoAPI = URL + "trial/userinfo.do";
    //开始实习后的操作
    public static final String PracticeAPI = URL + "trial/userpractice.do";


    public static final String PracticePushAPI = URL + "trial/dynamic_publish.do";


    public static final String SchoolHomeAPI = URL + "trial/campusinfo.do";

    public static final String Pro_jpbAPI = URL + "trial/EducationInfo.do";


    public static final String Chance_API = URL + "trial/chanceinfo.do";

    public static final String Resume_API = URL + "trial/resumeinfo.do";

    /***
     * 新接口
     */
    //上传图片http://image.tyunfarm.com/Home/SaveImage?type=0&path=Vep
    public static final String UploadImageAPI = "http://image.tyunfarm.com/Home/SaveImage";
//    public static final String UploadImageAPI =  "http://172.16.10.234:8081/Home/SaveImage";
    //用户登录：（1.校验  2.返回：用户信息---用户实习申请信息）http://172.16.10.242:8080/mainStudentWeb/userlogin/login?UserName=1234&Password=123456
    public static final String LoginAPI = URL2 + "userlogin/login";
//      public static final String LoginAPI="http://172.16.10.242:8080/mainStudentWeb/userlogin/login"
    //2.根据（专业、学院、学校、地区）获取推荐的实习企业及岗位信息列表
    public static final String RecommendPracticeAPI = URL2 + "practiceInterface/getRecommendPostAndCompanyList.do";
    //申请实习_计划获取http://172.16.10.231:8080/mainStudentWeb/practiceInterface/getPracticeByStudentId.do?StudentId=4060
    public static final String NewInternAPI = URL2 + "practiceInterface/getPracticeByStudentId.do";
    //获取城市http://172.16.10.242:8080/mainStudentWeb/cityinfo/loadCityInfoList?pageNumber=0
    public static final String CityAPI = URL2 + "practiceInterface/getCityList";
    //获取基地http://172.16.10.242:8080/mainStudentWeb/cityinfo/loadCityInfoList?pageNumber=0
    public static final String BaseInfoAPI = URL2 + "practiceInterface/getBaseAndPostList.do";
    //获取申请通过的企业http://172.16.10.242:8080/mainStudentWeb/cityinfo/loadCityInfoList?pageNumber=0
    public static final String ComInfoAPI = URL2 + "practiceInterface/getPostAndCompanyPassList.do";
    //签到
    public static final String SinginAPI = URL2 + "practiceInterface/addSigninfo";
    //签到历史http://182.92.173.223:8080/mainStudentWeb/signinfo/selectByPage?startDate=2016-05-03&endDate=2016-07-20&userId=1
    public static final String SinginHistoryAPI = URL2 + "practiceInterface/selectSignInfo.do";

    //15：查询日志列表信息（日志信息和答复信息）http://182.92.173.223:8080/mainStudentWeb/practiceInterface/getDayReportList.do?StudentId=1&pageNumber=1
    public static final String JournalListAPI = URL2 + "practiceInterface/getDayReportList.do";
    //16：添加一个日志信息http://182.92.173.223:8080/mainStudentWeb/practiceInterface/addDayReportinfo
    public static final String JournalAPI = URL2 + "practiceInterface/addDayReportinfo";
    //17：查询周报列表信息（周报信息和点评信息）http://182.92.173.223:8080/mainStudentWeb/practiceInterface/getWeekReportList.do?StudentId=1&pageNumber=1
    public static final String WeekListAPI = URL2 + "practiceInterface/getWeekReportList.do";
    //18：添加一个周报信息http://182.92.173.223:8080/mainStudentWeb/practiceInterface/addWeekReportinfo
    public static final String WeekAPI = URL2 + "practiceInterface/addWeekReportInfo";
    // 19：查询請假列表信息http://182.92.173.223:8080/mainStudentWeb/practiceInterface/getLeaveInfoList.do?StudentId=1&pageNumber=1
    public static final String AskForLeaveListAPI = URL2 + "practiceInterface/getLeaveInfoList.do";
    //20：添加一个请假信息 http://182.92.173.223:8080/mainStudentWeb/practiceInterface/addLeaveInfo
    public static final String AskForLeaveAPI = URL2 + "practiceInterface/addLeaveInfo";
    //21：查询出差列表信息 http://182.92.173.223:8080/mainStudentWeb/practiceInterface/getTravelInfoList.do?StudentId=1&pageNumber=1
    public static final String BudinessListAPI = URL2 + "practiceInterface/getTravelInfoList.do";
    // 22：添加一个出差信息http://182.92.173.223:8080/mainStudentWeb/practiceInterface/addTravelInfo
    public static final String BudinessAPI = URL2 + "practiceInterface/addTravelInfo";
    // 23：查询问答列表信息http://182.92.173.223:8080/mainStudentWeb/practiceInterface/getTravelInfoList.do?StudentId=1&pageNumber=1
    public static final String QuestionsListAPI = URL2 + "practiceInterface/getQuestionInfoList.do";
    //24：添加一个问答信息 http://182.92.173.223:8080/mainStudentWeb/practiceInterface/addTravelInfo
    public static final String QuestionsAPI = URL2 + "practiceInterface/addQuestionInfo";
    //25：查询简历信息http://172.16.10.242:8080/mainStudentWeb/practiceInterface/getResumeInfo.do?StudentId=1
    public static final String ResumeAPI = URL2 + "practiceInterface/getResumeInfo.do";
    //26：添加一个实习经历 http://172.16.10.242:8080/mainStudentWeb/practiceInterface/addExperiencePractice
    public static final String AddInternAPI = URL2 + "practiceInterface/addExperiencePractice";
    //27：添加一个工作经历http://172.16.10.242:8080/mainStudentWeb/practiceInterface/addExperiencework
    public static final String AddWorkAPI = URL2 + "practiceInterface/addExperiencework";
    // 28：添加一个教育经历http://172.16.10.242:8080/mainStudentWeb/practiceInterface/addExperienceEducation
    public static final String AddEducationAPI = URL2 + "practiceInterface/addExperienceEducation";
    //29：添加一个项目经历 http://172.16.10.242:8080/mainStudentWeb/practiceInterface/addExperienceProject
    public static final String AddProjectAPI = URL2 + "practiceInterface/addExperienceProject";

    //6.添加实习申请 http://172.16.10.242:8080/mainStudentWeb/practiceInterface/addUserPractice
    public static final String AddPracticeAPI = URL2 + "practiceInterface/addUserPractice";

    //33：根据baseID获取基地岗位列表 http://172.16.10.242:8080/mainStudentWeb/practiceInterface/getBasePostListByBaseId.do?BaseId=5
    public static final String GetBasePostAPI = URL2 + "practiceInterface/getBasePostListByBaseId.do?";

    //32：根据planId 获取教师列表http://172.16.10.242:8080/mainStudentWeb/practiceInterface/getTeacherListByPlanId.do?PlanId=4
    public static final String GetTeacherAPI = URL2 + "practiceInterface/getTeacherListByPlanId.do?";
    //25：查询简历信息http://182.92.173.223:8080/mainStudentWeb/practiceInterface/getResumeInfo.do?StudentId=1
    public static final String ResumeInfoAPI = URL2 + "practiceInterface/getResumeInfo.do";


    //34：根据UserId获取实习情况http://172.16.10.242:8080//mainStudentWeb/practiceInterface/getUserPracticeByUserId.do?UserId=1
    public static final String GetPracticeStatusAPI = URL2 + "practiceInterface/getUserPracticeByUserId.do";


    //26：添加一个实习经历http://182.92.173.223:8080/mainStudentWeb/practiceInterface/addExperiencePractice
    public static final String AddInternErAPI = URL2 + "practiceInterface/addExperiencePractice";
    //27：添加一个工作经历http://182.92.173.223:8080/mainStudentWeb/practiceInterface/addExperiencework
    public static final String AddWorkErAPI = URL2 + "practiceInterface/addExperiencework";
    //28：添加一个教育经历 http://182.92.173.223:8080/mainStudentWeb/practiceInterface/addExperienceEducation
    public static final String AddEduErAPI = URL2 + "practiceInterface/addExperienceEducation";
    //29：添加一个项目经历http://182.92.173.223:8080/mainStudentWeb/practiceInterface/addExperienceProject
    public static final String AddProErAPI = URL2 + "practiceInterface/addExperienceProject";
    //30：添加简历基本信息http://182.92.173.223:8080/mainStudentWeb/practiceInterface/addResumeinfo
    public static final String AddResumeBaseInfoAPI = URL2 + "practiceInterface/addResumeinfo";
    //35：删除实习经历表http://172.16.10.242:8080/mainStudentWeb/experiencepractice/delExperiencePractice.do?practiceId=792
    public static final String DelInternErAPI = URL2 + "experiencepractice/delExperiencePractice.do";
    //38：删除工作经验http://172.16.10.242:8080/mainStudentWeb/experiencework/delExperiencework.do?workId=10
    public static final String DelWorkErAPI = URL2 + "experienceprojec/delExperiencework.do";
    //37：删除教育经历http://172.16.10.242:8080/mainStudentWeb/experienceeducation/delExperienceEducation.do?educationId=1
    public static final String DelEduErAPI = URL2 + "experienceeducation/delExperienceEducation.do";
    //36：删除项目经历http://172.16.10.242:8080/mainStudentWeb/experienceproject/delExperienceProject.do?projectId=10
    public static final String DelPorErAPI = URL2 + "experiencework/delExperienceProject.do";
}

