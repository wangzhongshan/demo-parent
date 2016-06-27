package pers.wzsframework.demo.javase.Enum;

public class EnumTest {

	public static void main(String[] args) {
		System.out.println(AnimalsEnum.DOG.name());
		
		for(AnimalsEnum a:AnimalsEnum.values()){
			System.out.println(a.name());
		}
		
		System.out.println(AnimalsEnum1.CAT.getVoice());
		
		
	}
}
