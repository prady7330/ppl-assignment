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
public class girl {
    /* COMMON GIRL CLASS REPRESENTING 
       THE COMMON ATTRIBUTES OF ALL
       GIRLS
    */
    private String name;
    private int att;       /* common girls attributes */
    private int main_budget;
    private int intl_level;
    private int status;
    /*setters method*/
    public void set_status(int x){
        status=x;
    }
    public int get_status(){
        return status;
    }
    public void set_name(String str){
        name=str;
    }
    public void set_att(int x){
        att=x;
    }
    public void set_main_budget(int x){
        main_budget=x;
    }
    public void set_intl_level(int x){
        intl_level=x;
    }
    /* getters method*/
    public String get_name(){
        return name;
    }
    public int get_att(){
        return att;
    }
    public int get_main_budget(){
        return main_budget;
    }
    public int get_intl_level(){
        return intl_level;
    }
}
