let item_id ;
let oid;

/* rate open and close */
var allbtn = document.querySelectorAll('.ratebtn');

allbtn.forEach((x) => x.addEventListener('click',
	function() {
		document.querySelector('.bg-modal').style.display = 'flex';
		
		item_id = this.value;
		
		oid = this.getAttribute("data-value");
	}));

function rateSubmit() {

	var rate_num = $("input[type='radio'][name='rate']:checked").val();

	var def_review = document.getElementById('starlabel').textContent;
	
	var review = document.getElementById('review').value;

	$.post("http://localhost:8080/Online_food_ordering_system/AddRatingServlet", {item_id : item_id, oid : oid, rate_num : rate_num, review : review, def_review : def_review}, function(){
		
		document.querySelector('.bg-modal').style.display = 'none';
	})
}

document.querySelector('.closelabel').addEventListener('click',
	function() {
		document.querySelector('.bg-modal').style.display = 'none';
	});

/* rate */
function rateMsg() {
	if (document.getElementById('rate-5').checked) {
		document.getElementById('starlabel').innerHTML = "It's awesome";
		document.getElementById('starlabel').style.color = 'black';
	}
	if (document.getElementById('rate-4').checked) {
		document.getElementById('starlabel').innerHTML = "I like it";
		document.getElementById('starlabel').style.color = 'black';
	}
	if (document.getElementById('rate-3').checked) {
		document.getElementById('starlabel').innerHTML = "It's ok";
		document.getElementById('starlabel').style.color = 'black';
	}
	if (document.getElementById('rate-2').checked) {
		document.getElementById('starlabel').innerHTML = "I don't like it";
		document.getElementById('starlabel').style.color = 'black';
	}
	if (document.getElementById('rate-1').checked) {
		document.getElementById('starlabel').innerHTML = "I hate it";
		document.getElementById('starlabel').style.color = 'black';
	}
}