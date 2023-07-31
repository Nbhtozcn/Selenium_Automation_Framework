Feature: Verify the Community Join Button

  Scenario Outline: Check if the "Katıl" button loads the payment page of the related community
    Given I am on the Evimdeki Psikologlar website homepage
    When I click on the Topluluk button in the top tab
    And I scroll down the webpage
    And I click on the Katıl button under the "<Topluluk>" section
    Then I should see that the opened page is related to the payment page of the "<Topluluk>" community

    Examples:
      | Topluluk             |
      | Romantik İlişkiler   |
      | Göç Eden Türkler     |
      | OKB                  |
      | Depresyon            |
      | Kaygı                |
      | Ebeveyn & Çocuk      |
      | Psikologlar          |
      | Sağlıklı Yaşam       |
      | Sınav Kaygısı        |
      | Yaşlanma Psikolojisi |
      | DEHB                 |
      | Kayıp ve Yas         |



