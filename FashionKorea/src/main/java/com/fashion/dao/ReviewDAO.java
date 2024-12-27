package com.fashion.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fashion.vo.Review;

public class ReviewDAO extends DAO {

	public List<Review> review(String review) {
		List<Review> result = new ArrayList<>();
		String sql = "select re.comments, " //
				+ "re.wdate, " //
				+ "re.score, " //
				+ "re.title, " //
				+ "re.image, " //
				+ "m.member_name " //
				+ "from review re " //
				+ "join member m on re.member_no = m.member_no "
				+ "where re.clothes_no = ? ";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, review);
			rs = psmt.executeQuery();

			while (rs.next()) {
				Review rv = new Review();
				rv.setComments(rs.getString("comments"));
				rv.setScore(rs.getString("score"));
				rv.setTitle(rs.getString("title"));
				rv.setImage(rs.getString("image"));

				result.add(rv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return result;
	}

	public Integer selectCountReview(int cno) {
		int result = 0;
		String sql = "select count(review_no) as count"
				+ "	  from review"
				+ "	  where clothes_no=?";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, cno);
			rs = psmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return result;
	}
}