package homework;

class HW10 extends Exception {
    public String message;

    public HW10() {}

    public HW10(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Exception [" + this.message + "]";
    }

}
