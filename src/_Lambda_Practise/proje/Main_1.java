package _Lambda_Practise.proje;

import java.util.*;


public class Main_1 {
    static Scanner scan = new Scanner (System.in);
    static List<Ogrenci_1> list = new ArrayList<Ogrenci_1>();

    public static void main(String[] args) {
        System.out.println("Task 00 -> ad soyad yas diplomaNotu cinsiyet -> Ogrenci Class");
        ogrListeEkle();
        System.out.println("\nTask 01 -> toString methodu ile ogrenci bilgilerin yazdirin");
        ogrListeYazdir();
        System.out.println("\nTask -> 02 Öğrenci notlarını alt ve üst limitlere göre sıralayarak  yazdirin");
        ogrNotlarAltUstSinirYaz(55,90);
        System.out.println("\nTask 03 -> Öğrencileri yaşlarına göre sıralayarak yazdırin");
        OgrYasSira();
        System.out.println("\nTask 04 -> Öğrencileri belirli bir yaşa ve cinsiyete göre sıralayarak listeleyin");
        ogrYasVeCnsytSirala(29,"k");
        System.out.println("\nTask 05 -> Öğrencileri istenilen  isme göre yazdırın");
        ismGoreSirala("eda");
        System.out.println("\nTask 06 -> Öğrencileri istenilen  soyisme göre yazdırin");
        soyadSirala("saglam");
        System.out.println("\nTask 07 -> Öğrencileri belirlenen cinsiyete göre yazdırin");
        cnsytSirala("e");
        System.out.println("\nTask 09 -> reduce metoduyla diplomaNotu ortalama hesaplayin");
        diplomaNotOrt();
        diplomaNotOrt1();




    }
    // Task 09 -> reduce metoduyla diplomaNotu ortalama hesaplayin
    private static void diplomaNotOrt() {
        Double toplam = list.
                stream().
                map(t -> t.getDiplomaNotu()).
                reduce(Double::sum).orElse(0.0);
        System.out.println(toplam / list.size());
    }

    private static void diplomaNotOrt1() {

        System.out.println(list.
                stream().
                mapToDouble(Ogrenci_1::getDiplomaNotu).
                average());
    }


    // Task 08 -> listeyi yazdırırken içinde veri var mı diye kontrol edin
    private static void emptyKontrol(List<String> list1) {
        if(list1.isEmpty()){
            System.out.println("Yazdirmak istediginiz liste bos");
        }else {
            System.out.println(list1);
        }
    }


    // Task 07 -> Öğrencileri cinsiyetlerine göre yazdıran
    private static void cnsytSirala(String cnsyt) {
        list.
                stream().
                filter(t-> t.getCinsiyet().equalsIgnoreCase(cnsyt)).
                forEach(System.out::println);
    }

    // Task 06 -> Öğrencileri soyisimlerine göre yazdırin
    private static void soyadSirala(String soyAd) {
        list.
                stream().
                filter(t-> t.getSoyAd().equalsIgnoreCase(soyAd)).
                forEach(System.out::println);
    }


    //Task 05 -> Öğrencileri isimlerine göre yazdırın
    private static void ismGoreSirala(String ad) {
        list.
                stream().
                filter(t-> t.getAd().equalsIgnoreCase(ad)).
                forEach(System.out::println);
    }

    // Task 04 -> Öğrencileri belirli bir yaşa ve cinsiyete göre sıralayarak listeleyin
    private static void ogrYasVeCnsytSirala(int yas, String cnsyt) {
        list.
                stream().
                filter(t-> t.getYas() == yas && t.getCinsiyet().equalsIgnoreCase(cnsyt)).
                forEach(System.out::println);
    }


    // Task 03 -> Öğrencileri yaşlarına göre sıralayarak yazdırin
    private static void OgrYasSira() {
        list.
                stream().
                sorted(Comparator.comparing(Ogrenci_1::getYas)).
                forEach(System.out::println);
    }

    // Task -> 02 Öğrenci notlarını alt ve üst limitlere göre sıralayarak  yazdirin
    private static void ogrNotlarAltUstSinirYaz(double alt,double ust) {
        list.
                stream().
                filter(t-> t.getDiplomaNotu() > alt && t.getDiplomaNotu() < ust).
                sorted(Comparator.comparing(Ogrenci_1::getDiplomaNotu)).
                forEach(System.out::println);

    }




    //Task 01 -> toString methodu ile ogrenci bilgilerin yazdirin
    private static void ogrListeYazdir() {
        list.stream().forEach(t-> System.out.println(t.toString()));
    }
    // Task 00 -> ad soyad yas diplomaNotu cinsiyet -> Ogrenci Class
    private static void ogrListeEkle() {
        list.add(new Ogrenci_1("Emrah","Saglam",34,82.5,"E"));
        list.add(new Ogrenci_1("Mehmet","Saglam",42,92.5,"E"));
        list.add(new Ogrenci_1("Eda","Saglam",29,98,"K"));
        list.add(new Ogrenci_1("Hikmet","Ertem",48,90,"E"));
        list.add(new Ogrenci_1("Isa","Meral",25,70,"E"));
        list.add(new Ogrenci_1("Osman","Kahraman",56,35,"E"));
    }

}
