package com.wonder.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.wonder.ex.dto.Dto;

public class Dao {

	private static Dao dao = new Dao();
	private String CONNECTION_POOL_RESOURCE_NAME = "jdbc/testdb";
	private final String MEMBER_TABLE_NAME = "memberBoard";
	private final String POST_TABLE_NAME = "postBoard";
	private DataSource dataSource;

	public Dao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/" + CONNECTION_POOL_RESOURCE_NAME);

		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public static Dao getDao() {
		return dao;
	}

	public void joinMember(Dto dto) {

		String INSERT_BOARD_SQL = "INSERT INTO " + MEMBER_TABLE_NAME
				+ "(name,id,nickName,pw,email,postcode,roadAddress,jibunAddress,detailAddress,extraAddress,birthYear,birthMonth,birthDay,phoneNum,gender) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(INSERT_BOARD_SQL)) {

			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getNickName());
			pstmt.setString(4, dto.getPw());
			pstmt.setString(5, dto.getEmail());
			pstmt.setString(6, dto.getPostcode());
			pstmt.setString(7, dto.getRoadAddress());
			pstmt.setString(8, dto.getJibunAddress());
			pstmt.setString(9, dto.getDetailAddress());
			pstmt.setString(10, dto.getExtraAddress());
			pstmt.setInt(11, dto.getBirthYear());
			pstmt.setInt(12, dto.getBirthMonth());
			pstmt.setInt(13, dto.getBirthDay());
			pstmt.setString(14, dto.getPhoneNum());
			pstmt.setString(15, dto.getGender());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int idCheck(String inputId) {
		String CHECK_SQL = "SELECT COUNT(*) FROM " + MEMBER_TABLE_NAME + " WHERE id=?";

		try (Connection conn = dataSource.getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(CHECK_SQL)) {

			pstmt.setString(1, inputId);

			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
			int result = rs.getInt(1);
			return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}

	public int logMatch(Dto dto) {
		String PWCHECK_SQL = "SELECT * FROM " + MEMBER_TABLE_NAME + " WHERE id=?";

		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(PWCHECK_SQL)) {

			pstmt.setString(1, dto.getId());

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				String inputPw = dto.getPw();
				String dbPw = rs.getString("pw");

				if (inputPw.equals(dbPw)) {
					return 0;
				} else {
					return 1;
				}
			} else {
				return 2;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return 3;
		}
	}

