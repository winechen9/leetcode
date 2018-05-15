import java.util.*;
public class Insert_Delete_GetRandom_O1_380 {
    /*
    Design a data structure that supports all following operations in average O(1) time.

    insert(val): Inserts an item val to the set if not already present.
    remove(val): Removes an item val from the set if present.
    getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
    Example:

    // Init an empty set.
    RandomizedSet randomSet = new RandomizedSet();

    // Inserts 1 to the set. Returns true as 1 was inserted successfully.
    randomSet.insert(1);

    // Returns false as 2 does not exist in the set.
    randomSet.remove(2);

    // Inserts 2 to the set, returns true. Set now contains [1,2].
    randomSet.insert(2);

    // getRandom should return either 1 or 2 randomly.
    randomSet.getRandom();

    // Removes 1 from the set, returns true. Set now contains [2].
    randomSet.remove(1);

    // 2 was already in the set, so return false.
    randomSet.insert(2);

    // Since 2 is the only number in the set, getRandom always return 2.
    randomSet.getRandom();
     */
    Map<Integer, Integer> map;
    List<Integer> list;
    //int index;
    Random rmd;
    /** Initialize your data structure here. */
    public Insert_Delete_GetRandom_O1_380() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        //this.index = 0;
        this.rmd = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            list.add(val);
            map.put(val, list.size() - 1);
            //index++;
        }else return false;
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)){
            int i = map.remove(val);
            int size = list.size();
            int j = list.remove(size - 1);//只能删最后一个，否则remove(index)的复杂度是O(n)
            if (i != size - 1){
                list.set(i, j);
                map.put(j, i);
            }
        }else return false;
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rmd.nextInt(list.size()));
    }
}

