/**
 * 
 */

'use strict';

App.factory('MemberService', ['$http', '$q', function($http, $q){

	return {
		
		 searchAllMembers: function(query) {
					return $http.get( '/search?query=' + query )
							.then(
									function(response){								
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while fetching users');
										return $q.reject(errResponse);
									}
							);
			},
			
			
			  fetchAllUsers: function() {
				  
                  return $http.get('/users/')
                          .then(
                                  function(response){
                                      return response.data;
                                  }, 
                                  function(errResponse){
                                      console.error('Error while fetching all users');
                                      return $q.reject(errResponse);
                                  }
                          );
          }
			
}		
			
}]);