package com.land.myfeature.myutils;

import com.alibaba.fastjson.JSON;
import com.land.myfeature.retrofit.BaseRespPack;

/**
 * com.land.myfeature.myutils
 * Created by nikai on 2017-11-22.
 * Description:
 */

public class PrintUtils {
    private static final String TAG = "PrintUtils";

    public static String printJavaBean(BaseRespPack object) {
        if (object != null) {
            String JsonString = JSON.toJSONString(object);
            return format(JsonString);
        }
        return null;
    }

    public static String format(String jsonStr) {
        int level = 0;
        StringBuffer jsonForMatStr = new StringBuffer();
        for (int i = 0; i < jsonStr.length(); i++) {
            char c = jsonStr.charAt(i);
            if (level > 0 && '\n' == jsonForMatStr.charAt(jsonForMatStr.length() - 1)) {
                jsonForMatStr.append(getLevelStr(level));
            }
            switch (c) {
                case '{':
                case '[':
                    jsonForMatStr.append(c + "\n");
                    level++;
                    break;
                case ',':
                    jsonForMatStr.append(c + "\n");
                    break;
                case '}':
                case ']':
                    jsonForMatStr.append("\n");
                    level--;
                    jsonForMatStr.append(getLevelStr(level));
                    jsonForMatStr.append(c);
                    break;
                default:
                    jsonForMatStr.append(c);
                    break;
            }
        }

        return jsonForMatStr.toString();

    }

    private static String getLevelStr(int level) {
        StringBuffer levelStr = new StringBuffer();
        for (int levelI = 0; levelI < level; levelI++) {
            levelStr.append("\t");
        }
        return levelStr.toString();
    }

}

