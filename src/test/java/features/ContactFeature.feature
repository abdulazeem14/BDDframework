Feature: ContactFeature
@Store-1401
Scenario Outline: Send Message from contactUs option in Store WebSite
	Given User is on a landing page
	When Click the Contact option from Top Nav
	And Enter the Contact Email, Contact Name and Message field '<Test Id>'
	Then Message sent Acknowledgement Message is displayed
	
	Examples:
	|Test Id	|
	|Store-1401	|
	|Store-1402	|
	|Store-1403	|
	|Store-1404	|
	