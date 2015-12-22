/**
 * 
 */

'use strict';

loginApp.controller('LoginController', ['$rootscope','$scope', '$location', 'LoginService', function($rootscope, $scope, $location, LoginService) {
  
   $scope.credentials = {username : "", password : ""};	
   
   var headers = credentials ? {authorization : "Basic "
            + btoa(credentials.username + ":" + credentials.password)
        } : {};
	
	
      $scope.authenticateUser = function () {
    	  
    	  LoginService.authenticateUser(headers)
    	     .then(
    	             function(authUser){
    	            	 
    	            	 if(authUser.name){
    	            	
    	            		 $rootscope.authenticated = true;
    	            	 
    	            	 } else {
    	            		 
    	            		 $rootscope.authenticated = false;
    	            	 }
    	            	
    	            	 callback && callback();
    	             },
    	             
    	             function(errResponse){
    	            	 
    	            	 $rootscope.authenticated = false;
    	            	 console.log("error authenticating user"); 
    	            	 
    	            	 callback && callback();
    	             }
    	            
    	     );
    	  
      }  
        
      authenticate();
   
      $scope.login = function() {
          
    	  authenticateUser($scope.credentials, function() {
          
        	  if ($rootScope.authenticated) {
              
              $location.path("/search");
              $scope.error = false;
              
            } else {
              
              $location.path("/");
              $scope.error = true;
            }
        	  
          });
      };   
      
      
]});