<%@page import="io.zilker.zbuy.delegate.GroceryDBUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="io.zilker.zbuy.bean.*, java.util.*"%>

<%
	User user = (User) session.getAttribute("user");
	String groceryName = user.getUserName();
	long groceryId = user.getUserId();

	// Get list of Products from the Grocery ID
	GroceryDBUtil groceryDB = new GroceryDBUtil();
	List<Items> itemsList = groceryDB.retrieveAllItems(groceryId);

	pageContext.setAttribute("itemsList", itemsList);
%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<!-- CSS External Links -->
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" href="../css/reusable-style.css">
<link rel="stylesheet"
	href="../assets/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="../css/media-query.css">


<title>Welcome <%=groceryName%></title>
</head>

<body>

    <header>

        <div class="app-header">
            <div class="app-title">Z Buy</div>
        </div>
        <div class="app-menu">
            <span class="menu-icon">
                <i class="fa fa-bars" aria-hidden="true" onclick="navigationMenu()"></i>



            </span>

            <div class="profile-icon ">
                <i class="fa fa-user" aria-hidden="true"></i>
                <div class="menu-list">
                    <ol class="profile-list">
                        <li>
                            <a href="#settings">
                                <span class="font-22">
                                    <i class="fa fa-cog profile-padding" aria-hidden="true"></i>
                                </span> Settings</a>
                        </li>
                        <li>
                            <a href="#orders">
                                <span class="font-20">
                                    <i class="fa fa-motorcycle profile-padding" aria-hidden="true"></i>
                                </span>Orders</a>
                        </li>
                        <li>
                            <a href="/zbuy/UserHandler?logout">
                                <span class="font-22">
                                    <i class="fa fa-sign-out profile-padding" aria-hidden="true"></i>
                                </span> Log Out</a>
                        </li>
                    </ol>
                </div>
            </div>
            <div class="notification-icon">
                <i class="fa fa-bell" aria-hidden="true"></i>
                <div class="menu-list notification-overflow">
                    <div class="notification-content">
                        <span>
                            <img src="../assets/images/user-profile/user.png" height="70px" width="70px" alt="">
                        </span>
                        <span class="padding-2"> you received a new order from the customer Akash
                            <span class="display-block padding-1">
                                <span class="color-primary"> Phone Number : </span> 9876554321</span>
                        </span>
                        <div>

                        </div>

                    </div>
                    <div class="notification-content">
                        <span>
                            <img src="../assets/images/user-profile/user.png" height="70px" width="70px" alt="">
                        </span>
                        <span class="padding-2"> you received a new order from the customer Akash
                            <span class="display-block padding-1">
                                <span class="color-primary"> Phone Number : </span> 9876554321</span>
                        </span>
                        <div>

                        </div>

                    </div>
                    <div class="notification-content">
                        <span>
                            <img src="../assets/images/user-profile/user.png" height="70px" width="70px" alt="">
                        </span>
                        <span class="padding-2"> you received a new order from the customer Akash
                            <span class="display-block padding-1">
                                <span class="color-primary"> Phone Number : </span> 9876554321</span>
                        </span>
                        <div>

                        </div>

                    </div>
                    <div class="notification-content">
                        <span>
                            <img src="../assets/images/user-profile/user.png" height="70px" width="70px" alt="">
                        </span>
                        <span class="padding-2"> you received a new order from the customer Akash
                            <span class="display-block padding-1">
                                <span class="color-primary"> Phone Number : </span> 9876554321</span>
                        </span>
                        <div>

                        </div>

                    </div>
                    <div class="notification-content">
                        <span>
                            <img src="../assets/images/user-profile/user.png" height="70px" width="70px" alt="">
                        </span>
                        <span class="padding-2"> you received a new order from the customer Akash
                            <span class="display-block padding-1">
                                <span class="color-primary"> Phone Number : </span> 9876554321</span>
                        </span>
                        <div>

                        </div>

                    </div>
                    <div class="notification-content">
                        <span>
                            <img src="../assets/images/user-profile/user.png" height="70px" width="70px" alt="">
                        </span>
                        <span class="padding-2"> you received a new order from the customer Akash
                            <span class="display-block padding-1">
                                <span class="color-primary"> Phone Number : </span> 9876554321</span>
                        </span>
                        <div>

                        </div>

                    </div>
                    <div class="notification-content">
                        <span>
                            <img src="../assets/images/user-profile/user.png" height="70px" width="70px" alt="">
                        </span>
                        <span class="padding-2"> you received a new order from the customer Akash
                            <span class="display-block padding-1">
                                <span class="color-primary"> Phone Number : </span> 9876554321</span>
                        </span>
                        <div>

                        </div>

                    </div>
                    <div class="notification-content">
                        <span>
                            <img src="../assets/images/user-profile/user.png" height="70px" width="70px" alt="">
                        </span>
                        <span class="padding-2"> you received a new order from the customer Akash
                            <span class="display-block padding-1">
                                <span class="color-primary"> Phone Number : </span> 9876554321</span>
                        </span>
                        <div>

                        </div>

                    </div>
                    <div class="notification-content">
                        <span>
                            <img src="../assets/images/user-profile/user.png" height="70px" width="70px" alt="">
                        </span>
                        <span class="padding-2"> you received a new order from the customer Akash
                            <span class="display-block padding-1">
                                <span class="color-primary"> Phone Number : </span> 9876554321</span>
                        </span>
                        <div>

                        </div>

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
				<li><a href="orders.jsp"> <i class="fa fa-motorcycle"
						aria-hidden="true"> </i>Orders
				</a></li>
				<li class="active"><a href="products.jsp"> <i
						class="fa fa-cubes" aria-hidden="true"> </i>Products
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
			<div class="hr-space-2"></div>
			<div class="row">
				<div class=" col-xs-12 col-sm-12  col-md-12 col-lg-12  ">
					<div class="box-body">
						<div class="hr-space-2"></div>
						<div class="col-lg-1"></div>
						<input type="text" id="search-item" class="text-box"
							placeholder="Enter Item Name to search"> <input
							type="button" class="button  btn btn-success" value="Search">
						<span class="pull-right col-xs-12 add-product"> <a
							href="products/add-item.jsp"> <i
								class="fa fa-plus button primary" aria-hidden="true"></i></a> Add
							Product
						</span>
						<div class=" hr-space-4"></div>

					</div>
				</div>

			</div>

			<div class="hr-space-4"></div>


			<!-- display items -->


			<%
				int itemCount = 0;
				int mark = 0;

				for (Items item : itemsList) {

					if (itemCount % 4 == 0) {

						mark = 0;
			%>

			<div class="row">


				<%
					}
				%>


				<div
					class=" col-xs-12 col-sm-item-6  col-md-item-6 col-lg-item-3 item-container ">
					<a href="products/update-item.jsp?ItemId=<%=item.getItemId() %>"
						class="product-link"> <span class="item-image"> <img
							src="../assets/images/items/<%=item.getItemImage()%>"
							alt="item-image">

					</span> <span class="item-rate"> Rs. <%=item.getItemPrice()%> /-
					</span> <span class="item-name"><%=item.getItemName()%></span>
					</a>

				</div>
				<%
					if (mark == 3) {
				%>

			</div>


			<%
				} else if (itemsList.size() - 1 == itemCount) {
			%>

		</div>


		<%
			}

				++itemCount;
				++mark;

			}
		%>




		<div class="hr-space-8"></div>


	</div>
	</div>

	<!-- Javasctipt External Links -->
	<script src="../js/script.js"></script>
</body>

</html>