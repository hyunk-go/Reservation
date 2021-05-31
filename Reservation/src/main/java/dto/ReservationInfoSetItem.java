package dto;

public class ReservationInfoSetItem {

	public int reservationInfoId;
	public int productId;
	public int displayInfoId;
	public String reservationName;
	public String reservationTelephone;
	public String reservationEmail;
	public Boolean cancelYn;
	public String reservationDate;
	public String createDate;
	public String modifyDate;
	
	
	public int getReservationInfoId() {
		return reservationInfoId;
	}

	public void setReservationInfoId(int reservationInfoId) {
		this.reservationInfoId = reservationInfoId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getDisplayInfoId() {
		return displayInfoId;
	}

	public void setDisplayInfoId(int displayInfoId) {
		this.displayInfoId = displayInfoId;
	}

	public String getReservationName() {
		return reservationName;
	}

	public void setReservationName(String reservationName) {
		this.reservationName = reservationName;
	}

	public String getReservationTelephone() {
		return reservationTelephone;
	}

	public void setReservationTelephone(String reservationTelephone) {
		this.reservationTelephone = reservationTelephone;
	}

	public String getReservationEmail() {
		return reservationEmail;
	}

	public void setReservationEmail(String reservationEmail) {
		this.reservationEmail = reservationEmail;
	}

	public Boolean getCancelYn() {
		return cancelYn;
	}

	public void setCancelYn(Boolean cancelYn) {
		this.cancelYn = cancelYn;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	int totalPrice;
	
	public void setReservationInfo(ReservationInfoDto reservationInfo) {
		reservationInfoId = reservationInfo.getReservationInfoId();
		productId = reservationInfo.getProductId();
		displayInfoId = reservationInfo.getDisplayInfoId();
		reservationName = reservationInfo.getReservationName();
		reservationTelephone = reservationInfo.getReservationTelephone();
		cancelYn = reservationInfo.getCancelYn();
		reservationDate = reservationInfo.getReservationDate();
		createDate = reservationInfo.getCreateDate();
		modifyDate = reservationInfo.getModifyDate();
		reservationEmail = reservationInfo.getReservationEmail();
	}
}
