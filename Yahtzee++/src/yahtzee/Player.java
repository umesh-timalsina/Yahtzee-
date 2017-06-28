/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yahtzee;

import java.util.Arrays;
import java.util.Random;

public class Player {

    private Random[] dices = new Random[5];
    //private boolean [] categories = new boolean [13];

    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public void addScore(int roundScore){
        this.score += roundScore; 
    
    }
    public Player() {

        for (int i = 0; i < this.dices.length; i++) {

            this.dices[i] = new Random();

        }
        System.out.println("Your Dices are ready to roll.");
    }

    public int[] rollDices() {

        // This function is to roll dices
        int[] result = new int[5];
        for (int i = 0; i < result.length; i++) {

            result[i] = dices[i].nextInt(6) + 1;
            

        }
        
        sortResult(result);
        return result;
    }

    private void sortResult(int[] result) {

        Arrays.sort(result);
    }

    //A set of private helper methods for calculating results of the dice. These
    //methods will be called by analyzeResults() method.
}
