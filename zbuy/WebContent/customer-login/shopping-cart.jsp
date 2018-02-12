<%@page import="io.zilker.zbuy.delegate.CustomerDBUtil, java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="io.zilker.zbuy.bean.*"%>

<%
	User user = (User) session.getAttribute("user");
	long userId = user.getUserId();

	CustomerDBUtil customerDBUtil = new CustomerDBUtil();
	List<CartItems> cartList = customerDBUtil.fetchCartItems(userId);

	pageContext.setAttribute("cartList", cartList);
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
				<input type="text " id="search-item"
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
						<li><a href="/zbuy/UserHandler?logout"> <span class="font-22"> <i
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
		<div id="article" class="article-customer">

			<div class="hr-space-2"></div>
			<span> <a href="index.jsp" class="remove-link-style"> <span
					class="home-icon"> <i class="fa fa-home" aria-hidden="true"></i>
				</span> Home
			</a>
			</span>

			<div class="hr-space-2"></div>

			<div onclick="deleteCartItem(event)">

				<c:forEach var="cartItem" items="${cartList}">




					<div class="cart-row">
						<div class=" white round-border-5 shadow">
							<span class="delete-cart-icon"> <i
								class="fa fa-trash color-red" data-id="${cartItem.itemId}"
								aria-hidden="true"></i>
							</span>
							<div class=" center col-xs-12 col-sm-1  col-md-1 col-lg-1 ">

								<div class="hr-space-2"></div>

								<img class="center col-xs-4 col-sm-12 col-md-12 col-lg-12"
									src="../assets/images/items/${cartItem.itemImage}" alt="">
								<div class=" hr-space-2 "></div>

							</div>

							<div
								class=" col-xs-12 col-sm-6 padding-top-1 padding-left-1 col-md-6  col-lg-6 align-top">
								<h3>${cartItem.itemName}</h3>
								<div class="color-success ">In stock</div>
								<div>
									Sold by <span class="color-primary">
										${cartItem.groceryName} </span>
								</div>
							</div>
							<div
								class=" col-xs-12 col-sm-2 padding-top-1  col-md-2 col-lg-2   align-top padding-left-1">
								<div class="hr-space-2"></div>
								<div class="inline-block color-primary bold">Quantity:</div>
								<select name="quanity" id="quantity">
									<option value="${cartItem.totalQuantity }">${cartItem.totalQuantity }</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
								</select>

							</div>
							<div
								class=" col-xs-12 col-sm-2 padding-top-1  col-md-2 col-lg-2   align-top padding-left-1">
								<div class="hr-space-2"></div>
								<div class="inline-block color-primary bold">price:</div>
								<span class="bold"> Rs. ${cartItem.itemPrice  * cartItem.totalQuantity}
									/-</span>
							</div>
							<div class=" hr-space-1 "></div>
						</div>
						<div class=" hr-space-2 "></div>
					</div>


				</c:forEach>

			</div>


			<div class="hr-space-4"></div>


			<div class="display-center">
				<button
					class="btn button btn-primary  col-xs-6 col-sm-4 col-md-2 col-lg-2"
					onclick="proceedToCheckout()">Proceed to Checkout</button>


			</div>



			<div class="hr-space-16"></div>


		</div>



	</div>

	<!-- Javasctipt External Links -->
	<script src="../js/script2.js"></script>

</body>

</html>