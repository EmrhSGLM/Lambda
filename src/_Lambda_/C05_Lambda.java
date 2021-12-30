package _Lambda_;

import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class C05_Lambda {

    public static void main(String[] args) {
        System.out.println("Task 01 -> " + topla(10));
        System.out.println("Task 011 -> " + topla1(10));
        System.out.println("Task 012 -> " + topla1(10));
        System.out.println(" *************************************** ");
        System.out.println("Task 02-> " + ciftSayiTopla(10));
        System.out.println("Task 021 -> " + ciftSayiTopla1(10));
        System.out.println(" *************************************** ");
        System.out.println("Task 03 -> " + ilkXCiftSayiTopla(10));
        System.out.println(" *************************************** ");
        System.out.println("Task 04 -> " + ilkXTekSayiTopla(10));
        System.out.println(" *************************************** ");
        ikininIlkXKuvveti(4);
        System.out.println(" *************************************** ");
        istenenSayiIlkXKuvveti(4);
        System.out.println(" *************************************** ");
        System.out.println(istenilenSayiFaktoriyel());
        System.out.println(" *************************************** ");
        System.out.println("Task 08 -> " + istenenSayininXinciKuvveti(2,4));

    }


    //  TASK 01 --> Structured Programming ve Functional Programming ile 1'den
    // x'e kadar tamsayilari toplayan bir program yaziniz.

    public static int topla(int x) {
        int toplam = 0;
        for(int i = 0; i <= x; i++) {
            toplam += i;
        }
        return toplam;
    }
    //Fuctional Programming
    public static int topla1(int x) {
        // IntStream. -> int variable'lari akisa aliyor
        return IntStream.range(1,x+1). // 1 2 3 ... x elemanlarinin akisi -- Baslangic dahil Son dahil degil
                sum();
    }
    public static int topla2(int x) {
        // IntStream. -> int variable'lari akisa aliyor
        return IntStream.rangeClosed(1,x). // 1 2 3 ... x elemanlarinin akisi -- Baslangic ve son eleman dahil
                sum();
    }


    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program yaziniz
    public static int ciftSayiTopla(int x) {
        return IntStream.
                range(1,x). // 1 2 3 4 ... eleman akisi
                // filter(C01_giris::ciftBul).
                filter(t->t%2==0). // 2 4 6 .... eleman akisi
                sum();
    }
    public static int ciftSayiTopla1(int x) {
        return IntStream.
                iterate(2,t-> t+2). // 2 4 6 ... x elemanlarinin
                limit(x/2-1). // 2 den baslayip 10 adet cift sayiyi alir
                sum();
    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program yaziniz
    public static int ilkXCiftSayiTopla(int x) {
        return IntStream.
                iterate(2,t->t+2).
                limit(x). // akisdaki ilk X elemani verir
                sum();
    }

    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi yaziniz
    public static int ilkXTekSayiTopla(int x) {
        return IntStream.
                iterate(1,t->t+2). // 1 3 5 7 ..... x elemanlarinin akisi
                limit(x). // sonsuz tekrar'a sinir getirir
                  sum(); // akis ta ki ilk x elemani toplar
    }

    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi yaziniz -- > 2 4 8 16 ,, 2 uzeri x e kadar
    public static void ikininIlkXKuvveti(int x) {
        System.out.print("Task 05 -> ");
        IntStream.
                iterate(2,t->t*2).
                limit(x).
                forEach(C01_giris::printEl);
    }

    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi yaziniz
    public static void istenenSayiIlkXKuvveti(int x) {
        Scanner scan=new Scanner (System.in);
        System.out.println("Ilk X Kuvveti icin Bir sayi giriniz ");
        int a=scan.nextInt();
        System.out.print("Task 06 -> ");

        IntStream.
                iterate(a,t->t*a).
                limit(x).
                forEach(C01_giris::printEl);
    }

    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi yaziniz
    public static int istenilenSayiFaktoriyel() {
        Scanner scan=new Scanner (System.in);
        System.out.println("Faktoriyel hesaplamak icin bir sayi giriniz ");
        int a=scan.nextInt();
        System.out.print("Task 07 -> ");

        return IntStream.
                rangeClosed(1,a).
                reduce(1,(t,u) -> t*u);


    }

    //TASK 08 --> Istenilen bir sayinin x. kuvvetini ekrana yazdiran programi yaziniz
    public static int  istenenSayininXinciKuvveti(int a,int x) {

        return IntStream.
                iterate(a,t->t*a).
                limit(x).
                //skip(x-1);//skip den sonra cıkan elemanları toList ile yazdirilmali
                reduce(0,(t,u) -> u);
    }

}
