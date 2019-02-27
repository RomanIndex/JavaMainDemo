package com.xidian;

public enum CreateTypeEnum {
	averege(1, "均匀生成", "Math.random()"),
	gauss(2, "正太高斯生成", "rand.nextGaussian()"),
    enhanceGuass(3, "正太强化高斯生成", "Math.abs(rand.nextGaussian())");
    
	private int type;
    private String name;
    private String function;
    
	private CreateTypeEnum(int type, String name, String function) {
		this.type = type;
		this.name = name;
		this.function = function;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}
    
    

}
