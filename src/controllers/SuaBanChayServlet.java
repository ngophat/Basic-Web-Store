package controllers;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entityBeans.Sua;
import sessionBeans.CtHoadonSBLocal;
import sessionBeans.SuaSBLocal;

@WebServlet("/SuaBanChayServlet")
public class SuaBanChayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SuaBanChayServlet() {
		super();
	}

	@EJB
	private CtHoadonSBLocal ctHoadonLocal;

	@EJB
	private SuaSBLocal suaSBLocal;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		// Thi sinh viet them cac lenh vao day de thuc hien
		List<Sua> list = ctHoadonLocal.suaBanChay(5);
		request.setAttribute("listDS", list);
		Sua sua; 
		if(request.getParameter("maSua")==null) {
			sua = list.get(0);
		}else {
			String mahang = request.getParameter("maSua");
			sua = suaSBLocal.timTheoMa(mahang);
		}			
		request.setAttribute("Sua", sua);

		request.getRequestDispatcher("views/sua-ban-chay.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
