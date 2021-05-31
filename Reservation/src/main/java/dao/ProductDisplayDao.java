package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import dto.DisplayInfoDto;

@Repository
public class ProductDisplayDao {

	private JdbcTemplate jdbc;
	
	@Autowired 
	public ProductDisplayDao(DataSource dataSource) {
		this.jdbc=new JdbcTemplate(dataSource);
		
	}
	
	public DisplayInfoDto getDisplayInfo(int displayInfoId) {
		
		List<DisplayInfoDto> displayInfoList = jdbc.query(
				"SELECT display_info.product_id AS productId, product.category_id AS categoryId, display_info.id AS displayInfoId, "
						+ "category.name AS categoryName, product.description, product.content, product.event, opening_hours, "
						+ "place_name, place_lot, place_street, tel, homepage, email, product.create_date, product.modify_date "
						+ "FROM category " + "INNER JOIN product ON category.id = product.category_id "
						+ "INNER JOIN display_info ON product.id = display_info.product_id "
						+ "WHERE display_info.id = ?",
				new RowMapper<DisplayInfoDto>() {
					@Override
					public DisplayInfoDto mapRow(ResultSet rs, int rowNum) throws SQLException {
						DisplayInfoDto displayInfoDto = new DisplayInfoDto();
						displayInfoDto.setCategoryId(rs.getInt("categoryId"));
						displayInfoDto.setCategoryName(rs.getString("categoryName"));
						displayInfoDto.setCreateDate(rs.getTimestamp("create_date").toLocalDateTime());
						displayInfoDto.setDisplayInfoId(rs.getInt("displayInfoId"));
						displayInfoDto.setEmail(rs.getString("email"));
						displayInfoDto.setHomepage(rs.getString("homepage"));
						displayInfoDto.setModifyDate(rs.getTimestamp("modify_date").toLocalDateTime());
						displayInfoDto.setOpeningHours(rs.getString("opening_hours"));
						displayInfoDto.setPlaceLot(rs.getString("place_lot"));
						displayInfoDto.setPlaceName(rs.getString("place_name"));
						displayInfoDto.setPlaceStreet(rs.getString("place_street"));
						displayInfoDto.setProductContent(rs.getString("content"));
						displayInfoDto.setProductDescription(rs.getString("description"));
						displayInfoDto.setProductEvent(rs.getString("event"));
						displayInfoDto.setProductId(rs.getInt("productId"));
						displayInfoDto.setTelephone(rs.getString("tel"));

						return displayInfoDto;
					}
					
	},displayInfoId);
		
		return displayInfoList.isEmpty() ? null : displayInfoList.get(0);
	
}
}