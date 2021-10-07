package baskeyCart;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.action.Action;
import svc.BasektCartQtyDownService;
import vo.ActionForward;

public class BaskeyCartQtyDownAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO 수량 감소
		String name = request.getParameter("encodingName");
		
		BasektCartQtyDownService basektCartQtyDownService = new BasektCartQtyDownService(); 
		basektCartQtyDownService.BasketCartQtyDown(name, request);
		
		
		//아니 -1로 넘어가면 안되게 하는데 ㅅㅂ 왜 안되지
		if(basektCartQtyDownService != null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('1개 이상부터 구매하실 수 있습니다.');");
			out.print("history.back();");
			out.print("</script>");
		}
		
		
		return new ActionForward("baskeyCartList.bk", true);
	}

}
