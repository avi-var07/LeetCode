/*A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 

Constraints:

1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique. */


import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter begin word: ");
        String begin = sc.nextLine();
        System.out.println("Enter end word: ");
        String end = sc.nextLine();

        System.out.println("Enter number of words: ");
        int n =sc.nextInt();
        
        List<String>list = new ArrayList<>();
        sc.nextLine();
        for(int i=0;i<n;i++)list.add(sc.nextLine());

        System.out.println(ladderLength(begin, end, list));

        sc.close();
    }
    static class Pair{
        String word;
        int len;
        Pair(String word, int len){
            this.word= word;
            this.len = len;
        }
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))return 0;
        Queue<Pair>queue = new LinkedList<>();

        Set<String>set = new HashSet<>(wordList);

        //for(String str: wordList)set.add(str);

        queue.add(new Pair(beginWord, 1));

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            String node = p.word;
            int len = p.len;

            if(node.equals(endWord))return len;

            char arr[] = node.toCharArray(); //['h', 'o', 't']
            int n = arr.length;
            for(int i=0;i<n;i++){
                char ori = arr[i]; //'h'
                for(char ch='a';ch<='z';ch++){
                    arr[i]=ch;
                    String replaced = new String(arr);
                    if(set.contains(replaced)){
                        queue.add(new Pair(replaced,len+1));
                        set.remove(replaced);
                    }
                }
                arr[i]=ori; //taaki agli baar 'hat' bane
            }
        }
        return 0;
    }
}