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
public class boy {
    /* COMMON BOY CLASS REPRESENTING
        THE COMMON ATTRIBUTES OF ALL
        BOYS
    */
    private String name;
    private int att;        /* all common values in boys*/
    private int intl_level;
    private int budget;
    private int min_att_req;
    private int status;
    public void set_status(int e){
        status=e;
    }
    public int get_status(){
        return status;
    }
    public void set_name(String str){
        name=str;
    }
    /*setters method*/
    public void set_att(int x){
        att=x;
    }
    public void set_intl_level(int y){
        intl_level=y;
    }
    public void set_budget(int x){
        budget=x;
    }
    public void set_min_att_req(int y){
        min_att_req=y;
    }
    /*getters method*/
    public String get_name(){
        return name;
    }
    public int get_att(){
        return att;
    }
    public int get_intl_level(){
        return intl_level;
    }
    public int get_budget(){
        return budget;
    }
    public int get_min_att_req(){
        return min_att_req;
    }
}
