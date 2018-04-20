@Featuretest 
Feature: Gmail Testing 

@test 
Scenario: Gmail Login 
	Given url opened 
	Then enter user id and click next 
	And enter password 
	And click login 
	
Scenario: Gmail Close 
	Then close browser