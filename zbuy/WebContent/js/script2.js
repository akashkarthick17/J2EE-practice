// Index Page

function getLocation() {
	if (navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(showPosition);
	} else {
		alert("Geo Location is not supported in this browser");
	}
}

function showPosition(position) {

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			console.log("retrieved Location");

			document.location.reload();

		}
	};

	xhttp.open("GET", "../LocationGrabber?lat=" + position.coords.latitude
			+ "&long=" + position.coords.longitude, true);

	xhttp.send();

}

// Item Page

function addToCart(itemId) {

	console.log("in add to cart");

	var quantity = document.getElementById("item-quantity").value;

	var updated = 0;
	var xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {

		if (this.readyState == 4 && this.status == 200) {

			console.log(this.response);
			updated = this.responseText;
			var existingQuantity = document.getElementById("cart-number").innerHTML;
			console.log("existing: " + existingQuantity);
			console.log("updated: " + updated)

			var updatedQuantity = Number(existingQuantity) + Number(updated);

			console.log("updatedQuantity: " + updatedQuantity);

			document.getElementById("cart-number").innerHTML = updatedQuantity;
		}
	}

	xhttp.open("GET", "../CartHandler?addCart=add&itemId=" + itemId
			+ "&quantity=" + quantity, true);
	xhttp.send();

}

function deleteCartItem(event) {

	if (event.target.tagName == "I") {
		var itemId = event.target.getAttribute("data-id");

		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				console.log(this.response);
				window.location.reload();
			}
		}

		xhttp.open("GET", "../CartHandler?deleteCart=delete&itemId=" + itemId);
		xhttp.send();

	}

}

function proceedToCheckout() {
	console.log("checkout");

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			console.log(this.response);
			window.location.reload();
		}
	}

	xhttp.open("GET", "../CartHandler?checkoutCart=checkout");
	xhttp.send();
}


function deliverProducts() {
	
	
	
	var orderId = document.getElementById("order-id").value;
	
	console.log("deliver "+orderId);
	
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			
			console.log(this.response);
			
			window.location.reload();
		}
	}

	xhttp.open("POST", "../../GroceryHandler",true);
	xhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhttp.send("type=deliver&OrderId="+orderId);
	
	
}

function shoppingCart() {
	window.location.href = "shopping-cart.jsp";
}

function homePage() {
	window.href.location = "customer-login/orders.jsp";
}

// document.addEventListener("DOMContentLoaded", function() {
// updateShoppingCart();
// });
