package sort;

/**
 * 桶排序
 * @author zhangjie
 */
public class BucketSort {
  public static void bucketSort(int []arr,int bucketSize){
    if(arr.length<2){
      return;
    }

    int minValue = arr[0];
    int maxValue = arr[1];

    for(int i = 0; i < arr.length; i++){
      if(arr[i]<minValue){
        minValue = arr[i];
      }

      if(arr[i]>maxValue){
        maxValue = arr[i];
      }
    }

    int bucketCount = (maxValue-minValue)/bucketSize;
    int [][]buckets = new int[bucketCount][bucketSize];

    //存储每个桶当前位置下标
    int[] indexArr = new int[bucketCount];

    for(int i = 0; i < arr.length; i++){
      //计算放到哪个桶
      int bucketIndex =(arr[i]-minValue)/bucketSize;

      //如果桶装满了扩容
      if(indexArr[bucketIndex]==buckets[bucketIndex].length){
        ensureCapacity(buckets,bucketIndex);
      }
      buckets[bucketIndex][indexArr[bucketIndex]++] = arr[i];
    }

    //每个桶进行排序
    int k = 0;
    for(int i = 0 ; i < bucketCount; i++){
      if(indexArr[i]==0){
        continue;
      }
      //快排
      quickSort(buckets[i],0,indexArr[i]-1);

      for(int j = 0 ; j < indexArr[i]; j++){
        arr[k++] = buckets[i][j];
      }
    }
  }

  private static void quickSort(int[] bucket, int i, int i1) {
  }

  private static void ensureCapacity(int[][] buckets, int bucketIndex) {
  }
}
