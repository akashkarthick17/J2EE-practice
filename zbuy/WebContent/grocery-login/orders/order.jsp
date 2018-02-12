<%@page import="io.zilker.zbuy.utility.Constants"%>
<%@page import="io.zilker.zbuy.bean.OrderDetails"%>
<%@page import="java.util.*"%>
<%@page import="io.zilker.zbuy.delegate.GroceryDBUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	long orderId = Long.parseLong(request.getParameter("OrderId"));

	GroceryDBUtil groceryDBUtil = new GroceryDBUtil();

	List<OrderDetails> orderDetailsList = groceryDBUtil.getOrderDetails(orderId);

	// Calculate Total amount of the order
	double totalAmount = groceryDBUtil.getTotalAmount(orderDetailsList);

	// Get the order Status
	String status = groceryDBUtil.getOrderStatus(orderId);

	pageContext.setAttribute("orderDetailsList", orderDetailsList);
	pageContext.setAttribute("totalAmount", totalAmount);
	pageContext.setAttribute("orderId", orderId);
	pageContext.setAttribute("status", status);
%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<title>Grocery Login</title>

<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous"> -->
<!-- <link href="http://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css"> -->

<!-- CSS External Links -->
<link rel="stylesheet" href="../../css/style.css">
<link rel="stylesheet" href="../../css/reusable-style.css">
<link rel="stylesheet"
	href="../../assets/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="../../css/media-query.css">



</head>

<body>

	<header>

		<div class="app-header">
			<div class="app-title">Z Buy</div>
		</div>
		<div class="app-menu">
			<span class="menu-icon"> <i class="fa fa-bars"
				aria-hidden="true" onclick="navigationMenu()"></i>
			</span> <span class="profile-icon"> <i class="fa fa-user"
				aria-hidden="true"></i>
			</span> <span class="notification-icon"> <i class="fa fa-bell"
				aria-hidden="true"></i>
			</span>

		</div>

		<div class="user-profile"></div>

	</header>


	<div class="body-container">

		<div class="navigation display-none" id="navigation">
			<ol class="ordered-list">
				<li><a href="../index.jsp"> <i class="fa fa-home"
						aria-hidden="true"> </i> Home
				</a></li>
				<li class="active"><a href="../orders.jsp"> <i
						class="fa fa-motorcycle" aria-hidden="true"> </i>Orders
				</a></li>
				<li><a href="../products.jsp"> <i class="fa fa-cubes"
						aria-hidden="true"> </i>Products
				</a></li>
				<li><a href="../customers.jsp"> <i class="fa fa-users"
						aria-hidden="true"> </i>Customers
				</a></li>
				<li><a href="../marketing.jsp"> <i class="fa fa-suitcase"
						aria-hidden="true"> </i> Marketing
				</a></li>
			</ol>
		</div>



		<div id="article" class="article  ">

			<div class="hr-space-4"></div>



			<div class="row">
				<div
					class="col-xs-12  col-sm-12  col-md-12 col-lg-12  box  bootstrap-table ">
					<div class="box-header">Order Details</div>
					<div class="box-body">
						<div class="responsive-table">
							<table id="table1" class="design-table">
								<thead>
									<tr>
										<th>Item Id</th>
										<th>Item Name</th>
										<th>Quantity</th>
										<th>Amount</th>
									</tr>
								</thead>
								<tbody>

									<c:forEach var="orderDetails" items="${orderDetailsList}">

										<tr>
											<td><a href="#" class="customer-name">
													${orderDetails.itemId } </a></td>
											<td>${orderDetails.itemName }</td>
											<td>${orderDetails.totalQuantity }</td>
											<td>${orderDetails.totalPrice }</td>
										</tr>

									</c:forEach>

									<tr>
										<td class="bold color-red" colspan="3">Total Amount</td>
										<td class="bold color-red">${totalAmount }</td>
									</tr>

								</tbody>

							</table>

						</div>


						<div class="hr-space-2"></div>
						<nav aria-label="Page navigation">
							<ul class="pagination" id="pagination"></ul>
						</nav>



					</div>


				</div>

				<form>
					<input type="hidden" name="order-id" id="order-id"
						value="${orderId}">
				</form>

				<div class="hr-space-4"></div>

				<%
					if (status.equals(Constants.STATUS_PENDING)) {
				%>
				<div class="display-center">
					<button
						class="btn button btn-primary  col-xs-6 col-sm-4 col-md-2 col-lg-2"
						onclick="deliverProducts()">Deliver Products</button>


				</div>


				<%
					} else {
				%>

				<%
					}
				%>




			</div>


			<!-- <div class="hr-space-4"></div> -->

		</div>
	</div>

	<!-- Javasctipt External Links -->
	<script src="../../js/script.js"></script>
	<script src="../../js/script2.js"></script>
</body>

</html>