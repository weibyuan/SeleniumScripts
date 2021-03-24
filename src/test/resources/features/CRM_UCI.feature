@RegressionTest
Feature: CRM UCI feature

  @SmokeInProdInst @SmokeInProdRetail @SmokeInProdHybrid @Institutional @Retail @Hybrid @TC1 @SmokeInProdAll @CreatedByGordon
  Scenario Outline: LeftSideMenu
    Validate each link under Sales on left side menu and make sure no error is displayed to the user

    Given Open CRM "<userName>"
    When Navigate to app
    Then Click on each link under Sales on left side menu and make sure no error is displayed to the user

    Examples: 
      | userName         |
      | svc_qc@pimco.com |

  @SmokeInProdInst @SmokeInProdRetail @SmokeInProdHybrid @Institutional @Retail @Hybrid @TC2 @SmokeInProdAll @CreatedByGordon
  Scenario Outline: TabOnRelationship
    Validate each tab on relationship and make sure no error is displayed to the user

    Given Open CRM "<userName>"
    When Navigate to app
    And Search a relationship "<relationshipRecord>" to Open
    Then make sure no error is displayed to the user
    Then Click on each tab and make sure no error is displayed to the user

    Examples: 
      | userName         | relationshipRecord |
      | svc_qc@pimco.com | 3M Company         |

  @SmokeInProdInst @SmokeInProdRetail @SmokeInProdHybrid @Institutional @Retail @Hybrid @TC3 @SmokeInProdAll @CreatedByGordon
  Scenario Outline: AllLabelsOnRelationship
    Validate all labels on relationship page

    Given Open CRM "<userName>"
    When Navigate to app
    And Search a relationship "<relationshipRecord>" to Open
    Then Validate all labels on the relationship summary page
    Then Click on each tab and validate all labels on the page

    Examples: 
      | userName         | relationshipRecord |
      | svc_qc@pimco.com | 3M Company         |

  @SmokeInProdInst @SmokeInProdRetail @SmokeInProdHybrid @Institutional @Retail @Hybrid @TC4 @SmokeInProdAll @CreatedByOscar
  Scenario Outline: AllTabsOnContact
    Author:Oscar
     Validate all tabs in contact record page and make sure no error is displayed to the user

    Given Open CRM "<userName>"
    When Navigate to app
    And Search out and open the existing contact record "<contactName>"
    Then Make sure no error is displayed
    Then Click on each tab and make sure no error is displayed

    Examples: 
      | userName         | contactName |
      | svc_qc@pimco.com | Barb Larson |

  @SmokeInProdInst @SmokeInProdRetail @SmokeInProdHybrid @Institutional @Retail @Hybrid @TC5 @SmokeInProdAll @CreatedByOscar
  Scenario Outline: AllUIOnContact
    Author:Oscar
     Validate UI in all tabs in contact record page

    Given Open CRM "<userName>"
    When Navigate to app
    And Search out and open the existing contact record "<contactName>"
    Then Validate labels in Summary tab in contact record page

    Examples: 
      | userName         | contactName |
      | svc_qc@pimco.com | Barb Larson |

  @Institutional @Retail @Hybrid @TC6 @CreatedByGordon
  Scenario Outline: Create new relationship with mandatory fields
    Validate all mandatory fields saved successfully

    Given Open CRM "<userName>"
    When Navigate to app
    And Click New National Firm button
    And Enter relationship name "<relationshipName>" on MDM search page to create new relationship
    And Enter the street1 as "<Street1>"
    And Enter the Country as "<Country>"
    And Enter the zipcode as "<zipcode>"
    Then Save the relationship record
    Then Validate relationshp name field
    Then Validate official name field
    Then Validate street1 field saved as "<Street1>"
    Then Validate country field saved as "<Country>"
    Then Validate zipcode field saved as "<zipcode>"

    Examples: 
      | userName         | relationshipName | Street1 | zipcode | Country |
      | svc_qc@pimco.com | QATest           | test    |     666 | Algeria |

  @Institutional @Retail @Hybrid @TC7 @CreatedByOscar
  Scenario Outline: InputRequiredLabelsInContact
    Author:Oscar
    Validate create new contact and fill in required labels

    Given Open CRM "<userName>"
    When Navigate to app
    Then Search one relationship "<relationshipRecord>" to Open
    Then Open new contact page "<firstName>"
    Then Fill in phone label "<phone>"
    Then Fill in email label "<email>"
    Then Save new contact "<firstName>"

    Examples: 
      | userName         | relationshipRecord    | firstName    | phone        | email            |
      | svc_qc@pimco.com | Microsoft Corporation | Test contact | 651-733-9986 | a-larson@mmm.com |

  @Institutional @Retail @Hybrid @TC8 @CreatedByOscar
  Scenario Outline: InpuAllLabelsInContact
    Author:Oscar
    Validate create new contact and fill in all labels

    Given Open CRM "<userName>"
    When Navigate to app
    And Search one relationship "<relationshipRecord>" to Open
    Then Open new contact page "<firstName>"
    Then Fill in phone label "<phone>"
    Then Fill in email label "<email>"
    Then Fill in nick name label "<nickName>"
    Then Fill in job title label "<jobTitle>"
    Then Fill in remarks label "<remarks>"
    Then Save and verify contact "<firstName>"

    Examples: 
      | userName         | relationshipRecord    | firstName    | nickName | jobTitle         | remarks                   | phone        | email            |
      | svc_qc@pimco.com | Microsoft Corporation | Test contact | Barb     | jan Yeomans Asst | Worldwide Capital Markets | 651-733-8888 | b-larson@mmm.com |

  @Institutional @Retail @Hybrid @TC9 @CreatedByOscar
  Scenario Outline: CreatePhoneCallWithRequiredLabels
    Author:Oscar
    Validate create new phone call under contact record and fill in required labels

    Given Open CRM "<userName>"
    When Navigate to app
    And Search out and open the existing contact record "<contactName>"
    And Open new phone call page
    Then Fill in subject label "<phoneCallName>"
    Then Save and verify phone call

    Examples: 
      | userName         | contactName | phoneCallName        | itemValue |
      | svc_qc@pimco.com | Barb Larson | Test phone call data | Contact   |

  @Institutional @Retail @Hybrid @TC10 @CreatedByOscar
  Scenario Outline: EditContactRecord
    Author:Oscar
    Validate edit labels for the existing record

    Given Open CRM "<userName>"
    When Navigate to app
    And Search one relationship "<relationshipRecord>" to Open
    Then Open new contact page "<firstName>"
    Then Fill in phone label "<phone>"
    Then Fill in email label "<email>"
    Then Save new contact "<firstName>"
    Then update labels in conatct page "<newEmail>"

    Examples: 
      | userName         | relationshipRecord    | firstName    | phone        | email            | newEmail         |
      | svc_qc@pimco.com | Microsoft Corporation | Test contact | 651-733-9986 | a-larson@mmm.com | c-larson@mmm.com |

  @Institutional @Hybrid @TC11 @CreatedByOscar
  Scenario Outline: CreateINSTOppWithRequiredLabels
    Author:Oscar
    Validate create INST opportunity record under relationship record and fill in required labels

    Given Open CRM "<userName>"
    When Navigate to app
    And Search one relationship "<relationshipRecord>" to Open
    And Open new INST Opportunity page
    And Fill in INST opp name
    And Select in Consulting Firm / OCIO Involvement
    And Select in Investment Pool "<investmentPoolItem>"
    Then Save and verify inst opportunity

    Examples: 
      | userName         | relationshipRecord    | investmentPoolItem   |
      | svc_qc@pimco.com | Microsoft Corporation | Defined Benefit Plan |

  @Institutional @Retail @Hybrid @TC12 @CreatedByGordon
  Scenario Outline: Create new relationship with all fields
    Validate all mandatory fields saved successfully

    Given Open CRM "<userName>"
    When Navigate to app
    And Click New National Firm button
    And Enter relationship name "<relationshipName>" on MDM search page to create new relationship
    And Enter the street1 as "<Street1>"
    And Enter the street2 as "<Street2>"
    And Enter the street3 as "<Street3>"
    And Enter the City as "<City>"
    And Enter the Country as "<Country>"
    And Enter the State as "<State>"
    And Enter the zipcode as "<zipcode>"
    Then Save the relationship record
    Then Validate relationshp name field
    Then Validate official name field
    Then Validate street1 field saved as "<Street1>"
    Then Validate street2 field saved as "<Street2>"
    Then Validate city field saved as "<City>"
    Then Validate state field saved as "<State>"
    Then Validate country field saved as "<Country>"
    Then Validate zipcode field saved as "<zipcode>"

    Examples: 
      | userName         | relationshipName | Street1 | Street2 | Street3 | City | Country | State | zipcode |
      | svc_qc@pimco.com | QATest           | test    | test2   | test3   | test | Algeria | Alger |     666 |

  @Institutional @Retail @Hybrid @TC13 @CreatedByGordon
  Scenario Outline: NewTaskWithMandatoryFields
    Create new task with mandatory fields and validate the mandatory input fields saved successfully

    Given Open CRM "<userName>"
    When Navigate to app
    And Search a relationship "<relationshipRecord>" to Open
    And Click Task button under Add Activity drop down
    And Input field for Subject as "<Subject>"
    And Input field for Due Date as "<DueDate>"
    And Input field for Due Time as "<DueTime>"
    Then Click SaveClose button
    And Open the created task record
    Then Validate subject fields saved successfully
    Then Validate Due date fields as "<DueDate>" saved successfully
    Then Validate Due time fields as "<DueTime>" saved successfully
    Then Validate relationship fields as "<relationshipRecord>" saved successfully

    Examples: 
      | userName         | relationshipRecord | Subject    | DueDate    | DueTime  |
      | svc_qc@pimco.com | 3M Company         | QATestTask | 10/26/2020 | 12:00 AM |

  @Institutional @Retail @Hybrid @TC14 @CreatedByGordon
  Scenario Outline: NewTaskWithAllFields
    Create new task with all fields and validate the all input fields saved successfully

    Given Open CRM "<userName>"
    When Navigate to app
    And Search a relationship "<relationshipRecord>" to Open
    And Click Task button under Add Activity drop down
    And Input field for Subject as "<Subject>"
    And Input field for primary contact as "<primaryContact>"
    And Input field for Due Date as "<DueDate>"
    And Input field for Due Time as "<DueTime>"
    And Input field for Duration as "<duration>"
    And Input field for Description as "<description>"
    Then Click SaveClose button
    And Open the created task record
    Then Validate subject fields saved successfully
    Then Validate primary contact saved successfully as "<primaryContact>"
    Then Validate Due date fields as "<DueDate>" saved successfully
    Then Validate Due time fields as "<DueTime>" saved successfully
    Then Validate duration as "<duration>" saved successfully
    Then Validate description as "<description>" saved successfully
    Then Validate relationship fields as "<relationshipRecord>" saved successfully

    Examples: 
      | userName         | relationshipRecord | Subject    | DueDate    | DueTime  | primaryContact | duration   | description |
      | svc_qc@pimco.com | 3M Company         | QATestTask | 10/26/2020 | 12:00 AM | Barb Larson    | 45 minutes | test        |

  @Institutional @Hybrid @TC15 @CreatedByOscar
  Scenario Outline: CreateINSTOppWithAllLabels
    Author:Oscar
     Validate create INST opportunity record under relationship record and fill all labels

    Given Open CRM "<userName>"
    When Navigate to app
    And Search one relationship "<relationshipRecord>" to Open
    And Open new INST Opportunity page
    And Fill in INST opp name
    And Select in Consulting Firm / OCIO Involvement
    And Select in Investment Pool "<investmentPoolItem>"
    And Fill in Strategy/Product "<strategyProductValue>"
    And Fill in Est Close Date "<estCloseDateValue>"
    And Fill in Est Size MM "<estSizeMMValue>"
    And Fill in Description "<descriptionValue>"
    Then Save and verify inst opportunity
    Then Validate value in Strategy/Product "<strategyProductValue>"
    Then Validate value in Est Close Date "<estCloseDateValue>"
    Then Validate value in Est Size MM "<estSizeMMValue>"
    Then Validate value in Investment Pool "<investmentPoolItem>"
    Then Validate value in Description "<descriptionValue>"

    Examples: 
      | userName         | relationshipRecord    | investmentPoolItem   | strategyProductValue    | estCloseDateValue | estSizeMMValue | descriptionValue   |
      | svc_qc@pimco.com | Microsoft Corporation | Defined Benefit Plan | MF Senior Floating Rate | 12/27/2020        |             19 | Test Inst opp data |

  @Institutional @Retail @Hybrid @TC16 @CreatedByGordon
  Scenario Outline: NewMeetingWithRequiredFields
    Create new meeting with required fields and validate the input fields saved successfully

    Given Open CRM "<userName>"
    When Navigate to app
    And Search a relationship "<relationshipRecord>" to Open
    And Click Meeting button under Add Activity drop down
    And Input subjcet field as "<Subject>"
    And Input primary attendee as "<primaryAttendee>"
    And Select activity purpose
    And Click save button to save record
    Then Validate subject fields saved successfully for meeting
    Then Validate primary attendee as "<primaryAttendee>" saved successfully

    Examples: 
      | userName         | relationshipRecord | Subject       | primaryAttendee |
      | svc_qc@pimco.com | 3M Company         | QATestMeeting | Aaron Anderson  |

  @Retail @Hybrid @TC17 @CreatedByGordon
  Scenario Outline: NewRetailOpporWithRequiredFields
    Create new Retail opportunity record and fill in required fields.

    Given Open CRM "<userName>"
    When Navigate to app
    And Search out and open the existing contact record "<contactName>"
    And Click on Add Opportunity button
    And Fill in opportunity name field as "<retailOpporName>"
    And Click Save button to save retail opportunity
    Then Validate retail opportunity saved successfully
    Then Validate retail opportunity name

    Examples: 
      | userName         | contactName | retailOpporName   |
      | svc_qc@pimco.com | Barb Larson | QAtestRetailOppor |

  @Retail @Hybrid @TC18 @CreatedByGordon
  Scenario Outline: NewRetailOpporWithAllFields
    Create new Retail opportunity record and fill in all fields.

    Given Open CRM "<userName>"
    When Navigate to app
    And Search out and open the existing contact record "<contactName>"
    And Click on Add Opportunity button
    And Fill in opportunity name field as "<retailOpporName>"
    And Fill in strategy field as "<strategyProduct>"
    And Fill in Est close date field as "<estCloseDate>"
    And Fill in Est size field as "<estSize>"
    And Fill in description field as "<description>"
    And Click Save button to save retail opportunity
    Then Validate retail opportunity saved successfully
    Then Validate retail opportunity name
    Then Validate strategy field as "<strategyProduct>"
    Then Validate Est close date field as "<estCloseDate>"
    Then Validate Est size field as "<estSize>"
    Then Validate description field as "<description>"

    Examples: 
      | userName         | contactName | retailOpporName   | strategyProduct | estCloseDate | estSize | description |
      | svc_qc@pimco.com | Barb Larson | QAtestRetailOppor | ABS - EURO      | 12/24/2020   |   10000 | test        |

  @Institutional @Retail @Hybrid @TC20 @CreatedByGordon
  Scenario Outline: NewMeetingWithAllFields
    Create new meeting with all fields and validate the input fields saved successfully

    Given Open CRM "<userName>"
    When Navigate to app
    And Search a relationship "<relationshipRecord>" to Open
    And Click Meeting button under Add Activity drop down
    And Input subjcet field as "<Subject>"
    And Input primary attendee as "<primaryAttendee>"
    And Input start date as "<startDate>"
    And Input start time as "<startTime>"
    And Input end date as "<endDate>"
    And Input end time as "<endTime>"
    And Select location
    And Input city as "<city>"
    And Select engagement type
    And Select activity purpose
    And Select external attendees as "<externalAttendees>"
    And Select product as "<product>"
    And Input notes as "<notes>"
    And Select RTC
    And Click save button to save record
    Then Validate subject fields saved successfully for meeting
    Then Validate primary attendee as "<primaryAttendee>" saved successfully
    Then Validate start date as "<startDate>"
    Then Validate start time as "<startTime>"
    Then Validate end date as "<endDate>"
    Then Validate end time as "<endTime>"
    Then Validate location as "<location>"
    Then Validate city as "<city>"
    Then Validate engagement type as "<engagement>"
    Then Validate notes as "<notes>"
    Then Validate activity purpose as "<activityPurpose>"
    Then Validate product as "<product>"
    Then Validate external attendees as "<externalAttendees>"
    Then Validate RTC

    Examples: 
      | userName         | relationshipRecord | Subject       | primaryAttendee | startDate  | startTime | endDate    | endTime | location        | city          | engagement            | notes | activityPurpose     | product            | externalAttendees |
      | svc_qc@pimco.com | 3M Company         | QATestMeeting | Aaron Anderson  | 12/24/2020 | 12:00 PM  | 12/25/2020 | 1:00 PM | Client/Prospect | newport beach | Meaningful Engagement | test  | Operational Support | Alts CLO Opps Fund | Barb Larson       |

  @Institutional @Retail @Hybrid @TC21 @CreatedByGordon
  Scenario Outline: ExportToExcelOnActivityManager
    Make sure Export to Excel button working as expect

    Given Open CRM "<userName>"
    When Navigate to app
    And Click on Activity Manager left side menu
    And Search Activities by user "<user>",select from "<startDate>" and to "<endDate>" then click Export to Excel button
    Then Validate the counts for activities are same with the ones in exported excel

    Examples: 
      | userName         | user     | startDate | endDate   |
      | svc_qc@pimco.com | Jingyang | 2/17/2021 | 2/17/2021 |

  @SmokeInProdInst @SmokeInProdRetail @SmokeInProdHybrid @Institutional @Retail @Hybrid @TC22 @SmokeInProdAll @CreatedByGordon
  Scenario Outline: AdvanceSearchRelationship
    Make sure Export to Excel function working on Advance Seaarch for relationship

    Given Open CRM "<userName>"
    When Navigate to app
    And Click on Advance Search left side menu
    And Search for "<relationshipName>" relationship
    And Open the result in CRM-Grid
    And Click on Export to Excel button
    Then Validate the counts for Relationship are same with the ones in exported excel

    Examples: 
      | userName         | relationshipName |
      | svc_qc@pimco.com | 3M Company       |

  @Institutional @Retail @Hybrid @TC23 @CreatedByOscar
  Scenario Outline: CreatePhoneCallWithAllLabels
    Author:Oscar
    Validate create new phone call under contact record and fill in all labels

    Given Open CRM "<userName>"
    When Navigate to app
    And Search out and open the existing contact record "<contactName>"
    And Open new phone call page
    Then Fill in subject label "<phoneCallName>"
    Then Select value in engagement type label
    Then Fill in value in notes label "<notesValue>"
    Then Select value in Products label "<productsValue>"
    Then Select value in Reasons to Contact label
    #Then Select value in Additional Relationships
    Then Save and verify phone call
    Then Validate value in engagement type label

    #Then Validate value in notes label "<notesValue>"
    #Then Validate value in Products label "<productsValue>"
    #Then Validate value in Reasons to Contact label
    Examples: 
      | userName         | contactName | phoneCallName        | itemValue | notesValue           | productsValue |
      | svc_qc@pimco.com | Barb Larson | Test phone call data | Contact   | test phone call data | Tac Opps      |

  @SmokeInProdInst @SmokeInProdRetail @SmokeInProdHybrid @Institutional @Retail @Hybrid @TC24 @SmokeInProdAll @CreatedByGordon
  Scenario Outline: AdvanceSearchContact
    Make sure Export to Excel function working on Advance Seaarch for contact

    Given Open CRM "<userName>"
    When Navigate to app
    And Click on Advance Search left side menu
    And Search for contact as "<firstName>" and "<lastName>"
    And Open the result in CRM-Grid
    And Click on Export to Excel button
    Then Validate the counts for Contact are same with the ones in exported excel

    Examples: 
      | userName         | firstName | lastName |
      | svc_qc@pimco.com | shane     | casey    |

  @SmokeInProdInst @SmokeInProdHybrid @Institutional @Hybrid @TC25 @CreatedByGordon
  Scenario Outline: AdvanceSearchAccount
    Make sure Export to Excel function working on Advance Seaarch for account

    Given Open CRM "<userName>"
    When Navigate to app
    And Click on Advance Search left side menu
    And Search for account as "<accountNumber>"
    And Open the result in CRM-Grid
    And Click on Export to Excel button
    Then Validate the counts for Account are same with the ones in exported excel

    Examples: 
      | userName         | accountNumber |
      | svc_qc@pimco.com |            18 |

  @SmokeInProdInst @SmokeInProdRetail @SmokeInProdHybrid @Institutional @Retail @Hybrid @TC26 @SmokeInProdAll @CreatedByGordon
  Scenario Outline: AdvanceSearchOpportunity
    Make sure Export to Excel function working on Advance Seaarch for opportunity

    Given Open CRM "<userName>"
    When Navigate to app
    And Click on Advance Search left side menu
    And Search for opportunity as "<opportunityName>"
    And Open the result in CRM-Grid
    And Click on Export to Excel button
    Then Validate the counts for Opportunity are same with the ones in exported excel

    Examples: 
      | userName         | opportunityName |
      | svc_qc@pimco.com | sample          |

  @SmokeInProdInst @SmokeInProdRetail @SmokeInProdHybrid @Institutional @Retail @Hybrid @TC27 @SmokeInProdAll @CreatedByGordon
  Scenario Outline: AdvanceSearchEvent
    Make sure Export to Excel function working on Advance Seaarch for opportunity

    Given Open CRM "<userName>"
    When Navigate to app
    And Click on Advance Search left side menu
    And Search for event as "<eventName>"
    And Open the result in CRM-Grid
    And Click on Export to Excel button
    Then Validate the counts for event are same with the ones in exported excel

    Examples: 
      | userName         | eventName                |
      | svc_qc@pimco.com | CFA Society Boston Event |

  @SmokeInProdInst @SmokeInProdRetail @SmokeInProdHybrid @Institutional @Retail @Hybrid @TC28 @SmokeInProdAll @CreatedByGordon
  Scenario Outline: AdvanceSearchInvitee
    Make sure Export to Excel function working on Advance Seaarch for invitee

    Given Open CRM "<userName>"
    When Navigate to app
    And Click on Advance Search left side menu
    And Search for invitee as "<firstName>" and "<lastName>"
    And Open the result in CRM-Grid
    And Click on Export to Excel button
    Then Validate the counts for invitee are same with the ones in exported excel

    Examples: 
      | userName         | firstName | lastName |
      | svc_qc@pimco.com | William   | Zhang    |

  @TC29 @Institutional @Hybrid @CreatedByGordon @SmokeInProdInst @SmokeInProdHybrid
  Scenario Outline: allRibbonButtonsOnInstOpportunity
      Click on all ribbon buttons one by one and make sure no error displayed

    Given Open CRM "<userName>"
    When Navigate to app
    And Search a Inst opportunity "<opportunityName>" to Open
    Then Click on all ribbon buttons on the Inst opportunity "<opportunityName>" page and validate no error displayed

    Examples: 
      | userName         | opportunityName       |
      | svc_qc@pimco.com | Tail Risk Hedging Opp |

  @Retail @Hybrid @TC30 @CreatedByGordon @SmokeInProdRetail @SmokeInProdHybrid
  Scenario Outline: allRibbonButtonsOnRetailOpportunity
      Click on all ribbon buttons one by one and make sure no error displayed

    Given Open CRM "<userName>"
    When Navigate to app
    And Search a Retail opportunity "<opportunityName>" to Open
    Then Click on all ribbon buttons on the Retail opportunity "<opportunityName>" page and validate no error displayed

    Examples: 
      | userName         | opportunityName |
      | svc_qc@pimco.com | USD Mandates    |

  @Institutional @Hybrid @TC31 @CreatedByGordon @SmokeInProdInst @SmokeInProdHybrid
  Scenario Outline: allRibbonButtonsOnAccount
      Click on all ribbon buttons one by one and make sure no error displayed

    Given Open CRM "<userName>"
    When Navigate to app
    And Search an account "<accountNumber>" to Open
    Then Click on all ribbon buttons on the account and validate no error displayed

    Examples: 
      | userName         | accountNumber |
      | svc_qc@pimco.com |          3059 |

  @SmokeInProdInst @SmokeInProdRetail @SmokeInProdHybrid @Institutional @Retail @Hybrid @TC32 @SmokeInProdAll @CreatedByOscar
  Scenario Outline: allRibbonButtonsOnContact
    Click on all ribbon buttons in contact reocrd page and make sure no error is displayed

    Given Open CRM "<userName>"
    When Navigate to app
    And Search out and open the existing contact record "<contactName>"
    Then Make sure no error is displayed
    Then Click on all ribbon buttons in contact reocrd page and make sure no error is displayed

    Examples: 
      | userName         | contactName |
      | svc_qc@pimco.com | Barb Larson |

  @Institutional @Retail @Hybrid @TC33 @CreatedByGordon
  Scenario Outline: addMarketingList
    click on add new marketing list and validate if this page is opening without any error.

    Given Open CRM "<userName>"
    When Navigate to app
    And Change area as "<areaName>"
    And Click new button on marketing list search page
    Then Validate if the target page is opening without any error

    Examples: 
      | userName         | areaName  |
      | svc_qc@pimco.com | Marketing |

  @Institutional @Retail @Hybrid @TC34 @CreatedByGordon
  Scenario Outline: OrderLiterature
    click on add new marketing list and validate if this page is opening without any error.

    Given Open CRM "<userName>"
    When Navigate to app
    And Search out and open the existing contact record "<contactName>"
    And Click Order Literature button
    Then Validate if the Order Literature page is opening without any error

    Examples: 
      | userName         | contactName |
      | svc_qc@pimco.com | Barb Larson |

  @Institutional @Retail @Hybrid @TC35 @CreatedByOscar
  Scenario Outline: allRibbonButtonsOnPhoneCall
    Click on all ribbon buttons in phone call reocrd page and make sure no error is displayed

    Given Open CRM "<userName>"
    When Navigate to app
    And Search out and open the existing other contact record "<contactName>"
    #And Open new phone call page
    #Then Fill in subject label "<phoneCallName>"
    #Then Save and verify phone call
    Then Click on all ribbon buttons in phone call reocrd page and make sure no error is displayed

    Examples: 
      | userName         | contactName   | phoneCallName                  | itemValue |
      | svc_qc@pimco.com | Cameron Retif | Test phone call data For Oscar | Contact   |

  @Institutional @Retail @Hybrid @TC36 @CreatedByGordon
  Scenario Outline: allRibbonButtonsOnMeeting
    Click on all ribbon buttons on meeting page and make sure no error is displayed

    Given Open CRM "<userName>"
    When Navigate to app
    And Click on Activity Manager left side menu
    And Search Activities by user "<user>",select from "<startDate>"
    And Open the meeting record "<meetingRecord>" on the grid
    Then Click on all ribbon buttons on the meeting page and make sure no error is displayed

    Examples: 
      | userName         | user     | startDate| meetingRecord |
      | svc_qc@pimco.com | Jingyang | 2/17/2021 |QATESTMeeting |

 

  @Institutional @Retail @Hybrid @TC38 @CreatedByOscar
  Scenario Outline: allRibbonButtonsOnEmail
    Click on all ribbon buttons in email reocrd page and make sure no error is displayed

    Given Open CRM "<userName>"
    When Navigate to app
    And Search out and open the existing other contact record "<contactName>"
    Then Click on all ribbon buttons in email reocrd page and make sure no error is displayed

    Examples: 
      | userName         | contactName            | toLabelValue       |
      | svc_qc@pimco.com | 3M Public Equity Alias | Tony.Han@pimco.com |

  @SmokeInProdInst @SmokeInProdRetail @SmokeInProdHybrid @Institutional @Retail @Hybrid @TC39 @CreatedByGordon @SmokeInProdAll
  Scenario Outline: AdvanceFind
    Click on Advance Find button on header and it should open the Advance find in new window

    Given Open CRM "<userName>"
    When Navigate to app
    And Click on Advance Find button on header
    Then Validate the Advance Find should be opened in new window

    Examples: 
      | userName         |
      | svc_qc@pimco.com |

  @Retail @TC40 @CreatedByGordon @SmokeInProdRetail
  Scenario Outline: RTCDashboard
    Data should load on page after user selects a user in “View List for” drop down

    Given Open CRM "<userName>"
    When Navigate to app
    And Switch to RTCs dashboard view
    Then Validate Data should load on page when the "<user>" selected

    Examples: 
      | userName         | user          |
      | svc_qc@pimco.com | jill hamilton |

  @Institutional @Retail @Hybrid @TC41 @CreatedByOscar
  Scenario Outline: quickCreateNewPhoneCallOnContact
    Quick create new phone call record on contact page

    Given Open CRM "<userName>"
    When Navigate to app
    And Search out and open the existing contact record "<contactName>"
    And Open the quick create new phone call record page
    And Fill in required label
    Then Click Save and Close button

    Examples: 
      | userName         | contactName |
      | svc_qc@pimco.com | Barb Larson |

  @Institutional @Retail @Hybrid @TC42 @CreatedByOscar
  Scenario Outline: inputRequiredLabelsInNewEmail
    Create new email record and input required fields

    Given Open CRM "<userName>"
    When Navigate to app
    And Search out and open the existing contact record "<contactName>"
    And Open new email page
    And Fill in required label "<toLabelValue>"
    And Click Save button
    Then Click on buttons in email reocrd page and make sure no error is displayed

    Examples: 
      | userName         | contactName | toLabelValue       |
      | svc_qc@pimco.com | Barb Larson | Tony.Han@pimco.com |

  @Institutional @Retail @Hybrid @TC43 @CreatedByGordon
  Scenario Outline: quickCreateMeetingOnRelationship
    Quick create new meeting record on relationship page

    Given Open CRM "<userName>"
    When Navigate to app
    And Search a relationship "<relationshipRecord>" to Open
    And Open the quick create new "<activity>" activity record page
    And Input field for Subject as "<Subject>"
    And Input field for Relationship "<relationshipRecord>"
    And Input primary attendee as "<PrimaryAttendee>"
    Then Click SaveClose button

    Examples: 
      | userName         | relationshipRecord | activity | Subject | PrimaryAttendee |
      | svc_qc@pimco.com | 3M Company         | Meeting  | QAtest  | Barb Larson     |

  @SmokeInProdInst @SmokeInProdRetail @SmokeInProdHybrid @SmokeInProdAll @Institutional @Retail @Hybrid @TC19 @CreatedByGordon
  Scenario Outline: allRibbonButtonsOnRelationship
      Click on all ribbon buttons one by one and make sure no error displayed

    Given Open CRM "<userName>"
    When Navigate to app
    And Search a relationship "<relationshipRecord>" to Open
    Then Click on all ribbon buttons on the relationship page and validate no error displayed

    Examples: 
      | userName         | relationshipRecord |
      | svc_qc@pimco.com | 3M Company         |

  @Institutional @Retail @Hybrid @TC44 @CreatedByOscar
  Scenario Outline: quickCreateMeetingOnContact
    Quick create new meeting record on contact page

    Given Open CRM "<userName>"
    When Navigate to app
    And Search out and open the existing contact record "<contactName>"
    And Open the quick create new meeting record page
    And Fill in required label in new meeting record page
    Then Click Save and Close button

    Examples: 
      | userName         | contactName |
      | svc_qc@pimco.com | Barb Larson |

  @Institutional @Retail @Hybrid @TC45 @CreatedByOscar
  Scenario Outline: quickCreateTaskOnContact
    Quick create new task record on contact page

    Given Open CRM "<userName>"
    When Navigate to app
    And Search out and open the existing contact record "<contactName>"
    And Open the quick create new task record page
    And Input field for Subject as "<Subject>"
    And Input field for Due Date as "<DueDate>"
    #And Input field for Due Time as "<DueTime>"
    Then Click SaveClose button

    Examples: 
      | userName         | contactName | Subject    | DueDate    | DueTime  |
      | svc_qc@pimco.com | Barb Larson | QATestTask | 10/26/2021 | 12:00 AM |

  @Institutional @Retail @Hybrid @TC46 @CreatedByGordon
  Scenario Outline: quickCreateNewPhoneCallRelationship
    Quick create new phone call record on relationship page

    Given Open CRM "<userName>"
    When Navigate to app
    And Search a relationship "<relationshipRecord>" to Open
    And Open the quick create new "<activity>" activity record page
    And Fill in required label
    Then Click Save and Close button

    Examples: 
      | userName         | relationshipRecord | activity |
      | svc_qc@pimco.com | 3M Company         | Phone Call |
 
 @Institutional @Retail @Hybrid @TC47 @CreatedByGordon
  Scenario Outline: quickCreateTaskOnRelationship
    Create quick task on relationship page

    Given Open CRM "<userName>"
    When Navigate to app
    And Search a relationship "<relationshipRecord>" to Open
    And Open the quick create new "<activity>" activity record page
    And Input field for Subject as "<Subject>"
     And Input field for Relationship "<relationshipRecord>"
    And Input field for Due Date as "<DueDate>"
    And Input field for Due Time as "<DueTime>"
    Then Click SaveClose button

    Examples: 
      | userName         | relationshipRecord | Subject    |activity|DueDate|DueTime|
      | svc_qc@pimco.com | 3M Company         | QATestTask | Task |10/26/2021|12:00 AM|