Feature: Validating Account Overview page scenarios
   
   @Regression @TC01 @PROD @Severity(Severitylevel.High)
  Scenario Outline: CFPortal_AO_Tab_Verification
  /* */ Validate expected tabs are displaying or not for all account types*/
    Given The user navigate to application URL 
    Then Verify title as "Single Account Overview" after loading the URL
    And The user enters account number as "<accountNumber>" and click enter
    And Verify all tabs are displaying "<expectedTabs>" 

    Examples:
    |accountNumber  |expectedTabs					|
    |12				|Overview,Overview Credit,Overview Country  			|
    |700			|Overview,Overview Credit,Overview Country,Share Class Detail,Fund External			|
    |400			|Overview,Overview Credit,Overview Country,Share Class Detail				|
    |771			|Overview,Overview Credit,Overview Country,Share Class Detail,Fund External				|
    |401			|Overview,Overview Credit,Overview Country,Share Class Detail				|
    |758			|Overview,Overview Fixed Income,Overview Equity,Overview Country,Share Class Detail		|
 

  @Regression @TC02 @PROD @Severity(Severitylevel.High)
  Scenario Outline: CFPortal_AO_Tiles_Verification
   /* */ Validate tile information is loaded or not for Overview tab - Pimco Bogie for all account types (Client_Account_Overview_Account)*/
    Given The user navigate to application URL 
    Then Verify title as "Single Account Overview" after loading the URL
    And The user enters account number as "<accountNumber>" and click enter
    And Verify for these "<tileNames>" tiles information is getting loaded or not on overview page
    
    Examples:
    |accountNumber  |fundName														|tileNames																																																					|
     |758			|PIMCO Global Multi-Asset Fund									|Acct Info FOF,Allocation by Region (Look Thru),Perf - Daily,Perf - Month End,Asset Class Allocation, Currency Allocation by Region (Look Thru), Perf - Historical Annual													|
    # |14858			|PIMCO Multi-Strategy Alternative Main Sleeve					|Acct Info PIMCO,Duration PIMCO,Maturity PIMCO,Perf - Daily,Perf - Month End,Perf - Historical Annual,Risk Allocation,Regional Sectors (by Currency) PIMCO,Quality PIMCO									|
   #  |766			|PIMCO Income Fund												|Acct Info PIMCO,Duration PIMCO,Maturity PIMCO,Perf - Daily,Perf - Month End,Perf - Historical Annual,Sector Level1 PIMCO,Regional Sectors (by Currency) PIMCO,Quality PIMCO									|
     
   @Regression @TC03 @Severity(Severitylevel.Normal)
  Scenario Outline: CFPortal_AO_OverviewCredit_Tiles_Verification
  /* */ Validate tile information is loaded or not for Overview Credit tab - Pimco Bogie for all account types*/
    Given The user navigate to application URL 
    Then Verify title as "Single Account Overview" after loading the URL
    And The user enters account number as "<accountNumber>" and click enter
    And click on "Overview Credit" tab
    And Verify for these "<tileNames>" tiles information is getting loaded or not on overview page
    
    Examples:
    |accountNumber  |tileNames																																							|
    |12				|Credit Overweight By Industry,Credit Overweight By Issuer,Credit Underweight By Industry,Credit Underweight By Issuer												|
     
    
  @Regression @TC04 @Severity(Severitylevel.Normal)
  Scenario Outline: CFPortal_AO_OverviewCountry_Tiles_Verification
  /* */ Validate tile information is loaded or not for Overview Country tab - Pimco Bogie for all account types*/
    Given The user navigate to application URL 
    Then Verify title as "Single Account Overview" after loading the URL
    And The user enters account number as "<accountNumber>" and click enter
    And click on "Overview Country" tab
    And Verify for these "<tileNames>" tiles information is getting loaded or not on overview page
    
    Examples:
    |accountNumber  |tileNames																																																					|
    |758			|Country Breakout (Look Thru - Fund of Funds)													|	
    |12				|Country (by Currency),Country (by Issuer)														|
    
     @Regression @TC05 @Severity(Severitylevel.Normal)
  Scenario Outline: CFPortal_AO_OverviewFixedIncome_Tiles_Verification
  /* */ Validate tile information is loaded or not for Overview Fixed Income tab - Pimco Bogie for all account types*/
    Given The user navigate to application URL 
    Then Verify title as "Single Account Overview" after loading the URL
    And The user enters account number as "<accountNumber>" and click enter
    And click on "Overview Fixed Income" tab
    And Verify for these "<tileNames>" tiles information is getting loaded or not on overview page
    
    Examples:
    |accountNumber  |tileNames																																																					|
    |758			|Credit Overweight By Industry,Credit Underweight By Issuer,Credit Underweight By Industry,Credit Overweight By Issuer,Fixed Income Sectors,Quality PIMCO													|
    
      @Regression @TC06 @Severity(Severitylevel.Normal)
  Scenario Outline: CFPortal_AO_OverviewEquity_Tiles_Verification
  /* */ Validate tile information is loaded or not for Overview Equity tab - Pimco Bogie for all account types
    Given The user navigate to application URL 
    Then Verify title as "Single Account Overview" after loading the URL
    And The user enters account number as "<accountNumber>" and click enter
    And click on "Overview Equity" tab
    And Verify for these "<tileNames>" tiles information is getting loaded or not on overview page
    
    Examples:
    |accountNumber  |tileNames																																																					|
    |758			|Acct Info,Equity Sectors (Look Thru)												|
    
      @Regression @TC07 @Severity(Severitylevel.Normal)
  Scenario Outline: CFPortal_AO_ShareClass_Tiles_Verification
  /* */ Validate tile information is loaded or not for Share Class Detail tab - Pimco Bogie for all account types */
    Given The user navigate to application URL 
    Then Verify title as "Single Account Overview" after loading the URL
    And The user enters account number as "<accountNumber>" and click enter
    And click on "Share Class Detail" tab
    And Verify for these "<tileNames>" tiles information is getting loaded or not on overview page
    
    Examples:
    |accountNumber  |tileNames																																																					|
    |758			|Fund Detail,Fund Info Grid,Daily Perf													|
    
  @Regression @TC08 @Severity(Severitylevel.Normal)
  Scenario Outline: CFPortal_AO_FundExternal_Tiles_Verification
  /* */ Validate tile information is loaded or not for Fund External tab - Pimco Bogie for all account types */
    Given The user navigate to application URL 
    Then Verify title as "Single Account Overview" after loading the URL
    And The user enters account number as "<accountNumber>" and click enter
    And click on "Fund External" tab
    And Verify for these "<tileNames>" tiles information is getting loaded or not on overview page
    
    Examples:
    |accountNumber  |tileNames																																																					|
    |758			|Fund Info,Performance,Maturity													|	
    
  @Regression @TC09 @Severity(Severitylevel.Normal)
  Scenario: CFPortal_AO_CRMLink_Verification
  /* */ Verify CRM Link in Account Overview page is working or not*/
    Given The user navigate to application URL 
    Then Verify title as "Single Account Overview" after loading the URL
    And The user enters account number as "12" and click enter
    When The user clicks on CRM Link
    Then Verify page should navigate to CRM login page "Sign in to your account"
    And Login into CRM application with "svc_qc@pimco.com"
    And click on Next Link in CRM application
    And Verify Account number "12" in CRM Application
    
     	
  
   @Regression @TC10 @Severity(Severitylevel.Normal)
  Scenario Outline: CFPortal_AO_PublishedBogie_Tiles_Verification
  /* */ Validate tile information is loaded or not for Overview tab - Published Bogie for all account types */
    Given The user navigate to application URL 
    Then Verify title as "Single Account Overview" after loading the URL
    And The user enters account number as "<accountNumber>" and click enter
    And Click on Pimco Bogie button
    And Verify for these "<tileNames>" tiles information is getting loaded or not on overview page
    
    Examples:
    |accountNumber  |tileNames																																																					|
    |758			|Acct Info FOF,Allocation by Region (Look Thru),Perf - Daily,Perf - Month End,Asset Class Allocation, Currency Allocation by Region (Look Thru), Perf - Historical Annual													|
   
   @Regression @TC11 @Severity(Severitylevel.Normal)
  Scenario Outline: CFPortal_AO_OverviewCountry_PublishedBogie_Tiles_Verification
 /* */  Validate tile information is loaded or not for Overview Country tab - Published Bogie for all account types */
    Given The user navigate to application URL 
    Then Verify title as "Single Account Overview" after loading the URL
    And The user enters account number as "<accountNumber>" and click enter
    And Click on Pimco Bogie button
    And click on "Overview Country" tab
    And Verify for these "<tileNames>" tiles information is getting loaded or not on overview page
    
    Examples:
    |accountNumber  |tileNames																																																					|
    |758			|Country Breakout (Look Thru - Fund of Funds)													|	
    |12				|Country (by Currency),Country (by Issuer)														|
    
     @Regression @TC12 @Severity(Severitylevel.Normal)
  Scenario Outline: CFPortal_AO_OverviewFixedIncome_PublishedBogie_Tiles_Verification
  /* */ Validate tile information is loaded or not for Overview Fixed Income tab - Published Bogie for all account types*/
    Given The user navigate to application URL 
    Then Verify title as "Single Account Overview" after loading the URL
    And The user enters account number as "<accountNumber>" and click enter
    And Click on Pimco Bogie button
    And click on "Overview Fixed Income" tab
    And Verify for these "<tileNames>" tiles information is getting loaded or not on overview page
    
    Examples:
    |accountNumber  |tileNames																																																					|
    |758			|Credit Overweight By Industry,Credit Underweight By Issuer,Credit Underweight By Industry,Credit Overweight By Issuer,Fixed Income Sectors,Quality PIMCO													|
    
      @Regression @TC13 @Severity(Severitylevel.Normal)
  Scenario Outline: CFPortal_AO_OverviewEquity_PublishedBogie_Tiles_Verification
  /* */ Validate tile information is loaded or not for Overview Equity tab - Published Bogie for all account types*/
    Given The user navigate to application URL 
    Then Verify title as "Single Account Overview" after loading the URL
    And The user enters account number as "<accountNumber>" and click enter
    And Click on Pimco Bogie button
    And click on "Overview Equity" tab
    And Verify for these "<tileNames>" tiles information is getting loaded or not on overview page
    
    Examples:
    |accountNumber  |tileNames																			|
    |758			|Acct Info,Equity Sectors (Look Thru)												|
    
  @Regression @TC14 @Severity(Severitylevel.Normal)
  Scenario Outline: CFPortal_AO_ShareClassDetail_PublishedBogie_Tiles_Verification
  /* */ Validate tile information is loaded or not for Share Class Detail tab - Published Bogie for all account types*/
    Given The user navigate to application URL 
    Then Verify title as "Single Account Overview" after loading the URL
    And The user enters account number as "<accountNumber>" and click enter
    And Click on Pimco Bogie button
    And click on "Share Class Detail" tab
    And Verify for these "<tileNames>" tiles information is getting loaded or not on overview page
    
    Examples:
    |accountNumber  |tileNames																				|
    |758			|Fund Detail,Fund Info Grid,Daily Perf													|
    
  @Regression @TC15 @Severity(Severitylevel.Normal)
  Scenario Outline: CFPortal_AO_FundExternal_PublishedBogie_Tiles_Verification
  /* */ Validate tile information is loaded or not for Fund External tab - Published Bogie for all account types*/
    Given The user navigate to application URL 
    Then Verify title as "Single Account Overview" after loading the URL
    And The user enters account number as "<accountNumber>" and click enter
    And Click on Pimco Bogie button
    And click on "Fund External" tab
    And Verify for these "<tileNames>" tiles information is getting loaded or not on overview page
    
    Examples:
    |accountNumber  |tileNames																		|
    |758			|Fund Info,Performance,Maturity													|	
    
    
  @Regression @TC16 @Severity(Severitylevel.Normal)
  Scenario Outline: CFPortal_AO_Tile_Kangaroo_Navigation
  /* */ Validate excel is getting downloaded for Share Class Detail tab - Export excel tile kangaroo for all account types*/
    Given The user navigate to application URL 
    Then Verify title as "Single Account Overview" after loading the URL
    And The user enters account number as "<accountNumber>" and click enter
    And Click on Pimco Bogie button
    And click on "<tabName>" tab
    And click on tile "tileNames" export excel kangaroo
    And Verify file is downloaded successfully or not with extension "xlsx"
    
    Examples:
    |accountNumber  |tabName						|tileNames				| comments												|
    |758			|Share Class Detail				|Fund Detail			| we have to add tileno when it is implemented in Html	|
    
  @Regression @TC16_1 @Severity(Severitylevel.High)
  Scenario Outline: CFPortal_AO_Excel_Verification
  /* */ Validate excel is getting downloaded or not Export excel from tool bar*/
    Given The user navigate to application URL 
    Then Verify title as "Single Account Overview" after loading the URL
    And The user enters account number as "<accountNumber>" and click enter
    And click on export excel from toolbar
    And Verify file is downloaded successfully or not with extension "xlsx"
    
    Examples:
    |accountNumber  | comments												|
    |758			| we have to add tileno when it is implemented in Html	|
    
  @Regression @TC16_2 @Severity(Severitylevel.High)
  Scenario Outline: CFPortal_AO_AllDownloads_Verification
  /* */ Validate all files are downloading or not when we try to download with excel, pdf,ppt & docs icons from Export options*/
    Given The user navigate to application URL 
    Then Verify title as "Single Account Overview" after loading the URL
    And The user enters account number as "<accountNumber>" and click enter
    And click on "excel" icon from export options
    And Verify file is downloaded successfully or not with extension "xlsx"
    And click on "ppt" icon from export options
    And Verify file is downloaded successfully or not with extension "ppt"
    And click on "docx" icon from export options
    And Verify file is downloaded successfully or not with extension "docx"
    And click on "pdf" icon from export options
    And Verify pdf is loaded in a different browser tab with URL as "<URL>"
    
    Examples:
    |accountNumber  | comments												| URL														|
    |758			| we have to add tileno when it is implemented in Html	|http://cfportalwcfbeta/PimcoDataService.svc/Reports/pdf	|
    
    @Regression @TC17 @PROD @Severity(Severitylevel.High)
  Scenario: CFPortal_Client_Account_Overview_766_OverviewCredit_Validation
  /* */ Validate tile information is loaded or not for Oerview Credit tab for 766 account with Last business date as As of Date and B1*/
    Given The user navigate to application URL 
    Then Verify title as "Single Account Overview" after loading the URL
    And The user enters account number as "766" and click enter
    And click on "Overview Credit" tab
    And click on "B1" Bogie button
   #And verify with start date as "lastMonthBusinessday"
    And click on Run
    And Verify for these "Credit Overweight By Industry,Credit Overweight By Issuer,Credit Underweight By Industry,Credit Underweight By Issuer" tiles information is getting loaded or not on overview page 
  # And verify with start date as "lastYearBusinessday"
    And click on Run
    And Verify for these "Credit Overweight By Industry,Credit Overweight By Issuer,Credit Underweight By Industry,Credit Underweight By Issuer" tiles information is getting loaded or not on overview page
    
   @Regression @TC18 @PROD @Severity(Severitylevel.High)
  Scenario Outline: CFPortal_Client_Account_Overview_766_OverviewCredit_B2_Validation
    /* */ Validate tile information is loaded or not for Oerview Credit tab for 766 account with Last business date as As of Date and B2*/
    Given The user navigate to application URL 
    Then Verify title as "Single Account Overview" after loading the URL
    And The user enters account number as "<accountNumer>" and click enter
    And click on "Overview Credit" tab
    And click on "B1" Bogie button
    And Enter As Of Date as lastBusinessDay
    When click on Run
   # Then Verify url "<URL>" of the page for account number "<accountNumer>"
    And Verify for these "<tileNames>" tiles information is getting loaded or not on overview page
         
    Examples:
    |accountNumer|URL  																		|tileNames																												|
    |766		 |http://cfportalbeta/default.aspx#/singleaccounthtml/overviewcredit/ABR2	|Credit Overweight By Industry,Credit Overweight By Issuer,Credit Underweight By Industry,Credit Underweight By Issuer	| 
  	
  	  	
  	@Regression @TC20 @PROD @Severity(Severitylevel.High)
   Scenario: CFPortal_Client_Dashboard_Navigation_Account_Overview
  	/* */ Validate tile information is loaded or not for Bogie and Rel tab for account with Last business date as As of Date */
    Given The user navigate to application URL 
    Then Verify title as "Single Account Overview" after loading the URL
    And The user enters account number as "758" and click enter
    And Enter As Of Date as lastBusinessDay
    And click on Run
    When click on "Bogie" tab
 		Then Verify for these "Bogie Info,Accounts,Perf - Historical Annual,PIMCO Bogie Sectors Level 1" tiles are getting loaded or not on overview page
   	When click on "Rel" tab
  	Then Verify for these "Relation Info,Acct Info,Portfolio,Cash Flows (mm USD),Performance" tiles are getting loaded or not on overview page
         
    
    #  Validation for invalid account numbers  #
     @Regression @TC21 @PROD  @Severity(Severitylevel.High)
  	Scenario Outline: CFPortal_Client_Account_Overview_AccountSearch
  	/* */ Validate Negative scenarios for Accounts Number Search */
    Given The user navigate to application URL 
    Then Verify title as "Single Account Overview" after loading the URL
    And The user enters account number as "<accountNumber>" and click enter
    Then Verify the validation message "<validationMessage>" 
  	
  	Examples:
  	|accountNumber		| validationMessage   						|
  	|-1					|Account number not recognized as active.	|
  	|5260   			|Model account not processed.				|
  
  	@Regression @TC22 @PROD @Severity(Severitylevel.High)
  	Scenario Outline:: CFPortal_Client_Account_Overview_Bucket
  	/* */ Validate Bucket Columns Values in existing tiles for Overview tab*/
    Given The user navigate to application URL 
    Then Verify title as "Single Account Overview" after loading the URL
    And The user enters account number as "700" and click enter
    And Verify Bucket values "<bucketValuesDuration>" for "Duration PIMCO" tile
  	And Verify Bucket values "<bucketValuesMaturity>" for "Maturity PIMCO" tile
  	And Verify Bucket values "<bucketValuesQuality>" for "Quality PIMCO" tile
  	And Verify Bucket values "<bucketValuesSectorLevel>" for "Sector Level1 PIMCO" tile
         
    Examples:
    |bucketValuesDuration 																																				|bucketValuesMaturity																	|bucketValuesSectorLevel																																																								|bucketValuesQuality									|
    |0-1 yrs,1-3 yrs,3-5 yrs,5-7 yrs,7-8 yrs,8-10 yrs,10-15 yrs,15-20 yrs,20-25 yrs,25-30 yrs,30+ yrs|0-1 yrs,1-3 yrs,3-5 yrs,5-10 yrs,10-20 yrs,20+ yrs|US Government Related,Securitized,Invest. Grade Credit,High Yield Credit,Non-USD Developed,Emerging Markets,Other,Net Other Short Duration Instruments|A1/P1,Below A1/P1,AAA,AA,A,BAA,BB,B,Below B|	
  
  	@Regression @TC23 @PROD @Severity(Severitylevel.High)
  	Scenario Outline: CFPortal_Client_Account_Overview_BogieOverview_Open  
  	/* */ Validate tile information is loaded or not for Bogie tab for 601 account with Last business date as As of Date*/
  	Given The user navigate to application URL
  	Then Verify title as "Single Account Overview" after loading the URL
		And The user enters account number as "601" and click enter
	  And Enter As Of Date as lastBusinessDay
		And Select the Mode as "Reported (Partial)" and Click on Run button
		When click on "Bogie" tab 
		Then Verify the Bogie Overview Open page and validate "<tileNames>" tiles details
		
	Examples:
	|tileNames																	| 
	|Bogie Info,Accounts,Perf - Historical Annual,PIMCO Bogie Sectors Level 1	|
  	
