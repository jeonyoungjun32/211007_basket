package svc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Basket;

public class BasketCartQtyUpService {
	public void upBasketCartQty(String name, HttpServletRequest request) {
		
		//세션에 담고
		HttpSession session = request.getSession();
		
		//여기 cartList가 맞는지 모르겠네 
		ArrayList<Basket> cartList = (ArrayList<Basket>) session.getAttribute("cartList");
		
		
		//수량 증가 시키기 
		for(int i = 0;i<cartList.size();i++) {
			if(cartList.get(i).getBasket_name().equals(name)) {
				cartList.get(i).setQty(cartList.get(i).getQty()+1);
				break;
			}
		}
		
	}

}
