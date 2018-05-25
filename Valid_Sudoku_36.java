import java.util.*;
public class Valid_Sudoku_36 {
    /*
    cube这个set其实不用先转成数字再加，直接Set<Character>就行。
    i和j其实不是严格的行和列，根据求row和col的不同进行变动
     */
    public boolean isValidSudoku(char[][] board) {
        for(int i =0; i < board.length; i++){
            Set<Integer> row = new HashSet<>();
            Set<Integer> col = new HashSet<>();
            Set<Integer> cube = new HashSet<>();
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] != '.' && !row.add(board[i][j] - '0')){
                    return false;
                }
                if(board[j][i] != '.' && !col.add(board[j][i] - '0')){
                    return false;
                }
                int rowIndex = 3 * (i / 3);//0, 3, 6
                int colIndex = 3 * (i % 3);//0, 3, 6
                //[0,0], [0,3],[0,6],[3,0],[6,0]...就是每个sub-boxes的起始点，在此基础上
                //要用j，因为j遍历9次，正好填一个sub-boxes
                if(board[rowIndex + j / 3][colIndex + j % 3]!= '.' && !cube.add(board[rowIndex + j / 3][colIndex + j % 3] - '0')){
                    return false;
                }
            }
        }
        return true;
    }
}
