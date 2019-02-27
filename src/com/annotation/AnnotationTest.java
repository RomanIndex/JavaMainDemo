package com.annotation;

import javax.validation.ValidationException;

import com.commonEntity.Student;

public class AnnotationTest {
	
	public static void main(String[] args) {
		
		Student xiaoMing = getBean();
		
		/*try {
			ValidationUtil.validate(xiaoMing);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}*/
		
		
		try {
		    ValidationUtil.validate(xiaoMing);
		} catch(ValidationException e){
		    e.printStackTrace();
		    //返回校验结果给前台
		    //return getErrorResponse(ResponseCodeEnum.ERROR.getValue(), e.getMessage());
		}catch (Exception e) {
		    e.printStackTrace();
		    throw new RuntimeException();
		}
		
		/*validate.forEach(row ->{
			System.out.println(row.toString());
		});*/
		//System.out.println(AnnotationDetail.validate(student));
	}
	
	/*private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	
	public static <T> List<String> validate(T t) {
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);
		
		List<String> messageList = new ArrayList<>();
		
		for (ConstraintViolation<T> constraintViolation : constraintViolations){
			messageList.add(constraintViolation.getMessage());
		}
		
		return messageList;
		
	}*/

	private static Student getBean() {
		Student student = new Student();
		student.setName("");
		student.setMail("12");
		return student;
	}

}
