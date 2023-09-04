public class TestLine 
{
    public static void main(String[] args) 
	{
        Line line1 = new Line(9.264, 8.626, 9.070, 3.194, Color.Purple);
        Line line2 = new Line(5.670, 0.307, 4.001, 8.058, Color.Orange);
        Line line3 = new Line(9.360, 6.226, 4.605, 4.110, Color.Maroon);
        Line line4 = new Line(0.752, 9.955, 5.561, 9.962, Color.Pink);

        System.out.println(line1.toString() + " has length " + line1.length());
        System.out.println(line2.toString() + " has length " + line2.length());
        System.out.println(line3.toString() + " has length " + line3.length());
        System.out.println(line4.toString() + " has length " + line4.length());
    }
}
