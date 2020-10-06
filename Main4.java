import java.util.*;
public class Main4 {
    class Pair<A, B> {
        public final A first;
        public final B second;
        public Pair(A a, B b){
            first = a;
            second = b;
        }
        public Pair(Pair<A,B> p){
            first = p.first;
            second = p.second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(first, pair.first) &&
                    Objects.equals(second, pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }

    public int[][] countIsland(int[][] grid,int n, int m) {
        int[][] direction={{-1,0},{0,-1},{1,0},{0,1}};
        boolean[][] visited= new boolean[n][m];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==-1){
                    Queue<Pair> queue = new LinkedList<>();
                    HashSet<Pair> set = new HashSet<>();
                    HashSet<Pair> neighbours = new HashSet<>();
                    queue.offer(new Pair(i,j));
                    visited[i][j]=true;
                    grid[i][j]=-2;
                    set.add(new Pair(i,j));
                    while(!queue.isEmpty()){
                        Pair<Integer,Integer> cur=queue.poll();
                        for(int k=0;k<4;k++){
                            int x=cur.first+direction[k][0];
                            int y=cur.second+direction[k][1];
                            if(x>=0 && x<n && y>=0 && y<m){
                                if(grid[x][y]==-1 && !visited[x][y]){
                                    queue.offer(new Pair(x,y));
                                    visited[x][y]=true;
                                    grid[x][y]=-2;
                                    set.add(new Pair(x,y));
                                }
                                else if(grid[x][y]>=0){
                                    neighbours.add(new Pair(x,y));
                                }
                            }
                        }
                    }
                    int ave=0;
                    for(Pair<Integer,Integer> cor:neighbours){
                        ave+=grid[cor.first][cor.second];
                    }
                    ave/=neighbours.size();
                    for(Pair<Integer,Integer> cor:set){
                        grid[cor.first][cor.second]=ave;
                    }
                }
            }
        }
        return grid;
    }


    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        String[] line=in.nextLine().split(" ");
        int n=Integer.parseInt(line[0]);
        int m=Integer.parseInt(line[1]);
        int[][] image=new int[n][m];
        ArrayList<int[]> noise = new ArrayList<>();
        for(int i=0;i<n;i++){
            line=in.nextLine().split(" ");
            for(int j=0;j<m;j++){
                image[i][j]=Integer.parseInt(line[j]);
            }
        }
        int[][] res=new Main4().countIsland(image,n,m);
        for(int i=0;i<n;i++){
            for(int j=0;j<m-1;j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println(res[i][m-1]);
        }

    }
}