public class LevenshteinDistance {
    public static void main(String args[]) {
        String str1 = args[0];
        String str2 = args[1];
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        float result = levenshteinDistance(charArray1, charArray2);
        System.out.println("편집거리: "+result);
        int maxLength = Math.max(charArray1.length, charArray2.length);
        float nomalizedResult = (float) ( (maxLength - result) / maxLength );
        System.out.println("정규화된 편집거리: "+nomalizedResult);
    }

    public static int levenshteinDistance(char[] s, char[] t) {
        int m = s.length;
        int n = t.length;
        int d[][] = new int[m+1][n+1];

        for (int i=0; i<=m; i++) {
            d[i][0] = i;
        }

        for (int j=0; j<=n; j++) {
            d[0][j] = j;
        }

        for (int j=1; j<=n; j++) {
            for (int i=1; i<=m; i++) {
                if (s[i-1] == t[j-1]) {
                    d[i][j] = d[i-1][j-1];
                } else {
                    d[i][j] = Math.min(Math.min(
                        d[i-1][j] + 1,
                        d[i][j-1] + 1),
                        d[i-1][j-1] + 1);
                }
            }
        }
        return d[m][n];
    }
}