<%@page import="sun.security.mscapi.CKeyPairGenerator.RSA"%>
<%@page import="vo.Product"%>
<%@page import="baskeyCart.BaskeyCartListAction"%>
<%@page import="vo.Basket"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	ArrayList<Basket> CartList = (ArrayList<Basket>) session.getAttribute("cartList"); /* 다 뽑아내야지 */
Object totalMoney = request.getAttribute("totalMoney");/* 총 금액 */
String remove = request.getParameter("remove");/* 삭제 */
/* Object members= request.getAttribute("member");/* 누구누구님 의 장바구니 만들어보자 */ 
Object membera = request.getAttribute("member");

%>

<script type="text/javascript">
	function checkAll(theForm) {
		if (theForm.remove.length == undefined) {
			theForm.remove.checked = theForm.allCheck.checked;
		} else {
			for (var i = 0; i < theForm.remove.length; i++) {
				theForm.remove[i].checked = theForm.allCheck.checked;
			}
		}
	}

	function checkQty(name, qty) {
		if (qty != 1) {
			location.href = "basketCartQtyDown.bk?encodingName="
					+ encodeURIComponent(name);
		}
	}
</script>

<%@include file="header.jsp"%>


<h2><%= membera %>의 장바구니</h2>
<h2 id="basket">장바구니 목록</h2>

<%
	if (CartList.isEmpty()) {
%>
상품이 없습니다
<%
	} else {
%>
<%
	int j = 1;
for (int i = 0; i < CartList.size(); i++) {
%>
<!-- <form action="basketCartRemove.bk" name="f" method="post"> -->
	<table id="basketTable" border="1">
		<tr>
			<th><input type="checkbox" name="allCheck" onclick="checkAll(this.form)"> </th>
			<th>번호</th>
			<th>상품 번호</th>
			<th>상품 이름</th>
			<th>상품 종류</th>
			<th>상품 수량</th>
			<th>상품 가격</th>
			<th>총 금액</th>
			<th colspan="2">구매한 수량</th>
			<th>상품삭제</th>
			<th>쇼핑계속하기</th>
		</tr>

		<tr>
			<td><input type="checkbox" name="allCheck"
				onclick="checkAll(this.form)"> <label for="allCheck">전체
					상품 선택</label></td>
			<td><%=j++%></td>
			<td><%=CartList.get(i).getBasket_num()%></td>
			<td><%=CartList.get(i).getBasket_name()%></td>
			<%
				if (CartList.get(i).getBasket_choice().equalsIgnoreCase("1")) {
			%>
			<td>케이크</td>
			<%
				} else if (CartList.get(i).getBasket_choice().equalsIgnoreCase("2")) {
			%>
			<td>음료</td>
			<%
				} else if (CartList.get(i).getBasket_choice().equalsIgnoreCase("3")) {
			%>
			<td>커피</td>
			<%
				} else if (CartList.get(i).getBasket_choice().equalsIgnoreCase("4")) {
			%>
			<td>디저트</td>
			<%
				} else if (CartList.get(i).getBasket_choice().equalsIgnoreCase("5")) {
			%>
			<td>아이스크림</td>
			<%
				}
			%>
			<td><%=CartList.get(i).getBasket_count()%></td>
			<td><%=CartList.get(i).getBasket_price()%></td>
			<%
				int money = CartList.get(i).getBasket_price() * CartList.get(i).getQty();
			%>
			<td>총 금액 : <%=money%>&nbsp;
			</td>
			<%-- <td ><%=CartList.get(i).getQty()%>개</td> --%>
			<td><a
				href="basketCartQtyUp.bk?encodingName=<%=CartList.get(i).getEncodingName()%>"><img
					src="img/up.jpg" id="upImg"></a> <br> <%=CartList.get(i).getQty()%>
				<br> <a
				href="basketCartQtyDown.bk?encodingName=<%=CartList.get(i).getEncodingName()%>&qty=<%=CartList.get(i).getQty()%>">
					<img src="img/down.jpg" id="downImg">
			</a></td>

			<td rowspan="2">구매</td>
			<td><input type="submit" value="삭제"></td>

			<td><a href="iceCakeList.bk"> 쇼핑 계속하기</a></td>
		</tr>
	</table>
	<%
		}
	%>

	<table border="1">
		<tr>
			<th>총 상품 금액</th>
			<th>포인트 금액</th>

		</tr>

		<%
			for (int i = 0; i < CartList.size(); i++) {
			int basketmoney = CartList.get(i).getBasket_price();
			int basketTotalmoney = 0;
			basketTotalmoney += basketmoney;
		%>


		<%
			}
		%>
		<tr>
			<td><%=totalMoney %>원 입니다</td>
			<td>포인트 금액</td>

		</tr>

	</table>
<!-- </form> -->
<%
	}
%>






