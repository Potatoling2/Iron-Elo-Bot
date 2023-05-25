/**
 * A program based around League of Legends Esports using my arbitrary stats and biases
 * The goal is to create a tool that has metrics for each individual team and can simulate matches between them
 * Each match will be determined based on a number of stats
 * Ex. lane power (all 5 positions) and teamfighting
 * The differential between these stats will give teams "points" towards how likely it is that they will win
 * The higher the differential between the points, the more likely it is they will win in my random simulator
 * No matches are guaranteed, otherwise all bo5's would be 3-0 and that would be boring
 * With the maximum possible differential between teams, the underdog should still have at least a 5-10% chance to win
 * Matches are always simulated individually, and can be done with or without elo in place
 * Each team should have an elo rating
 * This elo changes over the course of the season and can be turned on or off by the user if they are doing exhibition matches vs real simulations or predictions
 * A modifier for tournaments like a Worlds or MSI elo scaler can be applied to skew teams from major regions to have higher elo than those from minor ones
 * The team metrics can also be adjusted by the user if they want, changing their playstyle or player rankings as they see fit
 *
 * @author Potatoling2
 * @version 1.0
 */
import java.util.*;
import java.lang.Math;
public class Main {
    static Scanner Input = new Scanner(System.in);
    static boolean counter = false;
    static boolean edrag = false;
    static int baron = 0;
    static int elder = 0;
    public static void Stats() {
        counter = false;
        Input.nextLine();
        System.out.println("Which team would you like to view the stats of? Input their ID to view.");
        String team = Input.nextLine();
        System.out.println("");
        for(String a : Team.teamlist.keySet()) {
            if(team.toUpperCase().equals(a)) {
                Team.teamlist.get(a).view();
                counter = true;
            }
        }
        if(!counter) {
            System.out.println("No Team found. Try resetting and adding a database, or adding your own team.");
        }
    }
    public static void AddTeam() {
        Input.nextLine();
        System.out.println("What is the name of the team?");
        String team = Input.nextLine();
        System.out.println("What 2-3 character ID will they have?");
        String id = Input.nextLine();
        System.out.println("What region are they from? (Type 'idk' to view a list of the regions)");
        String region = Input.nextLine();
        if(region.equals("idk")) {
            System.out.println("LCK (Korea), LPL (China), LEC (Europe), LCS (North America)");
            System.out.println("VCS (Vietnam), PCS (Southeast Asia), LJL (Japan), CBLOL (Brazil)");
            System.out.println("LCL (Commonwealth of Independent States), LLA (Latin America), TCL (Turkey), LCO (Oceania)");
            System.out.println("");
            System.out.println("What region are they from?");
            region = Input.nextLine();
        }
        System.out.println("Rate their starting top laner (0-10)");
        int top = Input.nextInt();
        System.out.println("Rate their starting jungler (0-10)");
        int jungle = Input.nextInt();
        System.out.println("Rate their starting mid laner (0-10)");
        int mid = Input.nextInt();
        System.out.println("Rate their starting bot laner (0-10)");
        int bot = Input.nextInt();
        System.out.println("Rate their starting support (0-10)");
        int support = Input.nextInt();
        System.out.println("Rate their teamfighting (0-10)");
        int teamfight = Input.nextInt();
        Team a = new Team(team, id, region, top, jungle, mid, bot, support, teamfight);
        Team.teamlist.put(a.id, a);
        System.out.println("Team added.");
        System.out.println("");
    }
    public static void EditStats() {
        Input.nextLine();
        System.out.println("Which team would you like to change a stat of? (Use the team's id)");
        String id = Input.nextLine();
        System.out.println("Which stat would you like to edit? (numerical or description)");
        char choice = Input.nextLine().charAt(0);
        if(choice == 'n') {
            System.out.println("Which stat would you like to edit?");
            String change = Input.nextLine();
            System.out.println("What would you like to change the value to?");
            int value = Input.nextInt();
            for(String a : Team.teamlist.keySet()) {
                if(id.toUpperCase().equals(a)) {
                    Team.teamlist.get(a).edit(id, change, value);
                }
            }
        }
        else if(choice == 'd') {
            System.out.println("Which stat would you like to edit?");
            String change = Input.nextLine();
            System.out.println("What would you like to change the value to?");
            String value = Input.nextLine();
            for(String a : Team.teamlist.keySet()) {
                if(id.toUpperCase().equals(a)) {
                    Team.teamlist.get(a).edit(id, change, value);
                }
            }
        }
    }
    public static void Match() {
        Input.nextLine();
        System.out.println("Select the first team to match. (Use Team's ID)");
        String team1 = Input.nextLine();
        System.out.println("Select the second team to match. (Use Team's ID)");
        String team2 = Input.nextLine();
        for(String a : Team.teamlist.keySet()) {
            if(team1.toUpperCase().equals(a)) {
                for(String b : Team.teamlist.keySet()) {
                    if(team2.toUpperCase().equals(b)) {
                        System.out.println(Team.teamlist.get(a).name + " VS " + Team.teamlist.get(b).name);
                        System.out.println("");
                        //game time: 00:00
                        System.out.println("Top Lane: ");
                        int topdiff = Game.solorole(Team.teamlist.get(a).top, Team.teamlist.get(b).top);
                        int toplead = Game.gold(topdiff, Team.teamlist.get(a).name, Team.teamlist.get(b).name);
                        System.out.println("Jungle: ");
                        int jgdiff = Game.solorole(Team.teamlist.get(a).jungle, Team.teamlist.get(b).jungle);
                        int jglead = Game.gold(jgdiff, Team.teamlist.get(a).name, Team.teamlist.get(b).name);
                        System.out.println("Mid Lane: ");
                        int middiff = Game.solorole(Team.teamlist.get(a).mid, Team.teamlist.get(b).mid);
                        int midlead = Game.gold(middiff, Team.teamlist.get(a).name, Team.teamlist.get(b).name);
                        System.out.println("Bot Lane: ");
                        int botdiff = Game.duolane(Team.teamlist.get(a).bot, Team.teamlist.get(a).support, Team.teamlist.get(b).bot, Team.teamlist.get(b).support);
                        int botlead = Game.gold(botdiff, Team.teamlist.get(a).name, Team.teamlist.get(b).name);
                        int tfdiff = Game.solorole(Team.teamlist.get(a).teamfight, Team.teamlist.get(b).teamfight);
                        int goldlead = (toplead + jglead + midlead + botlead);
                        //game time 06:00
                        System.out.println("First Dragon: ");
                        int[] objectives = {0,0,0,0,0,0};
                        int objdiff = objectives[0] - objectives[1];
                        int obj = Game.objective(botlead, jgdiff, objdiff, Team.teamlist.get(a).name, Team.teamlist.get(b).name);
                        int objlead = obj;
                        if(obj > 0) {
                            objectives[0]++;
                        }
                        else if(obj < 0) {
                            objectives[1]++;
                        }
                        //game time 08:00
                        System.out.println("First Herald: ");
                        obj = Game.objective(toplead, jgdiff, objlead, Team.teamlist.get(a).name, Team.teamlist.get(b).name);
                        if(obj > 0) {
                            goldlead += 500;
                        }
                        else if(obj < 0) {
                            goldlead -= 500;
                        }
                        //game time 14:00
                        System.out.println("Laning Phase Done!");
                        if(goldlead < 0) {
                            goldlead = goldlead * -1;
                            System.out.println(goldlead + " gold lead for " + team2);
                            goldlead = goldlead * -1;
                        }
                        else if(goldlead > 0) {
                            System.out.println(goldlead + " gold lead for " + team1);
                        }
                        else if(goldlead == 0) {
                            System.out.println("Even Gold Lead");
                        }
                        //game time 15:00
                        System.out.println("Second Dragon: ");
                        obj = Game.objective(botlead, jgdiff, objlead, Team.teamlist.get(a).name, Team.teamlist.get(b).name);
                        if(obj > 0) {
                            objectives[0]++;
                        }
                        else if(obj < 0) {
                            objectives[1]++;
                        }
                        objlead += obj;
                        //game time 16:00
                        System.out.println("Second Herald: ");
                        obj = Game.objective(goldlead, jgdiff, tfdiff, objlead, Team.teamlist.get(a).name, Team.teamlist.get(b).name);
                        if(obj > 0) {
                            goldlead += 700;
                        }
                        else if(obj < 0) {
                            goldlead -= 700;
                        }
                        //game time 20:00
                        System.out.println("Third Dragon: ");
                        obj = Game.objective(goldlead, jgdiff, tfdiff, objlead, Team.teamlist.get(a).name, Team.teamlist.get(b).name);
                        if(obj > 0) {
                            objectives[0]++;
                        }
                        else if(obj < 0) {
                            objectives[1]++;
                        }
                        objlead += obj;
                        //endcheck 1
                        int outcome = Game.win(goldlead, objlead, Team.teamlist.get(a).name, Team.teamlist.get(b).name);
                        if(outcome > 0) {
                            System.out.println(Team.teamlist.get(a).name + " won the game!");
                            break;
                        }
                        else if(outcome < 0) {
                            System.out.println(Team.teamlist.get(b).name + " won the game!");
                            break;
                        }
                        else {
                            continue;
                        }
                        //game time 25:00 (dragon 4)
                        System.out.println("Fourth Dragon: ");
                        obj = Game.objective(goldlead, jgdiff, tfdiff, objlead, Team.teamlist.get(a).name, Team.teamlist.get(b).name);
                        if(obj > 0) {
                            objectives[0]++;
                        }
                        else if(obj < 0) {
                            objectives[1]++;
                        }
                        //dragon soul
                        if(dragons[0] == 4 && !edrag) {
                            objlead += 2;
                            edrag = true;
                        }
                        else if(dragons[1] == 4 && !edrag) {
                            objlead -= 2;
                            edrag = true;
                        }
                        objlead += obj;
                        //game time 30:00 (baron 1)
                        System.out.println("Baron: ");
                        obj = Game.objective(goldlead, jgdiff, tfdiff, objlead, Team.teamlist.get(a).name, Team.teamlist.get(b).name);
                        if(obj > 0) {
                            goldlead += 1500;
                            objlead += 2;
                            baron = 1;
                            objectives[2]++;
                        }
                        else if(obj < 0) {
                            goldlead -= 1500;
                            objlead -= 2;
                            baron = -1;
                            objectives[3]++;
                        }
                        //game time 30:00 (dragon 5)
                        if(edrag) {
                            System.out.println("Elder Dragon: ");
                            obj = Game.objective(goldlead, jgdiff, tfdiff, objlead, Team.teamlist.get(a).name, Team.teamlist.get(b).name);
                            if(obj > 0) {
                                objlead += 3;
                                elder = 1;
                                objectives[4]++;
                            }
                            else if(obj < 0) {
                                objlead -= 3;
                                elder = -1;
                                objectives[5]++;
                            }
                        }
                        else {
                            System.out.println("Fifth Dragon: ");
                            obj = Game.objective(goldlead, jgdiff, tfdiff, objlead, Team.teamlist.get(a).name, Team.teamlist.get(b).name);
                            if(obj > 0) {
                                objectives[0]++;
                            }
                            else if(obj < 0) {
                                objectives[1]++;
                            }
                            //dragon soul
                            if(dragons[0] == 4 && !edrag) {
                                objlead += 2;
                                edrag = true;
                            }
                            else if(dragons[1] == 4 && !edrag) {
                                objlead -= 2;
                                edrag = true;
                            }
                            objlead += obj;
                        }
                        //end check 2
                        int outcome = Game.win(goldlead, objlead, Team.teamlist.get(a).name, Team.teamlist.get(b).name);
                        if(outcome > 0) {
                            System.out.println(Team.teamlist.get(a).name + " won the game!");
                            break;
                        }
                        else if(outcome < 0) {
                            System.out.println(Team.teamlist.get(b).name + " won the game!");
                            break;
                        }
                        else {
                            if(baron == 1) {
                                objlead -= 2;
                            }
                            else if(baron == -1) {
                                objlead += 2;
                            }
                            baron = 0;
                            if(elder == 1) {
                                objlead -= 3;
                            }
                            else if(elder == -1) {
                                objlead += 3;
                            }
                            elder = 0;
                            continue;
                        }
                        //game time 35:00 (dragon 6)
                        if(edrag) {
                            System.out.println("Elder Dragon: ");
                            obj = Game.objective(goldlead, jgdiff, tfdiff, objlead, Team.teamlist.get(a).name, Team.teamlist.get(b).name);
                            if(obj > 0) {
                                objlead += 3;
                                elder = 1;
                                objectives[4]++;
                            }
                            else if(obj < 0) {
                                objlead -= 3;
                                elder = -1;
                                objectives[5]++;
                            }
                        }
                        else {
                            System.out.println("Sixth Dragon: ");
                            obj = Game.objective(goldlead, jgdiff, tfdiff, objlead, Team.teamlist.get(a).name, Team.teamlist.get(b).name);
                            if(obj > 0) {
                                objectives[0]++;
                            }
                            else if(obj < 0) {
                                objectives[1]++;
                            }
                            //dragon soul
                            if(dragons[0] == 4 && !edrag) {
                                objlead += 2;
                                edrag = true;
                            }
                            else if(dragons[1] == 4 && !edrag) {
                                objlead -= 2;
                                edrag = true;
                            }
                            objlead += obj;
                        }                        
                        //game time 40:00 (dragon 7)
                        //end check 3
                        //game time 45:00 (baron 2)
                        //game time 50:00 (dragon 8)
                        //end check 4
                        //game time 55:00 (dragon 9)
                        //game time 60:00 (baron 3)
                        //end check 5 (no chance for game continue)
                    }
                }
            }
        }
    }
    public static void main(String args[]) {
        System.out.println("Welcome to Iron Elo, a League of Legends Esports Simulator.");
        System.out.println("Would you like an explanation of what this bot does? (yes/no)");
        String explain = Input.nextLine();
        if(explain.toLowerCase().contains("y")) {
            System.out.println("This program contains statistics on every worlds contending region's teams, with values and metrics to describe and differentiate them.");
            System.out.println("You can view each's team's stats, add your own custom teams, edit current team stats, and run simulation matches between teams.");
            System.out.println("Each team has their 2-3 letter id stored, a power ranking for their individual players, and teamfight rating.");
            System.out.println("Each team also has an overall 'elo' score that doesn't affect matches but helps to display which teams are doing well and which aren't.");
            System.out.println("Matches adjust elo score accordingly, but do not affect any of the team stats. Those must be edited by users.");
            System.out.println("It is recommended to keep stats the same for tournament simulation, barring drastic changes such as substitutions.");
            System.out.println("Alright, with all of that out of the way, let's proceed.");
            System.out.println("");
        }
        else {
            System.out.println("Ok then, let's proceed.");
            System.out.println("");
        }
        boolean a = false;
        while(!a) {
            System.out.println("What would you like to do today?");
            System.out.println("1. Check team stats");
            System.out.println("2. Add team(s)");
            System.out.println("3. Modify team stats");
            System.out.println("4. Run a match");
            System.out.println("5. Add Databases");
            System.out.println("6. See explanation");
            System.out.println("7. Stats breakdown");
            System.out.println("8. End program");
            System.out.println("");
            int choice = Input.nextInt();
            switch(choice) {
                case 1:
                    Stats();
                    break;
                case 2:
                    AddTeam();
                    break;
                case 3:
                    EditStats();
                    break;
                case 4:
                    Match();
                    break;
                case 5:
                    System.out.println("Would you like to use a premade database of all Worlds 2022 Qualifying teams? (yes/no)");
                    Input.nextLine();
                    String worlds22 = Input.nextLine();
                    if(worlds22.toLowerCase().contains("y")) {
                        Team.initializeWorlds22();
                        System.out.println("Teams added.");
                        System.out.println("");
                    }
                    break;
                case 6:
                    System.out.println("This program contains statistics on every worlds contending region's teams, with values and metrics to describe and differentiate them.");
                    System.out.println("You can view each's team's stats, add your own custom teams, edit current team stats, and run simulation matches between teams.");
                    System.out.println("Each team has their 2-3 letter id stored, a power ranking for their individual players, and teamfight rating.");
                    System.out.println("Each team also has an overall 'elo' score that doesn't affect matches but helps to display which teams are doing well and which aren't.");
                    System.out.println("Matches adjust elo score accordingly, but do not affect any of the team stats. Those must be edited by users.");
                    System.out.println("It is recommended to keep stats the same for tournament simulation, barring drastic changes such as substitutions.");
                    System.out.println("");
                    break;
                case 7:
                    System.out.println("Always remember that stats are region exclusive, meaning there is no bias for being from the LCK or LPL compared to the LJL.");
                    System.out.println("The difference in skill will be accounted for if the international tournament setting is used for matchups.");
                    System.out.println("Laning metrics are out of 10, with 10 representing the best in the region, and 0 representing an extreme liability for their team.");
                    System.out.println("Teamfighting is an arbitrary stat out of 10, with 10 being best in class, and 0 being a massive issue.");
                    System.out.println("");
                    break;
                case 8:
                    System.out.println("Thank you for using Iron Elo.");
                    a = true;
                    break;
            }
        }   
    }
}
