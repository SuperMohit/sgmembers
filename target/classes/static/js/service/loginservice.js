/**
 * 
 */


'use strict';

loginApp.factory('MemberService', ['$http', '$q', function($http, $q){

	return {
		
		 authenticateUser : function(headers) {
					return $http.get('login', { "headers" : headers})
							.then(
									function(response){								
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while fetching users');
										return $q.reject(errResponse);
									}
							);
			}
	} 
}] );