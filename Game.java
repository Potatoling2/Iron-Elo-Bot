import java.util.*;
public class Game {
    public static int Rand(int min, int max) {
        return (int)(Math.random() * (max - min + 1)) + min;
    }
    public static int glead(int diff) {
        int bound = 50 + diff * 7;
        int factor = bound - Rand(1,100);
        int lead = factor * 50;
        return lead;
    }
    public static int pcheck(int diff) {
        int team = 0;
        if(diff > 7) {
            diff = 7;
        }
        int bound = 50 + diff * 7;
        int check = bound - Rand(1,100);
        if(check > 0) {
            team = 1;
        }
        else if(check < 0) {
            team = -1;
        }
        else if(check == 0) {
            int tiecheck = Rand(1,100);
            if(check > 50) {
                team = 1;
            }
            else if(check < 50) {
                team = -1;
            }
        }
        return team;
    }
    public static int solorole(int p1, int p2) {
        return p1 - p2;
    }
    public static int duolane(int b1, int s1, int b2, int s2) {
        return (b1 + s1) - (b2 + s2);
    }
    public static int gold(int diff, String team1, String team2) {
        int lead = glead(diff);
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
    public static int objective(int lead, int jgdiff, int objlead, String team1, String team2) {
        int golddiff = lead / 2000;
        int diff = golddiff + jgdiff + objlead;
        int objdiff = pcheck(diff);
        if(objdiff < 0) {
            System.out.println("Objective for " + team2);
        }
        else if(objdiff > 0) {
            System.out.println("Objective for " + team1);
        }
        System.out.println("");
        return objdiff;
    }
    public static int objective(int lead, int jgdiff, int tfdiff, int objlead, String team1, String team2) {
        int golddiff = lead / 2000;
        int diff = golddiff + jgdiff + tfdiff + objlead;
        int objdiff = pcheck(diff);
        if(objdiff < 0) {
            System.out.println("Objective for " + team2);
        }
        else if(objdiff > 0) {
            System.out.println("Objective for " + team1);
        }
        System.out.println("");
        return objdiff;
    }
    public static void win() {
    }
}
