// Java implementation to check if
// characters of a given string can
// be rearranged to form a palindrome

//Approack 1: find all permutations and check rev of each permutation if its euqal then yes else no
//this will take O(N*N!)

//This can be solved with even better time

//Time complexity of the below solution is O(N) and space complexity is O(N)
//A palindromic string must contain atmost 1 odd numbers of characters and rest all even characters.
//if the given string contains atmost 1 character that is occuring odd number of time and rest all characters even number of times then it can form  apalindrome.

import java.util.Arrays;

public class CheckIfStringCharsCanBeRearrangedToFormAPalindrome {

        /* function to check whether characters
        of a string can form a palindrome */
        //This program returns true if the string can be rearranged to form palindrome else false.This will not display the palindromic strings.



        // Driver program
        public static void main(String args[])
        {
            if (canFormPalindrome("kitten"))
                System.out.println("Yes");
            else
                System.out.println("No");


        }

    public static boolean canFormPalindrome(String str) {

         int MAX_CHARS=256;//no of ASCII characters =256 thats why we take max size as 256

         int[] arr = new int[MAX_CHARS];
        Arrays.fill(arr,0);//fill all values in zrray with zeroes initially

         for(int i=0;i< str.length();i++){
             arr[(int)str.charAt(i)]++;//increment the index if a character is found
         }

         int odd =0;
         for (int i=0;i< arr.length; i++){
             if(arr[i]%2 !=0){
                 odd++;

             }
         }

         if(odd>1){//if a more than one character repeated odd number of times then it cannot have permutations that can form a palindrome
             return false;
         }
         return true;

    }
}
