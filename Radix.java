//Missed a few class days and lab days. Completed with the help of Jackson Zou

@SuppressWarnings("unchecked")

public class Radix{

  public static void radixsort(int[] data){
    int runs = 0;
    for (int x = 0; x < data.length; x++){
      if (runs < digits(data[x])){
        runs = digits(data[x]);
      }
    }
    int[] result = new int[data.length];
    MyLinkedList<Integer>[] buckets = new MyLinkedList[10];

    for (int i = 0; i < buckets.length; i++){
      buckets[i] = new MyLinkedList<Integer>();
    }

    for (int i = 0; i < data.length; i++){
      int x = data[i] % 10;
      //    System.out.println(x);
      buckets[x].add(data[i]);
      //  System.out.println(buckets[x].toString());
    }

    for (int i = 0; i < 19; i++) {
      if (buckets[i].size() != 0) {
        buckets[19].extend(buckets[i]);
      }
    }
    int place = 1;
    while (place <= runs) {
      while (buckets[19].size() > 0) {
        int num = buckets[19].removeFront();
        int digit = (num / exp(10,place)) % 10;
        buckets[digit+9].add(num);
      }
      for (int i = 0; i < 19; i++) {
        if (buckets[i].size() != 0) {
          buckets[19].extend(buckets[i]);
        }
      }
      place++;
    }
    for (int i = 0; i < data.length; i++) {
      data[i] = buckets[19].removeFront();
    }

  }


  private static int digits(int num){
    int d = 1;
    while (num > 9){
      num = num / 10;
      d ++;
    }
    return d;
  }

  private static int findLongest(int[] data){
    int max = Math.abs(data[0]);
    for (int x = 1; x < data.length; x++){
      if (Math.abs(data[x]) > max){
        max = data[x];
      }
    }
    return max;
  }

  public static int exp(int base, int expo) {
    int x = 1;
    while (expo > 0) {
      x *= base;
      expo--;
    }
    return x;
  }

  public static void main(String args[]){
    int[] ary = new int[]{231, 23, 1246, 72, -21,321,13,46,87,23,86,36};
    System.out.println(Arrays.toString(ary));
    Radix.radixsort(ary);
    System.out.println(Arrays.toString(ary));
  }

}
