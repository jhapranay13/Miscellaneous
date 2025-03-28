package elementsOfProgramming.Sorting;

import java.util.ArrayList;
import java.util.List;
//Simalar to MergingIntervals after sorting...just take care of rules for open and closed ended time.
class Interval {
	int startTime;
	int endTime;
	boolean isStartClosed;
	boolean isEndClosed;
	
	public Interval(int startTime, int endTime, boolean isStartClosed, boolean isEndClosed) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.isStartClosed = isStartClosed;
		this.isEndClosed = isEndClosed;
	}
}

public class UnionOfIntervalsOpenOrClosedEnded {

	public static void main(String[] args) {
		Interval[] intervals = {  
				new Interval(0, 3, false, false),
				new Interval(1, 1, true, true),
				new Interval(3, 4, true, false),
				new Interval(2, 4, true, true),
				new Interval(5, 7, true, false),
				new Interval(9, 11, false, true),
				new Interval(7, 8, true, false),
				new Interval(8, 11, true, false),
				new Interval(13, 15, false, false),
				new Interval(12, 16, false, true),
				new Interval(12, 14, true, true),
				new Interval(16, 17, false, false)
		};
		List< Interval > result = new ArrayList<>();
		//unionIntervals( intervals );
	}

}
