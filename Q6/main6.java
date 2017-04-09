/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package entities;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Pradeep
 */
public class main6 {
    public static void main(String args[]) throws IOException{
        PrintWriter writer = new PrintWriter("event3.txt");//to write into the event file registering the events happening through out the program
        writer.print("");
        writer.close();
        PrintWriter writer1 = new PrintWriter("boys3.csv");//to write the record of all the boys
        writer1.print("");
        writer1.close();
        PrintWriter writer2 = new PrintWriter("girls3.csv");//to write the record of all the girls
        writer2.print("");
        writer2.close();
        ArrayList<boy> boys=new ArrayList<boy>();
        ArrayList<girl> girls=new ArrayList<girl>();
        ArrayList<gift> gifts=new ArrayList<gift>();
        ArrayList<couple> couples=new ArrayList<couple>();
        ques3_algo q3=new ques3_algo();
        boys=q3.generate_boys();
        girls=q3.generate_girls();
        gifts=q3.generate_gifts();
        couples=q3.create_couples(boys, girls);
        ques9_algo q9=new ques9_algo();
        ques8_algo q8=new ques8_algo();
        couples=q8.dist_gift2(couples, gifts, boys, girls);
        couples=q9.happi(couples, boys, girls);
       /*for(couple c:couples)
            System.out.println(c.get_happiness());
        System.out.println(couples.size()+"\\\\\\\"");
        for(couple c: couples)
            System.out.println(c.get_gift().size());*/
       ques6_algo q6=new ques6_algo();
       couples=q6.new_gifting(couples, boys, girls, gifts, 6000);
       System.out.println("happiness of couples-(0 is the happiness of new couples formed without couples)");
       for(couple c:couples)
            System.out.println(c.get_happiness());
       System.out.println("new total couples="+couples.size());
       
    }
}
