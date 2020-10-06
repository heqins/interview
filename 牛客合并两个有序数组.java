public class 牛客合并两个有序数组 {
    public void merge(int A[], int m, int B[], int n) {
        int i = m-1, j = n-1;
        while(i>=0 && j>=0)
            A[i+j+1] = A[i]>B[j]?A[i--]:B[j--];
        while(j>=0) A[j] = B[j--]; // 只需要考虑B尚未空的情况
    }
}
