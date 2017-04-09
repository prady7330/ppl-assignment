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
import static java.util.Collections.list;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Pradeep
 */
public class ques9_algo {
    public ArrayList<couple> give_best(int k ,ArrayList<couple> couples){
        //method to take out the best happy couples from the couples list
         Collections.sort(couples, new Comparator<couple>() {
           @Override
              public int compare(couple c1, couple c2) {
                   return Integer.compare(c1.get_happiness(), c2.get_happiness());
               }
         });
        List li=new ArrayList<couple>();
        int i;
        for(i=couples.size()-5;i<couples.size();++i)
            li.add(couples.get(i));
        return (ArrayList<couple>) li;
    }
    public ArrayList<couple> create_couple(ArrayList<boy> boys, ArrayList<girl> girls) throws IOException{
        //method to create couples on the new technique
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
        ArrayList<couple> couples=new ArrayList<couple>();
        for(girl g:girls){
            for(boy b:boys){
                if(g.get_att()<b.get_att() && b.get_budget()>g.get_main_budget() && b.get_status()==0 && g.get_status()==0){
                    couple c=new couple();
                    c.set_name(b.get_name(), g.get_name());
                    b.set_status(1);
                    g.set_status(1);
                    couples.add(c);
                    String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH_mm_ss").format(Calendar.getInstance().getTime());
                    write_file3.write_to_file(b.get_name()+" gets committed to"+g.get_name()+" at"+timeStamp);
                }
            }
        }
        return couples;
    }
    public ArrayList<couple> dist_gift(ArrayList<couple> couples, ArrayList<boy> boys,ArrayList<girl> girls,ArrayList<gift> gifts){
        //method to distribute gitfs
        Collections.sort(gifts, new Comparator<gift>() {
           @Override
              public int compare(gift c1, gift c2) {
                   return Integer.compare(c1.get_value(), c2.get_value());
               }
         });
        for(couple c: couples){
            for(boy b:boys){
                if(b.get_name().equals(c.get_b_name())){
                    int i=0;
                    int p=gifts.get(i).get_price();
                    while(b.get_budget()-p>0){
                        c.set_gift(gifts.get(i));
                        i++;
                        b.set_budget(b.get_budget()-p);
                        p=gifts.get(i).get_price();
                    }
                }
            }
        }
        return couples;
    }
    public ArrayList<couple> happi(ArrayList<couple> couples,ArrayList<boy> boys,ArrayList<girl> girls){
        //method to calculate the happiness
        for(couple c:couples){
            for(girl g:girls){
                if(c.get_g_name().equals(g.get_name())){
                    ArrayList<gift> gif=c.get_gift();
                    int n=0;
                    for(gift t:gif)
                        n=n+t.get_price();
                    if(g instanceof choosy_girl)
                        ((choosy_girl) g).set_happiness(n);
                    if(g instanceof normal_girl)
                        ((normal_girl) g).set_happiness(n);
                    if(g instanceof desperate_girl)
                        ((desperate_girl) g).set_happiness((n));
                }
            }
        }
        for(couple c:couples){
            for(boy b:boys){
                if(b.get_name().equals(c.get_b_name())){
                    if(b instanceof miser_boy)
                        ((miser_boy) b).set_happiness(b.get_budget());
                    if(b instanceof generous_boy){
                        int hap=0;
                        for(girl g:girls){
                            if(g.get_name().equals(c.get_g_name())){
                                if(g instanceof normal_girl)
                                    hap=((normal_girl) g).get_happiness();
                                if(g instanceof choosy_girl)
                                    hap=((choosy_girl) g).get_happiness();
                                if(g instanceof desperate_girl)
                                    hap=((desperate_girl) g).get_happiness();
                            }
                        }
                        ((generous_boy) b).set_happiness(hap);
                    }
                    if(b instanceof geeks_boy){
                        for(girl g:girls){
                            if(g.get_name().equals(c.get_g_name()))
                                ((geeks_boy) b).set_happiness(g.get_intl_level());
                        }
                    }
                }
            }
        }
        for(couple c: couples){
            for(boy b:boys){
                if(c.get_b_name().equals(b.get_name())){
                    if(b instanceof miser_boy)
                        c.set_happiness(c.get_happiness()+((miser_boy) b).get_happiness());
                    if(b instanceof generous_boy)
                        c.set_happiness(c.get_happiness()+((generous_boy) b).get_happiness());
                    if(b instanceof geeks_boy)
                        c.set_happiness(c.get_happiness()+((geeks_boy) b).get_happiness());
                }
            }
        }
        for(couple c: couples){
            for(girl g:girls){
                if(c.get_g_name().equals(g.get_name())){
                    if(g instanceof choosy_girl)
                        c.set_happiness(c.get_happiness()+((choosy_girl) g).get_happiness());
                    if(g instanceof normal_girl)
                        c.set_happiness(c.get_happiness()+((normal_girl) g).get_happiness());
                    if(g instanceof desperate_girl)
                        c.set_happiness(c.get_happiness()+((desperate_girl) g).get_happiness());
                }
            }
        }
        return couples;
    }
}
