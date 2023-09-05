public enum Color{
     Maroon(0x800000), 
     Indigo(0x4B0082),
     Teal(0x008080),
     Licorice(0x000000);

     private int rgb;

     private Color(int rgb)
     {
        this.rgb = rgb;
     }

     public int getRgb() {
        return rgb;
     }

     @Override 
     public String toString() {
        return name() + " (#" + Integer.toHexString(rgb) + ")";
     }
}