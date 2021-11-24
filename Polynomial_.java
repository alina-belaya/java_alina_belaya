package homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Polynomial_ {
    private final ComplexNum[] coeff;
    private final int deg;

    public Polynomial_(int n){
        deg = n;
        coeff = new ComplexNum[deg + 1];
        for(int i = 0; i < deg+1; i++)
            coeff[i] = new ComplexNum();
    }

    public Polynomial_(ComplexNum ...z){
        deg = z.length;
        coeff = new ComplexNum[deg];
        System.arraycopy(z, 0, coeff, 0, deg);
    }

    public void setCoeff(int index, ComplexNum x){
        coeff[index] = x;
    }

    public ComplexNum getCoeff(int index){
        return coeff[index];
    }

    public int getDeg(){
        return deg;
    }

    @Override
    public String toString() {
        List<String> res = new ArrayList<String>();
        for(int p=deg-1; p>=0; p--) if(!Objects.equals(coeff[p], new ComplexNum())) res.add((res.isEmpty()?"":'+')+String.valueOf(coeff[p])+(p==0?"":p==1?'x':"x^"+ p));
        return String.join("",res);
    }
}
