Feature: Uygun Akademi Kayit Olma Feature

  Scenario:Bir ogrenci olarak gecersiz bir telefon numarasi ile sisteme kaydolmaya calistigimda uygun hata mesajini almaliyim
    Given Kayit ol sayfasina git
    And Ad Soyadi gir
    And Email adresini gir
    And Sifreyi gir
    And TC Vatandasi degilim butonuna tikla
    And ILERI butonuna tikla
    And OGRENCI secenegine tikla
    And Gecersiz bir ogrenci telefon numarasi gir
    And Seviye ve Sube sec
    And Ogrenci TC kimlik numarasi gir
    When KAYIT OL a tikla
    Then Lutfen telefon numaranizi giriniz hata mesajini gor

  Scenario: Bir ogrenci olarak sisteme kayit olmak istiyorum
    Given Kayit ol sayfasina git
    And Ad Soyadi gir
    And Email adresini gir
    And Sifreyi gir
    And TC Vatandasi degilim butonuna tikla
    And ILERI butonuna tikla
    And OGRENCI secenegine tikla
    And Ogrenci telefon numarasini gir
    And Seviye ve Sube sec
    And Ogrenci TC kimlik numarasi gir
    When KAYIT OL a tikla
    And Aktivasyon kodunu kaydet
    Then Kayıt işleminiz başarı ile tamamlanmıştır metnini gor


  Scenario: Bir veli olarak kayit olmak istiyorum
    Given Kayit ol sayfasina git
    And Ad Soyadi gir
    And Email adresini gir
    And Sifreyi gir
    And TC Vatandasi degilim butonuna tikla
    And ILERI butonuna tikla
    And VELI secenegine tikla
    And Veli Telefon numarasini gir
    And Veli TC kimlik numarasi gir
    And Aktivasyon kodunu gir ve SORGULA ya tikla
    And KAYIT OL a tikla
    Then Kayıt işleminiz başarı ile tamamlanmıştır metnini gor