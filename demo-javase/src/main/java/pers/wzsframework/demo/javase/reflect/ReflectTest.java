package pers.wzsframework.demo.javase.reflect;

import java.lang.reflect.ParameterizedType;

public class ReflectTest extends BaseReflect<User>{

	public static void main(String[] args) {
		ReflectTest test=new ReflectTest();
		test.test();
	}
	
	public void test(){
		System.out.println("fafafe");
		System.out.println(((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
	}

}
