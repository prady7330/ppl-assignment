/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package entities;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.text.SimpleDateFormat;
/**
 *
 * @author Pradeep
 */
public class ques_1_algo {
    /* CLASS TO PROVIDE ALGORITHMIC 
        SUPPORT TO THE SOLUTION 
        OF QUESTION 1
    */
// class variable
    final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";
    final java.util.Random rand = new java.util.Random();
// consider using a Map<String,Boolean> to say whether the identifier is being used or not 
    final Set<String> identifiers = new HashSet<String>();
    public String randomIdentifier() {
/* MEHOD TO RETURN RANDOM ALPHANUMERIC NAMES*/
        StringBuilder builder = new StringBuilder();
        while(builder.toString().length() == 0) {
            int length = rand.nextInt(5)+5;
            for(int i = 0; i < length; i++) {
                builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
            }
            if(identifiers.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }
        return builder.toString();
    }
   public void printC(ArrayList<couple> c){
        for(couple co: c){
            System.out.println("boy="+co.get_b_name()+" girl="+co.get_g_name());
    }
        System.out.println("total couples="+c.size());
   }
   public ArrayList<couple> simple_algo(ArrayList<boy> boys,ArrayList<girl> girls) throws IOException{
       ArrayList<couple> c =new ArrayList<couple>();
       for(int i=0;i<50;++i){
           boy b=new boy();
           b.set_name(randomIdentifier());
           b.set_att(ThreadLocalRandom.current().nextInt(5, 50 + 1));
           b.set_budget(ThreadLocalRandom.current().nextInt(1000, 10000 + 1));
           b.set_intl_level(ThreadLocalRandom.current().nextInt(20, 80 + 1));
           b.set_min_att_req(ThreadLocalRandom.current().nextInt(5, 50 + 1));
           write_boys.write_to_boys(i+1+","+b.get_name()+","+b.get_att()+","+b.get_budget()+","+b.get_intl_level()+","+b.get_min_att_req());
           boys.add(b);
       }
       for(int i=0;i<15;++i){
           girl g=new girl();
           g.set_name(randomIdentifier());
           g.set_att(ThreadLocalRandom.current().nextInt(5, 50 + 1));
           g.set_intl_level(ThreadLocalRandom.current().nextInt(20, 80 + 1));
           g.set_main_budget(ThreadLocalRandom.current().nextInt(1000, 10000 + 1));
           write_girls.write_to_girls(i+1+","+g.get_name()+","+g.get_att()+","+g.get_main_budget()+","+g.get_intl_level());
           girls.add(g);
       }
       for(girl g: girls){
            int flag=0;
            for(boy b : boys){
                //COUPLE CONDITION DEPLOYED TO CREATE COUPLES
                if(g.get_main_budget()< b.get_budget() && g.get_att()>b.get_min_att_req() && b.get_status()==0){
                    flag=1;
                    couple co=new couple();
                    co.set_name(b.get_name(), g.get_name());
                    c.add(co);
                    b.set_status(1);
                    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
                    write_file.write_to_file(b.get_name()+" gets committed to "+g.get_name()+" at"+timeStamp);
                }
                if(flag==1)
                    break;
            }
        }
       return c;
   }
}
