package svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.MyPageDAO;
import dao.ProductDAO;

import static db.Jdbcutil.*;

import vo.Member;
import vo.MemberOrder;
import vo.Product;

public class OrderService {

	//OrderResultProAction
	public boolean insertOrder(ArrayList<Product> productList, int[] Count, Member member, String howchoice, int resultMoney, int resultPoint) throws Exception {
		Connection con = getConnection();
		
		ProductDAO productDAO = ProductDAO.getInstance();
		
		productDAO.setConnection(con);
		
		int insertCount = productDAO.insertOrder(productList,Count,member,howchoice);
		
		int ReturnValue = productDAO.insertIO_Out(productList,Count);
		
		int moneyUpdateCount = productDAO.moneyUpdateMember(member,resultMoney,resultPoint);
		
		boolean insertSuccess = false;
		
		if(insertCount > 0) {
			if(ReturnValue >0) {
				if(moneyUpdateCount>0) {
				commit(con);
				insertSuccess = true;
				} else {
					rollback(con);
				}
			} else {
				rollback(con);
			}
		} else {
			rollback(con);
		}
		close(con);
		
		return insertSuccess;
	}

	//AdminOrderProAction
	public ArrayList<MemberOrder> allListOrder() throws Exception {
		Connection con = getConnection();
		
		MyPageDAO myPageDAO = MyPageDAO.getInstance();
		
		myPageDAO.setConnection(con);
		
		ArrayList<MemberOrder> memberAllOrderList = myPageDAO.allListOrder();
		
		close(con);
		
		return memberAllOrderList;
	}
	

}
