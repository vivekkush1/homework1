
public class HWobject {
	public int id;
	public int lab_ex;
	public int[] hw;
	public int midterm;
	public int finl;
	public int extralab;
	public static int max = 0;
	public static int total_pct = 0;
	public static int NoOfA = 0;
	public static int NoOfB = 0;
	public static int NoOfC = 0;
	public static int NoOfD = 0;
	public static int NoOfF = 0;
	public static int MaxPt = 0;

	// empty constructor
	public HWobject() {
		id = 0;
		lab_ex = 0;
		hw = new int[10];
		for (int i = 0; i < 10; i++)
			hw[i] = 0;

		midterm = 0;
		finl = 0;
		extralab = 0;
	}

	// constructor having array of int as argument
	public HWobject(int[] arr) {
		id = arr[0];
		lab_ex = arr[1];
		hw = new int[10];
		for (int i = 2; i < 12; i++)
			hw[i - 2] = arr[i];

		midterm = arr[12];
		finl = arr[13];
		extralab = arr[14];
	}

	// function to calculate total assignment marks
	public int totalAsG() {
		int total = 0;
		for (int i = 0; i < 10; i++)
			total += hw[i];

		return total;
	}

	// function to calculate total points
	public int pts() {
		int total = totalAsG();
		total = total + lab_ex + midterm + finl + extralab;
		if (total > MaxPt)
			MaxPt = total;
		return total;
	}

	// function to calculate percentage
	public int pct() {
		int p = pts();
		float z = ((float) p * 100) / 420;
		p = Math.round(z);
		return p;
	}

	// function to calculate grade
	public String gr() {
		int p = pct();
		if (p >= 90) {
			NoOfA++;
			return "A";
		}

		else if (p >= 78) {
			NoOfB++;
			return "B";
		}

		else if (p >= 62) {
			NoOfC++;
			return "C";
		}

		else if (p >= 46) {
			NoOfD++;
			return "D";
		}

		else {
			NoOfF++;
			return "F";
		}
	}

	// function to calculate part2 of output and return in form of string
	public String Part2() {
		String Summary = "Average total point percent of all students:"
				+ String.format("%4s", Integer.toString(Math.round((float) total_pct / (float) max))) + '\n' + '\n';
		Summary += "Number of A's = " + String.format("%2s", Integer.toString(NoOfA)) + '\n';
		Summary += "Number of B's = " + String.format("%2s", Integer.toString(NoOfB)) + '\n';
		Summary += "Number of C's = " + String.format("%2s", Integer.toString(NoOfC)) + '\n';
		Summary += "Number of D's = " + String.format("%2s", Integer.toString(NoOfD)) + '\n';
		Summary += "Number of F's = " + String.format("%2s", Integer.toString(NoOfF)) + '\n' + '\n';
		Summary += "Maximum points = " + String.format("%4s", Integer.toString(MaxPt)) + '\n';

		return Summary;
	}

	// function to calculate part1 of output and return in form of string
	public String assgn() {
		max++;
		// toString to convert int into string
		// 'replace' is to replace first argument by second argument
		String stres = String.format("%8s", Integer.toString(id)).replace(' ', '0');
		stres = stres + String.format("%4s", Integer.toString(lab_ex));
		stres = stres + " ";
		for (int k = 0; k < 10; k++) {
			stres = stres + String.format("%3s", Integer.toString(hw[k]));
		}
		stres = stres + String.format("%5s", Integer.toString(totalAsG()));
		stres = stres + String.format("%4s", Integer.toString(midterm));
		stres = stres + String.format("%5s", Integer.toString(finl));
		stres = stres + String.format("%4s", Integer.toString(extralab));
		stres = stres + String.format("%5s", Integer.toString(pts()));
		total_pct += pct();
		stres = stres + String.format("%5s", Integer.toString(pct()));
		stres = stres + String.format("%3s", gr());
		return stres;
	}
}
