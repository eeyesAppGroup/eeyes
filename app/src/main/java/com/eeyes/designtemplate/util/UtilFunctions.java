package com.eeyes.designtemplate.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;

import com.eeyes.designtemplate.R;

/**
 * Created by lizhaotailang on 2016/4/23.
 */
public class UtilFunctions {

    public static int getThemeState(Context context){
        // 从SharedPreferences读取主题的值，如果为日间主题，返回0，夜间主题返回1
        // read the theme value from SharedPreferences, if it is day mode, return 0,or return 1.
        SharedPreferences sp = context.getSharedPreferences("user_settings", Context.MODE_PRIVATE);
        return sp.getInt("theme",0);
    }

    /**
     * 储存主题对应的int值 store theme value
     * @param context 上下文 context
     * @param themeValue 主题对应int值 0为日间主题，1为夜间主题 theme's int value, 0->day mode, 1->night mode
     */
    public static void setThemeState(Context context, int themeValue){
        SharedPreferences sp = context.getSharedPreferences("user_settings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("theme",themeValue);
        editor.apply();
    }

    public static void setTheme(Activity activity){
        if ( UtilFunctions.getThemeState(activity) == 0){
            activity.setTheme(R.style.DayTheme);
        } else {
            activity.setTheme(R.style.NightTheme);
        }

        // change the status bar's color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            Window window = activity.getWindow();
            // clear FLAG_TRANSLUCENT_STATUS flag:
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

            // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

            // finally change the color
            if (UtilFunctions.getThemeState(activity) == 0){
                window.setStatusBarColor(activity.getResources().getColor(R.color.colorStatusBarLight));
            } else {
                window.setStatusBarColor(activity.getResources().getColor(R.color.colorStatusBarDark));
            }

        }

    }

}
