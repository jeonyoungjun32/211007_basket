package svc;

import static db.Jdbcutil.close;
import static db.Jdbcutil.commit;
import static db.Jdbcutil.getConnection;
import static db.Jdbcutil.rollback;

import java.sql.Connection;

import dao.ProductDAO;
import vo.Product;

public class BaskeyCartRemoveService {
	// int baskte_num
	public boolean basketRemove(Product basket_num) throws Exception {

		Connection con = getConnection();

		ProductDAO productDAO = ProductDAO.getInstance();

		productDAO.setConnection(con);

		int basketDeleteCount = productDAO.getdeleteList(basket_num);

		boolean basketDelete = false;
		if (basketDeleteCount > 0) {
			commit(con);
			basketDelete = true;
		} else {
			rollback(con);
		}
		close(con);

		return basketDelete;

	}
}
