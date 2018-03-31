package controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entityBeans.KhachHang;
import sessionBeans.KhachHangSBLocal;

@WebServlet("/ThemKhachHangServlet")
public class ThemKhachHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ThemKhachHangServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        //Thi sinh viet them cac lenh vao day de thuc hien
        
        request.getRequestDispatcher("views/them-khach-hang.jsp").include(request, response);
	}
	@EJB
	private KhachHangSBLocal khachHangSBLocal;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Thi sinh viet them cac lenh vao day de thuc hien
        if(request.getParameter("btnThemMoi")!=null) {
        	String maKH, tenKH, email, dienThoai, diaChi;
        	byte phai;
        	
        	maKH = request.getParameter("txtMaKH");
        	tenKH= request.getParameter("txtTenKH");
        	email = request.getParameter("txtEmail");
        	dienThoai=request.getParameter("txtDienThoai");
        	diaChi=request.getParameter("txtDiaChi");
        	phai=1;
        	phai=(byte) ((request.getParameter("rdbPhai").equals("Nam")) ? 0 : 1);
        	
        	KhachHang khachHang =new KhachHang();
        	khachHang.setDia_chi(diaChi);
        	khachHang.setDien_thoai(dienThoai);
        	khachHang.setEmail(email);
        	khachHang.setTen_khach_hang(tenKH);
        	khachHang.setMa_khach_hang(maKH);
        	khachHang.setPhai(phai);
        	
        	khachHangSBLocal.them(khachHang);
        }
        request.getRequestDispatcher("views/them-khach-hang.jsp").include(request, response);
	}

}
