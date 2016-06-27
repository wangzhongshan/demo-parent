package pers.wzsframework.demo.javase.Enum;

public enum AnimalsEnum2 implements BehaviourInterface{
	
	DOG("dog","汪汪"),
	CAT("cat","瞄"),
	TIGER("tiger","吼"),
	SNAKE("snake","滋滋"),
	Monkey("monkey","嘻嘻");
	
	private String name;
	private String voice;
	
	private AnimalsEnum2(String name ,String voice) {
		this.name=name;
		this.voice=voice;
	}
	
	public String getName() {
		return name;
	}
	
	public String getVoice() {
		return voice;
	}

	@Override
	public void voice() {
		System.out.println(this.voice);
	}

	@Override
	public String getMyName() {
		return name;
	}
	
}

