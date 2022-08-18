package IplProjectPackage;

import java.util.*;

public class Question4
{
    void topEconicalBower(ArrayList<MatchesModel> match_al,ArrayList<DeliveriesModel> deliver_al)
    {
        HashMap<String,Integer> hm_totalRuns= new HashMap<>();
        HashMap<String,Integer> hm_totalBalls= new HashMap<>();
       // HashMap<String,Double> economy= new HashMap<>();


        for(MatchesModel mm:match_al)
        {

            for (DeliveriesModel dm : deliver_al)
            {
                if(mm.getMatch_id().equals(dm.getDel_match_idMatch_id())&& mm.getSeason().equals("2015"))
                {
                    if(hm_totalRuns.containsKey(dm.getBowler()))
                    {
                        int c=hm_totalRuns.get(dm.getBowler());
                        hm_totalRuns.put(dm.getBowler(),c+(Integer.parseInt(dm.getTotal_runs())));
                        int n=hm_totalBalls.get(dm.getBowler());
                        hm_totalBalls.put(dm.getBowler(),c+1);

                    }
                    else
                    {
                        hm_totalRuns.put(dm.getBowler(),Integer.parseInt(dm.getTotal_runs()));
                        hm_totalBalls.put(dm.getBowler(),1);
                    }

                }
            }
        }
        System.out.println("-----------------Question4------");


        System.out.println("for the year 2015 the top economical bowler");
        System.out.println(" Bowler Name "+" Total runs Givens in the season "+"  total ball throw  "+"  economy");
        for(String str:hm_totalRuns.keySet())
        {

            if(hm_totalBalls.containsKey(str))
            {
                int runs=hm_totalRuns.get(str);
                int totalball= hm_totalBalls.get(str);
                double economy=(double)(runs*6)/totalball;
               // economy.put(str,e);

             //  System.out.println(str+"\t\t\t"+runs+"\t\t\t"+totalball+"\t\t\t" + "\t\t\t"+economy);
                System.out.printf("%s %d %d %.2f\n",str,runs,totalball,economy);

            }
        }


//       Set<Map.Entry<String,Double>> entrySet= economy.entrySet();
//        List<Map.Entry<String,Double>> sortedList= new ArrayList<>(entrySet);
//        Collections.sort(sortedList,(val1,val2) -> val1.getValue().compareTo(val2.getValue()));
//
//
//        for (int i=0;i<10;i++)
//        {
//            System.out.println(sortedList.get(i));
//        }




        //System.out.println("Best bowler of 2015 was "+ ss+ " with an economy of "+f);
    }
}
