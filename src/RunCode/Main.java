package RunCode;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ThucThi.Connect;
import ThucThi.LOPHOC;
import ThucThi.SINHVIEN;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
//		Connect.getConnect();
//		List <SINHVIEN> a = SINHVIEN.getSinhVien();
//		for(SINHVIEN b:a) {
//			System.out.println(b.toString());
//		}
//		
//		List<LOPHOC> a=LOPHOC.getLopHoc();
//		for(LOPHOC b:a) {
//			System.out.println(b.toString());
//		}
//		SINHVIEN.xoa(3);
		
		SINHVIEN a= new SINHVIEN(4, "Lê Thành", "21/02/2000");
		SINHVIEN.CapNhat(a);
	}

}
