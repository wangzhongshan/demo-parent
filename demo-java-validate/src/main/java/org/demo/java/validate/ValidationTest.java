package org.demo.java.validate;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

public class ValidationTest {

	public static void main(String[] args) {
		User user=new User();
		user.setAge(0);
		user.setUserName("哈哈哈哈哈哈哈哈网地方急哦跟偶记基金覅额及覅额计菲菲");
		user.setSex("男");
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Set<ConstraintViolation<User>> violations = factory.getValidator().validate(user);
        if (violations!=null && violations.size()>0) {
            for (ConstraintViolation<User> violation : violations) {
                System.out.println(violation.getMessage());
            }
        }
	}

}
