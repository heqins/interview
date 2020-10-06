import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 牛客合并区间 {
    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<>();

        Collections.sort(intervals, (o1, o2) -> o1.start - o2.start);

        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start < intervals.get(i - 1).end) {
                intervals.get(i).start = intervals.get(i - 1).start;
                intervals.get(i).end = Math.max(intervals.get(i - 1).end, intervals.get(i).end);
            }else {
                res.add(intervals.get(i - 1));
            }
        }

        res.add(intervals.get(intervals.size() - 1));

        return res;
    }

    public static void main(String[] args) {
        ArrayList<Interval> list = new ArrayList<>();
        list.add(new Interval(40, 70));
        list.add(new Interval(20, 60));
        list.add(new Interval(80, 100));
        merge(list);
    }
}
