Feature: Free Investment Loan Simulator
  As a Bancolombia customer
  I want to simulate a free investment loan
  So that I can evaluate repayment options based on my needs

  Background:
    Given Juan is on the Bancolombia homepage
    And he navigates to the loan simulator section

  Scenario Outline: Simulating the free investment loan is a success story.

    When he answers the question "¿Sabes cuánto dinero necesitas?" with "<answer>"

    And he enters simulation details free investment:
      | amount |  deadline  | birthdate   |
      | <amount> | <deadline> | <birthdate> |
    And he clicks on simulate button
    Then he should see loan information:
      | fees_tf_cf |  fees_tv_cf |  fees_tv_cv   |
      | <fees_tf_cf> |  <fees_tv_cf> | <fees_tv_cv> |

    Examples:
      | answer | amount |  deadline | birthdate   | fees_tf_cf |  fees_tv_cf |  fees_tv_cv |
      | Si     | 20,000,000    |  56    | 11/ENE/1998 |     $567,158     |      $575,199     |      $750,943    |
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

