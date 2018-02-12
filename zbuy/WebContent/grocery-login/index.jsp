<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="io.zilker.zbuy.bean.*" %>
     <% 
	
	User user = (User)session.getAttribute("user");
	String name = user.getUserName();
	
	%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Welcome <%= user.getUserName() %></title>
    <link rel="shortcut icon" href="../assets/images/logo.jpg">

    <!-- CSS External Links -->
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/reusable-style.css">
    <link rel="stylesheet" href="../assets/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../css/media-query.css">

    <!-- chart -->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
        google.charts.load('current', {
            'packages': ['corechart']
        });
        google.charts.setOnLoadCallback(drawChart);

        function drawChart() {
            var data = google.visualization.arrayToDataTable([
                ['Year', 'Sales', 'Expenses'],
                ['2015', 1000, 400],
                ['2016', 1170, 460],
                ['2017', 660, 1120],
                ['2018', 1030, 540]
            ]);

            var options = {
                title: '',
                curveType: 'function',
                legend: {
                    position: 'bottom'
                }
            };

            var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

            chart.draw(data, options);
        }
    </script>

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
                <li class="active">
                    <a href="index.jsp">
                        <i class="fa fa-home" aria-hidden="true"> </i> Home
                    </a>
                </li>
                <li>
                    <a href="orders.jsp">
                        <i class="fa fa-motorcycle" aria-hidden="true"> </i>Orders
                    </a>
                </li>
                <li>
                    <a href="products.jsp">
                        <i class="fa fa-cubes" aria-hidden="true"> </i>Products
                    </a>
                </li>
                <li>
                    <a href="customers.jsp">
                        <i class="fa fa-users" aria-hidden="true"> </i>Customers
                    </a>
                </li>
                <li>
                    <a href="marketing.jsp">
                        <i class="fa fa-suitcase" aria-hidden="true"> </i> Marketing
                    </a>
                </li>
            </ol>
        </div>



        <div id="article" class="article  ">

            <div class="hr-space-2"></div>

            <div class="row">
                <div class="col-xs-12  col-sm-12  col-md-3 col-lg-3  box ">
                    <div class="box-header">
                        Customers
                    </div>
                    <div class="box-body">
                        <h1 class="zero-margin">5326</h1>
                        <div class="hr-space-4"></div>
                    </div>
                </div>

                <div class="col-md-1 col-lg-1"></div>

                <div class="col-xs-12  col-sm-12  col-md-4 col-lg-4  box ">
                    <div class="box-header">
                        Orders
                    </div>
                    <div class="box-body">
                        <h1 class="zero-margin">56</h1>
                        <div class="hr-space-4"></div>
                    </div>

                </div>

                <div class="col-md-1 col-lg-1"></div>

                <div class="col-xs-12 col-sm-12 col-md-3 col-lg-3  box ">
                    <div class="box-header">
                        Products
                    </div>
                    <div class="box-body ">
                        <h1 class="zero-margin ">33446</h1>
                        <div class="hr-space-4"></div>
                    </div>

                </div>
            </div>


            <div class="row">
                <div class="col-xs-12  col-sm-12  col-md-12 col-lg-12  box ">
                    <div class="box-header">
                        Recent Orders
                    </div>
                    <div class="box-body">
                        <div class="responsive-table">
                            <table class="design-table">
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
                                    <tr>
                                        <td>
                                            <span class="processed"> processed</span>
                                        </td>
                                        <td>123#</td>
                                        <td>Akash</td>
                                        <td>12/06/2018</td>
                                        <td>Rs. 500</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <span class="delivered">Delivered</span>
                                        </td>
                                        <td>123#</td>
                                        <td>Akash</td>
                                        <td>12/06/2018</td>
                                        <td>Rs. 500</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <span class="delivered"> Delivered</span>
                                        </td>
                                        <td>123#</td>
                                        <td>Akash</td>
                                        <td>12/06/2018</td>
                                        <td>Rs. 500</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <span class="processed"> Processed</span>
                                        </td>
                                        <td>123#</td>
                                        <td>Akash</td>
                                        <td>12/06/2018</td>
                                        <td>Rs. 500</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <span class="rejected"> Rejected </span>
                                        </td>
                                        <td>123#</td>
                                        <td>Akash</td>
                                        <td>12/06/2018</td>
                                        <td>Rs. 500</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <span class="processed"> processed</span>
                                        </td>
                                        <td>123#</td>
                                        <td>Akash</td>
                                        <td>12/06/2018</td>
                                        <td>Rs. 500</td>
                                    </tr>
                                </tbody>
                            </table>

                            <!-- <div class="hr-space-4"></div> -->
                        </div>
                    </div>

                </div>



            </div>

            <div class="row">
                <div class="col-xs-12  col-sm-12  col-md-6 col-lg-6  box ">
                    <div class="box-header">
                        Order by Status
                    </div>
                    <div class="box-body ">

                        <table class="design-table">
                            <thead>
                                <tr>
                                    <th>Status</th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>
                                        <span class="processed"> processed</span>
                                    </td>
                                    <td>563</td>
                                    <td>Rs. 34,500</td>

                                </tr>
                                <tr>
                                    <td>
                                        <span class="delivered"> Delivered</span>
                                    </td>
                                    <td>563</td>
                                    <td>Rs. 34,500</td>

                                </tr>
                                <tr>
                                    <td>
                                        <span class="rejected"> Rejected</span>
                                    </td>
                                    <td>563</td>
                                    <td>Rs. 34,500</td>

                                </tr>
                                <tr>
                                    <td>
                                        <span class="processed"> Open</span>
                                    </td>
                                    <td>563</td>
                                    <td>Rs. 34,500</td>

                                </tr>

                            </tbody>
                        </table>

                    </div>
                </div>

                <div class="col-md-1 col-lg-1"></div>

                <div class="col-xs-12  col-sm-12  col-md-5 col-lg-5  box ">
                    <div class="box-header">
                        Sales Statistics
                    </div>
                    <div class="box-body">
                        <div id="curve_chart" style="width:100%; height:235px; "></div>
                    </div>

                </div>
            </div>

            <div class="row">
                <div class="col-xs-12  col-sm-12  col-md-3 col-lg-3  box ">
                    <div class="box-header">
                        Active Products
                    </div>
                    <div class="box-body">
                        <h1 class="zero-margin">5326</h1>
                        <div class="hr-space-4"></div>
                    </div>
                </div>

                <div class="col-md-1 col-lg-1"></div>

                <div class="col-xs-12  col-sm-12  col-md-2 col-lg-2  box ">
                    <div class="box-header">
                        Out of Stock
                    </div>
                    <div class="box-body">
                        <h1 class="zero-margin">56</h1>
                        <div class="hr-space-4"></div>
                    </div>

                </div>

                <div class="col-md-1 col-lg-1"></div>

                <div class="col-xs-12 col-sm-12 col-md-2 col-lg-2  box ">
                    <div class="box-header">
                        Categories
                    </div>
                    <div class="box-body ">
                        <h1 class="zero-margin ">76</h1>
                        <div class="hr-space-4"></div>
                    </div>

                </div>

                <div class="col-md-1 col-lg-1"></div>

                <div class="col-xs-12 col-sm-12 col-md-2 col-lg-2  box ">
                    <div class="box-header">
                        Active Users
                    </div>
                    <div class="box-body ">
                        <h1 class="zero-margin ">546</h1>
                        <div class="hr-space-4"></div>
                    </div>

                </div>
            </div>
            <div class="hr-space-8"></div>

        </div>
    </div>

    <!-- Javasctipt External Links -->
    <script src="../js/script.js"></script>

</body>

</html>