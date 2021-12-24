package _Lambda_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class C02_giris {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(12, -3, 13, 65, 3, 7, 34, -60, 22, 60, 42, 55));
        ciftKare(list);
        System.out.println(" ********** ");
        elamanlariTopla(list);
        System.out.println(" ********** ");
        elamanlariTopla2(list);
        System.out.println(" ********** ");
        ciftCarpimi(list);
        ciftCarpimi2(list);
        System.out.println(" ********** ");
        enKucukEleman(list);
        enKucukEleman2(list);
        enKucukEleman3(list);
        enKucukEleman4(list);

    }

    // List'in cift olan elemanlarin karelerini aliniz ve en buyugunu yazdiriniz

    public static void ciftKare(List<Integer> list) {
        Optional<Integer> maxEl = list.stream().filter(C01_giris::ciftBul).map(t -> t * t).reduce(Integer::max);
        // reduce(Math::max) da kullanilir ancak daha spesifik oldugu icin spesifik oldugu icin hizli calisir
        System.out.println("Cift Sayilarin Karesi ==> " + maxEl);
        // reduce() return edilen eleman null ya da int'dan buyuk olur ihtimali icin Java guvenlik olarak
        // handle ederek Optional class'i gerekli/sart kosuyor

    }

    //  List 'teki tum elemanlari toplamini yazdiriniz
    // Lambda Expression

    public static void elamanlariTopla(List<Integer> list) {
        Optional<Integer> toplam = Optional.of(list.stream().reduce(0, (x, y) -> x + y));
        System.out.println("Eleman sayilarinin toplam  ==> " + toplam);
		/*
		 x degiskeni her zaman ilk degerini atanan degerden alir
		 y her zaman degerini list.stream()'den yani akis'dan alir
		 x ilk degerden sonraki degerlerini islemden alir

		 */
    }

    //  List 'teki tum elemanlari toplamini yazdiriniz
    // Method reference

    public static void elamanlariTopla2(List<Integer> list) {
        Optional<Integer> toplam = list.stream().reduce(Integer::sum);
        Optional<Integer> toplam1 = list.stream().reduce(Math::addExact);
        System.out.println("Eleman sayilarinin toplam 2 ==> " + toplam1);
		/*
		 x degiskeni her zaman ilk degerini atanan degerden alir
		 y her zaman degerini list.stream()'den yani akis'dan alir
		 x ilk degerden sonraki degerlerini islemden alir

		 */
    }

    //  List 'teki cift elemanlarinin carpimin yazdiriniz
    // Method reference
    public static void ciftCarpimi(List<Integer> list) {
        Optional<Integer> carpim = list.stream().filter(C01_giris::ciftBul).reduce(Math::multiplyExact);
        System.out.println("Cift Elemanlarin Carpimi ==> " + carpim);
    }

    //  List 'teki cift elemanlarinin carpimin yazdiriniz
    // Lambda Expression ...

    public static void ciftCarpimi2(List<Integer> list) {
        Optional<Integer> carpim = Optional.of(list.stream().filter(C01_giris::ciftBul).reduce(1, (x, y) -> (x * y)));
        // pozitif deger bulunuz
        Optional<Integer> carpim1 = Optional.of(list.stream().filter(C01_giris::ciftBul).reduce(-1, (x, y) -> (x * y)));
        System.out.println("Cift Elemanlarin Carpimi 2 ==> " + carpim);
        System.out.println("Pozitif deger Cift Elemanlarin Carpimi 3 ==> " + carpim1);
    }

    // List'teki elemanlardan en kucugunu 4 farkli yontemle yazdiriniz
    // 1. Yontem ==> Method Reference --> Math  class 2. Yontem ==> Integer  class
    public static void enKucukEleman(List<Integer> list) {
        Optional<Integer> min1 = list.stream().reduce(Math::min);
        Optional<Integer> min2 = list.stream().reduce(Integer::min);
        System.out.println("En kucuk Eleman 1 ==> " + min1);
        System.out.println("En kucuk Eleman 2 ==> " + min2);
    }

    public static void enKucukEleman2(List<Integer> list) {
        Optional<Integer> min3 = list.stream().reduce(C02_giris::minBul);
        System.out.println("En kucuk Eleman 3 ==> " + min3);
    }

    public static void enKucukEleman3(List<Integer> list) {
        Optional<Integer> min3 = list.stream().sorted().findFirst();
        System.out.println("En kucuk Eleman 4 ==> " + min3);
    }

    // 4. Yontem ==> Lambda Expression
    public static void enKucukEleman4(List<Integer> list) {
        Optional<Integer> min4 = Optional.of(list.stream().reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y));
        Optional<Integer> min5 = list.stream().reduce((x, y) -> x < y ? x : y);
        System.out.println("En kucuk Eleman 5 ==> " + min4);
        System.out.println("En kucuk Eleman 6 ==> " + min5);
    }
    public static int minBul(int x , int y){
        return x<y ? x:y; // ternary
    }


}