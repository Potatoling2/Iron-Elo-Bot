import java.util.*;
public class Team {
    String name;
    String id;
    String region;
    String style;
    int top;
    int jungle;
    int mid;
    int bot;
    int support;
    int teamfight;
    int macro;
    int regionid;
    int styleid;
    int elo;
    static String[] regions = {"LCK", "LPL", "LEC", "LCS", "VCS", "PCS", "LJL", "CBLOL", "LCL", "LLA", "TCL", "LCO"};
    static String[] styles = {"NEUTRAL", "PASSIVE", "AGGRESSIVE"};
    static HashMap<String,Team> teamlist = new HashMap<String,Team>();
    public static void initialize() {
        Team C9 = new Team("Cloud9", "C9", "LCS", "Neutral", 5, 5, 5, 5, 5, 5, 5);
        teamlist.put(C9.id, C9);
        Team FLY = new Team("FlyQuest", "FLY", "LCS", "Neutral", 5, 5, 5, 5, 5, 5, 5);
        teamlist.put(FLY.id, FLY);
    }
    public void view() {
        System.out.println("Team: " + name);
        System.out.println("ID: " + id);
        System.out.println("Region: " + region);
        System.out.println("Team Playstyle: " + style);
        System.out.println("Top Lane Rating: " + top);
        System.out.println("Jungle Rating: " + jungle);
        System.out.println("Mid Lane Rating: " + mid);
        System.out.println("Bot Lane Rating: " + bot);
        System.out.println("Support Rating: " + support);
        System.out.println("Teamfight Rating: " + teamfight);
        System.out.println("Macro Rating: " + macro);
        System.out.println("Elo: " + elo);
        System.out.println(regionid);
        System.out.println(styleid);
        System.out.println("");
    }
    Team(String a, String b, String c, String d, int e, int f, int g, int h, int i, int j, int k) {
        name = a;
        id = b;
        region = c;
        style = d;
        top = e;
        jungle = f;
        mid = g;
        bot = h;
        support = i;
        teamfight = j;
        macro = k;
        for(int r = 0; r < 12; r++) {
            if(region.toUpperCase().equals(regions[r])) {
                regionid = r + 1;
            }
        }
        for(int s = 0; s < 3; s++) {
            if(style.toUpperCase().equals(styles[s])) {
                styleid = s;
            }
        }
        elo = 1000;
    }
    public void edit(String id, String change, int value) {
        if(change.toLowerCase().equals("top")) {
            teamlist.get(id).top = value;
        }
        else if(change.toLowerCase().equals("jungle")) {
            teamlist.get(id).jungle = value;
        }
        else if(change.toLowerCase().equals("mid")) {
            teamlist.get(id).mid = value;
        }
        else if(change.toLowerCase().equals("bot")) {
            teamlist.get(id).bot = value;
        }
        else if(change.toLowerCase().equals("support")) {
            teamlist.get(id).support = value;
        }
        else if(change.toLowerCase().equals("teamfight")) {
            teamlist.get(id).teamfight = value;
        }
        else if(change.toLowerCase().equals("macro")) {
            teamlist.get(id).macro = value;
        }
    }
    public void edit(String id, String change, String value) {
        if(change.toLowerCase().equals("region")) {
            teamlist.get(id).region = value;
            for(int r = 0; r < 12; r++) {
                if(region.toUpperCase().equals(regions[r])) {
                    regionid = r + 1;
                }
            }
        }
        else if(change.toLowerCase().equals("style")) {
            teamlist.get(id).style = value;
            for(int s = 0; s < 3; s++) {
                if(style.toUpperCase().equals(styles[s])) {
                    styleid = s;
                }
            }
        }
    }
}
