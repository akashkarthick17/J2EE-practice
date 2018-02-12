<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Grocery Login</title>

    <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous"> -->
    <!-- <link href="http://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css"> -->
    <link href="../../assets/Tiny-jQuery-Pagination-Widget-For-HTML-Table-table-hpaging/paging.css" rel="stylesheet" type="text/css"
    />
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="../../assets/Tiny-jQuery-Pagination-Widget-For-HTML-Table-table-hpaging/scripts/jquery.table.hpaging.min.js"></script>

    <!-- CSS External Links -->
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" href="../../css/reusable-style.css">
    <link rel="stylesheet" href="../../assets/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../../css/media-query.css">


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

            <span class="profile-icon">
                <i class="fa fa-user" aria-hidden="true"></i>
            </span>
            <span class="notification-icon">
                <i class="fa fa-bell" aria-hidden="true"></i>
            </span>

        </div>

        <div class="user-profile">

        </div>

    </header>


    <div class="body-container">

        <div class="navigation display-none" id="navigation">
            <ol class="ordered-list">
                <li>
                    <a href="../index.jsp">
                        <i class="fa fa-home" aria-hidden="true"> </i> Home
                    </a>
                </li>
                <li>
                    <a href="../orders.jsp">
                        <i class="fa fa-motorcycle" aria-hidden="true"> </i>Orders
                    </a>
                </li>
                <li class="active">
                    <a href="../products.jsp">
                        <i class="fa fa-cubes" aria-hidden="true"> </i>Products
                    </a>
                </li>
                <li >
                    <a href="../customers.jsp">
                        <i class="fa fa-users" aria-hidden="true"> </i>Customers
                    </a>
                </li>
                <li>
                    <a href="../marketing.jsp">
                        <i class="fa fa-suitcase" aria-hidden="true"> </i> Marketing
                    </a>
                </li>
            </ol>
        </div>



        <div id="article" class="article  ">

           



            <div class="row">

                <div class="col-xs-12  col-sm-12  col-md-12 col-lg-12  box  ">
                    <div class="box-header">
                        Add Product Details
                    </div>
                    <div class="box-body ">
                        <div class="display-center">
                            <table class="text-right">
                                <thead>

                                </thead>
                                <tbody>
                                 
                                    <tr>
                                        <td>
                                            <label for="product-id" class="bold">Product Name: </label>
                                        </td>
                                        <td>
                                            <input type="text" class="text-box" name="product-name" id="product-name" >
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label for="product-id" class="bold">Price: </label>
                                        </td>
                                        <td>
                                            <input type="text" class="text-box" name="price" id="price" >
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label for="product-id" class="bold">Quantity: </label>
                                        </td>
                                        <td>
                                            <input type="text" class="text-box" name="quantity" id="quantity" >
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label for="product-id" class="bold">Unit: </label>
                                        </td>
                                        <td>
                                            <input type="text" class="text-box" name="unit  " id="unit" >
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label for="product-id" class="bold">Category: </label>
                                        </td>
                                        <td>
                                            <select name="category" class="text-box" id="category">
                                                <option value=""></option>
                                                <option value="Fruits">Fruits</option>
                                                <option value="Vegetable">vegetables</option>
                                                <option value="Chocolates">Chocolates</option>
                                                <option value="Grocery Items">Grocery Items</option>
                                                <option value="Snacks">Snacks</option>
                                            </select>
                                        </td>
                                    </tr>


                                    <tr>
                                        <td class="hr-space-8">

                                            <label for="product-id" class="bold ">Select Image </label>

                                        </td>
                                        <td class="hr-space-8 text-left">

                                
                                                <input type="file" name="image" id="image" class="input-file">
                                                <label for="image" ><i class="fa fa-upload" aria-hidden="true"></i>  Upload Image</label>
                                        

                                        </td>

                                    </tr>




                                </tbody>

                            </table>


                        </div>

                        <div class="display-center">
                            <input type="submit" class="btn button success" value="Add" name="Edit" id="edit">
                        </div>





                    </div>
                </div>


            </div>


            <!-- <div class="hr-space-4"></div> -->

        </div>
    </div>

    <!-- Javasctipt External Links -->
    <script src="../js/script.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#table1").hpaging({
                "limit": 7
            });
        });
    </script>
</body>

</html>