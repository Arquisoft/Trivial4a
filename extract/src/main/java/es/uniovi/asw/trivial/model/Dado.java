package es.uniovi.asw.trivial.model;

public class Dado {

	private int min;
	private int max;
	private static Dado instance;
	
	private Dado(int min,int max)
	{
		this.min=min;
		this.max=max;
		
	}

	public static Dado getInstance(int min,int max)
	{
		if(instance==null)
			instance = new Dado(min,max);
		return instance;
	}
	public static Dado getInstance()
	{
		if(instance==null)
			instance = new Dado(1,6);
		return instance;
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
