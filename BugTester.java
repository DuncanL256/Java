public class BugTester {
    public static void main(String[] args) {
        Bug population = new Bug();
        double pop = population.setBugPop(10);

        System.out.println("starting pop is: " + pop);
        pop = population.breedBugs();
        System.out.println("After bugs are bred first time, pop is: " + pop);
        pop = population.sprayBugs();
        System.out.println("After bugs are sprayed first time, pop is:"+ pop);

        System.out.println("");

        System.out.println("round 2 starting pop is: " + pop);
        pop = population.breedBugs();
        System.out.println("After bugs are bred second time, pop is: " + pop);
        pop = population.sprayBugs();
        System.out.println("After bugs are sprayed second time, pop is: "+ Math.round(pop));
        
        System.out.println("");

        System.out.println("round 3 starting pop is: " + Math.round(pop));
        pop = population.breedBugs();
        System.out.println("After bugs are bred third time, pop is: " + pop);
        pop = population.sprayBugs();
        System.out.println("After bugs are sprayed third time, pop is: "+ Math.round(pop));
    }

    
}   
