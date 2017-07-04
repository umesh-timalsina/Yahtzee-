/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yahtzee;

import java.util.Scanner;

/**
 *
 * @author tumesh
 */
public class Rounds {
    private int score; // Score for this round
    //private static int totalScore;
    private  int numberOfRolls;      // number of rolls for this round
    private static int yahtzeesCount = 0; // number of yahtzees that have occured
    private static final int maxNumberOfRolls = 3; // maximum number of rolls in a round
    private int [] catFrequencyArray = new int [6]; // frequency of each dice in this round
    private int [] result = new int [5];            // dice result in this round
    private Player p;                               // player for this round                        
    private static boolean [] categoriesScored = new boolean[13];   // scored categories for this round
    private static enum Categories   // An enumuration has been declared
    {US1, US2, US3,  US4, US5, US6, THREE, FOUR, SMALLSTRAIGHT, LARGESTRAIGHT, FULLHOUSE, YAHTZEE, CHANCE};
    
    
    
    // Constructoris for the class
    public Rounds(){
    
    }
    
    
    // A Set of public methods for this methods
    public Rounds(Player pIn, int score){
        this.p = pIn;
        this.score = score;
    }
    public void initialize(){
        System.out.println("Welcome to Yathzee... \nPress 1 to Play");
        Scanner sc1 = new Scanner(System.in);
        while(sc1.nextInt() != 1){
        }
    }
    public void printResult(){
    
        // this function prints result of the function
        for(int i = 0; i < this.result.length; i++){
        
            
            if(i == (result.length-1)){
                System.out.print(this.result[i]);
            }
            else{
                System.out.print(this.result[i] + " " + '-' + " ");
            }
        }
        System.out.println("");
    }
    public void playRound(){
        System.out.println("Press 1 to roll Dices");
        Scanner sc1 = new Scanner(System.in);
        while(sc1.nextInt()!= 1);
        this.numberOfRolls++;
        this.result = this.p.rollDices();
        System.out.println("This is the result");
        this.printResult();
        if(this.numberOfRolls < Rounds.maxNumberOfRolls) {
            System.out.println("Roll Again?? Press 2 for rolling again and 5 to Analyze What you Scored/");
            if(sc1.nextInt()==2){
            this.playRound();
            }
            else{
                System.out.println("Round  now Over");
                
            }
        }
        else{
        
            System.out.println("Round  now Over");
            
        }

    }
    
    
    // A Set of private helper methods 
    private boolean isThreeOfAKind(){
        
        int count = 0;
        boolean threeOfAKind = false;
        for(int i = 0; i < result.length; i++){
            count = 1;
            for(int j = 0; ((j < result.length) && (i != j)) ; j++){
                if(result[i] == result[j]){
                    count++;
                   
                }

            }
           // System.out.println(count);
            if(count == 3){
                threeOfAKind = true;
                return threeOfAKind;   
            }   
        }
        return threeOfAKind;
    }
    private boolean isFourofAKind(){ 
        int count = 0;
        boolean fourOfAKind = false;
        for(int i = 0; i < result.length; i++){
            count = 1;
            for(int j = 0; ((j < result.length) && (i != j)) ; j++){
                if(result[i] == result[j]){
                    count++;
                   
                }

            }
            //System.out.println(count);
            if(count == 4){
                fourOfAKind = true;
                return fourOfAKind;   
            }   
        }
        return fourOfAKind;
    }   
    private boolean isYathzee(){
        int count = 0;
        //result[0] = result[1] = result[2] = result[3] = result[4] = 0;
        boolean yathzee = false;
        for(int i = 0; i < result.length; i++){
            count = 1;
            for(int j = 0; ((j < result.length) && (i != j)) ; j++){
                if(result[i] == result[j]){
                    count++;
                   
                }

            }
            //System.out.println(count);
            if(count == 5){
                yathzee = true;
                return yathzee;   
            }   
        }
        return yathzee;
    
    }
    private void populateCategoriesArray(){
        
        for(int i = 0; i < this.catFrequencyArray.length; i++){
            for(int j = 0; j < this.result.length; j++){
                if(this.result[j] == (i+1))
                    ++catFrequencyArray[i];
            }
            System.out.println((i+1) + "Has occoured " + catFrequencyArray[i] + "Times");
        }
        
    } 
    private boolean isSmallStraight(){
        boolean isSmallStraight = false;
        int count = 0;
        for(int i = 0; i < this.result.length-1; i++){
            for(int j = i + 1; j<this.result.length-2; j++){
                if((this.result[i] == this.result[j]-1) && (this.result[j] == this.result[j+1]-1) && (this.result[j+1] == this.result[j+2]-1))
                    isSmallStraight = true;
            
            }
            
        }
        return isSmallStraight;
    }
    private boolean isFullHouse(){
        boolean count1 = false , count2 = false;
        for(int i = 0; i<this.catFrequencyArray.length; i++){
            if(this.catFrequencyArray[i] == 2)
                count1 = true;
            if(this.catFrequencyArray[i] == 3)
                count2 = true;
        }
        return (count1&&count2);
    }
    private boolean isLargeStraight(){
    
        int count=0;
        boolean isLargeStraight = false;
        for(int i = 0; i < this.result.length-1; i++){
            
            if(this.result[i] + 1 == this.result[i+1]){
                count++;
            }
        
        }
        if(count == 4){
            isLargeStraight = true;
        }

        return isLargeStraight;
    }
    private void printRoundResults(){
        
         System.out.println("Round Score =  " + this.score + " Total Score = " + p.getScore());
    }
    private int sumResult(){
        int sum = 0;
        for(int i = 0; i< this.result.length; i++){
            sum += this.result[i];
        }
        return sum;
    }
    private void scoreUpperScores(){
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Select which of the upper Scores you want");
        for(int i = 0; i < this.catFrequencyArray.length; i++ ){
            if(catFrequencyArray[i]>0 && categoriesScored[i] == false){
                System.out.print(" Press " + (i+1) + " to score upper ");
                System.out.println(i+1);
            }
        }
        switch(sc1.nextInt()){
            case 1:
                this.score = catFrequencyArray[0] * 1;
                p.addScore(this.score);
                Rounds.categoriesScored[Rounds.Categories.US1.ordinal()] = true;
                this.printRoundResults();
                break;
            case 2:
                this.score = catFrequencyArray[1] * 2;
                p.addScore(this.score);
                this.printRoundResults();
                Rounds.categoriesScored[Rounds.Categories.US2.ordinal()] = true;
                break;
            case 3:
                this.score = catFrequencyArray[2] * 3;
                p.addScore(this.score);
                Rounds.categoriesScored[Rounds.Categories.US3.ordinal()] = true;
                this.printRoundResults();
                break;
            case 4:
                this.score = catFrequencyArray[3] * 4;
                p.addScore(this.score);
                Rounds.categoriesScored[Rounds.Categories.US4.ordinal()] = true;
                this.printRoundResults();
                break;
            case 5:
                this.score = catFrequencyArray[4] * 5;
                p.addScore(this.score);
                Rounds.categoriesScored[Rounds.Categories.US5.ordinal()] = true;
                this.printRoundResults();
                break;
            case 6:
                this.score = catFrequencyArray[5] * 6;
                p.addScore(this.score);
                Rounds.categoriesScored[Rounds.Categories.US6.ordinal()] = true;
                this.printRoundResults();
                break;    
        }
 
        
        
                
        

    }
    
