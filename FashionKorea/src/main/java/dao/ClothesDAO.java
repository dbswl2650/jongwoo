package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Clothes;

public class ClothesDAO extends DAO {
	private String selectAllSql = "select count(clothes_no) as count"
			+ "					   from clothes";
	private String selectSomeSql = "select clothes_no"
			+ "						from clothes";
	private String selectOneSql = "select category_no,"
			+ "						 name,"
			+ "						 price,"
			+ "						 color,"
			+ "						 clothes_size,"
			+ "						 image,"
			+ "						 category,"
			+ "						 about,"
			+ "						 image_detail"
			+ "					   from clothes"
			+ "					   where clothes_no=?";
	private String insertSql = "insert into clothes(clothes_no,"
			+ "					  category_no,"
			+ "					  name,"
			+ "					  price,"
			+ "					  color,"
			+ "					  clothes_size,"
			+ "					  image,"
			+ "					  category,"
			+ "					  about,"
			+ "					  image_detail"
			+ "					values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private String updateSql = "update clothes"
			+ "					set category_no=?,"
			+ "					  name=?,"
			+ "					  price=?,"
			+ "					  color=?,"
			+ "					  clothes_size=?,"
			+ "					  image=?,"
			+ "					  category=?,"
			+ "					  about=?,"
			+ "					  image_detail=?"
			+ "					where clothes_no=?";
	private String deleteSql = "delete from clothes"
			+ "					where clothes_no=?";
	public int selectAllClothes() {
		int count = 0;
		if (connect() == false) {
			System.out.println("연결 에러");
			return count;
		}
		
		try {
			psmt = conn.prepareStatement(selectAllSql);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				count = rs.getInt("count");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disConnect();
		}
		return count;
	}
	public List<Integer> selectSomeClothes() {
		List<Integer> result = new ArrayList<>();
		if (connect() == false) {
			System.out.println("연결 에러");
			return result;
		}
		
		try {
			psmt = conn.prepareStatement(selectSomeSql);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				result.add(rs.getInt("clothes_no"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disConnect();
		}
		return result;
	}
	public Clothes selectOneClothes(int cno) {
		Clothes clothes = new Clothes();
		if (connect() == false) {
			System.out.println("연결 에러");
			clothes.setName("연결 에러");
			return clothes;
		}
		
		try {
			psmt = conn.prepareStatement(selectOneSql);
			psmt.setInt(1, cno);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				clothes.setCategory_no(rs.getInt("category_no"));
				clothes.setName(rs.getString("name"));
				clothes.setPrice(rs.getInt("price"));
				clothes.setColor(rs.getString("color"));
				clothes.setClothes_size(rs.getString("clothes_size"));
				clothes.setImage(rs.getString("image"));
				clothes.setCategory(rs.getString("category"));
				clothes.setAbout(rs.getString("about"));
				clothes.setImage_detail(rs.getString("image_detail"));
				break;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disConnect();
		}
		return clothes;
	}
	public boolean insertClothes(Clothes clothes) {
		if (connect() == false) {
			System.out.println("연결 에러");
			return false;
		}
		try {
			psmt = conn.prepareStatement("select max(clothes_no) as max_no from clothes");
			rs = psmt.executeQuery();
			int new_cno = rs.getInt("max_no") + 1;
			
			psmt = conn.prepareStatement(insertSql);
			psmt.setInt(1, new_cno);
			psmt.setInt(2, clothes.getCategory_no());
			psmt.setString(3, clothes.getName());
			psmt.setInt(4, clothes.getPrice());
			psmt.setString(5, clothes.getColor());
			psmt.setString(6, clothes.getClothes_size());
			psmt.setString(7, clothes.getImage());
			psmt.setString(8, clothes.getCategory());
			psmt.setString(9, clothes.getAbout());
			psmt.setString(10, clothes.getImage_detail());
			
			if (psmt.executeUpdate() > 1) {
				return true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disConnect();
		}
		return false;
	}
	public boolean updateClothes(Clothes clothes) {
		if (connect() == false) {
			System.out.println("연결 에러");
			return false;
		}
		try {
			psmt = conn.prepareStatement(updateSql);
			psmt.setInt(10, clothes.getClothes_no());
			psmt.setInt(1, clothes.getCategory_no());
			psmt.setString(2, clothes.getName());
			psmt.setInt(3, clothes.getPrice());
			psmt.setString(4, clothes.getColor());
			psmt.setString(5, clothes.getClothes_size());
			psmt.setString(6, clothes.getImage());
			psmt.setString(7, clothes.getCategory());
			psmt.setString(8, clothes.getAbout());
			psmt.setString(9, clothes.getImage_detail());
			
			if (psmt.executeUpdate() > 1) {
				return true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disConnect();
		}
		return false;
	}
	public boolean deleteClothes(int cno) {
		if (connect() == false) {
			System.out.println("연결 에러");
			return false;
		}
		try {
			psmt = conn.prepareStatement(deleteSql);
			psmt.setInt(1, cno);
			
			if (psmt.executeUpdate() > 1) {
				return true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disConnect();
		}
		return false;
	}
}
