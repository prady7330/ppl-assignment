/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Pradeep
 */
public class ques8_algo {
    public ArrayList<couple> dist_gift(ArrayList<couple> couples,ArrayList<gift> gifts,ArrayList<boy> boys){
        //method to distribute gifts among the committed girls with the given 1st algo int he question
        Collections.sort(gifts, new Comparator<gift>() {//sorting couples on the basis of happiness and printing
           @Override
              public int compare(gift c1, gift c2) {
                   return Integer.compare(c1.get_price(), c2.get_price());
               }
         });
        int flag=0;
        int i=0;
        int j=0;
        int k=0;
        int check=0;
        for(couple c:couples){
            if(check==0){
                for(gift g:gifts){
                    if(g instanceof gift){
                        c.set_gift(g);
                        for(boy b:boys){
                            if(b.get_name().equals(c.get_b_name())){
                                b.set_budget(b.get_budget()-g.get_price());
                            }
                        }
                        break;
                    }
                }
                for(gift g:gifts){
                    if(g instanceof luxury_gift){
                        c.set_gift(g);
                        for(boy b:boys){
                            if(b.get_name().equals(c.get_b_name())){
                                b.set_budget(b.get_budget()-g.get_price());
                            }
                        }
                        break;
                    }
                }
                for(gift g:gifts){
                    if(g instanceof utility_gift){
                        c.set_gift(g);
                        for(boy b:boys){
                            if(b.get_name().equals(c.get_b_name())){
                                b.set_budget(b.get_budget()-g.get_price());
                            }
                        }
                        break;
                    }
                }
                check++;
            }
            else{
                for(couple co:couples){
                    for(boy b:boys){
                        if(b.get_name().equals(co.get_b_name())){
                            i=0;
                            if(b.get_budget()>0){
                                int p=gifts.get(i).get_price();
                                while(b.get_budget()-p>0){
                                    co.set_gift(gifts.get(i));
                                    i++;
                                    p=gifts.get(i).get_price();
                                    b.set_budget(b.get_budget()-p);
                                    
                                }
                            }
                        }
                    }
                }
            }
        }
        return couples;
    }
    public ArrayList<couple> dist_gift2(ArrayList<couple> couples, ArrayList<gift> gifts,ArrayList<boy> boys,ArrayList<girl> girls){
        //method to distribute gifts among the girls with the algo specified in the question
        Collections.sort(gifts, new Comparator<gift>() {//sorting couples on the basis of happiness and printing
           @Override
              public int compare(gift c1, gift c2) {
                   return Integer.compare(c1.get_price(), c2.get_price());
               }
         });
        for(couple c:couples){
            for(boy b:boys){
                if(b.get_name().equals(c.get_b_name())){
                    if(b instanceof miser_boy){
                        int i=0;
                        int p=gifts.get(i).get_price();
                        while(b.get_budget()-p>0){
                            c.set_gift(gifts.get(i));
                            i++;
                            b.set_budget(b.get_budget()-p);
                            p=gifts.get(i).get_price();
                        }
                    }
                    if(b instanceof generous_boy){
                        int i=gifts.size()-1;
                        int p=gifts.get(i).get_price();
                        while(b.get_budget()-p>0){
                            c.set_gift(gifts.get(i));
                            i--;
                            b.set_budget(b.get_budget()-p);
                            p=gifts.get(i).get_price();
                        }
                        
                    }
                    if(b instanceof geeks_boy){
                        for(gift g:gifts){
                            if(g instanceof luxury_gift && b.get_budget()>g.get_price()){
                                c.set_gift(g);
                                b.set_budget(b.get_budget()-g.get_price());
                            }
                        }
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
        }
        return couples;
    }
}
