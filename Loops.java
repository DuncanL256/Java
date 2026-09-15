public class Loops {
    public int usingWhileLoops(int stop){
        int begin = 1;
        double sum = 0;
        int count = 0;
        
        while (count <= stop) {
            count++;
            sum = sum + begin;
            begin++;

            
        }
        return count;
    }

    public int usingForLoops(int stop){
        int begin = 1;
        double sum = 0;
        int count = 0;
        
        for (int i = 0; i <= stop; i++) {
            sum = sum + begin;
            begin++;
            count++;
            
        }
        return count;
    }

    public int usingDoLoops(int stop){
        int begin = 1;
        double sum = 0;
        int count = 0;
        
        do{    
            count++;
            sum = sum + begin;
            begin++;
        }while (count <= stop);   
        
        return count;
    }

    
}
