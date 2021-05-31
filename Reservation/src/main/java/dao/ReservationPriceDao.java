package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import dto.ReservationPriceDto;

public class ReservationPriceDao {

	private JdbcTemplate jdbc;
	@Autowired
	public ReservationPriceDao(DataSource dataSource)
	{
		this.jdbc=new JdbcTemplate(dataSource);
	}
	
	public int getTotalPrice(int reservationInfoId)
	{
		List<Integer> totalPrice= jdbc.query(
					"select SUM(price*count) as totalPrice from reservation_info " + 
					"INNER JOIN reservation_info_price ON reservation_info_price.reservation_info_id = reservation_info.id " + 
					"INNER JOIN product_price ON product_price.id = reservation_info_price.product_price_id " + 
					"WHERE reservation_info_id = ? ",
					
					new RowMapper<Integer>() {
						@Override
						public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
							return rs.getInt("totalPrice");
						}
					}, reservationInfoId);

			return totalPrice.isEmpty() ? null : totalPrice.get(0);
		}
		
		public List<ReservationPriceDto> getPriceList(int reservationInfoId){
			List<ReservationPriceDto> priceList = jdbc.query(
					"SELECT id as reservationInfoPriceId, reservation_info_id, product_price_id, count "
					+ "FROM reservation_info_price "
					+ "where reservation_info_id=?",
					new RowMapper<ReservationPriceDto>() {
						@Override
						public ReservationPriceDto mapRow(ResultSet rs, int rowNum) throws SQLException {
							ReservationPriceDto reservationPriceDto = new ReservationPriceDto();
							reservationPriceDto.setCount(rs.getInt("count"));
							reservationPriceDto.setProductPriceId(rs.getInt("product_price_id"));
							reservationPriceDto.setReservationInfoId(rs.getInt("reservation_info_id"));
							reservationPriceDto.setReservationInfoPriceId(rs.getInt("reservationInfoPriceId"));
							return reservationPriceDto;
						}
					}, reservationInfoId);

			return priceList.isEmpty() ? null : priceList;
		}
		
		public int registerPrice(final ReservationPriceDto reservationPrice) {
			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbc.update(new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement pstmt = con.prepareStatement(
							"insert into reservation_info_price(reservation_info_id, product_price_id, count) values (?,?,?)", new String[] {"ID"});
					
					pstmt.setInt(1,  reservationPrice.getReservationInfoId());
					pstmt.setInt(2, reservationPrice.getProductPriceId());
					pstmt.setInt(3, reservationPrice.getCount());
					
					return pstmt;
				}
			},keyHolder);
			
			Number keyValue = keyHolder.getKey();
			return keyValue.intValue();
		}
	}
