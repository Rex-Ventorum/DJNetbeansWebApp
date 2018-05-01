/* function */
function calculateTotal() {
    var dropDown = document.getElementById("j_idt12:quantity");
    var cost = Number(document.getElementById('unitPrice').value);
    var qnt = Number(dropDown.value);
    var minValue = 1;
    var maxValue = 1000;
    if (qnt < minValue) {
        this.value = minValue;
    } else if (qnt > maxValue) {
        this.value = maxValue;
    } else {
        document.getElementById("TotalTag").innerHTML = "For: $" + (cost * qnt);
    }
};
