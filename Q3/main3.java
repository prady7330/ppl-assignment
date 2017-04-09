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
public class main3 {
    public static void main(String args[]) throws FileNotFoundException, IOException{
        PrintWriter writer = new PrintWriter("event3.txt");
        writer.print("");
        writer.close();
        PrintWriter writer1 = new PrintWriter("boys3.csv");
        writer1.print("");
        writer1.close();
        PrintWriter writer2 = new PrintWriter("girls3.csv");
        writer2.print("");
        writer2.close();
        ArrayList<boy> boys=new ArrayList<boy>();//creating common list for all the type of boys  
        ArrayList<girl> girls=new ArrayList<girl>();//creating common list for all the girls
        ArrayList<gift> gifts=new ArrayList<gift>();//creating common list for all the gifts
        ques3_algo q3= new ques3_algo();//creating object for deploying algo residing in other class
        boys=q3.generate_boys();//generateing boys
        girls=q3.generate_girls();//generating girls
        gifts=q3.generate_gifts();//generating gifts
        ArrayList<couple> couples=new ArrayList<couple>();//list for storing couples
        couples=q3.create_couples(boys, girls);//generating couples using algo residing in other class
       couples=q3.do_real(couples, boys, girls);//distributing the gifts among the girls
       couples=q3.do_real_again(couples, boys, girls);//setting happiness and compatibility of the couples
       Collections.sort(couples, new Comparator<couple>() {//sorting couples on the basis of happiness and printing
           @Override
              public int compare(couple c1, couple c2) {
                   return Integer.compare(c1.get_happiness(), c2.get_happiness());
               }
         });
       System.out.println("most happiest couples");
       q3.printc(5, couples);//printing most happiest couples
       Collections.sort(couples, new Comparator<couple>() {//sorting couples on the basis of compatibilty and printing
           @Override
              public int compare(couple c1, couple c2) {
                   return Integer.compare(c1.get_compat(), c2.get_compat());
               }
         });
       System.out.println("\n\n\n"+"most comapatible couples");
       q3.printh(5,couples);//printing most compatible couples
      System.out.println("total couples="+couples.size());
   }
}
