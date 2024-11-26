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
      | 80000000         | 70%     |       25      |  10/1/1991   |   56000000  |     346469    |
      | 120000000        | 80%     |       30      |  8/3/1960    |   96000000  |     549635    |





      | No     | 1,000,000    |  56    | 11/ENE/1998 |     $35,263,565   |    $34,770,548     |      $27,580,772   |

  Scenario Outline: Invalid loan simulation input
    Given Juan is on the Bancolombia homepage
    And he navigates to the loan simulator section
    When he answers the question "¿Sabes cuánto dinero necesitas?" with "<answer>"
    And he enters simulation details free investment:
      | amount   | deadline | birthdate    |
      | <amount> | <deadline> | <birthdate>  |
    Then he should see the following error messages:
      | expected_message |  field |
      | <expected_message> |  <field> |
    Examples:
      | answer | amount   | deadline | birthdate   | field       | expected_message  |
      | Si     | 1,000,000  | 56       | 20/MAR/1939 | birthdate     | Ingrese una fecha válida   |
      | Si     | 1,000,000  | 41       | 11/ENE/1998 | deadline    | El campo no cumple con el valor mínimo: 48 meses |
      | Si     | 500,000   | 48       | 11/ENE/1998 | amount    | El campo no cumple con el valor mínimo: $1.000.000|
