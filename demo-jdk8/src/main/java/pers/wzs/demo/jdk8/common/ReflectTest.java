package pers.wzs.demo.jdk8.common;

import java.lang.reflect.*;
import java.util.List;
import java.util.Map;

/**
 * Created by wangzhongshan on 2017/9/8.
 */
public class ReflectTest {
    private Map<String, String> map;

    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {
        // Class<UserDao> userDaoClass = UserDao.class;
        // Method getUsers = userDaoClass.getMethod("getUsers",String.class, List.class);
        // Parameter[] parameters = getUsers.getParameters();
        // for (Parameter parameter : parameters) {
        //     System.out.println(parameter.getName());
        //     System.out.println(parameter.getType());
        //     System.out.println(parameter.getParameterizedType());
        // }
        Class<ReflectTest> reflectTestClass = ReflectTest.class;
        Field field = reflectTestClass.getDeclaredField("map");
        System.out.println("一般type:" + field.getType());
        Type genericType = field.getGenericType();
        if (genericType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericType;
            System.out.println("parameterizedType:" + parameterizedType);
            Type rawType = parameterizedType.getRawType();
            System.out.println("原始类型：" + rawType);
            for (Type type : parameterizedType.getActualTypeArguments()) {
                System.out.println("泛型参数类型：" + type);
            }
        }
    }
}
