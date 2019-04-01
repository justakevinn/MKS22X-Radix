public class Radix{

  public static void radixsort(int[]data){
    return;
  }


  private static int digits(Integer num){
    int d = 1;
    while (num > 9){
      num = num / 10;
      d ++;
    }
    return d;
  }



  public static void main(String args[]){
    System.out.println(digits(102));
    System.out.println(digits(112415));
    System.out.println(digits(1023));
    System.out.println(digits(12));
    System.out.println(digits(2));

  }
}
