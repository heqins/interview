public class 牛客求平方根 {
    public int sqrt (int x) {
        // write code here
        if(x <=1) return x;
        // write code here
        //r*r = x; -> x/r = r
        int l = 0;
        int r = x;
        while (l <= r) {
            int m =l + (r-l)/2 ;
            if (m == (int)(x/m) ) return m;
            else if (m <x/m) {
                l = m+1;
            }else {
                r = m-1;
            }


        }
        return r;
    }
}
