package IplProjectPackage;

import java.util.*;

public class Question1
{

    public  void totalMatchPalyed(ArrayList<MatchesModel> al)
    {
        Map<String,Integer> hm= new HashMap<>();

        for(MatchesModel m:al)
        {
            if(hm.containsKey(m.getSeason()))
            {
                int count=hm.get(m.getSeason());
                hm.put(m.getSeason(),count+1);
            }
            else
            {
                hm.put(m.getSeason(),1);
            }
        }

        System.out.println("total number of match played per year");
        for(String s:hm.keySet())
        {

            System.out.println(s+"-"+hm.get(s)+" ");
        }
        System.out.println("-----------------------------------------------------------------------------------------------------");


    }
}
