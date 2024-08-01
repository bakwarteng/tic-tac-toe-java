class Main{
    public static void main(String[] args){
        char[][] board = new char[3][3];
        for(int row= 0; row < board.length; row++){
            for(int col = 0; col < board[row].lengh; col++){
            board[row][col]='';
        }
    }
    Chat player='X';
    boolean gameOver=false;
    Scanner scanner= new Scanner(System.in);

    while(!gameOver){
        printBoard(board);
        System.out.printIn("Player" + player + "enter:");
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        if (board[row][col==='']){
            board[row][col]= player;
            gameOver= haveWon(board, player); //place the element
            if(gameOver){
             System.out.printIn("Player" + player + "has won:");

            }else{
                if (player ==='X'){
                    player = 'O';
                }else{
                    player = 'X';
                }
            }
         } else{
                System.out.printIn(' Invalid move. Try Again!'
                )

            }
        }

    }
printBoard(board);

}
public static boolean haveWon(char[][] board, char player){
    // check the rows
    for(int row= 0; row < board.length; row++){
        if(board[row][0]== player && board[row][1]== player && board[row][2]== player){
            return true;
        }

}
// check for col
 for(int col= 0; col < board[0].length; col++){
        if(board[col][0]== player && board[col][1]== player && board[col][2]== player){
            return true;
        }
}
//diagnal
if(board[0][0]== player && board[1][1] == player&&board[2][2]== player) {
    return true;
}
if(board[0][2]== player && board[1][1] == player&&board[2][0]== player) {
    return true;

}
return false
}
public static void printBoard(char[][] board){
        for(int row= 0; row < board.length; row++){
            for(int col = 0; col < board[row].lengh; col++){
            System.out.printIn(board[row][col] + "|");

}
System.out.printIn();
        }
    }
