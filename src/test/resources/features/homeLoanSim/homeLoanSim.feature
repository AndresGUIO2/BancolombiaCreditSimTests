Feature: Home Loan Simulator
  As a potential home buyer
  I want to simulate a home loan
  So that I can understand my borrowing capacity

  Background:
    Given Juan is on the Bancolombia homepage
    And he navigates to the home loan section

  Scenario Outline: Simulate home loan by home value and percent
    Given he enters to the home value based simulation option
    When he enters simulation details:
      | commercial_value  |  percent  |  desired_term  | birthdate   |
      | <commercial_value>| <percent> | <desired_term> | <birthdate> |
    And he clicks on "simular" button
    Then he should see loan information:
      | loan_amount   |  first_payment  |
      | <loan_amount> | <first_payment> |

    Examples:
      | commercial_value | percent |  desired_term |  birthdate   | loan_amount | first_payment |
      | 80000000         | 70%     |       20      |  10/1/1982   |   56000000  |     559077    |
      | 120000000        | 40%     |       30      |  8/3/2006   |   96000000  |     549635    |