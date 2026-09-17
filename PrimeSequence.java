public class PrimeSequence {
    public int next(){       // brute force aproach because writing an algorythm feels needlessly complicated
        int starterNum = 1;
        
        for(int i=1; i<100; i++){
            if(starterNum % 2 == 0){
                System.out.println("not prime");
            } else if(starterNum % 3 == 0){
                System.out.println("not prime");
            } else if(starterNum % 4 == 0){
                System.out.println("not prime");
            } else if(starterNum % 5 == 0){
                System.out.println("not prime");
            } else if(starterNum % 6 == 0){
                System.out.println("not prime");
            } else if(starterNum % 7 == 0){
                System.out.println("not prime");
            } else if(starterNum % 8 == 0){
                System.out.println("not prime");
            } else if(starterNum % 9 == 0){
                System.out.println("not prime");
            } else if(starterNum % 10 == 0){
                System.out.println("not prime");
            } else if(starterNum % 11 == 0){
                System.out.println("not prime");
            } else{
                System.out.println("number is prime");
                
            }

            
        }
        
    
        return starterNum;
        
    }
}
