package _Lambda_Practise.lambda;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q05 {

//         {"A", "B", "D", "C", "B", "A", "A", "B", "B"} gibi bir array oluşturun;

static List<String> list = new ArrayList<>(Arrays.asList("A", "B", "D", "C", "B", "A", "A", "B", "B"));

    public static void main(String[] args) {
        tekrarliOgeYaz();
    }

    public static boolean tekrarliOlanBul(String t) {
        int count=0;
        boolean varMi = false;
        for (int i = 0; i < list.size(); i++) {
            count = 0;
            if (t.equals(list.get(i))) {
                count++;
            }
            if (count > 0) {
                varMi = true;
                break;
            }
        }
        return varMi;
    }
    //    Task 01 ->      Tekrarlanan öğeleri konsolda yazdırın
   public static void tekrarliOgeYaz() {
       list.
               stream().
               filter(Q05::tekrarliOlanBul).
               distinct().
               forEach(t-> System.out.print(t + " "));
   }
}
