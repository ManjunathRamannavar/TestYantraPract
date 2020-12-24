Feature: Leads

Background:     
    When I want to click on Leads link in homepage
    And I will click on create Lead link
    And I create an Lead using mandatory fileds and click on save
    |SelOption|FirstName|LastName|Company|
    |Mr.|Mick_|Micky_|Dell_|
    Then  Lead information page should display and go back to Lead page

Scenario: I want to Convert created lead to organization
  When I want to select lead from reacord in LeadsPage
  Then Selected lead information page should display 
  And I will click on Convert Lead from Actions 
  Then Convert Lead pop-up should display 
  And Select all the check box from pop-up and fill all mandatory field and click on save
  |CloseDate|
  |2020-12-30|
  Then Organization Information page should display
  
 