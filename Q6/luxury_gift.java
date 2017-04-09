//package entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pradeep
 */
public class luxury_gift extends gift{
    /* CLASS SHOWING GIFTS
        WHICH ARE LUXURY
    */
    private int lux_rating;
    private int difficulty;
    //SETTERS METHOD
    public void set_luxury_rate(int x){
        lux_rating=x;
    }
    public void set_difficulty(int x){
        difficulty=x;
    }
    //GETTERS METHOD
    public int get_luxury_rate(){
        return lux_rating;
    }
    public int get_difficulty(){
        return difficulty;
    }
}
