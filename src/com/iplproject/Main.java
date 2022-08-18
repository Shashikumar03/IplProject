package com.iplproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static final int MATCH_ID = 0;
    public static final int SEASON = 1;
    public static final int CITY = 2;
    public static final int DATE = 3;
    public static final int TEAM1 = 4;
    public static final int TEAM2 = 5;
    public static final int TOSS_WINNER = 6;
    public static final int TOSS_DECISION = 7;
    public static final int RESULT = 8;
    public static final int DL_APPLIED = 9;
    public static final int WINNER = 10;
    public static final int WIN_BY_RUNS = 11;
    public static final int WIN_BY_WICKET = 12;
    public static final int PLAYER_OF_THE_MATCH = 13;
    public static final int VENUE = 14;
    //Delivery parts
    public static final int DEL_MATCH_ID = 0;
    public static final int INNINGS = 1;
    public static final int BATTING_TEAM = 2;
    public static final int BOWLING_TEAM = 3;
    public static final int OVER = 4;
    public static final int BALLS = 5;
    public static final int BATSMAN = 6;
    public static final int NON_STRIKER = 7;
    public static final int BOWLER = 8;
    public static final int EXTRA_RUNS = 16;
    public static final int TOTAL_RUNS = 17;
    public static final String year = "2016";

    public static void main(String[] args) {
        ArrayList<Match> matches = getTheDatafromMatch();
        ArrayList<Delivery> deliveries = getTheDatafromDeliveries();

        findNumberOfMatchesPlayedPerYear(matches);
        findNumberOfMatchesWonPerTeamInAllYear(matches);
        findExtraRunsConcededperTeamIn2016(matches, deliveries);
        findMostEconomicalBowlerIn2016(matches, deliveries);
        findMostSuccessfullTeamInIpl(matches);
    }

    public static ArrayList<Match> getTheDatafromMatch() {
        String path = "matches.csv";
        String line = "";
        ArrayList<Match> matchList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            br.readLine();
            while ((line = br.readLine()) != null) {
                Match match = new Match();
                String[] values = line.split(",");
                match.setMatchId(values[MATCH_ID]);
                match.setSeason(values[SEASON]);
                match.setCity(values[CITY]);
                match.setDate(values[DATE]);
                match.setTeam1(values[TEAM1]);
                match.setTeam2(values[TEAM2]);
                match.setTossWinner(values[TOSS_WINNER]);
                match.setTossDecision(values[TOSS_DECISION]);
                match.setResult(values[RESULT]);
                match.setDlApplied(values[DL_APPLIED]);
                match.setWinner(values[WINNER]);
                match.setWinByRuns(values[WIN_BY_RUNS]);
                match.setWinByWickets(values[WIN_BY_WICKET]);
                match.setPlayerOfMatch(values[PLAYER_OF_THE_MATCH]);
                match.setVenue(values[VENUE]);

                matchList.add(match);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return matchList;
    }

    public static ArrayList<Delivery> getTheDatafromDeliveries() {
        String path1 = "deliveries.csv";
        String line = "";
        ArrayList<Delivery> deliveryDataList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path1));
            br.readLine();
            while ((line = br.readLine()) != null) {
                Delivery delivery = new Delivery();
                String[] values = line.split(",");
                delivery.setDelMatchId(values[DEL_MATCH_ID]);
                delivery.setInnings(values[INNINGS]);
                delivery.setBattingTeams(values[BATTING_TEAM]);
                delivery.setBowlingTeams(values[BOWLING_TEAM]);
                delivery.setOver(values[OVER]);
                delivery.setBall(values[BALLS]);
                delivery.setBatsman(values[BATSMAN]);
                delivery.setNonStriker(values[NON_STRIKER]);
                delivery.setBowler(values[BOWLER]);
                delivery.setExtraRuns(values[EXTRA_RUNS]);
                delivery.setTotalRuns(values[TOTAL_RUNS]);
                deliveryDataList.add(delivery);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deliveryDataList;
    }

    //question1
    public static void findNumberOfMatchesPlayedPerYear(ArrayList<Match> matchesArrayList) {
        Map<String, Integer> totalMatcheshPlayed = new HashMap<>();
        for (Match match : matchesArrayList) {
            if (totalMatcheshPlayed.containsKey(match.getSeason())) {
                int count = totalMatcheshPlayed.get(match.getSeason());
                totalMatcheshPlayed.put(match.getSeason(), count + 1);
            } else {
                totalMatcheshPlayed.put(match.getSeason(), 1);
            }
        }
        System.out.println("total number of match played per year");
        System.out.println(totalMatcheshPlayed);

    }

    //question2
    public static void findNumberOfMatchesWonPerTeamInAllYear(ArrayList<Match> matchArrayList) {
        Map<String, Integer> MatchesWonHashMap = new HashMap<>();

        for (Match match : matchArrayList) {
            if (MatchesWonHashMap.containsKey(match.getWinner())) {
                int count = MatchesWonHashMap.get(match.getWinner());
                MatchesWonHashMap.put(match.getWinner(), count + 1);
            } else {
                MatchesWonHashMap.put(match.getWinner(), 1);
            }
        }
        System.out.println("total number of matches won by each team over all the year");
        System.out.println(MatchesWonHashMap);
    }

    //question3
    public static void findExtraRunsConcededperTeamIn2016(ArrayList<Match> matchList, ArrayList<Delivery> deliverList) {
        HashMap<String, Integer> extraRunHm = new HashMap<>();

        for (Match match : matchList) {

            for (Delivery delivery : deliverList) {

                if (match.getMatchId().equals(delivery.getDelMatchId()) && match.getSeason().equals(year)) {
                    if (extraRunHm.containsKey(delivery.getBattingTeams())) {
                        int exRunsAlreadyGiven = extraRunHm.get(delivery.getBattingTeams());
                        int extraRun = Integer.parseInt(delivery.getExtraRuns());
                        extraRunHm.put(delivery.getBattingTeams(), exRunsAlreadyGiven + extraRun);
                    } else {
                        extraRunHm.put(delivery.getBattingTeams(), Integer.parseInt(delivery.getExtraRuns()));
                    }
                }
            }

        }
        System.out.println("for the year 2016 total extra runs given by");
        System.out.println(extraRunHm);
    }

    //Question4
    public static void findMostEconomicalBowlerIn2016(ArrayList<Match> matchArrayList, ArrayList<Delivery> deliveryArrayList) {
        HashMap<String, Integer> totalRunsHm = new HashMap<>();
        HashMap<String, Integer> totalBallHm = new HashMap<>();

        for (Match match : matchArrayList) {
            for (Delivery delivery : deliveryArrayList) {
                if (match.getMatchId().equals(delivery.getDelMatchId()) && match.getSeason().equals("2015")) {
                    if (totalRunsHm.containsKey(delivery.getBowler())) {
                        int count = totalRunsHm.get(delivery.getBowler());
                        totalRunsHm.put(delivery.getBowler(), count + (Integer.parseInt(delivery.getTotalRuns())));
                        totalBallHm.put(delivery.getBowler(), count + 1);

                    } else {
                        totalRunsHm.put(delivery.getBowler(), Integer.parseInt(delivery.getTotalRuns()));
                        totalBallHm.put(delivery.getBowler(), 1);
                    }
                }
            }
        }
        System.out.println("for the year 2015 the top economical bowler");
        System.out.println(" Bowler Name " + " Total runs Givens in the season " + "  total ball throw  " + "  economy");
        for (String str : totalRunsHm.keySet()) {

            if (totalBallHm.containsKey(str)) {
                int runs = totalRunsHm.get(str);
                int totalball = totalBallHm.get(str);
                double economy = (double) (runs * 6) / totalball;
                //  System.out.println(str+"\t\t\t"+runs+"\t\t\t"+totalball+"\t\t\t" + "\t\t\t"+economy);
                System.out.printf("%s %d %d %.2f\n", str, runs, totalball, economy);
            }
        }

    }

    //question5
    public static void findMostSuccessfullTeamInIpl(ArrayList<Match> matchArrayList) {
        HashMap<String, Integer> mostSuccessTeam = new HashMap<>();
        for (Match match : matchArrayList) {
            if (mostSuccessTeam.containsKey(match.getWinner())) {
                int count = mostSuccessTeam.get(match.getWinner());
                mostSuccessTeam.put(match.getWinner(), count + 1);
            } else {
                mostSuccessTeam.put(match.getWinner(), 1);

            }
        }

        int total = 0;
        for (Match match : matchArrayList) {
            if (match.getTeam1().equals("Mumbai Indians") || match.getTeam2().equals("Mumbai Indians")) {
                total = total + 1;
            }
        }

        int MostWon = Integer.MIN_VALUE;
        String teamName = "";
        for (String str : mostSuccessTeam.keySet()) {
            if (mostSuccessTeam.get(str) > MostWon) {
                MostWon = mostSuccessTeam.get(str);
                teamName = str;
            }
        }
        System.out.println("-------------question 5-----------------------------------------------");
        System.out.println("Most successful Team Of IPL is " + teamName + " won " + MostWon + "  matches of "
                + total + " total matches played");
    }
}
