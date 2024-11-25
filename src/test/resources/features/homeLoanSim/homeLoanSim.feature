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
      | commercial_value   |
      | <commercial_value> |
    And he clicks off the field
    Then he should see displayed in the "Invalid commercial value label" the error message: "El campo no cumple con el valor mínimo: $ 52.000.000"
    And he should see that the "SIMULAR" button remains disabled

    Examples:
      | commercial_value |
      | 51999999         |
      | 1000000          |

  Scenario: Loan amount is automatically updated after entering the commercial value
    When he enters a commercial value of "150000000"
    Then he should see that the "Percentage dropdown" remain set to "70%"
    And he should see the "Loan amount input" updated to the corresponding value
      | expected_value   |
      | 105,000,000      |

  Scenario Outline: Loan amount is automatically updated after changing the loan percentage
    And he enters a commercial value of "100000000"
    When he selects a loan percentage
      | percentage   |
      | <percentage> |
    Then he should see the "Loan amount input" updated to the corresponding value
      | expected_value   |
      | <expected_value> |

    Examples:
      | percentage | expected_value       |
      | 50%        | 50,000,000           |
      | 20%        | 20,000,000           |

  Scenario Outline: Immediate validation for loan percentage outside allowed range
    When he enters a commercial value of "100000000"
    And he deletes the value of the loan amount input
    And he enters a loan amount that equals a loan percentage below 1% or above 80% of the commercial value
      | loan_amount   |
      | <loan_amount> |
    And he clicks off the field
    Then he should see displayed in the "Invalid percentage label" the error message: "El porcentaje no puede ser mayor al 80% y menor al 1%"
    And he should see that the "SIMULAR" button remains disabled

    Examples:
      | loan_amount |
      | 999999      |
      | 80000001    |

  Scenario: Immediate validation for loan term below the allowed range
    When he enters a loan term below 5 years
      | loan_term |
      | 4         |
    And he clicks off the field
    Then he should see displayed in the "Invalid minimum loan term label" the error message: "El campo no cumple con el valor mínimo: 5 años"
    And he should see that the "SIMULAR" button remains disabled

  Scenario: Immediate validation for loan term above the allowed range
    When he enters a loan term above 30 years
      | loan_term |
      | 31        |
    And he clicks off the field
    Then he should see displayed in the "Invalid maximum loan term label" the error message: "El campo no cumple con el valor máximo: 30 años"
    And he should see that the "SIMULAR" button remains disabled