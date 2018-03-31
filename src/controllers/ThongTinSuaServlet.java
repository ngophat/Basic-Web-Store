package controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import sessionBeans.SuaSBLocal;

@WebServlet("/ThongTinSuaServlet")
public class ThongTinSuaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ThongTinSuaServlet() {
        super();
    }
    @EJB
    private SuaSBLocal suaSBLocal;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        //Thi sinh viet them cac lenh vao day de thuc hien
        String masua = request.getParameter("maSua");
        request.setAttribute("sua", suaSBLocal.timTheoMa(masua));
        request.getRequestDispatcher("views/thong-tin-sua.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
