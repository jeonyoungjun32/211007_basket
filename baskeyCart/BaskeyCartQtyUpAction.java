package baskeyCart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.action.Action;
import svc.BasketCartQtyUpService;
import vo.ActionForward;

public class BaskeyCartQtyUpAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO 수량 올리기
		String name = request.getParameter("encodingName");
		
		BasketCartQtyUpService basketCartQtyUpService = new BasketCartQtyUpService();
		basketCartQtyUpService.upBasketCartQty(name, request);
		
		
		return new ActionForward("baskeyCartList.bk", true);
	}

}
