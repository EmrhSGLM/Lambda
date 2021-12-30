package _Lambda_;

import java.util.*;
import java.util.stream.Collectors;

public class C04_Lambda {

    public static void main(String[] args) {
    TechPro trGunduz = new TechPro ("yaz","TR gunduz",97,124);
    TechPro engGunduz=new TechPro("kis","ENG gunduz",95,131);
    TechPro trGece=new TechPro("bahar","TR gece",98,143);
    TechPro engGece=new TechPro("sonbahar","ENG gece",93,151);

        List<TechPro> list=new ArrayList<>(Arrays.asList(trGunduz,engGunduz,trGece,engGece));

    // Bu class'da agirlikli return type calisacagiz

        System.out.println("Task01 -> "+batchOrt92Buyuk(list));
        System.out.println(" ********************** ");
        System.out.println("Task02 -> "+ogrcSayisi110Az(list));
        System.out.println(" ********************** ");
        System.out.println("Task03 -> "+herhangiBirBaharKontrol(list));
        System.out.println(" ********************** ");
        System.out.println("Task04 -> "+ogrcSayiBuyuktenKucuge(list));
        System.out.println(" ********************** ");
        System.out.println("task 05 -> " + batchOrtBuyukKucuk(list));
        System.out.println(" ********************** ");
        System.out.println("task 06 -> " + ogrcSayisiEnAzIkinci(list));
        System.out.println(" ********************** ");
        System.out.println("task 07 -> " + batchOrt95BuyukOgrcSayisiToplam(list));
        System.out.println("task 07 (2. Method) -> " + batchOrt95BuyukOgrcSayisiToplam2(list));
        System.out.println(" ********************** ");
        System.out.println("task 08 -> " + ogrcSayisi130BykBatchOrt(list));
        System.out.println(" ********************** ");
        System.out.println("task 09 -> " +gunduzBatchSayis(list));
        System.out.println(" ********************** ");
        System.out.println("task 10 -> " +OgrcSayisi130BuyukBatchOrtEnByk(list));
        System.out.println("task 10 -> Haluk Hoca -> " +OgrcSayisi130BuyukBatchOrtEnByk1(list));
        System.out.println(" ********************** ");
        System.out.println("task 11 -> " +ogrcSayisi150KckEnKckBatchOrt(list));
        System.out.println("task 11 -> Hlk -> " +ogrcSayisi150KckEnKckBatchOrt1(list));
        System.out.println("task 11 -> Islm -> " + ogrSayisi150danAzEnKckbatchOrt(list));

    }

    // task01 --> batch art'larinin 92 den buyuk oldugunu kontrol eden pr create ediniz
    public static boolean batchOrt92Buyuk(List<TechPro> list) {
        return list.
                stream().
                allMatch(t->t.getBatchOrt()>92);

    }

    // task 02 -->Ogrc sayilarinin hic birinin 110 den az olmadigini kontrol eden pr cretae ediniz

    public static boolean ogrcSayisi110Az(List<TechPro> list) {
        return list.
                stream().
                noneMatch(t->t.getOgrcSayisi() < 110);
    }

    // task 03 -->batch lerin herhangi birinde "bahar" olup olmadigini kontrol eden pr create ediniz
    public static boolean herhangiBirBaharKontrol(List<TechPro> list) {
        return list.
                stream().
                anyMatch(t->t.getBatch().equals("bahar"));
    }

    //task 04-->batch'leri ogr sayilarina gore buyukten kucuge siralayiniz.
    public static List<TechPro> ogrcSayiBuyuktenKucuge(List<TechPro> list) {
       return list.
                stream().
                sorted(Comparator.comparing(TechPro::getOgrcSayisi).reversed()).
                collect(Collectors.toList());// collect() -> akisdaki elemanlari istenen sarta gore toplar
                // Collectors.toList() -> collect'e toplanan elemanlari list'e cevirir
    }

    //task 05-->batch'leri batch ort gore  b->k siralayip ilk3 'unu yazdiriniz.

