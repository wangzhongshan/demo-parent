package org.demo.wzs.validate;

public class TradeInfo {


    @Validate(type = ValidateTypeKind.Length, name = "商品名称", maxLength = 256, required = true)
    private String subject;

    @Validate(type = ValidateTypeKind.Integer, name = "商品数量", maxLength = 5, required = true)
    private String quantity;

    @Validate(type = ValidateTypeKind.Number, name = "交易金额", maxLength = 12, required = true)
    private String totalAmount;
    
    @Validate(type = ValidateTypeKind.Date, name = "交易时间",maxLength=14, required = true)
    private String tranTime;


	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getTranTime() {
		return tranTime;
	}

	public void setTranTime(String tranTime) {
		this.tranTime = tranTime;
	}
	
	
    
}
