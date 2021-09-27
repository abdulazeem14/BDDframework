Feature: CartFeature
Scenario Outline:
Given User is on a landing page
When select the product from PLP page'<Test Id>'
And Navigated to the PDP page
And Product is added to cart
And Navigate to cart page
And Place order and Enter User Details and Payment Details
Then Order Confirmation

Examples:
	|Test Id|
	|Store-4404|
	|Store-4405|
	|Store-4406|
	|Store-4407|
	|Store-4408|