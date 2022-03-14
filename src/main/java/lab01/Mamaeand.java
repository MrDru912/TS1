package lab01;

public class Mamaeand {

    public static int factorialRecursive(int n){
        if(n <= 1){
            return 1;
        }
        else{
            return n*factorialRecursive(n-1);
        }
    }

}
