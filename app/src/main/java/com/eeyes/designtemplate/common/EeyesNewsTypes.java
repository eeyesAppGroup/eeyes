package com.eeyes.designtemplate.common;

/**
 * Created by Lei Guo on 2015/8/12.
 */
public class EeyesNewsTypes {

    /**
     * 第一个默认为全部分页
     * 处理活动类型的类
     * 如果以后更新活动的类型，只需改动这里就好
     */


    public static final String[] TYPES = {"全部","文艺晚会","学习培训","专题讲座","实践锻炼","主题活动","会议讲座"};

    //通过活动的id返回活动的类型
    public static String getTypeName(int typeId)
    {
        switch (typeId){
            case 1:
                return TYPES[0];
            case 2:
                return TYPES[1];
            case 3:
                return TYPES[2];
            case 4:
                return TYPES[3];
            case 5:
                return TYPES[4];
            case 6:
                return TYPES[5];
            case 7:
                return TYPES[6];
            default:
                return TYPES[0];
        }

    }

    public static int getTypeLength(){
        return TYPES.length;
    }
}
