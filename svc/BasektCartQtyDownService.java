package svc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Basket;

public class BasektCartQtyDownService {

	public void BasketCartQtyDown(String name , HttpServletRequest request) {
		
		HttpSession session =  request.getSession();
		
		ArrayList<Basket> cartList = (ArrayList<Basket>) session.getAttribute("cartList");
		
		for (int i = 0; i < cartList.size(); i++) {
			if(cartList.get(i).getBasket_name().equals(name)) {
				cartList.get(i).setQty(cartList.get(i).getQty()-1);
				break;
			}
		}
		
	}
}
