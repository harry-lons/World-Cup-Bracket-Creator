public class Team {
    public String name;
    public int teamIdx;
    public String fullName;
    public static final String[] teams = {"QAT","ECU","NED","SEN","ENG","IRA","USA"
    ,"WAL","ARG","SAU","MEX","POL","FRA","AUS","DEN","TUN","SPA","COS","GER","JAP",
    "BEL","CAN","MOR","CRO","BRA","SER","SWI","CAM","POR","GHA","URU","KOR"};
    public static final String[] teamsFull = {"Qatar","Ecuador","Netherlands","Senegal",
"England","Iran","United States","Wales","Argentina","Saudi Arabia","Mexico","Poland","France",
"Australia","Denmark","Tunisia","Spain","Costa Rica","Germany","Japan","Belgium","Canada","Morocco",
"Croatia","Brazil","Serbia","Switzerland","Cameroon","Portugal","Ghana","Uruguay","Korea"};

    public Team(String abbr){
        this.name = abbr.toUpperCase();
        this.teamIdx=findNum(name);
        this.fullName = teamsFull[teamIdx];
    }
    public Team(Team copy){
        this.name = copy.name;
        this.teamIdx = copy.teamIdx;
        this.fullName = copy.fullName;
    }
    public int findNum(String abbr){
        for(int i = 0; i<32; i++){
            if(abbr.equals(teams[i])){
                return i;
            }
        }
        return -1;
    }
    public String toString(){
        return this.name;
    }
}
