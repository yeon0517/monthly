window.addEventListener("DOMContentLoaded", function () {
  var idInput = document.querySelector(".id");
  var passwordInput = document.querySelector(".password");
  var notLoginButton = document.querySelector(".not-login-button");
  var loginButton = document.querySelector(".login-button");

  idInput.addEventListener("input", toggleLoginButton);
  passwordInput.addEventListener("input", toggleLoginButton);
  notLoginButton.addEventListener("click", showErrorMessage);

  function toggleLoginButton() {
    var idValue = idInput.value.trim();
    var passwordValue = passwordInput.value.trim();

    var isValidId = /^[a-z0-9]{4,}$/.test(idValue);
    var isValidPassword =
      /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/.test(
        passwordValue
      );

    if (isValidId && isValidPassword) {
      notLoginButton.style.display = "none";
      loginButton.style.display = "block";
    } else {
      notLoginButton.style.display = "block";
      loginButton.style.display = "none";
    }
  }

  function showErrorMessage() {
    var idValue = idInput.value.trim();
    var passwordValue = passwordInput.value.trim();

    var isValidId = /^[a-z0-9]{4,}$/.test(idValue);
    var isValidPassword =
      /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/.test(
        passwordValue
      );

    if (!isValidId && !isValidPassword) {
      alert(
        "아이디는 영어와 숫자를 포함한 4글자 이상, 비밀번호는 영어, 숫자, 특수문자를 포함한 8글자 이상 입력해야 합니다."
      );
    } else if (!isValidId) {
      alert("아이디는 영어와 숫자를 포함한 4글자 이상 입력해야 합니다.");
    } else if (!isValidPassword) {
      alert(
        "비밀번호는 영어, 숫자, 특수문자를 포함한 8글자 이상 입력해야 합니다."
      );
    }
  }
});