	public Dto selectInfo(String id) {
		Dto dto = new Dto();

		String SELECT_INFO_SQL = "SELECT * FROM " + MEMBER_TABLE_NAME + " WHERE id=?";

		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_INFO_SQL)) {

			pstmt.setString(1, id);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				dto.setName(rs.getString("name"));
				dto.setId(rs.getString("id"));
				dto.setNickName(rs.getString("nickName"));
				dto.setEmail(rs.getString("email"));
				dto.setPostcode(rs.getString("postcode"));
				dto.setRoadAddress(rs.getString("roadAddress"));
				dto.setJibunAddress(rs.getString("jibunAddress"));
				dto.setDetailAddress(rs.getString("detailAddress"));
				dto.setExtraAddress(rs.getString("extraAddress"));
				dto.setBirthYear(Integer.parseInt(rs.getString("birthYear")));
				dto.setBirthMonth(Integer.parseInt(rs.getString("birthMonth")));
				dto.setBirthDay(Integer.parseInt(rs.getString("birthDay")));
				dto.setPhoneNum(rs.getString("phoneNum"));
				dto.setGender(rs.getString("gender"));

				return dto;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dto;
	}

	public void modifyInfo(Dto dto) {
		String MODIFY_INFO_SQL = "UPDATE " + MEMBER_TABLE_NAME
				+ " SET name=?,nickName=?,pw=?,email=?,postcode=?,roadAddress=?,jibunAddress=?,detailAddress=?,extraAddress=?,birthYear=?,birthMonth=?,birthDay=?,phoneNum=?,gender=? WHERE id=?";

		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(MODIFY_INFO_SQL)) {

			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getNickName());
			pstmt.setString(3, dto.getPw());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getPostcode());
			pstmt.setString(6, dto.getRoadAddress());
			pstmt.setString(7, dto.getJibunAddress());
			pstmt.setString(8, dto.getDetailAddress());
			pstmt.setString(9, dto.getExtraAddress());
			pstmt.setInt(10, dto.getBirthYear());
			pstmt.setInt(11, dto.getBirthMonth());
			pstmt.setInt(12, dto.getBirthDay());
			pstmt.setString(13, dto.getPhoneNum());
			pstmt.setString(14, dto.getGender());
			pstmt.setString(15, dto.getId());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Dto> listDao(int no) {
		ArrayList<Dto> list = new ArrayList<Dto>();
		final String sql = "SELECT * FROM " + POST_TABLE_NAME
				+ " order by GROUPNUM DESC, STEPNUM ASC LIMIT 10 OFFSET ?";

		try (Connection conn = dataSource.getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, (no - 1) * 10);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Dto dto = new Dto();
				dto.setNo(rs.getInt("no"));
				dto.setId(rs.getString("id"));
				dto.setTitle(rs.getString("title"));
				dto.setHit(rs.getInt("hit"));
				dto.setGroupNum(rs.getInt("groupNum"));
				dto.setStepNum(rs.getInt("stepNum"));
				dto.setIndentNum(rs.getInt("indentNum"));
				list.add(dto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int countPost() {
		int no = 0;
		String COUNT_SQL = "SELECT COUNT(*) FROM " + POST_TABLE_NAME;

		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(COUNT_SQL);
				ResultSet rs = pstmt.executeQuery()) {

			if (rs.next()) {
				no = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return no;
	}

	public void insertPost(Dto dto) {
		String INSERT_POST_SQL = "INSERT INTO " + POST_TABLE_NAME + " (id, title, contents) values(?,?,?)";

		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(INSERT_POST_SQL)) {

			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContents());

			pstmt.executeUpdate();

			int curNum = getCurNum();

			updateGroupNum(curNum);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public int getCurNum() {
		int result = 0;
		String MAX_NUM_SQL = "SELECT MAX(no) FROM " + POST_TABLE_NAME;
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(MAX_NUM_SQL);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next())
				result = rs.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public void updateGroupNum(int no) {
		String UPDATE_GROUP_NUM = "UPDATE " + POST_TABLE_NAME + " SET groupNum=? WHERE no=?";
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(UPDATE_GROUP_NUM)) {

			pstmt.setInt(1, no);
			pstmt.setInt(2, no);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Dto selectPost(Dto dto) {
		String SELECT_POST = "SELECT no,nickName,name," + POST_TABLE_NAME
				+ ".id,phoneNum, title, contents,hit, groupNum, stepNum, indentNum FROM " + POST_TABLE_NAME
				+ " INNER JOIN " + MEMBER_TABLE_NAME + " ON " + POST_TABLE_NAME + ".id = " + MEMBER_TABLE_NAME
				+ ".id WHERE " + POST_TABLE_NAME + ".no = ? ORDER BY groupNum DESC, stepNum ASC";

		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_POST)) {

			pstmt.setInt(1, dto.getNo());

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setId(rs.getString("id"));
				dto.setNickName(rs.getString("nickName"));
				dto.setPhoneNum(rs.getString("phoneNum"));
				dto.setTitle(rs.getString("title"));
				dto.setContents(rs.getString("contents"));
				dto.setHit(rs.getInt("hit"));
				dto.setGroupNum(rs.getInt("groupNum"));
				dto.setStepNum(rs.getInt("stepNum"));
				dto.setIndentNum(rs.getInt("indentNum"));
			}

			return dto;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

	public void updateHit(Dto dto) {
		String UPDATE_HIT = "UPDATE " + POST_TABLE_NAME + " SET hit=? WHERE no=?";

		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(UPDATE_HIT)) {

			pstmt.setInt(1, dto.getHit() + 1);
			pstmt.setInt(2, dto.getNo());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deletePost(int no) {
		String DELETE_POST = "DELETE FROM " + POST_TABLE_NAME + " WHERE no=?";

		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(DELETE_POST)) {

			pstmt.setInt(1, no);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updatePost(Dto dto) {
		String UPDATE_POST = "UPDATE " + POST_TABLE_NAME + " SET title=?,contents=? WHERE no=?";

		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(UPDATE_POST)) {

			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContents());
			pstmt.setInt(3, dto.getNo());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertReply(Dto dto) {
		String INSERT_REPLY = "INSERT INTO " + POST_TABLE_NAME
				+ " (id, title, contents,groupNum,stepNum,indentNum) values(?,?,?,?,?,?)";

		updateStepNum(dto);

		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(INSERT_REPLY)) {

			String dash = "";

			if (dto.getTitle().indexOf("re") != -1) {
				dash = "-";
			} else {
				dash = "-re : ";
			}

			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dash + dto.getTitle());
			pstmt.setString(3, dto.getContents());
			pstmt.setInt(4, dto.getGroupNum());
			pstmt.setInt(5, dto.getStepNum() + 1);
			pstmt.setInt(6, dto.getIndentNum() + 1);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateStepNum(Dto dto) {
		String UPDATE_STEPNUM_SQL = "UPDATE " + POST_TABLE_NAME
				+ " SET stepNum=stepNum+1 WHERE groupNum=? AND stepNum>=?";
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(UPDATE_STEPNUM_SQL)) {

			pstmt.setInt(1, dto.getGroupNum());
			pstmt.setInt(2, dto.getStepNum() + 1);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Dto> searchPost(Dto dto) {
		ArrayList<Dto> list = new ArrayList<Dto>();

		String sql = "SELECT no,nickName,name," + POST_TABLE_NAME
				+ ".id,phoneNum, title, contents,hit, groupNum, stepNum, indentNum FROM " + POST_TABLE_NAME
				+ " INNER JOIN " + MEMBER_TABLE_NAME + " ON " + POST_TABLE_NAME + ".id = " + MEMBER_TABLE_NAME + ".id";

		switch (dto.getSelectOpt()) {
		case "title":
			sql = sql + " WHERE title LIKE ? ORDER BY groupNum DESC, stepNum ASC";
			break;
		case "titleAndContents":
			sql = sql + " WHERE title LIKE ? OR contents LIKE ? ORDER BY groupNum DESC, stepNum ASC";
			break;
		case "writer":
			sql = sql + " WHERE nickName LIKE ? ORDER BY groupNum DESC, stepNum ASC";
			break;
		}

		try (Connection conn = dataSource.getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(sql)) {

			switch (dto.getSelectOpt()) {
			case "title":
				pstmt.setString(1, "%" + dto.getSearchInfo() + "%");
				break;
			case "titleAndContents":
				pstmt.setString(1, "%" + dto.getSearchInfo() + "%");
				pstmt.setString(2, "%" + dto.getSearchInfo() + "%");
				break;
			case "writer":
				pstmt.setString(1, "%" + dto.getSearchInfo() + "%");
				break;
			}
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Dto sDto = new Dto();
				sDto.setNo(rs.getInt("no"));
				sDto.setId(rs.getString("id"));
				sDto.setTitle(rs.getString("title"));
				sDto.setHit(rs.getInt("hit"));
				sDto.setGroupNum(rs.getInt("groupNum"));
				sDto.setStepNum(rs.getInt("stepNum"));
				sDto.setIndentNum(rs.getInt("indentNum"));
				list.add(sDto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}