var app = angular.module('isbnVerifier', []);
app.controller('myCtrl', function($scope, $http) {
    $scope.verifications = [];
    $scope.verify = function () {
        if (!$scope.isbn) {return;}
        $http.get("/api/verifyISBN?isbns=" + $scope.isbn)
            .then(function(response) {
                errors = [];
                $scope.errortext = "";
                for(i in response.data) {
                    _isbn = response.data[i].isbn;
                    if (!_isbn) {continue;}
                    _isISBN10 = response.data[i].isISBN10;
                    _isISBN13 = response.data[i].isISBN13;

                    if(!_isISBN10 && !_isISBN13) {
                        message = _isbn + " is not a valid ISBN";
                    } else if (_isISBN10) {
                        message = _isbn + " is a valid 10 digit ISBN";
                    } else if (_isISBN13) {
                        message = _isbn + " is a valid 13 digit ISBN";
                    }

                    if ($scope.verifications.indexOf(message) == -1) {
                        $scope.verifications.push(message);
                    } else {
                        errors.push(_isbn);
                    }
                }
                
                if(errors.length == 1) {
                    $scope.errortext += errors[i];
                } else {
                    for(i in errors) {
                        if(i != 0 && i == errors.length - 1) {
                            $scope.errortext += "and " + errors[i];
                        } else {
                            $scope.errortext += errors[i] + ", ";
                        }
                    }
                }
                
                if(errors.length == 1) {
                    $scope.errortext += " has already been verified.."
                } else if (errors.length > 1) {
                    $scope.errortext += " have already been verified.."
                }
            })
    };
});