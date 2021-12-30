package _Lambda_;

import java.util.Arrays;

public class C000 {
    public static void main(String[] args) {
        int arr1[] = {5, 5, 8, 10, -2, 15, 1}; // tekrarlayan eleman olma durumunu degerlendiremedim :(

        int arr2[] = new int[arr1.length];

        int sayi = Integer.MAX_VALUE;

        int son = Integer.MIN_VALUE;

        int sayac=0;

        for (int i = 0; i < arr1.length; i++) {

            for (int j = 0; j < arr1.length; j++) {

                if(son == arr1[j]){
                        sayac++;
                }
                if (sayi > arr1[j] && arr1[j] > son) {

                    sayi = arr1[j];
                    System.out.println(sayi);

                }

            }
            arr2[i] = sayi;
            son = sayi;
            sayi = Integer.MAX_VALUE;

        }



        System.out.println(Arrays.toString(arr2)); // siralanmis yeni array
    }
}