package com.github.itliwei.util;


import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;


public class CompareUtil {
    /**
     * 比较两个实体属性值，返回一个map以有差异的属性名为key，value为一个Map分别存oldObject,newObject此属性名的值
     *
     * @param oldObject 进行属性比较的对象1
     * @param newObject 进行属性比较的对象2
     * @param ignoreArr 忽略比较的字段
     * @return 属性差异比较结果map
     */
    public static Map<String, List<Object>> compareFields(Object oldObject, Object newObject, boolean userAnno, String[] ignoreArr) {
        try {
            Map<String, List<Object>> map = new HashMap<>();
            Set<String> ignoreList = null;
            if (ignoreArr != null && ignoreArr.length > 0) {
                // array转化为list
                ignoreList = new HashSet<>(Arrays.asList(ignoreArr));
            }
            if (oldObject.getClass() != newObject.getClass()) {
                return map;
            }
            Class clazz = oldObject.getClass();
            // 获取object的属性描述
            PropertyDescriptor[] pds = Introspector.getBeanInfo(clazz, Object.class).getPropertyDescriptors();
            // 这里就是所有的属性了
            for (PropertyDescriptor pd : pds) {
                // 属性名
                String name = pd.getName();
                if (ignoreList != null && ignoreList.contains(name)) {// 如果当前属性选择忽略比较，跳到下一次循环
                    continue;
                }
                // get方法
                Method readMethod = pd.getReadMethod();
                // 获取值
                Object oldValue = readMethod.invoke(oldObject);
                Object newValue = readMethod.invoke(newObject);
                //放置结果
                if (oldValue == null || !oldValue.equals(newValue)) {
                    //获取注解备注
                    if (userAnno) {
                        //根据字段名来获取字段
                        Field f = clazz.getDeclaredField(name);
                        FieldInfo annotation = f.getAnnotation(FieldInfo.class);
                        if (annotation != null) {
                            name = annotation.desc();
                        }
                    }
                    List<Object> list = new ArrayList<>(2);
                    list.add(oldValue);
                    list.add(newValue);
                    map.put(name, list);
                }
            }
            return map;
        } catch (Exception e) {
            return null;
        }
    }


    public static void main(String[] args) throws InterruptedException {
        User user1 = new User("liwei", 18, (byte) 1, new Date());
        Thread.sleep(100);
        User user2 = new User("liwei", 19, (byte) 1, new Date());
        String[] ignor = {"age"};
        Map<String, List<Object>> stringListMap = CompareUtil.compareFields(user1, user2, true, null);
        System.out.println(stringListMap);
    }
}