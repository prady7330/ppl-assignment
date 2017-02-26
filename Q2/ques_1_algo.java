/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package entities;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
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
    public ArrayList<miser_boy> generate_miser_boys() throws IOException{
        /* METHOD TO RETURN AN ARRAYLIST
            CONTAINING ALL SINGLE BOYS
        */
        ArrayList<miser_boy> blist=new ArrayList<miser_boy>();
        /* CREATING BOYS WITH RANDOM ATTRIBUTES*/
        //CREATING MISER BOYS AND STORING THEM IN BOYS ARRAYLIST
        for(int i=0;i<20;++i){
            miser_boy b=new miser_boy();
            /* GENERATING ALL RANDOM VALUES*/
            b.set_name(randomIdentifier());
            b.set_att(ThreadLocalRandom.current().nextInt(5, 50 + 1));
            b.set_budget(ThreadLocalRandom.current().nextInt(1000, 10000 + 1));
            b.set_intl_level(ThreadLocalRandom.current().nextInt(20, 80 + 1));
            b.set_min_att_req(ThreadLocalRandom.current().nextInt(5, 50 + 1));
            write_boys2.write_to_boys(b.get_name()+","+"miser"+","+b.get_att()+","+b.get_budget()+","+b.get_happiness()+","+b.get_intl_level()+","+b.get_min_att_req());
            blist.add(b);
        }
        return blist;
    }
        //CREATING GENEROUS BOYS AND STORING THEM IN BOYS ARRALYLIST
    public ArrayList<generous_boy> generate_generous_boys() throws IOException{
        ArrayList<generous_boy> blist=new ArrayList<generous_boy>();
         for(int i=0;i<20;++i){
            generous_boy b=new generous_boy();
            /* GENERATING ALL RANDOM VALUES*/
            b.set_name(randomIdentifier());
            b.set_att(ThreadLocalRandom.current().nextInt(5, 50 + 1));
            b.set_budget(ThreadLocalRandom.current().nextInt(1000, 10000 + 1));
            b.set_intl_level(ThreadLocalRandom.current().nextInt(20, 80 + 1));
            b.set_min_att_req(ThreadLocalRandom.current().nextInt(5, 50 + 1));
            write_boys2.write_to_boys(b.get_name()+","+"generous"+","+b.get_att()+","+b.get_budget()+","+b.get_happiness()+","+b.get_intl_level()+","+b.get_min_att_req());
            blist.add(b);
        }
        return blist;
    }
         //CREATING GEEKS BOYS AND STORING THEM IN BOYS ARRAYLIST
    public ArrayList<geeks_boy> generate_geeks_boys() throws IOException{
        ArrayList<geeks_boy> blist=new ArrayList<geeks_boy>();
        for(int i=0;i<20;++i){
            geeks_boy b=new geeks_boy();
            /* GENERATING ALL RANDOM VALUES*/
            b.set_name(randomIdentifier());
            b.set_att(ThreadLocalRandom.current().nextInt(5, 50 + 1));
            b.set_budget(ThreadLocalRandom.current().nextInt(1000, 10000 + 1));
            b.set_intl_level(ThreadLocalRandom.current().nextInt(20, 80 + 1));
            b.set_min_att_req(ThreadLocalRandom.current().nextInt(5, 50 + 1));
            write_boys2.write_to_boys(b.get_name()+","+"geek"+","+b.get_att()+","+b.get_budget()+","+b.get_happiness()+","+b.get_intl_level()+","+b.get_min_att_req());
            blist.add(b);
        }
        return blist;
    }
    public ArrayList<choosy_girl> generate_choosy_girls() throws IOException{
        /* METHOD TO RETURN AN ARRAYLIST 
            CONTAINING ALL SINGLE GIRLS
        */
        /* CREATING GIRLS WITH RANDOM ATTRIBUTES*/
        ArrayList<choosy_girl> glist=new ArrayList<choosy_girl>();
        //CREATING CHOOSY GIRLS AND STORING THEM IN GIRLS ARRAYLIST
        for(int j=0;j<5;++j){
            choosy_girl g=new choosy_girl();
            /* GENERATING ALL RANDOM VALUES*/
            g.set_name(randomIdentifier());
            g.set_att(ThreadLocalRandom.current().nextInt(5, 50 + 1));
            g.set_intl_level(ThreadLocalRandom.current().nextInt(20, 80 + 1));
            g.set_main_budget(ThreadLocalRandom.current().nextInt(1000, 10000 + 1));
            write_girls2.write_to_girls(g.get_name()+","+"choosy"+","+g.get_att()+","+g.get_happiness()+","+g.get_intl_level()+","+g.get_intl_level()+","+g.get_main_budget());
            glist.add(g);
        }
        return glist;
    }
        //CREATING NORMAL GIRLS AND STORING THEM IN GIRLS ARRAYLIST
    public ArrayList<normal_girl> generate_normal_girls() throws IOException{
        ArrayList<normal_girl> glist=new ArrayList<normal_girl>();
        for(int j=0;j<5;++j){
            normal_girl g=new normal_girl();
            /* GENERATING ALL RANDOM VALUES*/
            g.set_name(randomIdentifier());
            g.set_att(ThreadLocalRandom.current().nextInt(5, 50 + 1));
            g.set_intl_level(ThreadLocalRandom.current().nextInt(20, 80 + 1));
            g.set_main_budget(ThreadLocalRandom.current().nextInt(1000, 10000 + 1));
            write_girls2.write_to_girls(g.get_name()+","+"normal"+","+g.get_att()+","+g.get_happiness()+","+g.get_intl_level()+","+g.get_intl_level()+","+g.get_main_budget());
            glist.add(g);
        }
        return glist;
    }
        //CREATING DESPERATE GIRLS AND STORING THEM IN GIRLS ARRAYLIST
    public ArrayList<desperate_girl> generate_desperate_girls() throws IOException{
        ArrayList<desperate_girl> glist=new ArrayList<desperate_girl>();
        for(int j=0;j<5;++j){
            desperate_girl g=new desperate_girl();
            /* GENERATING ALL RANDOM VALUES*/
            g.set_name(randomIdentifier());
            g.set_att(ThreadLocalRandom.current().nextInt(5, 50 + 1));
            g.set_intl_level(ThreadLocalRandom.current().nextInt(20, 80 + 1));
            g.set_main_budget(ThreadLocalRandom.current().nextInt(1000, 10000 + 1));
            write_girls2.write_to_girls(g.get_name()+","+"desperate"+","+g.get_att()+","+g.get_happiness()+","+g.get_intl_level()+","+g.get_intl_level()+","+g.get_main_budget());
            glist.add(g);
        }
        return glist;
    }
    
    public ArrayList<couple> CreateCouples(ArrayList<miser_boy> miser_boys,ArrayList<generous_boy> generous_boys,ArrayList<geeks_boy> geeks_boys, ArrayList<choosy_girl> choosy_girls,ArrayList<normal_girl> normal_girls,ArrayList<desperate_girl> desperate_girls) throws IOException{
        //METHOD TO CREATE COUPLES
        ArrayList<couple> c=new ArrayList<couple>();//IN THIS,COUPLES WILL BE STORED
        ArrayList<boy> blist=new ArrayList<boy>();//GETTING ALL BOYS IN ONE LIST
        ArrayList<girl> glist=new ArrayList<girl>();//GETTING ALL GIRLS IN ONE LIST
        for(miser_boy m : miser_boys){
            blist.add(m);//MISER BOYS IN BOYS LIST
        }
        for(generous_boy g : generous_boys){
            blist.add(g);//GENEROUS BOYS IN BOYS LIST
        }
        for(geeks_boy ge : geeks_boys){
            blist.add(ge);//GEEKS BOYS IN BOYS LIST
        }
        for(choosy_girl ch : choosy_girls){
            glist.add(ch);//CHOOSY GIRLS IN GIRLS LIST
        }
        for(normal_girl n : normal_girls){
            glist.add(n);// NORMAL GIRLS IN GIRLS LIST
        }
        for(desperate_girl d: desperate_girls){
            glist.add(d);//DESPERATE GIRLS IN GIRLS LIST
        }
        int flag;
        //CREATING COUPLES USING BOTH THE ABOVE LISTS
        for(girl g: glist){
            flag=0;
            for(boy b : blist){
                //COUPLE CONDITION DEPLOYED TO CREATE COUPLES
                if(g.get_main_budget()< b.get_budget() && g.get_att()>b.get_min_att_req() && b.get_status()==0){
                    flag=1;
                    couple co=new couple();
                    co.set_name(b.get_name(), g.get_name());
                    c.add(co);
                    b.set_status(1);
                    String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH_mm_ss").format(Calendar.getInstance().getTime());
                    write_file2.write_to_file(b.get_name()+" gets committed to"+g.get_name()+" at"+timeStamp);
                }
                if(flag==1)
                    break;
            }
        }
        return c;
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
           write_boys2.write_to_boys(i+1+","+b.get_name()+","+b.get_att()+","+b.get_budget()+","+b.get_intl_level()+","+b.get_min_att_req());
           boys.add(b);
       }
       for(int i=0;i<15;++i){
           girl g=new girl();
           g.set_name(randomIdentifier());
           g.set_att(ThreadLocalRandom.current().nextInt(5, 50 + 1));
           g.set_intl_level(ThreadLocalRandom.current().nextInt(20, 80 + 1));
           g.set_main_budget(ThreadLocalRandom.current().nextInt(1000, 10000 + 1));
           write_girls2.write_to_girls(i+1+","+g.get_name()+","+g.get_att()+","+g.get_main_budget()+","+g.get_intl_level());
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
                    String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH_mm_ss").format(Calendar.getInstance().getTime());
                    write_file2.write_to_file(b.get_name()+" gets committed to "+g.get_name()+" at"+ timeStamp);
                }
                if(flag==1)
                    break;
            }
        }
       return c;
   }
}
