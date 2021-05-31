package dto;

import java.util.ArrayList;
import java.util.List;

public class ProductListDto {

	private int totalCount;
	private List<ProductDto> items;
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List<ProductDto> getItems() {
		return items;
	}
	public void setItems(List<ProductDto> items) {
		if (items == null) 
			this.items = null;
		else 
			this.items.addAll(items);
	}
	
	public ProductListDto() {
		items = new ArrayList<>();
	}
	
}
