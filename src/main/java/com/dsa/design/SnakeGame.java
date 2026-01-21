package com.dsa.design;

import java.util.*;

/**
 * Design Snake Game (LeetCode 353)
 *
 * Design a Snake game that is played on a device with screen size = width x
 * height.
 * The snake is initially positioned at the top left corner (0,0) with length =
 * 1 unit.
 * You are given a list of food's positions in row-column order. When a snake
 * eats the food,
 * its length and the game's score both increase by 1.
 */
public class SnakeGame {

    private Set<Integer> snakeMap; // Fast lookup for collision
    private Deque<Integer> snakeBody; // Order of body parts
    private int width;
    private int height;
    private int[][] food;
    private int foodIndex;
    private int score;

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        this.foodIndex = 0;
        this.score = 0;
        this.snakeMap = new HashSet<>();
        this.snakeBody = new ArrayDeque<>();

        // Initial snake at 0,0
        snakeBody.offerLast(0);
        snakeMap.add(0);
    }

    /**
     * Moves the snake.
     * 
     * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     * @return The game's score after the move. Return -1 if game over.
     */
    public int move(String direction) {
        if (score == -1)
            return -1;

        int head = snakeBody.peekLast(); // Current head
        int r = head / width;
        int c = head % width;

        if (direction.equals("U"))
            r--;
        else if (direction.equals("D"))
            r++;
        else if (direction.equals("L"))
            c--;
        else if (direction.equals("R"))
            c++;

        // Boundary Check
        if (r < 0 || r >= height || c < 0 || c >= width)
            return -1;

        int newHead = r * width + c;

        // Tail movement logic
        // Case 1: Eat food -> Tail stays (grow)
        // Case 2: No food -> Tail moves (remove tail, check newHead collision)

        // Check collision (removed tail first to allow chasing tail)
        int tail = snakeBody.peekFirst();

        if (foodIndex < food.length && food[foodIndex][0] == r && food[foodIndex][1] == c) {
            score++;
            foodIndex++;
        } else {
            snakeBody.pollFirst();
            snakeMap.remove(tail);
        }

        // Self Collision Check
        if (snakeMap.contains(newHead)) {
            return -1;
        }

        snakeBody.offerLast(newHead);
        snakeMap.add(newHead);

        return score;
    }
}
