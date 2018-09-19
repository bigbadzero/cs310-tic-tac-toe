package edu.jsu.mcis;

public class TicTacToeModel {
    
    private static final int DEFAULT_WIDTH = 3;
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a tie,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("Tie"), 
        NONE("none");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    private Mark[][] grid; /* Game grid */
    private boolean xTurn; /* True if X is current player */
    private int width;     /* Size of game grid */
    
    /* DEFAULT CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        /* No arguments (call main constructor; use default size) */
        
        this(DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create grid (width x width) as a 2D Mark array */

        grid = new Mark[width][width];

        /* Initialize grid by filling every square with empty marks */

        for (int i=0; i < width; i++){
                for(int j = 0; j < width; j++){
                    grid[i][j] = Mark.EMPTY;



            }
        }
        
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Place the current player's mark in the square at the specified
           location, but only if the location is valid and if the square is
           empty! */
        
        
        boolean madeMark = false;
        if(isValidSquare(row, col)){
            if(!isSquareMarked(row, col)){
                madeMark = true;
                if(xTurn == true){
                    grid[row][col] = Mark.X;
                    xTurn = false;
                }
                else{
                    grid[row][col] = Mark.O;
                    xTurn = true;
                }

            }
        }

        return madeMark; 
        
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return true if specified location is within grid bounds */
        
        
        boolean valid = false;
        if ((row < this.width && row > -1) && (col < this.width && col> -1)){
            valid = true;
        }

        return valid; 
        
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return true if square at specified location is marked */
        
        /* INSERT YOUR CODE HERE */
        boolean marked = false;
        if (isValidSquare(row, col)){
            if (grid[row][col] != Mark.EMPTY){
                marked = true;
            }
        }

        return marked; 
            
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return mark from the square at the specified location */
        
        Mark mark = grid[row][col];
        return mark;
        
        
    }
	
    public Result getResult() {
        
        /* Use isMarkWin() to see if X or O is the winner, if the game is a
           tie, or if the game is not over, and return the corresponding Result
           value */
        
        /* INSERT YOUR CODE HERE */
        
        boolean xWins = isMarkWin(Mark.X);
        boolean oWins = isMarkWin(Mark.O);
        boolean tieGame = isTie();
        
        if (xWins == true){
            return Result.X;
        }
        else if(oWins == true){
            return Result.O;
        }
        else if(tieGame == true){
            return Result.TIE;
        }
        else{
           return Result.NONE; 
        }

        
        

    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
        /* INSERT YOUR CODE HERE */
        boolean win = false;
        
        int horiz_counter = 0;
        int vert_counter = 0;
        int diag_counter = 0;
        int rev_diag_counter = 0;

        for(int i =0; i < width; i++){
            for(int j = 0; j < width; j++){
                if(grid[i][j] == mark){
                    horiz_counter ++;
                }
                if(grid[j][i] == mark){
                    vert_counter ++;
                }   
        }
            if(horiz_counter == width || vert_counter == width){
  
                win = true;
            }
            horiz_counter = vert_counter = 0;
        }

        for(int i = 0; i < width; i++){
            if(grid[i][i] == mark){
                diag_counter ++;
                
            }
        if (diag_counter == width){
             win = true;
        }
        }

        for(int i =0; i < width; i++){
            if(grid[i][width - i - 1] == mark){
                rev_diag_counter ++;
            }
        if(rev_diag_counter == width){
            win = true;
        }

        }
        

        



        return win; 

    }
	
    private boolean isTie() {
        boolean tie = false;
        boolean noSquares = false;
        boolean xWon = isMarkWin(Mark.X);
        boolean oWon = isMarkWin(Mark.O);
        int squareCount = 0;
        int squareTotal = (width * width);

        
        /* Check the squares of the board to see if the game is a tie */

        /* INSERT YOUR CODE HERE */
        for(int i = 0; i < width; i++){
            for(int j = 0; j< width; j++){
                if(isSquareMarked(i,j)){
                    squareCount ++;
                }
            }
        }
        if(squareCount == squareTotal){
            noSquares = true;
        }
        if(noSquares && !xWon && !oWon ){
            tie = true;
        }

        return tie; /* remove this line! */
        
    }

    public boolean isGameover() {
        
        /* Return true if the game is over */
        
        return Result.NONE != getResult();
        
    }

    public boolean isXTurn() {
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth() {
        
        /* Getter for width */
        
        return width;
        
    }
    
}