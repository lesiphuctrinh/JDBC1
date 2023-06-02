package ThucThi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SINHVIEN {
	private int ma;
	private String hoten, ngaysinh;
	/**
	 * @return the ma
	 */
	public int getMa() {
		return ma;
	}
	/**
	 * @param ma the ma to set
	 */
	public void setMa(int ma) {
		this.ma = ma;
	}
	/**
	 * @return the hoten
	 */
	public String getHoten() {
		return hoten;
	}
	/**
	 * @param hoten the hoten to set
	 */
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	/**
	 * @return the ngaysinh
	 */
	public String getNgaysinh() {
		return ngaysinh;
	}
	/**
	 * @param ngaysinh the ngaysinh to set
	 */
	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public SINHVIEN(int ma, String hoten, String ngaysinh) {
		super();
		this.ma = ma;
		this.hoten = hoten;
		this.ngaysinh = ngaysinh;
	}
	@Override
	public String toString() {
		return "SINHVIEN [ma=" + ma + ", hoten=" + hoten + ", ngaysinh=" + ngaysinh + "]";
	}
	
	//đọc dữ liệu giảm dần theo tên
	public static List<SINHVIEN> getSinhVien() throws ClassNotFoundException, SQLException{
		Connection con=Connect.getConnect();
		Statement state=con.createStatement();
		String sql="SELECT *FROM SINHVIEN ORDER BY HOTENSV DESC";
		ResultSet rs=state.executeQuery(sql);
		List<SINHVIEN> sv=new ArrayList<>();
		while(rs.next()) {
			int m=rs.getInt("MASV");
			String t=rs.getString("HOTENSV");
			String n=rs.getString("NGAYSINH");
			SINHVIEN a= new SINHVIEN(m, t, n);
			sv.add(a);
		}
		con.close();
		return sv;
	}
	// xoá
	public static int xoa(int m) throws ClassNotFoundException, SQLException {
		Connection con= Connect.getConnect();
		Statement state=con.createStatement();
		String sql="DELETE FROM SINHVIEN WHERE MASV=" +m;
		int rs=state.executeUpdate(sql);
		con.close();
		return rs;
	}
	// thêm
	public static void bosung( SINHVIEN a) throws ClassNotFoundException, SQLException {
		Connection con=Connect.getConnect();
		Statement state=con.createStatement();
		String sql="INSERT INTO SINHVIEN( MASV, HOTENSV, NGAYSINH) VALUES('"+a.getMa()+"', '"+a.getHoten()+"', '"+a.getNgaysinh()+"')";
		int rs=state.executeUpdate(sql);
		con.close();
	}
	// cập nhật
	public static void CapNhat( SINHVIEN a) throws ClassNotFoundException, SQLException {
		Connection con=Connect.getConnect();
		Statement state=con.createStatement();
		String sql="UPDATE SINHVIEN SET HOTENSV = '"+a.getHoten()+"', NGAYSINH ='"+a.getNgaysinh()+"' +"
				+ "WHERE MASV = '"+a.getMa()+"'";
		int rs=state.executeUpdate(sql);
		con.close();
	}
}
