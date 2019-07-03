package Strings;

/**
 * Compare two version numbers version1 and version2.
 *
 * If version1 > version2 return 1,
 * If version1 < version2 return -1,
 * otherwise return 0.
 * You may assume that the version strings are non-empty
 * and contain only digits and the . character.
 * The . character does not represent a decimal point and is
 * used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to
 * version three", it is the fifth second-level revision of
 * the second first-level revision.
 *
 * Here is an example of version numbers ordering:
 *
 * 0.1 < 1.1 < 1.2 < 1.13 < 1.13.4
 */
public class CompareVersionNumbers {

    public static int compareVersionNumbers(String A, String B){
        A = A.replaceFirst("^0*","");
        B = B.replaceFirst("^0*","");

        String[] arrA = A.split("\\.");
        String[] arrB = B.split("\\.");

        int length = Math.max(arrA.length, arrB.length);
        for (int i=0;i<length;i++) {
            if (i < arrA.length && i < arrB.length) {
                if (arrA[i].length() > arrB[i].length()) return 1;
                else if (arrA[i].length() < arrB[i].length()) return -1;
            }

            Long n1 = i<arrA.length ? Long.parseLong(arrA[i]) : 0;
            Long n2 = i<arrB.length ? Long.parseLong(arrB[i]) : 0;

            int comp = n1.compareTo(n2);
            if (comp != 0) return comp;
        }

        return 0;
    }


}
