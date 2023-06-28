window.addEventListener('DOMContentLoaded', function() {
  var notFindIdButton = document.querySelector('.not-find-id-button');
  var findIdButton = document.querySelector('.find-id-button');
  var inputName = document.querySelector('.input-name input');
  var inputEmail = document.querySelector('.input-email input');

  inputName.addEventListener('input', toggleFindIdButton);
  inputEmail.addEventListener('input', toggleFindIdButton);
  notFindIdButton.addEventListener('click', handleNotFindIdButtonClick);

  function toggleFindIdButton() {
    var nameValue = inputName.value.trim();
    var emailValue = inputEmail.value.trim();

    var isValidName = /^[가-힣]{2,}$/.test(nameValue);
    var isValidEmail = emailValue.length >= 2 && /^[^\s@]+@[^\s@]+\.(net|org|com)$/.test(emailValue);

    if (isValidName && isValidEmail) {
      notFindIdButton.style.display = 'none';
      findIdButton.style.display = 'inline-block';
    } else {
      notFindIdButton.style.display = 'inline-block';
      findIdButton.style.display = 'none';
    }
  }

  function handleNotFindIdButtonClick(event) {
    event.preventDefault();
    alert('올바르지 않은 형식입니다. 입력란을 다시 확인해 주세요.');
  }
});
