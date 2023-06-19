const radio1 = document.querySelector("#check-method1");
const radio2 = document.querySelector("#check-method2");

radio1.addEventListener("click", () => {
  radio2.checked = false;
});

radio2.addEventListener("click", () => {
  radio1.checked = false;
});

const emailRadio = document.querySelector("#check-method1");
const phoneRadio = document.querySelector("#check-method2");
const emailSection = document.querySelector(".input-email");
const phoneSection = document.querySelector(".input-phone");

emailRadio.addEventListener("click", function () {
  emailSection.style.display = "block";
  phoneSection.style.display = "none";
});

phoneRadio.addEventListener("click", function () {
  emailSection.style.display = "none";
  phoneSection.style.display = "block";
});

window.addEventListener("DOMContentLoaded", function () {
  var checkMethod1 = document.querySelector("#check-method1");
  var checkMethod2 = document.querySelector("#check-method2");
  var inputId = document.querySelector(".id-space");
  var inputName = document.querySelector(".name-space");
  var inputEmail = document.querySelector(".email-space");
  var inputPhone1 = document.querySelector(".phone-space1");
  var inputPhone2 = document.querySelector(".phone-space2");
  var inputPhone3 = document.querySelector(".phone-space3");
  var notFindPwButton = document.querySelector(".not-find-pw-button");
  var findPwButton = document.querySelector(".find-pw-button");

  checkMethod1.addEventListener("click", function () {
    toggleInputFields(true); // 이메일 선택 시 입력 필드 토글
    clearInputFields();
    toggleFindPwButton();
  });

  checkMethod2.addEventListener("click", function () {
    toggleInputFields(false); // 휴대폰번호 선택 시 입력 필드 토글
    clearInputFields();
    toggleFindPwButton();
  });

  inputId.addEventListener("input", toggleFindPwButton);
  inputName.addEventListener("input", toggleFindPwButton);
  inputEmail.addEventListener("input", toggleFindPwButton);
  inputPhone1.addEventListener("input", toggleFindPwButton);
  inputPhone2.addEventListener("input", toggleFindPwButton);
  inputPhone3.addEventListener("input", toggleFindPwButton);

  notFindPwButton.addEventListener("click", function (event) {
    event.preventDefault();
    alert("올바르지 않은 형식입니다. 입력란을 다시 확인해주세요.");
  });

  function toggleInputFields(isEmailChecked) {
    var inputEmailField = document.querySelector(".input-email");
    var inputPhoneField = document.querySelector(".input-phone");

    if (isEmailChecked) {
      inputEmailField.style.display = "block";
      inputPhoneField.style.display = "none";
    } else {
      inputEmailField.style.display = "none";
      inputPhoneField.style.display = "block";
    }
  }

  function clearInputFields() {
    inputId.value = "";
    inputName.value = "";
    inputEmail.value = "";
    inputPhone1.value = "";
    inputPhone2.value = "";
    inputPhone3.value = "";
  }

  function toggleFindPwButton() {
    var idValue = inputId.value.trim();
    var nameValue = inputName.value.trim();
    var emailValue = inputEmail.value.trim();
    var phone1Value = inputPhone1.value.trim();
    var phone2Value = inputPhone2.value.trim();
    var phone3Value = inputPhone3.value.trim();

    var isValidId = /^[a-z0-9]{4,}$/.test(idValue);
    var isValidName = nameValue.length >= 2;
    var isValidEmail =
      emailValue.length >= 2 &&
      /^[^\s@]+@[^\s@]+\.(net|org|com)$/.test(emailValue);
    var isValidPhone =
      phone1Value.length >= 3 &&
      phone2Value.length >= 4 &&
      phone3Value.length >= 4;

    if (isValidId && isValidName && (isValidEmail || isValidPhone)) {
      notFindPwButton.style.display = "none";
      findPwButton.style.display = "inline-block";
    } else {
      notFindPwButton.style.display = "inline-block";
      findPwButton.style.display = "none";
    }
  }
});