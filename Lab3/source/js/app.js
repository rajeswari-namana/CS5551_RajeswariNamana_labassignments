/**
 * Created by rajin on 9/8/2017.
 */

var app = angular.module('myApp', []);
app.controller('myCtrl', function ($scope, $http) {
    $scope.trans = function () {
        // get text from input text box
        var a=document.getElementById("a").value;
        // get text from language selected option
        var l=document.getElementById("l").value;
        var b;
        //using yandex translate api
        $http.get("https://translate.yandex.net/api/v1.5/tr.json/translate?" +
            "key=trnsl.1.1.20170908T182132Z.e3446250e4d76750.389351b9a1ac3fd7bc4fdb0a5a9fa8607e08ff97" +
            "&text="+a+"&lang="+l)
            .then(function (response) {
                $scope.translate = response.data.text[0];

                //using youtube api
                $http.get("https://www.googleapis.com/youtube/v3/search?"+
                    "key=AIzaSyA9spYNxTzOfOXSJLnUO4m9iXllxAwmDfs&videoEmbeddable=any"+
                    "&q="+a+"&type=video&part=snippet&maxResults=1")
                    .then(function (response) {
                        var comId = response.data.items[0].id.videoId;
                        $scope.labelText="Translation:";
                        $scope.labelImage="Video:";
                        //getting video image, title and id.
                        $scope.displayImage=response.data.items[0].snippet.thumbnails.medium.url;
                        $scope.title=response.data.items[0].snippet.title;
                        var lin="https://www.youtube.com/embed/";
                        b=lin+comId;
                        $scope.displayTitle=b;
                    });
            });
    };
});