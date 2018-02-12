
function submitForm() {

    var firstname = document.getElementById("firstname").value;
    var lastname = document.getElementById("lastname").value;
    var id = document.getElementById("id").value;
    var age = document.getElementById("age").value;
    var company = document.getElementById("company").value;

    if ((firstname.length == 0 && lastname.length == 0 && id == 0
            && age == 0 && company == 0)) {
        alert("Enter Valid Input");

        return false;
    }

    return true;

}