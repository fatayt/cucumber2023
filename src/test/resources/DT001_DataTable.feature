@adding_account
Feature:F001_Adding_Account_to_DataTable

@with_scenario_outline
Scenario Outline: DT01_Datatable_with_Scenario_Outline
  Given user is on the datatable page
  And user clicks new button
  And user enters first name "<firstname>"
  And user enters last name "<lastname>"
  And user enters position "<position>"
  And user enters office "<office>"
  And user enters extension "<extension>"
  And user enters start date "<startdate>"
  And user enters salary "<salary>"
  Then user clicks create button
  And user search first name "<search>"
  Then verifies that name fields contain first name
  Then user close data table page


  Examples: Data table
    | firstname | lastname | position               | office    | extension | startdate  | salary |search|
    | Fatih     | Moonstar | QA Automation Engineer | Frankfurt | 3846      | 2022-08-21 | 85000  |Fatih |

@with_datatable
  Scenario: DT02_Datatable_with_DataTable
    Given user is on the datatable page
    And user clicks new button
    When user enters all fields
      | firstname | lastname | position               | office    | extension | startdate  | salary |search|
      | Fatih     | Moonstar | QA Automation Engineer | Frankfurt | 3846      | 2022-08-21 | 85000  |Fatih |
    Then user clicks create button
    Then verifies that name fields contain first name
    Then user close data table page

  @with_excel
  Scenario: DT03_Datatable_with_Excel
    Given user is on the datatable page
    And user clicks new button
    When user enters all fields with excel
    Then user clicks create button
    Then verifies that name fields contain first name
    Then user close data table page



