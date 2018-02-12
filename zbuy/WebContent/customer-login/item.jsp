<%@page
	import="io.zilker.zbuy.delegate.CustomerDBUtil, io.zilker.zbuy.bean.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%
	long itemId = Long.parseLong(request.getParameter("itemId"));

	CustomerDBUtil customerDBUtil = new CustomerDBUtil();

	Items item = customerDBUtil.getItemDetails(itemId);
	pageContext.setAttribute("item", item);
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

				</span> <span id="cart-number" class="cart-label">${sessionScope.user.cartCount }</span>

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
			<div class="row">
				<div class=" col-xs-12 col-sm-12  col-md-12 col-lg-12  ">
					<div class="box-body padding-0 white item-detail-container">
						<div class="hr-space-2"></div>

						<div class="padding-left-10">
							<span class="color-black font-26">${item.itemName}</span>
						</div>
						<div class=" hr-space-4 "></div>

						<div class="row ">
							<div
								class="item-detail-image flex-center col-xs-12 col-sm-6 col-md-6 col-lg-6 inline-block">
								<img class="  col-xs-8 col-sm-8  col-md-8 col-lg-8"
									src="../assets/images/items/${item.itemImage }"
									alt="item-image">
							</div>
							<div
								class="item-detail-box col-xs-12 col-sm-6 col-md-5 padding-left-10  col-lg-5 inline-block">
								<div class="hr-space-2"></div>
								<div>
									<h3>Rs. ${item.itemPrice} /-</h3>
								</div>

								<div class="color-black">
									<h3>About this item:</h3>
									<p>${item.itemDescription}</p>


									<h3>Ingredients:</h3>
									<p>${item.ingredients }</p>
								</div>
								<div class="hr-space-2"></div>
								<h3 class="color-black inline-block">Quantity</h3>
								<div class="inline-block padding-1">
									<select name="quantity" id="item-quantity">
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
										<option value="6">6</option>
										<option value="7">7</option>
										<option value="8">8</option>
									</select>
								</div>
								<div class="hr-space-2"></div>
								<div>
									<button class="btn btn-primary button  color-white"
										onclick="addToCart(${item.itemId})">Add to Cart</button>
									<button class="btn btn-primary button  color-white">Checkout</button>

								</div>
							</div>
						</div>
						<div class=" hr-space-4"></div>

					</div>
				</div>
			</div>

			<div class="hr-space-8"></div>

			<div class=" hr-space-4"></div>
		</div>



	</div>

	<!-- Javasctipt External Links -->
	<script src="../js/script2.js"></script>

</body>

</html>