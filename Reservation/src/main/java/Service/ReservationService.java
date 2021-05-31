package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.ReservationDao;
import dao.ReservationPriceDao;
import dto.ReservationInfoDto;
import dto.ReservationInfoPriceDto;
import dto.ReservationInfoSetDto;
import dto.ReservationInfoSetItem;
import dto.ReservationPriceDto;

@Service
public class ReservationService {

	@Autowired
	private ReservationDao reservationDao;
	@Autowired
	private ReservationPriceDao reservationPriceDao;
	
	public ReservationInfoSetDto getReservationInfoSet(String reservationEmail) {
		ReservationInfoSetDto reservationInfoSet = new ReservationInfoSetDto();

		List<ReservationInfoDto> reservationInfoList = reservationDao.getReservationInfoList(reservationEmail);
		int totalPrice;
		for (ReservationInfoDto reservationInfo : reservationInfoList) {
			ReservationInfoSetItem reservationItem = new ReservationInfoSetItem();
			totalPrice = reservationPriceDao.getTotalPrice(reservationInfo.getReservationInfoId());
			
			reservationItem.setReservationInfo(reservationInfo);
			reservationItem.setTotalPrice(totalPrice);

			reservationInfoSet.addReservationItem(reservationItem);
			reservationInfoSet.addSize(1);
		}

		return reservationInfoSet;
	}

	@Transactional
	public ReservationInfoPriceDto registerReservation(ReservationInfoPriceDto reservationDto) {
		ReservationInfoPriceDto updatedReservationInfo;
		int reservationInfoId = reservationDao.registerReservation(reservationDto);
		reservationDto.setReservationInfoIdAll(reservationInfoId);

		for (ReservationPriceDto price : reservationDto.getPrices()) {
			if (price.getCount() > 0) {
				reservationPriceDao.registerPrice(price);
			}
		}

		updatedReservationInfo = getReservationinfo(reservationInfoId);

		return updatedReservationInfo;
	}

	public ReservationInfoPriceDto setCancelReservation(int reservationId) {
		reservationDao.setCancelReservation(reservationId);
		ReservationInfoPriceDto updatedReservationInfo = getReservationinfo(reservationId);

		return updatedReservationInfo;
	}

	public ReservationInfoPriceDto getReservationinfo(int reservationId) {
		ReservationInfoPriceDto reservationInfoPriceDto = new ReservationInfoPriceDto();
		ReservationInfoDto reservationInfoDto = reservationDao.getReservationInfo(reservationId);
		List<ReservationPriceDto> prices = reservationPriceDao.getPriceList(reservationId);

		reservationInfoPriceDto.setReservationInfo(reservationInfoDto);
		reservationInfoPriceDto.setPrices(prices);

		return reservationInfoPriceDto;
	}

	public boolean existReservation(String reservationEmail) {
		List<ReservationInfoDto> reservationInfoList = reservationDao.getReservationInfoList(reservationEmail);

		if (reservationInfoList == null) {
			return false;
		} else {
			return true;
		}
	}
}
