Feature: Allergie en vegetarisch informatie

  As a potential customer
  I want to be able to see the allergy information and whether the meal is vegetarian
  In order to be informed about what I can eat

# Personas
# Jan - Student TI

  Scenario: Het broodje met brie en walnoten heeft informatie dat er noten in zitten, het broodje veggylicious heeft de informatie dat het vegetarisch is
    Given Broodje met walnoten en broodje veggylicious
    When “Jan” deze broodjes op het menu ziet
    Then Jan krijgt informatie dat eerste broodje sporen van noten bevat en veggylicious vegetarisch is



  Scenario: Het broodje spelt dat glutenvrij is heeft informatie dat het glutenvrij is
    Given Broodje spelt dat glutenvrij is
    When “Jan” dit broodje op het menu ziet
    Then Jan krijgt informatie dat dit broodje glutenvrij is