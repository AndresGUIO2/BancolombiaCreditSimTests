Feature: Home Loan Simulator
  As a potential home buyer
  I want to simulate a home loan
  So that I can understand my borrowing capacity

  Background:
    Given Juan is on the Bancolombia homepage
    And he navigates to the home loan section
    And he enters to the home value based simulation option

  Scenario Outline: Successful simulation with valid data
    When he enters simulation details:
      | commercial_value  |  percent  |  desired_term  | birthdate   |
      | <commercial_value>| <percent> | <desired_term> | <birthdate> |
    And he clicks on "SIMULAR" button
    Then he should see loan information:
      | loan_amount   |  first_payment  |
      | <loan_amount> | <first_payment> |

    Examples:
      | commercial_value | percent |  desired_term |  birthdate   | loan_amount | first_payment |
      | 80000000         | 70%     |       20      |  10/1/1982   |   56000000  |     559077    |
      | 120000000        | 40%     |       30      |  8/3/2006    |   96000000  |     549635    |

  Scenario Outline: Immediate validation for commercial value bellow the allowed range
    When he enters a commercial value below 52000000 COP
      | commercial_value  |
      | <commercial_value>|
    And he clicks off the field
    Then he should see the error message: "El campo no cumple con el valor mínimo: $ 52.000.000"
    And he should see that the "SIMULAR" button remains disabled

    Examples:
      | commercial_value |
      | 51999999         |
      | 1000000        |