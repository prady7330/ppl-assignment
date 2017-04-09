/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package entities;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Pradeep
 */
public class main5 {
    public static void main(String args[]) throws IOException{
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
        Collections.sort(girls, new Comparator<girl>() {//sorting girls on the basis of maintenance budget
           @Override
              public int compare(girl c1, girl c2) {
                   return Integer.compare(c1.get_main_budget(), c2.get_main_budget());
               }
         });
        Collections.sort(boys, new Comparator<boy>() {//sorting boys on the basis of budget
           @Override
              public int compare(boy c1, boy c2) {
                   return Integer.compare(c1.get_att(), c2.get_att());
               }
         });
        ques5_algo q5=new ques5_algo();//creating object to deploy algo
        couples=q5.create_couples(boys, girls);//creating couples according to the couples choosing condition
        couples=q3.do_real(couples, boys, girls);//distributing gifts to the girls 
        Collections.sort(couples, new Comparator<couple>() {//sorting couples on the basis of happiness and printing
           @Override
              public int compare(couple c1, couple c2) {
                   return Integer.compare(c1.get_happiness(), c2.get_happiness());
               }
         });
        System.out.println("5 most happiest couples");
        q3.printc(5, couples);
    }
}
