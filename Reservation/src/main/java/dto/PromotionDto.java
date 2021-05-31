package dto;

public class PromotionDto {

	private int id;
	private int productId;
	private String productImageUrl;
	private String description;
	private String placeName;
	
	public PromotionDto(int id, int productId, String productImageUrl, String description, String placeName) {
		this.id = id;
		this.productId = productId;
		this.productImageUrl = productImageUrl;
		this.description = description;
		this.placeName = placeName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductImageUrl() {
		return productImageUrl;
	}

	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	
	
}
