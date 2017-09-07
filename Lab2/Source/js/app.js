
var cityApp = angular.module('cityApp', ['ngRoute']);

cityApp.config(function($routeProvider) {
    'use strict';
    $routeProvider
        .when('/', {
            templateUrl: 'login.html',
            controller: 'loginController'
        })
        .when('/register', {
            templateUrl: 'register.html',
            controller: 'registerController'
        })
        .when('/main', {
            templateUrl: 'main.html',
            controller: 'mainController'
        })
        .when('/home', {
            templateUrl: 'home.html',
            controller: 'homeController'
        });

    });

cityApp.controller('loginController', function($scope) {
    'use strict';
    $scope.pageClass = 'login';
    $scope.localStore = function (user, pwd) {
        localStorage.setItem("name" , user);
        localStorage.setItem("passwordd" , pwd);
    };
});

cityApp.controller('registerController', function($scope) {
    'use strict';
    $scope.pageClass = 'register';
});

cityApp.controller('mainController', function($scope) {
    'use strict';
    $scope.pageClass = 'main';
});

cityApp.controller('homeController', function($scope) {
    'use strict';
    $scope.pageClass = 'home';
});

