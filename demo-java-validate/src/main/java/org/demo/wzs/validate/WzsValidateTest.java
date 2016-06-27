package org.demo.wzs.validate;

import java.util.List;
import java.util.Map;

public class WzsValidateTest {

	public static void main(String[] args) {
		TradeInfo trade=new TradeInfo();
		trade.setSubject("奥迪A8");
		trade.setQuantity("1");
		trade.setTotalAmount("200万");
		trade.setTranTime("2015-11-20 11:30:30");
		
		Map<String, List<String>> results=ValidateTools.validate(trade);
		
		for(String key :results.keySet()){
			System.out.println(ValidateEnum.getByCode(key).getDesc()+"="+results.get(key));
		}
		
	}
}
