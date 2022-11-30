import java.util.*;
public class WCBracket{
    static Team[] groupWinners;
    static Team[] Ro16Winners;
    static Team[] qtrWinners;
    static Team[] semiWinners;
    static Team winner;
    private static final String[] GRPs = {"QAT/ECU/NED/SEN","ENG/IRA/USA/WAL","ARG/SAU/MEX/POL",
    "FRA/AUS/DEN/TUN","SPA/COS/GER/JAP","BEL/CAN/MOR/CRO","BRA/SER/SWI/CAM","POR/GHA/URU/KOR"};
    public static void reset(){
        groupWinners = new Team[16];
        Ro16Winners = new Team[8];
        qtrWinners = new Team[4];
        semiWinners = new Team[2];
        winner = null;
    }
    public static boolean groups(){
        Scanner input = new Scanner(System.in);
        for(int i = 0; i <= 7; i++){
            char grp = (char)(i+65);
            System.out.println("Group "+grp+" Winner? " + GRPs[i]);
            String next = input.nextLine().toUpperCase();
            if(next.equals("EXIT")){return false;}
            groupWinners[2*i] = new Team(next);
            System.out.println("Group "+grp+" Runner up? " + GRPs[i]);
            next = input.nextLine().toUpperCase();
            if(next.equals("EXIT")){return false;}
            while(next.equals(groupWinners[i*2].name)){
            System.out.println("Cannot be winning team. Enter again " + GRPs[i]);
            next = input.nextLine().toUpperCase();
            if(next.equals("EXIT")){return false;}
            }
            groupWinners[2*i+1] = new Team(next);
            System.out.println();
        }
        return true;
    }
    public static boolean ro16(){
        Scanner input = new Scanner(System.in);
        Ro16Winners = new Team[8];
        System.out.println("\nRound of 16!\n");
        for(int i = 0; i<13; i+=4){
            System.out.println("Who wins: " + groupWinners[i] + " or " + groupWinners[i+3] +"?");
            
            int j =0;
            while(true){
            String next = input.nextLine().toUpperCase();
            if(next.equals("EXIT")){return false;}
            if(next.equals(groupWinners[i].name)){Ro16Winners[i/4] = groupWinners[i];break;}
            else if(next.equals(groupWinners[i+3].name)){Ro16Winners[i/4] = groupWinners[i+3];break;}
            else{System.out.println("Invalid, try again");j++;if(j==5){break;}}
            }
        }
        for(int i = 2; i<15; i+=4){
            System.out.println("Who wins: " + groupWinners[i] + " or " + groupWinners[i-1] +"?");
            int j =0;
            while(true){
            String next = input.nextLine().toUpperCase();
            if(next.equals("EXIT")){return false;}
            if(next.equals(groupWinners[i].name)){Ro16Winners[(i+14)/4] = groupWinners[i];break;}
            else if(next.equals(groupWinners[i-1].name)){Ro16Winners[(i+14)/4] = groupWinners[i-1];break;}
            else{System.out.println("Invalid, try again");j++;if(j==5){break;}}
            }
        }
        return true;
    }
    public static boolean quarters(){
        Scanner input = new Scanner(System.in);
        qtrWinners = new Team[4];
        System.out.println("\nQuarterfinals!\n");
        for(int i = 0; i<4; i++){
        System.out.println("Who wins: " + Ro16Winners[i*2]+" or "+Ro16Winners[i*2+1]+"?");
        String next = input.nextLine().toUpperCase();
        if(next.equals("EXIT")){return false;}
        while(true){
        if(next.equals(Ro16Winners[i*2].name)){qtrWinners[i]=Ro16Winners[i*2];break;}
        else if(next.equals(Ro16Winners[i*2+1].name)){qtrWinners[i]=Ro16Winners[i*2+1];break;}
        else{System.out.println("Invalid. Try again.");}
        }
        }
        return true;
    }
    public static boolean semis(){
        Scanner input = new Scanner(System.in);
        semiWinners = new Team[2];
        System.out.println("\nSemifinals!\n");
        System.out.println("Who wins: "+qtrWinners[0].fullName+" or "+qtrWinners[1].fullName+"? (Enter either abbreviation or full name)");
        int j = 0;
        while(true){
        String next = input.nextLine().toUpperCase();
        if(next.equals("EXIT")){return false;}
        if(next.equals(qtrWinners[0].name.toUpperCase())||next.equals(qtrWinners[0].fullName.toUpperCase())){
            semiWinners[0] = new Team(qtrWinners[0]);break;
        }
        else if(next.equals(qtrWinners[1].name.toUpperCase())||next.equals(qtrWinners[1].fullName.toUpperCase())){
            semiWinners[0] = new Team(qtrWinners[1]);break;
        }
        else{System.out.println("Invalid, try again!");j++;if(j==5){break;}}
    }
        System.out.println("Who wins: "+qtrWinners[2].fullName+" or "+qtrWinners[3].fullName+"? (Enter either abbreviation or full name");
        j = 0;
        while(true){
        String next = input.nextLine().toUpperCase();
        if(next.equals("EXIT")){return false;}
        if(next.equals(qtrWinners[2].name.toUpperCase())||next.equals(qtrWinners[2].fullName.toUpperCase())){
            semiWinners[1] = new Team(qtrWinners[2]);break;
        }
        else if(next.equals(qtrWinners[3].name.toUpperCase())||next.equals(qtrWinners[3].fullName.toUpperCase())){
            semiWinners[1] = new Team(qtrWinners[3]);break;
        }
        else{System.out.println("Invalid, try again!");j++;if(j==5){break;}}
    }
    return true;
    }
    public static boolean champ(){
        Scanner input = new Scanner(System.in);
        System.out.println("\nAnd Now Time for the final! Who wins? "+semiWinners[0].fullName+" or "+semiWinners[1].fullName+"?");
        String next = input.nextLine();
        if(next.equals("EXIT")){return false;}
        int j = 0;
        while(j<5){
        if(next.toUpperCase().equals(semiWinners[0].name) || next.toUpperCase().equals(semiWinners[0].fullName.toUpperCase())){
            winner = new Team(semiWinners[0]);break;
        }
        else if(next.toUpperCase().equals(semiWinners[1].name) || next.toUpperCase().equals(semiWinners[1].fullName.toUpperCase())){
            winner = new Team(semiWinners[1]);break;
        }
        else{
            System.out.println("Invalid, try again");j++;
        }
    }
    System.out.println(winner.fullName + " is the winner.");
    return true;
    }
    public static void draw(){
        System.out.println("\n\nHere is a drawing of your bracket:\n");
        System.out.println(groupWinners[0]+"-|");
        System.out.println(groupWinners[3]+"-|--"+Ro16Winners[0]);
        System.out.println("        |---"+qtrWinners[0]);
        System.out.println(groupWinners[4]+"-|--"+Ro16Winners[1]+"   |");
        System.out.println(groupWinners[7]+"-|        |");
        System.out.println("             |-----"+semiWinners[0]);
        System.out.println(groupWinners[8]+"-|        |      |");
        System.out.println(groupWinners[11]+"-|--"+Ro16Winners[2]+"   |      |");
        System.out.println("        |---"+qtrWinners[1]+"     |");
        System.out.println(groupWinners[12]+"-|--"+Ro16Winners[3]+"          |");
        System.out.println(groupWinners[15]+"-|               |");
        System.out.println("                    -----"+winner.fullName);
        System.out.println(groupWinners[2]+"-|               |");
        System.out.println(groupWinners[1]+"-|--"+Ro16Winners[4]+"          |");
        System.out.println("        |---"+qtrWinners[2]+"     |");
        System.out.println(groupWinners[6]+"-|--"+Ro16Winners[5]+"   |      |");
        System.out.println(groupWinners[5]+"-|        |      |");
        System.out.println("             |-----"+semiWinners[1]);
        System.out.println(groupWinners[10]+"-|        |");
        System.out.println(groupWinners[9]+"-|--"+Ro16Winners[6]+"   |");
        System.out.println("        |---"+qtrWinners[3]);
        System.out.println(groupWinners[14]+"-|--"+Ro16Winners[7]);
        System.out.println(groupWinners[13]+"-|");

    }
    public static void main(String[] args){
        if(args.length == 0){
        Scanner input = new Scanner(System.in);
        System.out.print("\n\nWelcome to the 2022 World Cup prediction game! You can type exit at any point to leave mid-bracket. Press enter to play.");
        if(input.nextLine().toUpperCase().equals("EXIT")){return;}
        boolean end = false;
        while(!end){
        System.out.println("\n\nWhat to do? (NEW/END)");
        String entry = input.nextLine().toUpperCase();
        if(entry.equals("END")){
            break;
        }
        if(entry.equals("NEW")){
            reset();
            if(groups()){
                if(ro16()){
                    if(quarters()){
                        if(semis()){
                            if(champ()){
                                System.out.println();
                                draw();
                            }
                        }
                    }
                }
            }
            
        }
        
        }
    }
    else if(args !=null && args[0].equals("draw")){
        reset();
        
        groupWinners = new Team[]{new Team("NED"), new Team("ECU"), new Team("ENG"), new Team("IRA"), new Team("ARG"), new Team("MEX"), new Team("FRA"), new Team("DEN"), new Team("SPA"), new Team("GER"), new Team("CRO"),new Team("BEL"),new Team("BRA"),new Team("SWI"),new Team("POR"), new Team("URU")};
        Ro16Winners = new Team[]{new Team("IRA"), new Team("ARG"), new Team("SPA"), new Team("BRA"),new Team("ENG"),new Team("FRA"), new Team("CRO"), new Team("POR")};
        qtrWinners = new Team[]{new Team("ARG"), new Team("BRA"), new Team("ENG"), new Team("POR")};
        semiWinners = new Team[]{new Team("BRA"), new Team("ENG")};
        winner = semiWinners[1];
        draw();
    }
    }
}