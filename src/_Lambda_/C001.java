package _Lambda_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C001 {
    public static void main(String[] args) {
        int arr1 [] = {5, 8, 10, -2, -2, 5, 15, 1}; // tekrarlayan eleman olma durumunu degerlendiremedim :(

        int arr2 [] = new int [arr1.length];
        List<Integer> list=new ArrayList<Integer>();


        int min=arr1[0];
        //int max=arr1[0];

        for(int i=0 ; i < arr2.length;i++) {
            if(min > arr1[i]){
                min=arr1[i];}
            if(i==arr1.length-1){
                arr2[0]=min;
               }
        }

        System.out.println(list);
        int[] kova=new int[1];
    int sayac=0;
        for(int i=1; i <= arr1.length-1;i++){
            kova[0]=arr2[i];
            sayac=0;

            for (int j = i+1; j < arr1.length-1; j++) {
                if(kova[0] < arr1[j]){
                    kova[0]=arr1[j];
                    sayac++;
                }
                if(sayac==1 && kova[0] > arr1[j]){
                    kova[0]=arr1[j];
                }
            }
            if(kova[0] != arr2[i] ){
                arr2[i+1]=kova[0];
            }
        }
        System.out.println(Arrays.toString(arr2));
        //System.out.println(list); // siralanmis yeni array

    }
}
