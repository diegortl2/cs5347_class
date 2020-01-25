package cs5387;

public class QuickSortTable {
	
	public void quickSort(Table t) {
		int range = t.getSize();
		
		Position start = new Position( 0, 0, range);
		Position end = new Position( range-1, range-1, range);
		
		quickSort( t, start, end);
	}
	
	private void quickSort(Table t, Position min, Position max) {
		if(min != null && max != null && min.smallerThan(max)) {
		
			Position partitionIndex = partition(t,min,max);
			
			quickSort(t, min, partitionIndex.getPrev());
			quickSort(t, partitionIndex.getNext(), max);
		}
	}
	
	private Position partition(Table t, Position min, Position max) {
		
		Position pivot = max;
		Position positionIndex = min.getPrev();
		Position iterator = min;
		while(iterator.smallerThan(pivot)) {
			
			int iteratorVal  = t.getTableValue(iterator.row, iterator.col);
			int pivotVal = t.getTableValue(pivot.row, pivot.col);
			if (iteratorVal < pivotVal) {
				
				positionIndex = positionIndex.getNext();
				
				swap( t, positionIndex, iterator);
			}
			
			iterator = iterator.getNext();
		}
		
		swap(t, positionIndex.getNext(), pivot);
		
		return positionIndex.getNext();
	}
	
	private void swap(Table t, Position a, Position b) {
		
		int tempVal_A = t.getTableValue(a.row, a.col);
		int tempVal_B = t.getTableValue(b.row, b.col);
		
		t.setTableValue(a.row, a.col, tempVal_B);
		t.setTableValue(b.row, b.col, tempVal_A);
	}

}