    public void showCategories(){
        
        this.populateCategoriesArray();
        System.out.println("Following Categories are applicable to this round");
        System.out.println("Please Select Which to Score");
        Scanner sc1 = new Scanner(System.in);
        if(this.isThreeOfAKind() && !(categoriesScored[Categories.THREE.ordinal()])){
            System.out.println("1 - Three of a Kind");
        }
        if(this.isFourofAKind() && !(categoriesScored[Categories.FOUR.ordinal()])){
            System.out.println("2 - Four of a Kind");
        }
        if(this.isYathzee() && !(categoriesScored[Categories.YAHTZEE.ordinal()])){
            System.out.println("3 - Bingo!! Yathzee");
        }
        if(this.isFullHouse() && !(categoriesScored[Categories.FULLHOUSE.ordinal()])){
            System.out.println("4 -  Full House");
        }
        if(this.isLargeStraight() && !(categoriesScored[Categories.LARGESTRAIGHT.ordinal()])){
            System.out.println("5- Large Straight");
        }
        if(this.isSmallStraight()  && !(categoriesScored[Categories.SMALLSTRAIGHT.ordinal()])){
        
            System.out.println("6- Small Straight");
        
        }
        if(!categoriesScored[Categories.CHANCE.ordinal()]){
            System.out.println("7 - Chance");
       
        }
        boolean upperScoreResult = (categoriesScored[0] && categoriesScored[1] && categoriesScored[2] && categoriesScored[3] && categoriesScored[4] && categoriesScored[5]);
        if(!upperScoreResult){
            System.out.println("8 - Upper Scores");
        }
        this.scorePoints(sc1.nextInt());
    
    }
    private void scorePoints(int selection){
    
        switch(selection){
        
            case 1:
                Rounds.categoriesScored[Rounds.Categories.THREE.ordinal()] = true;
                this.score = this.sumResult();
                p.addScore(score);
                System.out.println("Round Score =  " + this.score + " Total Score = " + p.getScore());
                break;
            case 2:
                Rounds.categoriesScored[Rounds.Categories.FOUR.ordinal()] = true;
                this.score = this.sumResult();
                p.addScore(score);
                System.out.println("Round Score =  " + this.score + " Total Score = " + p.getScore());
                break;
            case 3:
                Rounds.categoriesScored[Rounds.Categories.YAHTZEE.ordinal()] = false;
                this.score = (yahtzeesCount++>0)?50:100;
                p.addScore(score);
                System.out.println("Round Score =  " + this.score + " Total Score = " + p.getScore());
                break;
            case 4:
                Rounds.categoriesScored[Rounds.Categories.FULLHOUSE.ordinal()] = true;
                this.score = 25;
                p.addScore(score);
                System.out.println("Round Score =  " + this.score + " Total Score = " + p.getScore());
                break;
            case 5:
                Rounds.categoriesScored[Rounds.Categories.LARGESTRAIGHT.ordinal()] = true;
                this.score = 40;
                p.addScore(score);
                System.out.println("Round Score =  " + this.score + " Total Score = " + p.getScore());
                break;
            case 6:
                Rounds.categoriesScored[Rounds.Categories.SMALLSTRAIGHT.ordinal()] = true;
                this.score = 30;
                p.addScore(score);
                System.out.println("Round Score =  " + this.score + " Total Score = " + p.getScore());
                break;
            case 7:
                Rounds.categoriesScored[Rounds.Categories.CHANCE.ordinal()] = true;
                this.score=sumResult();
                p.addScore(score);
                System.out.println("Round Score =  " + this.score + " Total Score = " + p.getScore());
                break;
            case 8:
                scoreUpperScores();
                break;
        }
    
    
    }
}
