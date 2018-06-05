import java.util.*;

public class Design_Snake_Game_353 {
    /*
    🐍的身体存在hashset中，用来判断有没有撞到自己，走路的格子存在dq中，进一格退一格
     */
        int foodIndex;
        Set<Integer> set;
        Deque<Integer> dq;
        int score;
        int[][] food;
        int width;
        int height;
        /** Initialize your data structure here.
         @param width - screen width
         @param height - screen height
         @param food - A list of food positions
         E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
        public Design_Snake_Game_353(int width, int height, int[][] food) {
            this.height = height;
            this.width = width;
            this.food = food;
            this.set = new HashSet<>();
            this.dq = new ArrayDeque<>();
            this.score = 0;
            this.foodIndex = 0;
            set.add(0);//第一个位置
            dq.offerFirst(0);
        }

        /** Moves the snake.
         @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
         @return The game's score after the move. Return -1 if game over.
         Game over when snake crosses the screen boundary or bites its body. */
        public int move(String direction) {
            if(score == -1) return -1;
            int idx = dq.peekFirst();
            int rowHead = idx / width;
            int colHead = idx % width;
            switch (direction){
                case "U":
                    rowHead--;
                    break;
                case "D":
                    rowHead++;
                    break;
                case "L":
                    colHead--;
                    break;
                default:
                    colHead++;
                    break;
                //默认向右走
            }
            int newindex = rowHead * width + colHead;
            set.remove(dq.peekLast());
            //先从set中移去，如果要长度加一的话，就把原来的尾部再加回来，所以deque先不能删尾部
            if(rowHead < 0 || rowHead == height || colHead < 0 || colHead == width || set.contains(newindex)){
                return -1;
            }
            dq.offerFirst(newindex);
            set.add(newindex);
            if(foodIndex < food.length && rowHead == food[foodIndex][0] && colHead == food[foodIndex][1]){
                score++;
                foodIndex++;
                set.add(dq.peekLast());
                return score;
            }
            dq.pollLast();//把尾巴删掉
            return score;
        }
}
