import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager extends DBConnecter {
	public DBManager(String id, String password) {
		super(id, password);
	}

	public boolean rentalInsert(Date 시작기간, Date 종료기간, int 인원, String 사유, int 동의인, int 건물, int 호실) {
		String query = "insert into 대여내역  values(대여번호.NEXTVAL,?,?,?,?,?,?,?) ";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setDate(1, 시작기간);
			pstmt.setDate(2, 종료기간);
			pstmt.setInt(3, 인원);
			pstmt.setString(4, 사유);
			pstmt.setInt(5, 동의인);
			pstmt.setInt(6, 건물);
			pstmt.setInt(7, 호실);
		} catch (SQLException e) {
			System.out.println("대여내역 데이터 삽입 오류:" + e.getMessage());
			return false;
		}
		return true;
	}

	public boolean select(String table) {
		String query = "SELECT * form " + table;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				System.out.print("\t" + rs.getInt(1));
				System.out.print("\t" + rs.getString(2));
				System.out.print("\t" + rs.getString(3));
				System.out.print("\t" + rs.getString(4));
				System.out.print("\t" + rs.getString(5));
				System.out.print("\t" + rs.getString(6));
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("데이터 검색 오류 : " + e.getMessage());
			return false;
		}
		return true;
	}

	public boolean Login(String id, String password) {
		String query = "SELECT * from 동의인 where 동의인번호=" + id + "and 비밀번호=" + password;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				System.out.println("로그인 성공");
			} else {
				System.out.println("회원이아닙니다.");
			}
			stmt.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// DBManager dbm = new DBManager("DEU_FACILITY", "1234");
	}
}