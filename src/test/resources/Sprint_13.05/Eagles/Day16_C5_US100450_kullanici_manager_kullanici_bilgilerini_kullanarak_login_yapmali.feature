@manager_login_test
Feature: Login_manager_kullanici_bilgileriyle_deneme
  Scenario Outline:
    Given kullanici application sayfasindadir
    And kullanici manager "<kullaniciadi>" girer
    And kullanici manager "<kullanicisifre>" girer
    Then kullanici login buttonuna click eder
    Then kullanici "<default_page>" oldugunu very eder
    Then kullanici application kapatir

    Examples: Test Data
      | kullaniciadi | kullanicisifre | default_page |
      | manager      | Manager1!      | default_page |
      | manager7     | Manager7!      | default_page |
      | manager12    | Manager12!     | default_page |