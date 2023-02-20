// approach 1
class Solution {
    public boolean isTrue(char[][] board,int row,int col,char target) {
        for(int i = 0;i < 9;i++) {
            if(i == col) {
                continue;
            }
            if(board[row][i] == target) {
                return false;
            }
        }
        for(int i =0 ;i < 9;i++) {
            if(i == row) {
                continue;
            }
            if(board[i][col] == target) {
                return false;
            }
        }
        int start_x = row - row%3;
        int start_y = col - col%3;
        for(int i  = start_x;i <= (start_x + 2);i++) {
            for(int j = start_y; j <= (start_y + 2);j++) {
                if(i == row && j == col) {
                    continue;
                }
                if(board[i][j] == target) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        for(int i =0;i < 9;i++) {
            for(int j =0;j < 9;j++) {
                if(board[i][j] == '.') {
                    continue;
                }
                if(!this.isTrue(board,i,j,board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }
}


// approach 2
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer,HashSet<Character>> map1 = new HashMap<>();
        Map<Integer,HashSet<Character>> map2 = new HashMap<>();
        Map<Integer,HashSet<Character>> map3 = new HashMap<>();
        for(int i =0;i < 9;i++) {
            for(int j =0;j < 9;j++) {
                if(board[i][j] == '.') {
                    continue;
                }
                int x = i/3;
                int y = j/3;
                int number  = x* 10 + y;
                if(map1.containsKey(i) && map1.get(i).contains(board[i][j])) {
                    return false;
                }
                 if(map2.containsKey(j) && map2.get(j).contains(board[i][j])) {
                    return false;
                }
                 if(map3.containsKey(number) && map3.get(number).contains(board[i][j])) {
                    return false;
                }
                if(!map1.containsKey(i)) {
                map1.put(i,new HashSet<>());
                 HashSet<Character> set1 = map1.get(i);
                set1.add(board[i][j]);
                }
                else {
                    HashSet<Character> set1 = map1.get(i);
                set1.add(board[i][j]);
                map1.put(i,set1);
                }
                if(!map2.containsKey(j)) {
                map2.put(j,new HashSet<>());
                 HashSet<Character> set12 = map2.get(j);
                set12.add(board[i][j]);
                }
                else {
                     HashSet<Character> set12 = map2.get(j);
                set12.add(board[i][j]);
                map2.put(j,set12);
                }
                if(!map3.containsKey(number)) {
                    map3.put(number,new HashSet<>());
                    HashSet<Character> set123 = map3.get(number);
                    set123.add(board[i][j]);
                }
                else {
                    HashSet<Character> set123 = map3.get(number);
                    set123.add(board[i][j]);
                    map3.put(number,set123);
                }
            }
        }
        return true;
    }
}
