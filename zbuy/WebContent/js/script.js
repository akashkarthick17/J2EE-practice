function navigationMenu() {
    var items = document.getElementsByClassName("navigation");
    for (var i = 0; i < items.length; i++) {
        items[i].classList.toggle("display-none");
        items[i].classList.toggle("nav-animation");
    }

    var itemsa = document.getElementsByClassName("article");
    for (var i = 0; i < itemsa.length; i++) {
        itemsa[i].classList.toggle("article-animation");
    }



}

document.getElementById("navigation").addEventListener('click', function(event) {
    console.log(event.target);
});


