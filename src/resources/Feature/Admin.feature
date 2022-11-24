Feature: Validate Admin page

  Background:
    Given User "Admin" is logged in with password "admin123" and at AdminPage



Scenario Outline: Search with Username
When Search with username '<username>'
Then Record Should be displayed with username '<username>'

Examples:
|username|
|Admin   |

