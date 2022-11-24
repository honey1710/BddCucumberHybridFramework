Feature: Dashboard Validation
  Background: User Logged In
    Given User "Admin" is logged in with password "admin123"

  Scenario: Left Menu Items Validation
    Then Left Side Menu Items Should be Available
    |Admin|
    |PIM  |
    |Leave|
    |Time |
    |Recruitment|
    |My Info|
    |Performance|
    |Dashboard  |
    |Directory  |
    |Maintenance|
    |Buzz       |


