public class Calculator {
    public int sum(int a,int b) {
        return a+b;
    }

    public int sum(int ...a) {
        int sum =0;
        for(int temp:  a) {
            sum = sum+temp;
        }
        return sum;
    }

    public int divide(int a, int b) {
        if(b==0){
            throw new IllegalArgumentException("Value of b can't be zero");
        }
        return a/b;
    }

}
