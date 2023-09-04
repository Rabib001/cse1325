//class
public class Line
{
	private double x1;
	private double y1;
	private double x2;
	private double y2;	
	private Color color;
	


	//constructor
	public Line (double x1, double y1, double x2, double y2, Color color)
	{
		this.x1=x1;
		this.x2=x2;
		this.y1=y1;
		this.y2=y2;
		this.color=color;
	}

	//method1
	public double length()
	{
		return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
	}

	//method2
	public String toString()
	{
		return color + "("+x1+","+y1+")-("+x2+","+y2+")";
	}
}
