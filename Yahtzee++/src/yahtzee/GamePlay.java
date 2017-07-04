/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yahtzee;

/**
 *
 * @author tumesh
 */
public class GamePlay{
    
    
    public static void main(String [] args){
        
            Player p1 = new Player();
            Rounds [] R = new Rounds[13];
            for(int i = 0; i < R.length; i++){
                R[i] = new Rounds(p1, 0);
                
            }
//            R[1].initialize();
//            R[1].playRound();
//            R[1].showCategories();
//           // R[1].scorePoints();
           for(int i = 0; i < R.length; i++){
                System.out.println("Round number " + (i+1));
                R[i].initialize();
                R[i].playRound();
                R[i].showCategories();
           }
    
    
    }
}
