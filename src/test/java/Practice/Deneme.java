public class Deneme {
    String  isim="John Doe";
    int yas=40;

    public Deneme(){ //John Doe,40-Seher,40
        isim="Seher";
        System.out.println("isim : " + isim);//Seher,Seher
    }
    public Deneme(String isim) { //Esra //Murat
        this();
        this.yas=30; //40-30
        System.out.println("isim : "+isim); //Esra //Murat
    }
    public Deneme(String isim,int yas){ //Fatih,55
        this("Murat");
        this.yas=45;//45
    }

    public static void main(String[] args) {
        Deneme obj1=new Deneme("Esra");
        Deneme obj2=new Deneme("Fatih",55);
    }


}
