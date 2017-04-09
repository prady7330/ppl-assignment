/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package entities;

import java.util.ArrayList;

/**
 *
 * @author Pradeep
 */
public class couple {
/* CLASS TO REPRESENT
    A COUPLE
    */    
    private String b_name;
    private String g_name;    /* all couples attributes*/
    private int happiness;
    private int compat;
    private ArrayList<gift> gifts=new ArrayList<gift>();
    /* setters functions*/
    public void set_name(String str1,String str2){
        b_name=str1;
        g_name=str2;
    }
    public void set_happiness(int x){
        happiness=x;
    }
    public void set_compat(int x){
        compat=x;
    }
    /*getters function*/
    public String get_b_name(){
        return b_name;
    }
    public String get_g_name(){
        return g_name;
    }
    public int get_happiness(){
        return happiness;
    }
    public int get_compat(){
        return compat;
    }
    public void set_gift(gift g){
        gifts.add(g);
    }
    public ArrayList<gift> get_gift(){
        return gifts;
    }
}

