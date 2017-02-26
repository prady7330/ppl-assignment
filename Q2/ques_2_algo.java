/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package entities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Pradeep
 */
public class ques_2_algo {
    public ArrayList<couple> deploy_start_algo(ArrayList<miser_boy> miser_boys,ArrayList<generous_boy> generous_boys,ArrayList<geeks_boy> geeks_boys,ArrayList<choosy_girl> choosy_girls,ArrayList<normal_girl> normal_girls,ArrayList<desperate_girl> desperate_girls) throws IOException{
       ArrayList<couple> c=new ArrayList<couple>();
       ques_1_algo obj=new ques_1_algo();
       miser_boys=obj.generate_miser_boys();
       generous_boys=obj.generate_generous_boys();
       geeks_boys=obj.generate_geeks_boys();
       choosy_girls=obj.generate_choosy_girls();
       normal_girls=obj.generate_normal_girls();
       desperate_girls=obj.generate_desperate_girls();
       c=obj.CreateCouples(miser_boys, generous_boys, geeks_boys, choosy_girls, normal_girls, desperate_girls);
       return c;
    }
    public ArrayList<gift> generate_gifts(){
        ArrayList<gift> g=new ArrayList<gift>();
        for(int i=0;i<100;++i){
            gift gi=new gift();
            gi.set_price(ThreadLocalRandom.current().nextInt(500, 5000+1));
            gi.set_value(ThreadLocalRandom.current().nextInt(5, 100+ 1));
            g.add(gi);
        }
        return g;
    }
    public ArrayList<luxury_gift> generate_luxury_gifts(){
        ArrayList<luxury_gift> g=new ArrayList<luxury_gift>();
        for(int i=0;i<100;++i){
            luxury_gift gi=new luxury_gift();
            gi.set_price(ThreadLocalRandom.current().nextInt(500, 5000+1));
            gi.set_value(ThreadLocalRandom.current().nextInt(5, 100+ 1));
            gi.set_luxury_rate(ThreadLocalRandom.current().nextInt(10, 100+1));
            gi.set_difficulty(ThreadLocalRandom.current().nextInt(5, 100+ 1));
            g.add(gi);
        }
        return g;
    }
    public ArrayList<utility_gift> generate_utility_gifts(){
        ArrayList<utility_gift> g=new ArrayList<utility_gift>();
        for(int i=0;i<100;++i){
            utility_gift gi=new utility_gift();
            gi.set_price(ThreadLocalRandom.current().nextInt(500, 5000+1));
            gi.set_value(ThreadLocalRandom.current().nextInt(5, 100+ 1));
            gi.set_utility_value(ThreadLocalRandom.current().nextInt(10, 100+ 1));
            gi.set_utility_class(ThreadLocalRandom.current().nextInt(5, 100+ 1));
            g.add(gi);
        }
        return g;
    }
    public ArrayList<couple> distribute_gifts(ArrayList<miser_boy> miser_boys,ArrayList<generous_boy> generous_boys,ArrayList<geeks_boy> geeks_boys,ArrayList<choosy_girl> choosy_girls,ArrayList<normal_girl> normal_girls,ArrayList<desperate_girl> desperate_girls,ArrayList<couple> couples,ArrayList<gift> gifts,ArrayList<luxury_gift> luxury_gifts,ArrayList<utility_gift> utility_gifts){
    ArrayList<gift> gif=new ArrayList<gift>();
    for(gift gi : gifts)
        gif.add(gi);
    for( luxury_gift l : luxury_gifts)
        gif.add(l);
    for(utility_gift u: utility_gifts)
        gif.add(u);
    ArrayList<boy> b=new ArrayList<boy>();
    for(miser_boy m : miser_boys)
        b.add(m);
    for(generous_boy ge : generous_boys)
        b.add(ge);
    for(geeks_boy gee : geeks_boys)
        b.add(gee);
    ArrayList<girl> g=new ArrayList<girl>();
    for(choosy_girl c : choosy_girls)
        g.add(c);
    for(normal_girl n : normal_girls)
        g.add(n);
    for(desperate_girl d : desperate_girls)
        g.add(d);
    ///////////////////////////////////
    int i=0;
    int x;
    int y;
    int z;
    Collections.sort(gif,(player1,player2)->player1.get_price()-player2.get_price());
    for(couple cup : couples){
        boy pk=null;
        miser_boy pk1=null;
        generous_boy pk2=null;
        geeks_boy pk3=null;
        for(boy bo: b){
            if(cup.get_b_name().equals(bo.get_name())){
                
                if(bo instanceof miser_boy){
                    //pk= new miser_boy();
                    //pk=(miser_boy)bo;
                    pk1=new miser_boy();
                    pk1=(miser_boy)bo;
                }
                if(bo instanceof generous_boy){
                    //pk=new generous_boy();
                    //pk=(generous_boy) bo;
                    pk2=new generous_boy();
                    pk2=(generous_boy)bo;
                }
                if(bo instanceof geeks_boy){
                    //pk=new geeks_boy();
                    //pk=(geeks_boy)bo;
                    pk3=new geeks_boy();
                    pk3=(geeks_boy)bo;
                }
                break;
            }
        }
        girl pr=null;
        choosy_girl pr1=null;
        normal_girl pr2=null;
        desperate_girl pr3=null;
        for(girl gir : g){
            if(gir.get_name().equals(cup.get_g_name())){
                
               if(gir instanceof choosy_girl){
                   pr=new choosy_girl();
                    pr=(choosy_girl)gir;
                    pr1=new choosy_girl();
                    pr1=(choosy_girl)gir;
                }
                if(gir instanceof normal_girl){
                    pr=new normal_girl();
                    pr=(normal_girl)gir;
                    pr2=new normal_girl();
                    pr2=(normal_girl)gir;
                }
                if(gir instanceof desperate_girl){
                    pr=new desperate_girl();
                    pr=(desperate_girl)gir;
                    pr3=new desperate_girl();
                    pr3=(desperate_girl)gir;
            }
                break;
            }
        }
        
        i=0;
        //////////////////
        if(pk1!=null){
            y=0;
            z=0;
          for(gift gt : gif){
              y=y+gt.get_price();
              if(gt instanceof luxury_gift)
                  z=z+2*gt.get_value();
              else
                  z=z+gt.get_value();
              if(i==0 && gt.get_price()>pk1.get_budget()){
                x=gt.get_price();
                while(pk1.get_budget()<x)
                   pk1.set_budget(ThreadLocalRandom.current().nextInt(1000, 10000 + 1));
                i++;
              }
              if(y<pr.get_main_budget()){
                  cup.set_gift(gt);
              }
          }
          ((miser_boy) pk1).set_happiness(pk1.get_budget()-y);
          if(pr1!=null){
              ((choosy_girl) pr1).set_happiness(Math.log10(y));
              cup.set_happiness(((miser_boy) pk1).get_happiness()+((choosy_girl) pr1).get_happiness());
          }
          if(pr2!=null){
              ((normal_girl) pr2).set_happiness(y);
              cup.set_happiness(((miser_boy) pk1).get_happiness()+((normal_girl) pr2).get_happiness());
          }
          if(pr3!=null){
              ((desperate_girl) pr3).set_happiness(Math.exp(y));
              cup.set_happiness(((miser_boy) pk1).get_happiness()+((desperate_girl) pr3).get_happiness());
          }
          cup.set_compat(Math.abs(pk1.get_budget()-pr.get_main_budget())+Math.abs(pk1.get_att()-pr.get_att())+Math.abs(pk1.get_intl_level()-pr.get_intl_level()));
        }
        /////////
        i=0;
        if(pk2!=null){
            y=0;
            z=0;
            for(gift gt : gif){
                y=y+gt.get_price();
                if(gt instanceof luxury_gift)
                  z=z+2*gt.get_value();
                else
                 z=z+gt.get_value();
              if(i==0 && gt.get_price()>pk2.get_budget()){
                x=gt.get_price();
                while(pk2.get_budget()<x)
                   pk2.set_budget(ThreadLocalRandom.current().nextInt(1000, 10000 + 1));
                i++;
              }
              if(y<pk2.get_budget()){
                  cup.set_gift(gt);
              }
            }
            if(pr1!=null){
                ((choosy_girl) pr1).set_happiness(Math.log10(y));
                ((generous_boy) pk2).set_happiness(((choosy_girl) pr1).get_happiness());
                cup.set_happiness(((generous_boy) pk2).get_happiness()+((choosy_girl) pr1).get_happiness());
            }
            if(pr2!=null){
                ((normal_girl) pr2).set_happiness(y);
                ((generous_boy) pk2).set_happiness(((normal_girl) pr2).get_happiness());
                cup.set_happiness(((generous_boy) pk2).get_happiness()+((normal_girl) pr2).get_happiness());
            }
            if(pr3!=null){
                ((desperate_girl) pr3).set_happiness(Math.exp(y));
                ((generous_boy) pk2).set_happiness(((desperate_girl) pr3).get_happiness());
                cup.set_happiness(((generous_boy) pk2).get_happiness()+((desperate_girl) pr3).get_happiness());
            }
            cup.set_compat(Math.abs(pk2.get_budget()-pr.get_main_budget())+Math.abs(pk2.get_att()-pr.get_att())+Math.abs(pk2.get_intl_level()-pr.get_intl_level()));
        }
        //////////////
        i=0;
        if(pk3!=null){
            y=0;
            z=0;
            for(gift gt : gif){
              y=y+gt.get_price();
              if(gt instanceof luxury_gift)
                  z=z+2*gt.get_value();
              else
                z=z+gt.get_value();
              if(i==0 && gt.get_price()>pk3.get_budget()){
                x=gt.get_price();
                while(pk3.get_budget()<x)
                   pk3.set_budget(ThreadLocalRandom.current().nextInt(1000, 10000 + 1));
                i++;
              }
              if(y<pr.get_main_budget()){
                  cup.set_gift(gt);
              }
          }
          for(int j=gif.size();j>0;--j){
              if(gif.get(j) instanceof luxury_gift && (pk3.get_budget()-y)>=gif.get(j).get_price()){
                  cup.set_gift(gif.get(j));
                  break;
              }
          }
          /////////////
          if(pr1!=null){
              ((choosy_girl) pr1).set_happiness(Math.log10(y));
              ((geeks_boy) pk3).set_happiness(pr.get_intl_level());
              cup.set_happiness(((geeks_boy) pk3).get_happiness()+((choosy_girl) pr1).get_happiness());
          }
          if(pr2!=null){
              ((normal_girl) pr2).set_happiness(y);
              ((geeks_boy) pk3).set_happiness(pr2.get_intl_level());
              cup.set_happiness(((geeks_boy) pk3).get_happiness()+((normal_girl) pr2).get_happiness());
          }
          if(pr3!=null){
             ((desperate_girl) pr3).set_happiness(Math.exp(y));
             ((geeks_boy) pk3).set_happiness(pr3.get_intl_level());
             cup.set_happiness(((geeks_boy) pk3).get_happiness()+((desperate_girl) pr3).get_happiness());
          }
          cup.set_compat(Math.abs(pk3.get_budget()-pr.get_main_budget())+Math.abs(pk3.get_att()-pr.get_att())+Math.abs(pk3.get_intl_level()-pr.get_intl_level()));
        }
    }
    return couples;
    }
    public void printh(ArrayList<couple> c, int i){
        int k=0;
        for(couple co : c){
            if(k==i)
                break;
            System.out.println("boy="+co.get_b_name()+" girl="+co.get_g_name());
            k++;
        }
    }
    public void printa(ArrayList<couple> c){
        for(couple cup : c){
            System.out.println("hap="+cup.get_happiness()+" com="+cup.get_compat());
        }
    }
}