    public static List<TechPro> batchOrtBuyukKucuk(List<TechPro> list) {
        return list.
                stream().
                //sorted(Comparator.comparingInt(t->t.getBatchOrt())).
                sorted(Comparator.comparing(TechPro::getBatchOrt).reversed()).
                limit(3). // akista ki ilk ucu aldi
                collect(Collectors.toList());
    }

    // task 06 -> ogrc sayisi en az olan 2. batch'i yazdiriniz
    public static List<TechPro> ogrcSayisiEnAzIkinci(List<TechPro> list) {
        return list.
                stream(). // akisa girdi
                sorted(Comparator.comparing(TechPro::getOgrcSayisi)). // kucukten buyuge siraladi
                limit(2). // ilk iki eleman alindi
                skip(1). // ilk elemani atladi
                collect(Collectors.toList()); // ikinci elemani yazdirdi
    }

    // task 07 -> batch ort larini 95'den buyuk olan batch'lerin ogr sayilarinin toplamini yazdiriniz
    public static int batchOrt95BuyukOgrcSayisiToplam(List<TechPro> list) {
       return  list.
               stream().
               filter(t->t.getBatchOrt() > 95). // 95'den buyuk sarti saglandi
               map(t->t.getOgrcSayisi()). // batch ogrc ort 95'den byk olan ogrc sayilarini getirdi
               //reduce(0,Integer::sum); // Method Reference
                reduce(0,(t,u)->(t+u)); // Lambda Expression
    }
    public static int batchOrt95BuyukOgrcSayisiToplam2(List<TechPro> list) {
        return  list.
                stream().
                filter(t->t.getBatchOrt() > 95). // 95'den buyuk sarti saglandi
                        mapToInt(t->t.getOgrcSayisi()).// mapToInt()--> type gore int return ederki sum() calisir
                                                       // reduce gerek kalmaz daha kisa ve hizli code imkani saglar
                        sum();
    }

    // task 08 -> ogrenci sayilari 130'dan buyuk olan batch'lerin batchOrt'larinin Ortalamasini bulunuz
    public static OptionalDouble ogrcSayisi130BykBatchOrt(List<TechPro> list) {
       return  list.
                stream().
                filter(t->t.getOgrcSayisi() > 130).
                mapToDouble(t->t.getBatchOrt()).
                average(); // gelen sayilarin ortalamasini alir

    }

    //task 09-->gunduz batch'lerinin sayisini  yazdiriniz.
    public static long gunduzBatchSayis(List<TechPro> list) {
       return  list.
                stream().
                filter(t -> t.getBatchName().contains("gunduz")).
                count();
    }

    //task 10-->Ogrenci sayilari 130'dan fazla olan batch'lerin en buyuk batch ort'unu bulunuz
    public static Optional<Integer> OgrcSayisi130BuyukBatchOrtEnByk(List<TechPro> list) {
        return list.
                stream().
                filter(t->t.getOgrcSayisi() > 130).
                map(t->t.getBatchOrt()).reduce(Integer::max);
    }
    public static OptionalInt OgrcSayisi130BuyukBatchOrtEnByk1(List<TechPro> list) {
        return list.
                stream().
                filter(t->t.getOgrcSayisi() > 130).
                mapToInt(t->t.getBatchOrt()).max();
    }

    //task 11-->Ogrenci sayilari 150'dan az olan batch'lerin en kucuk batch ort'unu bulunuz.
    public static Optional<Integer> ogrcSayisi150KckEnKckBatchOrt(List<TechPro> list) {
       return list.
                stream().
                filter(t->t.getOgrcSayisi() < 150).
                map(t->t.getBatchOrt()).reduce(Integer::min);
    }
    public static OptionalInt ogrcSayisi150KckEnKckBatchOrt1(List<TechPro> list) {
        return list.
                stream().
                filter(t->t.getOgrcSayisi() < 150).
                mapToInt(t->t.getBatchOrt()).min();
    }
    public static int ogrSayisi150danAzEnKckbatchOrt(List<TechPro>list) {
        return list.stream().
                filter(t -> t.getOgrcSayisi() < 150).
                mapToInt(t -> t.getBatchOrt()).
                min().
                getAsInt(); // getAsInt() -> ciktiyi int olarak return eder
    }

}
