package _Lambda_Practise.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;



public class Q03 {

    //String isimlerden olusan bir list olusturun

    public static void main(String[] args) {
       // List<String> list = new ArrayList<String>(Arrays.asList("Emrah","Kemalettin","Ahmet","Ali","Hikmet",
       //         "Kemalettin","Suleyman","MehmetMeral","Adnan","Osman","Avni"));

        List<String> list = new ArrayList<String>();
        list.add("Lutfullah");
        list.add("Emine");
        list.add("Emine");
        list.add("Yusuf");
        list.add("Seyfullah");
        list.add("Hakan");

        System.out.println(" ========== Task 01 ======== ");
        farkliOgeUzunlukIleYaz(list);
        System.out.println("\n ========== Task 02 ======== ");
        farkliOgeYazdirUzunlukGoreSira(list);
        System.out.println("\n ========== Task 03 ======== ");
        farkliOgeleriYazSonHarfSirala(list);
        System.out.println("\n ========== Task 04 ======== ");
        farkliOgeTersSiraYaz(list);
        System.out.println("\n ========== Task 05 ======== ");
        uzunlukYediKckFarkliOgeTersYaz(list);

    }
    //Task 01 -> Konsoldaki farklı öğeleri uzunluklarıyla birlikte yazdırın.
   public static void farkliOgeUzunlukIleYaz(List<String> list) {
       list.
               stream().
               sorted().
               distinct().
               forEach(t-> System.out.println("Isim -> "+t + ", Uzunluk -> " + t.length()));
   }

    // Task 02 -> Konsoldaki farklı öğeleri yazdırın, uzunluklarına göre sıralayın.
    public static void farkliOgeYazdirUzunlukGoreSira(List<String> list) {
        list.
                stream(). // akisa girdi
                sorted(Comparator.comparing(t->t.length())). // Uzunluklara gore siralandi
                distinct(). // Tekrarlar cikarildi
                forEach(t-> System.out.print(t + " "));
    }

    //Task 03 -> Konsoldaki farklı öğeleri yazdırın, son karakterlerine göre sıralayın.
    public static void farkliOgeleriYazSonHarfSirala(List<String> list) {
        list.
                stream().
                distinct().
                sorted(Comparator.comparing(t-> t.substring(t.length()-1))).
                forEach(t -> System.out.print(t + " "));
    }

    //Task 04 -> Konsoldaki farklı öğeleri ters sırada yazdırın.
    public static void farkliOgeTersSiraYaz(List<String> list) {
        list.
                stream(). // akisa aldi
                distinct(). // tekrarlar cikarildi
                sorted(Comparator.reverseOrder()). // siralamayi ters den yapdi
                forEach(t-> System.out.print(t + " "));
    }
    //Task 05 -> Uzunluğu 7'den küçük olan farklı öğeleri ters sırada konsolda büyük harflerle yazdırın.
    public static void uzunlukYediKckFarkliOgeTersYaz(List<String> list) {
        list.
                stream().
                filter(t-> t.length() < 7). // Uz 7 den kucuk olanlar alindi
                distinct(). // Tekrarlar cikarildi
                sorted(Comparator.reverseOrder()). // Siralama ters yapildi
                forEach(t-> System.out.print(t + " "));
    }

}
