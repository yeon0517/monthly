Kakao.init('5fe0ebff82917c2d9a3adb0e4c01eeec'); // 발급받은 키 중 JavaScript 키를 사용합니다.

let $kakaoLogin = $('#kakaoLogin');
console.log($kakaoLogin);

$kakaoLogin.on('click', function(){
    kakaoLogin();
});

// 카카오 로그인
function kakaoLogin() {
    Kakao.Auth.login({
        success: function (authObj) {
            console.log(authObj);
            // 카카오 로그인 정보 추출
            Kakao.API.request({
                url: '/v2/user/me',
                success: function (response) {
                    console.log(response);
                    // 서버로 카카오 로그인 정보 전송
                    sendKakaoUserInfoToServer(response);
                },
                fail: function (error) {
                    console.log(error);
                },
            });
        },
        fail: function (error) {
            console.log(error);
        },
    });
}

// 서버로 카카오 로그인 정보 전송
function sendKakaoUserInfoToServer(userInfo) {
    const data = {
        id: userInfo.id,
        nickname: userInfo.properties.nickname,
        email: userInfo.kakao_account.email,
        birthday: userInfo.kakao_account.birthday,
        // 추가 필요한 정보가 있다면 여기에 추가
    };

    fetch('/api/register/kakao', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    })
        .then(response => {
            if (response.ok) {
                console.log('Kakao login information sent to the server successfully.');
                // 로그인 성공 후 페이지 이동 등의 동작 수행
            } else {
                console.error('Failed to send Kakao login information to the server.');
            }
        })
        .catch(error => {
            console.error('An error occurred while sending Kakao login information:', error);
        });
}
