package structural.p6_bridge.sample2;

/**
   Concrete implementer class...
 */
public class RedCircle implements DrawAPI {

    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: " + radius +", x: " +x+", "+ y +"]");
    }
}
