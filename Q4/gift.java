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
public class gift {
    /* GIFT CLASS REPRESENTING
        THE ATTRIBUTES OF COMMON
            GIFTS
    */
    private int price;
    private int value;
    //SETTERS METHOD
    public void set_price(int x){
        price=x;
    }
    public void set_value(int x){
        value=x;
    }
    //GETTERS METHOD
    public int get_price(){
        return price;
    }
    public int get_value(){
        return value;
    }
}
