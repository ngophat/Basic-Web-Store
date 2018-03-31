package controllers;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.weld.context.ejb.Ejb;

import entityBeans.HangSua;
import entityBeans.LoaiSua;
import entityBeans.Sua;
import sessionBeans.HangSuaSBLocal;
import sessionBeans.LoaiSuaSBLocal;
import sessionBeans.SuaSBLocal;

@WebServlet("/ThemSuaMoiServlet")
public class ThemSuaMoiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ThemSuaMoiServlet() {
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
        request.getRequestDispatcher("views/them-sua-moi.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
      
        //Thi sinh viet them cac lenh vao day de thuc hien
        List<LoaiSua> listLs = loaiSuaSBLocal.docTatCa();
        List<HangSua> listHs = hangSuaSBLocal.docTatCa();
        if(request.getParameter("btnThemMoi")!=null) {
        	Sua sua = new Sua();
        	String hangSua, hinh, loaiSua, loiIch, maSua, tenSua, tpDinhDuong;
        	int donGia, trongLuong;
        	
        	donGia = Integer.parseInt(request.getParameter("txtDonGia"));
        	trongLuong = Integer.parseInt(request.getParameter("txtTrongLuong"));
        	hangSua = request.getParameter("cboHangSua");
        	hinh = request.getParameter("txtHinh");
        	loaiSua = request.getParameter("cboLoaiSua");
        	loiIch = request.getParameter("txtLoiIch");
        	maSua = request.getParameter("txtMaSua");
        	tenSua = request.getParameter("txtTenSua");
        	tpDinhDuong = request.getParameter("txtTPDinhDuong");
        	
        	sua.setDon_gia(donGia);
        	sua.setTrong_luong(trongLuong);
        	sua.setHangSua(hangSuaSBLocal.timTheoMa(hangSua));
        	sua.setHinh(hinh);
        	sua.setLoaiSua(loaiSuaSBLocal.timTheoMa(loaiSua));
        	sua.setLoi_ich(loiIch);
        	sua.setMa_sua(maSua);
        	sua.setTen_sua(tenSua);
        	sua.setTp_dinh_duong(tpDinhDuong);
        	
        	suaSBLocal.themSua(sua);
        }
        request.setAttribute("listLS", listLs);
        request.setAttribute("listHS", listHs);
        request.getRequestDispatcher("views/them-sua-moi.jsp").include(request, response);
	}

}
