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
public class utility_gift extends gift{
    /* CLASS SHWOING GIFT
        WHICH ARE UTILITY
    */
    private int utility_value;
    private int utility_class;
    //SETTERS METHOD
    public void set_utility_value(int x){
        utility_value=x;
    }
    public void set_utility_class(int x){
        utility_class=x;
    }
    //GETTERS METHOD
    public int get_utility_value(){
        return utility_value;
    }
    public int get_utility_class(){
        return utility_class;
    }
}