#  	@Regression @TC24
#  Scenario: Validate avg Quality functionality working fine or not
#    Given The user navigate to application URL 
#    Then Verify title as "Single Account Overview" after loading the URL
#    And The user enters account number as "766" and click enter
#    And double click on "Avg Quality" from Risk Stat tile section

 @Regression @TC25 @PROD @Severity(Severitylevel.High)
  Scenario: CFportal_Client_Account_Overview_AccntValuesDur_Mat_RegSec_Qual
  /* */ Verify and compare Duration DWE values in tiles and verify aggregate values displayign in tiles */
    Given The user navigate to application URL 
    Then Verify title as "Single Account Overview" after loading the URL
    And The user enters account number as "771" and click enter
    And Verify for these "Duration PIMCO,Quality PIMCO,Regional Sectors (by Issuer) PIMCO,Maturity PIMCO" tiles information is getting loaded or not on overview page
    And Verify and Capture Account DWE Value, Bogie DWE and Var DWE Value
	And Verify Account,Bogie and Var DWE values in these "Duration PIMCO,Quality PIMCO,Regional Sectors (by Issuer) PIMCO" tiles 
	And Verify Aggregate values in these "Duration PIMCO,Quality PIMCO,Regional Sectors (by Issuer) PIMCO,Maturity PIMCO" tiles
	And Click on Pimco Bogie button
	And Verify and Capture Account DWE Value, Bogie DWE and Var DWE Value
	And Verify Account,Bogie and Var DWE values in these "Duration Published,Quality Published,Regional Sectors (by Issuer) Published" tiles 
	And Verify Aggregate values in these "Duration Published,Quality Published,Regional Sectors (by Issuer) Published,Maturity Published" tiles
  	
  @Regression @TC26 @PROD @Severity(Severitylevel.High)
  Scenario Outline: CFPortal_Client_Account_Overview_Grids
  	/* */ To validate the tile details of the Overview tab.  */
    Given The user navigate to application URL 
    Then Verify title as "Single Account Overview" after loading the URL
    And The user enters account number as "700" and click enter
    And Verify for these "<tileNames>" tiles information is getting loaded or not on overview page
    
   Examples:
    |tileNames	|
    |Acct Info PIMCO,Duration PIMCO,Maturity PIMCO,Perf - Daily,Perf - Month End,Perf - Historical Annual,Sector Level1 PIMCO,Regional Sectors (by Currency) PIMCO,Quality PIMCO	|	
  
  @Regression @TC27 @PROD @Severity(Severitylevel.High)
  Scenario: CFPortal_Client_Account_Overview_Account_BogieValueinBogieOverviewpage
  	/* */ To validate the tile details of the Overview tab.  */
    Given The user navigate to application URL 
    Then Verify title as "Single Account Overview" after loading the URL
    And The user enters account number as "700" and click enter
   And Enter As Of Date as lastBusinessDay
    And The user enters account number as "601" and click enter
		And Select the Mode as "Reported (Partial)" and Click on Run button
    When click on "Bogie" tab
    #Then Verify the values on the Bogie Overview page
    
    @Regression @TC28 @PROD @Severity(Severitylevel.High)
  Scenario: CFportal_Client_Account_Overview_AccntValuesDur_Mat_RegSec_Qual
  /* */ Verify and compare Duration DWE values in tiles and verify aggregate values displayign in tiles */
    Given The user navigate to application URL 
    Then Verify title as "Single Account Overview" after loading the URL
    And The user enters account number as "771" and click enter
    And Enter As Of Date as lastBusinessDay
    And click on Run
    And Verify for these "Duration PIMCO,Quality PIMCO,Regional Sectors (by Issuer) PIMCO,Maturity PIMCO" tiles information is getting loaded or not on overview page
    And Verify and Capture Account DWE Value, Bogie DWE and Var DWE Value
		And Verify Account,Bogie and Var DWE values in these "Duration PIMCO,Quality PIMCO,Regional Sectors (by Issuer) PIMCO" tiles 
	  And Verify Aggregate values in these "Duration PIMCO,Quality PIMCO,Regional Sectors (by Issuer) PIMCO,Maturity PIMCO" tiles
	 	And Click on Pimco Bogie button
	  And Verify and Capture Account DWE Value, Bogie DWE and Var DWE Value
	 	And Verify Account,Bogie and Var DWE values in these "Duration Published,Quality Published,Regional Sectors (by Issuer) Published" tiles 
		And Verify Aggregate values in these "Duration Published,Quality Published,Regional Sectors (by Issuer) Published,Maturity Published" tiles
      
 
       
 
 @Regression @TC29 @PROD @Severity(Severitylevel.High)
  Scenario Outline: CFportal_Client_Account_Overview_AccntValuesDur_Mat_Sec_RegSec_Qual_MulBogies
  /* */ Verify and compare Duration DWE values in tiles and verify aggregate values displayign in tiles for B1 and B2 Bogie
   */
    Given The user navigate to application URL 
    Then Verify title as "Single Account Overview" after loading the URL
    And The user enters account number as "<accountNumber>" and click enter
    When Enter As Of Date as lastBusinessDay
    And click on Run
    And Verify for these "<tileNames>" tiles information is getting loaded or not on overview page
    And Verify the Mode as "Reported (Direct)"
    And Verify and Capture Account DWE Value, Bogie DWE and Var DWE Value
  	And Verify Account,Bogie and Var DWE values in these "<tileNames>" tiles 
    And Verify Aggregate values in these "<tileNames>" tiles
  	And Click on Pimco Bogie button
    And Verify and Capture Account DWE Value, Bogie DWE and Var DWE Value
    And Verify Aggregate values in these "<tileNamesPublishedBogie>" tiles
    And click on "B1" Bogie button
    And click on Run
    And Verify for these "<tileNamesPublishedBogie>" tiles information is getting loaded or not on overview page
    And Verify the Mode as "Reported (Direct)"
    And Click on Published Bogie button
    And Verify and Capture Account DWE Value, Bogie DWE and Var DWE Value
   	And Verify Account,Bogie and Var DWE values in these "<tileNames>" tiles 
    And Verify Aggregate values in these "<tileNames>" tiles
  
  Examples:
    |accountNumber  |tileNames	|tileNamesPublishedBogie|
    |775			|Duration PIMCO,Quality PIMCO,Regional Sectors (by Currency) PIMCO,Maturity PIMCO,Sector Level1 PIMCO|Duration Published,Quality Published,Regional Sectors (by Currency) Published,Sector Level1 Published,Maturity Published|    	
    |703			|Duration PIMCO,Quality PIMCO,Regional Sectors (by Currency) PIMCO,Maturity PIMCO,Sector Level1 PIMCO|Duration Published,Quality Published,Regional Sectors (by Currency) Published,Sector Level1 Published,Maturity Published|
    
   @Regression @TC30 @PROD @Severity(Severitylevel.High)
  Scenario Outline: CFportal_Client_Account_Overview_AccntValuesDur_EqSec_Top10hld_Reg_GICSSec
  /* */ Verify and compare Duration DWE values in tiles and verify aggregate values displayign in tiles for B1 and B2 Bogie*/
    Given The user navigate to application URL 
    Then Verify title as "Single Account Overview" after loading the URL
    And The user enters account number as "<accountNumber>" and click enter
    When Enter As Of Date as lastBusinessDay
    And click on Run
    And Verify for these "<tileNames>" tiles information is getting loaded or not on overview page
    And Verify the Mode as "Reported (Direct)"
    And Verify these values "Partial,Lookthru" are disabled in Mode
    And Verify Aggregate values in these "Portfolio Composition,Region (by Issuer)" tiles
  	And Click on Pimco Bogie button
    And Verify Aggregate values in these "Portfolio Composition,Region (by Issuer)" tiles
 		
  Examples:
    |accountNumber  |tileNames	|
    |4122 	|Acct Info,Perf - Historical Annual,Portfolio Composition,Perf - Daily,Perf - Month End,Top 10 Holdings,Region (by Issuer),GICS sectors|
    
    
  	@Regression @TC31 @PROD   @Severity(Severitylevel.High)
    Scenario Outline: CFPORTAL_Client_Account_Overview_ExpandGridTile
    Given The user navigate to application URL
    Then Verify title as "Single Account Overview" after loading the URL
    When  The user enters account number as "<accountNumber>" and click enter
    And The user clicks on the expand icon for the "Duration PIMCO" tile
    Then Verify "Duration PIMCO" tile gets expanded.
  
      Examples:
    |accountNumber  |tileNames																																																					|
     |700			|Acct Info PIMCO,Duration PIMCO,Maturity PIMCO,Perf - Daily,Perf - Month End,Perf - Historical Annual,Sector Level1 PIMCO,Regional Sectors (by Currency) PIMCO,Quality PIMCO									|
     
   @Regression @TC32 @PROD @Severity(Severitylevel.High)
  Scenario Outline: CFportal_Client_Account_Overview_GridNamesinPublishedandPimcoMode
  /* */ Validate tile information is loaded or not for Overview tab - PIMCO and  Published Bogie for all account types */
    Given The user navigate to application URL 
    Then Verify title as "Single Account Overview" after loading the URL
    And The user enters account number as "<accountNumber>" and click enter
    When Enter As Of Date as lastBusinessDay
    And Verify for these "<tileNames>" tiles information is getting loaded or not on overview page
    And Click on Pimco Bogie button
    And Verify for these "<tileNamesForPublished>" tiles information is getting loaded or not on overview page
    
    Examples:
    |accountNumber  |tileNames|tileNamesForPublished																																																					|
    |700			|Acct Info PIMCO,Duration PIMCO,Maturity PIMCO,Perf - Daily,Perf - Month End,Perf - Historical Annual,Sector Level1 PIMCO,Regional Sectors (by Currency) PIMCO,Quality PIMCO|Acct Info Published,Duration Published,Maturity Published,Perf - Daily,Perf - Month End,Perf - Historical Annual,Sector Level1 Published,Regional Sectors (by Currency) Published,Quality Published|
    |703			|Acct Info PIMCO,Duration PIMCO,Maturity PIMCO,Perf - Daily,Perf - Month End,Perf - Historical Annual,Sector Level1 PIMCO,Regional Sectors (by Currency) PIMCO,Quality PIMCO|Acct Info Published,Duration Published,Maturity Published,Perf - Daily,Perf - Month End,Perf - Historical Annual,Sector Level1 Published,Regional Sectors (by Currency) Published,Quality Published|
    
    
    	@Regression @TC33 @PROD @Severity(Severitylevel.High) @Navigation
   Scenario: CFPortal_Client_Dashboard_Account_ClientOverview_VerifyExportTravelBook
  	/* */ Validate */
    Given The user navigate to application URL 
    Then Verify title as "Single Account Overview" after loading the URL
    And The user enters account number as "36" and click enter
    And Enter As Of Date as lastBusinessDay
    And click on Run
    When click on "Rel" tab
  	Then Verify for these "Relation Info,Acct Info,Portfolio,Cash Flows (mm USD),Performance" tiles are getting loaded or not on overview page
  	When click on Export Relationship Travel Book 
  	Then Verify these details "5049791   Reynolds American   Relationship" are displaying in Travel Book
  	Then Verify these details "36 Reynolds American Defined Benefit Master Trust,6736 Reynolds Overlay,6836 Reynolds Parent" are displaying in Separate Account section
  	Then Verify these details "700 PIMCO Total Return Fund,720 PIMCO Low Duration Fund,766 PIMCO Income Fund" are displaying in Fund Investment section
  	Then click on OK button
  	And Verify pdf is loaded in a different browser tab with URL as "http://cfportalwcfbeta/PimcoDataService.svc/cfreport?$filter=REPORT_KEY"

	@Regression @TC34 @PROD @Severity(Severitylevel.High) @Navigation
   Scenario Outline: CFPortal_Client_Account_Overview_tabs_OverviewCredit_OverviewCountry
  	  /* */ Validate tile information is loaded or not for Overview Country/Overview Country tab - Published Bogie for all account types*/
    Given The user navigate to application URL 
    Then Verify title as "Single Account Overview" after loading the URL
    And The user enters account number as "<accountNumber>" and click enter
    And Enter As Of Date as lastBusinessDay
   	And Select the Mode as "Lookthru"
   	And click on Run
    And Click on Pimco Bogie button
    And Verify and Capture Account DWE Value, Bogie DWE and Var DWE Value
    And click on "Overview Credit" tab
    Then Verify Number of Rows for these "<tileNamesOverviewCredit>" tiles
    And Verify for these "<tileNamesOverviewCredit>" tiles information is getting loaded or not on overview page
    And Verify the Mode as "Lookthru"
  	And Verify this "<accountNumber>" in AccountNumber field
  	And Verify As Of Date field exists
  	And Verify Run button exists
  	And Verify Published Bogie button is displayed
    And click on "Overview Country" tab
    Then Verify Number of Rows for these "<tileNamesOverviewCountry>" tiles
    And Verify for these "<tileNamesOverviewCountry>" tiles information is getting loaded or not on overview page
    And Verify Account,Bogie and Var DWE values in these "Country (by Issuer)" tiles  
    
    
    Examples:
    |accountNumber  |tileNamesOverviewCountry						|tileNamesOverviewCredit 			 |
    |12							|Country (by Currency),Country (by Issuer)	|Credit Overweight By Industry,Credit Overweight By Issuer,Credit Underweight By Industry,Credit Underweight By Issuer| 
  	
  @Regression @TC35 @PROD @Severity(Severitylevel.High)
  Scenario Outline: CFPortal_Client_Account_Overview_Account_7298
  /* */ Verify and compare Duration DWE values in tiles and verify aggregate values displayign in tiles for B1 and B2 Bogie
   */
    Given The user navigate to application URL 
    Then Verify title as "Single Account Overview" after loading the URL
    And The user enters account number as "<accountNumber>" and click enter
    When Enter As Of Date as lastBusinessDay
    And click on Run
    And Verify for these "<tileNames>" tiles information is getting loaded or not on overview page
    And Verify the Mode as "Reported (Direct)"
    And Verify and Capture Account DWE Value, Bogie DWE and Var DWE Value
  	And Verify Account,Bogie and Var DWE values in these "<tileNames>" tiles 
    And Verify Aggregate values in these "<tileNames>" tiles
  	And Click on Pimco Bogie button
    And Verify and Capture Account DWE Value, Bogie DWE and Var DWE Value
    And Verify Aggregate values in these "<tileNamesPublishedBogie>" tiles
   
  
  Examples:
    |accountNumber  |tileNames	|tileNamesPublishedBogie|
    |7298			|Duration PIMCO,Sector Level1 PIMCO CEF,Quality PIMCO,Regional Sectors (by Currency) PIMCO,|Duration Published,Quality Published,Regional Sectors (by Currency) Published,Sector Level1 Published CEF|
    
    @Regression @TC36 @PROD @Severity(Severitylevel.High)
  Scenario Outline: CFPortal_Client_Account_Overview_AccntValuesAllcReg_AssClass_Currency
  /* */ Verify Allocation by Region  and Asset Class Tiles
   */
    Given The user navigate to application URL 
    Then Verify title as "Single Account Overview" after loading the URL
    And The user enters account number as "<accountNumber>" and click enter
    When Enter As Of Date as lastBusinessDay
    And click on Run
    And Select the Mode as "Reported (Lookthru)"
    And Verify for these "<tileNames>" tiles information is getting loaded or not on overview page
 
