package com.miyako.subject.commons.result;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * ClassName JsonAndBean
 * Description //TODO
 * Author weila
 * Date 2019-08-07-0007 20:42
 */
public class JsonAndBean{

    /**
     * 将字符串转换为Bean对象
     * parseInt()返回的是基本类型int 而valueOf()返回的是包装类Integer
     * Integer是可以使用对象方法的  而int类型就不能和Object类型进行互相转换 。
     */
    public static <T> T stringToBean(String s,Class<T> clazz) {
        if(s==null||s.length()==0||clazz==null) {
            return null;
        }
        if(clazz==int.class||clazz==Integer.class) {
            return ((T) Integer.valueOf(s));
        }else if(clazz==String.class) {
            return (T) s;
        }else if(clazz==long.class||clazz==Long.class) {
            return (T) Long.valueOf(s);
        }else {
            try{
                ObjectMapper mapper = new ObjectMapper();
                return mapper.readValue(s, clazz);
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }
    }

    public static <T> T stringToBean(String s, Class<?> collectionClass, Class<?>... elementClasses){
        try{
            ObjectMapper mapper = new ObjectMapper();
            JavaType javaType = mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
            return mapper.readValue(s,javaType);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将Bean对象转换为字符串类型
     * @param <T>
     */
    public static <T> String beanToString(T value) {
        //如果是null
        if(value==null) return null;
        //如果不是null
        Class<?> clazz=value.getClass();
        if(clazz==int.class||clazz==Integer.class) {
            return ""+value;
        }else if(clazz==String.class) {
            return ""+value;
        }else if(clazz==long.class||clazz==Long.class) {
            return ""+value;
        }else {
            try{
                ObjectMapper mapper = new ObjectMapper();
                return mapper.writeValueAsString(value);
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }
    }
}
