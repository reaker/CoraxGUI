/**
 * Created by sebastian on 2017-04-05.
 */
public class RównanieKwadratowe {
    private  int a,b,c;

    public RównanieKwadratowe(int a, int b, int c){
        this.a=a;
        this.b=b;
        this.c=c;
    }

    public String solve(){
        String solution;
        double delta;
        delta = (b*b-4*a*c);
        if (delta>0){
            delta=Math.sqrt(delta);
            double x1=(-b-delta)/(2*a);
            double x2=(-b+delta)/(2*a);
            solution= "Rownjanie posdiada dwa pierwiastki "+ x1 +" oraz "+ x2;
        }

        else  if (delta==0){
            delta= Math.sqrt(delta);
            double x0=b/(2*a);
            solution= "Rownanie posiada jeden pierwiastek"+ x0;
        }
        else {
            solution = "Brak pierwiastkow";
        }
        return solution;
    }

    public String toString(){
        return "Rownanie kwadratowe: "+ a + "x^2 + "+ b + "x +";
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
}
