/* payment method popup */
document.getElementById('editname').addEventListener('click',
  function () {
    document.querySelector('.bg-modal').style.display = 'flex';
  });
document.querySelector('.closelabel').addEventListener('click',
  function () {
    document.querySelector('.bg-modal').style.display = 'none';
  });


/* document.querySelector('.closelabel').addEventListener('click',
  function () {
    document.querySelector('.bg-modal').style.display = 'none';
  }); */


/* close payments */
//document.querySelector('.closeall').addEventListener('click',
//  function () {
//    document.querySelector('.bg-modal').style.display = 'none';
//    document.querySelector('.bg-modalcredit').style.display = 'none';
//    document.querySelector('#editname2').style.background = 'darkgreen';
//    document.querySelector('#editname2').style.border = 'none';
//    document.querySelector('#editname2').innerHTML = 'Place Order';
//  });
document.querySelector('.closeall2').addEventListener('click',
  function () {
    document.querySelector('.bg-modal').style.display = 'none';
    document.querySelector('.bg-modalcash').style.display = 'none';
    document.querySelector('#editname2').style.background = 'darkgreen';
    document.querySelector('#editname2').style.border = 'none';
    document.querySelector('#editname2').innerHTML = 'Place Order';
  });

/* credit card popup */
document.getElementById('credit').addEventListener('click',
  function () {
    document.querySelector('.bg-modalcredit').style.display = 'flex';
  });
document.querySelector('.closelabelcredit').addEventListener('click',
  function () {
    document.querySelector('.bg-modalcredit').style.display = 'none';
  });


/* cash popup */
document.getElementById('cash').addEventListener('click',
  function () {
    document.querySelector('.bg-modalcash').style.display = 'flex';
  });

document.querySelector('.closelabelcash').addEventListener('click',
  function () {
    document.querySelector('.bg-modalcash').style.display = 'none';
  });


/* check the checkbox when button is clicked */
function checkuncheck() {
  var checkbox = document.getElementById('showcntr');
  var a;

  if (checkbox.checked) {
    checkbox.checked = false;
  }
  else {
    checkbox.checked = true;
  }

  if (a == 1) {
    document.getElementById('cntrbtn').style.display = 'block';
    return a = 0;
  }
  else {
    document.getElementById('cntrbtn').style.display = 'none';
    return a = 1;
  }
}

/* check the checkbox when button is clicked */
function checkuncheck2() {
  var checkbox = document.getElementById('showcntr2');
  var a;

  if (checkbox.checked) {
    checkbox.checked = false;
  }
  else {
    checkbox.checked = true;
  }

  if (a == 1) {
    document.getElementById('cntrbtn2').style.display = 'block';
    return a = 0;
  }
  else {
    document.getElementById('cntrbtn2').style.display = 'none';
    return a = 1;
  }
}

function showbtn() {
  document.getElementById('cntrbtn').style.display = 'block';
}

function showbtn2() {
  document.getElementById('cntrbtn2').style.display = 'block';
}


function addPayment(payment_type){
	
	var cardNo = document.getElementById('cardNo').value
	var exp_date = document.getElementById('exp_date').value
	var ccv = document.getElementById('ccv').value
	var name = document.getElementById('name').value
	var type = payment_type
	
	$.post("http://localhost:8080/Online_food_ordering_system/AddPaymentServlet", { cardNo: cardNo, exp_date : exp_date, ccv : ccv, name : name, type : payment_type }, function(response){
		
		var error = document.getElementById('errMsg')
		
		if(response == ''){
			
			    document.querySelector('.bg-modal').style.display = 'none';
			    document.querySelector('.bg-modalcredit').style.display = 'none';
			    document.querySelector('#editname2').style.background = 'darkgreen';
			    document.querySelector('#editname2').style.border = 'none';
			    document.querySelector('#editname2').innerHTML = 'Place Order';
			    document.querySelector('#editname2').disabled = false;
			  
		}
		else{
			error.innerHTML = response
		    $('.alert').show()
		}
	})
}



function createOrder(){
	
	var address = document.getElementById('address').value
	var phone = document.getElementById('phone').value
	
	$.post("http://localhost:8080/Online_food_ordering_system/CreateOrderServlet", { address: address, phone : phone })
}