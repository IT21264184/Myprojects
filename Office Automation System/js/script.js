function enableRegister() {

    var btn = document.getElementById("register");

    btn.disabled = chkbox.checked ? false : true;

    if (!btn.disabled) {
        btn.focus();

    }
}