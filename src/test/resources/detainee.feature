Feature: El App permite el registro de un nuevo denetido
  Yo como policia quiero registrar los nuevos detenidos para tener el registro completo
  Scenario: Registro de un nuevo detenido
    Given El policia ingresa el username y el password y hace click en login
    And Hace click en la opcion Detainee del menu
    When Hace click en el boton nuevo de la lista
    And Ingresa los datos del detenido
    And Hace click en el boton Grabar del formulario de detainee
    Then Verificar que el detenido fue registrado