Feature: Verify the get post in the API 

Background: 
	Given Get the API Base URI 
@SmokeTest
Scenario: Perform operations on API like GET,POST,PUT,PATCH,DELETE

	Given Get call to url test the API 
	When Response code is storing PostPet 
	And Update pet details PutPet 
	And Update pet details PostUpdate 
	Then Delete the pet DeletePet