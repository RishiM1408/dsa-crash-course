package com.dsa.sorting;

import java.util.*;

/**
 * Rank Teams by Votes (LeetCode 1366)
 * 
 * In a special ranking system, each voter gives a rank from highest to lowest
 * to all teams participated in the competition.
 * The ordering of teams is decided by who received the most position-one votes.
 * If two or more teams tie in the first position,
 * we consider the second position to resolve the conflict, if they tie again,
 * we continue this process until the ties are resolved.
 * If two or more teams are still tied after considering all positions, we rank
 * them alphabetically.
 */
public class RankTeamsByVotes {

    public String rankTeams(String[] votes) {
        Map<Character, int[]> map = new HashMap<>();
        int l = votes[0].length();
        for (String vote : votes) {
            for (int i = 0; i < l; i++) {
                char c = vote.charAt(i);
                map.putIfAbsent(c, new int[l]);
                map.get(c)[i]++;
            }
        }

        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> {
            for (int i = 0; i < l; i++) {
                if (map.get(a)[i] != map.get(b)[i]) {
                    return map.get(b)[i] - map.get(a)[i];
                }
            }
            return a - b;
        });

        StringBuilder sb = new StringBuilder();
        for (char c : list)
            sb.append(c);
        return sb.toString();
    }
}
