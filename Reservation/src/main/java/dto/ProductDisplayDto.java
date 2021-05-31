package dto;

import java.util.ArrayList;
import java.util.List;

public class ProductDisplayDto {

	private DisplayInfoDto displayInfo;
	private List<ProductImageDto> productImages;
	private List<CommentDto> comments;
	private double averageScore;
	private List<ProductPriceDto> productPrices;
	private DisplayInfoImageDto displayInfoImage;
	public DisplayInfoDto getDisplayInfo() {
		return displayInfo;
	}
	public void setDisplayInfo(DisplayInfoDto displayInfo) {
		this.displayInfo = displayInfo;
	}
	public List<ProductImageDto> getProductImages() {
		return productImages;
	}
	public void setProductImages(List<ProductImageDto> productImages) {
		if (productImages == null) {
			this.productImages = null;
		} else {
			this.productImages.addAll(productImages);
		}
	}
	public List<CommentDto> getComments() {
		return comments;
	}
	public void setComments(List<CommentDto> comments) {
		if (comments == null) {
			this.comments = null;
		} else {
			this.comments.addAll(comments);
		}
	}
	public double getAverageScore() {
		return averageScore;
	}
	public void setAverageScore(double averageScore) {
		this.averageScore = averageScore;
	}
	public List<ProductPriceDto> getProductPrices() {
		return productPrices;
	}
	public void setProductPrices(List<ProductPriceDto> productPrices) {
		if (productPrices == null) {
			this.productPrices = null;
		} else {
			this.productPrices.addAll(productPrices);
		}
	}
	public DisplayInfoImageDto getDisplayInfoImage() {
		return displayInfoImage;
	}
	public void setDisplayInfoImage(DisplayInfoImageDto displayInfoImage) {
		this.displayInfoImage = displayInfoImage;
	}
	
	public ProductDisplayDto() {
		this.productImages = new ArrayList<>();
		this.comments = new ArrayList<>();
		this.productPrices = new ArrayList<>();
	}

	
}
