<%@page import="io.zillker.zbuy.factorydelegate.FactoryDelegate"%>
<%@page import="io.zilker.zbuy.Interface.OrderInterface"%>
<%@page import="io.zilker.zbuy.delegate.GroceryDBUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="io.zilker.zbuy.bean.*, java.util.*"%>

<%
	User user = (User) session.getAttribute("user");

	FactoryDelegate factoryDelegate = new FactoryDelegate();

	OrderInterface orderInterface = factoryDelegate.getOrderObject("Grocery");

	List<Orders> orderList = orderInterface.fetchOrders(user.getUserId());

	pageContext.setAttribute("listOfOrders", orderList);
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
<link
	href="../assets/Tiny-jQuery-Pagination-Widget-For-HTML-Table-table-hpaging/paging.css"
	rel="stylesheet" type="text/css" />
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script
	src="../assets/Tiny-jQuery-Pagination-Widget-For-HTML-Table-table-hpaging/scripts/jquery.table.hpaging.min.js"></script>

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
			<span class="menu-icon"> <i class="fa fa-bars"
				aria-hidden="true" onclick="navigationMenu()"></i>



			</span>

			<div class="profile-icon ">
				<i class="fa fa-user" aria-hidden="true"></i>
				<div class="menu-list">
					<ol class="profile-list">
						<li><a href="#settings"> <span class="font-22"> <i
									class="fa fa-cog profile-padding" aria-hidden="true"></i>
							</span> Settings
						</a></li>
						<li><a href="#orders"> <span class="font-20"> <i
									class="fa fa-motorcycle profile-padding" aria-hidden="true"></i>
							</span>Orders
						</a></li>
						<li><a href="/zbuy/UserHandler?logout"> <span
								class="font-22"> <i
									class="fa fa-sign-out profile-padding" aria-hidden="true"></i>
							</span> Log Out
						</a></li>
					</ol>
				</div>
			</div>
			<div class="notification-icon">
				<i class="fa fa-bell" aria-hidden="true"></i>
				<div class="menu-list notification-overflow">
					<div class="notification-content">
						<span> <img src="../assets/images/user-profile/user.png"
							height="70px" width="70px" alt="">
						</span> <span class="padding-2"> you received a new order from the
							customer Akash <span class="display-block padding-1"> <span
								class="color-primary"> Phone Number : </span> 9876554321
						</span>
						</span>
						<div></div>

					</div>
					<div class="notification-content">
						<span> <img src="../assets/images/user-profile/user.png"
							height="70px" width="70px" alt="">
						</span> <span class="padding-2"> you received a new order from the
							customer Akash <span class="display-block padding-1"> <span
								class="color-primary"> Phone Number : </span> 9876554321
						</span>
						</span>
						<div></div>

					</div>
					<div class="notification-content">
						<span> <img src="../assets/images/user-profile/user.png"
							height="70px" width="70px" alt="">
						</span> <span class="padding-2"> you received a new order from the
							customer Akash <span class="display-block padding-1"> <span
								class="color-primary"> Phone Number : </span> 9876554321
						</span>
						</span>
						<div></div>

					</div>
					<div class="notification-content">
						<span> <img src="../assets/images/user-profile/user.png"
							height="70px" width="70px" alt="">
						</span> <span class="padding-2"> you received a new order from the
							customer Akash <span class="display-block padding-1"> <span
								class="color-primary"> Phone Number : </span> 9876554321
						</span>
						</span>
						<div></div>

					</div>
					<div class="notification-content">
						<span> <img src="../assets/images/user-profile/user.png"
							height="70px" width="70px" alt="">
						</span> <span class="padding-2"> you received a new order from the
							customer Akash <span class="display-block padding-1"> <span
								class="color-primary"> Phone Number : </span> 9876554321
						</span>
						</span>
						<div></div>

					</div>
					<div class="notification-content">
						<span> <img src="../assets/images/user-profile/user.png"
							height="70px" width="70px" alt="">
						</span> <span class="padding-2"> you received a new order from the
							customer Akash <span class="display-block padding-1"> <span
								class="color-primary"> Phone Number : </span> 9876554321
						</span>
						</span>
						<div></div>

					</div>
					<div class="notification-content">
						<span> <img src="../assets/images/user-profile/user.png"
							height="70px" width="70px" alt="">
						</span> <span class="padding-2"> you received a new order from the
							customer Akash <span class="display-block padding-1"> <span
								class="color-primary"> Phone Number : </span> 9876554321
						</span>
						</span>
						<div></div>

					</div>
					<div class="notification-content">
						<span> <img src="../assets/images/user-profile/user.png"
							height="70px" width="70px" alt="">
						</span> <span class="padding-2"> you received a new order from the
							customer Akash <span class="display-block padding-1"> <span
								class="color-primary"> Phone Number : </span> 9876554321
						</span>
						</span>
						<div></div>

					</div>
					<div class="notification-content">
						<span> <img src="../assets/images/user-profile/user.png"
							height="70px" width="70px" alt="">
						</span> <span class="padding-2"> you received a new order from the
							customer Akash <span class="display-block padding-1"> <span
								class="color-primary"> Phone Number : </span> 9876554321
						</span>
						</span>
						<div></div>

					</div>
				</div>

			</div>

		</div>








	</header>


	<div class="body-container">

		<div class="navigation display-none" id="navigation">
			<ol class="ordered-list">
				<li><a href="index.jsp"> <i class="fa fa-home"
						aria-hidden="true"> </i> Home
				</a></li>
				<li class="active"><a href="orders.jsp"> <i
						class="fa fa-motorcycle" aria-hidden="true"> </i>Orders
				</a></li>
				<li><a href="products.jsp"> <i class="fa fa-cubes"
						aria-hidden="true"> </i>Products
				</a></li>
				<li><a href="customers.jsp"> <i class="fa fa-users"
						aria-hidden="true"> </i>Customers
				</a></li>
				<li><a href="marketing.jsp"> <i class="fa fa-suitcase"
						aria-hidden="true"> </i> Marketing
				</a></li>
			</ol>
		</div>



		<div id="article" class="article  ">

			<div class="hr-space-4"></div>

			<!-- processed blue, delivered green, rejected red -->



			<div class="row">
				<div
					class="col-xs-12  col-sm-12  col-md-12 col-lg-12  box  bootstrap-table ">
					<div class="box-header">Recent Orders</div>
					<div class="box-body">
						<div class="responsive-table">
							<table id="table1" class="design-table">
								<thead>
									<tr>
										<th>Status</th>
										<th>Order Id</th>
										<th>Customer Name</th>
										<th>Date</th>
										<th>Total Price</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="order" items="${listOfOrders}">
										<tr>
											<td><c:if test="${order.status == 'Processed' }">
													<span class="processed span-table"> ${order.status }</span>
												</c:if> <c:if test="${order.status == 'Pending' }">
													<span class="pending span-table"> ${order.status }</span>
												</c:if> <c:if test="${order.status == 'Delivered' }">
													<span class="delivered span-table"> ${order.status }</span>
												</c:if> <c:if test="${order.status == 'Rejected' }">
													<span class="rejected span-table"> ${order.status }</span>
												</c:if></td>
											<td><a class="customer-name"
												href="orders/order.jsp?OrderId=${order.orderId }">
													${order.orderId } </a></td>
											<td>${order.customerName }</td>
											<td>${order.orderDate }</td>
											<td>Rs. ${order.amount }</td>
										</tr>
									</c:forEach>

								</tbody>

							</table>

						</div>


						<div class="hr-space-2"></div>
						<nav aria-label="Page navigation">
							<ul class="pagination" id="pagination"></ul>
						</nav>



					</div>


				</div>



			</div>


			<!-- <div class="hr-space-4"></div> -->

		</div>
	</div>

	<!-- Javasctipt External Links -->
	<script src="../js/script.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#table1").hpaging({
				"limit" : 7
			});
		});
	</script>
</body>

</html>