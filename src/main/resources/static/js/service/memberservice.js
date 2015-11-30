/**
 * 
 */

'use strict';

App.factory('MemberService', ['$http', '$q', function($http, $q){

	return {
		
		 searchAllMembers: function() {
					return $http.get('')
							.then(
									function(response){}								
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while fetching users');
										return $q.reject(errResponse);
									}
							);
			},
			
});