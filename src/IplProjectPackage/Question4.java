package IplProjectPackage;

import java.util.ArrayList;
import java.util.HashMap;

public class Question4
{
    void topEconicalBower(ArrayList<MatchesModel> match_al,ArrayList<DeliveriesModel> deliver_al)
    {
        HashMap<String,Integer> hm= new HashMap<>();
        HashMap<String,Integer> hm1= new HashMap<>();

        for(MatchesModel mm:match_al)
        {

            for (DeliveriesModel dm : deliver_al)
            {
                if(mm.getMatch_id().equals(dm.getDel_match_idMatch_id())&& mm.getSeason().equals("2015"))
                {
                    if(hm.containsKey(dm.getBowler()))
                    {
                        int c=hm.get(dm.getBowler());
                        hm.put(dm.getBowler(),c+(Integer.parseInt(dm.getTotal_runs())));
                        int n=hm1.get(dm.getBowler());
                        hm1.put(dm.getBowler(),c+1);
                    }
                    else
                    {
                        hm.put(dm.getBowler(),Integer.parseInt(dm.getTotal_runs()));
                        hm1.put(dm.getBowler(),1);
                    }

                }
            }
        }
        System.out.println("-----------------Question4------");


        System.out.println("for the year 2015 the top economical bowler");
        System.out.println(" Bowler Name "+" Total runs Givens in the season "+"  total ball throw  "+"  economy");
        float f=Integer.MAX_VALUE;
        String ss="";
        for(String str:hm.keySet())
        {
            if(hm1.containsKey(str))
            {
                int runs=hm.get(str);
                int totalball= hm1.get(str);
                float e=(float)(runs*6)/totalball;
                System.out.println(str+"\t\t\t"+runs+"\t\t\t"+totalball+"\t\t\t" + "\t\t\t"+e);
                if(e<f)
                {
                    f=e;
                    ss=str;
                }
            }
        }


        System.out.println("Best bowler of 2015 was "+ ss+ " with an economy of "+f);
    }
}
