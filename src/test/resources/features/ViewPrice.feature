Feature: Prijs moet altijd getoond worden

  As a potential customer
  I want to be able to see the price
  In order to decide what meal I want to order

# Personas
# Jan - Student TI

  Scenario: Het broodje martino kost 2 euro en lasagne kost 4,30 euro
    Given broodje martino en lasagne
    When Jan deze maaltijden ziet
    Then Krijgt Jan de informatie over de prijs en kan hij zo beslissen welke maaltijd hij wil bestellen