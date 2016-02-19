public class LevenshteinDistance {
    public static void main(String args[]) {
        String str1 = args[0];
        String str2 = args[1];
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        float result = levenshteinDistance(charArray1, charArray2);
        System.out.println("편집거리: "+result);
    }

    public static int levenshteinDistance(char[] s, char[] t) {
        return 0;
    }

}