Feature: Maaltijden gegroepeerd per categorie

  As a potential customer
  I want to see the available meals grouped in categories.
  In order to decide which meal I want to order.

# Personas
# Jan- Student TI

  Scenario: Lasagne hoort bij pasta, Broodje Martino hoort bij Broodjes, Tomatensoep hoort bij Soepen
    Given Lasagne, Broodje martino en tomatensoep staan op de menu en zijn beschikbaar
    When Jan de menu bekijkt
    Then kan Jan een lijst met categorieen zien en deze zijn producten