/* event listener */
document.getElementById("quantity")[0].addEventListener('input', calculateTotal);

/* function */
function calculateTotal() {
    var cost = Number(document.getElementById('unitPrice').value);
    var qnt = Number(this.value);
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
