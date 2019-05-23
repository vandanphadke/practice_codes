public class MinCharsPalindrome {

    public static void main(String[] args){
        System.out.println(solve("ABC"));
    }

    public static int solve(String A) {
        int j = A.length() - 1;

        for (; j >= 0; --j){
            if(isPalindrome(A, 0, j)){
                break;
            }
        }

        return A.length() - j - 1;
    }

    public static boolean isPalindrome(String s, int start, int end){
        while (start < end){
            if (s.charAt(start) != s.charAt(end)){
                return false;
            }
            ++start;
            --end;
        }
        return true;
    }

}
