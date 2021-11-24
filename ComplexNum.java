package homework;

public class ComplexNum {
    private int real;
    private int imag;

    public ComplexNum(){
        real = 0;
        imag = 0;
    }

    public ComplexNum(int real, int imag){
        this.real = real;
        this.imag = imag;
    }

    public ComplexNum add(ComplexNum other){
        ComplexNum temp = new ComplexNum();
        temp.real = this.real + other.real;
        temp.imag = this.imag + other.imag;
        return temp;
    }

    @Override
    public String toString() {
        if (imag == 0 && real == 0) return "";
        if (imag == 0) return real + "";
        if (real == 0) return imag + "i";
        if (imag <  0) return "(" + real + " - " + (-imag) + "i)";
        return "(" + real + " + " + imag + "i)";
    }
}
