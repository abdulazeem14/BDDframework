Feature: Category Feature
@STORE-701
Scenario Outline: Products in the Phone Categories
	Given User is on a landing page 
	When select the phones in categories'<Test Id>' 
	And Products related to Phones category is displayed in PLP
	And Select the Product from PLP
	
	Then Home page is Displayed 
	
		Examples: 
			|Test Id|
			|Store-701|