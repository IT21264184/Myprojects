document.getElementById('address').addEventListener('click',
  function () {
    document.querySelector('.checkout .center .addresscont').style.display = 'flex';
  });

document.querySelector('.closelabelcash').addEventListener('click',
  function () {
    document.querySelector('.checkout .center .addresscont').style.display = 'none';
  });


function checkuncheck() {
  var checkbox = document.getElementById('showcntr');
  var a;

  document.getElementById('prof2').style.padding = '0px 10px 0px 10px';

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

function checkuncheck2() {
  var checkbox = document.getElementById('showcntr2');
  var a;

  document.getElementById('prof1').style.padding = '0px 10px 0px 10px';
  
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
  document.getElementById('prof2').style.padding = '0px 0px 0px 10px';
}

function showbtn2() {
  document.getElementById('cntrbtn2').style.display = 'block';
  document.getElementById('prof1').style.padding = '0px 0px 0px 10px';
}


function updateProfile(){
	
	var email = document.getElementById('email').value
	var phone = document.getElementById('phone').value
	var address = document.getElementById('address').value
	var name = document.getElementById('name').value
	
	$.post("http://localhost:8080/Online_food_ordering_system/UpdateProfileServlet", {email : email, address : address, name : name, phone : phone}, function(response){
		
		var error = document.getElementById('errMsg')
		
		if(response == ''){
			setTimeout(function () {
		     location.reload(true);
		   }, 1);
		}
		else{
			error.innerHTML = response
			
		   
		    $('.alert').show()
		    
		    
		    
		}
	
	})
}

