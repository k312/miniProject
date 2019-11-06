package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.UserDTO;
import util.DbUtil;

public class UserDAOImpl implements UserDAO {

	@Override
	public UserDTO signUp(String id, String password, int residence) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into userinfo values(upper(id), password, residence)";
		UserDTO dto = null;
		int result = 0;
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
			
			dto = new UserDTO(id, password, residence);
			
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return dto;
	}

	@Override
	public UserDTO logIn(String id, String password) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select userid, userpassword, userresidence from userinfo where userid = ? and userpassword = ?";
		UserDTO dto = null;
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				String rid = rs.getString(1);
				String rpassword = rs.getString(2);
				String rresidence = rs.getString(3);
				
				dto = new UserDTO(rid, rpassword, Integer.parseInt(rresidence));
			}
			
			
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return dto;
	}

	@Override
	public String myResidence(String id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select cn.intendance from userinfo ui join crimeno cn on ui.userresidence = cn.pkno where ui.userid = ?";//두 테이블을 조인해서 가져와야함
		String result = null;
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				result = rs.getString(1);
			}
			
			
			
			
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return result;
	}

	@Override
	public int checkSecurity(int residence) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT P.RESPONSBILITY\r\n" + 
				"FROM CRIMENO CN JOIN POLICE P\r\n" + 
				"ON CN.INTENDANCE = p.intendance\r\n" + 
				"WHERE CN.PKNO = ?";
		int responsbility = 0;
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
		
			ps.setInt(1, residence);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				responsbility = rs.getInt(1);
			}
			
			
		}finally {
			DbUtil.dbClose(con, ps);
		}
		
		return responsbility;
	}

	@Override
	public int changeResidence(String id, int residence) throws SQLException {
		// TODO Auto-generated method stub
		//전출신고면 userinfo 거주지 바뀨ㅜ고
		//전체인구 +1 기존 지역 -1
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql1 = "select userresidance from userinfo where userid = ?";//처음 거주지 번호 받아서
		String sql2 = "select intendance from crimeno where pkno = ?";//처음 받은 거주지 번호로 거주지 이름을 받는다.
		String sql3 = "update police set population = population-1 where ?";//기존 지역 -1
		
		String sql4 = "update userinfo set userresidance = ? where userid = ?";//전출신고면 userinfo 거주지 바뀨ㅜ고
		String sql5 = "select userresidance from userinfo where userid = ?";//거주지 번호 받아서
		String sql6 = "select intendance from crimeno where pkno = ?";//받은 거주지 번호로 거주지 이름을 받는다.
		String sql7 = "update police set population = population+1 where /*받은 거주지 이름*/";//전체인구 +1
		int result = 0;

		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql1);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			int reno = rs.getInt(1);
			
			ps = con.prepareStatement(sql2);
			ps.setInt(1, reno);
			rs = ps.executeQuery();
			
			String rename = rs.getString(1);
			
			ps = con.prepareStatement(sql3);
			ps.setString(1, rename);
			ps.executeUpdate();
			
			ps = con.prepareStatement(sql4);
			ps.setInt(1, residence);
			ps.setString(2, id);
			ps.executeUpdate();
			
			ps = con.prepareStatement(sql5);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			int reno2 = rs.getInt(1);
			
			ps = con.prepareStatement(sql6);
			ps.setInt(1, reno2);
			rs = ps.executeQuery();
			
			String rename2 = rs.getString(1);
			
			ps = con.prepareStatement(sql7);
			ps.setString(1, rename2);
			result = ps.executeUpdate();
			
			
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}

		return result;
	}

	@Override
	public String checkDetail(String id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select cn.intendance, cn.occurrence, p.responsbility\r\n" + 
				"from userinfo ui join crimeno cn\r\n" + 
				"on ui.userresidence = cn.pkno join police p\r\n" + 
				"on cn.intendance = p.intendance\r\n" + 
				"where ui.userid = upper(?)";
		
		String result = null;
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			
			String intendance = rs.getString(1);
			int occurrence = rs.getInt(2);
			int responsbility = rs.getInt(3);
			
			result = "거주지 : " + intendance +"   범죄발생건수 : "+occurrence+"   경찰 1인당 담당인구 : "+responsbility;
			
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return result;
	}

}
