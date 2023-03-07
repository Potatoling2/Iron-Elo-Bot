import java.util.*;
public class Team {
    String name;
    String id;
    String region;
    int top;
    int jungle;
    int mid;
    int bot;
    int support;
    int teamfight;
    int regionid;
    int elo;
    static String[] regions = {"LCK", "LPL", "LEC", "LCS", "VCS", "PCS", "LJL", "CBLOL", "LCL", "LLA", "TCL", "LCO"};
    static HashMap<String,Team> teamlist = new HashMap<String,Team>();
    public static void initializeWorlds22() {
        Team JDG = new Team("JD Gaming", "JDG", "LPL", 10, 10, 7, 8, 8, 7);
        teamlist.put(JDG.id, JDG);
        Team TES = new Team("Top Esports", "TES", "LPL", 7, 9, 10, 9, 7, 6);
        teamlist.put(TES.id, TES);
        Team EDG = new Team("EDward Gaming", "EDG", "LPL", 8, 8, 8, 10, 9, 8);
        teamlist.put(EDG.id, EDG);
        Team RNG = new Team("Royal Never Give Up", "RNG", "LPL", 8, 8, 10, 9, 9, 8);
        teamlist.put(RNG.id, RNG);
        Team GEN = new Team("Gen.G", "GEN", "LCK", 7, 8, 10, 10, 9, 10);
        teamlist.put(GEN.id, GEN);
        Team T1 = new Team("T1", "T1", "LCK", 10, 8, 8, 9, 10, 8);
        teamlist.put(T1.id, T1);
        Team DK = new Team("DWG KIA", "DK", "LCK", 7, 10, 9, 7, 7, 9);
        teamlist.put(DK.id, DK);
        Team DRX = new Team("DRX", "DRX", "LCK", 6, 7, 6, 7, 8, 7);
        teamlist.put(DRX.id, DRX);
        Team RGE = new Team("Rogue", "RGE", "LEC", 9, 8, 9, 9, 9, 10);
        teamlist.put(RGE.id, RGE);
        Team G2 = new Team("G2 Esports", "G2", "LEC", 8, 9, 9, 7, 8, 8);
        teamlist.put(G2.id, G2);
        Team FNC = new Team("Fnatic", "FNC", "LEC", 8, 8, 10, 9, 8, 7);
        teamlist.put(FNC.id, FNC);
        Team MAD = new Team("MAD Lions", "MAD", "LEC", 7, 8, 8, 6, 8, 5);
        teamlist.put(MAD.id, MAD);
        Team C9 = new Team("Cloud9", "C9", "LCS", 8, 8, 9, 10, 7, 10);
        teamlist.put(C9.id, C9);
        Team IOO = new Team("100 Thieves", "IOO", "LCS", 10, 9, 8, 7, 8, 8);
        teamlist.put(IOO.id, IOO);
        Team EG = new Team("Evil Geniuses", "EG", "LCS", 9, 10, 8, 4, 8, 6);
        teamlist.put(EG.id, EG);
        Team CFO = new Team("CTBC Flying Oyster", "CFO", "PCS", 10, 8, 9, 7, 8, 8);
        teamlist.put(CFO.id, CFO);
        Team BYG = new Team("Beyond Gaming", "BYG", "PCS", 7, 7, 6, 6, 5, 7);
        teamlist.put(BYG.id, BYG);
        Team GAM = new Team("GAM Esports", "GAM", "VCS", 8, 9, 7, 9, 9, 9);
        teamlist.put(GAM.id, GAM);
        Team SGB = new Team("Saigon Buffalo", "SGB", "VCS", 9, 7, 6, 10, 7, 7);
        teamlist.put(SGB.id, SGB);
        Team DFM = new Team("DetonatioN FocusMe", "DFM", "LJL", 10, 9, 10, 8, 9, 9);
        teamlist.put(DFM.id, DFM);
        Team CHF = new Team("Chiefs Esports Club", "CHF", "LCO", 8, 9, 9, 10, 10, 9);
        teamlist.put(CHF.id, CHF);
        Team IW = new Team("Istanbul Wildcats", "IW", "TCL", 7, 7, 10, 10, 9, 8);
        teamlist.put(IW.id, IW);
        Team ISG = new Team("Isurus", "ISG", "LLA", 8, 9, 7, 6, 8, 7);
        teamlist.put(ISG.id, ISG);
        Team LLL = new Team("LOUD", "LLL", "CBLOL", 9, 7, 9, 9, 9, 10);
        teamlist.put(LLL.id, LLL);
    }
    public void view() {
        System.out.println("Team: " + name);
        System.out.println("ID: " + id);
        System.out.println("Region: " + region);
        System.out.println("Top Lane Rating: " + top);
        System.out.println("Jungle Rating: " + jungle);
        System.out.println("Mid Lane Rating: " + mid);
        System.out.println("Bot Lane Rating: " + bot);
        System.out.println("Support Rating: " + support);
        System.out.println("Teamfight Rating: " + teamfight);
        System.out.println("Elo: " + elo);
        System.out.println("");
    }
    Team(String a, String b, String c, int d, int e, int f, int g, int h, int i) {
        name = a;
        id = b;
        region = c;
        top = d;
        jungle = e;
        mid = f;
        bot = g;
        support = h;
        teamfight = i;
        for(int r = 0; r < 12; r++) {
            if(region.toUpperCase().equals(regions[r])) {
                regionid = r + 1;
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
    }
}
