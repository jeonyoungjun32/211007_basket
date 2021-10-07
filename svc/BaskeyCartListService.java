package svc;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import vo.Basket;
import vo.Member;

import static db.Jdbcutil.close;
import static db.Jdbcutil.getConnection;
public class BaskeyCartListService {

	public ArrayList<Basket> getCartList(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		ArrayList<Basket> cartList = (ArrayList<Basket>) session.getAttribute("cartList"); // cartList는 어디서 셋팅 했냐 하면 CartAddService 에서 셋팅 시킨것이다
		
		
		return cartList;
		
	}
	//MemberDAO의 memberGetID 찾아봐라
	//누구누구님 의 장바구니 만들라고 하는중
	public String selectMember(String id)throws Exception{
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		String memberIdSelect = memberDAO.memberGetID(id);
		close(con);
		return memberIdSelect;
		
	}
}
