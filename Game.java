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
    public static int gold(int diff, String team1, String team2) {
        if(diff > 7) {
            diff = 7;
        }
        int bound = 50 + diff * 7;
        int factor = bound - Rand(1,100);
        int lead = factor * 50;
        if(lead < 0) {
            lead = lead * -1;
            System.out.println(lead + " gold lead for " + team2);
            lead = lead * -1;
        }
        else if(lead > 0) {
            System.out.println(lead + " gold lead for " + team1);
        }
        else if(lead == 0) {
            System.out.println("Even Gold Lead");
        }
        System.out.println("");
        return lead;
    }
    public static void objective() {
    }
    public static void win() {
    }
}
