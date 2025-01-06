import java.util.*;

public class sol {

    static String reverse(String s) {
        if (s == null) return null;
        String[] arr=s.split(" ");
        int left=0;
        int right=arr.length-1;
        
        while (left < right) {
            String temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
        return String.join(" ", arr);
    }
    public static void main(String[] args) {
        String s="Hello a the crow World";
        String a=reverse(s);
        System.out.println(a);
    }
}
