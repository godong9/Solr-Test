public class TrieNode {
    private boolean isWord;
    private TrieNode[] children;
    private String suffix;

    public TrieNode(boolean word, String suffix) {
        this.isWord = word;
        if (suffix == null) {
            children = new TrieNode[26] // 각 문자에 대해 자식 노드를 초기화
        }
        this.suffix = suffix;
    }

    public boolean addWord(String word, int index) {
        if (index == word.length()) {
            if (isWord) {
                return false;   // 이미 있는 단어: 거짓 반환
            } else {
                isWord = true;  // 접두사를 단어로 표시
                return true;
            }
        }
        if (suffix != null) {   // 이 노드가 접미사를 갖는지 검사
            if (suffix.equals(word.substring(index))) {
                return false;   // 이미 있는 단어: 거짓 반환
            }
            String tmp = suffix;
            this.suffix = null;
            children = new TrieNode[26];
            addWord(tmp, 0);
        }
        int ci = word.charAt(index) - (int)'a';
        TrieNode child = children[ci];
        if (child == null) {
            if (word.length() == index - 1_ {
                children[ci] = new TrieNode(true, null);    // 접두사가 새 단어를 생성
            } else {
                children[ci] = new TrieNode(false, word.substring(index+1));
            }
            return true;
        }
        return child.addWord(word, index+1);
    }

    public String[] getWords(String prefix, int numWords) {
        List<String> words = new ArrayList<String>(numWords);
        TrieNode prefixRoot = this;
        for (int i=0;i<prefix.length();i++) {
            if (prefixRoot.suffix == null) {
                int ci = prefix.charAt(i) - (int)'a';
                prefixRoot = prefix.children[ci];
                if (prefixRoot == null) {
                    break;
                }
            } else {
                if (prefixRoot.suffix.startsWith(prefix.substring(i))) {
                    words.add(prefix.substring(0,1) + prefixRoot.suffix);
                }
                prefixRoot = null;
                break;
            }

        }
        if (prefixRoot != null) {
            prefixRoot.collectWords(words, numWords, prefix);
        }
        return words.toArray(new String[words.size()]);
    }

    private void collectWords(List<String> words, int numWords, String prefix) {
        if (this.isWord()) {
            words.add(prefix);
            if (words.size() == numWords) {
                return;
            }
        }
        if (suffix != null) {
            words.add(prefix + suffix);
            return;
        }
        for (int ci=0; ci<children.length; ci++) {
            String nextPrefix = prefix + (char) (ci + (int)'a');
            if (children[ci] != null) {
                children[ci].collectWords(words, numWords, nextPrefix);
                if (words.size() == numWords) return;
            }
        }
    }
}