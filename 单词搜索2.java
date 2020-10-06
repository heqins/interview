import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 单词搜索2 {
    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        for (String word: words) {
            insert(root, word);
        }

        Set<String> set = new HashSet<>();
        int n = board.length, m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Trie cur = root;
                StringBuilder temp = new StringBuilder();
                temp.append(board[i][j]);
                boolean[][] visited = new boolean[n][m];
                dfs(board, i, j, cur.children[board[i][j] - 'a'], temp, set, visited);
            }
        }

        List<String> ans = new ArrayList<>();
        ans.addAll(set);
        return ans;
    }

    public void dfs(char[][] board, int x, int y, Trie root, StringBuilder temp,
                    Set<String> res, boolean[][] visited) {
        if (root == null) {
            return;
        }

        if (root.is_word) {
            res.add(temp.toString());
        }

        int n = board.length, m = board[0].length;
        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};
        visited[x][y] = true;

        for (int i = 0; i < dx.length; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newY >= 0 && newX < n && newY < m && !visited[newX][newY]) {
                temp.append(board[newX][newY]);
                dfs(board, newX, newY, root.children[board[newX][newY] - 'a'], temp, res, visited);
                temp.deleteCharAt(temp.length() - 1);
            }
        }

        visited[x][y] = false;
    }

    public void insert (Trie root, String word) {
        Trie cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (root.children[index] == null) {
                root.children[index] = new Trie();
            }

            root = root.children[index];
        }

        root.is_word = true;
    }

    public boolean search(String s, Trie root){
        Trie cur = root;
        for(int i = 0; i < s.length(); i++){
            int c = s.charAt(i) - 'a';
            if(cur.children[c] == null){
                return false;
            }
            cur = cur.children[c];
        }
        return cur.is_word;
    }

    class Trie {
        boolean is_word;
        Trie[] children;
        public Trie() {
            is_word = false;
            children = new Trie[26];
        }
    }
}
