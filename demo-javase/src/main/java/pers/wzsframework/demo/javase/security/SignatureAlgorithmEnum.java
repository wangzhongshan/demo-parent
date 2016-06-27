/**
 * 
 */
package pers.wzsframework.demo.javase.security;

/**
 * @author Administrator
 *
 */
public enum SignatureAlgorithmEnum {
	MD5withRSA("MD5withRSA"),
	SHA1withRSA("SHA1withRSA");
	
	private String code;
	
	private SignatureAlgorithmEnum(String code) {
		this.code=code;
	}
	
	public String getCode() {
		return code;
	}
}
