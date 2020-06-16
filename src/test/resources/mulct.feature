Feature: El app permite registrar multas
  Yo como policia quiero registrar las multas de las personas para tener un registro completo
  Scenario: Registro de una nueva multa
    Given El policia ingresa el username y el password y hace click en login
    And Hace click en la opcion Mulct del menu
    And Hace click en el boton nuevo
    When Ingresa los datos del detenido y la multa
    And Hace click en el boton Grabar
    Then Los datos son registrados en el sistema