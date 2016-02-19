public class JaccardCalculate {
    public static void main(String args[]) {
        String str1 = args[0];
        String str2 = args[1];
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        float result = jaccard(charArray1, charArray2);
        System.out.println("유사도: "+result);
    }

    public static float jaccard(char[] s, char[] t) {
        int intersection = 0;
        int union = s.length + t.length;
        boolean[] sdup = new boolean[s.length];
        union -= findDuplicates(s,sdup);
        boolean[] tdup = new boolean[t.length];
        union -= findDuplicates(t,tdup);
        for (int si=0; si<s.length; si++) {
            if (!sdup[si]) {
                for (int ti=0; ti<t.length; ti++) {
                    if (!tdup[ti]) {
                        if (s[si] == t[ti]) {
                            intersection++;
                            break;
                        }
                    }
                }
            }
        }
        union -= intersection;
        return (float) intersection/union;
    }

    private static int findDuplicates(char[] s, boolean[] sdup) {
        int ndup = 0;

        for (int si=0; si<s.length; si++) {
            if (sdup[si]) {
                ndup++;
            } else {
                for (int si2=si+1; si2<s.length; si2++) {
                    if (!sdup[si2]) {
                        sdup[si2] = s[si] == s[si2];
                    }
                }
            }

        }
        return ndup;
    }
}