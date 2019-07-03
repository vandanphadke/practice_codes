package Math;

public class ExcelColumnNumber {

    public static void main(String[] args){
        System.out.println(returnColumnNumber("AA"));
        System.out.println(returnColumnNumber("A"));
        System.out.println(returnColumnNumber("AB"));
        System.out.println(returnColumnNumber("AAA"));

        System.out.println(returnColumnName(27));
        System.out.println(returnColumnName(1));
        System.out.println(returnColumnName(28));
        System.out.println(returnColumnName(943566));
    }

    /**
     * Given a column title as appears in an Excel sheet, return its corresponding column number.
     *
     * Example:
     *
     *     A -> 1
     *     B -> 2
     *     C -> 3
     *     Z -> 26
     *     AA -> 27
     *     AB -> 28
     */

    public static int returnColumnNumber(String colName){
        int num = 0;
        for (int i = 0; i < colName.length(); ++i){
            int single = colName.charAt(i) - 'A' + 1;
            num = (num * 26) + single;
        }
        return num;
    }

    /**
     * Write an inverse function to the following so that we can find the
     * name of the column given its number.
     */
    public static String returnColumnName(int colNumber){
        StringBuilder sb = new StringBuilder();
        while(colNumber > 0){
            int curNum = (colNumber - 1) % 26;
            colNumber = (colNumber - curNum) / 26;
            sb.insert(0, (char)(curNum + 'A'));
        }
        return sb.toString();
    }

}
