import java.util.ArrayList;
import java.util.List;

public class StringPermutationOfOther {

    public static void main(String[] args) {
        String str1 = "bird";
        String str2 = "yuhg";

        System.out.println(isPermutedString(str1, str2));
    }

    private static boolean isPermutedString(String str1, String str2) {

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        boolean res = false;

        List<Character> arrlist = new ArrayList<Character>();

        if (arr1.length != arr2.length) {
            return false;
        } else {

            for (int i = 0; i < arr1.length; i++) {
                arrlist.add(arr1[i]);
            }

            for (int i = 0; i < arr2.length; i++) {
                if (!arrlist.contains(arr2[i])) {
                    res = false;
                    break;
                } else {
                    res = true;
                }
            }

        }
        return res;
    }
}
