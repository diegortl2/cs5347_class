package cs5387;

//*******************************************************************
//QuickSortTable
//Author: Diego A. Rivera
//Date: 01/29/2020
//Programming Assignment 1
//
//Sorting algorithm class implemented to sort rows or columns on 
//a given table. The algorithm has a single implementation, but
//depending on the entry method used it will decide if the next position
//on the matrix is right (for rows) or down (for columns).
//
//References: 
//- Implementation of quick sort algorithm provided by https://www.geeksforgeeks.org/quick-sort/
//*******************************************************************

public class QuickSortTable {
	
	boolean isColumn;
	
	//Entry point for sorting rows. 
	public void quickSortRow(Table t, int rowIndex) {
		int range = t.getSize();
		
		isColumn = false;
		Position start = new Position( rowIndex, 0, range);
		Position end = new Position( rowIndex, range-1, range);
		
		quickSort( t, start, end);
	}
	
	//Entry point for sorting columns. 
	public void quickSortCol(Table t, int colIndex) {
		int range = t.getSize();
		
		isColumn = true;
		Position start = new Position( 0, colIndex, range);
		Position end = new Position( range-1, colIndex, range);
		
		quickSort( t, start, end);
	}
	
	private void quickSort(Table t, Position min, Position max) {
		if(min != null && max != null && min.smallerThan(max)) {
		
			Position partitionIndex = partition(t,min,max);
			
			quickSort(t, min, partitionIndex.getPrev(isColumn));
			quickSort(t, partitionIndex.getNext(isColumn), max);
		}
	}
	
	private Position partition(Table t, Position min, Position max) {
		
		Position pivot = max;
		Position positionIndex = min.getPrev(isColumn);
		Position iterator = min;
		while(iterator.smallerThan(pivot)) {
			
			int iteratorVal  = t.getTableValue(iterator.row, iterator.col);
			int pivotVal = t.getTableValue(pivot.row, pivot.col);
			if (iteratorVal < pivotVal) {
				
				positionIndex = positionIndex.getNext(isColumn);
				
				swap( t, positionIndex, iterator);
			}
			
			iterator = iterator.getNext(isColumn);
		}
		
		swap(t, positionIndex.getNext(isColumn), pivot);
		
		return positionIndex.getNext(isColumn);
	}
	
	private void swap(Table t, Position a, Position b) {
		
		int tempVal_A = t.getTableValue(a.row, a.col);
		int tempVal_B = t.getTableValue(b.row, b.col);
		
		t.setTableValue(a.row, a.col, tempVal_B);
		t.setTableValue(b.row, b.col, tempVal_A);
	}

}
