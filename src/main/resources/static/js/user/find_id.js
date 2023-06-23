const radio1 = document.querySelector("#check-method1");
const radio2 = document.querySelector("#check-method2");
const noFindIdButton = document.querySelector(".not-find-id-button");

radio1.addEventListener("click", () => {
  radio2.checked = false;
  clearInputFields();
  toggleFindIdButton();
});

radio2.addEventListener("click", () => {
  radio1.checked = false;
  clearInputFields();
  toggleFindIdButton();
});

const emailRadio = document.querySelector("#check-method1");
const phoneRadio = document.querySelector("#check-method2");
const nameSection1 = document.querySelector(".input-name1");
const nameSection2 = document.querySelector(".input-name2");
const emailSection = document.querySelector(".input-email");
const phoneSection = document.querySelector(".input-phone");

emailRadio.addEventListener("click", function () {
  nameSection1.style.display = "block";
  nameSection2.style.display = "none";
  emailSection.style.display = "block";
  phoneSection.style.display = "none";
  clearInputFields();
  toggleFindIdButton();
});

phoneRadio.addEventListener("click", function () {
  nameSection1.style.display = "none";
  nameSection2.style.display = "block";
  emailSection.style.display = "none";
  phoneSection.style.display = "block";
  clearInputFields();
  toggleFindIdButton();
});

function clearInputFields() {
  const inputFields = document.querySelectorAll(
    ".input-email input, .input-phone input"
  );
  inputFields.forEach((input) => {
    input.value = "";
  });
}

function toggleFindIdButton() {
  noFindIdButton.disabled = true;
}

window.addEventListener("DOMContentLoaded", function () {
  var checkMethod1 = document.querySelector("#check-method1");
  var checkMethod2 = document.querySelector("#check-method2");
  var inputName1 = document.querySelector(".name-space1");
  var inputName2 = document.querySelector(".name-space2");
  var inputEmail = document.querySelector(".email-space");
  var inputPhone1 = document.querySelector(".phone-space1");
  var inputPhone2 = document.querySelector(".phone-space2");
  var inputPhone3 = document.querySelector(".phone-space3");
  var notFindIdButton = document.querySelector(".not-find-id-button");
  var findIdButton = document.querySelector(".find-id-button");

  checkMethod1.addEventListener("click", function () {
    toggleInputFields(true); // 이메일 선택 시 입력 필드 토글
    clearInputFields();
    toggleFindIdButton();
  });

  checkMethod2.addEventListener("click", function () {
    toggleInputFields(false); // 휴대폰번호 선택 시 입력 필드 토글
    clearInputFields();
    toggleFindIdButton();
  });

  inputName1.addEventListener("input", toggleFindIdButton);
  inputName2.addEventListener("input", toggleFindIdButton);
  inputEmail.addEventListener("input", toggleFindIdButton);
  inputPhone1.addEventListener("input", toggleFindIdButton);
  inputPhone2.addEventListener("input", toggleFindIdButton);
  inputPhone3.addEventListener("input", toggleFindIdButton);

  notFindIdButton.addEventListener("click", function (event) {
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
    inputName1.value = "";
    inputName2.value = "";
    inputEmail.value = "";
    inputPhone1.value = "";
    inputPhone2.value = "";
    inputPhone3.value = "";
  }

  function toggleFindIdButton() {
    var nameValue1 = inputName1.value.trim();
    var nameValue2 = inputName2.value.trim();
    var emailValue = inputEmail.value.trim();
    var phone1Value = inputPhone1.value.trim();
    var phone2Value = inputPhone2.value.trim();
    var phone3Value = inputPhone3.value.trim();

    var isValidName1 = nameValue1.length >= 2;
    var isValidName2 = nameValue2.length >= 2;
    var isValidEmail =
      emailValue.length >= 2 &&
      /^[^\s@]+@[^\s@]+\.(net|org|com)$/.test(emailValue);
    var isValidPhone =
      phone1Value.length >= 3 &&
      phone2Value.length >= 4 &&
      phone3Value.length >= 4;

    if (isValidName1 && isValidEmail) {
      noFindIdButton.style.display = "none";
      findIdButton.style.display = "inline-block";

    } else if (isValidName2 && isValidPhone){
      noFindIdButton.style.display = "none";
      findIdButton.style.display = "inline-block";

    } else {
      noFindIdButton.style.display = "inline-block";
      findIdButton.style.display = "none";
    }
  }
});