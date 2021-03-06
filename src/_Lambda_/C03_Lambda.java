package _Lambda_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class C03_Lambda {

    public static void main(String[] args) {

        List<String> names=new ArrayList<>(Arrays.asList("Emrah Saglam","mehmet","emre","nilgun","yildiz",
                                                    "kader","emine","islam","islam","emre"));
        buyukHarfTekrarsizSira(names);
        System.out.println("\n*****************************");
        karakterSayisiTersSirali(names);
        System.out.println("\n*****************************");
        karakterSayisiKucuktenBuyuge(names);
        System.out.println("\n*****************************");
        sonHarfTersSirali(names);
        System.out.println("\n*****************************");
        ciftElKareTekrarsizBuyukKucuk(names);
        System.out.println("\n*****************************");
        karakterSayisi7Kontrol(names);
        System.out.println("\n*****************************");
        wBaslamaKontrol(names);
        System.out.println("\n*****************************");
        xBitmeKontrol(names);
        System.out.println("\n*****************************");
        karakterSayisiEnBuyuk(names);
        karakterSayisiEnBuyuk2(names);
        System.out.println("\n*****************************");
        sonHarfeGoreSiralaIlkElemanHaricSirala(names);


    }

    // List elemanlarini alfabetik buyuk harf ve tekrarsiz yazdiriniz
    public static void buyukHarfTekrarsizSira(List<String> names) {
        System.out.print("\nBuyuk Harf Tekrarsiz Sira ==> ");
        names.
                stream(). // akisa girdi
                //map(t->t.toUpperCase()).// elemanlar buyuk harf uptade edildi
                map(String::toUpperCase). // Method Reference
                sorted().// alfabetik sira yapildi
                distinct().// TEKRARSIZ YAPILDI... COK ONEMLIII
                forEach(t-> System.out.print(t+" "));
        // Buyuk Harf Tekrarsiz Sira ==> EMRE EM??NE KADER MEHMET N??LGUN Y??LD??Z ??SLAM
    }

    //  List elemanlarini karakter sayisini ters sirali tekrarsiz yazdiriniz
    public static void karakterSayisiTersSirali(List<String> names) {
        System.out.print("Karakter Sayisi Ters Sirali ==>  ");
        names.
                stream().
                map(t->t.length()).// String girdi int olarak degistirdik degisimlerde MAP kullanilir
                sorted(Comparator.reverseOrder()). // tersten siraladi Comparator => Karsilastirma class'i
                distinct().// tekrarsiz olarak yapildi
                forEach(t-> System.out.print(t+" "));
    }

    // List elemanlarini character sayisina gore kucukten buyuge dogru yazdiriniz
    public static void karakterSayisiKucuktenBuyuge(List<String> names) {
        System.out.print("Karakter Sayisina Gore Kucukten Buyuge ==> ");
        names.
                stream().
                sorted(Comparator.comparing(t->t.length())).// Karsilastirma class'indan karsilastir
                                              // Eleman karakter sayisina gore ozel siralama
                forEach(t-> System.out.print(t+" "));
    }

    // List elemanlarini son harfine gore ters sirali yazdiriniz
    public static void sonHarfTersSirali(List<String> names) {
        System.out.print("Son Harfe gore Ters Sirali => ");
        names.
                stream().
                sorted(Comparator.comparing(t->t.toString().
                        charAt(t.toString().length()-1)). // elemanin  son index'inin karakterini alir
                        reversed()). // elemanin son index'ine gore ters siralar
                forEach(t-> System.out.print(t+" "));
    }

    //  Cift sayili elemanlarin karelerini tekrarsiz buyukten kucuge dogru yazdiran bir program yaziniz.
    public static void ciftElKareTekrarsizBuyukKucuk(List<String> names){
        System.out.print("Cift Elemanli Karelerini Buyukten Kucuge ==> ");
        names.
                stream(). // akisa girdi
                // filter(t-> t.length()%2==0).
                map(t->t.length()*t.length()). // Karesini aldim
                filter(C01_giris::ciftBul). // cift elemanlari aldim
                sorted(Comparator.reverseOrder()).// buyukten kucuge siraladim
                distinct().//tekrarsiz
                forEach(C01_giris::printEl); // yazdirildi Output ==> 36 16
    }
    // List elemanlarini karakter sayisini 7 ve 7'den az olma durumu kontrol ediniz
    public static void karakterSayisi7Kontrol(List<String> names) {
       //boolean kontrol = names.
       //        stream().
       //        allMatch(t -> t.length() <= 7); // her bir elemani harf sayisini <= 7 ye eslesmasine bakti
       //if(kontrol){
       //    System.out.println("list elemanlari 7 harf den BUYUK degil");
       //}else {
       //    System.out.println("list elemanlari 7 harf den BUYUK ");
       //}
       //System.out.println(kontrol);
        System.out.println(names.stream().allMatch(t -> t.length() <= 7)?"list elemanlari 7 harf den BUYUK degil":"list elemanlari 7 harf den BUYUK ");

        // allMatch() ==> Belirtilen kriter listede t??m elemanlarda bulunuyor ise true d??nd??r??r.
    }

    // List elemanlarinin "W" ile baslamasini kontrol ediniz
    public static void wBaslamaKontrol(List<String> names) {
        System.out.println(names.stream(). noneMatch(t -> t.toUpperCase().startsWith("W"))?"W ile baslayan isim Kim":"W ile baslayan turkce isim olmaz");
    // noneMatch() => Belirtilen kriter listede hi??bir elemanda bulunmuyor ise true d??nd??r??r.
    }

    // List elemanlarinin "X" ile baslamasini kontrol ediniz
    public static void xBitmeKontrol(List<String> names) {
        System.out.println(names.
                stream().
                anyMatch(t -> t.toUpperCase().endsWith("X"))?"W ile baslayan isim Kim":"W ile baslayan turkce isim olmaz");
        // anyMatch() => Belirtilen kriter listede herhangi bir elemanda bulunuyor ise true d??nd??r??r.

        // anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
        // allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
        // noneMatch() --> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

    }

    // Karakter sayisi en buyuk elemani yazdiriniz
    public static void karakterSayisiEnBuyuk(List<String> names) {
        System.out.println(names.
                stream(). // akisa girdi
                sorted(Comparator.comparing(t -> t.toString().length()).// Karakter uzunluguna gore siraladi
                        reversed()). // buyukten kucuge dogru siralama yapti
                findFirst()); // ilk elemani aldi

    }

    public static void karakterSayisiEnBuyuk2(List<String> names) {
        Stream<String> sonIsim = names.
                stream(). // akisa girdi
                        sorted(Comparator.comparing(t -> t.toString().length()).// Karakter uzunluguna gore siraladi
                        reversed()). // buyukten kucuge dogru siralama yapti
                //  findFirst()); // ilk elemani aldi
                        limit(1); // limit(a) ==> akisdan cikan elemanlari a parametresine gore ilk a elemani alir
        System.out.println(Arrays.toString(sonIsim.toArray()));
    }

    // List elemanlarini son harfine gore siralayip ilk eleman haric kalan elemanlari yazdiriniz

    public static void sonHarfeGoreSiralaIlkElemanHaricSirala(List<String> names) {
        names.
                stream().
                sorted(Comparator.comparing(t->t.toString().charAt(t.toString().length()-1))).
                skip(1). // Akisdan cikan elemanlarin 1. parametreyi atlar
                forEach(System.out::println); // forEach(t->System.out.println(t+" "));
    }

}
