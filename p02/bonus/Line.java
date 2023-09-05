public class Line {
    private Color color; 
    private double x1,x2,y1,y2;


    public Line(Color color, double x1, double x2, double y1, double y2)
    {
        this.color = color;
        this.x1 = x1; 
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;

    }

    public double length()
    {
        return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
    }

    @Override
    public String toString() {

        return color + " (" + x1 + "," + y1 + ") - (" + x2 + "," + y2 + ") has length " + length();
    }
}