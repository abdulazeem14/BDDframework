Feature: LoginFeature 
@STORE-402 
Scenario Outline: Store Login with Valid Credentials 
	Given User is on a landing page 
	When User enter username and password '<Test Id>' 
	And Username is displayed 
	Then Home page is Displayed 
	
		Examples: 
			|Test Id|
			|Store-402|
		
#@STORE-407 
#Scenario Outline: Store Logout After Successful Login 
#		Given User is on a landing page 
#		When User enter username and password '<Test Id>' 
#		And Username is displayed 
#		And Press the Logout button 
#		Then User is Logout Successfully 
#			
#		Examples: 
#			|Test Id|
#			|Store-407|
#@STORE-403-5 
#Scenario Outline: Store Login with Invalid Credentials 
#		Given User is on a landing page 
#		When User enter username and password '<Test Id>' 
#		Then Error Message Should be displayed 
#					
#		Examples: 
#			|Test Id|
#			|Store-403|
#			|Store-404|
#			|Store-405|
#						
#						
