Feature: El app permite registrar multas
  Scenario: Registro de una nueva multa
    Given El policia ingresa el username y el password y hace click en login
    And Hace click en la opcion Mulct del menu
    And Hace click en el boton nuevo
    When Ingresa los datos del detenido y la multa
    And Hace click en el boton Grabar
    Then Los datos son registrados en el sistema