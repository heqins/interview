public class 牛客进制转换 {
    public String solve (int M, int N) {
        // write code here
        if(M == 0) return "0";
        boolean flag = true;
        if(M < 0){
            M = - M;
            flag = false;
        }
        StringBuffer res = new StringBuffer();
        String hex = "0123456789ABCDEF";
        while(M != 0){
            res.append(hex.charAt(M % N));
            M = M / N;
        }
        return flag == true ? res.reverse().toString() : "-"+res.reverse().toString();
    }
}
