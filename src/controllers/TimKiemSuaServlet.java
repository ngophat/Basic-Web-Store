package controllers;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entityBeans.HangSua;
import entityBeans.LoaiSua;
import entityBeans.Sua;
import sessionBeans.HangSuaSBLocal;
import sessionBeans.LoaiSuaSBLocal;
import sessionBeans.SuaSBLocal;

@WebServlet("/TimKiemSuaServlet")
public class TimKiemSuaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TimKiemSuaServlet() {
        super();
    }
    @EJB
    private LoaiSuaSBLocal loaiSuaSBLocal;
    
    @EJB
    private HangSuaSBLocal hangSuaSBLocal;
    
    @EJB
    private SuaSBLocal suaSBLocal;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        //Thi sinh viet them cac lenh vao day de thuc hien
        List<LoaiSua> listLs = loaiSuaSBLocal.docTatCa();
        List<HangSua> listHs = hangSuaSBLocal.docTatCa();
        request.setAttribute("listLS", listLs);
        request.setAttribute("listHS", listHs);
        request.setAttribute("tongSP", 0);
        request.getRequestDispatcher("views/tim-kiem-sua.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        //Thi sinh viet them cac lenh vao day de thuc hien
        List<LoaiSua> listLs = loaiSuaSBLocal.docTatCa();
        List<HangSua> listHs = hangSuaSBLocal.docTatCa();
        if(request.getParameter("btnTimKiem")!=null) {
        	String maHS, maLS, tenSua;
        	maHS = request.getParameter("cboHangSua");
        	maLS = request.getParameter("cboLoaiSua");
        	tenSua = request.getParameter("txtTenSuaTim");
        	
        	List<Sua> list = suaSBLocal.timTheoTen(maHS, maLS, tenSua);
        	int tongSP = suaSBLocal.tongSanPham(list);
        	request.setAttribute("listS", list);
        	request.setAttribute("tongSP", tongSP);
        	
        }
        request.setAttribute("listLS", listLs);
        request.setAttribute("listHS", listHs);
        request.getRequestDispatcher("views/tim-kiem-sua.jsp").include(request, response);
	}

}
