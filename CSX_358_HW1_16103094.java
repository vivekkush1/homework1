import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class CSX_358_HW1_16103094 {
	private static Scanner ss;

	public static void main(String[] arg) throws IOException {
		int[] arr = new int[15];
		File file = new File("C:\\Users\\hp\\Desktop\\HW1-data.txt");
		Scanner sc = new Scanner(file);

		PrintWriter writer = new PrintWriter("C:\\Users\\hp\\Desktop\\out.txt", "UTF-8");
		writer.println("* The Student Report Output File");
		writer.println("  ------------------------------\n");
		writer.println("Stdnt Id  Ex  -------- Assignments --------  Tot  Mi  Fin  CL  Pts  Pct  Gr");
		writer.println("--------  --  -----------------------------  ---  --  ---  --  ---  ---  --");
		
		while (sc.hasNextLine()) {
			String St = sc.nextLine();
			ss = new Scanner(St);
			int i = 0;
			while (ss.hasNextInt()) {
				arr[i] = ss.nextInt();
				i++;
			}

				//create object of type HWobject class
				HWobject obj1 = new HWobject(arr);
				//call assgn() function 
				String stres = obj1.assgn();
				//write string returned by assgn() in output file
				writer.println(stres);
		}
		writer.println("\n* Summary Report File");
		writer.println("  -------------------\n");
		
		//create object of type HWobject class
		HWobject obj1 = new HWobject();
		writer.println(obj1.Part2());
		
		sc.close();
		writer.close();
	}
}
