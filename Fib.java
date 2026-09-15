public class Fib {
    int number = 0;

    public int calcFib(int fib){
        int foldnew = 0;
        int fold1 = 1;
        int fold2 = 1;

        for (int i = 0; i < number; i++) {
            foldnew = fold1 + fold2;
            fold2 = fold1;
            fold1 = foldnew;

            
        }
        System.out.println(foldnew);
        return foldnew;
    }
}
