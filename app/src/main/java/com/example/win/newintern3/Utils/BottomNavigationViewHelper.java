package com.example.win.newintern3.Utils;

import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;

import java.lang.reflect.Field;

// 利用反射，改变 item 中 mShiftingMode 的值
public class BottomNavigationViewHelper {

    public static void disableShiftMode(BottomNavigationView navigationView) {

        BottomNavigationMenuView menuView = (BottomNavigationMenuView) navigationView.getChildAt(0);

        Field shiftingMode = null;
        try {
            shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        shiftingMode.setAccessible(true);
        try {
            shiftingMode.setBoolean(menuView, false);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        shiftingMode.setAccessible(false);

        for (int i = 0; i < menuView.getChildCount(); i++) {
            BottomNavigationItemView itemView = (BottomNavigationItemView) menuView.getChildAt(i);
            itemView.setShiftingMode(false);
            itemView.setChecked(itemView.getItemData().isChecked());

        }
    }
}