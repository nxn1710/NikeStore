let inputSize = document.querySelectorAll('input[name=productSize]');

inputSize.forEach((e) => {
	e.addEventListener("click", () => {
		let labelSize = document.querySelector(`label[for=${e.id}]`);
		if (labelSize.getAttribute("class").indexOf("disabled") == -1) {
			if (e.checked) {
				let quantity = labelSize.getAttribute("quantity");
				document.getElementById("product-quantity").innerText = `Available products is ${quantity}`;
				removeActiveLabelSize(inputSize);
				labelSize.setAttribute("class", "label_size mx-0 active")
			}
		} else {
			e.checked = false;
		}
	})
});

function removeActiveLabelSize(inputSize) {
	inputSize.forEach((e) => {
		let labelSize = document.querySelector(`label[for=${e.id}]`);
		if (labelSize.getAttribute("class").indexOf("disabled") == -1) {
			labelSize.setAttribute("class", "label_size mx-0");
		}
	})
}


window.onload = function() {
	document.getElementById("logoutLink").addEventListener("click", function(e) {
		e.preventDefault();
		document.logoutForm.submit();
	});
	

}