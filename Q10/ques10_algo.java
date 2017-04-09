/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package entities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Pradeep
 */
public class ques10_algo {
    public boy random_boy(ArrayList<boy> boys){
        //method to return a random boy from the best boys list
      int n=boys.size();
      int i=ThreadLocalRandom.current().nextInt(0,n);
      while(boys.get(i).get_status()!=0){
          i=ThreadLocalRandom.current().nextInt(0,n);
      }
      return boys.get(i);
    }
    public gift random_gift(ArrayList<gift> gifts){
        //method to retunr a random gift from the best gifts
        int n=gifts.size();
        int i=ThreadLocalRandom.current().nextInt(0, n);
        return gifts.get(i);
    }
    public girl random_girl(ArrayList<girl> girls){
        //method to return a random girl from the best girl
        int n=girls.size();
        int i=ThreadLocalRandom.current().nextInt(0,n);
        while(girls.get(i).get_status()!=0) i=ThreadLocalRandom.current().nextInt(0,n);
        return girls.get(i);
    }
    public ArrayList<couple> create_couple(ArrayList<boy> boys,ArrayList<girl>girls) throws IOException{
        //method to create couples on the basis of random slection of boys from the boys list to the girls
        ArrayList<couple> couples=new ArrayList<couple>();
        Collections.sort(boys, new Comparator<boy>() {
           @Override
              public int compare(boy c1, boy c2) {
                   return Integer.compare(c1.get_att(), c2.get_att());
               }
         });
          Collections.sort(girls, new Comparator<girl>() {
           @Override
              public int compare(girl c1, girl c2) {
                   return Integer.compare(c1.get_main_budget(), c2.get_main_budget());
               }
         });
          for(girl g:girls){
              boy b=random_boy(boys);
              if(b.get_budget()>g.get_main_budget() && b.get_min_att_req()<g.get_att() && b.get_status()==0 && g.get_status()==0){
                  couple c=new couple();
                  c.set_name(b.get_name(), g.get_name());
                  b.set_status(1);
                  g.set_status(1);
                  couples.add(c);
                  String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH_mm_ss").format(Calendar.getInstance().getTime());
                    write_file3.write_to_file(b.get_name()+" gets committed to"+g.get_name()+" at"+timeStamp);
              }
          }
        return couples;
    }
    public ArrayList<couple> dist_gift(ArrayList<couple> couples,ArrayList<boy> boys, ArrayList<girl> girls,ArrayList<gift> gifts){
        //method to distribute the gifts among the girls with the random selection of the gifts from the giftd list
        for(couple c:couples){
            for(boy b:boys){
                if(b.get_name().equals(c.get_b_name())){
                    gift g=random_gift(gifts);
                    int p=g.get_price();
                    while(b.get_budget()-p>0){
                        c.set_gift(g);
                        b.set_budget(b.get_budget()-p);
                        g=random_gift(gifts);
                        p=g.get_price();
                    }
                }
            }
        }
        return couples;
    }
}
