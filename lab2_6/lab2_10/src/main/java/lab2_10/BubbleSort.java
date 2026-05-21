package lab2_10;

public class BubbleSort {
    public static void main(String[] args) {
        int[] m = {1,4,6,2,5,3};
        sort(m);
        for (int i: m) System.out.print(i+" ");

    }

    public static void sort(int[] massiv) {
        for (int i=0; i<massiv.length-1; i++) {
            for (int j=0; j<massiv.length-i-1;j++) {
                if (massiv[j]>massiv[j+1]) {
                    int a = massiv[j];
                    massiv[j]=massiv[j+1];
                    massiv[j+1]=a;
                }
            }
        }
    }
}
