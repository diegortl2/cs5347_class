package cs5387;

public class TableSorter {
	
	public boolean isSorted(Table table) {
		
		Position index = new Position( 0, 0, table.getSize());
		
		while (index.getNext() != null) {
			
			Position next = index.getNext();
			int curVal = table.getTableValue(index.row, index.col);
			int nextVal = table.getTableValue(next.row, next.col);
			
			if(curVal>nextVal) {
				return false;
			}
			
			index = next;
		}
		
		return true; 
	}
	
	
	public static void SortTable(Table table) {
		QuickSortTable sorter = new QuickSortTable();
		sorter.quickSort(table);
	}
	
}
