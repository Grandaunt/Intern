package com.example.win.newintern3.Utils.themes;

/**
 * 主题的默认实现类
 * 
 * The default implement of theme
 *
 * @author AigeStudio 2015-06-17
 */
public class DPBaseTheme extends DPTheme {
    //月视图背景色
    @Override
    public int colorBG() {
        return 0xFFFFFFFF;
    }

    //背景圆颜色
    @Override
    public int colorBGCircle() {
        return 0xFFFF0000;
    }

    //标题栏背景色
    @Override
    public int colorTitleBG() {
        return 0xFFFFFFFF;
    }

    //标题栏文本颜色
    @Override
    public int colorTitle() {
        return 0xFF000000;
    }

    // 今天的背景色
    @Override
    public int colorToday() {
        return 0xFF40d4FF;
    }

    //公历（一到五）文本颜色
    @Override
    public int colorG() {
        return 0xFF333333;
    }

    //农历节假日文本颜色
    @Override
    public int colorF() {
        return 0xFFcccccc;
    }

    //周末文本颜色
    @Override
    public int colorWeekend() {
        return 0xFF333333;
    }

    //假期文本颜色
    @Override
    public int colorHoliday() {
        return 0xAA40AFFF;
    }
}
