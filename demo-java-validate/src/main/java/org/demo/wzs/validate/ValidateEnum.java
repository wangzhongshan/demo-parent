package org.demo.wzs.validate;

public enum ValidateEnum {

	REQUIRED_FIELD_NOT_EXIST("REQUIRED_FIELD_NOT_EXIST","必填字段未填"),
	FIELD_LENGTH_EXCEEDS_LIMIT("FIELD_LENGTH_EXCEEDS_LIMIT","字段长度超过限制"),
	FIELD_TYPE_ERROR("FIELD_TYPE_ERROR","字段类型错误");
	
	private String code;
	private String desc;
	
	private ValidateEnum(String code,String desc) {
		this.setCode(code);
		this.setDesc(desc);
	}
	
	public static ValidateEnum getByCode(String code){
		for(ValidateEnum e:ValidateEnum.values()){
			if(e.getCode().equals(code)){
				return e;
			}
		}
		return null;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
	
}
