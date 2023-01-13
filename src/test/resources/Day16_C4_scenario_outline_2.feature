#When kullanici asagidaki baskentleri arar: London, Paris, Vienna, Berlin, Madrid
#Then  cikan sonuclarin icinde aranan baskentin oldugunu verify eder

@scenario_outline_2_google_arama

Feature: Google_Arama_Fonksiyonu
  Scenario Outline:
    Given kullanici google sayfasindadir
    And kullanici "<baskent>" arar
    Then kullanici sonuclarda "<baskent>" oldugunu verify eder
    Then kullanici application kapatir


    Examples:
      | baskent |
      | London  |
      | Paris   |
      | Vienna  |
      | Berlin  |
      | Madrid  |