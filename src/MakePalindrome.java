public class MakePalindrome {

    private int swap(StringBuilder s, int i, int k){

        int cnt =0 ;

        while(k!=i){
            char tp = s.charAt(k);
            s.setCharAt(k,s.charAt(k-1));
            s.setCharAt(k-1,tp);
            cnt++;
            k--;
        }
        return cnt;
    }

    public int minMovesToMakePalindrome(String str) {

        StringBuilder s  = new StringBuilder(str);
        int i=0;
        int j=s.length()-1;
        int centre = -1;
        int cnt =0;
        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }
            else{
                int k=i+1;
                for(;k<=j;k++){
                    if(s.charAt(k)==s.charAt(j)){
                        break;
                    }
                }

                if(k!=j){
                    cnt += swap(s,i,k);
                    i++;
                    //System.out.println(s);
                }
                else{
                    cnt+= j-(s.length()/2);
                }
                j--;
            }
        }

        return cnt;
    }
}
/*You are given a string s consisting only of lowercase English letters.

In one move, you can select any two adjacent characters of s and swap them.

Return the minimum number of moves needed to make s a palindrome.

Note that the input will be generated such that s can always be converted to a palindrome.



Example 1:

Input: s = "aabb"
Output: 2
Explanation:
We can obtain two palindromes from s, "abba" and "baab".
- We can obtain "abba" from s in 2 moves: "aabb" -> "abab" -> "abba".
- We can obtain "baab" from s in 2 moves: "aabb" -> "abab" -> "baab".
Thus, the minimum number of moves needed to make s a palindrome is 2.
Example 2:

Input: s = "letelt"
Output: 2
Explanation:
One of the palindromes we can obtain from s in 2 moves is "lettel".
One of the ways we can obtain it is "letelt" -> "letetl" -> "lettel".
Other palindromes such as "tleelt" can also be obtained in 2 moves.
It can be shown that it is not possible to obtain a palindrome in less than 2 moves.
*/