/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package entities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Pradeep
 */
public class main2 {
    public static void main(String args[]) throws FileNotFoundException, IOException{
        PrintWriter writer1 = new PrintWriter("boys2.csv");
        writer1.print("");
        writer1.close();
        PrintWriter writer2 = new PrintWriter("girls2.csv");
        writer2.print("");
        writer2.close();
        ArrayList<miser_boy> miser_boys=new ArrayList<miser_boy>();//CREATING MISER BOYS
        ArrayList<generous_boy> generous_boys=new ArrayList<generous_boy>();// CREATING GENEROUS BOYS
        ArrayList<geeks_boy> geeks_boys=new ArrayList<geeks_boy>();//CREATING GEEKS BOYS
        ArrayList<choosy_girl> choosy_girls=new ArrayList<choosy_girl>();//CREATING CHOOSY GIRLS
        ArrayList<normal_girl> normal_girls=new ArrayList<normal_girl>();//CREATING NORMAL GIRLS
        ArrayList<desperate_girl> desperate_girls=new ArrayList<desperate_girl>();//CREATING DESPERATE GIRLS
        ques_2_algo obj1=new ques_2_algo();//MAKING OBJECT FROM CLASS HAVING ALGORITHM
        ArrayList<couple> couples=obj1.deploy_start_algo(miser_boys,generous_boys,geeks_boys,choosy_girls,normal_girls,desperate_girls);//DEPLOYING ALGORITHM
        ArrayList<gift> gifts=new ArrayList<gift>();//MAKING NORMAL GIFT
        ArrayList<luxury_gift> luxury_gifts=new ArrayList<luxury_gift>();//MAKING LUXURY GIFTS
        ArrayList<utility_gift> utility_gifts=new ArrayList<utility_gift>();//MAKING UTILITY GIFTS
        gifts=obj1.generate_gifts();//GENERATING NORMAL GIFTS FROM OTHER FILE ALGORITHM
        luxury_gifts=obj1.generate_luxury_gifts();//GENERATING LUXURY GIFTS
        utility_gifts=obj1.generate_utility_gifts();//GENERATING UTILITY GIFTS
        //DEPLOYING ALGORITHM TO DISTRIBUTE GIFTS ACCORDING TO THE TYPE OF BOYS AND CALCULATING HAPPINESS AND COMPATIBILITY OF THE COUPLES;
        
        couples=obj1.distribute_gifts(miser_boys, generous_boys, geeks_boys, choosy_girls, normal_girls, desperate_girls, couples, gifts, luxury_gifts, utility_gifts);
        int k=5;
        Collections.sort(couples, new Comparator<couple>() {
           @Override
              public int compare(couple c1, couple c2) {
                   return Double.compare(c1.get_happiness(), c2.get_happiness());
               }
         });
        System.out.println("-->"+k+" most happiest couples");
        obj1.printh(couples,k);
        Collections.sort(couples,(player1,player2)->player1.get_compat()-player2.get_compat());
        System.out.println("-->"+k+" most compatible couples");
        obj1.printh(couples,k);
    }
}
