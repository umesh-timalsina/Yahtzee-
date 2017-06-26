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
    private int score;
    //private static int totalScore;
    private  int numberOfRolls;
    private static int yahtzeesCount = 0;
    private static final int maxNumberOfRolls = 3;
    private int [] result = new int [5];
    private Player p;
    private static boolean [] categoriesScored = new boolean[13];
    private static enum Categories  {US1, US2, US3,  US4, US5, US6, THREE, FOUR, SMALLSTRAIGHT, LARGESTRAIGHT, FULLHOUSE, YAHTZEE, CHANCE};
    
    public Rounds(){
    
    }
    
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
//    
//    private boolean isSmallStraight(){
//    
//        //int count = 0;
//        boolean isSmallStraight = false;
//        for(int i = 0; i< this.result.length; i++){
//           for(int j = i+1; j < this.result.length-1; j++){
//               if(this.result[i] == this.result[j]-1 && this.result[j] == this.result[j+1]-1){
//                   isSmallStraight = true;
//               }
//           }    
//        }    
//        return isSmallStraight;
//    }
    
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
        boolean isFullHouse = false;
        
    
        return isFullHouse;
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
    
    private int sumResult(){
        int sum = 0;
        for(int i = 0; i< this.result.length; i++){
            sum += this.result[i];
        }
        return sum;
    }

    public void showCategories(){
        
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
        System.out.println("7 - Chance");
        System.out.println("8 - Upper Scores");
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
                //this.score = ;
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
                break;
        }
    
    
    }
}
