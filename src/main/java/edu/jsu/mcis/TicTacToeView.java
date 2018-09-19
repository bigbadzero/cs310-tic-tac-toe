package edu.jsu.mcis;

import edu.jsu.mcis.TicTacToeModel.Mark;
import edu.jsu.mcis.TicTacToeModel.Result;

public class TicTacToeView {

    private TicTacToeModel model;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
        
    }
	
    public void viewModel() {
        
        /* Print the board to the console (see examples) */
        
        /* INSERT YOUR CODE HERE */
          String toprow = "  ";
          for(int i =0; i < model.getWidth(); i++){
              toprow += i;
          }
          System.out.println(toprow + "\n");
          String rows = "";
          for(int i = 0; i < model.getWidth(); i++){
              rows += i + " " ;
              for(int j = 0; j < model.getWidth(); j++){
                  rows = rows + model.getMark(i,j);
              }
            System.out.println(rows);
            rows = "";
          }
          

    }
    public void showNextMovePrompt() {

        /* Display a prompt for the player's next move (see examples) */

        /* INSERT YOUR CODE HERE */
        if(model.isXTurn() != false){
            System.out.println(" Player 1 (X) Move:");
        }
        else{
            System.out.println(" Player 2 (O) Move:");
        }

        System.out.println("Enter the row and column number, seperated by a space:"); 

    }

    public void showInputError() {

        /* Display an error if input is invalid (see examples) */

        /* INSERT YOUR CODE HERE */
        
            System.out.println("entry not in bounds");
    }
        

    

    public void showResult(String r) {

        /* Display final winner */

        System.out.println(r + "!");

    }
	
}