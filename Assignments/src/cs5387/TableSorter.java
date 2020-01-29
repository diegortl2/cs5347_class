package cs5387;


//*******************************************************************
//TableSorter
//Author: Diego A. Rivera
//Date: 01/29/2020
//Programming Assignment 1
//
//TableSorter class with public interface methods required by
//programming assignment 1
//*******************************************************************
public class TableSorter {
	
	//*******************************************************************
	//isSorted
	//Author: Diego A. Rivera
	//Date: 01/29/2020
	//Programming Assignment 1
	//
	//Given a table returns a boolean value "True" if the table 
	//provided has all rows and columns sorted.  
	//*******************************************************************
	public boolean isSorted(Table table) {
		if(table != null) {
				
			int range = table.getSize();
			
			Position index;
			
			//Iterate through rows
			for(int rowIndex = 0; rowIndex < range ; rowIndex++) {
				
				index = new Position( rowIndex, 0, range);
				Position next;
				
				//Check that all values in the row are sorted
				while(index.getNext(false)!=null) {
					next = index.getNext(false);
					int curVal = table.getTableValue(index.row, index.col);
					int nextVal = table.getTableValue(next.row, next.col);
					
					if(curVal>nextVal) {
						return false;
					}
					
					index = next;
				}
			}
			
			//Iterate through all columns
			for(int colIndex = 0; colIndex < range ; colIndex++) {
				
				index = new Position( 0, colIndex, range);
				Position next;
				
				//Check that all values in the column are sorted. 
				while(index.getNext(true)!=null) {
					next = index.getNext(true);
					int curVal = table.getTableValue(index.row, index.col);
					int nextVal = table.getTableValue(next.row, next.col);
					
					if(curVal>nextVal) {
						return false;
					}
					
					index = next;
				}
			}
			
			return true; 
		}
		else {
			throw new NullPointerException();
		}
	}
	
	
	//*******************************************************************
	//sortable
	//Author: Diego A. Rivera
	//Date: 01/29/2020
	//Programming Assignment 1
	//
	//Given a table returns a boolean value "True" if the table 
	//provided has all rows and columns sorted.  
	//*******************************************************************
	public static void sortable(Table table) {
		if(table != null) {
			QuickSortTable sorter = new QuickSortTable();
			int range = table.getSize();
			
			//sort rows
			for(int rowIndex = 0; rowIndex < range ; rowIndex++) {
				sorter.quickSortRow(table, rowIndex);
			}
			
			//sort columns 
			for(int colIndex = 0; colIndex < range ; colIndex++) {
				sorter.quickSortCol(table, colIndex);
			}
		}
		else {
			throw new NullPointerException();
		}
	}
	
}
