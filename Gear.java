import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public  class Gear{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<String> list=new ArrayList<>();
        while(sc.hasNext()){
            String temp=sc.nextLine();
            String str=sc.nextLine();
            list.add(str);
        }
        for(String s:list){
            int res=1;
            for(int i=0;i<s.length();i++){
                res+=count(s,i);
            }
            System.out.println(res);
        }

    }

    static  int count(String str,int index){
        if(index==0){
            if(str.charAt(0)=='Z'||(str.length()>=2&&str.charAt(1)=='A')){
                return 0;
            }else{
                return 1;
            }
        }else if(index==str.length()-1){
            if(str.charAt(index)=='Z'||(str.length()-2>=0&&str.charAt(index-1)=='A')){
                return 0;
            }else{
                return 1;
            }
        }else {
            int res=0;
            if(str.charAt(index)=='Z')  return 0;
            if(str.charAt(index-1)!='A') res++;
            if(str.charAt(index+1)!='A') res++;
            return res;
        }
    }
}