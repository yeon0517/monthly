

document.addEventListener('DOMContentLoaded', function() {
    const wrapLists = document.querySelectorAll('.wrap_list');

    wrapLists.forEach(function(wrapList) {
        const divs = wrapList.querySelectorAll('.wrap_il');

        if (divs.length > 3) {
            for (let i = 3; i < divs.length; i++) {
                divs[i].style.display = 'none';
            }
        }
    });
});
