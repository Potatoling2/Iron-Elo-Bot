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
        Team JDG = new Team("JD Gaming", "JDG", "LPL", "Aggressive", 10, 10, 7, 8, 8, 7, 8);
        teamlist.put(JDG.id, JDG);
        Team TES = new Team("Top Esports", "TES", "LPL", "Aggressive", 7, 9, 10, 9, 7, 6, 8);
        teamlist.put(TES.id, TES);
        Team EDG = new Team("EDward Gaming", "EDG", "LPL", "Neutral", 8, 8, 8, 10, 9, 8, 9);
        teamlist.put(EDG.id, EDG);
        Team RNG = new Team("Royal Never Give Up", "RNG", "LPL", "Neutral", 8, 8, 10, 9, 9, 8, 8);
        teamlist.put(RNG.id, RNG);
        Team GEN = new Team("Gen.G", "GEN", "LCK", "Passive", 7, 8, 10, 10, 9, 10, 10);
        teamlist.put(GEN.id, GEN);
        Team T1 = new Team("T1", "T1", "LCK", "Neutral", 10, 8, 8, 9, 10, 8, 8);
        teamlist.put(T1.id, T1);
        Team DK = new Team("DWG KIA", "DK", "LCK", "Neutral", 7, 10, 9, 7, 7, 9, 7);
        teamlist.put(DK.id, DK);
        Team DRX = new Team("DRX", "DRX", "LCK", "Aggressive", 6, 7, 6, 7, 8, 7, 7);
        teamlist.put(DRX.id, DRX);
        Team RGE = new Team("Rogue", "RGE", "LEC", "Neutral", 9, 8, 9, 9, 9, 10, 8);
        teamlist.put(RGE.id, RGE);
        Team G2 = new Team("G2 Esports", "G2", "LEC", "Aggressive", 8, 9, 9, 7, 8, 8, 9);
        teamlist.put(G2.id, G2);
        Team FNC = new Team("Fnatic", "FNC", "LEC", "Aggressive", 8, 8, 10, 9, 8, 7, 7);
        teamlist.put(FNC.id, FNC);
        Team MAD = new Team("MAD Lions", "MAD", "LEC", "Neutral", 7, 8, 8, 6, 8, 5, 7);
        teamlist.put(MAD.id, MAD);
        Team C9 = new Team("Cloud9", "C9", "LCS", "Passive", 8, 8, 9, 10, 7, 10, 8);
        teamlist.put(C9.id, C9);
        Team IOO = new Team("100 Thieves", "IOO", "LCS", "Neutral", 10, 9, 8, 7, 8, 8, 7);
        teamlist.put(IOO.id, IOO);
        Team EG = new Team("Evil Geniuses", "EG", "LCS", "Neutral", 9, 10, 8, 4, 8, 6, 7);
        teamlist.put(EG.id, EG);
        Team CFO = new Team("CTBC Flying Oyster", "CFO", "PCS", "Neutral", 10, 8, 9, 7, 8, 8, 7);
        teamlist.put(CFO.id, CFO);
        Team BYG = new Team("Beyond Gaming", "BYG", "PCS", "Neutral", 7, 7, 6, 6, 5, 7, 6);
        teamlist.put(BYG.id, BYG);
        //work here
        Team GAM = new Team("GAM Esports", "GAM", "VCS", "Neutral", 5, 5, 5, 5, 5, 5, 5);
        teamlist.put(GAM.id, GAM);
        Team SGB = new Team("Saigon Buffalo", "SGB", "VCS", "Aggressive", 5, 5, 5, 5, 5, 5, 5);
        teamlist.put(SGB.id, SGB);
        Team DFM = new Team("DetonatioN FocusMe", "DFM", "LJL", "Neutral", 5, 5, 5, 5, 5, 5, 5);
        teamlist.put(DFM.id, DFM);
        Team CHF = new Team("Chiefs Esports Club", "CHF", "LCO", "Neutral", 5, 5, 5, 5, 5, 5, 5);
        teamlist.put(CHF.id, CHF);
        Team IW = new Team("Istanbul Wildcats", "IW", "TCL", "Neutral", 5, 5, 5, 5, 5, 5, 5);
        teamlist.put(IW.id, IW);
        Team ISG = new Team("Isurus", "ISG", "LLA", "Neutral", 5, 5, 5, 5, 5, 5, 5);
        teamlist.put(ISG.id, ISG);
        Team LLL = new Team("LOUD", "LLL", "CBLOL", "Aggressive", 5, 5, 5, 5, 5, 5, 5);
        teamlist.put(LLL.id, LLL);
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
            top = value;
        }
        else if(change.toLowerCase().equals("jungle")) {
            jungle = value;
        }
        else if(change.toLowerCase().equals("mid")) {
            mid = value;
        }
        else if(change.toLowerCase().equals("bot")) {
            bot = value;
        }
        else if(change.toLowerCase().equals("support")) {
            support = value;
        }
        else if(change.toLowerCase().equals("teamfight")) {
            teamfight = value;
        }
        else if(change.toLowerCase().equals("macro")) {
            macro = value;
        }
    }
    public void edit(String id, String change, String value) {
        if(change.toLowerCase().equals("region")) {
            region = value;
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
