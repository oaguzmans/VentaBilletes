#Author: omarguzman73@gmail.com


@searchFlights
Feature: Search and select a round-trip ticket from Barcelona to Madrid on Vueling website

  @SearchAndSelectFlight
  Scenario Outline: Enter the Vueling website and select a flight
    Given Login to Vueling website "<url>"
    And Select the round trip option
    When Fill out the form "<txtOrigin>", "<txtDestination>", "<txtNumberAdults>", "<txtNumberChildren>"
    And Search for flights
    Then Select a flight
    And select the tariff "<txtTariffSelected>"
    And validate message page who will travel


    Examples:
      | url   | txtOrigin  | txtDestination  | txtNumberAdults | txtNumberChildren|txtTariffSelected |
        ##@externaldata@src\test\resources\DataDriver\DataProyectVueling.xlsx@CompraVuelos
|https://www.esky.es/aerolineas/al/vy/vueling-airlines?gad_source=1&gclid=EAIaIQobChMIofiX5Oe0jAMVAp9aBR28JzIhEAAYASAAEgJIavD_BwE|Malaga, Pablo Ruiz Picasso, Andalucía, España (AGP)|Madrid, Madrid-Barajas, Madrid, España (MAD)|2|1|Optima|
|https://tickets.vueling.com|Barcelona|Madrid|9|4|Basic|







