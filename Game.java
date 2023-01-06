import java.util.*;
public class Game {
    public static int Rand(int min, int max){
        return (int)(Math.random() * (max - min + 1)) + min;
    }
    public static int solorole(int p1, int p2) {
        return p1 - p2;
    }
    public static int duolane(int b1, int s1, int b2, int s2) {
        return (b1 + s1) - (b2 + s2);
    }
    public static void gold(int diff) {
        if(diff > 7) {
            diff = 7;
        }
        int bound = 50 + diff * 7;
        int factor = bound - Rand(1,100);
        //incomplete
        System.out.println("");
    }
    public static void objective() {
    }
    public static void win() {
    }
}
