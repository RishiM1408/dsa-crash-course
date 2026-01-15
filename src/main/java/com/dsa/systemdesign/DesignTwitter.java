package com.dsa.systemdesign;

import java.util.*;

/**
 * LeetCode 355: Design Twitter
 *
 * Pattern: HashMap + Heap (Merge K Sorted Lists Logic)
 * 1. Post Tweet: User -> List<Tweet>
 * 2. Get Feed: Merge (User + Followees) tweets using Max Heap.
 * 3. Follow/Unfollow: User -> Set<Followee>
 */
public class DesignTwitter {

    private static int timeStamp = 0;

    private class Tweet {
        int id;
        int time;
        Tweet next; // Linked list node

        public Tweet(int id) {
            this.id = id;
            this.time = timeStamp++;
            this.next = null;
        }
    }

    private class User {
        int id;
        Set<Integer> followed;
        Tweet head;

        public User(int id) {
            this.id = id;
            followed = new HashSet<>();
            followed.add(id); // Follow self
            head = null;
        }

        public void post(int id) {
            Tweet t = new Tweet(id);
            t.next = head;
            head = t;
        }

        public void follow(int id) {
            followed.add(id);
        }

        public void unfollow(int id) {
            if (id != this.id)
                followed.remove(id);
        }
    }

    private Map<Integer, User> userMap;

    public DesignTwitter() {
        userMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        userMap.putIfAbsent(userId, new User(userId));
        userMap.get(userId).post(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> info = new ArrayList<>();
        if (!userMap.containsKey(userId))
            return info;

        Set<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> (b.time - a.time));

        for (int u : users) {
            User user = userMap.get(u);
            if (user != null && user.head != null) {
                pq.offer(user.head);
            }
        }

        int n = 0;
        while (!pq.isEmpty() && n < 10) {
            Tweet t = pq.poll();
            info.add(t.id);
            n++;
            if (t.next != null) {
                pq.offer(t.next);
            }
        }
        return info;
    }

    public void follow(int followerId, int followeeId) {
        userMap.putIfAbsent(followerId, new User(followerId));
        userMap.putIfAbsent(followeeId, new User(followeeId));
        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || followerId == followeeId)
            return;
        userMap.get(followerId).unfollow(followeeId);
    }

    public static void main(String[] args) {
        DesignTwitter twitter = new DesignTwitter();

        twitter.postTweet(1, 5);
        List<Integer> feed = twitter.getNewsFeed(1);
        System.out.println("Feed 1: " + (feed.toString().equals("[5]") ? "PASS" : "FAIL"));

        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        feed = twitter.getNewsFeed(1);
        System.out.println("Feed 2: " + (feed.toString().equals("[6, 5]") ? "PASS" : "FAIL"));

        twitter.unfollow(1, 2);
        feed = twitter.getNewsFeed(1);
        System.out.println("Feed 3: " + (feed.toString().equals("[5]") ? "PASS" : "FAIL"));
    }
}
