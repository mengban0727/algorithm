package array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author zhangjie
 */
public class TopKFrequent {

  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> countMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (countMap.containsKey(nums[i])) {
        countMap.put(nums[i], countMap.get(nums[i]) + 1);
      } else {
        countMap.put(nums[i], 1);
      }
    }

    PriorityQueue<Integer> queue = new PriorityQueue<>(k,
        Comparator.comparingInt(countMap::get));

    for (Integer key : countMap.keySet()) {
      if (queue.size() < k) {
        queue.add(key);
      } else {
        if (countMap.get(queue.peek()) < countMap.get(key)) {
          queue.remove();
          queue.add(key);
        }
      }
    }

    int[] result = new int[queue.size()];
    int i = 0;
    while (!queue.isEmpty()) {
      result[i++] = queue.remove();
    }
    return result;
  }
}
