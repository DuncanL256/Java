public class Bug {
    double bugs = 0;

    public double setBugPop(int bugsInput){
        bugs = bugsInput;
        return bugs;
    }

    public double breedBugs(){
        bugs = bugs*2;
        return bugs;
    }

    public double sprayBugs(){
        bugs = bugs*0.75;
        Math.round(bugs);
        return bugs;
    }


    public double returnBugs(){
        return bugs;
    }
    
}