Examples:
    |accountNumber  |tileNames	|
    |736			|Asset Class Allocation,Allocation by Region (Look Thru),Currency Allocation by Region (Look Thru)|
    
   @Regression @TC37 @PROD @Severity(Severitylevel.High)
  Scenario Outline: CFPortal_Client_Account_Overview_Account_LookThru
  /* */ Verify and compare Duration DWE values in tiles and verify aggregate values displayign in tiles for B1 and B2 Bogie and all Mode-Direct/Reported(Partial)/Lookthru
   */
    Given The user navigate to application URL 
    Then Verify title as "Single Account Overview" after loading the URL
    And The user enters account number as "<accountNumber>" and click enter
    When Enter As Of Date as lastBusinessDay
    And click on Run
    And Verify for these "<tileNames>" tiles information is getting loaded or not on overview page
    And Verify the Mode as "Direct"
    And Verify and Capture Account DWE Value, Bogie DWE and Var DWE Value
  	And Verify Account,Bogie and Var DWE values in these "<tileNames>" tiles 
    And Verify Aggregate values in these "<tileNames>" tiles
  	And Click on Pimco Bogie button
    And Verify and Capture Account DWE Value, Bogie DWE and Var DWE Value
    And Verify Aggregate values in these "<tileNamesPublishedBogie>" tiles
    And Select the Mode as "Reported (Partial)" and Click on Run button
    And Verify and Capture Account DWE Value, Bogie DWE and Var DWE Value
    And Verify Aggregate values in these "<tileNamesPublishedBogie>" tiles
    And Click on Published Bogie button
    And Verify and Capture Account DWE Value, Bogie DWE and Var DWE Value
   	And Verify Account,Bogie and Var DWE values in these "<tileNames>" tiles 
    And Verify Aggregate values in these "<tileNames>" tiles
    And Select the Mode as "Lookthru" and Click on Run button
    And Verify and Capture Account DWE Value, Bogie DWE and Var DWE Value
  	And Verify Account,Bogie and Var DWE values in these "<tileNames>" tiles 
    And Verify Aggregate values in these "<tileNames>" tiles
  	And Click on Pimco Bogie button
    And Verify and Capture Account DWE Value, Bogie DWE and Var DWE Value
    And Verify Aggregate values in these "<tileNamesPublishedBogie>" tiles
  
  Examples:
    |accountNumber  |tileNames	|tileNamesPublishedBogie|
    |601			|Duration PIMCO,Quality PIMCO,Regional Sectors (by Currency) PIMCO,Maturity PIMCO,Sector Level1 PIMCO|Duration Published,Quality Published,Regional Sectors (by Currency) Published,Sector Level1 Published,Maturity Published|         
    
    @Regression @TC38 @PROD @Severity(Severitylevel.High) @Navigation
   Scenario Outline: CFPortal_Client_Account_Overview_PerfDaily_PerfMonthly_DataValidation
  	  /* */ Validate data shoudl be present in Perf Daily and Perf Month End tile */
    Given The user navigate to application URL 
    Then Verify title as "Single Account Overview" after loading the URL
    And The user enters account number as "<accountNumber>" and click enter
    And Enter As Of Date as lastBusinessDay
   	And click on Run
    Then Verify Data present in "Perf - Daily,Perf - Month End" tile
        
    Examples:
    |accountNumber  |
   |700 |
   |12|
   
   @Regression @TC39 @PROD @Severity(Severitylevel.High)
  Scenario: CFPortal_Client_Account_Overview_AmtMKTValueAndAsofDateForAccount
  /* */ Verify the As Of Date and Amount Market Value date are same   */
    Given The user navigate to application URL 
    Then Verify title as "Single Account Overview" after loading the URL
    And The user enters account number as "700" and click enter
    When Enter As Of Date as lastBusinessDay
    And click on Run
    And Capture the AsOfDate and Verify with the Calender Date
    
    
   