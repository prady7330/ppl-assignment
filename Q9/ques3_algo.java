/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package entities;

import static com.sun.org.apache.bcel.internal.Repository.instanceOf;
import java.io.IOException;
import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Pradeep
 */
public class ques3_algo {
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
    public ArrayList<boy> generate_boys() throws IOException{
        //method to generate boys of all types in a single list;
        ArrayList<boy> boys=new ArrayList<boy>();
        int i;
        for(i=0;i<20;++i){//creating miser_boys
            miser_boy b=new miser_boy();
            b.set_name(randomIdentifier());
            b.set_budget(ThreadLocalRandom.current().nextInt(1000, 10000 + 1));
            b.set_intl_level(ThreadLocalRandom.current().nextInt(20, 80 + 1));
            b.set_min_att_req(ThreadLocalRandom.current().nextInt(5, 50 + 1));
            b.set_status(0);
            b.set_att(ThreadLocalRandom.current().nextInt(5, 50 + 1));
            boys.add(b);
            write_boys3.write_to_boys(b.get_name()+","+"miser"+","+b.get_att()+","+b.get_budget()+","+b.get_happiness()+","+b.get_intl_level()+","+b.get_min_att_req());
        }
        for(i=0;i<20;++i){//creating generous_boys
            generous_boy b=new generous_boy();
            b.set_name(randomIdentifier());
            b.set_budget(ThreadLocalRandom.current().nextInt(1000, 10000 + 1));
            b.set_intl_level(ThreadLocalRandom.current().nextInt(20, 80 + 1));
            b.set_min_att_req(ThreadLocalRandom.current().nextInt(5, 50 + 1));
            b.set_att(ThreadLocalRandom.current().nextInt(5, 50 + 1));
            b.set_status(0);
            boys.add(b);
            write_boys3.write_to_boys(b.get_name()+","+"generous"+","+b.get_att()+","+b.get_budget()+","+b.get_happiness()+","+b.get_intl_level()+","+b.get_min_att_req());
        }
        for(i=0;i<20;++i){//creating geeks_boys
            geeks_boy b=new geeks_boy();
            b.set_name(randomIdentifier());
            b.set_budget(ThreadLocalRandom.current().nextInt(1000, 10000 + 1));
            b.set_intl_level(ThreadLocalRandom.current().nextInt(20, 80 + 1));
            b.set_min_att_req(ThreadLocalRandom.current().nextInt(5, 50 + 1));
            b.set_status(0);
            b.set_att(ThreadLocalRandom.current().nextInt(5, 50 + 1));
            boys.add(b);
            write_boys3.write_to_boys(b.get_name()+","+"geeky"+","+b.get_att()+","+b.get_budget()+","+b.get_happiness()+","+b.get_intl_level()+","+b.get_min_att_req());
        }
        return boys;
    }
    public ArrayList<girl> generate_girls() throws IOException{
        //method to create all the girls
        ArrayList<girl> girls=new ArrayList<girl>();
        int i;
        for(i=0;i<5;++i){//cretaing choos girl
            choosy_girl g=new choosy_girl();
            g.set_name(randomIdentifier());
            g.set_intl_level(ThreadLocalRandom.current().nextInt(20, 80 + 1));
            g.set_main_budget(ThreadLocalRandom.current().nextInt(1000, 10000 + 1));
            g.set_att(ThreadLocalRandom.current().nextInt(5, 50 + 1));
            girls.add(g);
            write_girls3.write_to_girls(g.get_name()+","+"choosy"+","+g.get_att()+","+g.get_happiness()+","+g.get_intl_level()+","+g.get_intl_level()+","+g.get_main_budget());
        }
        for(i=0;i<5;++i){//creating normal girl
            normal_girl g=new normal_girl();
            g.set_name(randomIdentifier());
            g.set_intl_level(ThreadLocalRandom.current().nextInt(20, 80 + 1));
            g.set_main_budget(ThreadLocalRandom.current().nextInt(1000, 10000 + 1));
            g.set_att(ThreadLocalRandom.current().nextInt(5, 50 + 1));
            girls.add(g);
            write_girls3.write_to_girls(g.get_name()+","+"normal"+","+g.get_att()+","+g.get_happiness()+","+g.get_intl_level()+","+g.get_intl_level()+","+g.get_main_budget());
        }
        for(i=0;i<5;++i){//creating desperate_girl
            desperate_girl g=new desperate_girl();
            g.set_name(randomIdentifier());
            g.set_intl_level(ThreadLocalRandom.current().nextInt(20, 80 + 1));
            g.set_main_budget(ThreadLocalRandom.current().nextInt(1000, 10000 + 1));
            g.set_att(ThreadLocalRandom.current().nextInt(5, 50 + 1));
            girls.add(g);
            write_girls3.write_to_girls(g.get_name()+","+"desperate"+","+g.get_att()+","+g.get_happiness()+","+g.get_intl_level()+","+g.get_intl_level()+","+g.get_main_budget());
        }
        return girls;
    }
    public ArrayList<gift> generate_gifts(){
        //method to generate all kinds of gifts and storing them in common gift box
        ArrayList<gift> gifts=new ArrayList<gift>();
        int i;
        for(i=0;i<100;++i){//generating normal gifts
            gift g=new gift();
            g.set_price(ThreadLocalRandom.current().nextInt(500, 5000 + 1));
            g.set_value(ThreadLocalRandom.current().nextInt(5, 100 + 1));
            gifts.add(g);
        }
        for(i=0;i<100;++i){//generating luxury gifts
            luxury_gift g=new luxury_gift();
            g.set_price(ThreadLocalRandom.current().nextInt(500, 5000 + 1));
            g.set_value(ThreadLocalRandom.current().nextInt(5, 100 + 1));
            g.set_luxury_rate(ThreadLocalRandom.current().nextInt(10, 100 + 1));
            g.set_difficulty(ThreadLocalRandom.current().nextInt(5, 100 + 1));
            gifts.add(g);
        }
        for(i=0;i<100;++i){//generating utility gifts
            utility_gift g=new utility_gift();
            g.set_price(ThreadLocalRandom.current().nextInt(500, 5000 + 1));
            g.set_value(ThreadLocalRandom.current().nextInt(5, 100 + 1));
            g.set_utility_value(ThreadLocalRandom.current().nextInt(10, 100 + 1));
            g.set_utility_class(ThreadLocalRandom.current().nextInt(5, 100 + 1));
            gifts.add(g);
        }
        return gifts;
    }
    public ArrayList<couple> create_couples(ArrayList<boy> boys,ArrayList<girl> girls) throws IOException{
        //method to generate couples on the basis of some conditions given in the question
        ArrayList<couple> couples=new ArrayList<couple>();
        int flag;
        for(girl g : girls){
            flag=0;
            for(boy b: boys){
                if(g.get_main_budget()<b.get_budget() && b.get_min_att_req()<=g.get_att() && b.get_status()==0 && g.get_status()==0){
                    flag=1;
                    couple co=new couple();
                    co.set_name(b.get_name(), g.get_name());
                    couples.add(co);
                    b.set_status(1);
                    g.set_status(1);
                    String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH_mm_ss").format(Calendar.getInstance().getTime());
                    write_file3.write_to_file(b.get_name()+" gets committed to"+g.get_name()+" at"+timeStamp);
                }
                if(flag==1) break;
            }
        }
        return couples;
    }
    public ArrayList<couple> do_real(ArrayList<couple> couples,ArrayList<boy> boys,ArrayList<girl> girls){
        for(boy b: boys){
        if(b instanceof miser_boy)
            ((miser_boy) b).set_happiness(ThreadLocalRandom.current().nextInt(5, 100 + 1));
        if(b instanceof generous_boy)
            ((generous_boy) b).set_happiness(ThreadLocalRandom.current().nextInt(5, 100 + 1));
        if(b instanceof geeks_boy)
            ((geeks_boy) b).set_happiness(ThreadLocalRandom.current().nextInt(5, 100 + 1));
        }
        for(girl g: girls){
            if(g instanceof choosy_girl){
                ((choosy_girl) g).set_happiness(ThreadLocalRandom.current().nextInt(5, 100 + 1));
            }
            if(g instanceof normal_girl){
                ((normal_girl) g).set_happiness(ThreadLocalRandom.current().nextInt(5, 100 + 1));
            }
            if(g instanceof desperate_girl){
                ((desperate_girl) g).set_happiness(ThreadLocalRandom.current().nextInt(5, 100 + 1));
            }
            
            for(couple c:couples){
                c.set_happiness(0);
            }
            for(couple c:couples){
                for(boy b :boys){
                    if(c.get_b_name().equals(b.get_name())){
                        if(b instanceof miser_boy)
                            c.set_happiness(c.get_happiness()+((miser_boy) b).get_happiness());
                        if(b instanceof generous_boy)
                            c.set_happiness(c.get_happiness()+((generous_boy) b).get_happiness());
                        if(b instanceof geeks_boy)
                            c.set_happiness(c.get_happiness()+((geeks_boy) b).get_happiness());
                    }
                }
                for(girl ge: girls){
                    if(ge.get_name().equals(c.get_g_name())){
                        if(ge instanceof choosy_girl)
                            c.set_happiness(c.get_happiness()+((choosy_girl) ge).get_happiness());
                        if(ge instanceof normal_girl)
                            c.set_happiness(c.get_happiness()+((normal_girl) ge).get_happiness());
                        if(ge instanceof desperate_girl)
                            c.set_happiness(c.get_happiness()+((desperate_girl) ge).get_happiness());
                    }
                }
            }
        }
        return couples;
    }
    public ArrayList<couple> do_real_again(ArrayList<couple> couples,ArrayList<boy>boys,ArrayList<girl> girls ){
        for(couple c:couples){
            for(boy b:boys){
                if(b.get_name().equals(c.get_b_name())){
                    for(girl g: girls){
                        if(g.get_name().equals(c.get_g_name())){
                            c.set_compat(Math.abs(b.get_budget()-g.get_main_budget())+Math.abs(g.get_att()-b.get_att())+Math.abs(b.get_intl_level()-g.get_intl_level()));
                        }
                    }
                }
            }
        }
        return couples;
    }   
    public void printc(int k,ArrayList<couple> couples){
        int j=0;
        int i;
        for(i=couples.size()-1; ;--i){
            if(j==k) break;
            System.out.println(couples.get(i).get_b_name()+"-->"+couples.get(i).get_g_name()+" "+couples.get(i).get_happiness());
            j++;
        }
    }
    public void printh(int k, ArrayList<couple> couples){
         int j=0;
        int i;
        for(i=couples.size()-1; ;--i){
            if(j==k) break;
            System.out.println(couples.get(i).get_b_name()+"-->"+couples.get(i).get_g_name()+" "+couples.get(i).get_compat());
            j++;
        }
    }
    
}
