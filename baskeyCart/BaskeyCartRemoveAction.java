package baskeyCart;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.action.Action;
import svc.BaskeyCartRemoveService;
import vo.ActionForward;
import vo.Product;

public class BaskeyCartRemoveAction implements Action {

	private static final ArrayList<Product> BaskeyCartRemoveService = null;

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO 장바구니에 있는걸 삭제
		//baskeyCartList.jsp에서 쓸라고 remove 씀 
		String [] nameArray = request.getParameterValues("remove");  
		
		HttpSession session = request.getSession();
		
		if(nameArray == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('뭐가 null이면?');");
			out.print("history.back();");
			out.print("</script>");
			
		}
		
		BaskeyCartRemoveService baskeyCartRemoveService = new BaskeyCartRemoveService(); 
		
		baskeyCartRemoveService.basketRemove(request, nameArray);
		
		return new ActionForward("baskeyCartList.bk", true);
	}

}
