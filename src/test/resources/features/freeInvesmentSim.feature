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






  Scenario Outline: Validate error handling for amount
    Given he has answered the question "¿Sabes cuánto dinero necesitas?" with "Si"
    When he enters simulation details free investment with wrong amount:
      | wrong_amount   | correct_deadline   | correct_birthdate   |
      | <wrong_amount> | <correct_deadline> | <correct_birthdate> |
    Then he should see an error message "<error_message>"
    And he should see the simulate button disabled

    Examples:
      | wrong_amount | correct_deadline | correct_birthdate | error_message                                        |
      | 500000       | 56               | 11/ENE/1998       | El campo no cumple con el valor mínimo: $1.000.000   |
      | 600000000    | 56               | 11/ENE/1998       | El campo no cumple con el valor máximo: $500.000.000 |


  Scenario Outline: Validate error handling for deadline
    Given he has answered the question "¿Sabes cuánto dinero necesitas?" with "Si"
    When he enters simulation details free investment with wrong deadline:
      | correct_amount   | wrong_deadline   | c_birthdate   |
      | <correct_amount> | <wrong_deadline> | <c_birthdate> |
    Then he should see other error message "<error_message2>"
    And he should see the simulate button disabled

    Examples:
      | correct_amount | wrong_deadline | c_birthdate | error_message2                                   |
      | 2000000        | 20             | 11/ENE/1998 | El campo no cumple con el valor mínimo: 48 meses |
      | 2000000        | 90             | 11/ENE/1998 | El campo no cumple con el valor máximo: 84 meses |




  Scenario Outline: Validate invalid age handling for birthdate
    Given he has answered the question "¿Sabes cuánto dinero necesitas?" with "Si"
    When he attempts to select the birthdate field
    Then he should not be able to select the birthdate "<birthdate>"

    Examples:
      | birthdate   |
      | 20/NOV/2010 |
      | 20/NOV/1900 |


