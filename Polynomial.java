package homework;

import java.util.ArrayList;
import java.util.List;

public class Polynomial {
    private final int[] coeff;
    private final int deg;

    public Polynomial(int n){
        deg = n;
        coeff = new int[deg+1];
        for(int i = 0; i < deg+1; i++)
            coeff[i] = 0;
    }

    public Polynomial(int ...a){
        deg = a.length;
        coeff = new int[deg];
        System.arraycopy(a, 0, coeff, 0, deg);
    }

    public void setCoeff(int index, int x){
        coeff[index] = x;
    }

    public int getCoeff(int index){
        return coeff[index];
    }

    public int getDeg(){
        return deg;
    }

    @Override
    public String toString() {
        List<String> res = new ArrayList<>();
        for(int p=deg-1; p>=0; p--) if(coeff[p]!=0)res.add((coeff[p]<0?'-':res.isEmpty()?"":'+')+(Math.abs(coeff[p])==1&&p>0?"":String.valueOf(Math.abs(coeff[p])))+(p==0?"":p==1?'x':"x^"+ p));
        return String.join("",res);
    }
}
