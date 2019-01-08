import java.util.HashMap;
import java.util.Map;

public class UniqueCharactersInaString {

    public static void main(String[] args) {
        String str = "abcjklhgfcb";
        System.out.println(isUnique(str));
    }

    private static boolean isUnique(String str) {
        char[] arr = str.toCharArray();
        Map<Character, Integer> charcountmap = new HashMap<Character, Integer>();

        int size = arr.length;
        for (int i = 0; i < size; i++) {
            if (charcountmap.containsKey(arr[i])) {
                charcountmap.put(arr[i],charcountmap.get(arr[i])+1);

            } else {
                charcountmap.put(arr[i], 1);
            }
        }

        boolean res = false;
        for (Integer count : charcountmap.values()) {


            if (count > 1) {
                res = false;
                break;
            } else {
                res = true;
            }
        }
        return res;

    }
}
