package ThucThi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LOPHOC {
	private int id;
	private String tenlop;
	public LOPHOC(int id, String tenlop) {
		super();
		this.id = id;
		this.tenlop = tenlop;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the tenlop
	 */
	public String getTenlop() {
		return tenlop;
	}
	/**
	 * @param tenlop the tenlop to set
	 */
	public void setTenlop(String tenlop) {
		this.tenlop = tenlop;
	}
	@Override
	public String toString() {
		return "LOPHOC [id=" + id + ", tenlop=" + tenlop + "]";
	}
	
	public static List<LOPHOC> getLopHoc() throws SQLException, ClassNotFoundException{
		Connection con=Connect.getConnect();
		Statement state=con.createStatement();
		String sql="SELECT *FROM LOPHOC ORDER BY TENLOP ASC";
		ResultSet rs=state.executeQuery(sql);
		List<LOPHOC> l= new ArrayList<>();
		while(rs.next()) {
			int d=rs.getInt("ID");
			String t=rs.getString("TENLOP");
			LOPHOC a=new LOPHOC(d, t);
			l.add(a);
		}
		con.close();
		return l;
	}
}
