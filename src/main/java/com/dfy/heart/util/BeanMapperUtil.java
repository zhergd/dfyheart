package com.dfy.heart.util;


import org.slf4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.util.CollectionUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


public class BeanMapperUtil {


    /**
     * 缓存coper
     */
    public static Map<String, BeanCopier> beanCopierMap = new ConcurrentHashMap<>();

    /**
     * @param source
     * @param target
     * @return
     */
    private static String generateKey(Class<?> source, Class<?> target) {
        return source.toString() + target.toString();
    }

    /**
     * 单个转换
     *
     * @param source
     * @param destinationClass
     * @param <T>
     * @return
     */
    public static <T> T map(Object source, Class<T> destinationClass) {
        if (source == null) {
            return null;
        }
        try {
            T instance = destinationClass.newInstance();
            copyProperties(source, instance);
            return instance;
        } catch (Throwable e) {
            return null;
        }
    }

    /**
     * 集合转换
     *
     * @param sourceList
     * @param destinationClass
     * @param <T>
     * @return
     */
    public static <T> List<T> mapList(Collection sourceList, Class<T> destinationClass) {
        List<T> destinationList = new ArrayList<>();
        if (CollectionUtils.isEmpty(sourceList)) {
            return destinationList;
        }
        for (Object sourceObject : sourceList) {
            T cur = map(sourceObject, destinationClass);
            destinationList.add(cur);
        }
        return destinationList;
    }

    /**
     * @param source
     * @param target
     */
    public static void copyProperties(Object source, Object target) {
        String beanKey = generateKey(source.getClass(), target.getClass());
        BeanCopier copier;
        if (!beanCopierMap.containsKey(beanKey)) {
            copier = BeanCopier.create(source.getClass(), target.getClass(), false);
            beanCopierMap.put(beanKey, copier);
        } else {
            copier = beanCopierMap.get(beanKey);
        }
        copier.copy(source, target, null);
    }

    /**
     * copy 不为 null的 .
     *
     * @param source
     * @param target
     */
    public static void copyNotNullProperties(Object source, Object target) {
        BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
    }

    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for (PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }


    /**
     * 获取利用反射获取类里面的值和名称
     *
     * @param obj
     * @return
     */
    public static HashMap<String, Object> objectToMap(Object obj) {
        HashMap<String, Object> map = new HashMap<>();
        Class<?> clazz = obj.getClass();
        if (classToMap(obj, map, clazz)) return map;
        return new HashMap<>();
    }

    public static HashMap<String, Object> objectAndSuperClassToMap(Object obj) {
        HashMap<String, Object> map = new HashMap<>();
        Class<?> clazz = obj.getClass();
        Class superclass = obj.getClass().getSuperclass();
        if (classToMap(obj, map, clazz) && classToMap(obj, map, superclass)) {
            return map;
        }
        return new HashMap<>();
    }

    private static boolean classToMap(Object obj, HashMap<String, Object> map, Class<?> clazz) {
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value;
            try {
                value = field.get(obj);
            } catch (IllegalAccessException e) {
                return false;
            }
            map.put(fieldName, value);
        }
        return true;
    }


    public static <T> T mapToObject(Map<String, Object> map, Class<?> beanClass) {
        if (map == null)
            return null;
        Object obj = null;
        try {
            obj = beanClass.newInstance();
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                Method setter = property.getWriteMethod();
                if (setter != null) {
                    setter.invoke(obj, map.get(property.getName()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) obj;
    }
}