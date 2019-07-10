public class 点点点表达式_可变参数 {

    public static void main(String[] args) {

        //   int[] a=new int[3];
        int i = add(1, 2, 3, 4);
        System.out.println(i);

    }

    //计算 n 个数的和
    public static int add(int... arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {

            sum = arr[i] + sum;
        }

        return sum;


    }
}
