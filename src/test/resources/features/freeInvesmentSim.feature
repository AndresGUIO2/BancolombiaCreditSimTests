Feature: Free Investment Loan Simulator
  As a Bancolombia customer
  I want to simulate a free investment loan
  So that I can evaluate repayment options based on my needs

  Background:
    Given Juan is on the Bancolombia homepage
    And he navigates to the loan simulator section

  Scenario Outline: Simulate free investment loan by amount and term

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
      | Si     | 20000000    |  56    | 11/ENE/1998 |     $567,158     |      $575,199     |      $750,943    |
      | No     | 1000000    |  56    | 11/ENE/1998 |     $30,970,406    |        |      $39,724,100    |
