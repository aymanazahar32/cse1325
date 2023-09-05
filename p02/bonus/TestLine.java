public class TestLine {

    public static void main(String[] args){
        Line lineInd = new Line(Color.Indigo, 6.5, 23.5, 1.0, 5.6);
        Line lineTeal= new Line(Color.Teal, 2.5, 5.1, 6.6, 8.6);
        Line lineMar = new Line(Color.Maroon, 0.5, 3.5, 1.8, 2.6);
        Line lineLic = new Line(Color.Licorice, 3.2, 5.4, 11, 19.1);
        
        System.out.println(lineInd);
        System.out.println(lineTeal);
        System.out.println(lineMar);
        System.out.println(lineLic);
    }
}
