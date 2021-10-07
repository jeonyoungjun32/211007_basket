package baskeyCart;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.action.Action;
import sun.security.mscapi.CKeyPairGenerator.RSA;
import svc.BaskeyCartListService;
import vo.ActionForward;
import vo.Basket;
import vo.Member;

public class BaskeyCartListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO 자동 생성된 메소드 스텁

		BaskeyCartListService baskeyCartListService = new BaskeyCartListService();
		
		
		
		
		ArrayList<Basket> cartList = baskeyCartListService.getCartList(request);
		String member = baskeyCartListService.selectMember("id");

		System.out.println("carListService의 안에 있는 selectMember의 값은?	: "+member);
		
		
		
		int totalMoney = 0;
		int money = 0;

		for (int i = 0; i < cartList.size(); i++) {
			money = cartList.get(i).getBasket_price()*cartList.get(i).getQty();
			totalMoney += money;
		}
		System.out.println(totalMoney+"총 금액");

		request.setAttribute("totalMoney", totalMoney);
		request.setAttribute("baskeyCartListService", baskeyCartListService);
		
		request.setAttribute("member", member);

		ActionForward forward = new ActionForward("baskeyCartList.jsp", false);// "디스패치 방식"으로 포워딩

		return forward;
	}

}
