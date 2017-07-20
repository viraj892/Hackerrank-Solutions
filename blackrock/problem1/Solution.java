package blackrock.problem1;
import java.util.*;
public class Solution {
	static String electionWinner(String[] votes) {
        Map<String, Integer> ballot = new TreeMap<String, Integer>();
        for(String vote : votes){
                if(ballot.containsKey(vote))
                        ballot.replace(vote, ballot.get(vote)+1);
                else
                        ballot.put(vote, 1);
        }
        Map.Entry<String, Integer> maxEntry = null;
        for(Map.Entry<String, Integer> entry : ballot.entrySet()){
                if(maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
                        maxEntry = entry;
         }
         Integer maxVotes=maxEntry.getValue();
         List<String> topNames = new ArrayList<String>();
         for (Map.Entry<String, Integer> entry : ballot.entrySet()) {
                if (entry.getValue().equals(maxVotes)) {
                        topNames.add(entry.getKey());
                }
         }
         topNames.sort(String::compareToIgnoreCase);
         return topNames.get(topNames.size()-1);
         

    }
}
