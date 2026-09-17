/**
   A class to simulate a combination lock.
*/

public class ComboLock{
   
//********* you will need to create appropriate instance variables here
   private int currentNumber = 0; //current value lock dial is set to
   //more variables here ....
   /**
      Initializes the combination of the lock.
      
   */
   //**** COMPLETE THIS CONSTRUCTOR - input should be 3 number combination
   //**** You may need to set other instance variables other than the 
   //**** arguments here
   //You should verify that the secret number are in the range 0-39 (inclusive)
   //if the values given are not in that range, clamp them.
   //i.e. the call new ComboLock(0, -20, 45) would create a combination of
   // 0, 0, 39  (the -20 gets clamped to 0 because it was less than 0)
   // (the 45 gets clamped to 39 because it was > 39).
   
   // below are instance variables to help code run
   int turnOne;
   int turnTwo;
   int turnThree;
   boolean firstOpen = false;
   boolean secondOpen = false;
   boolean thirdOpen = false;
   
   public ComboLock(int secret1, int secret2, int secret3){
      if(secret1<0){
         secret1 = 0;
      } else if(secret1>39){
         secret1 = 39;
      } else if(secret2<0){
         secret2 = 0;
      } else if(secret2>39){
         secret2 = 39;
      } else if(secret3<0){
         secret3 = 0;
      } else if(secret3>39){
         secret3 = 39;
      } 

      turnOne = secret1;
      turnTwo = secret2;
      turnThree = secret3;

   }
   /**
      Resets the state of the lock so that it can be opened again.
   */
   //********* COMPLETE THIS METHOD
   public void reset(){
      
   }
   /**
      Turns lock left given number of ticks.
      @param ticks number of ticks to turn left
   */
   //*********COMPLETE THIS METHOD
   //you can assume that ticks will be a valid value between 0-40 
   //note that 40 ticks in either direction should return us back to the 
   //number we started on
   public void turnLeft(int ticks){

      if(ticks == turnTwo){
         secondOpen = true;
         System.out.println("secondOpen is: " + secondOpen);
         System.out.println();
      }
   }
   /**
      Turns lock right given number of ticks
      @param ticks number of ticks to turn right
   */
   //*********COMPLETE THIS METHOD
   //you can assume that ticks will be a valid value between 0-40 
   //note that 40 ticks in either direction should return us back to the 
   //number we started on
   public void turnRight(int ticks){
      if(ticks==turnThree && firstOpen==true){
         thirdOpen = true;
         System.out.println("thirdOpen is: " + thirdOpen);
         System.out.println();
      }
      
      if(ticks == turnOne){
         firstOpen = true;
         System.out.println("firstOpen is: " + firstOpen);
         System.out.println();
      }
      
   }
   /**
      Returns true if the lock can be opened now
      @return true if lock is in open state
   */
   //**** COMPLETE THIS METHOD
   public boolean open(){
      if(firstOpen==true && secondOpen==true && thirdOpen==true){
         return true;
      } else{
         return false;
      }

      
   }
   /**
   Returns current value dial is pointing at
   @return value dial is pointing at currently
    */
   public int getCurrentNumber() {
      if(firstOpen==false){
         currentNumber=turnOne;
      } else if(firstOpen==true && secondOpen==false){
         currentNumber=turnTwo;
      } else if(firstOpen==true && secondOpen==true && thirdOpen==false){
         currentNumber=turnThree;
      }

      return currentNumber;
   }
}
