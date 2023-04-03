# author: Camilo Escobar
# date: 30/03/2023

Feature: Ingresar al buscador de google
  Como usuario de google quiero ingresar al aplicativo
  para realizar una busqueda.


  @CP_001
  Scenario Outline: Ingresar al buscador google
    Given que el usuario ingresa a la homepage de google
    When realiza una busqueda <cadenaSinEspacios> <conCaracteresEspeciales> <cadenConEspacios> <entero>
    Then deberia ver los resultados de la busqueda

    Examples:
      | cadenaSinEspacios | conCaracteresEspeciales | cadenConEspacios            | entero |
      | Colombia          | correo@gmial.com        | "problematica narcotrafico" | 1995   |
     #para las version de cucumber 7.4.1 se le deben colocar comillas a las cadenas que tengas espacios.