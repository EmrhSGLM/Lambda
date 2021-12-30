package _Lambda_Practise.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q02 {

//        2) Bir class oluşturun, 'Q02' olarak adlandırın
//        3) 5 elemanlı bir tamsayı listesi oluşturun
//        4) Elemanlari doğal sıraya koyun
//        5)Konsoldaki son 3 elemanın karelerinin toplamını bulun.
//        6) Konsoldaki toplamı yazdırın
//        7) 'Fonksiyonel Programlama' kullanın
public static void main(String[] args) {
    //List<Integer> list = new ArrayList<>(Arrays.asList(10,4,3,2,1));
    List<Integer> list=new ArrayList<>();
    list.add(5);
    list.add(7);
    list.add(1);
    list.add(4);
    list.add(3);
    siralaSonUcElKareToplami(list);
}

public static void siralaSonUcElKareToplami(List<Integer> list) {
    System.out.println(list.
            stream().
            sorted().
            skip(2).
            map(t -> t * t).
            reduce(Integer::sum));
}
}
