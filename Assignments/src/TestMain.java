import java.io.FileNotFoundException;
import java.io.IOException;

import cs5387.Table;
import cs5387.TableSorter;

public class TestMain {
	
	public static void main(String[] args) {
		try {
			Table t = Table.GetTable("C:\\temp\\matrix_NxN.txt");
			
			TableSorter sorter = new TableSorter();
			
			System.out.println("The following table: ");
			System.out.println(t.toString());
			
			if(sorter.isSorted(t)) {
				System.out.println("Is sorted.");
			}
			else {
				System.out.println("Is not sorted.");
			}
			
			
			System.out.println("----------: Sorting Table");
			TableSorter.SortTable(t);
			
			System.out.println("The table: ");
			System.out.println(t.toString());
			
			if(sorter.isSorted(t)) {
				System.out.println("Is now sorted.");
			}
			else {
				System.out.println("Failed to sort.");
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
