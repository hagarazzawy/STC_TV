Feature: Validate the Subscription Packages
@smoke
  Scenario Outline: Validate the Subscription Packages for each country
    Given I open STC TV page
    When I click on the selected country
    And I select country "<country>"
    Then the displayed plans are "<plans>" 
    And the displayed prices are "<prices>"
    And the displayed currencies for each plan are "<currencies>"
    
    Examples:
    |	country		|	plans									|	prices			|	currencies	|	
    |	Bahrain		|	LITE,CLASSIC,PREMIUM	|	1,3,6    		|	BHD,BHD,BHD	|
		|	KSA				|	LITE,CLASSIC,PREMIUM	|	15,25,60		|	SAR,SAR,SAR	|	
		|	Kuwait		|	LITE,CLASSIC,PREMIUM	|	1.2,2.5,4.8	|	KWD,KWD,KWD	|

	

