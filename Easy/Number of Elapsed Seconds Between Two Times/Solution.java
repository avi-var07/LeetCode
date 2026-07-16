/*You are given two valid times startTime and endTime, each represented as a string in the format "HH:MM:SS".

Return the number of seconds that have elapsed from startTime to endTime.

 

Example 1:

Input: startTime = "01:00:00", endTime = "01:00:25"

Output: 25

Explanation:

endTime is 25 seconds ahead of startTime.
Example 2:

Input: startTime = "12:34:56", endTime = "13:00:00"

Output: 1504

Explanation:

endTime is 25 minutes and 4 seconds ahead of startTime, which equals 1504 seconds.

 

Constraints:

startTime.length == 8
endTime.length == 8
startTime and endTime are valid times in the format "HH:MM:SS"
00 <= HH <= 23
00 <= MM <= 59
00 <= SS <= 59
endTime is not earlier than startTime */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter start: ");
        String start= sc.nextLine();
        System.out.println("Enter end: ");
        String end= sc.nextLine();
        System.out.println(secondsBetweenTimes(start, end));
        sc.close();
    }
    public static int secondsBetweenTimes(String startTime, String endTime) {
        String s[]= startTime.split(":");
        String e[]= endTime.split(":");

        int h = Integer.parseInt(e[0])-Integer.parseInt(s[0]);
        int m = Integer.parseInt(e[1])-Integer.parseInt(s[1]);
        int sec = Integer.parseInt(e[2])-Integer.parseInt(s[2]);

        return h*3600+m*60+sec;
    }
}