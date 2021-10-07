package svc;

import static db.Jdbcutil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ProductDAO;
import vo.IO;
import vo.Product;

public class ProductService {

	//IceCakeIngredientListAction
	// IcecreamListAction - 아이스크림
	public ArrayList<Product> getListIcecream() throws Exception {
		Connection con = getConnection();

		ProductDAO productDAO = ProductDAO.getInstance();

		productDAO.setConnection(con);

		ArrayList<Product> icecreamList = productDAO.getListIcecream();

		close(con);

		return icecreamList;
	}
	
	//IceCakeIngredientListAction
	//IceCakeListAction - 아이스케이크
	public ArrayList<Product> getListIceCake() throws Exception {
		Connection con = getConnection();
		
		ProductDAO productDAO = ProductDAO.getInstance();
		
		productDAO.setConnection(con);
		
		ArrayList<Product> iceCakeList = productDAO.getListIceCake();
		
		close(con);
		
		return iceCakeList;
	}

	//DessertIngredientListAction
	//DessertListAction - 디저트
	public ArrayList<Product> getListDessert() throws Exception {
		Connection con = getConnection();
		
		ProductDAO productDAO = ProductDAO.getInstance();
		
		productDAO.setConnection(con);
		
		ArrayList<Product> dessertList = productDAO.getListDessert();
		
		close(con);
		
		return dessertList;
	}

	//BeverageIngredientListAction
	//BeverageListAction - 음료
	public ArrayList<Product> getListBeverage() throws Exception {
		Connection con = getConnection();
		
		ProductDAO productDAO = ProductDAO.getInstance();
		
		productDAO.setConnection(con);
		
		ArrayList<Product> beverageList = productDAO.getListBeverage();
		
		close(con);
		
		return beverageList;
	}
	
	//CoffeeIngredientListAction
	//CoffeeListAction - 커피
	public ArrayList<Product> getListCoffee() throws Exception {
		Connection con = getConnection();
		
		ProductDAO productDAO = ProductDAO.getInstance();
		
		productDAO.setConnection(con);
		
		ArrayList<Product> coffeeList = productDAO.getListCoffee();
		
		close(con);
		
		return coffeeList;
	}

	// AdminProductInserProAction : 상품 등록
	public boolean insertProduct(Product product, String id) throws Exception {

		Connection con = getConnection();

		ProductDAO productDAO = ProductDAO.getInstance();

		productDAO.setConnection(con);

		int insertCount = productDAO.insertProduct(product, id);

		boolean insertSuccess = false;
		if (insertCount > 0) {
			commit(con);
			insertSuccess = true;
		} else {
			rollback(con);
		}
		close(con);

		return insertSuccess;
	}

	//AdminProductFormAction
	//AdminProductUpdateFormAction
	// 상품 코드로 상품 찾기
	public Product getProduct(int serial_code) throws Exception {
		Connection con = getConnection();

		ProductDAO productDAO = ProductDAO.getInstance();

		productDAO.setConnection(con);

		Product product = productDAO.getFindCode(serial_code);

		close(con);

		return product;
	}
	
	// AdminProductDeleteProAction
	// AdminIOFormAction
	// 체크된 물건 찾기
	public ArrayList<Product> getProduct(String[] productCheckCode) throws Exception {
		Connection con = getConnection();

		ProductDAO productDAO = ProductDAO.getInstance();

		productDAO.setConnection(con);

		ArrayList<Product> productList = productDAO.adminGetProduct(productCheckCode);

		close(con);

		return productList;
	}
	
	// AdminProductDeleteProAction - 상품 삭체 요청
	public boolean productAllDelete(Product products) throws Exception {
		Connection con = getConnection();

		ProductDAO productDAO = ProductDAO.getInstance();

		productDAO.setConnection(con);

		int productAllDeleteCount = productDAO.ProductAllDelete(products);

		boolean productDeleteSuccess = false;
		if (productAllDeleteCount > 0) {
			commit(con);
			productDeleteSuccess = true;
		} else {
			rollback(con);
		}
		close(con);

		return productDeleteSuccess;
	}

	// AdminProductListFormAction
	public int getProductListCount(int intViewSelect) throws Exception {
		Connection con = getConnection();

		ProductDAO productDAO = ProductDAO.getInstance();

		productDAO.setConnection(con);

		int productListCount = productDAO.getProductListCount(intViewSelect);

		close(con);

		return productListCount;
	}
	
	// AdminProductListFormAction(수정중)
	public void getProductListSelect(int intViewSelect) throws Exception {
		Connection con = getConnection();

		ProductDAO productDAO = ProductDAO.getInstance();

		productDAO.setConnection(con);

		productDAO.getProductListSelect(intViewSelect);

		close(con);
	}
	
	// OrderPageSelectDetailAction
	// 주문에서 선택한 상품을 찾아서 상세내역에 돌려주기
	public ArrayList<Product> getListProduct(int[] intCode) throws Exception {
		Connection con = getConnection();

		ProductDAO productDAO = ProductDAO.getInstance();

		productDAO.setConnection(con);

		ArrayList<Product> productList = productDAO.getProductListDetail(intCode);

		close(con);

		return productList;
	}
	
	// AdminProductListFormAction - 물건 리스트
	public ArrayList<Product> getListProduct() throws Exception {
		Connection con = getConnection();

		ProductDAO productDAO = ProductDAO.getInstance();

		productDAO.setConnection(con);

		ArrayList<Product> productList = productDAO.getListProduct();

		close(con);

		return productList;
	}
	
	// AdminProductUpdateProAction
	public boolean getProductUpdate(int serial_code, String name, String allergy, int kcal, int price) throws Exception {
		Connection con = getConnection();

		ProductDAO productDAO = ProductDAO.getInstance();

		productDAO.setConnection(con);

		int productUpdateCount = productDAO.productUpdate(serial_code, name, allergy, kcal, price);

		boolean productUpdateSuccess = false;
		if (productUpdateCount > 0) {
			productUpdateSuccess = true;
			commit(con);
		} else {
			rollback(con);
		}
		close(con);

		return productUpdateSuccess;
	}
	
	// AdminIOProAction
	public boolean adminIOUpdate(int[] intSerial_code, int[] product_count) throws Exception {
		Connection con = getConnection();

		ProductDAO productDAO = ProductDAO.getInstance();

		productDAO.setConnection(con);

		int IOValue = productDAO.AdminIOinsert(intSerial_code, product_count);

		boolean IOSuccess = false;
		if (IOValue > 0) {
			commit(con);
			IOSuccess = true;
		} else {
			rollback(con);
		}
		close(con);

		return IOSuccess;
	}
	
	// AdminIOListProAction
	public int getIOListCount() throws Exception {
		Connection con = getConnection();

		ProductDAO productDAO = ProductDAO.getInstance();

		productDAO.setConnection(con);

		int IOListCount = productDAO.selectIOListCount();

		close(con);

		return IOListCount;
	}

	// AdminIOListProAction
	public ArrayList<IO> getIOList(int page, int intviewCount) throws Exception {
		Connection con = getConnection();

		ProductDAO productDAO = ProductDAO.getInstance();

		productDAO.setConnection(con);

		ArrayList<IO> ioList = productDAO.selectIOlist(page, intviewCount);

		close(con);

		return ioList;
	}
}
