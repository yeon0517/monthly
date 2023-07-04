Kakao.init('5fe0ebff82917c2d9a3adb0e4c01eeec'); //발급받은 키 중 javascript키를 사용해준다.
console.log(Kakao.isInitialized()); // sdk초기화여부판단

let $kakaoLogin = $('#kakaoLogin');
console.log($kakaoLogin);

$kakaoLogin.on('click', function(){
    kakaoLogin();
});


//카카오로그인
function kakaoLogin() {
    Kakao.Auth.login({
        success: function (response) {
            console.log(response)
            Kakao.API.request({
                url: '/v2/user/me',
                success: function (response) {
                    window.location.href = 'http://localhost:10000/board/main';
                    console.log(response)
                },
                fail: function (error) {
                    console.log(error)
                },
            })
        },
        fail: function (error) {
            console.log(error)
        },
    })
}
//카카오로그아웃
function kakaoLogout() {
    if (Kakao.Auth.getAccessToken()) {
        Kakao.API.request({
            url: '/v1/user/unlink',
            success: function (response) {
                console.log(response)
            },
            fail: function (error) {
                console.log(error)
            },
        })
        Kakao.Auth.setAccessToken(undefined)
    }
}