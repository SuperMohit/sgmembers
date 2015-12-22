'use strict';

memberApp.controller('MemberController', ['$scope', 'MemberService', function($scope, MemberService) {
        
	      var self = $scope ;
          
          self.member = {"id" : null, "status" : "", "race": "", "weight": "", "height" : "", "is_veg":""};
          self.members = [];
          
          self.query = "";
          
          self.searchAllMembers = function(){
        	 
        	  console.log(self.query);
        	 
        	  MemberService.searchAllMembers(self.query)
                  .then(
      					       function(d) {
      						        self.members = d;
      						        console.log(d);
      					       },
            					function(errResponse){
            						console.error('Error while fetching members');
            					}
      			       );
          };
          
          
          self.fetchAllMembers = function () {
        	  
        	  MemberService.fetchAllUsers()
        	      .then(
        	    	     
        	    		  function(d) {
						        self.members = d;
						        console.log(d);
					       },
      					
					      function(errResponse){
      						console.error('Error while fetching all members');
      					}
        	         
        	     
        	     );
        	  
        	  
          };
          
}] );

