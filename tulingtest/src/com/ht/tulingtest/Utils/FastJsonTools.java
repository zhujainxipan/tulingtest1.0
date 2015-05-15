package com.ht.tulingtest.Utils;

/**
 * Created by IntelliJ IDEA
 * Project: com.ht.duanzi.utils
 * Author: 安诺爱成长
 * Email: 1399487511@qq.com
 * Date: 2015/5/10
 */
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
public class FastJsonTools {

    //Json字符串——>类型一：JavaBean
    public static <T> T getObject(String jsonStr,Class<T> cls)
    {
        T t = null;
        t = JSON.parseObject(jsonStr,cls);
        return t;
    }

    //Json字符串——>类型二：List<JavaBean>
    public static <T> List<T> getLists(String jsonStr,Class<T> cls)
    {
        List<T> list = null;
        list = JSON.parseArray(jsonStr, cls);
        return list;
    }

    //Json字符串——>类型三:List<String>
    public static  List<String> getStrings(String jsonStr)
    {
        List<String> list =null;
        //list = JSON.parseArray(jsonStr,String.class);//可以这样子用
        list = JSON.parseObject(jsonStr,new TypeReference<List<String>>(){}); //也可以这样子使用，即这里有两种方法
        return list;
    }

    //Json字符串——>类型四:List<Map<String,Object>>
    public static List<Map<String,Object>> getListMap(String jsonStr)
    {
        List<Map<String,Object>> list = null;
        list = JSON.parseObject(jsonStr,new TypeReference<List<Map<String,Object>>>(){});//注意是parseObject不是parseArray，人家api中是这么定义的
        return list;
    }
}

