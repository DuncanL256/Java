import java.util.Random;

public class die {
    private Random generator;
    private int sides;

    public die(int s){
        sides = s;
        generator = new Random();
    }


    public int cast(){
        return 1 + generator.nextInt(sides);
    }


}
