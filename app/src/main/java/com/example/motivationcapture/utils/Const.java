package com.example.motivationcapture.utils;

import java.util.Calendar;

/**
 * Created by tokunaga on 11/15/17.
 */

public class Const {
    public static final String TODAY = Today();
//    MainActivity
    public static final String[] QUESTIONS = {"今日の気分は？", "昨日と比べて自信がつきましたか？", "コメント"};
    public static final String[] Q2_ANSWERS = {"自信がついた", "少し自信がついた", "変わらない", "少し自信をなくした", "自信をなくした"};
    public static final String SENDBTNTXT = "入力確定";
//    ShowOverviewActivity
    public static final String[] TITLES = {"フィーリンググラフ", "コンフィデンスグラフ"};
    public static final String BACKBTNTXT = "戻る";

    private static String Today() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int date = cal.get(Calendar.DATE);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        String[] dayArray = {"(日)", "(月)", "(火)", "(水)", "(木)", "(金)", "(土)"};
        String dayString = new String();

        if (day < 8){
            dayString = dayArray[day-1];
        }
        String dateMessage = Integer.toString(year) + "年 " + Integer.toString(month) + "月 " + Integer.toString(date) + "日 " + dayString;

        return dateMessage;

    }

}


