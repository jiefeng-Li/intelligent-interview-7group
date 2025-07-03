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

    });
}

function getAjaxRequest(url, data, callBack) {
    request(url, "GET", data, "application/x-www-form-urlencoded;charset=UTF-8", function(res) {
        return typeof callBack == "function" && callBack(res);
    });
}

function postAjaxRequest(url, data, callBack) {
    request(url, "POST", data, "application/x-www-form-urlencoded;charset=UTF-8", function(res) {
        return typeof callBack == "function" && callBack(res);
    });
}
function httpJsonRequest(url, method, data = {}, token, contentType, back) {
    $.ajax({
        url: baseURL + url,
        type: method,
        data: data,
        cache: false,
        timeout: timeout,
        headers: {'token': token},
        contentType: contentType,
        dataType: "json",
        success: function(res) {
            console.log(res);
            return typeof back == "function" && back(res);
        },
        error: function(error) {
            console.log(error);
            return typeof back == "function" && back(null);
        }
    });
}



function getAjaxJsonHttpRequest(url, data, token, callBack) {
    httpJsonRequest(url, "GET", data, token, "application/json;charset=UTF-8", function(res) {
        return typeof callBack == "function" && callBack(res);
    });
}

function postAjaxJsonHttpRequest(url, data, token, callBack) {
    httpJsonRequest(url, "POST", data, token, "application/json;charset=UTF-8", function(res) {
        return typeof callBack == "function" && callBack(res);
    });
}

    })
}
