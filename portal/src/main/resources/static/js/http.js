const BASE_URL = "http://localhost:10005/";

function postAjax(option = {
    url: "",
    method: "",
    data: {},
    headers: {}
}, callback) {
    $.ajax({
        url: BASE_URL + option.url,
        type: 'post',
        data: JSON.stringify(option.data == null ? {} : option.data),
        headers: {token: localStorage.getItem("token")},
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (res) {
            callback(res)
        }
    })
}