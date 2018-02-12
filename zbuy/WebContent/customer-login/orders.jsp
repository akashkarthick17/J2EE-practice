<%@page import="io.zillker.zbuy.factorydelegate.FactoryDelegate"%>
<%@page import="io.zilker.zbuy.bean.Orders"%>
<%@page import="java.util.List"%>
<%@page import="io.zilker.zbuy.Interface.OrderInterface"%>
<%@page import="io.zilker.zbuy.factory.GetOrderFactory"%>
<%@page import="io.zilker.zbuy.bean.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	User user = (User) session.getAttribute("user");

	GetOrderFactory getOrderFactory = new GetOrderFactory();

	FactoryDelegate factoryDelegate = new FactoryDelegate();

	OrderInterface orderInterface = factoryDelegate.getOrderObject("Customer");

	List<Orders> orderList = orderInterface.fetchOrders(user.getUserId());

	pageContext.setAttribute("orderList", orderList);
%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<title>Z Buy</title>

<!-- CSS External Links -->
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" href="../css/reusable-style.css">
<link rel="stylesheet"
	href="../assets/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="../css/media-query.css">



</head>

<body>

	<header>

		<div class="app-header">
			<div class="app-title">Z Buy</div>
		</div>
		<div class="app-menu">
			<div
				class="inline-block search-bar col-xs-8 col-sm-6 col-md-7 col-lg-8">
				<input type="text" id="search-item"
					class="height-100 round-text-box  "
					placeholder="Enter Item Name to search">
			</div>

			<div class="profile-icon ">
				<i class="fa fa-user" aria-hidden="true"></i>
				<div class="menu-list">
					<ol class="profile-list">
						<li><a href="#settings"> <span class="font-22"> <i
									class="fa fa-cog profile-padding" aria-hidden="true"></i>
							</span> Settings
						</a></li>
						<li><a href="orders.jsp"> <span class="font-20"> <i
									class="fa fa-motorcycle profile-padding" aria-hidden="true"></i>
							</span>Your Orders
						</a></li>
						<li><a href="/zbuy/UserHandler?logout"> <span
								class="font-22"> <i
									class="fa fa-sign-out profile-padding" aria-hidden="true"></i>
							</span> Log Out
						</a></li>
					</ol>
				</div>
			</div>
			<div class="cart-icon">
				<span> <i class="fa fa-shopping-cart" id="cart-icon"
					aria-hidden="true" onclick="shoppingCart()"></i>

				</span> <span for="cart-icon" class="cart-label">${sessionScope.user.cartCount }</span>

			</div>

		</div>
	</header>

	<div class="body-container-customer">
		<div id="article" class="article-customer  ">
			<div class="hr-space-2"></div>
			<span> <a href="index.jsp" class="remove-link-style"> <span
					class="home-icon"> <i class="fa fa-home" aria-hidden="true"></i>
				</span> Home
			</a>
			</span>
			<div class="hr-space-2"></div>


			<c:forEach var="order" items="${orderList}">

				<div class="order-row">
					<div class=" col-xs-12 col-sm-12  col-md-12 col-lg-12  ">
						<div class="box-body">
							<div class="hr-space-2"></div>
							<div class=" col-xs-12 col-sm-3 col-md-3 col-lg-3 padding-10 ">
								<div class="color-primary bold">Order Id:</div>
								<div class="inline-block color-black">${order.orderId}

									<div>

										<span>Shop Name: </span>${order.groceryName }
									</div>

								</div>
							</div>
							<div class="col-xs-5 col-sm-2 col-md-3 col-lg-3 padding-10 ">
								<div class=" color-primary bold">Placed on:</div>
								<div class="   color-black">${order.orderDate }</div>

							</div>
							<div class="col-xs-5 col-sm-2 col-md-3 col-lg-3 padding-10 ">
								<div class="color-primary bold left">Total:</div>
								<div class="color-black">Rs. ${order.amount }</div>

							</div>
							<div class="col-xs-12 col-sm-3 col-md-2 col-lg-2 padding-10 ">
								<button
									class="button btn btn-primary col-xs-8 col-sm-12 col-md-12  col-lg-12">Order
									Details</button>

							</div>
							<div class=" hr-space-2 "></div>

						</div>
					</div>
					<div class=" hr-space-2 "></div>
				</div>

			</c:forEach>




			<div class="hr-space-4"></div>

		</div>



	</div>

	<!-- Javascript External Links -->
	<script src="../js/script.js"></script>

</body>

</html>