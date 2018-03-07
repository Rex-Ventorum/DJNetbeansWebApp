/* event listener */
document.getElementsByName("quantity")[0].addEventListener('input', calculateTotal);

/* function */
function calculateTotal() {
    var cost = Number(document.getElementById('unitPrice').value);
    var qnt = Number(this.value);
    var minValue = Number($('#quantity').prop('min'));
    var maxValue = Number($('#quantity').prop('max'));
    if (qnt < minValue) {
        this.value = minValue;
    } else if (qnt > maxValue) {
        this.value = maxValue;
    } else {
        document.getElementById("TotalTag").innerHTML = "For: $" + (cost * qnt);
    }
};
