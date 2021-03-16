import java.util.Random;

public class homework2 {
    // 1. целочисленный массив, состоящий из элеменов 0 и 1  ; в цикле заменить 0 на 1, 1 на 0
    public static void main(String[] args) {

        System.out.println("////////////// задание 1 //////////////////");
        int[] arr1 = new int[] {1,1,0,0,1,0,1,1,0,0};
        massivIntPrintln(arr1);
        for (int i=0;i<arr1.length;i++)
                        arr1[i] = arr1[i]==0 ? 1 : 0;

        massivIntPrintln(arr1);

        System.out.println("////////////// задание 2 //////////////////");
        int[] arr2 = new int[8];
        massivIntPrintln(arr2);

        for (int i=0;i<arr2.length;i++) arr2[i]=i*3;
        massivIntPrintln(arr2);

        System.out.println("////////////// задание 3 //////////////////");

        int[] arr3 = new int[] { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i=0;i<arr3.length;i++) System.out.print(arr3[i] + " ");
        System.out.println();
        for (int i=0;i<arr3.length;i++)
                         if (arr3[i]<6) arr3[i]*=2;       //arr3[i]= arr3[i]<6 ? arr3[i]*2 : arr3[i];
        massivIntPrintln(arr3);



        System.out.println("////////////// задание 4 //////////////////");
        System.out.println("создаем квадратный двухмерный массив");
        int[][] arr4;
        arr4 = createmassiv2Drandom(5);
        massiv2DIntPrintln(arr4);

        massiv2DIntModifyDiagonal(arr4);
        System.out.println("после замены  всех диагональных элементов:");
        massiv2DIntPrintln(arr4);


        System.out.println("////////////// задание 5 //////////////////");

        int[] arr5;
        arr5 = createmassivrandom(20);
        massivIntPrintln(arr5);
        System.out.println("MIN значение массива :"+ minelement(arr5));
        System.out.println("MAX значение массива :"+ maxelement(arr5));

        System.out.println("////////////// задание 6 //////////////////");

        int[] arr61 = new int[] {10,0,0,2,2,4,2,2,1,1};
        int[] arr62 = createmassivrandom(10,10);
        massivIntPrintln(arr61);
        System.out.println("checkbalance -> " + checkbalance(arr61));
        massivIntPrintln(arr62);
        System.out.println("checkbalance -> " + checkbalance(arr62));

        System.out.println("////////////// задание 7 //////////////////");

        int[] arr73 = new int[]{1,2,3};
        int[] arr74 = new int[]{3,5,6,1};
        int[] arr75 = new int[]{1,2,3,4,5,6,7,8,9,10};


        massivIntPrintln(arr73);
        massivIntPrintln(arr74);
        massivIntPrintln(arr75);

        straifmassiv(arr73,1);
        straifmassiv(arr74,-2);
        straifmassiv(arr75,3);

        massivIntPrintln(arr73);
        massivIntPrintln(arr74);
        massivIntPrintln(arr75);



    }

    static void straifmassiv(int[] m,int n) {
        n = n > m.length ? n % m.length : n;
        int i;
        int buff = 0;
        if (n > 0) {//сдвиг вправо
            i = 1;
            while (i <= n) {
                buff = m[m.length - 1];
                for (int z = m.length - 2; z >= 0; z--)
                         m[z + 1] = m[z];
                m[0] = buff;

                i++;
            }

        }
        if (n < 0) {//сдвиг влево
            i = -1;
            while (i >= n) {
                buff = m[0];
                for (int z = 1; z <= m.length - 1; z++) m[z - 1] = m[z];
                m[m.length - 1] = buff;


                i--;
            }



        }

    }


    static boolean checkbalance(int[] massiv) {
       int i=0;
       int sum1,sum2;

        while (i<massiv.length) {sum1=0;sum2=0;
                    for(int a=0;a<i;a++) sum1+=massiv[a];
                    for(int z=massiv.length-1;z>=i;z--) sum2+=massiv[z];
                    if (sum1==sum2) return true;
            i++;
        }

        return false;
    }
    static void massivIntPrintln(int[] massiv){
        for (int i=0;i< massiv.length;i++) System.out.print(massiv[i] + " ");
        System.out.println();
    }
    static void massiv2DIntPrintln(int[][] massiv){
        for(int i=0;i<massiv.length;i++) {
            for(int j=0;j<massiv[i].length;j++){
                System.out.print(massiv[i][j] + " ");

            }
            System.out.println();
        }

    }

    static void massiv2DIntModifyDiagonal(int[][] massiv){
        for(int i=0;i<massiv.length;i++) {
            for(int j=0;j<massiv[i].length;j++){
                if(i==j||((i+j)==massiv.length-1)) { massiv[i][j]=1;

                }

            }

        }

    }


    static int[] createmassivrandom(int n){
        int[] massiv = new int[n];
        for(int i=0;i<massiv.length;i++) {
            massiv[i]= (int)(Math.random()*100);
        }
        return massiv;
    }
    static int[] createmassivrandom(int n,int diap){
        int[] massiv = new int[n];
        for(int i=0;i<massiv.length;i++) {
            massiv[i]= (int)(Math.random()*diap);
        }
        return massiv;
    }


    static int[][] createmassiv2Drandom(int n){
        int[][] massiv = new int[n][n];
        for(int i=0;i<massiv.length;i++) {
            for(int j=0;j<massiv[i].length;j++){
                massiv[i][j] = (int)(Math.random()*10);
            }

        }
        return massiv;
    }

    static int maxelement(int[] massiv) {
        int max,i;
        i=0;
        max  = Integer.MIN_VALUE;;
        while (i<massiv.length) {
            if (massiv[i]>max) max = massiv[i];
            i++;
        }
        return max;
    }
    static int minelement(int[] massiv) {
        int min,i;
        i=0;
        min = Integer.MAX_VALUE;
        while (i<massiv.length) {
            if (massiv[i]<min) min = massiv[i];
            i++;
        }
        return min;
    }

}
