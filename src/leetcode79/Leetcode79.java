package leetcode79;
public class Leetcode79 {
    public static void main(String[] args) {
        char[][] board ={{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        String word ="AAB";
       boolean result=false;
        int k=0; 
        int row=board.length;
        int line =board[0].length;
        for(int i=0;i<row;i++){
            for (int j = 0; j < line; j++) {
                if (func(i, j, 0, word, board)) {
                    result=true;
                }
            }
        }
        System.out.println(result);
    }
    public static  boolean func(int i,int j,int k,String word,char[][] board){
        int row=board.length;
        int line =board[0].length;
        if (i<0 ||i>=row||j<0||j>=line) {
            return false; 
        }
        if (board[i][j]==word.charAt(k))
        {
            show(board);
           char temp=board[i][j];
            board[i][j]='.';
            System.out.println(temp);
            
            if (k==word.length()-1) 
            {
             return true;   
            }
            if (func(i+1, j, k+1, word, board) 
                || func(i-1, j, k+1, word, board)
                ||func(i, j+1, k+1, word, board)
                ||func(i, j-1, k+1, word, board))
            {
                
                return true;
            }
            
            board[i][j]=temp;
        }     
        return false;
    }
    public static void show(char[][]board){
        System.out.println("--------------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("\n");
            
        }
        System.out.println("---------------");
    }
    
}
