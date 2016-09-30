function checkRegistrazione() {
	var nome = document.getElementById('nome');
	var cognome = document.getElementById('cognome');
	var indirizzo = document.getElementById('indirizzo');
	var cap = document.getElementById('cap');
	var nascita = document.getElementById('nascita');
	var username = document.getElementById('username');
	var password = document.getElementById('password');
	var email = document.getElementById('email');

	var flag = 0;
	if (checkNome(nome))
		flag += 1;
	if (checkCognome(cognome))
		flag += 1;
	if (checkIndirizzo(indirizzo))
		flag += 1;
	if (checkCap(cap))
		flag += 1;
	if (checkNascita(nascita))
		flag += 1;
	if (checkUsername(username, 4, 10))
		flag += 1;
	if (checkPassword(password, 4, 10))
		flag += 1;
	if (checkEmail(email))
		flag += 1;
	if (flag == 8)
		return true;
	else
		return false;
}

function checkLogin() {
	var username = document.getElementById('username');
	var password = document.getElementById('password');

	var flag = 0;
	if (checkUsername(username, 4, 10))
		flag += 1;
	if (checkPassword(password, 4, 10))
		flag += 1;
	if (flag == 2)
		return true;
	else
		return false;
}

function checkNome(elem) {
	var nome = document.getElementById('infoNome');
	var regExp = /^[a-zA-Z ,.'-]+$/;
	if (elem.value.match(regExp)) {
		nome.innerHTML = "";
		return true;
	} else {
		nome.innerHTML = "Inserire solo lettere per il nome";
		return false;
	}
}

function checkCognome(elem) {
	var cognome = document.getElementById('infoCognome');
	var regExp = /^[a-zA-Z ,.'-]+$/;
	if (elem.value.match(regExp)) {
		cognome.innerHTML = "";
		return true;
	} else {
		cognome.innerHTML = "Inserire solo lettere per il cognome";
		return false;
	}
}

function checkIndirizzo(elem) {
	var indirizzo = document.getElementById('infoIndirizzo');
	var regExp = /^[a-zA-Z\, ]+[0-9]+$/;
	if (elem.value.match(regExp)) {
		indirizzo.innerHTML = "";
		return true;
	} else {
		indirizzo.innerHTML = "Inserire numeri o lettere come indirizzo";
		return false;
	}
}

function checkCap(elem) {
	var cap = document.getElementById('infoCap');
	var regExp = /^[0-9]{5}$/;
	if (elem.value.match(regExp)) {
		cap.innerHTML = "";
		return true;
	} else {
		cap.innerHTML = "Inserire 5 cifre per il cap";
		return false;
	}
}

function checkNascita(elem) {
	var nascita = document.getElementById('infoNascita');
	var regExp = /^(0?[1-9]|[12][0-9]|3[01])\/(0?[1-9]|1[012])\/((19|20)\d\d)$/;
	if (elem.value.match(regExp)) {
		nascita.innerHTML = "";
		return true;
	} else {
		nascita.innerHTML = "Inserire una data nel formato dd/MM/yyyy";
		return false;
	}
}

function checkUsername(elem, min, max) {
	var username = document.getElementById('infoUsername');
	var uInput = elem.value;
	if (uInput.length >= min && uInput.length <= max) {
		username.innerHTML = "";
		return true;
	} else {
		username.innerHTML = "La lunghezza dello username deve essere compresa tra "
				+ min + " e " + max;
		return false;
	}
}

function checkPassword(elem, min, max) {
	var password = document.getElementById('infoPassword');
	var uInput = elem.value;
	if (uInput.length >= min && uInput.length <= max) {
		password.innerHTML = "";
		return true;
	} else {
		password.innerHTML = "La lunghezza della password deve essere compresa tra "
				+ min + " e " + max;
		return false;
	}
}

function checkEmail(elem) {
	var email = document.getElementById('infoEmail');
	var regExp = /^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-Z0-9]{2,4}$/;

	if (elem.value.match(regExp)) {
		email.innerHTML = "";
		return true;
	} else {
		email.innerHTML = "Inserire una email valida";
		return false;
	}
}
