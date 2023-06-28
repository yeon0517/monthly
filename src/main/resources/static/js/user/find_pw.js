window.addEventListener('DOMContentLoaded', function() {
  var notFindPwButton = document.querySelector('.not-find-pw-button');
  var findPwButton = document.querySelector('.find-pw-button');
  var inputId = document.querySelector('.input-id input');
  var inputName = document.querySelector('.input-name input');
  var inputEmail = document.querySelector('.input-email input');

  inputId.addEventListener('input', toggleFindPwButton);
  inputName.addEventListener('input', toggleFindPwButton);
  inputEmail.addEventListener('input', toggleFindPwButton);
  notFindPwButton.addEventListener('click', handleNotFindPwButtonClick);

  function toggleFindPwButton() {
    var idValue = inputId.value.trim();
    var nameValue = inputName.value.trim();
    var emailValue = inputEmail.value.trim();

    var isValidId = /^[a-z0-9]{4,}$/.test(idValue);
    var isValidName = /^[가-힣]{2,}$/.test(nameValue);
    var isValidEmail = emailValue.length >= 2 && /^[^\s@]+@[^\s@]+\.(net|org|com)$/.test(emailValue);

    if (isValidId && isValidName && isValidEmail) {
      notFindPwButton.style.display = 'none';
      findPwButton.style.display = 'inline-block';
    } else {
      notFindPwButton.style.display = 'inline-block';
      findPwButton.style.display = 'none';
    }
  }

  function handleNotFindPwButtonClick(event) {
    event.preventDefault();
    alert('올바르지 않은 형식입니다. 입력란을 다시 확인해 주세요.');
  }
});
