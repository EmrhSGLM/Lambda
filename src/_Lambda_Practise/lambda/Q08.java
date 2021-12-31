package _Lambda_Practise.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q08 {
    // 7 ile bolunebilen ilk 3 tamsayinin toplamini ekrana yazdiriniz.

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(7,14,21,56,21,30,20,10,25));

        System.out.print("1. Yol => ");

        System.out.print(list.
                stream().
                filter(t -> t % 7 == 0).
                limit(10).reduce(Integer::sum));

        System.out.print("\n2. Yol => ");

        System.out.print(list.
                stream().
                filter(t -> t % 7 == 0).
                limit(10).
                reduce(Integer::sum).
                orElse(0));

    }

}
