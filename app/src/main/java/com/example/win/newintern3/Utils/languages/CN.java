package com.example.win.newintern3.Utils.languages;

/**
 * 中文的默认实现类
 * 如果你想实现更多的语言请参考Language{@link DPLManager}
 *
 * The implementation class of chinese.
 * You can refer to Language{@link DPLManager} if you want to define more language.
 *
 * @author AigeStudio 2015-03-28
 */
public class CN extends DPLManager {
    @Override
    public String[] titleMonth() {
//        return new String[]{"一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"};
        return new String[]{"1 月", "2 月", "3 月", "4 月", "5 月", "6 月", "7 月", "8 月", "9 月", "10 月", "11 月", "12 月"};
    }


    @Override
    public String titleEnsure() {
        return "确定";
    }

    @Override
    public String titleBC() {
        return "公元前";
    }

    @Override
    public String[] titleWeek() {
        return new String[]{"日", "一", "二", "三", "四", "五", "六"};
    }
}
