package model;

public class Dado {

	private int min;
	private int max;
	
	public Dado(int min,int max)
	{
		this.min=min;
		this.max=max;
		
	}
	
	public int getMin() {
		return min;
	}

	
	public int getMax() {
		return max;
	}

	public void setDado(int min,int max) {
		this.min = min;
		this.max = max;
	}
	
	
}
