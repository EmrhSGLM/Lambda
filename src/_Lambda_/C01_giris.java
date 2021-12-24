package _Lambda_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class C01_giris {
	
	/*
	   1) Lambda "Functional Programming"
	      "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
	   2) "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
	   3) "Functional Programming" hiz, code kisaligi, code okunabilirligi
	   ve hatasiz code yazma acilarindan cok faydalidir.
	   4) Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.
	      Lambda kullanmak hatasız code kullanmaktır.
	*/

	public static void main(String[] args) {
		
		
		List<Integer> list=new ArrayList<>(Arrays.asList(12,13,65,3,7,34,22,60,42,55));
		printELStructured(list); // method call
		System.out.println();
		printELfunctional(list);
		printElfunctional(list);
		printCiftElStructured(list);
		printCiftElFunctional(list);
		printCiftElFunctional2(list);
		printCift60ElFunctional(list);
		printCift60ElFunctional2(list);
		printTekYirmi(list);
		printCiftKare(list);
		printCiftKare2(list);
		printTekKupBirFazla(list);
		printCiftKarekok(list);
		printEnBuyuk(list) ;
	}
	
	// Structured Programming ile list elemanlarinin tamamini yazdiriniz 
	
	public static void printELStructured(List<Integer> list) {
		System.out.print("printELStructured => ");
		for (Integer w : list) {
			System.out.print(w + " ");
		}
	}
	
	// Functional Programming ile list elemanlarinin tamamini yazdiriniz 
	
	public static void printELfunctional(List<Integer> list) {
		System.out.print("printELfunctional => ");
		list.stream().forEach(t->System.out.print(t+" ")); // Lambda Expression : Lambda Ifadesi
		// stream() : datalari yukaridan asagiya akis sekline getirir
		// forEach() : datanin parametresine gore her bir elemani isler
		// t-> : Lambda operatoru
		
		// Lambda Experrassion yapisi cok tercih edilmez daha cok METHOD REFERENCE kullanilir
	}
	
	// Method Referance --> kendi create ettigimiz veya java'dan aldigimiz method ile 
	// Classname::MethodName ez - ber - leeeeee
	
	
	public static void printEl(int t) { // refere edilecek method creare edildi
		
		System.out.print(t+" ");
	}
	
	public static void printElfunctional(List<Integer> list) {
		System.out.print("\nprintElfunctional => ");
		list.stream().forEach(C01_giris::printEl); // iste lambda budur
	}
	
	// Structured Programming ile list elemanlarinin cift elemanlarini ayni satirda aralarina bosluk birakarak yazdiriniz 
	
	public static void printCiftElStructured(List<Integer> list) {
		System.out.print("\nClassic  ==>");
		for (Integer w : list) {
			if (w % 2 == 0) {
				System.out.print(w + " ");
			}
		}
	}
	
	// Functional Programming ile list elemanlarinin cift elemanlarini ayni satirda aralarina bosluk birakarak yazdiriniz 
	
	public static void printCiftElFunctional(List<Integer> list){
		System.out.print("\nFunctional 1 ==>  ");
		list.stream().filter(t->t%2==0).forEach(C01_giris::printEl);
		// filter() --> list elemanlarini istenen sarta gore filtreliyor
	}
	
	public static boolean ciftBul(int i) { // refere edilecek tohum method create edildi
		return i%2==0;
	}
	
	public static void printCiftElFunctional2(List<Integer> list){
		System.out.print("\nFunctional 2  ==>  ");
		list.stream().filter(C01_giris::ciftBul).forEach(C01_giris::printEl);
		// filter() --> list elemanlarini istenen sarta gore filtreliyor
	}
	
	// 		Functional Programming ile list elemanlarinin cift elemanlarinin 60'dan kucuk 
	// 	olanlarini ayni satirda aralarina bosluk birakarak yazdiriniz 
	public static boolean ciftAltmis(int t) {
		boolean a=false;
		if (t%2==0 && t<60) {
			a=true;
		}
		return a;
	}
	
	public static void printCift60ElFunctional(List<Integer> list){
		System.out.print("\nFunctional ciftAltmisKucuk  ==>  ");
		list.stream().filter(C01_giris::ciftAltmis).forEach(C01_giris::printEl);
	}
	
	public static void printCift60ElFunctional2(List<Integer> list){
		System.out.print("\nFunctional ciftAltmisKucuk 2 ==>  ");
		list.stream().filter(t->t%2==0 & t<60).forEach(C01_giris::printEl);	
	}
	
	//		 Functional Programming ile list elemanlarinin tek elemanlarinin 
	//  20 dan buyuk olanlarini ayni satirda aralarina bosluk birakarak yazdiriniz 
	
	
	public static void printTekYirmi(List<Integer> list){
		System.out.print("\nTekYirmidenBuyukFunctional ==> ");
		list.stream().filter(t->t%2!=0 || t>20).forEach(C01_giris::printEl);
	}
	
	//	 Functional Programming ile list elemanlarinin cift elemanlarinin 
	// karelerini ayni satirda aralarina bosluk birakarak yazdiriniz 
	
	
	public static void printCiftKare(List<Integer> list) {
		System.out.print("\nCiftKareFunctional ==> ");
		list.stream().filter(t->t%2==0).forEach(t->System.out.print(t*t+" "));
	}
	
	public static void printCiftKare2(List<Integer> list) {
		System.out.print("\nCiftKareFunctional 2 ==> ");
		list.stream().filter(C01_giris::ciftBul).map(t->t*t).forEach(C01_giris::printEl);
		//map()--> bir ara islemde kullanilir.elemanları istenen isleme gore degistirmek update etmek icin kullanilir.
	}
	/*
	public static void printCiftKare3(List<Integer> list) {
		System.out.print("\nCiftKareFunctional 3 ==> ");
		list.stream().filter(C01_giris::ciftBul).map(Math::pow(t,2)).forEach(C01_giris::printEl);
		//map()--> bir ara islemde kullanilir.elemanları istenen isleme gore degistirmek update etmek icin kullanilir.
	}
	*/
	
	//	 Functional Programming ile list elemanlarinin tek elemanlarinin 
	// kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak yazdiriniz 
	
	public static void printTekKupBirFazla(List<Integer> list) {
		System.out.print("\nTekKupBirFazlaFunctional ==> ");
		list.stream().filter(t->t%2!=0).map(t->(t*t*t)+1).forEach(C01_giris::printEl);
	}
	
	//	 Functional Programming ile list elemanlarinin cift elemanlarinin 
	// karakoklerini bir fazlasini ayni satirda aralarina bosluk birakarak yazdiriniz 
	
	
	public static void printCiftKarekok(List<Integer> list) {
		System.out.print("\nCiftKarekokFunctional ==> ");
		list.stream().filter(C01_giris::ciftBul).map(Math::sqrt).forEach(t->System.out.print(t+" "));
	}
	
	//	 list'in en buyuk elemanini yazdiriniz
	
	public static void printEnBuyuk(List<Integer> list) {
		System.out.print("\nEnBuyuk ==> ");
		Optional<Integer> maxEl = list.stream().reduce(Math::max);
		System.out.print(maxEl); 
		
		// reduce() ==> azaltmak.. bir cok datayi tek bir data'ya(max, min, carp, toplama vb. islemlerde) cevirmek icin kullanilir
	}
}
