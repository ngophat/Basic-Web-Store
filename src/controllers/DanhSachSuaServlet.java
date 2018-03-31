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
import sessionBeans.CtHoadonSBLocal;
import sessionBeans.HangSuaSBLocal;
import sessionBeans.LoaiSuaSBLocal;
import sessionBeans.SuaSBLocal;

@WebServlet("/DanhSachSuaServlet")
public class DanhSachSuaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DanhSachSuaServlet() {
        super();
    }
    @EJB
    private HangSuaSBLocal hangSuaSBLocal;
    
    @EJB
    private LoaiSuaSBLocal loaiSuaSBLocal;
    
    @EJB
    private SuaSBLocal suaSBLocal;
    
	@EJB
	private CtHoadonSBLocal ctHoadonLocal;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        //Thi sinh viet them cac lenh vao day de thuc hien
        List<Sua> list = ctHoadonLocal.suaBanChay();
        request.setAttribute("listCt", list.get(0));
        
        request.setAttribute("listHS", hangSuaSBLocal.docTatCa());
        request.setAttribute("listLS", loaiSuaSBLocal.docTatCa());
        request.setAttribute("listS", suaSBLocal.docTatCa());
        request.setAttribute("tongSoTrang", 4);
        request.getRequestDispatcher("views/danh-sach-sua.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
