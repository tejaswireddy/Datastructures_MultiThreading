import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class StringPermutations {

        public List<String> permute(char input[]) {
            //Iterate through the character array and store each character and its count in a TreeMap
            //TreeMap stored keys in sorted order(ascending).O(log N) lookup,insertion,deletion because its underlying datastructure is red black trees

            Map<Character, Integer> countMap = new TreeMap<>();
            for (char ch : input) {
                //compute is introduced in java 8 .It does the put here in this case .
                countMap.compute(ch, (key, val) -> {
                    if (val == null) {
                        return 1;
                    } else {
                        return val + 1;
                    }
                });
            }
            //For inpit in our case the map will contains keys,values as follows.
            //key:A value:2 key:B value:1 key:C value:1

            //Str array contains all characters
            //count array contains counts of above characters

            char str[] = new char[countMap.size()];
            int count[] = new int[countMap.size()];
            int index = 0;
            //iterate through the map and put all characters(keys) in str array and counts(values) in count array.

            for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
                str[index] = entry.getKey();
                count[index] = entry.getValue();
                index++;
            }

            //create an arraylist called result list that holds all results(permutations of input string)
            //Also create a result character array of input string length

            List<String> resultList = new ArrayList<>();
            char result[] = new char[input.length];
            permuteUtil(str, count, result, 0, resultList);
            return resultList;
        }

        public void permuteUtil(char str[], int count[], char result[], int level, List<String> resultList) {
            //if level matches the result array length then add the string to the resultList arraylist

            if (level == result.length) {
                resultList.add(new String(result));
                return;
            }
//Now iterate through the count array and look for count >1 starting from left

            for(int i = 0; i < str.length; i++) {
                if(count[i] == 0) {
                    continue;
                }
                //if count is >1 then add the element to result array and decrease the count
                result[level] = str[i];
                count[i]--;
                //now recursively call it again by increasing the level
                permuteUtil(str, count, result, level + 1, resultList);
                count[i]++;
            }
        }

        private void printArray(char input[]) {
            for(char ch : input) {
                System.out.print(ch);
            }
            System.out.println();
        }

        public static void main(String args[]) {
            StringPermutations sp = new StringPermutations();
            sp.permute("ABBCG".toCharArray()).forEach(s -> System.out.println(s));
        }
    }

    //O(n!)