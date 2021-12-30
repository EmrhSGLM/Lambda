package _Lambda_Practise.proje;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Main {

    static List<Ogrenci> ogrListesi = new ArrayList<Ogrenci>();

    public static void main(String[] args) {

       ogrenciListesi();
       System.out.println("*******************");
       notaGoreSirala(60,95);
       System.out.println("*******************");
       yasaGoreSirala();
       System.out.println("*******************");
       yasaVeCinsiyeteGore(30,"kadin");
       System.out.println("*******************");
       ismeGoreSirala("Ahmet");
       System.out.println("*******************");
       soyIsmeGoreSirala("Can");
       System.out.println("*******************");
       System.out.println(ortHesapla());


    }

    private static double ortHesapla() {
        double ortDiplomaNotu = ogrListesi.
                stream().mapToDouble(Ogrenci::getDiplomaNotu).
                average().
                orElse(0); // varsa al yoksa 0 al
        return ortDiplomaNotu;
    }

    //Öğrencileri soyisimlerine göre yazdırin
    private static void soyIsmeGoreSirala(String soyAd) {
       ogrListesi.
                stream().
                filter(t -> t.getSoyAd().equalsIgnoreCase(soyAd)).
               forEach(System.out::println);
    }

    //Öğrencileri isimlerine göre yazdırın
    private static void ismeGoreSirala(String isim) {
        ogrListesi.
                stream().
                filter(t->t.getAd().equalsIgnoreCase(isim)).
                forEach(System.out::println);
    }

    //Öğrencileri belirli bir yaşa ve cinsiyete göre sıralayarak listeleyin
    private static void yasaVeCinsiyeteGore(int yas,String cinsiyet) {
        ogrListesi.stream().
                filter(t->t.getYas() < yas && t.getCinsiyet().equalsIgnoreCase(cinsiyet)).
                forEach(t-> System.out.println(t.toString()));
    }

    //Öğrencileri yaşlarına göre sıralayark yazdırin
    private static void yasaGoreSirala() {
        ogrListesi.
                stream().
                sorted(Comparator.comparing(Ogrenci::getYas).reversed()).
                forEach(t-> System.out.println(t.toString()));
    }
    //Öğrenci notlarını alt ve üst limitlere göre sıralayarak  yazdirin
    private static void notaGoreSirala(double alt, double ust) {
        ogrListesi.
                stream().
                sorted(Comparator.comparing(Ogrenci::getDiplomaNotu)).
                filter(t->t.getDiplomaNotu() > alt && t.getDiplomaNotu() < ust).
                forEach(t-> System.out.println(t + " "));

    }
    //toString methodu ile ogrenci bilgilerin yazdirin
    private static void ogrenciListesi() {
        ogrListesi.add(new Ogrenci("Ahmet","Can",30,95.5,"erkek"));
        ogrListesi.add(new Ogrenci("Ahmet","Yarba",25,90.5,"erkek"));
        ogrListesi.add(new Ogrenci("Ayse","Can",21,82.5,"kadin"));
        ogrListesi.add(new Ogrenci("Merve","Aslan",30,95.8,"kadin"));
        ogrListesi.add(new Ogrenci("Veli","Han",80,35.5,"erkek"));
        ogrListesi.add(new Ogrenci("Funda","Funda",24,99,"kadin"));

}
}