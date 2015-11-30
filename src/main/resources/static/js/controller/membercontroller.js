'use strict';

App.controller('MemberController', ['$scope', 'MemberService', function($scope, MemberService) {
          var self = this;
          
          self.member = {"id" : null, "status" : "", "race": "", "weight": "", "height" : "", "is_veg":""};
          self.members = [];
          
          self.searchAllMembers = function(){
        	  MemberService.searchAllMembers()
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
          
} );

