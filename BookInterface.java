package CW10;

public class BookInterface{

    public static void main(String[] args) {

        Dictionary d = new Dictionary("Title Dict", "Author D", 100, 50123, 430000, "English");
        Encyclopedia e = new Encyclopedia("Title Encyclop", "Author E", 131, 98001, 100100, "Animals");
        Fiction f = new Fiction("Title Fict", "Author F", 91.5, 500000, 500000, "Fantasy");

        System.out.println(d);
        d.print();
        d.advertise();
        d.popularity();

        System.out.println(e);
        e.print();
        e.advertise();
        e.popularity();

        System.out.println(f);
        f.print();
        f.advertise();
        f.popularity();
    }
}
interface Printable{

    void advertise();
    void print();
    int getCirculation();
    void setCirculation(int n);

}
class Book implements Printable{

    String title;
    String author;
    double price;
    int circulation;
    int sold;


    Book(String title, String author, double price, int sold, int circulation){

        this.title = title;
        this.author = author;
        this.price = price;
        this.sold = sold;
        this.circulation = circulation;
    }

    @Override
    public void advertise() {
        System.out.println("Book is advertised");
    }

    @Override
    public void print() {
        System.out.println("Book is printing");
    }

    @Override
    public int getCirculation() {
        return circulation;
    }

    @Override
    public void setCirculation(int circulation) {
        this.circulation = circulation;
    }

    public void popularity(){
        if (circulation == sold){
            System.out.println("Book is sold out");
        } else if (sold >= circulation/2) {
            System.out.println("Book is popular");
        } else {
            System.out.println("Book failed");
        }
    }
}

class Dictionary extends Book {

    String dictLanguage;

    Dictionary(String title, String author, double price, int sold, int circulation, String dictLanguage) {
        super(title, author, price, sold, circulation);
        this.dictLanguage = dictLanguage;
    }

    @Override
    public String toString() {
        return "\nDictionary: " + this.title + ", language: " + this.dictLanguage + ", published by " + this.author + ". Price = " + this.price;
    }
}

class Encyclopedia extends Book {

    String theme;

    Encyclopedia(String title, String author, double price, int sold, int circulation, String theme) {
        super(title, author, price, sold, circulation);
        this.theme = theme;
    }

    @Override
    public String toString() {
        return "\nEncyclopedia: " + this.title + ", theme: " + this.theme + ", published by " + this.author + ". Price = " + this.price;
    }
}

class Fiction extends Book {

    String genre;

    Fiction(String title, String author, double price, int sold, int circulation, String genre) {
        super(title, author, price, sold, circulation);
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "\nEncyclopedia: " + this.title + ", genre: " + this.genre + ", published by " + this.author + ". Price = " + this.price;
    }
}
