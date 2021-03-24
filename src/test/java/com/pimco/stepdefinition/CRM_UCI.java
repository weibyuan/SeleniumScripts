package com.pimco.stepdefinition;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.IOCase;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.FileFileFilter;
import org.apache.commons.io.filefilter.PrefixFileFilter;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.collections.Lists;

import com.automation.AutomationLibrary.ui.BrowserLibrary;
import com.automation.AutomationLibrary.ui.ElementLibrary;
import com.automation.AutomationLibrary.ui.WebdriverService;
import com.automation.AutomationLibrary.ui.config.IdentifyBy;
import com.automation.AutomationLibrary.ui.config.UIElement;
import com.gargoylesoftware.htmlunit.javascript.host.intl.NumberFormat;
import com.pimco.runner.BaseRunner;
import com.pimco.util.EnvironmentConfig;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Keys;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.text.DecimalFormat;

/**
 * @author Gordon
 * @author Oscar
 */

public class CRM_UCI extends BaseRunner {

	public UIElement OKButton = new UIElement("OKButton", IdentifyBy.XPATH, "//button[@data-id='ok_id']");
	public UIElement serviceNowButton = new UIElement("serviceNowButton", IdentifyBy.XPATH,
			"//button[@data-id='cs.ApplicationRibbon.ServiceNow.Button]");
	public UIElement areaSwichButton = new UIElement("areaSwichButton", IdentifyBy.XPATH,
			"//button[@id='areaSwitcherId']");
	public UIElement newMarketingListButton = new UIElement("newMarketingListButton", IdentifyBy.XPATH,
			"//span[text()='New']");
	public UIElement taskPrimaryContactSelected = new UIElement("taskPrimaryContactSelected", IdentifyBy.XPATH,
			"//div[@data-id='cs_primarycontactid.fieldControl-LookupResultsDropdown_cs_primarycontactid_selected_tag_text']");
	public UIElement inputFiled = new UIElement("inputFiled", IdentifyBy.XPATH, "//input[@id='i0116']");
	public UIElement nextButton = new UIElement("nextButton", IdentifyBy.XPATH, "//input[@type='submit']");
	public UIElement navigateArrow = new UIElement("navigateArrow", IdentifyBy.ID, "TabArrowDivider");
	public UIElement exportToExcelButton = new UIElement("exportToExcelButton", IdentifyBy.XPATH,
			"//span[text()='Export to Excel']");
	public UIElement relationshipSearchFlied = new UIElement("relationshipSearchFlied", IdentifyBy.XPATH,
			"//input[@placeholder='Search this view']");
	public UIElement relationshipSearchButton = new UIElement("relationshipSearchButton", IdentifyBy.XPATH,
			"//button[@title='Start search']");
	public UIElement relationshipName = new UIElement("relationshipName", IdentifyBy.XPATH,
			"//div[@title='BOK Financial']");
	public UIElement addActivity = new UIElement("addActivity", IdentifyBy.XPATH, "//span[text()='Add Activity']");
	public UIElement clientAssets = new UIElement("clientAssets", IdentifyBy.XPATH, "//span[text()='Client Assets']");
	public UIElement siteMap = new UIElement("siteMap", IdentifyBy.XPATH,
			"//span[@class='symbolFont SiteMap-symbol ']");
	public UIElement myContacts = new UIElement("myContacts", IdentifyBy.XPATH, "//span[text()='My Contacts']");
	public UIElement myLeadAccounts = new UIElement("myLeadAccounts", IdentifyBy.XPATH,
			"//span[text()='My Lead Accounts']");
	public UIElement myDashboard = new UIElement("myDashboard", IdentifyBy.XPATH, "//span[text()='My Dashboard']");
	public UIElement IframeActivityManagerPage = new UIElement("search", IdentifyBy.XPATH,
			"//iframe[@id='FullPageWebResource']");
	public UIElement allOpportunities = new UIElement("allOpportunities", IdentifyBy.XPATH,
			"//span[tex()='All Opportunities - Inst']");
	public UIElement myLeadBuyingUnits = new UIElement("myLeadBuyingUnits", IdentifyBy.XPATH,
			"//span[tex()='My Lead Buying Units']");
	public UIElement relatedOthers = new UIElement("search", IdentifyBy.XPATH, "//span[text()='Related - Others']");
	public UIElement reasonToCall = new UIElement("reasonToCall", IdentifyBy.XPATH, "//span[text()='Reasons to Call']");
	public UIElement engagementHub = new UIElement("engagementHub", IdentifyBy.XPATH,
			"(//div[text()='All My Contacts'])[1]");
	public UIElement newNationalFirmButton = new UIElement("newNationalFirmButton", IdentifyBy.XPATH,
			"//span[text()='New National Firm']");
	public UIElement relationshipNameInput = new UIElement("relationshipNameInput", IdentifyBy.ID, "relationshipName");
	public UIElement MDMSearchButton = new UIElement("MDMSearchButton", IdentifyBy.XPATH,
			"//button[contains(text(),'Search')]");
	public UIElement MDMCreateButton = new UIElement("MDMCreateButton", IdentifyBy.XPATH,
			"//button[@id='btn-contact-create']");
	public UIElement street1InputBox = new UIElement("street1InputBox", IdentifyBy.XPATH,
			"//input[@data-id='address1_line1.fieldControl-text-box-text']");
	public UIElement street2InputBox = new UIElement("street2InputBox", IdentifyBy.XPATH,
			"//input[@data-id='address1_line2.fieldControl-text-box-text']");
	public UIElement street3InputBox = new UIElement("street3InputBox", IdentifyBy.XPATH,
			"//input[@data-id='address1_line3.fieldControl-text-box-text']");
	public UIElement cityInputBox = new UIElement("cityInputBox", IdentifyBy.XPATH,
			"//input[@data-id='address1_city.fieldControl-text-box-text']");
	public UIElement countryInputBox = new UIElement("countryInputBox", IdentifyBy.XPATH,
			"//input[@data-id='cs_address1_countryid.fieldControl-LookupResultsDropdown_cs_address1_countryid_textInputBox_with_filter_new']");
	public UIElement stateInputBox = new UIElement("stateInputBox", IdentifyBy.XPATH,
			"//input[@data-id='cs_address1_regionid.fieldControl-LookupResultsDropdown_cs_address1_regionid_textInputBox_with_filter_new']");
	public UIElement zipcodeInputBox = new UIElement("zipcodeInputBox", IdentifyBy.XPATH,
			"//input[@data-id='address1_postalcode.fieldControl-text-box-text']");
	public UIElement saveButton = new UIElement("zipcodeInputBox", IdentifyBy.XPATH, "//span[text()='Save']");
	public UIElement relationshipField = new UIElement("relationshipField", IdentifyBy.XPATH,
			"//input[@data-id='name.fieldControl-text-box-text']");
	public UIElement officialNameField = new UIElement("officialNameField", IdentifyBy.XPATH,
			"//input[@data-id='cs_companyname.fieldControl-text-box-text']");
	public UIElement detailTab = new UIElement("detailTab", IdentifyBy.XPATH, "//li[@data-id='tablist-DETAILS_TAB']");
	public UIElement taskButton = new UIElement("taskButton", IdentifyBy.XPATH, "//span[text()='Task']");
	public UIElement taskSubjectInputBox = new UIElement("taskSubjectInputBox", IdentifyBy.XPATH,
			"//input[@data-id='subject.fieldControl-text-box-text']");
	public UIElement taskDueDate = new UIElement("taskDueDate", IdentifyBy.XPATH,
			"//input[@aria-label='Date of Due Date']");
	// new UIElement("taskDueDate", IdentifyBy.XPATH,
	// "//input[@data-id='scheduledend.fieldControl-date-time-input']");
	public UIElement taskDueTime = new UIElement("taskDueTime", IdentifyBy.ID, "scheduledend_fabric_combobox-input");
	public UIElement taskSaveCloseButton = new UIElement("taskSaveCloseButton", IdentifyBy.XPATH,
			"//span[text()='Save and Close']");
	public UIElement recentDropList = new UIElement("recentDropList", IdentifyBy.XPATH, "//span[text()='Recent']");
	public UIElement advanceFindButton = new UIElement("advanceFindButton", IdentifyBy.XPATH,
			"//button[@data-id='advancedFindLauncher']");
	public UIElement recentActivitySearch = new UIElement("recentActivitySearch", IdentifyBy.XPATH,
			"//input[@id='timeline_search_keyword_input']");
	public UIElement openRecordButton = new UIElement("openRecordButton", IdentifyBy.XPATH,
			"//span[@class='symbolFont OpenEntityRecord-symbol ']");
	public UIElement firstNameOnAdvancedSearch = new UIElement("contactTabOnAdvancedSearch", IdentifyBy.XPATH,
			"//li[@class='ui-state-default ui-corner-top ui-tabs-active ui-state-active ui-sortable-handle']");
	public UIElement viewListForOnVulnerabilities = new UIElement("viewListForOnVulnerabilities", IdentifyBy.XPATH,
			"//label[text()='View List For: ']");
	public UIElement taskDurationInputBox = new UIElement("taskDurationInputBox", IdentifyBy.XPATH,
			"//input[@data-id='actualdurationminutes.fieldControl-duration-combobox-text']");
	public UIElement taskDescriptionInputBox = new UIElement("taskDescriptionInputBox", IdentifyBy.XPATH,
			"//textarea[@data-id='description.fieldControl-text-box-text']");
	public UIElement taskPrimaryContactInputBox = new UIElement("taskPrimaryContactInputBox", IdentifyBy.XPATH,
			"//input[@data-id='cs_primarycontactid.fieldControl-LookupResultsDropdown_cs_primarycontactid_textInputBox_with_filter_new']");
	public UIElement okButton = new UIElement("okButton", IdentifyBy.XPATH, "//button[@id='okButton']");
	public UIElement meetingButton = new UIElement("meetingButton", IdentifyBy.XPATH, "//span[text()='Meeting']");
	public UIElement inputFieldForPrimaryAttendee = new UIElement("inputFieldForPrimaryAttendee", IdentifyBy.XPATH,
			("//input[@data-id='cs_primarycontact.fieldControl-LookupResultsDropdown_cs_primarycontact_textInputBox_with_filter_new']"));
	public UIElement stateInput1Box = new UIElement("stateInput1Box", IdentifyBy.XPATH,
			"//input[@data-id='address1_stateorprovince.fieldControl-text-box-text']");
	private String newRelationshipName;
	private String newTaskSubject;
	private String newMeetingSubject;
	public ElementLibrary elementLibrary = getElementLibrary();
	private BrowserLibrary browserLibrary = getBrowserLibrary();
	private final static Logger log = Logger.getLogger(CRM_UCI.class.getName());
	WebDriver driver = getWebDriverService().getWebDriver();
	public UIElement phoneCallButton = new UIElement("taskButton", IdentifyBy.XPATH, "//span[text()='Phone Call']");
	public UIElement newPhoneCall = new UIElement("newPhoneCall", IdentifyBy.XPATH, "//h1[@title='New Phone Call']");
	public UIElement phoneCallSubjectLabel = new UIElement("phoneCallSubjectLabel", IdentifyBy.XPATH,
			"//input[@data-id='subject.fieldControl-text-box-text']");
	private WebdriverService webdriverServiceLibrary = getWebDriverService();
	private String newPhoneCallSubject;
	public UIElement whoAmITalkingTo = new UIElement("whoAmITalkingTo", IdentifyBy.XPATH,
			"//select[@aria-label='Who am I talking to?' and @data-id='cs_contacttypecode.fieldControl-option-set-select']");
	public UIElement phoneCallSaveButton = new UIElement("phoneCallSaveButton", IdentifyBy.XPATH,
			"//button[@aria-label='Save']");
	private String phoneCallNameA;
	private String phoneCallNameValue;
//	public UIElement addOpportunity = new UIElement("addOpportunity", IdentifyBy.XPATH,
//			"//li[@aria-label='Add Opportunity']");
	public UIElement addOpportunity = new UIElement("addOpportunity", IdentifyBy.XPATH,
			"//li[@title='Add Opportunity']");

	public UIElement newInstOpportunityLabel = new UIElement("newInstOpportunityLabel", IdentifyBy.XPATH,
			"//h1[text()='New Opportunity']");
	public UIElement instOpportunityName = new UIElement("instOpportunityName", IdentifyBy.XPATH,
			"//input[@aria-label='Opportunity Name']");
	private String instOppNameA;
	private String instOppNameValue;
	private String instOppNameValueA;
	private String instOppNameValueB;
	private String newRetailOpporName;
	private UIElement consultingfirmOcioInvolvement = new UIElement("consultingfirmOcioInvolvement", IdentifyBy.XPATH,
			"//select[@aria-label='Consulting Firm / OCIO  Involvement' and @data-id='cs_consultingfirminvolvement.fieldControl-option-set-select']");
	private UIElement investmentPool = new UIElement("investmentPool", IdentifyBy.XPATH,
			"//input[@data-id='cs_assetpoolid.fieldControl-LookupResultsDropdown_cs_assetpoolid_textInputBox_with_filter_new' and @aria-label='Investment Pool, Lookup']");
	private UIElement investmentPoolSearch = new UIElement("investmentPoolSearch", IdentifyBy.XPATH,
			"//button[@aria-label='Search all records' and @data-id='cs_assetpoolid.fieldControl-LookupResultsDropdown_cs_assetpoolid_search']");
	// private UIElement instOppSaveButton = new UIElement("instOppSaveButton",
	// IdentifyBy.XPATH,
	// "//li[@id='opportunity|NoRelationship|Form|Mscrm.SavePrimary03' and
	// @aria-label='Save']");
	private UIElement instOppSaveButton = new UIElement("instOppSaveButton", IdentifyBy.XPATH,
			"//button[@data-id='opportunity|NoRelationship|Form|Mscrm.Form.opportunity.Save']");
	private UIElement instOppTitleName = new UIElement("instOppTitleName", IdentifyBy.XPATH,
			"//h1[@data-id='header_title']");
//	private UIElement addInstOpportunity = new UIElement("addInstOpportunity", IdentifyBy.XPATH,
//			"//li[@aria-label='Add Institutional Opportunity']");
	private UIElement addInstOpportunity = new UIElement("addInstOpportunity", IdentifyBy.XPATH,
			"//li[@title='Add Institutional Opportunity']");
	public UIElement phoneCallNameOnTop = new UIElement("phoneCallNameOnTop", IdentifyBy.ID, "formHeaderTitle_0");
	private String phoneCallNameTest;
	private UIElement strategyProduct = new UIElement("strategyProduct", IdentifyBy.XPATH,
			"//input[@data-id='cs_productreferenceid.fieldControl-LookupResultsDropdown_cs_productreferenceid_textInputBox_with_filter_new']");
	private UIElement estCloseDate = new UIElement("estCloseDate", IdentifyBy.XPATH,
			"//input[@aria-label='Date of Est. Close Date']");
	// new UIElement("estCloseDate", IdentifyBy.XPATH, "//input[@aria-label='Est.
	// Close Date']");
	private UIElement estSize = new UIElement("estSize", IdentifyBy.XPATH,
			"//input[@data-id='estimatedvalue.fieldControl-currency-text-input']");
	private UIElement descriptionField = new UIElement("descriptionField", IdentifyBy.XPATH,
			"//textarea[@data-id='description.fieldControl-text-box-text']");
	private UIElement strategyProductContect = new UIElement("strategyProductContect", IdentifyBy.XPATH,
			"//div[@data-id='cs_productreferenceid.fieldControl-LookupResultsDropdown_cs_productreferenceid_selected_tag_text']");
	private UIElement investmentPoolContect = new UIElement("investmentPoolContect ", IdentifyBy.XPATH,
			"//div[@data-id='cs_assetpoolid.fieldControl-LookupResultsDropdown_cs_assetpoolid_selected_tag_text']");
	private UIElement relevanceSearchNew = new UIElement("relevanceSearchNew", IdentifyBy.XPATH,
			"//input[@title='Search']");
	private UIElement fullNameForContact = new UIElement("fullNameForContact", IdentifyBy.XPATH,
			"//span[text()='Barb Larson']");
	private UIElement fullNameForOtherContact = new UIElement("fullNameForOtherContact", IdentifyBy.XPATH,
			"//span[text()='Cameron Retif']");
	private UIElement fullNameForRelationship = new UIElement("fullNameForRelationship", IdentifyBy.XPATH,
			"//span[text()='3M Company']");
	private UIElement fullNameForInstOpportunity = new UIElement("fullNameForInstOpportunity", IdentifyBy.XPATH,
			"//span[text()='Tail Risk Hedging Opp']");
	private UIElement fullNameForRetailOpportunity = new UIElement("fullNameForRetailOpportunity", IdentifyBy.XPATH,
			"//span[text()='USD Mandates']");
	private UIElement fullNameForRelationshipRecord = new UIElement("fullNameForRelationshipRecord ", IdentifyBy.XPATH,
			"//span[text()='Microsoft Corporation']");
	public UIElement subjectFieldForMeeting = new UIElement("subjectFieldForMeeting", IdentifyBy.XPATH,
			("//input[@data-id='subject.fieldControl-text-box-text']"));
	public UIElement meetingPrimaryAttendeeInputBox = new UIElement("meetingPrimaryContactInputBox", IdentifyBy.XPATH,
			"//div[@data-id='cs_primarycontact.fieldControl-LookupResultsDropdown_cs_primarycontact_selected_tag_text']");
	public UIElement clockIcon = new UIElement("clockIcon", IdentifyBy.XPATH,
			"//button[contains(@class,'ms-Button ms-Button--icon')]");
	public UIElement retailOpporNameInputBox = new UIElement("retailOpporNameInputBox", IdentifyBy.XPATH,
			"//input[@data-id='name.fieldControl-text-box-text']");
	public UIElement saveRetailOpporButton = new UIElement("saveRetailOpporButton", IdentifyBy.XPATH,
			"//button[@data-id='opportunity|NoRelationship|Form|Mscrm.Form.opportunity.Save']");
	public UIElement addOpportunityDropDownButton = new UIElement("addOpportunityDropDownButton", IdentifyBy.XPATH,
			"//button[@data-id='contact|NoRelationship|Form|cs.contact.Form.Button.Hybrid.AddOpportunity.Menu$splitButtonId']");
	public UIElement retailOpportunityButton = new UIElement("retailOpportunityButton", IdentifyBy.XPATH,
			"//span[text()='Retail Opportunity']");
	public UIElement strategyProductField = new UIElement("strategyProductField", IdentifyBy.XPATH,
			"//input[@data-id='cs_productreferenceid.fieldControl-LookupResultsDropdown_cs_productreferenceid_textInputBox_with_filter_new']");
	public UIElement strategyProductFieldSelected = new UIElement("strategyProductFieldSelected", IdentifyBy.XPATH,
			"//div[@data-id='cs_productreferenceid.fieldControl-LookupResultsDropdown_cs_productreferenceid_selected_tag']");
	public UIElement estCloseDateField = new UIElement("estCloseDateField", IdentifyBy.XPATH,
			"//input[@data-id='estimatedclosedate.fieldControl-date-time-input']");
	public UIElement estSizeField = new UIElement("estSizeField", IdentifyBy.XPATH,
			"//input[@data-id='cs_estimatedvaluek.fieldControl-currency-text-input']");
	public UIElement descriptionFieldForRetailOppor = new UIElement("descriptionFieldForRetailOppor", IdentifyBy.XPATH,
			"//textarea[@data-id='description.fieldControl-text-box-text']");
	public UIElement cancelButtonForQuickCreateTask = new UIElement("cancelButtonForQuickCreateTask", IdentifyBy.XPATH,
			"//button[@data-id='quickCreateCancelBtn']");
	public UIElement cancelButton = new UIElement("cancelButton", IdentifyBy.XPATH, "//button[@id='cancelButton']");
	public UIElement cancelDeactivateButton = new UIElement("cancelDeactivateButton", IdentifyBy.XPATH,
			"//button[@data-id='cancel_id']");
	public UIElement cancelDeactivateButtonForContact = new UIElement("cancelDeactivateButtonForContact",
			IdentifyBy.XPATH, "//button[@data-id='cancelButton']");
	public UIElement dialogcancelButton = new UIElement("dialogcancelButton", IdentifyBy.XPATH,
			"//button[@id='cmdDialogCancel']");
	public UIElement dialogCloseButton = new UIElement("dialogCloseButton", IdentifyBy.XPATH,
			"//button[@data-id='dialogCloseIconButton']");
	public UIElement moreCommandButtonForRelationship = new UIElement("moreCommandButtonForRelationship",
			IdentifyBy.XPATH, "//button[@aria-label='More commands for Relationship']");
	public UIElement moreCommandButtonForViewActivityReport = new UIElement("moreCommandButtonForViewActivityReport",
			IdentifyBy.XPATH, "//span[contains(@class,'symbolFont Arrow-symbol')]");//span[contains(@class,'symbolFont Arrow-symbol')]
//	public UIElement moreCommandButtonForCreateRequest = new UIElement("moreCommandButtonForCreateRequest",
//			IdentifyBy.XPATH, "//button[@title='Create Request']");
	public UIElement moreCommandButtonForCreateRequest = new UIElement("moreCommandButtonForCreateRequest",
			IdentifyBy.XPATH, "//button[@aria-label='Create Request']");
//	public UIElement moreCommandButtonForAnalysisRequest = new UIElement("moreCommandButtonForAnalysisRequest",
//			IdentifyBy.XPATH, "//button[@title='Analysis Request']");
	public UIElement moreCommandButtonForAnalysisRequest = new UIElement("moreCommandButtonForAnalysisRequest",
			IdentifyBy.XPATH, "//button[@aria-label='Analysis Request']");
	
//	public UIElement moreCommandButtonForCollaborate = new UIElement("moreCommandButtonForCollaborate",
//			IdentifyBy.XPATH, "//button[@title='Collaborate']");
	public UIElement moreCommandButtonForCollaborate = new UIElement("moreCommandButtonForCollaborate",
			IdentifyBy.XPATH, "//button[@aria-label='Collaborate']");
	public UIElement scriptErrorDialogWindown = new UIElement("scriptErrorDialogWindown", IdentifyBy.XPATH,
			"//h1[text()='Script Error']");
	public UIElement selectDropDownForLocation = new UIElement("selectDropDownForLocation", IdentifyBy.XPATH,
			"//select[@data-id='cs_locationtypecode.fieldControl-option-set-select']");
	public UIElement cityFieldForMeeting = new UIElement("cityFieldForMeeting", IdentifyBy.XPATH,
			"//input[@data-id='cs_city.fieldControl-text-box-text']");
	public UIElement engagementTypeForMeeting = new UIElement("engagementTypeForMeeting", IdentifyBy.XPATH,
			"//select[@data-id='cs_engagementtypecode.fieldControl-option-set-select']");
	public UIElement notesForMeeting = new UIElement("notesForMeeting", IdentifyBy.XPATH,
			"//div[@class='fr-element fr-view']");
	public UIElement relationshipTabOnAdvanceSearch = new UIElement("relationshipTabOnAdvanceSearch", IdentifyBy.XPATH,
			"//a[@id='ui-id-2']");
	public UIElement accountTabOnAdvanceSearch = new UIElement("accountTabOnAdvanceSearch", IdentifyBy.XPATH,
			"//a[@id='ui-id-3']");
	public UIElement opporTabOnAdvanceSearch = new UIElement("opporTabOnAdvanceSearch", IdentifyBy.XPATH,
			"//a[@id='ui-id-4']");
	public UIElement eventTabOnAdvanceSearch = new UIElement("eventTabOnAdvanceSearch", IdentifyBy.XPATH,
			"//a[@id='ui-id-5']");
	public UIElement inviteeTabOnAdvanceSearch = new UIElement("inviteeTabOnAdvanceSearch", IdentifyBy.XPATH,
			"//a[@id='ui-id-6']");
	public UIElement accountNumberInputField = new UIElement("accountNumberInputField", IdentifyBy.XPATH,
			"//input[@id='4af80ddb-a58d-e711-810c-fc15b428467c']");
	public UIElement opportunityNameInputField = new UIElement("opportunityNameInputField", IdentifyBy.XPATH,
			"//input[@id='dad117a3-1dfa-ea11-a815-000d3a337c9e']");
	public UIElement eventNameInputField = new UIElement("eventNameInputField", IdentifyBy.XPATH,
			"//input[@id='075905a6-fd70-e811-8141-e0071b6ad141']");
	public UIElement firstNameInputField = new UIElement("firstNameInputField", IdentifyBy.XPATH,
			"//input[@id='1d5c5ef0-f0e9-e811-814b-e0071b6ae251']");
	public UIElement lastNameInputField = new UIElement("lastNameInputField", IdentifyBy.XPATH,
			"//input[@id='1e5c5ef0-f0e9-e811-814b-e0071b6ae251']");
	public UIElement relationshipInputFieldOnAdvanceSearch = new UIElement("relationshipInputFieldOnAdvanceSearch",
			IdentifyBy.ID, "465e013d-8ef7-e911-a835-000d3a365662");
	public UIElement openCRMGridButtonOnAdvanceSearch = new UIElement("openCRMGridButtonOnAdvanceSearch", IdentifyBy.ID,
			"btOpenCrmGrid");
	private UIElement valueForCompany = new UIElement("valueForCompany", IdentifyBy.XPATH,
			("//span[text()='3M Company']"));
	public UIElement notesForPhoneCall = new UIElement("notesForPhoneCall", IdentifyBy.XPATH,
			"//div[@class='fr-element fr-view']");
	public UIElement firstValue = new UIElement("firstValue", IdentifyBy.XPATH,
			("(//input[@class='wj-cell-check'])[1]"));
	private UIElement engagementTypeContact = new UIElement("engagementTypeContact", IdentifyBy.XPATH,
			"//select[@data-id='cs_engagementtypecode.fieldControl-option-set-select' and @aria-label='Engagement Type']");
	private UIElement productsForPhoneCall = new UIElement("productsForPhoneCall", IdentifyBy.XPATH,
			"//input[@placeholder='Filter or press Enter to search']");
	private UIElement tacOppsForPhoneCall = new UIElement("tacOppsForPhoneCall", IdentifyBy.XPATH,
			"//div[@title='Tac Opps']");
	private UIElement firstItemInRTC = new UIElement("firstItemInRTC", IdentifyBy.XPATH,
			"//div[@class='wj-cell wj-state-selected wj-state-active wj-align-center']/input[@tabindex='-1']");
	// private UIElement fullNameForContact = new UIElement("fullNameForContact",
	// IdentifyBy.XPATH,
	// "//span[text()='Barb Larson']");
	public String i;
	public WebElement checkAllBoxes;
	public WebElement checkBox;
	public UIElement pimcoAssetsLabelFromContact = new UIElement("pimcoAssetsLabelFromContact", IdentifyBy.XPATH,
			"//div[text()='PIMCO Assets']");
	public UIElement goBackButton = new UIElement("goBackButton", IdentifyBy.XPATH, "//button[@title='Go back']");
	public UIElement discardChangesForNewINSTOpp = new UIElement("discardChangesForNewINSTOpp", IdentifyBy.XPATH,
			"//button[@aria-label='Discard changes']");
	public UIElement cancelForMarketingList = new UIElement("cancelForMarketingList", IdentifyBy.XPATH,
			"//button[@data-id='lookupDialogCancelBtnFooter']");
//	public UIElement moreCommandsForContact = new UIElement("moreCommandsForContact", IdentifyBy.XPATH,
//			"//button[@title='More commands for Contact']");
	public UIElement moreCommandsForContact = new UIElement("moreCommandsForContact", IdentifyBy.XPATH,
			"//button[@aria-label='More commands for Contact']");
	private static boolean browserFlag;
	private static RemoteWebDriver browserDriver;
	public UIElement closePDFPreviewDialog = new UIElement("closePDFPreviewDialog", IdentifyBy.XPATH,
			"//button[@aria-label='Close PDF Preview Dialog']");
	public UIElement firstNameOnAdvanceSearch = new UIElement("firstNameOnAdvanceSearch", IdentifyBy.XPATH,
			"//input[@id='7f1d7f32-8df7-e911-a835-000d3a365662']");
	public UIElement lastNameOnAdvanceSearch = new UIElement("lastNameOnAdvanceSearch", IdentifyBy.XPATH,
			"//input[@id='801d7f32-8df7-e911-a835-000d3a365662']");
	public UIElement cancelForPhoneCall = new UIElement("UIElment CancelForPhoneCall", IdentifyBy.XPATH,
			"//button[@data-id='cancelButton']");
	public UIElement completeCloseForPhoneCall = new UIElement("UIElment completeCloseForPhoneCall", IdentifyBy.XPATH,
			"//button[@aria-label='Complete & Close']");
	public UIElement emailDetailForContact = new UIElement("emailDetailForContact ", IdentifyBy.XPATH,
			"//span[text()='Email Details']");
	public UIElement toLabelForEmail = new UIElement("toLabelForEmail", IdentifyBy.XPATH,
			"//input[@data-id='to.fieldControl-LookupResultsDropdown_to_textInputBox_with_filter_new']");
	public UIElement saveForEmail = new UIElement("saveForEmail", IdentifyBy.XPATH, "//button[@aria-label='Save']");
	public UIElement scriptErrorDialog = new UIElement("scriptErrorDialog", IdentifyBy.XPATH,
			"//h1[@aria-label='Script Error']");
	public UIElement cancelForEmail = new UIElement("cancelForEmail", IdentifyBy.XPATH,
			"//button[@aria-label='Cancel']");
//	public UIElement moreCommandForEmail = new UIElement("moreCommandForEmail", IdentifyBy.XPATH,
//			"//button[@title='More commands for Email']");
	public UIElement moreCommandForEmail = new UIElement("moreCommandForEmail", IdentifyBy.XPATH,
			"//button[@aria-label='More commands for Email']");
	public UIElement quickNewButtonInContact = new UIElement("quickNewButtonInContact", IdentifyBy.XPATH,
			"//button[@data-id='quickCreateLauncher']");
	public UIElement activitiesInquickNewButtonOnContact = new UIElement("activitiesInquickNewButtonOnContact =",
			IdentifyBy.XPATH, "//span[text()='Activities']");
	public UIElement quickNewPhoneCall = new UIElement("quickNewPhoneCall", IdentifyBy.XPATH,
			"//span[text()='Phone Call']");
	public UIElement subjectInquickNewPhoneCall = new UIElement("subjectInquickNewPhoneCal", IdentifyBy.XPATH,
			"//input[@data-id='subject.fieldControl-text-box-text']");
	public UIElement relationshipInquickNewPhoneCall = new UIElement("relationshipInquickNewPhoneCall",
			IdentifyBy.XPATH,
			"//input[@data-id='cs_accountid.fieldControl-LookupResultsDropdown_cs_accountid_textInputBox_with_filter_new']");
	public UIElement primaryContactInquickNewPhoneCall = new UIElement("primaryContactInquickNewPhoneCall",
			IdentifyBy.XPATH,
			"//input[@data-id='cs_primarycontact.fieldControl-LookupResultsDropdown_cs_primarycontact_textInputBox_with_filter_new']");
	public UIElement whoAmITlakToInquickNewPhoneCall = new UIElement("whoAmITlakToInquickNewPhoneCall",
			IdentifyBy.XPATH, "//select[@data-id='cs_contacttypecode.fieldControl-option-set-select']");
	public UIElement saveAndCloseInquickNewPhoneCall = new UIElement("saveAndCloseInquickNewPhoneCall",
			IdentifyBy.XPATH, "//button[@data-id='quickCreateSaveAndCloseBtn']");
	public UIElement okInErrorDialog = new UIElement("okInErrorDialog", IdentifyBy.XPATH,
			"//div[@role='alertdialog']/button[@aria-label='OK']");
	public UIElement aCTIVITIESInContact = new UIElement("aCTIVITIESInContact", IdentifyBy.XPATH,
			"//li[@data-id='tablist-TAB_ACTIVITIES']");
	public UIElement phoneCallDataInContact = new UIElement("phoneCallDataInContact", IdentifyBy.XPATH,
			"//a[text()=' Test phone call data For Oscar']");
	public UIElement emaillDataInContact = new UIElement("emaillDataInContact", IdentifyBy.XPATH,
			"//a[text()=' Test email data For Oscar']");
	private UIElement fullNameForOneContact = new UIElement("fullNameForOneContact", IdentifyBy.XPATH,
			"//span[text()='3M Public Equity Alias']");
	
	public UIElement quickNewMeeting = new UIElement("quickNewMeeting",IdentifyBy.XPATH,"//span[text()='Meeting']");
	public UIElement subjectInquickNewMeeting = new UIElement("subjectInquickNewMeeting",IdentifyBy.XPATH,"//input[@data-id='subject.fieldControl-text-box-text']");
	private String quickNewMeetingA;
	private String quickNewMeetingValue;
	public UIElement relationshipInquickNewMeeting = new UIElement("relationshipInquickNewMeeting",IdentifyBy.XPATH,"//input[@data-id='cs_accountid.fieldControl-LookupResultsDropdown_cs_accountid_textInputBox_with_filter_new']");
	public UIElement primaryAttendeeInquickMeeting= new UIElement("primaryAttendeeInquickMeeting",IdentifyBy.XPATH,"//input[@data-id='cs_primarycontact.fieldControl-LookupResultsDropdown_cs_primarycontact_textInputBox_with_filter_new']");
    public UIElement activityPurposeInquickMeeting = new UIElement("activityPurposeInquickMeeting",IdentifyBy.XPATH,"//input[@placeholder='Filter items by name']");
    public UIElement internalAttendeesInquickMeeting = new UIElement("internalAttendeesInquickMeeting",IdentifyBy.XPATH,"//input[@placeholder='Filter or press Enter to search'][1]']");
    public UIElement itemInternalAttendeeForquickMeeting = new UIElement("itemInternalAttendeeForquickMeeting",IdentifyBy.XPATH,"//span[text()='Tony Han']");
    public UIElement buttonInActivityPurposeForquickMeeting = new UIElement("buttonInActivityPurposeForquickMeeting",IdentifyBy.XPATH,"//button[@name='Show r hide quick pick list']/span[@data-automationid='splitbuttonprimary']");
    public UIElement servicingInquickMeeting = new UIElement("servicingInquickMeeting",IdentifyBy.XPATH,"//span[text()='Servicing']");    
    public UIElement quickNewTask = new UIElement("quickNewTask",IdentifyBy.XPATH,"//span[text()='Task']");
    
    
	@Given("^Open CRM \"(.*?)\"$")
	public void NavigateToURL(String userName) throws Throwable {

		String appURL = EnvironmentConfig.getURL();
		Assert.assertNotNull(appURL, "Application URL should not be null");
		getBrowserLibrary().navigate(appURL);
		log.info("Navigated to the URL: " + appURL);

		elementLibrary.enterText(inputFiled, userName);
		log.info("I entered user name as  " + userName + " in username box");
		elementLibrary.click(nextButton);
		browserLibrary.waitForLoad();
		log.info("clicked on Next button");

	}

	@When("^Navigate to app$")
	public void navigateToApp() throws Throwable {

//		WebElement iframeDialog = driver.findElement(By.xpath("//iframe[@id='InlineDialog_Iframe']"));
//
//		if (iframeDialog.isDisplayed()) {
//			elementLibrary.switchToFrame(iframeDialog);
//			Robot robot = new Robot();
//			robot.keyPress(KeyEvent.VK_ESCAPE);
//		}
//		elementLibrary.waitForElementToDisplay(navigateArrow);
//		elementLibrary.click(navigateArrow);
//		Thread.sleep(2000);
//		String sheetName = EnvironmentConfig.getAPP();
//		Assert.assertNotNull(sheetName, "app should not be null");
//		System.out.println(sheetName);
//		WebElement navigateToApp = driver.findElement(By.xpath("//span[text()='" + sheetName + "']"));
//		if (navigateToApp.isDisplayed() == true) {
//			navigateToApp.click();
//		} else {
//			Assert.fail("please check user role");
//		}

		String app = EnvironmentConfig.getAPP();
		UIElement appDetail = new UIElement("appDetail", IdentifyBy.XPATH, "//div[text()='" + app + "']");
		// UIElement appBreadCrumbText = new UIElement("appBreadCrumbText",
		// IdentifyBy.XPATH,"//a[@data-id='appBreadCrumb']");
		// elementLibrary.waitForElementToDisplay(appBreadCrumbText);
//		if (app.equals("Institutional")) {
//			log.info("Navigate Hybrid app successfully");
//		}else {

		// elementLibrary.click(appBreadCrumbText);
		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='AppLandingPage']"));
		elementLibrary.switchToFrame(iframe);
		elementLibrary.waitForElementToDisplay(appDetail);
		elementLibrary.click(appDetail);
		driver.switchTo().defaultContent();
		browserLibrary.waitForLoad();

		// }

	}

	@Then("^Click on each link under Sales on left side menu and make sure no error is displayed to the user$")
	public void clickLeftSideMenu() throws Throwable {

		UIElement relationships_LeftSideMenu = new UIElement("relationships_LeftSideMenu", IdentifyBy.XPATH,
				elementLibrary.getCellData("LeftSideMenu.xls", "Relationships"));
		UIElement contacts_LeftSideMenu = new UIElement("contacts_LeftSideMenu", IdentifyBy.XPATH,
				elementLibrary.getCellData("LeftSideMenu.xls", "Contacts"));
		UIElement opportunities_LeftSideMenu = new UIElement("opportunities_LeftSideMenu", IdentifyBy.XPATH,
				elementLibrary.getCellData("LeftSideMenu.xls", "Opportunities"));
		UIElement activityManager_LeftSideMenu = new UIElement("activityManager_LeftSideMenu", IdentifyBy.XPATH,
				elementLibrary.getCellData("LeftSideMenu.xls", "Activity Manager"));
		UIElement accounts_LeftSideMenu = new UIElement("accounts_LeftSideMenu", IdentifyBy.XPATH,
				elementLibrary.getCellData("LeftSideMenu.xls", "Accounts"));
		UIElement dashboards_LeftSideMenu = new UIElement("dashboards_LeftSideMenu", IdentifyBy.XPATH,
				elementLibrary.getCellData("LeftSideMenu.xls", "Dashboards"));
		UIElement buyingUnits_LeftSideMenu = new UIElement("dashboards_LeftSideMenu", IdentifyBy.XPATH,
				elementLibrary.getCellData("LeftSideMenu.xls", "Buying Units"));
		UIElement myRelationships = new UIElement("myRelationships", IdentifyBy.XPATH,
				elementLibrary.getCellData("LeftSideMenu.xls", "RelationshipsDefaultView"));
		UIElement RTCs_LeftSideMenu = new UIElement("RTCs_LeftSideMenu", IdentifyBy.XPATH,
				elementLibrary.getCellData("LeftSideMenu.xls", "RTCs"));
		UIElement engagementHub_LeftSideMenu = new UIElement("engagementHub_LeftSideMenu", IdentifyBy.XPATH,
				elementLibrary.getCellData("LeftSideMenu.xls", "Engagement Hub"));
		UIElement advancedSearch_LeftSideMenu = new UIElement("advancedSearch_LeftSideMenu", IdentifyBy.XPATH,
				elementLibrary.getCellData("LeftSideMenu.xls", "Advanced Search"));
		UIElement vulnerabilities_LeftSideMenu = new UIElement("vulnerabilities_LeftSideMenu", IdentifyBy.XPATH,
				elementLibrary.getCellData("LeftSideMenu.xls", "Vulnerabilities"));

		String sheetName = EnvironmentConfig.getAPP();
		if (sheetName.equals("Hybrid") || sheetName.equals("Institutional")) {

			String[] arryTiles = { "Dashboards", "Advanced Search", "Relationships", "Contacts", "Accounts",
					"Opportunities", "Vulnerabilities", "Activity Manager" };

			for (int iLoop = 0; iLoop < arryTiles.length; iLoop++) {
				switch (arryTiles[iLoop].trim()) {
				case "Dashboards":
					elementLibrary.click(dashboards_LeftSideMenu);
					elementLibrary.waitForElementToDisplay(myDashboard);
					if (elementLibrary.isAlertPresent(driver)) {
						// driver.switchTo().alert().dismiss();
						Assert.fail("Click on tab: " + arryTiles[iLoop] + " is displaying with error");

					} else {
						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
					}
					break;
				case "Advanced Search":
					elementLibrary.click(advancedSearch_LeftSideMenu);
					WebElement iframeAdvancedSearch = driver
							.findElement(By.xpath("//iframe[@id='FullPageWebResource']"));
					elementLibrary.switchToFrame(iframeAdvancedSearch);
					elementLibrary.waitForElementToDisplay(firstNameOnAdvancedSearch);
					if (elementLibrary.isAlertPresent(driver)) {
						// driver.switchTo().alert().dismiss();
						Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

					} else {
						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
					}
					driver.switchTo().defaultContent();
					break;
				case "Relationships":
					elementLibrary.click(relationships_LeftSideMenu);
					elementLibrary.waitForElementToDisplay(myRelationships);
					if (elementLibrary.isAlertPresent(driver)) {
						// driver.switchTo().alert().dismiss();
						Assert.fail("Click on tab: " + arryTiles[iLoop] + " is displaying with error");

					} else {
						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
					}
					break;
				case "Contacts":
					elementLibrary.click(contacts_LeftSideMenu);
					elementLibrary.waitForElementToDisplay(myContacts);
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

					} else {
						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
					}
					break;
				case "Accounts":
					elementLibrary.click(accounts_LeftSideMenu);
					elementLibrary.waitForElementToDisplay(myLeadAccounts);
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

					} else {
						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
					}
					break;
				case "Opportunities":
					elementLibrary.click(opportunities_LeftSideMenu);
					elementLibrary.waitForElementToDisplay(allOpportunities);
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

					} else {
						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
					}
					break;
				case "Vulnerabilities":
					elementLibrary.click(vulnerabilities_LeftSideMenu);
					WebElement iframeAdvancedSearch1 = driver
							.findElement(By.xpath("//iframe[@id='FullPageWebResource']"));
					elementLibrary.switchToFrame(iframeAdvancedSearch1);
					elementLibrary.waitForElementToDisplay(viewListForOnVulnerabilities);

					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

					} else {
						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
					}
					driver.switchTo().defaultContent();
					break;
				case "Activity Manager":
					elementLibrary.click(activityManager_LeftSideMenu);
					elementLibrary.waitForElementToDisplay(IframeActivityManagerPage);
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

					} else {
						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
					}
					break;
				}
			}
		} else if (sheetName.equals("Retail")) {
			String[] arryTiles = { "Dashboards", "Advanced Search", "Relationships", "Contacts", "Buying Units",
					"Opportunity", "Engagement Hub", "Activity Manager" };

			for (int iLoop = 0; iLoop < arryTiles.length; iLoop++) {
				switch (arryTiles[iLoop].trim()) {

				case "Dashboards":
					elementLibrary.click(dashboards_LeftSideMenu);
					elementLibrary.waitForElementToDisplay(myDashboard);
					if (elementLibrary.isAlertPresent(driver)) {
						// driver.switchTo().alert().dismiss();
						Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

					} else {
						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
					}
					break;
				case "Advanced Search":
					elementLibrary.click(advancedSearch_LeftSideMenu);
					WebElement iframeAdvancedSearch = driver
							.findElement(By.xpath("//iframe[@id='FullPageWebResource']"));
					elementLibrary.switchToFrame(iframeAdvancedSearch);
					elementLibrary.waitForElementToDisplay(firstNameOnAdvancedSearch);
					if (elementLibrary.isAlertPresent(driver)) {
						// driver.switchTo().alert().dismiss();
						Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

					} else {
						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
					}
					driver.switchTo().defaultContent();
					break;
				case "Relationships":
					elementLibrary.click(relationships_LeftSideMenu);
					elementLibrary.waitForElementToDisplay(myRelationships);
					if (elementLibrary.isAlertPresent(driver)) {
						// driver.switchTo().alert().dismiss();
						Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

					} else {
						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
					}
					break;
				case "Contacts":
					elementLibrary.click(contacts_LeftSideMenu);
					elementLibrary.waitForElementToDisplay(myContacts);
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

					} else {
						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
					}
					break;
				case "Buying Units":
					elementLibrary.click(buyingUnits_LeftSideMenu);
					elementLibrary.waitForElementToDisplay(myLeadBuyingUnits);
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

					} else {
						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
					}
					break;

				case "Opportunity":
					elementLibrary.click(opportunities_LeftSideMenu);
					elementLibrary.waitForElementToDisplay(allOpportunities);
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

					} else {
						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
					}
					break;
				case "Engagement Hub":
					elementLibrary.click(engagementHub_LeftSideMenu);
					elementLibrary.waitForElementToDisplay(engagementHub);
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

					} else {
						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
					}
					break;

				case "Activity Manager":
					elementLibrary.click(activityManager_LeftSideMenu);
					elementLibrary.waitForElementToDisplay(IframeActivityManagerPage);
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

					} else {
						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
					}
					break;
				}
			}
		}
//		else {
//
//			String[] arryTiles = { "Dashboards", "Advanced Search", "Relationships", "Contacts", "Accounts",
//					"Opportunities", "Vulnerabilities", "Activity Manager" };
//
//			for (int iLoop = 0; iLoop < arryTiles.length; iLoop++) {
//				switch (arryTiles[iLoop].trim()) {
//				case "Dashboards":
//					elementLibrary.click(dashboards_LeftSideMenu);
//					//browserLibrary.waitForPageLoaded();
//					elementLibrary.waitForElementToDisplay(myDashboard);
//					if (elementLibrary.isAlertPresent(driver)) {
//						// driver.switchTo().alert().dismiss();
//						Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");
//
//					} else {
//						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
//					}
//					break;
//
//				case "Advanced Search":
//					elementLibrary.click(advancedSearch_LeftSideMenu);
//					WebElement iframeAdvancedSearch = driver
//							.findElement(By.xpath("//iframe[@id='FullPageWebResource']"));
//					elementLibrary.switchToFrame(iframeAdvancedSearch);
//					elementLibrary.waitForElementToDisplay(firstNameOnAdvancedSearch);
//					if (elementLibrary.isAlertPresent(driver)) {
//						// driver.switchTo().alert().dismiss();
//						Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");
//
//					} else {
//						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
//					}
//					driver.switchTo().defaultContent();
//					break;
//				case "Relationships":
//					elementLibrary.click(relationships_LeftSideMenu);
//					elementLibrary.waitForElementToDisplay(myRelationships);
//					if (elementLibrary.isAlertPresent(driver)) {
//						// driver.switchTo().alert().dismiss();
//						Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");
//
//					} else {
//						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
//					}
//					break;
//				case "Contacts":
//					elementLibrary.click(contacts_LeftSideMenu);
//					elementLibrary.waitForElementToDisplay(myContacts);
//					if (elementLibrary.isAlertPresent(driver)) {
//						Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");
//
//					} else {
//						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
//					}
//					break;
//				case "Accounts":
//					elementLibrary.click(accounts_LeftSideMenu);
//					elementLibrary.waitForElementToDisplay(myLeadAccounts);
//
//					if (elementLibrary.isAlertPresent(driver)) {
//						Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");
//
//					} else {
//						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
//					}
//					break;
//				case "Opportunities":
//					elementLibrary.click(opportunities_LeftSideMenu);
//					elementLibrary.waitForElementToDisplay(allOpportunities);
//
//					if (elementLibrary.isAlertPresent(driver)) {
//						Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");
//
//					} else {
//						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
//					}
//					break;
//				case "Vulnerabilities":
//					elementLibrary.click(vulnerabilities_LeftSideMenu);
//					WebElement iframeAdvancedSearch1 = driver
//							.findElement(By.xpath("//iframe[@id='FullPageWebResource']"));
//					elementLibrary.switchToFrame(iframeAdvancedSearch1);
//					elementLibrary.waitForElementToDisplay(viewListForOnVulnerabilities);
//
//					if (elementLibrary.isAlertPresent(driver)) {
//						Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");
//
//					} else {
//						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
//					}
//					driver.switchTo().defaultContent();
//					break;
//				case "Activity Manager":
//					elementLibrary.click(activityManager_LeftSideMenu);
//					elementLibrary.waitForElementToDisplay(IframeActivityManagerPage);
//					if (elementLibrary.isAlertPresent(driver)) {
//						Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");
//
//					} else {
//						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
//					}
//					break;
//				}
//			}
//		}

	}

	@And("^Search a relationship \"(.*?)\" to Open$")
	public void openAnRelatioship(String relationshipRecord) throws Exception {

//		Robot robot = new Robot();
//		Thread.sleep(2000);
//		elementLibrary.waitForElementToDisplay(relevanceSearchNew);
//		elementLibrary.click(relevanceSearchNew);
//		Thread.sleep(1000);
//		elementLibrary.enterText(relevanceSearchNew, relationshipRecord);
//		Thread.sleep(1000);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(3000);
//		elementLibrary.waitForElementToDisplay(fullNameForRelationship);
//		elementLibrary.click(fullNameForRelationship);
//		browserLibrary.waitForLoad();
		Robot robot = new Robot();
		Thread.sleep(2000);
		elementLibrary.waitForElementToDisplay(relevanceSearchNew);
		elementLibrary.click(relevanceSearchNew);
		Thread.sleep(1000);
		elementLibrary.enterText(relevanceSearchNew, relationshipRecord);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);

//		UIElement cancelButton = new UIElement("cancelButton", IdentifyBy.XPATH,
//				"//button[@title='Close']//span[1]");
//		if (!driver.findElements(By.xpath("//h1[text()='Error']")).isEmpty()) {
//			elementLibrary.click(cancelButton);
//		}
//		
//		elementLibrary.waitForElementToDisplay(relevanceSearchNew);
//		elementLibrary.click(relevanceSearchNew);
//		Thread.sleep(1000);
//		elementLibrary.enterText(relevanceSearchNew, relationshipRecord);
//		Thread.sleep(1000);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(3000);

		elementLibrary.waitForElementToDisplay(fullNameForRelationship);
		elementLibrary.click(fullNameForRelationship);
		browserLibrary.waitForLoad();
//		UIElement relevanceSearch = new UIElement("relevanceSearch", IdentifyBy.XPATH,
//				"//button[@aria-label='Search']");
//		UIElement relevanceSearchInput = new UIElement("relevanceSearchInput", IdentifyBy.ID,
//				"MscrmControls.Containers.RelevanceSearchControl-text-input-props");
//		UIElement relevanceSearchButton = new UIElement("relevanceSearchButton", IdentifyBy.ID,
//				"MscrmControls.Containers.RelevanceSearchControl-microsoftIcon_searchButton");
//		UIElement relationshipItem = new UIElement("relationshipItem", IdentifyBy.ID,
//				"MscrmControls.Containers.RelevanceSearchControl-resultsContainer 0");
//		browserLibrary.waitForLoad();
//		elementLibrary.click(relevanceSearch);
//		elementLibrary.waitForElementToDisplay(relevanceSearchInput);
//		log.info("Relevance Search page open successfully");
//		elementLibrary.enterText(relevanceSearchInput, relationshipRecord);
//		elementLibrary.click(relevanceSearchButton);
//		elementLibrary.waitForElementToDisplay(relationshipItem);
//		elementLibrary.click(relationshipItem);
//		browserLibrary.waitForLoad();

	}

	@And("^Search a Inst opportunity \"(.*?)\" to Open$")
	public void openAnInstOpportunity(String opportunityName) throws Exception {

		Robot robot = new Robot();
		Thread.sleep(2000);
		elementLibrary.waitForElementToDisplay(relevanceSearchNew);
		elementLibrary.click(relevanceSearchNew);
		Thread.sleep(1000);
		elementLibrary.enterText(relevanceSearchNew, opportunityName);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
//
//		UIElement cancelButton = new UIElement("cancelButton", IdentifyBy.XPATH, "//button[@title='Close']//span[1]");
//		if (!driver.findElements(By.xpath("//h1[text()='Error']")).isEmpty()) {
//			elementLibrary.click(cancelButton);
//		}
//
//		elementLibrary.waitForElementToDisplay(relevanceSearchNew);
//		elementLibrary.click(relevanceSearchNew);
//		Thread.sleep(1000);
//		elementLibrary.enterText(relevanceSearchNew, opportunityName);
//		Thread.sleep(1000);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(3000);
		elementLibrary.waitForElementToDisplay(fullNameForInstOpportunity);
		elementLibrary.click(fullNameForInstOpportunity);
		browserLibrary.waitForLoad();
	}

	@And("^Search a Retail opportunity \"(.*?)\" to Open$")
	public void openAnRetailOpportunity(String opportunityName) throws Exception {

		Robot robot = new Robot();
		Thread.sleep(2000);
		elementLibrary.waitForElementToDisplay(relevanceSearchNew);
		elementLibrary.click(relevanceSearchNew);
		Thread.sleep(1000);
		elementLibrary.enterText(relevanceSearchNew, opportunityName);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		//Thread.sleep(3000);

//		UIElement cancelButton = new UIElement("cancelButton", IdentifyBy.XPATH, "//button[@title='Close']//span[1]");
//		if (!driver.findElements(By.xpath("//h1[text()='Error']")).isEmpty()) {
//			elementLibrary.click(cancelButton);
//		}
//
//		elementLibrary.waitForElementToDisplay(relevanceSearchNew);
//		elementLibrary.click(relevanceSearchNew);
//		Thread.sleep(1000);
//		elementLibrary.enterText(relevanceSearchNew, opportunityName);
//		Thread.sleep(1000);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(3000);
		elementLibrary.waitForElementToDisplay(fullNameForRetailOpportunity);
		elementLibrary.click(fullNameForRetailOpportunity);
		browserLibrary.waitForLoad();
	}

	@Then("^make sure no error is displayed to the user$")
	public void verifyRelationshipPage() throws IOException {
		elementLibrary.waitForElementToDisplay(addActivity);
		if (elementLibrary.isAlertPresent(driver)) {
			Assert.fail("The relationship page is displaying with error");

		} else {

			log.info("The relationship page is displaying without error");
		}
	}

	@Then("^Click on each tab and make sure no error is displayed to the user$")
	public void verifyAllTabsOnRelationshipPage() throws Throwable {

		String sheetName = EnvironmentConfig.getAPP();

		UIElement activitesTabOnRelationship = new UIElement("activitesTabOnRelationship", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabOnRelationship.xls", "Activities"));
		UIElement peopleTabOnRelationship = new UIElement("peopleTabOnRelationship", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabOnRelationship.xls", "People"));
		UIElement consultingFirmsTabOnRelationship = new UIElement("consultingFirmsTabOnRelationship", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabOnRelationship.xls", "Consulting Firms/OCIOs"));
		UIElement accountsTabOnRelationship = new UIElement("accountsTabOnRelationship", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabOnRelationship.xls", "Accounts"));
		UIElement detailsTabOnRelationship = new UIElement("detailsTabOnRelationship", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabOnRelationship.xls", "Details"));
		UIElement relationshipHierarchyTabOnRelationship = new UIElement("relationshipHierarchyTabOnRelationship",
				IdentifyBy.XPATH, elementLibrary.getCellData("TabOnRelationship.xls", "Relationship Hierarchy"));
		UIElement relatedTabOnRelationship = new UIElement("relatedTabOnRelationship", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabOnRelationship.xls", "Related"));
		UIElement documentTabOnRelationship = new UIElement("documentTabOnRelationship", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabOnRelationship.xls", "document"));
		UIElement BusDevRequestTabOnRelationship = new UIElement("BusDevRequestTabOnRelationship", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabOnRelationship.xls", "BusDevRequest"));
		UIElement feedBackTabOnRelationship = new UIElement("feedBackTabOnRelationship", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabOnRelationship.xls", "feedBack"));
		UIElement analysisRequestOnRelationship = new UIElement("analysisRequestOnRelationship", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabOnRelationship.xls", "analysisRequest"));
		UIElement speakerRequestTabOnRelationship = new UIElement("speakerRequestTabOnRelationship", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabOnRelationship.xls", "speakerRequest"));
		UIElement auditHistoryTabOnRelationship = new UIElement("auditHistoryTabOnRelationship", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabOnRelationship.xls", "auditHistory"));

		UIElement DevicesTabOnRelationship = new UIElement("DevicesTabOnRelationship", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabOnRelationship.xls", "Devices"));
		UIElement IoTDevicesTabOnRelationship = new UIElement("IoTDevicesTabOnRelationship", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabOnRelationship.xls", "IoTDevices"));
		UIElement nationalFirmRequestsTabOnRelationship = new UIElement("nationalFirmRequestsTabOnRelationship",
				IdentifyBy.XPATH, elementLibrary.getCellData("TabOnRelationship.xls", "nationalFirmRequests"));
		UIElement relationshipInvestmentPoolsTabOnRelationship = new UIElement(
				"relationshipInvestmentPoolsTabOnRelationship", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabOnRelationship.xls", "relationshipInvestmentPools"));
		UIElement connectionsTabOnRelationship = new UIElement("connectionsTabOnRelationship", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabOnRelationship.xls", "connections"));
		UIElement opportunitiesTabOnRelationship = new UIElement("opportunitiesTabOnRelationship", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabOnRelationship.xls", "opportunities"));
		UIElement marketingListsTabOnRelationship = new UIElement("marketingListsTabOnRelationship", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabOnRelationship.xls", "MarketingLists"));
		UIElement coverageChangeRequestTabOnRelationship = new UIElement("coverageChangeRequestTabOnRelationship",
				IdentifyBy.XPATH, elementLibrary.getCellData("TabOnRelationship.xls", "CoverageChangeRequest"));
		UIElement moreTabOnRelationship = new UIElement("moreTabOnRelationship", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabOnRelationship.xls", "moreTab"));

		UIElement Iframe_Activites = new UIElement("Iframe", IdentifyBy.XPATH,
				"//iframe[@id='WebResource_Activities']");
		UIElement Iframe_People = new UIElement("Iframe", IdentifyBy.XPATH,
				"//iframe[@id='WebResource_Custom_AllContacts']");
		UIElement Iframe_ConsultingFirm = new UIElement("Iframe", IdentifyBy.XPATH,
				"//iframe[@id='WebResource_Consultants']");
		UIElement Iframe_Accounts = new UIElement("Iframe", IdentifyBy.XPATH,
				"//iframe[@id='WebResource_AllAccounts']");
		UIElement Iframe_PRelationshipHierarchy = new UIElement("Iframe", IdentifyBy.XPATH,
				"//iframe[@id='WebResource_RelationshipHierarchy']");
		UIElement Ifrme_AuditHistory = new UIElement("Iframe", IdentifyBy.XPATH, "//iframe[@id='audit_iframe']");

		if (sheetName.equals("Institutional")) {
			String[] arryTiles = { "Activities", "People", "Consulting Firms/OCIOs", "Accounts", "Details",
					"Relationship Hierarchy", "Related" };
			String[] arryTiles1 = { "Documents", "Opportunities", "BusDevRequest", "Marketing Lists",
					"Analysis Requests", "Speaker Request", "Audit History", "National Firm Requests",
					"Relationship investment pools", "Coverage Change Request", "Connections" };

			for (int iLoop = 0; iLoop < arryTiles.length; iLoop++) {
				switch (arryTiles[iLoop].trim()) {
				case "Activities":
					elementLibrary.click(activitesTabOnRelationship);
					elementLibrary.waitForElementToDisplay(Iframe_Activites);
					if (elementLibrary.isAlertPresent(driver)) {
						// driver.switchTo().alert().dismiss();
						Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

					} else {
						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
					}
					break;
				case "People":
					elementLibrary.click(peopleTabOnRelationship);
					elementLibrary.waitForElementToDisplay(Iframe_People);
					if (elementLibrary.isAlertPresent(driver)) {
						// driver.switchTo().alert().dismiss();
						Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

					} else {
						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
					}
					break;

				case "Consulting Firms/OCIOs":
					elementLibrary.click(consultingFirmsTabOnRelationship);
					elementLibrary.waitForElementToDisplay(Iframe_ConsultingFirm);

					if (elementLibrary.isAlertPresent(driver)) {
						// driver.switchTo().alert().dismiss();
						Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

					} else {
						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
					}
					break;
				case "Accounts":
					elementLibrary.click(accountsTabOnRelationship);
					elementLibrary.waitForElementToDisplay(Iframe_Accounts);
					if (elementLibrary.isAlertPresent(driver)) {
						// driver.switchTo().alert().dismiss();
						Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

					} else {
						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
					}
					break;
				case "Details":
					elementLibrary.click(detailsTabOnRelationship);
					browserLibrary.waitForLoad();
					if (elementLibrary.isAlertPresent(driver)) {
						// driver.switchTo().alert().dismiss();
						Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

					} else {
						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
					}
					break;
				case "Relationship Hierarchy":
					elementLibrary.click(relationshipHierarchyTabOnRelationship);
					elementLibrary.waitForElementToDisplay(Iframe_PRelationshipHierarchy);
					if (elementLibrary.isAlertPresent(driver)) {
						// driver.switchTo().alert().dismiss();
						Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

					} else {
						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
					}
					break;
				case "Related":

					for (int iLoop1 = 0; iLoop1 < arryTiles1.length; iLoop1++) {
						if (iLoop1 > 7) {
							elementLibrary.waitForElementToDisplay(moreTabOnRelationship);
							elementLibrary.click(moreTabOnRelationship);
							elementLibrary.waitForElementToDisplay(relatedOthers);
						} else {
							elementLibrary.click(relatedTabOnRelationship);
							elementLibrary.waitForElementToDisplay(relatedOthers);
						}

						switch (arryTiles1[iLoop1].trim()) {
						case "Documents":
							elementLibrary.click(documentTabOnRelationship);
							browserLibrary.waitForLoad();
							if (elementLibrary.isAlertPresent(driver)) {
								// driver.switchTo().alert().dismiss();
								Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

							} else {
								log.info(sheetName + " Click on tab: " + arryTiles1[iLoop1]
										+ " is displaying without error");
							}
							break;
						case "Opportunities":
							elementLibrary.click(opportunitiesTabOnRelationship);
							browserLibrary.waitForLoad();
							if (elementLibrary.isAlertPresent(driver)) {
								// driver.switchTo().alert().dismiss();
								Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

							} else {
								log.info(sheetName + " Click on tab: " + arryTiles1[iLoop1]
										+ " is displaying without error");
							}
							break;
						case "BusDevRequest":
							elementLibrary.click(BusDevRequestTabOnRelationship);
							browserLibrary.waitForLoad();
							if (elementLibrary.isAlertPresent(driver)) {
								// driver.switchTo().alert().dismiss();
								Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

							} else {
								log.info(sheetName + " Click on tab: " + arryTiles1[iLoop1]
										+ " is displaying without error");
							}
							break;

						case "Marketing Lists":
							elementLibrary.click(marketingListsTabOnRelationship);
							browserLibrary.waitForLoad();
							if (elementLibrary.isAlertPresent(driver)) {
								// driver.switchTo().alert().dismiss();
								Assert.fail("The page: " + arryTiles1[iLoop1] + " is displaying with error");

							} else {
								log.info(sheetName + " Click on tab: " + arryTiles1[iLoop1]
										+ " is displaying without error");
							}
							break;
						case "Analysis Requests":
							elementLibrary.click(analysisRequestOnRelationship);
							browserLibrary.waitForLoad();
							if (elementLibrary.isAlertPresent(driver)) {
								// driver.switchTo().alert().dismiss();
								Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

							} else {
								log.info(sheetName + " Click on tab: " + arryTiles1[iLoop1]
										+ " is displaying without error");
							}
							break;
						case "Speaker Request":
							elementLibrary.click(speakerRequestTabOnRelationship);
							browserLibrary.waitForLoad();
							if (elementLibrary.isAlertPresent(driver)) {
								// driver.switchTo().alert().dismiss();
								Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

							} else {
								log.info(sheetName + " Click on tab: " + arryTiles1[iLoop1]
										+ " is displaying without error");
							}
							break;
						case "Audit History":
							elementLibrary.click(auditHistoryTabOnRelationship);
							elementLibrary.waitForElementToDisplay(Ifrme_AuditHistory);
							if (elementLibrary.isAlertPresent(driver)) {
								// driver.switchTo().alert().dismiss();
								Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

							} else {
								log.info(sheetName + " Click on tab: " + arryTiles1[iLoop1]
										+ " is displaying without error");
							}
							break;

						case "National Firm Requests":
							elementLibrary.click(nationalFirmRequestsTabOnRelationship);
							browserLibrary.waitForLoad();
							if (elementLibrary.isAlertPresent(driver)) {
								// driver.switchTo().alert().dismiss();
								Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

							} else {
								log.info(sheetName + " Click on tab: " + arryTiles1[iLoop1]
										+ " is displaying without error");
							}
							break;
						case "Relationship investment pools":
							elementLibrary.click(relationshipInvestmentPoolsTabOnRelationship);
							browserLibrary.waitForLoad();
							if (elementLibrary.isAlertPresent(driver)) {
								// driver.switchTo().alert().dismiss();
								Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

							} else {
								log.info(sheetName + " Click on tab: " + arryTiles1[iLoop1]
										+ " is displaying without error");
							}
							break;
						case "Coverage Change Request":
							elementLibrary.click(coverageChangeRequestTabOnRelationship);
							browserLibrary.waitForLoad();
							if (elementLibrary.isAlertPresent(driver)) {
								// driver.switchTo().alert().dismiss();
								Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

							} else {
								log.info(sheetName + " Click on tab: " + arryTiles1[iLoop1]
										+ " is displaying without error");
							}
							break;
						case "Connections":
							elementLibrary.click(connectionsTabOnRelationship);
							browserLibrary.waitForLoad();
							if (elementLibrary.isAlertPresent(driver)) {
								// driver.switchTo().alert().dismiss();
								Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

							} else {
								log.info(sheetName + " Click on tab: " + arryTiles1[iLoop1]
										+ " is displaying without error");
							}
							break;
						}

					}

				}

			}
		} else if (sheetName.equals("Retail")) {
			String[] arryTiles = { "Activities", "People", "Details", "Relationship Hierarchy", "Related" };
			String[] arryTiles1 = { "Documents", "Analysis Requests", "Speaker Request", "Audit History",
					"National Firm Requests", "Connections" };

			for (int iLoop = 0; iLoop < arryTiles.length; iLoop++) {
				switch (arryTiles[iLoop].trim()) {
				case "Activities":
					elementLibrary.click(activitesTabOnRelationship);
					elementLibrary.waitForElementToDisplay(Iframe_Activites);
					if (elementLibrary.isAlertPresent(driver)) {
						// driver.switchTo().alert().dismiss();
						Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

					} else {
						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
					}
					break;
				case "People":
					elementLibrary.click(peopleTabOnRelationship);
					elementLibrary.waitForElementToDisplay(Iframe_People);
					if (elementLibrary.isAlertPresent(driver)) {
						// driver.switchTo().alert().dismiss();
						Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

					} else {
						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
					}
					break;

				case "Details":
					elementLibrary.click(detailsTabOnRelationship);
					browserLibrary.waitForLoad();
					if (elementLibrary.isAlertPresent(driver)) {
						// driver.switchTo().alert().dismiss();
						Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

					} else {
						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
					}
					break;
				case "Relationship Hierarchy":
					elementLibrary.click(relationshipHierarchyTabOnRelationship);
					elementLibrary.waitForElementToDisplay(Iframe_PRelationshipHierarchy);
					if (elementLibrary.isAlertPresent(driver)) {
						// driver.switchTo().alert().dismiss();
						Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

					} else {
						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
					}
					break;
				case "Related":

					for (int iLoop1 = 0; iLoop1 < arryTiles1.length; iLoop1++) {
						elementLibrary.click(relatedTabOnRelationship);
						elementLibrary.waitForElementToDisplay(relatedOthers);
						switch (arryTiles1[iLoop1].trim()) {
						case "Documents":
							elementLibrary.click(documentTabOnRelationship);
							browserLibrary.waitForLoad();
							if (elementLibrary.isAlertPresent(driver)) {
								// driver.switchTo().alert().dismiss();
								Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

							} else {
								log.info(sheetName + " Click on tab: " + arryTiles1[iLoop1]
										+ " is displaying without error");
							}
							break;
//						case "FeedBack":
//							elementLibrary.click(feedBackTabOnRelationship);
//							browserLibrary.waitForLoad();
//							if (elementLibrary.isAlertPresent(driver)) {
//								// driver.switchTo().alert().dismiss();
//								Assert.fail("The page: " + arryTiles1[iLoop1] + " is displaying with error");
//
//							} else {
//								log.info(sheetName + " Click on tab: " + arryTiles1[iLoop1]
//										+ " is displaying without error");
//							}
//							break;
						case "Analysis Requests":
							elementLibrary.click(analysisRequestOnRelationship);
							browserLibrary.waitForLoad();
							if (elementLibrary.isAlertPresent(driver)) {
								// driver.switchTo().alert().dismiss();
								Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

							} else {
								log.info(sheetName + " Click on tab: " + arryTiles1[iLoop1]
										+ " is displaying without error");
							}
							break;
						case "Speaker Request":
							elementLibrary.click(speakerRequestTabOnRelationship);
							browserLibrary.waitForLoad();
							if (elementLibrary.isAlertPresent(driver)) {
								// driver.switchTo().alert().dismiss();
								Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

							} else {
								log.info(sheetName + " Click on tab: " + arryTiles1[iLoop1]
										+ " is displaying without error");
							}
							break;
						case "Audit History":
							elementLibrary.click(auditHistoryTabOnRelationship);
							elementLibrary.waitForElementToDisplay(Ifrme_AuditHistory);
							if (elementLibrary.isAlertPresent(driver)) {
								// driver.switchTo().alert().dismiss();
								Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

							} else {
								log.info(sheetName + " Click on tab: " + arryTiles1[iLoop1]
										+ " is displaying without error");
							}
							break;

						case "National Firm Requests":
							elementLibrary.click(nationalFirmRequestsTabOnRelationship);
							browserLibrary.waitForLoad();
							if (elementLibrary.isAlertPresent(driver)) {
								// driver.switchTo().alert().dismiss();
								Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

							} else {
								log.info(sheetName + " Click on tab: " + arryTiles1[iLoop1]
										+ " is displaying without error");
							}
							break;

						case "Connections":
							elementLibrary.click(connectionsTabOnRelationship);
							browserLibrary.waitForLoad();
							if (elementLibrary.isAlertPresent(driver)) {
								// driver.switchTo().alert().dismiss();
								Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

							} else {
								log.info(sheetName + " Click on tab: " + arryTiles1[iLoop1]
										+ " is displaying without error");
							}
							break;
						}

					}

				}

			}

		} else if (sheetName.equals("Hybrid")) {
			String[] arryTiles = { "Activities", "People", "Consulting Firms/OCIOs", "Accounts", "Details",
					"Relationship Hierarchy", "Related" };
			String[] arryTiles1 = { "Documents", "BusDevRequest", "Analysis Requests", "Speaker Request",
					"Audit History" };
			for (int iLoop = 0; iLoop < arryTiles.length; iLoop++) {
				switch (arryTiles[iLoop].trim()) {
				case "Activities":
					elementLibrary.click(activitesTabOnRelationship);
					elementLibrary.waitForElementToDisplay(Iframe_Activites);
					if (elementLibrary.isAlertPresent(driver)) {
						// driver.switchTo().alert().dismiss();
						Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

					} else {
						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
					}
					break;
				case "People":
					elementLibrary.click(peopleTabOnRelationship);
					elementLibrary.waitForElementToDisplay(Iframe_People);
					if (elementLibrary.isAlertPresent(driver)) {
						// driver.switchTo().alert().dismiss();
						Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

					} else {
						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
					}
					break;

				case "Consulting Firms/OCIOs":
					elementLibrary.click(consultingFirmsTabOnRelationship);
					elementLibrary.waitForElementToDisplay(Iframe_ConsultingFirm);

					if (elementLibrary.isAlertPresent(driver)) {
						// driver.switchTo().alert().dismiss();
						Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

					} else {
						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
					}
					break;
				case "Accounts":
					elementLibrary.click(accountsTabOnRelationship);
					elementLibrary.waitForElementToDisplay(Iframe_Accounts);
					if (elementLibrary.isAlertPresent(driver)) {
						// driver.switchTo().alert().dismiss();
						Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

					} else {
						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
					}
					break;
				case "Details":
					elementLibrary.click(detailsTabOnRelationship);
					browserLibrary.waitForLoad();
					if (elementLibrary.isAlertPresent(driver)) {
						// driver.switchTo().alert().dismiss();
						Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

					} else {
						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
					}
					break;
				case "Relationship Hierarchy":
					elementLibrary.click(relationshipHierarchyTabOnRelationship);
					elementLibrary.waitForElementToDisplay(Iframe_PRelationshipHierarchy);
					if (elementLibrary.isAlertPresent(driver)) {
						// driver.switchTo().alert().dismiss();
						Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

					} else {
						log.info(sheetName + " Click on tab: " + arryTiles[iLoop] + " is displaying without error");
					}
					break;
				case "Related":

					for (int iLoop1 = 0; iLoop1 < arryTiles1.length; iLoop1++) {
						elementLibrary.click(relatedTabOnRelationship);
						elementLibrary.waitForElementToDisplay(relatedOthers);
						switch (arryTiles1[iLoop1].trim()) {
						case "Documents":
							elementLibrary.click(documentTabOnRelationship);
							browserLibrary.waitForLoad();
							if (elementLibrary.isAlertPresent(driver)) {
								// driver.switchTo().alert().dismiss();
								Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

							} else {
								log.info(sheetName + " Click on tab: " + arryTiles1[iLoop1]
										+ " is displaying without error");
							}
							break;
						case "BusDevRequest":
							elementLibrary.click(BusDevRequestTabOnRelationship);
							browserLibrary.waitForLoad();
							if (elementLibrary.isAlertPresent(driver)) {
								// driver.switchTo().alert().dismiss();
								Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

							} else {
								log.info(sheetName + " Click on tab: " + arryTiles1[iLoop1]
										+ " is displaying without error");
							}
							break;

//						case "FeedBack":
//							elementLibrary.click(feedBackTabOnRelationship);
//							browserLibrary.waitForLoad();
//							if (elementLibrary.isAlertPresent(driver)) {
//								// driver.switchTo().alert().dismiss();
//								Assert.fail("The page: " + arryTiles1[iLoop1] + " is displaying with error");
//
//							} else {
//								log.info(sheetName + " Click on tab: " + arryTiles1[iLoop1]
//										+ " is displaying without error");
//							}
//							break;
						case "Analysis Requests":
							elementLibrary.click(analysisRequestOnRelationship);
							browserLibrary.waitForLoad();
							if (elementLibrary.isAlertPresent(driver)) {
								// driver.switchTo().alert().dismiss();
								Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

							} else {
								log.info(sheetName + " Click on tab: " + arryTiles1[iLoop1]
										+ " is displaying without error");
							}
							break;
						case "Speaker Request":
							elementLibrary.click(speakerRequestTabOnRelationship);
							browserLibrary.waitForLoad();
							if (elementLibrary.isAlertPresent(driver)) {
								// driver.switchTo().alert().dismiss();
								Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

							} else {
								log.info(sheetName + " Click on tab: " + arryTiles1[iLoop1]
										+ " is displaying without error");
							}
							break;
						case "Audit History":
							elementLibrary.click(auditHistoryTabOnRelationship);
							elementLibrary.waitForElementToDisplay(Ifrme_AuditHistory);
							if (elementLibrary.isAlertPresent(driver)) {
								// driver.switchTo().alert().dismiss();
								Assert.fail("The page: " + arryTiles[iLoop] + " is displaying with error");

							} else {
								log.info(sheetName + " Click on tab: " + arryTiles1[iLoop1]
										+ " is displaying without error");
							}
							break;

						}

					}

				}
			}
		}
	}

	@Then("^Validate all labels on the relationship summary page$")
	public void validateAllLabelsOnSummary() throws IOException, InterruptedException {

		UIElement addActivitiesButton = new UIElement("addActivitiesButton", IdentifyBy.XPATH,
				"//span[text()='Add Activity']");
		UIElement relationship = new UIElement("relationship", IdentifyBy.XPATH, "//label[text()='Relationship Name']");
		UIElement officialName = new UIElement("officialName", IdentifyBy.XPATH, "//label[text()='Official Name']");
		UIElement inceptionDate = new UIElement("inceptionDate", IdentifyBy.XPATH, "//label[text()='Inception Date']");
		UIElement parentRelationship = new UIElement("parentRelationship", IdentifyBy.XPATH,
				"//label[text()='Parent Relationship']");

		elementLibrary.waitForElementToDisplay(addActivitiesButton);
		String sheetName = EnvironmentConfig.getAPP();
		WebElement eleLableName = null;

		if (sheetName.equals("Institutional")) {

			UIElement[] arryTiles = { relationship, officialName };
			System.out.println(arryTiles.length);
			for (int iLoop = 0; iLoop < arryTiles.length; iLoop++) {
				eleLableName = getWebDriverService().findElement(arryTiles[iLoop]);
				if (eleLableName.isDisplayed()) {

					log.info("The lable " + arryTiles[iLoop].getName() + "is displaying successfully");
				} else {
					Assert.fail("The lable " + arryTiles[iLoop].getName() + "is displaying unsuccessfully");
					break;
				}

			}
		} else if (sheetName.equals("Retail")) {
			UIElement[] arryTiles = { relationship, officialName };
			System.out.println(arryTiles.length);
			for (int iLoop = 0; iLoop < arryTiles.length; iLoop++) {
				eleLableName = getWebDriverService().findElement(arryTiles[iLoop]);
				if (eleLableName.isDisplayed()) {

					log.info("The lable " + arryTiles[iLoop].getName() + "is displaying successfully");
				} else {
					Assert.fail("The lable " + arryTiles[iLoop].getName() + "is displaying unsuccessfully");
					break;
				}
			}
		} else if (sheetName.equals("Hybrid")) {
			UIElement relationship1 = new UIElement("relationship1", IdentifyBy.XPATH,
					"//label[text()='Relationship Name']");
			UIElement[] arryTiles = { relationship1, officialName };
			System.out.println(arryTiles.length);
			for (int iLoop = 0; iLoop < arryTiles.length; iLoop++) {
				eleLableName = getWebDriverService().findElement(arryTiles[iLoop]);
				if (eleLableName.isDisplayed()) {

					log.info("The lable " + arryTiles[iLoop].getName() + "is displaying successfully");
				} else {
					Assert.fail("The lable " + arryTiles[iLoop].getName() + "is displaying unsuccessfully");
					break;
				}

			}
		}
	}

	@Then("^Click on each tab and validate all labels on the page$")
	public void validateAllLabelsOnEachTab() throws Throwable {

		verifyAllTabsOnRelationshipPage();
//		String sheetName = EnvironmentConfig.getAPP();
//		UIElement activitesTabOnRelationship = new UIElement("activitesTabOnRelationship", IdentifyBy.XPATH,
//				elementLibrary.getCellData("TabOnRelationship.xls", "Activities"));
//		UIElement peopleTabOnRelationship = new UIElement("peopleTabOnRelationship", IdentifyBy.XPATH,
//				elementLibrary.getCellData("TabOnRelationship.xls", "People"));
//		UIElement consultingFirmsTabOnRelationship = new UIElement("consultingFirmsTabOnRelationship", IdentifyBy.XPATH,
//				elementLibrary.getCellData("TabOnRelationship.xls", "Consulting Firms/OCIOs"));
//		UIElement accountsTabOnRelationship = new UIElement("accountsTabOnRelationship", IdentifyBy.XPATH,
//				elementLibrary.getCellData("TabOnRelationship.xls", "Accounts"));
//		UIElement detailsTabOnRelationship = new UIElement("detailsTabOnRelationship", IdentifyBy.XPATH,
//				elementLibrary.getCellData("TabOnRelationship.xls", "Details"));
//		UIElement relationshipHierarchyTabOnRelationship = new UIElement("relationshipHierarchyTabOnRelationship",
//				IdentifyBy.XPATH, elementLibrary.getCellData("TabOnRelationship.xls", "Relationship Hierarchy"));
//		UIElement relatedTabOnRelationship = new UIElement("relatedTabOnRelationship", IdentifyBy.XPATH,
//				elementLibrary.getCellData("TabOnRelationship.xls", "Related"));
//		UIElement documentTabOnRelationship = new UIElement("documentTabOnRelationship", IdentifyBy.XPATH,
//				elementLibrary.getCellData("TabOnRelationship.xls", "document"));
//		UIElement BusDevRequestTabOnRelationship = new UIElement("BusDevRequestTabOnRelationship", IdentifyBy.XPATH,
//				elementLibrary.getCellData("TabOnRelationship.xls", "BusDevRequest"));
//		UIElement feedBackTabOnRelationship = new UIElement("feedBackTabOnRelationship", IdentifyBy.XPATH,
//				elementLibrary.getCellData("TabOnRelationship.xls", "feedBack"));
//		UIElement analysisRequestOnRelationship = new UIElement("analysisRequestOnRelationship", IdentifyBy.XPATH,
//				elementLibrary.getCellData("TabOnRelationship.xls", "analysisRequest"));
//		UIElement speakerRequestTabOnRelationship = new UIElement("speakerRequestTabOnRelationship", IdentifyBy.XPATH,
//				elementLibrary.getCellData("TabOnRelationship.xls", "speakerRequest"));
//		UIElement auditHistoryTabOnRelationship = new UIElement("auditHistoryTabOnRelationship", IdentifyBy.XPATH,
//				elementLibrary.getCellData("TabOnRelationship.xls", "auditHistory"));
//		UIElement nationalFirmRequestsTabOnRelationship = new UIElement("nationalFirmRequestsTabOnRelationship",
//				IdentifyBy.XPATH, elementLibrary.getCellData("TabOnRelationship.xls", "nationalFirmRequests"));
//		UIElement relationshipInvestmentPoolsTabOnRelationship = new UIElement(
//				"relationshipInvestmentPoolsTabOnRelationship", IdentifyBy.XPATH,
//				elementLibrary.getCellData("TabOnRelationship.xls", "relationshipInvestmentPools"));
//		UIElement connectionsTabOnRelationship = new UIElement("connectionsTabOnRelationship", IdentifyBy.XPATH,
//				elementLibrary.getCellData("TabOnRelationship.xls", "connections"));
//
//		UIElement Iframe_Activites = new UIElement("Iframe", IdentifyBy.XPATH,
//				"//iframe[@id='WebResource_Activities']");
//		UIElement Iframe_People = new UIElement("Iframe", IdentifyBy.XPATH,
//				"//iframe[@id='WebResource_Custom_AllContacts']");
//		UIElement Iframe_ConsultingFirm = new UIElement("Iframe", IdentifyBy.XPATH,
//				"//iframe[@id='WebResource_Consultants']");
//		UIElement Iframe_Accounts = new UIElement("Iframe", IdentifyBy.XPATH,
//				"//iframe[@id='WebResource_AllAccounts']");
//		UIElement Iframe_RelationshipHierarchy = new UIElement("Iframe", IdentifyBy.XPATH,
//				"//iframe[@id='WebResource_RelationshipHierarchy']");
//		UIElement Ifrme_AuditHistory = new UIElement("Iframe", IdentifyBy.XPATH, "//iframe[@id='audit_iframe']");
//		UIElement Activities = new UIElement("Activities", IdentifyBy.XPATH, "//h6[contains(text(),'Activities')]");
//		UIElement Contacts = new UIElement("Contacts", IdentifyBy.XPATH, "//h4[text()='Contacts']");
//		UIElement PIMCOCoverage = new UIElement("PIMCOCoverage", IdentifyBy.XPATH, "//span[text()='PIMCO Coverage']");
//		UIElement associatedRelationships = new UIElement("associatedRelationships", IdentifyBy.XPATH,
//				"//div[text()='Associated Relationships']");
//		UIElement ConsultingFirmsOCIOs = new UIElement("ConsultingFirmsOCIOs", IdentifyBy.XPATH,
//				"//select[@class='select']/option[1]");
//		UIElement activeAccounts = new UIElement("activeAccounts", IdentifyBy.TAGNAME, "input");
//		UIElement firstFundDate = new UIElement("firstFundDate", IdentifyBy.XPATH, "//label[text()='First Fund Date']");
//		UIElement lastupdated = new UIElement("lastupdated", IdentifyBy.XPATH, "//label[text()='Last updated:']");
//		UIElement lastContactDate = new UIElement("lastContactDate", IdentifyBy.XPATH,
//				"//label[text()='Last Contact Date']");
//		UIElement lastContactedBy = new UIElement("lastContactedBy", IdentifyBy.XPATH,
//				"//label[text()='Last Contacted By']");
//		UIElement lastMeetingDate = new UIElement("lastMeetingDate", IdentifyBy.XPATH,
//				"//label[text()='Last Meeting Date']");
//		UIElement lastMeetingBy = new UIElement("lastMeetingBy", IdentifyBy.XPATH, "//label[text()='Last Meeting By']");
//		UIElement vulnerabilityRating = new UIElement("vulnerabilityRating", IdentifyBy.XPATH,
//				"//label[text()='Vulnerability Rating']");
//		UIElement asOfDate = new UIElement("asOfDate", IdentifyBy.XPATH, "//label[text()='Vulnerability As of']");
//		UIElement street1 = new UIElement("street1", IdentifyBy.XPATH, "//label[text()='Address Line 1']");
//		UIElement street2 = new UIElement("street2", IdentifyBy.XPATH, "//label[text()='Address Line 2']");
//		UIElement city = new UIElement("city", IdentifyBy.XPATH, "//label[text()='City']");
//		UIElement stateProvince = new UIElement("stateProvince", IdentifyBy.XPATH, "//label[text()='State']");
//		UIElement ZIPPostalCode = new UIElement("ZIPPostalCode", IdentifyBy.XPATH, "//label[text()='Postal Code']");
//		UIElement mainPhone = new UIElement("mainPhone", IdentifyBy.XPATH, "//label[text()='Phone']");
//		UIElement webSite = new UIElement("webSite", IdentifyBy.XPATH, "//label[text()='Website']");
//
//		UIElement filters = new UIElement("filters", IdentifyBy.XPATH, "//h3[text()='Filters']");
//		UIElement documentAssociatedGrid = new UIElement("documentAssociatedGrid", IdentifyBy.XPATH,
//				"//span[text()='Document Associated Grid']");
//		UIElement busDevRequestAssociatedView = new UIElement("busDevRequestAssociatedView", IdentifyBy.XPATH,
//				"//span[text()='Bus Dev Request Associated View']");
//		UIElement feedbackAssociatedView = new UIElement("feedbackAssociatedView", IdentifyBy.XPATH,
//				"//span[text()='Feedback Associated View']");
//		UIElement analysisRequestAssociatedView = new UIElement("analysisRequestAssociatedView", IdentifyBy.XPATH,
//				"//span[text()='Analysis Request Associated View']");
//		UIElement speakerRequestAssociatedView = new UIElement("speakerRequestAssociatedView", IdentifyBy.XPATH,
//				"//span[text()='Speaker Request Associated View']");
//		UIElement auditHistory = new UIElement("auditHistory", IdentifyBy.XPATH, "//div[@id='crmGrid_titleText']");
//		UIElement nationalFirmRequestAssociatedView = new UIElement("nationalFirmRequestAssociatedView",
//				IdentifyBy.XPATH, "//span[text()='National Firm Request Associated View']");
//		UIElement consultingFirmsInvestmentPoolsAssociatedView = new UIElement(
//				"consultingFirmsInvestmentPoolsAssociatedView", IdentifyBy.XPATH,
//				"//span[text()='Consulting Firms/OCIOs & Investment Pools Associated View']");
//		UIElement allActiveConnections = new UIElement("allActiveConnections", IdentifyBy.XPATH,
//				"//span[text()='All Active Connections']");
//		UIElement street2Input = new UIElement("street2Input", IdentifyBy.XPATH,
//				"//input[@data-id='address1_line2.fieldControl-text-box-text']");
//		UIElement dataSetHostContainer = new UIElement("dataSetHostContainer", IdentifyBy.XPATH,
//				"//div[@data-id='DataSetHostContainer']");
//		
//		UIElement DevicesTabOnRelationship = new UIElement("DevicesTabOnRelationship", IdentifyBy.XPATH,
//				"//span[text()='Devices']");
//		UIElement showChartButton = new UIElement("showChartButton", IdentifyBy.XPATH, "//span[text()='Show Chart']");
//		UIElement deviceAssociatedView = new UIElement("deviceAssociatedView", IdentifyBy.XPATH,
//				"//span[text()='Device Associated View']");
//		if (sheetName.equals("Institutional")) {
//			String[] arryTiles = { "Activities", "People", "Consulting Firms/OCIOs", "Accounts", "Details",
//					"Relationship Hierarchy"};
//
//			String[] arryTiles1 = {"BusDevRequest","Analysis Request", "Speaker Request","Audit History"};
//
//			for (int iLoop = 0; iLoop < arryTiles.length; iLoop++) {
//				WebElement eleLableName = null;
//				switch (arryTiles[iLoop].trim()) {
//				case "Activities":
//					elementLibrary.click(activitesTabOnRelationship);
//					elementLibrary.waitForElementToDisplay(Iframe_Activites);
//					WebElement IframeActivites = driver.findElement(By.xpath("//iframe[@id='WebResource_Activities']"));
//					elementLibrary.switchToFrame(IframeActivites);
//					eleLableName = getWebDriverService().findElement(Activities);
//
//					if (eleLableName.getText().equalsIgnoreCase("Activities")) {
//						log.info("The lable Activities is displaying successfully");
//					} else {
//						Assert.fail(
//								"Expected lable name : Activities" + "Actual lable name : " + eleLableName.getText());
//					}
//
//					driver.switchTo().defaultContent();
//					break;
//				case "People":
//					elementLibrary.click(peopleTabOnRelationship);
//					elementLibrary.waitForElementToDisplay(Iframe_People);
//					WebElement IframePeople = driver
//							.findElement(By.xpath("//iframe[@id='WebResource_Custom_AllContacts']"));
//					elementLibrary.switchToFrame(IframePeople);
//					// String[] labelsList = { "Contacts", "PIMCO Coverage", "Associated
//					// Relationships" };
//					UIElement[] labelsList = { Contacts, PIMCOCoverage, associatedRelationships };
//					for (int i = 0; i < labelsList.length; i++) {
//						eleLableName = getWebDriverService().findElement(labelsList[i]);
//
//						if (eleLableName.isDisplayed()) {
//							log.info("The lable " + labelsList[i].getName() + "is displaying successfully");
//							if (i == 0) {
//								driver.switchTo().defaultContent();
//							}
//						} else {
//							Assert.fail("The lable " + labelsList[i].getName() + "is displaying unsuccessfully");
//						}
//					}
//
//					break;
//
//				case "Consulting Firms/OCIOs":
//					elementLibrary.click(consultingFirmsTabOnRelationship);
//					elementLibrary.waitForElementToDisplay(Iframe_ConsultingFirm);
//					WebElement IframeConsultingFirms = driver
//							.findElement(By.xpath("//iframe[@id='WebResource_Consultants']"));
//					elementLibrary.switchToFrame(IframeConsultingFirms);
//					eleLableName = getWebDriverService().findElement(ConsultingFirmsOCIOs);
//					if (eleLableName.getText().equalsIgnoreCase("Consulting Firms/OCIOs & Investment Pools")) {
//						log.info("The lable Consulting Firms/OCIOs is displaying successfully");
//					} else {
//						Assert.fail("Expected lable name : Consulting Firms/OCIOs" + " Actual lable name : "
//								+ eleLableName.getText());
//					}
//					driver.switchTo().defaultContent();
//					break;
//				case "Accounts":
//					elementLibrary.click(accountsTabOnRelationship);
//					elementLibrary.waitForElementToDisplay(Iframe_Accounts);
//					WebElement IframeAccounts = driver.findElement(By.xpath("//iframe[@id='WebResource_AllAccounts']"));
//					elementLibrary.switchToFrame(IframeAccounts);
//					eleLableName = getWebDriverService().findElement(activeAccounts);
//					if (eleLableName.isDisplayed()) {
//						log.info("The lable Active Accounts is displaying successfully");
//					} else {
//						Assert.fail("The lable Active Accounts is displaying unsuccessfully");
//					}
//					driver.switchTo().defaultContent();
//					break;
//				case "Details":
//					elementLibrary.click(detailsTabOnRelationship);
//					browserLibrary.waitForLoad();
//
//					elementLibrary.click(street2Input);
//					Robot robot = new Robot();
//					robot.keyPress(KeyEvent.VK_PAGE_DOWN);
//					UIElement[] labelsOnDetails = { firstFundDate, lastupdated, lastContactDate, lastContactedBy,
//							lastMeetingDate, lastMeetingBy, vulnerabilityRating, asOfDate, street1, street2, city,
//							stateProvince, ZIPPostalCode, mainPhone, webSite };
//
//					for (int i = 0; i < labelsOnDetails.length; i++) {
//						System.out.println(i + 1);
//						eleLableName = getWebDriverService().findElement(labelsOnDetails[i]);
//						if (eleLableName.isDisplayed()) {
//							log.info("The lable" + labelsOnDetails[i].getName() + "is displaying successfully");
//						} else {
//							Assert.fail("The lable" + labelsOnDetails[i].getName() + "is displaying unsuccessfully");
//
//						}
//					}
//					break;
//				case "Relationship Hierarchy":
//					elementLibrary.click(relationshipHierarchyTabOnRelationship);
//					elementLibrary.waitForElementToDisplay(Iframe_RelationshipHierarchy);
//					WebElement iframeRelationshipHierarchy = driver
//							.findElement(By.xpath("//iframe[@id='WebResource_RelationshipHierarchy']"));
//					elementLibrary.switchToFrame(iframeRelationshipHierarchy);
//					eleLableName = getWebDriverService().findElement(filters);
//					if (eleLableName.isDisplayed()) {
//						log.info("The lable Active Accounts is displaying successfully");
//					} else {
//						Assert.fail("The lable Active Accounts is displaying unsuccessfully");
//					}
//					driver.switchTo().defaultContent();
//					break;
//				case "Related":
//
//					for (int iLoop1 = 0; iLoop1 < arryTiles1.length; iLoop1++) {
//
//						elementLibrary.click(relatedTabOnRelationship);
//						elementLibrary.waitForElementToDisplay(relatedOthers);
//						switch (arryTiles1[iLoop1].trim()) {
//						case "Documents":
//							elementLibrary.click(documentTabOnRelationship);
//							elementLibrary.waitForElementToDisplay(documentAssociatedGrid);
//
//							eleLableName = getWebDriverService().findElement(documentAssociatedGrid);
//							if (eleLableName.isDisplayed()) {
//								log.info("The lable" + eleLableName.getText() + "is displaying successfully");
//							} else {
//								Assert.fail("The lable" + eleLableName.getText() + "is displaying unsuccessfully");
//							}
//
//							break;
//						case "BusDevRequest":
//							elementLibrary.click(BusDevRequestTabOnRelationship);
//							elementLibrary.waitForElementToDisplay(dataSetHostContainer);
//							eleLableName = getWebDriverService().findElement(busDevRequestAssociatedView);
//							if (eleLableName.isDisplayed()) {
//								log.info("The lable" + eleLableName.getText() + "is displaying successfully");
//							} else {
//								Assert.fail("The lable" + eleLableName.getText() + "is displaying unsuccessfully");
//							}
//							break;
////						case "FeedBack":
////							elementLibrary.click(feedBackTabOnRelationship);
////							elementLibrary.waitForElementToDisplay(dataSetHostContainer);
////							eleLableName = getWebDriverService().findElement(feedbackAssociatedView);
////							if (eleLableName.isDisplayed()) {
////								log.info("The lable" + eleLableName.getText() + "is displaying successfully");
////							} else {
////								Assert.fail("The lable" + eleLableName.getText() + "is displaying unsuccessfully");
////							}
////							break;
//						case "Analysis Request":
//							elementLibrary.click(analysisRequestOnRelationship);
//							elementLibrary.waitForElementToDisplay(dataSetHostContainer);
//							eleLableName = getWebDriverService().findElement(analysisRequestAssociatedView);
//							if (eleLableName.isDisplayed()) {
//								log.info("The lable" + eleLableName.getText() + "is displaying successfully");
//							} else {
//								Assert.fail("The lable" + eleLableName.getText() + "is displaying unsuccessfully");
//							}
//							break;
//						case "Speaker Request":
//							elementLibrary.click(speakerRequestTabOnRelationship);
//							elementLibrary.waitForElementToDisplay(dataSetHostContainer);
//							eleLableName = getWebDriverService().findElement(speakerRequestAssociatedView);
//							if (eleLableName.isDisplayed()) {
//								log.info("The lable" + eleLableName.getText() + "is displaying successfully");
//							} else {
//								Assert.fail("The lable" + eleLableName.getText() + "is displaying unsuccessfully");
//							}
//							break;
//						case "Audit History":
//							elementLibrary.click(auditHistoryTabOnRelationship);
//							elementLibrary.waitForElementToDisplay(Ifrme_AuditHistory);
//							WebElement ifrmeAuditHistory = driver.findElement(By.xpath("//iframe[@id='audit_iframe']"));
//							elementLibrary.switchToFrame(ifrmeAuditHistory);
//							eleLableName = getWebDriverService().findElement(auditHistory);
//							if (eleLableName.isDisplayed()) {
//								log.info("The lable" + eleLableName.getText() + "is displaying successfully");
//							} else {
//								Assert.fail("The lable" + eleLableName.getText() + "is displaying unsuccessfully");
//							}
//							driver.switchTo().defaultContent();
//
//							break;
//						/*
//						 * case "Devices": elementLibrary.click(DevicesTabOnRelationship);
//						 * elementLibrary.waitForElementToDisplay(showChartButton); eleLableName =
//						 * getWebDriverService().findElement(deviceAssociatedView); if
//						 * (eleLableName.isDisplayed()) { log.info("The lable" + eleLableName.getText()
//						 * + "is displaying successfully"); } else { Assert.fail("The lable" +
//						 * eleLableName.getText() + "is displaying unsuccessfully"); } break;
//						 */
//						case "National Firm Requests":
//							elementLibrary.click(nationalFirmRequestsTabOnRelationship);
//							elementLibrary.waitForElementToDisplay(dataSetHostContainer);
//							eleLableName = getWebDriverService().findElement(nationalFirmRequestAssociatedView);
//							if (eleLableName.isDisplayed()) {
//								log.info("The lable" + eleLableName.getText() + "is displaying successfully");
//							} else {
//								Assert.fail("The lable" + eleLableName.getText() + "is displaying unsuccessfully");
//							}
//							break;
//						case "Relationship investment pools":
//							elementLibrary.click(relationshipInvestmentPoolsTabOnRelationship);
//							elementLibrary.waitForElementToDisplay(dataSetHostContainer);
//							eleLableName = getWebDriverService()
//									.findElement(consultingFirmsInvestmentPoolsAssociatedView);
//							if (eleLableName.isDisplayed()) {
//								log.info("The lable" + eleLableName.getText() + "is displaying successfully");
//							} else {
//								Assert.fail("The lable" + eleLableName.getText() + "is displaying unsuccessfully");
//							}
//							break;
//						case "Connections":
//							elementLibrary.click(connectionsTabOnRelationship);
//							elementLibrary.waitForElementToDisplay(dataSetHostContainer);
//							eleLableName = getWebDriverService().findElement(allActiveConnections);
//							if (eleLableName.isDisplayed()) {
//								log.info("The lable" + eleLableName.getText() + "is displaying successfully");
//							} else {
//								Assert.fail("The lable" + eleLableName.getText() + "is displaying unsuccessfully");
//							}
//							break;
//						}
//
//					}
//
//					break;
//				}
//			}
//		} else if (sheetName.equals("Retail")) {
//			String[] arryTiles = { "Activities", "People", "Relationship Hierarchy" };
//			String[] arryTiles1 = { "Documents","Analysis Request", "Speaker Request", "Audit History",
//					"National Firm Requests", "Connections" };
//
//			for (int iLoop = 0; iLoop < arryTiles.length; iLoop++) {
//				WebElement eleLableName = null;
//				switch (arryTiles[iLoop].trim()) {
//				case "Activities":
//					elementLibrary.click(activitesTabOnRelationship);
//					elementLibrary.waitForElementToDisplay(Iframe_Activites);
//					WebElement IframeActivites = driver.findElement(By.xpath("//iframe[@id='WebResource_Activities']"));
//					elementLibrary.switchToFrame(IframeActivites);
//					eleLableName = getWebDriverService().findElement(Activities);
//
//					if (eleLableName.getText().equalsIgnoreCase("Activities")) {
//						log.info("The lable Activities is displaying successfully");
//					} else {
//						Assert.fail(
//								"Expected lable name : Activities" + "Actual lable name : " + eleLableName.getText());
//					}
//
//					driver.switchTo().defaultContent();
//					break;
//				case "People":
//					elementLibrary.click(peopleTabOnRelationship);
//					elementLibrary.waitForElementToDisplay(Iframe_People);
//					WebElement IframePeople = driver
//							.findElement(By.xpath("//iframe[@id='WebResource_Custom_AllContacts']"));
//					elementLibrary.switchToFrame(IframePeople);
//					// String[] labelsList = { "Contacts", "PIMCO Coverage", "Associated
//					// Relationships" };
//					UIElement[] labelsList = { Contacts, PIMCOCoverage, associatedRelationships };
//					for (int i = 0; i < labelsList.length; i++) {
//						eleLableName = getWebDriverService().findElement(labelsList[i]);
//
//						if (eleLableName.isDisplayed()) {
//							log.info("The lable " + labelsList[i].getName() + "is displaying successfully");
//							if (i == 0) {
//								driver.switchTo().defaultContent();
//							}
//						} else {
//							Assert.fail("The lable " + labelsList[i].getName() + "is displaying unsuccessfully");
//						}
//					}
//
//					break;
//				case "Relationship Hierarchy":
//					elementLibrary.click(relationshipHierarchyTabOnRelationship);
//					elementLibrary.waitForElementToDisplay(Iframe_RelationshipHierarchy);
//					WebElement iframeRelationshipHierarchy = driver
//							.findElement(By.xpath("//iframe[@id='WebResource_RelationshipHierarchy']"));
//					elementLibrary.switchToFrame(iframeRelationshipHierarchy);
//					eleLableName = getWebDriverService().findElement(filters);
//					if (eleLableName.isDisplayed()) {
//						log.info("The lable Active Accounts is displaying successfully");
//					} else {
//						Assert.fail("The lable Active Accounts is displaying unsuccessfully");
//					}
//					driver.switchTo().defaultContent();
//					break;
//				case "Related":
//
//					for (int iLoop1 = 0; iLoop1 < arryTiles1.length; iLoop1++) {
//
//						elementLibrary.click(relatedTabOnRelationship);
//						elementLibrary.waitForElementToDisplay(relatedOthers);
//						switch (arryTiles1[iLoop1].trim()) {
//						case "Documents":
//							elementLibrary.click(documentTabOnRelationship);
//							elementLibrary.waitForElementToDisplay(showChartButton);
//							eleLableName = getWebDriverService().findElement(showChartButton);
//							if (eleLableName.isDisplayed()) {
//								log.info("The lable" + eleLableName.getText() + "is displaying successfully");
//							} else {
//								Assert.fail("The lable" + eleLableName.getText() + "is displaying unsuccessfully");
//							}
//
//							break;
//
////						case "FeedBack":
////							elementLibrary.click(feedBackTabOnRelationship);
////							elementLibrary.waitForElementToDisplay(dataSetHostContainer);
////							eleLableName = getWebDriverService().findElement(feedbackAssociatedView);
////							if (eleLableName.isDisplayed()) {
////								log.info("The lable" + eleLableName.getText() + "is displaying successfully");
////							} else {
////								Assert.fail("The lable" + eleLableName.getText() + "is displaying unsuccessfully");
////							}
////							break;
//						case "Analysis Request":
//							elementLibrary.click(analysisRequestOnRelationship);
//							elementLibrary.waitForElementToDisplay(dataSetHostContainer);
//							eleLableName = getWebDriverService().findElement(analysisRequestAssociatedView);
//							if (eleLableName.isDisplayed()) {
//								log.info("The lable" + eleLableName.getText() + "is displaying successfully");
//							} else {
//								Assert.fail("The lable" + eleLableName.getText() + "is displaying unsuccessfully");
//							}
//							break;
//						case "Speaker Request":
//							elementLibrary.click(speakerRequestTabOnRelationship);
//							elementLibrary.waitForElementToDisplay(dataSetHostContainer);
//							eleLableName = getWebDriverService().findElement(speakerRequestAssociatedView);
//							if (eleLableName.isDisplayed()) {
//								log.info("The lable" + eleLableName.getText() + "is displaying successfully");
//							} else {
//								Assert.fail("The lable" + eleLableName.getText() + "is displaying unsuccessfully");
//							}
//							break;
//						case "Audit History":
//							elementLibrary.click(auditHistoryTabOnRelationship);
//							elementLibrary.waitForElementToDisplay(Ifrme_AuditHistory);
//							WebElement ifrmeAuditHistory = driver.findElement(By.xpath("//iframe[@id='audit_iframe']"));
//							elementLibrary.switchToFrame(ifrmeAuditHistory);
//							eleLableName = getWebDriverService().findElement(auditHistory);
//							if (eleLableName.isDisplayed()) {
//								log.info("The lable" + eleLableName.getText() + "is displaying successfully");
//							} else {
//								Assert.fail("The lable" + eleLableName.getText() + "is displaying unsuccessfully");
//							}
//							driver.switchTo().defaultContent();
//
//							break;
//
//						case "National Firm Requests":
//							elementLibrary.click(nationalFirmRequestsTabOnRelationship);
//							elementLibrary.waitForElementToDisplay(dataSetHostContainer);
//							eleLableName = getWebDriverService().findElement(nationalFirmRequestAssociatedView);
//							if (eleLableName.isDisplayed()) {
//								log.info("The lable" + eleLableName.getText() + "is displaying successfully");
//							} else {
//								Assert.fail("The lable" + eleLableName.getText() + "is displaying unsuccessfully");
//							}
//							break;
//
//						case "Connections":
//							elementLibrary.click(connectionsTabOnRelationship);
//							elementLibrary.waitForElementToDisplay(dataSetHostContainer);
//							eleLableName = getWebDriverService().findElement(allActiveConnections);
//							if (eleLableName.isDisplayed()) {
//								log.info("The lable" + eleLableName.getText() + "is displaying successfully");
//							} else {
//								Assert.fail("The lable" + eleLableName.getText() + "is displaying unsuccessfully");
//							}
//							break;
//						}
//
//					}
//
//					break;
//				}
//			}
//		} else if (sheetName.equals("Hybrid")) {
//			String[] arryTiles = { "Activities", "People", "Consulting Firms/OCIOs", "Accounts",
//					"Relationship Hierarchy"};
//			String[] arryTiles1 = { "Documents", "BusDevRequest","Analysis Request", "Speaker Request",
//					"Audit History" };
//
//			for (int iLoop = 0; iLoop < arryTiles.length; iLoop++) {
//				WebElement eleLableName = null;
//				switch (arryTiles[iLoop].trim()) {
//				case "Activities":
//					elementLibrary.click(activitesTabOnRelationship);
//					elementLibrary.waitForElementToDisplay(Iframe_Activites);
//					WebElement IframeActivites = driver.findElement(By.xpath("//iframe[@id='WebResource_Activities']"));
//					elementLibrary.switchToFrame(IframeActivites);
//					eleLableName = getWebDriverService().findElement(Activities);
//
//					if (eleLableName.getText().equalsIgnoreCase("Activities")) {
//						log.info("The lable Activities is displaying successfully");
//					} else {
//						Assert.fail(
//								"Expected lable name : Activities" + "Actual lable name : " + eleLableName.getText());
//					}
//
//					driver.switchTo().defaultContent();
//					break;
//				case "People":
//					elementLibrary.click(peopleTabOnRelationship);
//					elementLibrary.waitForElementToDisplay(Iframe_People);
//					WebElement IframePeople = driver
//							.findElement(By.xpath("//iframe[@id='WebResource_Custom_AllContacts']"));
//					elementLibrary.switchToFrame(IframePeople);
//					UIElement[] labelsList = { Contacts, PIMCOCoverage, associatedRelationships };
//					for (int i = 0; i < labelsList.length; i++) {
//						eleLableName = getWebDriverService().findElement(labelsList[i]);
//
//						if (eleLableName.isDisplayed()) {
//							log.info("The lable " + labelsList[i].getName() + "is displaying successfully");
//							if (i == 0) {
//								driver.switchTo().defaultContent();
//							}
//						} else {
//							Assert.fail("The lable " + labelsList[i].getName() + "is displaying unsuccessfully");
//						}
//					}
//
//					break;
//
//				case "Consulting Firms/OCIOs":
//					elementLibrary.click(consultingFirmsTabOnRelationship);
//					elementLibrary.waitForElementToDisplay(Iframe_ConsultingFirm);
//					WebElement IframeConsultingFirms = driver
//							.findElement(By.xpath("//iframe[@id='WebResource_Consultants']"));
//					elementLibrary.switchToFrame(IframeConsultingFirms);
//					eleLableName = getWebDriverService().findElement(ConsultingFirmsOCIOs);
//					if (eleLableName.getText().equalsIgnoreCase("Consulting Firms/OCIOs & Investment Pools")) {
//						log.info("The lable Consulting Firms/OCIOs is displaying successfully");
//					} else {
//						Assert.fail("Expected lable name : Consulting Firms/OCIOs" + " Actual lable name : "
//								+ eleLableName.getText());
//					}
//					driver.switchTo().defaultContent();
//					break;
//				case "Accounts":
//					elementLibrary.click(accountsTabOnRelationship);
//					elementLibrary.waitForElementToDisplay(Iframe_Accounts);
//					WebElement IframeAccounts = driver.findElement(By.xpath("//iframe[@id='WebResource_AllAccounts']"));
//					elementLibrary.switchToFrame(IframeAccounts);
//					eleLableName = getWebDriverService().findElement(activeAccounts);
//					if (eleLableName.isDisplayed()) {
//						log.info("The lable Active Accounts is displaying successfully");
//					} else {
//						Assert.fail("The lable Active Accounts is displaying unsuccessfully");
//					}
//					driver.switchTo().defaultContent();
//					break;
//				case "Relationship Hierarchy":
//					elementLibrary.click(relationshipHierarchyTabOnRelationship);
//					elementLibrary.waitForElementToDisplay(Iframe_RelationshipHierarchy);
//					WebElement iframeRelationshipHierarchy = driver
//							.findElement(By.xpath("//iframe[@id='WebResource_RelationshipHierarchy']"));
//					elementLibrary.switchToFrame(iframeRelationshipHierarchy);
//					eleLableName = getWebDriverService().findElement(filters);
//					if (eleLableName.isDisplayed()) {
//						log.info("The lable Active Accounts is displaying successfully");
//					} else {
//						Assert.fail("The lable Active Accounts is displaying unsuccessfully");
//					}
//					driver.switchTo().defaultContent();
//					break;
//				case "Related":
//
//					for (int iLoop1 = 0; iLoop1 < arryTiles1.length; iLoop1++) {
//
//						elementLibrary.click(relatedTabOnRelationship);
//						elementLibrary.waitForElementToDisplay(relatedOthers);
//						switch (arryTiles1[iLoop1].trim()) {
//						case "Documents":
//							elementLibrary.click(documentTabOnRelationship);
//							elementLibrary.waitForElementToDisplay(showChartButton);
//
//							eleLableName = getWebDriverService().findElement(showChartButton);
//							if (eleLableName.isDisplayed()) {
//								log.info("The lable" + eleLableName.getText() + "is displaying successfully");
//							} else {
//								Assert.fail("The lable" + eleLableName.getText() + "is displaying unsuccessfully");
//							}
//
//							break;
//						case "BusDevRequest":
//							elementLibrary.click(BusDevRequestTabOnRelationship);
//							elementLibrary.waitForElementToDisplay(dataSetHostContainer);
//							eleLableName = getWebDriverService().findElement(busDevRequestAssociatedView);
//							if (eleLableName.isDisplayed()) {
//								log.info("The lable" + eleLableName.getText() + "is displaying successfully");
//							} else {
//								Assert.fail("The lable" + eleLableName.getText() + "is displaying unsuccessfully");
//							}
//							break;
////						case "FeedBack":
////							elementLibrary.click(feedBackTabOnRelationship);
////							elementLibrary.waitForElementToDisplay(dataSetHostContainer);
////							eleLableName = getWebDriverService().findElement(feedbackAssociatedView);
////							if (eleLableName.isDisplayed()) {
////								log.info("The lable" + eleLableName.getText() + "is displaying successfully");
////							} else {
////								Assert.fail("The lable" + eleLableName.getText() + "is displaying unsuccessfully");
////							}
////							break;
//						case "Analysis Request":
//							elementLibrary.click(analysisRequestOnRelationship);
//							elementLibrary.waitForElementToDisplay(dataSetHostContainer);
//							eleLableName = getWebDriverService().findElement(analysisRequestAssociatedView);
//							if (eleLableName.isDisplayed()) {
//								log.info("The lable" + eleLableName.getText() + "is displaying successfully");
//							} else {
//								Assert.fail("The lable" + eleLableName.getText() + "is displaying unsuccessfully");
//							}
//							break;
//						case "Speaker Request":
//							elementLibrary.click(speakerRequestTabOnRelationship);
//							elementLibrary.waitForElementToDisplay(dataSetHostContainer);
//							eleLableName = getWebDriverService().findElement(speakerRequestAssociatedView);
//							if (eleLableName.isDisplayed()) {
//								log.info("The lable" + eleLableName.getText() + "is displaying successfully");
//							} else {
//								Assert.fail("The lable" + eleLableName.getText() + "is displaying unsuccessfully");
//							}
//							break;
//						case "Audit History":
//							elementLibrary.click(auditHistoryTabOnRelationship);
//							elementLibrary.waitForElementToDisplay(Ifrme_AuditHistory);
//							WebElement ifrmeAuditHistory = driver.findElement(By.xpath("//iframe[@id='audit_iframe']"));
//							elementLibrary.switchToFrame(ifrmeAuditHistory);
//							eleLableName = getWebDriverService().findElement(auditHistory);
//							if (eleLableName.isDisplayed()) {
//								log.info("The lable" + eleLableName.getText() + "is displaying successfully");
//							} else {
//								Assert.fail("The lable" + eleLableName.getText() + "is displaying unsuccessfully");
//							}
//							driver.switchTo().defaultContent();
//
//							break;
//
//						}
//
//					}
//
//					break;
//				}
//			}
//		}
	}

	/**
	 * @author Oscar
	 */
	@And("^Search out and open the existing contact record \"(.*?)\"$")
	public void openExistingContact(String contactName) throws Exception {
		Robot robot = new Robot();
		Thread.sleep(2000);
		elementLibrary.waitForElementToDisplay(relevanceSearchNew);
		elementLibrary.click(relevanceSearchNew);
		Thread.sleep(1000);
		elementLibrary.enterText(relevanceSearchNew, contactName);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(4000);
		// error dialog
//				elementLibrary.waitForElementToDisplay(okInErrorDialog);
//				Thread.sleep(1000);
//				elementLibrary.click(okInErrorDialog);
//				Thread.sleep(6000);
//				elementLibrary.waitForElementToDisplay(relevanceSearchNew);
//				elementLibrary.click(relevanceSearchNew);
//				Thread.sleep(1000);
//				elementLibrary.enterText(relevanceSearchNew, contactName);
//				Thread.sleep(1000);
//				robot.keyPress(KeyEvent.VK_ENTER);
//				Thread.sleep(5000);

		elementLibrary.waitForElementToDisplay(fullNameForContact);
		elementLibrary.click(fullNameForContact);

//	browserLibrary.waitForLoad();
//	UIElement relevanceSearch = new UIElement("relevanceSearch",IdentifyBy.XPATH,elementLibrary.getCellData("TabLabelOnContact.xls", "relevanceSearch"));
//	elementLibrary.click(relevanceSearch);
//	browserLibrary.waitForLoad();
//	
//	//UIElement relevanceSearchInput = new UIElement("relevanceSearchInput", IdentifyBy.ID,elementLibrary.getPathByName("relevanceSearchInput").getPath());
//	UIElement relevanceSearchInput = new UIElement("relevanceSearchInput", IdentifyBy.ID,elementLibrary.getCellData("TabLabelOnContact.xls","relevanceSearchInput"));
//
//	elementLibrary.waitForElementToDisplay(relevanceSearchInput);
//	System.out.println("Relevance Search page open successfully");
//	log.info("Relevance Search page open successfully");
//	elementLibrary.enterText(relevanceSearchInput,contactName);
//	
//	//UIElement relevanceSearchButton = new UIElement("relevanceSearchButton", IdentifyBy.ID,elementLibrary.getPathByName("relevanceSearchButton").getPath());
//	UIElement relevanceSearchButton = new UIElement("relevanceSearchButton", IdentifyBy.ID,elementLibrary.getCellData("TabLabelOnContact.xls","relevanceSearchButton"));
//
//	elementLibrary.click(relevanceSearchButton);
//	//UIElement firstContact = new UIElement("firstContact", IdentifyBy.ID,elementLibrary.getPathByName("firstContact").getPath());
//	UIElement firstContact = new UIElement("firstContact", IdentifyBy.ID,elementLibrary.getCellData("TabLabelOnContact.xls","firstContact"));
//
//	elementLibrary.waitForElementToDisplay(firstContact);
//	elementLibrary.click(firstContact);
//	browserLibrary.waitForLoad();
	}

	@Then("^Make sure no error is displayed$")
	public void noErrorInContactPage() throws IOException {
		// UIElement addActivityButton = new UIElement("addActivityButton",
		// IdentifyBy.XPATH,elementLibrary.getPathByName("addActivityButton").getPath());
		UIElement addActivityButton = new UIElement("addActivityButton", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "addActivityButton"));

		elementLibrary.waitForElementToDisplay(addActivityButton);
		if (elementLibrary.isAlertPresent(driver)) {
			Assert.fail("The contact page is opening and displaying with error");
		} else {
			System.out.println("Contact record page open successfully");
			log.info("Contact record page opening and displaying with not error");
		}

	}

	@Then("^Click on each tab and make sure no error is displayed$")
	public void clickEachTabOnContact() throws Exception {
		// UIElement activitiesTab = new UIElement("activitiesTab",
		// IdentifyBy.XPATH,elementLibrary.getPathByName("activitiesTab").getPath()) ;
		UIElement activitiesTab = new UIElement("activitiesTab", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "activitiesTab"));

		// UIElement peopleTab = new UIElement("peopleTab",
		// IdentifyBy.XPATH,elementLibrary.getPathByName("peopleTab").getPath()) ;
		UIElement peopleTab = new UIElement("peopleTab", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "peopleTab"));

		// UIElement accountsTab = new UIElement("accountsTab", IdentifyBy.XPATH,
		// getPathByName("accountsTab").getPath());
		// UIElement detailsTab = new UIElement("detailsTab", IdentifyBy.XPATH,
		// elementLibrary.getPathByName("detailsTab").getPath());
		UIElement detailsTab = new UIElement("detailsTab", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "detailsTab"));

		// UIElement subscriptionsTab = new UIElement("subscriptionsTab",
		// IdentifyBy.XPATH,
		// elementLibrary.getPathByName("subscriptionsTab").getPath());
		UIElement subscriptionsTab = new UIElement("subscriptionsTab", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "subscriptionsTab"));

		// UIElement adminTab = new UIElement("adminTab", IdentifyBy.XPATH,
		// elementLibrary.getPathByName("adminTab").getPath());
		// UIElement adminTab = new UIElement("adminTab",
		// IdentifyBy.XPATH,elementLibrary.getCellData("TabLabelOnContact.xls","adminTab"));

		// UIElement relatedTab = new UIElement("relatedTab", IdentifyBy.XPATH,
		// elementLibrary.getPathByName("relatedTab").getPath());
		UIElement relatedTab = new UIElement("relatedTab", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "relatedTab"));

		// UIElement assetsflowsTab = new UIElement("assetsflowsTab", IdentifyBy.XPATH,
		// getPathByName("assetsflowsTab").getPath());
		// UIElement assetsflowsTab = new UIElement("assetsflowsTab", IdentifyBy.XPATH,
		// elementLibrary.getCellData("TabLabelOnContact.xls","assetsflowsTab"));

		// UIElement summaryTab = new UIElement("summaryTab", IdentifyBy.XPATH,
		// elementLibrary.getPathByName("summaryTab").getPath());
		UIElement summaryTab = new UIElement("summaryTab", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "summaryTab"));

		UIElement expensesTab = new UIElement("expensesTab", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "expensesTab"));
		UIElement analysisRequestsTab = new UIElement("analysisRequestsTa", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "analysisRequestsTab"));
		UIElement speakerRequestContactsTab = new UIElement("speakerRequestContactsTab", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "speakerRequestContactsTab"));
		UIElement tradeResearchRequestsTab = new UIElement("tradeResearchRequestsTab", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "tradeResearchRequestsTab"));
		UIElement marketingListsTab = new UIElement("marketingListsTab", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "marketingListsTab"));
		UIElement eventDetailsTab = new UIElement("eventDetailsTab", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "eventDetailsTab"));
		UIElement auditHistoryTab = new UIElement("auditHistoryTab", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "auditHistoryTab"));
		UIElement pimcoCoveragesTab = new UIElement("pimcoCoveragesTab", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "pimcoCoveragesTab"));
		UIElement clientSegmentationsTab = new UIElement("clientSegmentationsTab", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "clientSegmentationsTab"));

		String sheetName = EnvironmentConfig.getAPP();

		if (sheetName.equals("Institutional")) {
			System.out.println("Click Tabs in Contact page on Institutional app");

			String[] arryTiles = { "activities", "people", "accounts", "details", "subscriptions", "related",
					"expenses", "analysisRequests", "speakerRequestContacts", "tradeResearchRequests", "marketingLists",
					"eventDetails", "auditHistory", "pimcoCoverages", "clientSegmentations", "summary" };
			// UIElement accountsTab = new UIElement("accountsTab", IdentifyBy.XPATH,
			// elementLibrary.getPathByName("accountsTab").getPath());
			UIElement accountsTab = new UIElement("accountsTab", IdentifyBy.XPATH,
					elementLibrary.getCellData("TabLabelOnContact.xls", "accountsTab"));

			for (int iLoop = 0; iLoop < arryTiles.length; iLoop++) {
				switch (arryTiles[iLoop].trim()) {
				case "activities":
					elementLibrary.waitForElementToDisplay(activitiesTab);
					elementLibrary.click(activitiesTab);
					browserLibrary.waitForLoad();
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The Activities tab is opening and displaying with error");
						System.out.println("The Activities tab is opening and displaying with error");
					} else {
						System.out.println("The Activities tab is opening and displaying with not error");
						log.info("The Activities tab is opening and displaying with not error");
					}
					break;
				case "people":
					elementLibrary.waitForElementToDisplay(peopleTab);
					elementLibrary.click(peopleTab);
					browserLibrary.waitForLoad();
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The People tab is opening and displaying with error");
						System.out.println("The People tab is opening and displaying with error");
					} else {
						System.out.println("The People tab is opening and displaying with not error");
						log.info("The People tab is opening and displaying with not error");
					}
					break;
				case "accounts":
					elementLibrary.waitForElementToDisplay(accountsTab);
					elementLibrary.click(accountsTab);
					browserLibrary.waitForLoad();
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The Accounts tab is opening and displaying with error");
						System.out.println("The Accounts tab is opening and displaying with error");
					} else {
						System.out.println("The Accounts tab is opening and displaying with not error");
						log.info("The Accounts tab is opening and displaying with not error");
					}
					break;
				case "details":
					elementLibrary.waitForElementToDisplay(detailsTab);
					elementLibrary.click(detailsTab);
					browserLibrary.waitForLoad();
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The Details tab is opening and displaying with error");
						System.out.println("The Details tab is opening and displaying with error");
					} else {
						System.out.println("The Details tab is opening and displaying with not error");
						log.info("The Details tab is opening and displaying with not error");
					}
					break;
				case "subscriptions":
					elementLibrary.waitForElementToDisplay(subscriptionsTab);
					elementLibrary.click(subscriptionsTab);
					browserLibrary.waitForLoad();
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The Subscriptions tab is opening and displaying with error");
						System.out.println("The Subscriptions tab is opening and displaying with error");
					} else {
						System.out.println("The Subscriptions tab is opening and displaying with not error");
						log.info("The Subscriptions tab is opening and displaying with not error");
					}
					break;
//	    	case "admin":
//	    		elementLibrary.waitForElementToDisplay(adminTab);
//	    		elementLibrary.click(adminTab);
//	    		browserLibrary.waitForLoad();
//	    		if (elementLibrary.isAlertPresent(driver))
//	    		{
//	    			Assert.fail("The Admin tab is opening and displaying with error");
//	    			System.out.println("The Admin tab is opening and displaying with error");
//	    		}
//	    		else
//	    		{
//	    			System.out.println("The Admin tab is opening and displaying with not error");
//	    	    	log.info("The Admin tab is opening and displaying with not error");
//	    		}
//	    		break;
				case "related":
					elementLibrary.waitForElementToDisplay(relatedTab);
					elementLibrary.click(relatedTab);
					browserLibrary.waitForLoad();
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The Related tab is opening and displaying with error");
						System.out.println("The Related tab is opening and displaying with error");
					} else {
						System.out.println("The Related tab is opening and displaying with not error");
						log.info("The Related tab is opening and displaying with not error");
					}
					break;

				case "expenses":
					elementLibrary.waitForElementToDisplay(relatedTab);
					elementLibrary.click(relatedTab);
					browserLibrary.waitForLoad();
					Thread.sleep(3000);
					elementLibrary.click(relatedTab);
					Thread.sleep(2000);
					elementLibrary.click(expensesTab);
					Thread.sleep(5000);
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The expenses tab is opening and displaying with error");
						System.out.println("The expenses tab is opening and displaying with error");
					} else {
						System.out.println("The expenses tab is opening and displaying with not error");
						log.info("The Related tab is opening and displaying with not error");
					}
					break;

				case "analysisRequests":
					elementLibrary.waitForElementToDisplay(relatedTab);
					elementLibrary.click(relatedTab);
					browserLibrary.waitForLoad();
//					 Thread.sleep(3000);
//					 elementLibrary.click(relatedTab);
					Thread.sleep(2000);
					elementLibrary.click(analysisRequestsTab);
					Thread.sleep(5000);
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The analysisRequests tab is opening and displaying with error");
						System.out.println("The analysisRequests Tab is opening and displaying with error");
					} else {
						System.out.println("The analysisRequests Tab is opening and displaying with not error");
						log.info("The analysisRequests Tab is opening and displaying with not error");
					}
					break;

				case "speakerRequestContacts":
					elementLibrary.waitForElementToDisplay(relatedTab);
					elementLibrary.click(relatedTab);
					browserLibrary.waitForLoad();
//					 Thread.sleep(3000);
//					 elementLibrary.click(relatedTab);
					Thread.sleep(2000);
					elementLibrary.click(speakerRequestContactsTab);
					Thread.sleep(5000);
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The speakerRequestContacts tab is opening and displaying with error");
						System.out.println("The speakerRequestContacts Tab is opening and displaying with error");
					} else {
						System.out.println("The speakerRequestContacts tab is opening and displaying with not error");
						log.info("The speakerRequestContacts tab is opening and displaying with not error");
					}
					break;

				case "tradeResearchRequests":
					elementLibrary.waitForElementToDisplay(relatedTab);
					elementLibrary.click(relatedTab);
					browserLibrary.waitForLoad();
//					 Thread.sleep(3000);
//					 elementLibrary.click(relatedTab);
					Thread.sleep(2000);
					elementLibrary.click(tradeResearchRequestsTab);
					Thread.sleep(5000);
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The tradeResearchRequests tab is opening and displaying with error");
						System.out.println("The tradeResearchRequests Tab is opening and displaying with error");
					} else {
						System.out.println("The tradeResearchRequests tab is opening and displaying with not error");
						log.info("The tradeResearchRequests tab is opening and displaying with not error");
					}
					break;

				case "marketingLists":
					elementLibrary.waitForElementToDisplay(relatedTab);
					elementLibrary.click(relatedTab);
					browserLibrary.waitForLoad();
//					 Thread.sleep(3000);
//					 elementLibrary.click(relatedTab);
					Thread.sleep(2000);
					elementLibrary.click(marketingListsTab);
					Thread.sleep(5000);
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The marketingLists tab is opening and displaying with error");
						System.out.println("The marketingLists Tab is opening and displaying with error");
					} else {
						System.out.println("The marketingLists tab is opening and displaying with not error");
						log.info("The marketingLists tab is opening and displaying with not error");
					}
					break;

				case "eventDetails":
					elementLibrary.waitForElementToDisplay(relatedTab);
					elementLibrary.click(relatedTab);
					browserLibrary.waitForLoad();
//					 Thread.sleep(3000);
//					 elementLibrary.click(relatedTab);
					Thread.sleep(2000);
					elementLibrary.click(eventDetailsTab);
					Thread.sleep(5000);
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The eventDetails Tab is opening and displaying with error");
						System.out.println("The eventDetails Tab is opening and displaying with error");
					} else {
						System.out.println("The eventDetails tab is opening and displaying with not error");
						log.info("The eventDetails tab is opening and displaying with not error");
					}
					break;

				case "auditHistory":
					elementLibrary.waitForElementToDisplay(relatedTab);
					elementLibrary.click(relatedTab);
					browserLibrary.waitForLoad();
//					 Thread.sleep(3000);
//					 elementLibrary.click(relatedTab);
					Thread.sleep(2000);
					elementLibrary.click(auditHistoryTab);
					Thread.sleep(5000);
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The auditHistory Tab is opening and displaying with error");
						System.out.println("The auditHistory Tab is opening and displaying with error");
					} else {
						System.out.println("The auditHistory tab is opening and displaying with not error");
						log.info("The auditHistory tab is opening and displaying with not error");
					}
					break;

				case "summary":
					elementLibrary.waitForElementToDisplay(summaryTab);
					elementLibrary.click(summaryTab);
					browserLibrary.waitForLoad();
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The Summary Tab is opening and displaying with error");
						System.out.println("The Summary tab is opening and displaying with error");
					} else {
						System.out.println("The Summary tab is opening and displaying with not error");
						log.info("The Summary tab is opening and displaying with not error");
					}
					break;
				}
			}

		} else if (sheetName.equals("Retail")) {
			System.out.println("Click Tabs in Contact page on Retail app");
			String[] arryTiles = { "activities", "people", "accounts", "details", "subscriptions", "related",
					"expenses", "analysisRequests", "speakerRequestContacts", "tradeResearchRequests", "marketingLists",
					"eventDetails", "auditHistory", "pimcoCoverages", "clientSegmentations", "summary",
					"pimcoCoverages", "clientSegmentations" };
			// UIElement assetsflowsTab = new UIElement("assetsflowsTab", IdentifyBy.XPATH,
			// elementLibrary.getPathByName("assetsflowsTab").getPath());
			UIElement assetsflowsTab = new UIElement("assetsflowsTab", IdentifyBy.XPATH,
					elementLibrary.getCellData("TabLabelOnContact.xls", "assetsflowsTab"));

			for (int iLoop = 0; iLoop < arryTiles.length; iLoop++) {
				switch (arryTiles[iLoop].trim()) {
				case "activities":
					elementLibrary.waitForElementToDisplay(activitiesTab);
					elementLibrary.click(activitiesTab);
					browserLibrary.waitForLoad();
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The Activities tab is opening and displaying with error");
						System.out.println("The Activities tab is opening and displaying with error");
					} else {
						System.out.println("The Activities tab is opening and displaying with not error");
						log.info("The Activities tab is opening and displaying with not error");
					}
					break;
				case "people":
					elementLibrary.waitForElementToDisplay(peopleTab);
					elementLibrary.click(peopleTab);
					browserLibrary.waitForLoad();
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The People tab is opening and displaying with error");
						System.out.println("The People tab is opening and displaying with error");
					} else {
						System.out.println("The People tab is opening and displaying with not error");
						log.info("The People tab is opening and displaying with not error");
					}
					break;
//	    	case "assets&flows":	
//	    	    elementLibrary.waitForElementToDisplay(assetsflowsTab);
//	    	    elementLibrary.click(assetsflowsTab);
//	    	    browserLibrary.waitForLoad();
//	    	    if(elementLibrary.isAlertPresent(driver))
//	    	    {
//	    	    	Assert.fail("The Assets & Flows tab is opening and displaying with error");
//	    	    	System.out.println("The Assets & Flows tab is opening and displaying with error");
//	    	    }
//	    	    else
//	    	    {
//	    	    	System.out.println("The Assets & Flows tab is opening and displaying with not error");
//	    	    	log.info("The Assets & Flows tab is opening and displaying with not error");
//	    	    }
//	    	    break;
				case "details":
					elementLibrary.waitForElementToDisplay(detailsTab);
					elementLibrary.click(detailsTab);
					browserLibrary.waitForLoad();
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The Details tab is opening and displaying with error");
						System.out.println("The Details tab is opening and displaying with error");
					} else {
						System.out.println("The Details tab is opening and displaying with not error");
						log.info("The Details tab is opening and displaying with not error");
					}
					break;
				case "subscriptions":
					elementLibrary.waitForElementToDisplay(subscriptionsTab);
					elementLibrary.click(subscriptionsTab);
					browserLibrary.waitForLoad();
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The Subscriptions tab is opening and displaying with error");
						System.out.println("The Subscriptions tab is opening and displaying with error");
					} else {
						System.out.println("The Subscriptions tab is opening and displaying with not error");
						log.info("The Subscriptions tab is opening and displaying with not error");
					}
					break;
//	    	case "admin":
//	    		elementLibrary.waitForElementToDisplay(adminTab);
//	    		elementLibrary.click(adminTab);
//	    		browserLibrary.waitForLoad();
//	    		if (elementLibrary.isAlertPresent(driver))
//	    		{
//	    			Assert.fail("The Admin tab is opening and displaying with error");
//	    			System.out.println("The Admin tab is opening and displaying with error");
//	    		}
//	    		else
//	    		{
//	    			System.out.println("The Admin tab is opening and displaying with not error");
//	    	    	log.info("The Admin tab is opening and displaying with not error");
//	    		}
//	    		break;
				case "related":
					elementLibrary.waitForElementToDisplay(relatedTab);
					elementLibrary.click(relatedTab);
					browserLibrary.waitForLoad();
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The Related tab is opening and displaying with error");
						System.out.println("The Related tab is opening and displaying with error");
					} else {
						System.out.println("The Related tab is opening and displaying with not error");
						log.info("The Related tab is opening and displaying with not error");
					}
					break;

				case "expenses":
					elementLibrary.waitForElementToDisplay(relatedTab);
					elementLibrary.click(relatedTab);
					browserLibrary.waitForLoad();
					Thread.sleep(3000);
					elementLibrary.click(relatedTab);
					Thread.sleep(2000);
					elementLibrary.click(expensesTab);
					Thread.sleep(5000);
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The expenses tab is opening and displaying with error");
						System.out.println("The expenses tab is opening and displaying with error");
					} else {
						System.out.println("The expenses tab is opening and displaying with not error");
						log.info("The Related tab is opening and displaying with not error");
					}
					break;

				case "analysisRequests":
					elementLibrary.waitForElementToDisplay(relatedTab);
					elementLibrary.click(relatedTab);
					browserLibrary.waitForLoad();
//					 Thread.sleep(3000);
//					 elementLibrary.click(relatedTab);
					Thread.sleep(2000);
					elementLibrary.click(analysisRequestsTab);
					Thread.sleep(5000);
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The analysisRequests tab is opening and displaying with error");
						System.out.println("The analysisRequests Tab is opening and displaying with error");
					} else {
						System.out.println("The analysisRequests Tab is opening and displaying with not error");
						log.info("The analysisRequests Tab is opening and displaying with not error");
					}
					break;

				case "speakerRequestContacts":
					elementLibrary.waitForElementToDisplay(relatedTab);
					elementLibrary.click(relatedTab);
					browserLibrary.waitForLoad();
//					 Thread.sleep(3000);
//					 elementLibrary.click(relatedTab);
					Thread.sleep(2000);
					elementLibrary.click(speakerRequestContactsTab);
					Thread.sleep(5000);
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The speakerRequestContacts tab is opening and displaying with error");
						System.out.println("The speakerRequestContacts Tab is opening and displaying with error");
					} else {
						System.out.println("The speakerRequestContacts tab is opening and displaying with not error");
						log.info("The speakerRequestContacts tab is opening and displaying with not error");
					}
					break;

				case "tradeResearchRequests":
					elementLibrary.waitForElementToDisplay(relatedTab);
					elementLibrary.click(relatedTab);
					browserLibrary.waitForLoad();
//					 Thread.sleep(3000);
//					 elementLibrary.click(relatedTab);
					Thread.sleep(2000);
					elementLibrary.click(tradeResearchRequestsTab);
					Thread.sleep(5000);
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The tradeResearchRequests tab is opening and displaying with error");
						System.out.println("The tradeResearchRequests Tab is opening and displaying with error");
					} else {
						System.out.println("The tradeResearchRequests tab is opening and displaying with not error");
						log.info("The tradeResearchRequests tab is opening and displaying with not error");
					}
					break;

				case "marketingLists":
					elementLibrary.waitForElementToDisplay(relatedTab);
					elementLibrary.click(relatedTab);
					browserLibrary.waitForLoad();
//					 Thread.sleep(3000);
//					 elementLibrary.click(relatedTab);
					Thread.sleep(2000);
					elementLibrary.click(marketingListsTab);
					Thread.sleep(5000);
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The marketingLists tab is opening and displaying with error");
						System.out.println("The marketingLists Tab is opening and displaying with error");
					} else {
						System.out.println("The marketingLists tab is opening and displaying with not error");
						log.info("The marketingLists tab is opening and displaying with not error");
					}
					break;

				case "eventDetails":
					elementLibrary.waitForElementToDisplay(relatedTab);
					elementLibrary.click(relatedTab);
					browserLibrary.waitForLoad();
//					 Thread.sleep(3000);
//					 elementLibrary.click(relatedTab);
					Thread.sleep(2000);
					elementLibrary.click(eventDetailsTab);
					Thread.sleep(5000);
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The eventDetails Tab is opening and displaying with error");
						System.out.println("The eventDetails Tab is opening and displaying with error");
					} else {
						System.out.println("The eventDetails tab is opening and displaying with not error");
						log.info("The eventDetails tab is opening and displaying with not error");
					}
					break;

				case "auditHistory":
					elementLibrary.waitForElementToDisplay(relatedTab);
					elementLibrary.click(relatedTab);
					browserLibrary.waitForLoad();
//					 Thread.sleep(3000);
//					 elementLibrary.click(relatedTab);
					Thread.sleep(2000);
					elementLibrary.click(auditHistoryTab);
					Thread.sleep(5000);
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The auditHistory Tab is opening and displaying with error");
						System.out.println("The auditHistory Tab is opening and displaying with error");
					} else {
						System.out.println("The auditHistory tab is opening and displaying with not error");
						log.info("The auditHistory tab is opening and displaying with not error");
					}
					break;

				case "pimcoCoverages":
					elementLibrary.waitForElementToDisplay(relatedTab);
					elementLibrary.click(relatedTab);
					browserLibrary.waitForLoad();
//					 Thread.sleep(3000);
//					 elementLibrary.click(relatedTab);
					Thread.sleep(2000);
					elementLibrary.click(pimcoCoveragesTab);
					Thread.sleep(5000);
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The pimcoCoveragesTab is opening and displaying with error");
						System.out.println("The pimcoCoveragesTab is opening and displaying with error");
					} else {
						System.out.println("The pimcoCoveragesTab is opening and displaying with not error");
						log.info("The pimcoCoveragesTab is opening and displaying with not error");
					}
					break;

				case "clientSegmentations":
					elementLibrary.waitForElementToDisplay(relatedTab);
					elementLibrary.click(relatedTab);
					browserLibrary.waitForLoad();
//					 Thread.sleep(3000);
//					 elementLibrary.click(relatedTab);
					Thread.sleep(2000);
					elementLibrary.click(clientSegmentationsTab);
					Thread.sleep(5000);
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The clientSegmentationsTab is opening and displaying with error");
						System.out.println("The clientSegmentationsTab is opening and displaying with error");
					} else {
						System.out.println("The clientSegmentationsTab is opening and displaying with not error");
						log.info("The clientSegmentationsTab is opening and displaying with not error");
					}
					break;

				case "summary":
					elementLibrary.waitForElementToDisplay(summaryTab);
					elementLibrary.click(summaryTab);
					browserLibrary.waitForLoad();
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The Summary Tab is opening and displaying with error");
						System.out.println("The Summary tab is opening and displaying with error");
					} else {
						System.out.println("The Summary tab is opening and displaying with not error");
						log.info("The Summary tab is opening and displaying with not error");
					}
					break;
				}
			}

		} else {
			System.out.println("Click Tabs in Contact page on Hybrid app");
			String[] arryTiles = { "activities", "people", "accounts", "details", "subscriptions", "related",
					"expenses", "analysisRequests", "speakerRequestContacts", "tradeResearchRequests", "marketingLists",
					"eventDetails", "auditHistory", "pimcoCoverages", "clientSegmentations", "summary" };
			// UIElement assetsflowsTab = new UIElement("assetsflowsTab", IdentifyBy.XPATH,
			// elementLibrary.getPathByName("assetsflowsTab").getPath());
			UIElement assetsflowsTab = new UIElement("assetsflowsTab", IdentifyBy.XPATH,
					elementLibrary.getCellData("TabLabelOnContact.xls", "assetsflowsTab"));

			// UIElement accountsTab = new UIElement("accountsTab", IdentifyBy.XPATH,
			// elementLibrary.getPathByName("accountsTab").getPath());
			UIElement accountsTab = new UIElement("accountsTab", IdentifyBy.XPATH,
					elementLibrary.getCellData("TabLabelOnContact.xls", "accountsTab"));

			for (int iLoop = 0; iLoop < arryTiles.length; iLoop++) {
				switch (arryTiles[iLoop].trim()) {
				case "activities":
					elementLibrary.waitForElementToDisplay(activitiesTab);
					elementLibrary.click(activitiesTab);
					browserLibrary.waitForLoad();
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The Activities tab is opening and displaying with error");
						System.out.println("The Activities tab is opening and displaying with error");
					} else {
						System.out.println("The Activities tab is opening and displaying with not error");
						log.info("The Activities tab is opening and displaying with not error");
					}
					break;
				case "people":
					elementLibrary.waitForElementToDisplay(peopleTab);
					elementLibrary.click(peopleTab);
					browserLibrary.waitForLoad();
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The People tab is opening and displaying with error");
						System.out.println("The People tab is opening and displaying with error");
					} else {
						System.out.println("The People tab is opening and displaying with not error");
						log.info("The People tab is opening and displaying with not error");
					}
					break;
// 	    	case "assets&flows":	
// 	    	    elementLibrary.waitForElementToDisplay(assetsflowsTab);
// 	    	    elementLibrary.click(assetsflowsTab);
// 	    	    browserLibrary.waitForLoad();
// 	    	    if(elementLibrary.isAlertPresent(driver))
// 	    	    {
// 	    	    	Assert.fail("The Assets & Flows tab is opening and displaying with error");
// 	    	    	System.out.println("The Assets & Flows tab is opening and displaying with error");
// 	    	    }
// 	    	    else
// 	    	    {
// 	    	    	System.out.println("The Assets & Flows tab is opening and displaying with not error");
// 	    	    	log.info("The Assets & Flows tab is opening and displaying with not error");
// 	    	    }
// 	    	    break;
				case "accounts":
					elementLibrary.waitForElementToDisplay(accountsTab);
					elementLibrary.click(accountsTab);
					browserLibrary.waitForLoad();
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The Accounts tab is opening and displaying with error");
						System.out.println("The Accounts tab is opening and displaying with error");
					} else {
						System.out.println("The Accounts tab is opening and displaying with not error");
						log.info("The Accounts tab is opening and displaying with not error");
					}
					break;
				case "details":
					elementLibrary.waitForElementToDisplay(detailsTab);
					elementLibrary.click(detailsTab);
					browserLibrary.waitForLoad();
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The Details tab is opening and displaying with error");
						System.out.println("The Details tab is opening and displaying with error");
					} else {
						System.out.println("The Details tab is opening and displaying with not error");
						log.info("The Details tab is opening and displaying with not error");
					}
					break;
				case "subscriptions":
					elementLibrary.waitForElementToDisplay(subscriptionsTab);
					elementLibrary.click(subscriptionsTab);
					browserLibrary.waitForLoad();
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The Subscriptions tab is opening and displaying with error");
						System.out.println("The Subscriptions tab is opening and displaying with error");
					} else {
						System.out.println("The Subscriptions tab is opening and displaying with not error");
						log.info("The Subscriptions tab is opening and displaying with not error");
					}
					break;
// 	    	case "admin":
// 	    		elementLibrary.waitForElementToDisplay(adminTab);
// 	    		elementLibrary.click(adminTab);
// 	    		browserLibrary.waitForLoad();
// 	    		if (elementLibrary.isAlertPresent(driver))
// 	    		{
// 	    			Assert.fail("The Admin tab is opening and displaying with error");
// 	    			System.out.println("The Admin tab is opening and displaying with error");
// 	    		}
// 	    		else
// 	    		{
// 	    			System.out.println("The Admin tab is opening and displaying with not error");
// 	    	    	log.info("The Admin tab is opening and displaying with not error");
// 	    		}
// 	    		break;
				case "related":
					elementLibrary.waitForElementToDisplay(relatedTab);
					elementLibrary.click(relatedTab);
					browserLibrary.waitForLoad();
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The Related tab is opening and displaying with error");
						System.out.println("The Related tab is opening and displaying with error");
					} else {
						System.out.println("The Related tab is opening and displaying with not error");
						log.info("The Related tab is opening and displaying with not error");
					}
					break;

				case "expenses":
					elementLibrary.waitForElementToDisplay(relatedTab);
					elementLibrary.click(relatedTab);
					browserLibrary.waitForLoad();
					Thread.sleep(3000);
					elementLibrary.click(relatedTab);
					Thread.sleep(2000);
					elementLibrary.click(expensesTab);
					Thread.sleep(5000);
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The expenses tab is opening and displaying with error");
						System.out.println("The expenses tab is opening and displaying with error");
					} else {
						System.out.println("The expenses tab is opening and displaying with not error");
						log.info("The Related tab is opening and displaying with not error");
					}
					break;

				case "analysisRequests":
					elementLibrary.waitForElementToDisplay(relatedTab);
					elementLibrary.click(relatedTab);
					browserLibrary.waitForLoad();
//					 Thread.sleep(3000);
//					 elementLibrary.click(relatedTab);
					Thread.sleep(2000);
					elementLibrary.click(analysisRequestsTab);
					Thread.sleep(5000);
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The analysisRequests tab is opening and displaying with error");
						System.out.println("The analysisRequests Tab is opening and displaying with error");
					} else {
						System.out.println("The analysisRequests Tab is opening and displaying with not error");
						log.info("The analysisRequests Tab is opening and displaying with not error");
					}
					break;

				case "speakerRequestContacts":
					elementLibrary.waitForElementToDisplay(relatedTab);
					elementLibrary.click(relatedTab);
					browserLibrary.waitForLoad();
//					 Thread.sleep(3000);
//					 elementLibrary.click(relatedTab);
					Thread.sleep(2000);
					elementLibrary.click(speakerRequestContactsTab);
					Thread.sleep(5000);
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The speakerRequestContacts tab is opening and displaying with error");
						System.out.println("The speakerRequestContacts Tab is opening and displaying with error");
					} else {
						System.out.println("The speakerRequestContacts tab is opening and displaying with not error");
						log.info("The speakerRequestContacts tab is opening and displaying with not error");
					}
					break;

				case "tradeResearchRequests":
					elementLibrary.waitForElementToDisplay(relatedTab);
					elementLibrary.click(relatedTab);
					browserLibrary.waitForLoad();
//					 Thread.sleep(3000);
//					 elementLibrary.click(relatedTab);
					Thread.sleep(2000);
					elementLibrary.click(tradeResearchRequestsTab);
					Thread.sleep(5000);
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The tradeResearchRequests tab is opening and displaying with error");
						System.out.println("The tradeResearchRequests Tab is opening and displaying with error");
					} else {
						System.out.println("The tradeResearchRequests tab is opening and displaying with not error");
						log.info("The tradeResearchRequests tab is opening and displaying with not error");
					}
					break;

				case "marketingLists":
					elementLibrary.waitForElementToDisplay(relatedTab);
					elementLibrary.click(relatedTab);
					browserLibrary.waitForLoad();
//					 Thread.sleep(3000);
//					 elementLibrary.click(relatedTab);
					Thread.sleep(2000);
					elementLibrary.click(marketingListsTab);
					Thread.sleep(5000);
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The marketingLists tab is opening and displaying with error");
						System.out.println("The marketingLists Tab is opening and displaying with error");
					} else {
						System.out.println("The marketingLists tab is opening and displaying with not error");
						log.info("The marketingLists tab is opening and displaying with not error");
					}
					break;

				case "eventDetails":
					elementLibrary.waitForElementToDisplay(relatedTab);
					elementLibrary.click(relatedTab);
					browserLibrary.waitForLoad();
//					 Thread.sleep(3000);
//					 elementLibrary.click(relatedTab);
					Thread.sleep(2000);
					elementLibrary.click(eventDetailsTab);
					Thread.sleep(5000);
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The eventDetails Tab is opening and displaying with error");
						System.out.println("The eventDetails Tab is opening and displaying with error");
					} else {
						System.out.println("The eventDetails tab is opening and displaying with not error");
						log.info("The eventDetails tab is opening and displaying with not error");
					}
					break;

				case "auditHistory":
					elementLibrary.waitForElementToDisplay(relatedTab);
					elementLibrary.click(relatedTab);
					browserLibrary.waitForLoad();
//					 Thread.sleep(3000);
//					 elementLibrary.click(relatedTab);
					Thread.sleep(2000);
					elementLibrary.click(auditHistoryTab);
					Thread.sleep(5000);
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The auditHistory Tab is opening and displaying with error");
						System.out.println("The auditHistory Tab is opening and displaying with error");
					} else {
						System.out.println("The auditHistory tab is opening and displaying with not error");
						log.info("The auditHistory tab is opening and displaying with not error");
					}
					break;

				case "summary":
					elementLibrary.waitForElementToDisplay(summaryTab);
					elementLibrary.click(summaryTab);
					browserLibrary.waitForLoad();
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("The Summary Tab is opening and displaying with error");
						System.out.println("The Summary tab is opening and displaying with error");
					} else {
						System.out.println("The Summary tab is opening and displaying with not error");
						log.info("The Summary tab is opening and displaying with not error");
					}
					break;
				}
			}

		}

	}

	@Then("^Validate labels in Summary tab in contact record page$")
	public void testLabelsInSummaryTab() throws IOException {
		// UIElement firstName = new UIElement("firstName",
		// IdentifyBy.XPATH,elementLibrary.getPathByName("firstName").getPath());
		UIElement firstName = new UIElement("firstName", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "firstName"));

		// UIElement lastName = new UIElement("lastName", IdentifyBy.XPATH,
		// elementLibrary.getPathByName("lastName").getPath());
		UIElement lastName = new UIElement("lastName", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "lastName"));

		// UIElement nickName = new UIElement("nickName", IdentifyBy.XPATH,
		// elementLibrary.getPathByName("nickName").getPath());
		UIElement nickName = new UIElement("nickName", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "nickName"));

		// UIElement jobTitle = new UIElement("jobTitle", IdentifyBy.XPATH,
		// elementLibrary.getPathByName("jobTitle").getPath());
		UIElement jobTitle = new UIElement("jobTitle", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "jobTitle"));

		// UIElement phone = new UIElement("phone",IdentifyBy.XPATH,
		// elementLibrary.getPathByName("phone").getPath());
		UIElement phone = new UIElement("phone", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "phone"));

		// UIElement email = new UIElement("email",IdentifyBy.XPATH,
		// elementLibrary.getPathByName("email").getPath());
		// UIElement email = new UIElement("email", IdentifyBy.XPATH,
		// elementLibrary.getCellData("TabLabelOnContact.xls", "email"));

//	WebDriver webdriver = webdriverServiceLibrary.getWebDriver();
//	Actions action = new Actions(webdriver);
//	WebElement remarksContact = webdriver.findElement(By.xpath("//h2[@title='Remarks']"));
//	action.moveToElement(remarksContact).build().perform();	

		// UIElement leadAMs = new UIElement("leadAMs",
		// IdentifyBy.XPATH,elementLibrary.getCellData("TabLabelOnContact.xls","leadAMs"));

		// UIElement internalAMs = new UIElement("internalAMs",IdentifyBy.XPATH,
		// elementLibrary.getPathByName("internalAMs").getPath());
		// UIElement primaryRelationship = new
		// UIElement("primaryRelationship",IdentifyBy.XPATH,
		// elementLibrary.getPathByName("primaryRelationship").getPath());

		// UIElement remarks = new UIElement("remarks",IdentifyBy.XPATH,
		// elementLibrary.getPathByName("remarks").getPath());
		UIElement remarks = new UIElement("remarks", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "remarks"));

		// UIElement assistant = new UIElement("assistant",IdentifyBy.XPATH,
		// elementLibrary.getPathByName("assistant").getPath());
		UIElement assistant = new UIElement("assistant", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "assistant"));

		// UIElement recentActivities = new
		// UIElement("recentActivities",IdentifyBy.XPATH,
		// elementLibrary.getPathByName("recentActivities").getPath());
		UIElement recentActivities = new UIElement("recentActivities", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "recentActivities"));

		// UIElement website = new UIElement("website",IdentifyBy.XPATH,
		// elementLibrary.getPathByName("website").getPath());

		String sheetName = EnvironmentConfig.getAPP();

		List<UIElement> listA = Lists.newArrayList(firstName, lastName, nickName, jobTitle, phone);

		for (int i = 0; i < listA.size(); i++) {
			String labelName = listA.get(i).getValue();

			if (sheetName.equals("Institutional")) {
				if (elementLibrary.isElementPresent(By.xpath(labelName))) {
					System.out.print("The label " + listA.get(i) + " displays successfully in INST APP");
				} else {
					Assert.fail("Not display " + listA.get(i) + " in page of INST APP");
				}
			} else if (sheetName.equals("Retail")) {
				if (elementLibrary.isElementPresent(By.xpath(labelName))) {
					System.out.print("The label " + listA.get(i) + " displays successfully in Retail APP");
				} else {
					Assert.fail("Not display " + listA.get(i) + " in page pf Retail App");
				}

			} else {
				if (elementLibrary.isElementPresent(By.xpath(labelName))) {
					System.out.print("The label " + listA.get(i) + " displays successfully in Hybrid APP");
				} else {
					Assert.fail("Not display " + listA.get(i) + " in page of Hybrid App");
				}
			}
		}
	}

	@And("^Click New National Firm button$")
	public void clickNewNationalFirmButton() throws Throwable {

		String sheetName = EnvironmentConfig.getAPP();
		if (sheetName.equals("Institutional") || sheetName.equals("Retail") || sheetName.equals("Hybrid")) {
			UIElement relationships_LeftSideMenu = new UIElement("relationships_LeftSideMenu", IdentifyBy.XPATH,
					elementLibrary.getCellData("LeftSideMenu.xls", "Relationships"));
			elementLibrary.waitForElementToDisplay(relationships_LeftSideMenu);
			elementLibrary.click(relationships_LeftSideMenu);
			elementLibrary.waitForElementToDisplay(newNationalFirmButton);
			elementLibrary.click(newNationalFirmButton);
		}
	}

	@And("^Enter relationship name \"(.*?)\" on MDM search page to create new relationship$")
	public void createNewRelationship(String text) throws Throwable {
		String sheetName = EnvironmentConfig.getAPP();
		if (sheetName.equals("Institutional") || sheetName.equals("Retail") || sheetName.equals("Hybrid")) {

			WebElement iframeMDM = driver.findElement(By.id("WebResource_MDM"));
			elementLibrary.switchToFrame(iframeMDM);
			elementLibrary.waitForElementToDisplay(relationshipNameInput);
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmss");
			String formattedDate = sdf.format(date);
			newRelationshipName = text + formattedDate;
			elementLibrary.enterText(relationshipNameInput, newRelationshipName);
			elementLibrary.click(MDMSearchButton);
			elementLibrary.waitForElementToDisplay(MDMCreateButton);
			elementLibrary.click(MDMCreateButton);
			driver.switchTo().defaultContent();
			elementLibrary.waitForElementToDisplay(officialNameField);

		}
	}

	@And("^Enter the street1 as \"(.*?)\"$")
	public void enterStreet1Field(String stree1) throws Throwable {

		elementLibrary.click(officialNameField);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		elementLibrary.click(street1InputBox);
		elementLibrary.enterText(street1InputBox, stree1);
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);

	}

	@And("^Enter the street2 as \"(.*?)\"$")
	public void enterStreet2Field(String stree2) throws Throwable {
		elementLibrary.click(street2InputBox);
		elementLibrary.enterText(street2InputBox, stree2);

	}

	@And("^Enter the street3 as \"(.*?)\"$")
	public void enterStreet3Field(String street3) throws Throwable {
		elementLibrary.click(street3InputBox);
		elementLibrary.enterText(street3InputBox, street3);

	}

	@And("^Enter the City as \"(.*?)\"$")
	public void enterCityField(String City) throws Throwable {
		elementLibrary.click(cityInputBox);
		elementLibrary.enterText(cityInputBox, City);

	}

	@And("^Enter the Country as \"(.*?)\"$")
	public void enterCountryField(String Country) throws Throwable {

		Robot robot = new Robot();

		elementLibrary.mouseOver(countryInputBox);
		elementLibrary.enterText(countryInputBox, Country);
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
	}

	@And("^Enter the State as \"(.*?)\"$")
	public void enterStateField(String State) throws Throwable {
		Robot robot = new Robot();
		elementLibrary.mouseOver(stateInputBox);
		elementLibrary.enterText(stateInputBox, State);
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
	}

	@And("^Enter the zipcode as \"(.*?)\"$")
	public void enterZipcode(String zipcode) throws Throwable {
		elementLibrary.click(zipcodeInputBox);
		elementLibrary.enterText(zipcodeInputBox, zipcode);
	}

	@Then("^Save the relationship record$")
	public void clickSaveButton() throws Throwable {
		elementLibrary.click(saveButton);
		Thread.sleep(50000);

		// if(elementLibrary.isElementPresent(By.xpath("//button[@id='okButton']"))) {
		// elementLibrary.click(okButton);
		// }
		WebElement relationshipTitle = driver
				.findElement(By.xpath("//h1[@title=" + "\'" + newRelationshipName + "\'" + "]"));
		Thread.sleep(20000);

		if (relationshipTitle.isDisplayed()) {

			log.info("The new relationship saved successfully");
		} else {
			Assert.fail("The new relationship saved unsuccessfully");
		}
	}

	@Then("^Validate relationshp name field$")
	public void validateRelationshipNameField() throws Throwable {

		if (elementLibrary.getAttribute(relationshipField, "Value").equalsIgnoreCase(newRelationshipName)) {
			log.info("The Relationship saved successfully");
		} else {

			Assert.fail("Expected Relationship : " + newRelationshipName + " Actual Relationship : "
					+ elementLibrary.getText(relationshipField));
		}

	}

	@Then("^Validate street1 field saved as \"(.*?)\"$")
	public void validateStreet1Field(String Street1) throws Throwable {

		elementLibrary.click(detailTab);
		elementLibrary.waitForElementToDisplay(street1InputBox);
		if (elementLibrary.getAttribute(street1InputBox, "Value").equalsIgnoreCase(Street1)) {
			log.info("The street1 saved successfully");
		} else {

			Assert.fail(
					"Expected street1 : " + Street1 + " Actual street1 : " + elementLibrary.getText(street1InputBox));
		}
	}

	@Then("^Validate street2 field saved as \"(.*?)\"$")
	public void validateStreet2Field(String Street2) throws Throwable {

		if (elementLibrary.getAttribute(street2InputBox, "Value").equalsIgnoreCase(Street2)) {
			log.info("The street2 saved successfully");
		} else {

			Assert.fail(
					"Expected street2 : " + Street2 + " Actual street2 : " + elementLibrary.getText(street2InputBox));
		}
	}

	@Then("^Validate city field saved as \"(.*?)\"$")
	public void validateCityField(String City) throws Throwable {
		if (elementLibrary.getAttribute(cityInputBox, "Value").equalsIgnoreCase(City)) {
			log.info("The City saved successfully");
		} else {

			Assert.fail("Expected City : " + City + " Actual City : " + elementLibrary.getText(cityInputBox));
		}
	}

	@Then("^Validate country field saved as \"(.*?)\"$")
	public void validateCountryField(String Country) throws Throwable {
		WebElement countrySelected = driver.findElement(By.xpath(
				"//div[@data-id='cs_address1_countryid.fieldControl-LookupResultsDropdown_cs_address1_countryid_selected_tag_text']"));
		if (countrySelected.getText().equalsIgnoreCase(Country)) {
			log.info("The Country saved successfully");
		} else {

			Assert.fail("Expected Country : " + Country + " Actual Country : " + countrySelected.getText());
		}
	}

	@Then("^Validate state field saved as \"(.*?)\"$")
	public void validateStateField(String State) throws Throwable {
		WebElement stateSelected = driver.findElement(By.xpath(
				"//div[@data-id='cs_address1_regionid.fieldControl-LookupResultsDropdown_cs_address1_regionid_selected_tag_text']"));

		if (stateSelected.getText().equalsIgnoreCase(State)) {
			log.info("The State saved successfully");
		} else {

			Assert.fail("Expected State : " + State + " Actual State : " + stateSelected.getText());
		}
	}

	@Then("^Validate zipcode field saved as \"(.*?)\"$")
	public void validateZipcodeField(String zipcode) throws Throwable {
		if (elementLibrary.getAttribute(zipcodeInputBox, "Value").equalsIgnoreCase(zipcode)) {
			log.info("The zipcode saved successfully");
		} else {

			Assert.fail(
					"Expected zipcode : " + zipcode + " Actual zipcode : " + elementLibrary.getText(zipcodeInputBox));
		}
	}

	@Then("^Validate official name field$")
	public void validateOfficialNameField() throws Throwable {
		if (elementLibrary.getAttribute(officialNameField, "Value").equalsIgnoreCase(newRelationshipName)) {
			log.info("The official name saved successfully");
		} else {

			Assert.fail("Expected official name : " + newRelationshipName + " Actual official name : "
					+ elementLibrary.getText(officialNameField));
		}
	}

	@And("^Search one relationship \"(.*?)\" to Open$")
	public void SearchOneRelationship(String relationshipRecord) throws Exception {
		Robot robot = new Robot();
		Thread.sleep(2000);
		elementLibrary.waitForElementToDisplay(relevanceSearchNew);
		elementLibrary.click(relevanceSearchNew);
		Thread.sleep(1000);
		elementLibrary.enterText(relevanceSearchNew, relationshipRecord);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);

//		elementLibrary.waitForElementToDisplay(okInErrorDialog);
//		Thread.sleep(1000);
//		elementLibrary.click(okInErrorDialog);
//		Thread.sleep(6000);
//		elementLibrary.waitForElementToDisplay(relevanceSearchNew);
//		elementLibrary.click(relevanceSearchNew);
//		Thread.sleep(1000);
//		elementLibrary.enterText(relevanceSearchNew, relationshipRecord);
//		Thread.sleep(1000);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(3000);

		elementLibrary.waitForElementToDisplay(fullNameForRelationshipRecord);
		elementLibrary.click(fullNameForRelationshipRecord);

//		browserLibrary.waitForLoad();
//		UIElement relevanceSearch = new UIElement("relevanceSearch", IdentifyBy.XPATH,
//				elementLibrary.getCellData("TabLabelOnContact.xls", "relevanceSearch"));
//		elementLibrary.click(relevanceSearch);
//		browserLibrary.waitForLoad();
//
//		UIElement relevanceSearchInput = new UIElement("relevanceSearchInput", IdentifyBy.ID,
//				elementLibrary.getCellData("TabLabelOnContact.xls", "relevanceSearchInput"));
//
//		elementLibrary.waitForElementToDisplay(relevanceSearchInput);
//		System.out.println("Relevance Search page open successfully");
//		log.info("Relevance Search page open successfully");
//		elementLibrary.enterText(relevanceSearchInput, relationshipRecord);
//
//		UIElement relevanceSearchButton = new UIElement("relevanceSearchButton", IdentifyBy.ID,
//				elementLibrary.getCellData("TabLabelOnContact.xls", "relevanceSearchButton"));
//
//		elementLibrary.click(relevanceSearchButton);
//		UIElement secondRelationship = new UIElement("secondRelationship", IdentifyBy.ID,
//				elementLibrary.getCellData("TabLabelOnContact.xls", "secondRelationship"));
//
//		elementLibrary.waitForElementToDisplay(secondRelationship);
//		elementLibrary.click(secondRelationship);
//
		Thread.sleep(3000);
		UIElement addActivityButton = new UIElement("addActivityButton", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "addActivityButton"));
		elementLibrary.waitForElementToDisplay(addActivityButton);

		Thread.sleep(1000);
		UIElement peopleTabInRelationship = new UIElement("peopleTabInRelationship", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "peopleTabInRelationship"));
		elementLibrary.waitForElementToDisplay(peopleTabInRelationship);
		Thread.sleep(3000);
		elementLibrary.click(peopleTabInRelationship);
		Thread.sleep(1000);
	}

	@Then("^Open new contact page \"(.*?)\"$")
	public void OpeNewConatctPage(String firstName) throws Exception {

		WebdriverService webdriverServiceLibrary = getWebDriverService();
		WebDriver driver = webdriverServiceLibrary.getWebDriver();
		driver.switchTo().frame("WebResource_Custom_AllContacts");

		Thread.sleep(2000);
		UIElement addContact = new UIElement("addContact", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "addContact"));
		elementLibrary.waitForElementToDisplay(addContact);
		Thread.sleep(1000);
		elementLibrary.click(addContact);
		driver.switchTo().defaultContent();

		Thread.sleep(1000);
		UIElement searchMDMLabel = new UIElement("searchMDMLabel", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "searchMDMLabel"));
		elementLibrary.waitForElementToDisplay(searchMDMLabel);
		System.out.println("Open search MDM page successfully");

		driver.switchTo().frame("WebResource_MDM");
		UIElement firstNameInMDM = new UIElement("firstNameInMDM", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "firstNameInMDM"));
		elementLibrary.waitForElementToDisplay(firstNameInMDM);
		elementLibrary.click(firstNameInMDM);
		elementLibrary.enterText(firstNameInMDM, firstName);
		System.out.println("Fill value in First Name on MDM page successfully");

		UIElement lastNameInMDM = new UIElement("lastNameInMDM", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "lastNameInMDM"));
		elementLibrary.waitForElementToDisplay(lastNameInMDM);
		elementLibrary.click(lastNameInMDM);
		elementLibrary.enterText(lastNameInMDM, getDate());
		System.out.println("Fill value in Last Name on MDM page successfully");

		UIElement searchButtonInMDM = new UIElement("searchButtonInMDM", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "searchButtonInMDM"));
		elementLibrary.click(searchButtonInMDM);

		UIElement createButtonInMDM = new UIElement("createButtonInMDM", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "createButtonInMDM"));
		elementLibrary.waitForElementToDisplay(createButtonInMDM);
		elementLibrary.click(createButtonInMDM);
		driver.switchTo().defaultContent();

		UIElement summaryLabelOnNewContact = new UIElement("summaryLabelOnNewContact", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "summaryLabelOnNewContact"));
		elementLibrary.waitForElementToDisplay(summaryLabelOnNewContact);
		System.out.println("Open new contact page successfully");
	}

	@Then("^Fill in phone label \"(.*?)\"$")
	public void fillInPhoneLabel(String phone) throws Exception {
		UIElement phoneLabel = new UIElement("phoneLabel", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "phoneLabel"));
		WebDriver webdriver = webdriverServiceLibrary.getWebDriver();
		Actions action = new Actions(webdriver);
		WebElement keyPeople = webdriver.findElement(By.xpath("//h2[@title='Key People']"));
		action.moveToElement(keyPeople).build().perform();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		elementLibrary.waitForElementToDisplay(phoneLabel);
		elementLibrary.click(phoneLabel);
		elementLibrary.enterText(phoneLabel, phone);
		System.out.println("Fill value in phone label");
	}

	@Then("^Fill in email label \"(.*?)\"$")
	public void fillValueInEmailLabel(String email) throws IOException {
		UIElement emailLabel = new UIElement("emailLabel", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "emailLabel"));
		elementLibrary.click(emailLabel);
		elementLibrary.enterText(emailLabel, email);
		System.out.println("Fill value in email label");
	}

	@Then("^Save new contact \"(.*?)\"$")
	public void saveNewContact(String firstName) throws Exception {
		UIElement saveButton = new UIElement("saveButton", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "saveButton"));
		UIElement firstNameLabelForContact = new UIElement("firstNameLabelForContact", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "firstNameLabelForContact"));
		UIElement lastNameLabelForContact = new UIElement("lastNameLabelForContact", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "lastNameLabelForContact"));

		elementLibrary.click(saveButton);
		browserLibrary.waitForLoad();
		Thread.sleep(2000);

		WebDriver webdriver = webdriverServiceLibrary.getWebDriver();
		Actions action = new Actions(webdriver);
		WebElement basicInfo = webdriver.findElement(By.xpath("//h2[@title='Basic Info']"));
		action.moveToElement(basicInfo).build().perform();
		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		if (elementLibrary.getAttribute(firstNameLabelForContact, "title").equalsIgnoreCase(firstName)) {
			System.out.println("The Value of First Name displays as excepted");
		} else {
			System.out.println("The Value of First Name not display as excepted");
		}

		if (elementLibrary.getAttribute(lastNameLabelForContact, "title").equalsIgnoreCase(getDate())) {
			System.out.println("The Value of Last Name displays as excepted");
		} else {
			System.out.println("The Value of Last Name not display as excepted");
		}

		// elementLibrary.waitForElementToDisplay();
		System.out.println("Save new contact succesffully");
	}

//	public String getDate() {
//		SimpleDateFormat sdf = new SimpleDateFormat();
//		sdf.applyPattern("yyyyMMddHHmmss");
//		Date date = new Date();
//		System.out.println("Now time:" + sdf.format(date));
//		return sdf.format(date);
//	}

	// TC8
	// author:Oscar
	@Then("^Fill in remarks label \"(.*?)\"$")
	public void fillInRemarksLabel(String remarks) throws Exception {
		UIElement remarksLabel = new UIElement("remarksLabel", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "remarksLabel"));
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);

		elementLibrary.waitForElementToDisplay(remarksLabel);
		elementLibrary.click(remarksLabel);
		browserLibrary.waitForLoad();
		elementLibrary.enterText(remarksLabel, remarks);

		System.out.println("fill value in remarks label");
		// driver.switchTo().;
	}

	@Then("^Fill in nick name label \"(.*?)\"$")
	public void fillInNickName(String nickName) throws Exception {
		UIElement nickNameLabel = new UIElement("nickNameLabel", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "nickNameLabel"));
		elementLibrary.waitForElementToDisplay(nickNameLabel);
		elementLibrary.click(nickNameLabel);
		elementLibrary.enterText(nickNameLabel, nickName);
		browserLibrary.waitForLoad();
	}

	@Then("^Fill in job title label \"(.*?)\"$")
	public void fillInJobTitle(String jobTitle) throws Exception {
		UIElement jobTitleLabel = new UIElement("jobTitleLabel", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "jobTitleLabel"));
		elementLibrary.click(jobTitleLabel);
		elementLibrary.enterText(jobTitleLabel, jobTitle);
		browserLibrary.waitForLoad();
	}

	@Then("^Save and verify contact \"(.*?)\"$")
	public void saveAndVerifyNewContact(String firstName) throws Exception {
		UIElement saveButton = new UIElement("saveButton", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "saveButton"));
		UIElement firstNameLabelForContact = new UIElement("firstNameLabelForContact", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "firstNameLabelForContact"));
		UIElement lastNameLabelForContact = new UIElement("lastNameLabelForContact", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "lastNameLabelForContact"));
		UIElement phoneLabel = new UIElement("phoneLabel", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "phoneLabel"));
		UIElement emailLabel = new UIElement("emailLabel", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "emailLabel"));
		UIElement nickNameLabel = new UIElement("nickNameLabel", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "nickNameLabel"));
		UIElement jobTitleLabel = new UIElement("jobTitleLabel", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "jobTitleLabel"));
		UIElement remarksLabel = new UIElement("remarksLabel", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "remarksLabel"));

		elementLibrary.click(saveButton);
		browserLibrary.waitForLoad();
		Thread.sleep(5000);

		WebDriver webdriver = webdriverServiceLibrary.getWebDriver();
		Actions action = new Actions(webdriver);
		WebElement basicInfo = webdriver.findElement(By.xpath("//h2[@title='Basic Info']"));
		action.moveToElement(basicInfo).build().perform();
		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		if (elementLibrary.getAttribute(firstNameLabelForContact, "title").equalsIgnoreCase(firstName)) {
			System.out.println("The Value of First Name displays as excepted");
		} else {
			System.out.println("The Value of First Name not display as excepted");
		}

		if (elementLibrary.getAttribute(lastNameLabelForContact, "title").equalsIgnoreCase(getDate())) {
			System.out.println("The Value of Last Name displays as excepted");
		} else {
			System.out.println("The Value of Last Name not display as excepted");
		}

		if (elementLibrary.getAttribute(phoneLabel, "title").equalsIgnoreCase("+1 666-777-8888")) {
			System.out.println("The Value of phone label displays as excepted");
		} else {
			System.out.println("The Value of phone label not display as excepted");
		}

		if (elementLibrary.getAttribute(emailLabel, "title").equalsIgnoreCase("b-larson@mmm.com")) {
			System.out.println("The Value of email label displays as excepted");
		} else {
			System.out.println("The Value of email label not display as excepted");
		}

		if (elementLibrary.getAttribute(jobTitleLabel, "title").equalsIgnoreCase("jan Yeomans Asst")) {
			System.out.println("The Value of job Title label displays as excepted");
		} else {
			System.out.println("The Value of job Title label not display as excepted");
		}

		if (elementLibrary.getAttribute(nickNameLabel, "title").equalsIgnoreCase("Barb")) {
			System.out.println("The Value of nickName label displays as excepted");
		} else {
			System.out.println("The Value of nickName label not display as excepted");
		}

		if (elementLibrary.getAttribute(remarksLabel, "title").equalsIgnoreCase("Worldwide Capital Markets")) {
			System.out.println("The Value of remarks label displays as excepted");
		} else {
			System.out.println("The Value of remarks label not display as excepted");
		}

		// elementLibrary.waitForElementToDisplay();
		System.out.println("Save new contact succesffully");
	}

	// TC9
	// author:Oscar
	@And("^Open new phone call page$")
	public void clickNewPhoneCall() throws IOException {
		// UIElement addActivity = new UIElement("addActivity",
		// IdentifyBy.XPATH,elementLibrary.getCellData("TabLabelOnContact.xls",
		// "saveButton"));
		elementLibrary.waitForElementToDisplay(addActivity);
		elementLibrary.click(addActivity);
		elementLibrary.waitForElementToDisplay(phoneCallButton);
		elementLibrary.click(phoneCallButton);
	}

	@Then("^Fill in subject label \"(.*?)\"$")
	public void fillInSubjectLabel(String phoneCallName) throws Exception {
		String appName = EnvironmentConfig.getAPP();
		WebDriver driver = webdriverServiceLibrary.getWebDriver();
		Set<String> childids = driver.getWindowHandles();

		for (String s : childids) {
			Thread.sleep(2000);
			if (appName.equals("Institutional")) {
				if (driver.switchTo().window(s).getTitle()
						.contains("Phone Call: Phone Call: New Phone Call - Dynamics 365")) {
					// UIElement newPhoneCall = new UIElement("newPhoneCall",
					// IdentifyBy.XPATH,elementLibrary.getCellData("PhoneCallLabel.xls",
					// "newPhoneCall"));
					elementLibrary.waitForElementToDisplay(newPhoneCall);
					System.out.println("Open new phone call page successfully");

					newPhoneCallSubject = "Institutional" + phoneCallName + getDate();
					phoneCallNameA = getDate();
					phoneCallNameValue = phoneCallName + phoneCallNameA;
					elementLibrary.waitForElementToDisplay(phoneCallSubjectLabel);
					elementLibrary.click(phoneCallSubjectLabel);
					elementLibrary.enterText(phoneCallSubjectLabel, newPhoneCallSubject);
					System.out.println("Fill in Subject label successfully");
					Thread.sleep(1000);
					elementLibrary.waitForElementToDisplay(whoAmITalkingTo);
					elementLibrary.selectDropdownBasedOnIndex(whoAmITalkingTo, 2);
					System.out.println("Select Voicemail in who Am I Talking To label successfully");
					Thread.sleep(1000);

					driver.switchTo().defaultContent();
					break;
				}
			}

			else if (appName.equals("Hybrid")) {
				if (driver.switchTo().window(s).getTitle()
						.contains("Phone Call: Phone Call Hybrid: New Phone Call - Dynamics 365")) {
					// UIElement newPhoneCall = new UIElement("newPhoneCall",
					// IdentifyBy.XPATH,elementLibrary.getCellData("PhoneCallLabel.xls",
					// "newPhoneCall"));
					elementLibrary.waitForElementToDisplay(newPhoneCall);
					System.out.println("Open new phone call page successfully");

					newPhoneCallSubject = "Hybrid" + phoneCallName + getDate();
					phoneCallNameA = getDate();
					phoneCallNameValue = phoneCallName + phoneCallNameA;
					elementLibrary.waitForElementToDisplay(phoneCallSubjectLabel);
					elementLibrary.click(phoneCallSubjectLabel);
					elementLibrary.enterText(phoneCallSubjectLabel, newPhoneCallSubject);
					System.out.println("Fill in Subject label successfully");
					Thread.sleep(1000);
					elementLibrary.waitForElementToDisplay(whoAmITalkingTo);
					elementLibrary.selectDropdownBasedOnIndex(whoAmITalkingTo, 2);
					System.out.println("Select Voicemail in who Am I Talking To label successfully");
					Thread.sleep(1000);

					driver.switchTo().defaultContent();
					break;
				}
			} else {
				if (driver.switchTo().window(s).getTitle()
						.contains("Phone Call: Phone Call Retail: New Phone Call - Dynamics 365")) {
					elementLibrary.waitForElementToDisplay(newPhoneCall);
					System.out.println("Open new phone call page successfully");
					newPhoneCallSubject = "Retail" + phoneCallName + getDate();
					phoneCallNameA = getDate();
					phoneCallNameValue = phoneCallName + phoneCallNameA;
					elementLibrary.waitForElementToDisplay(phoneCallSubjectLabel);
					elementLibrary.click(phoneCallSubjectLabel);
					elementLibrary.enterText(phoneCallSubjectLabel, newPhoneCallSubject);
					System.out.println("Fill in Subject label successfully");
					Thread.sleep(1000);
					elementLibrary.waitForElementToDisplay(whoAmITalkingTo);
					elementLibrary.selectDropdownBasedOnIndex(whoAmITalkingTo, 2);
					System.out.println("Select Voicemail in who Am I Talking To label successfully");
					Thread.sleep(1000);
					driver.switchTo().defaultContent();
					break;
				}
			}
		}
	}

	@Then("^Save and verify phone call$")
	public void saveAndVerifyNewCreationPhoneCall() throws Exception {
//			elementLibrary.waitForElementToDisplay(phoneCallSaveButton);
//			elementLibrary.click(phoneCallSaveButton);
//			Thread.sleep(1000);
//
//			if (elementLibrary.getAttribute(phoneCallSubjectLabel, "value").equalsIgnoreCase(phoneCallNameValue)) {
//				System.out.println("Create new phone call successfully");
//			} else {
//				System.out.println("create new phone call unsuccessfully");
//			}

//		Thread.sleep(1000);
//		WebDriver webdriver = webdriverServiceLibrary.getWebDriver();
//		Actions action = new Actions(webdriver);
//		WebElement externalAttendeesPC = webdriver.findElement(By.xpath("//h2[@title='Additional Relationships']"));
//		action.moveToElement(externalAttendeesPC).build().perform();

		Thread.sleep(2000);
		elementLibrary.waitForElementToDisplay(phoneCallSaveButton);
		elementLibrary.click(phoneCallSaveButton);
		Thread.sleep(7000);

		phoneCallNameTest = elementLibrary.getAttribute(phoneCallNameOnTop, "title");

		if (elementLibrary.getAttribute(phoneCallNameOnTop, "title").equalsIgnoreCase(newPhoneCallSubject)) {
			System.out.println("Create new phone call successfully");
		} else {
			System.out.println("create new phone call unsuccessfully");
		}
		System.out.println(phoneCallNameTest);
		System.out.println(newPhoneCallSubject);

		Thread.sleep(2000);

	}

	// TC10
	// author:Oscar
	@Then("^update labels in conatct page \"(.*?)\"$")
	public void updateLabelInContactPage(String newEmail) throws Exception {
		Thread.sleep(6000);
		UIElement emailLabel = new UIElement("emailLabel", IdentifyBy.XPATH,
				elementLibrary.getCellData("TabLabelOnContact.xls", "emailLabel"));
		WebElement emailField = driver
				.findElement(By.xpath("//input[@data-id='emailaddress1.fieldControl-mail-text-input']"));
		emailField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Thread.sleep(1000);
		emailField.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(4000);
		elementLibrary.enterText(emailField, newEmail);
		System.out.println("Fill value in email label");
		elementLibrary.click(saveButton);
		browserLibrary.waitForLoad();
		Thread.sleep(1000);

		if (elementLibrary.getAttribute(emailLabel, "value").equalsIgnoreCase(newEmail)) {
			System.out.println("Edit email label of contact record successfully");
		} else {
			System.out.println("Edit email label of contact record unsuccessfully");
		}
	}

	// TC11
	// author:Oscar
	@And("^Open new INST Opportunity page$")
	public void openNewInstOpp() throws Exception {
		String appName = EnvironmentConfig.getAPP();
		WebDriver driver = webdriverServiceLibrary.getWebDriver();
		// Set<String> childids = driver.getWindowHandles();
		// for (String s: childids) {
		Thread.sleep(2000);
		if (appName.equals("Institutional")) {
			Thread.sleep(2000);
			elementLibrary.waitForElementToDisplay(addOpportunity);
			elementLibrary.click(addOpportunity);
			Thread.sleep(2000);
			elementLibrary.waitForElementToDisplay(newInstOpportunityLabel);
			System.out.println("Open new INST opportunity page successfully in Institutional app");
			driver.switchTo().defaultContent();
			// break;
		} else {
			if (appName.equals("Hybrid")) {
				Thread.sleep(2000);
				elementLibrary.waitForElementToDisplay(addInstOpportunity);
				elementLibrary.click(addInstOpportunity);
				Thread.sleep(2000);
				elementLibrary.waitForElementToDisplay(newInstOpportunityLabel);
				System.out.println("Open new INST opportunity page successfully in Hybrid app");
				driver.switchTo().defaultContent();
			} else {
				System.out.println("Open new INST opportunity page unsuccessfully in Hybrid app");
			}
		}
	}
//				} else {
//					Thread.sleep(2000);
//					elementLibrary.waitForElementToDisplay(addInstOpportunity);
//					System.out.println("Should not be display Add Opportunity button in relationship record page on Retaill app");
//					driver.switchTo().defaultContent();
//					if (IsElementPresent(By.xpath("//li[@aria-label='Add Institutional Opportunity']"))) {
//						
//					}
//					

	@And("^Fill in INST opp name$")
	public void fillInINSTOppName() throws Exception {
		elementLibrary.waitForElementToDisplay(instOpportunityName);
		instOppNameA = getDate();
		instOppNameValue = "Test Opp" + instOppNameA;
		String instOppNameValueA = instOppNameValue;
		Thread.sleep(3000);
		elementLibrary.click(instOpportunityName);
		Thread.sleep(1000);
		elementLibrary.enterText(instOpportunityName, instOppNameValue);
		Thread.sleep(1000);
		if (elementLibrary.getAttribute(instOpportunityName, "value").equalsIgnoreCase(instOppNameValueA)) {
			System.out.println("Fill in value in Opportunity Name successfully");
		} else {
			System.out.println("Fill in value in Opportunity Name unsuccessfully");
		}
		System.out.println(instOppNameValue);
		System.out.println(instOppNameValueA);
	}

	@And("^Select in Consulting Firm / OCIO Involvement$")
	public void selectInConsultingFirmOCIO() throws Exception {
		// Robot robot = new Robot();
		// robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);

		elementLibrary.waitForElementToDisplay(consultingfirmOcioInvolvement);
		elementLibrary.selectDropdownBasedOnIndex(consultingfirmOcioInvolvement, 2);
		if (elementLibrary.getAttribute(consultingfirmOcioInvolvement, "title").equalsIgnoreCase("No")) {
			System.out.println("Select No in Consulting Firm / OCIO Involvement successfully");
		} else {
			System.out.println("Select No in Consulting Firm / OCIO Involvement unsuccessfully");
		}
	}

	@And("^Select in Investment Pool \"(.*?)\"$")
	public void selectInInvestmentPool(String investmentPoolItem) throws Exception {
		Robot robot = new Robot();
		Thread.sleep(1000);
		elementLibrary.click(investmentPool);
		elementLibrary.enterTextUsingSendkeys(investmentPool, investmentPoolItem);
		// Thread.sleep(1000);
		// elementLibrary.click(investmentPoolSearch);
		Thread.sleep(3000);
		// elementLibrary.click(definedBenefitPlanItem);
		// elementLibrary.sendKeys(Keys.TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
	}

	@Then("^Save and verify inst opportunity$")
	public void saveAndVerifyInstOpp() throws Exception {
		String instOppNameValueA = instOppNameValue;
		System.out.println("ValueA is" + instOppNameValueA);
		elementLibrary.click(instOppSaveButton);
		Thread.sleep(11000);
		instOppNameValueB = elementLibrary.getAttribute(instOppTitleName, "title");
		System.out.println("ValueB is" + instOppNameValueB);
		if (elementLibrary.getAttribute(instOppTitleName, "title").equalsIgnoreCase(instOppNameValueA)) {
			System.out.println("Create new inst Opportunity record successfully");
		} else {
			System.out.println("Create new inst Opportunity record unsuccessfully");
		}
		Thread.sleep(1000);

	}

	// TC15
	// author:Oscar
	@And("^Fill in Strategy/Product \"(.*?)\"$")
	public void fillInStrategyProduct(String strategyProductValue) throws Exception {
		Robot robot = new Robot();
		elementLibrary.waitForElementToDisplay(strategyProduct);
		elementLibrary.click(strategyProduct);
		Thread.sleep(1000);
		elementLibrary.enterTextUsingSendkeys(strategyProduct, strategyProductValue);
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

//		    if (elementLibrary.getAttribute(strategyProductField, "title").equalsIgnoreCase(strategyProductValue)) {
//				System.out.println("Fill value in strategy/Product field successfully");
//			} else {
//				System.out.println("Fill value in strategy/Product field unsuccessfully");
//			}

	}

	@And("^Fill in Est Close Date \"(.*?)\"$")
	public void fillInEstCloseDate(String estCloseDateValue) throws Exception {
		elementLibrary.waitForElementToDisplay(estCloseDate);
		// elementLibrary.click(estCloseDate);
		Thread.sleep(1000);
		elementLibrary.enterTextUsingSendkeys(estCloseDate, estCloseDateValue);

		// ((WebElement) estCloseDate).sendKeys("12/28/2020");
	}

	@And("^Fill in Est Size MM \"(.*?)\"$")
	public void fillInEstSize(String estSizeMMValue) throws Exception {
		Thread.sleep(1000);
		elementLibrary.waitForElementToDisplay(estSize);
		elementLibrary.click(estSize);
		Thread.sleep(1000);
		elementLibrary.enterText(estSize, estSizeMMValue);
	}

	@And("^Fill in Description \"(.*?)\"$")
	public void fillInDescription(String descriptionValue) throws Exception {
		Thread.sleep(1000);
		elementLibrary.waitForElementToDisplay(descriptionField);
		elementLibrary.click(descriptionField);
		Thread.sleep(1000);
		elementLibrary.enterText(descriptionField, descriptionValue);
	}

	@Then("^Validate value in Strategy/Product \"(.*?)\"$")
	public void validateValueInStrategyProduct(String strategyProductValue) throws Exception {
		if (elementLibrary.getAttribute(strategyProductContect, "title").equalsIgnoreCase(strategyProductValue)) {
			log.info("Save value in Strategy/Product successfully");
		} else {
			Assert.fail("Save value in Strategy/Product unsuccessfully");
		}
	}

	@Then("^Validate value in Est Close Date \"(.*?)\"$")
	public void validateValueInEstCloseDate(String estCloseDateValue) throws Exception {
		if (elementLibrary.getAttribute(estCloseDate, "value").equalsIgnoreCase(estCloseDateValue)) {
			log.info("Save value in Est Close Date successfully");
		} else {
			Assert.fail("Save value in Est Close Date unsuccessfully");
		}
	}

	@Then("^Validate value in Est Size MM \"(.*?)\"$")
	public void validateValueInEstSiezMM(String estSizeMMValue) throws Exception {
		if (elementLibrary.getAttribute(estSize, "title").equalsIgnoreCase("$19.000")) {
			log.info("Save value in Est Size(MM) successfully");
		} else {
			Assert.fail("Save value in Est Size(MM) unsuccessfully");
		}
	}

	@Then("^Validate value in Investment Pool \"(.*?)\"$")
	public void validateValueInInvestmentPool(String investmentPoolItem) throws Exception {
		if (elementLibrary.getAttribute(investmentPoolContect, "title").equalsIgnoreCase(investmentPoolItem)) {
			log.info("Save value in Investment Pool successfully");
		} else {
			Assert.fail("Save value in Investment Pool unsuccessfully");
		}
	}

//	   @Then("Validate value in Description \"(.*?)\"$")
//	   public void validateValueInDescription(String descriptionValue) throws Exception{
//			if (elementLibrary.getAttribute(descriptionField, "text").equalsIgnoreCase(descriptionValue)) {
//				log.info("Save value in Description successfully");
//			} else {
//				Assert.fail("Save value in Description unsuccessfully");
//			}
//		}

	public String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("yyyyMMddHHmmss");
		Date date = new Date();
		System.out.println("Now time:" + sdf.format(date));
		return sdf.format(date);
	}

	@And("^Click Task button under Add Activity drop down$")
	public void clickTaskButton() throws IOException {
		elementLibrary.waitForElementToDisplay(addActivity);
		elementLibrary.click(addActivity);
		elementLibrary.waitForElementToDisplay(taskButton);
		elementLibrary.click(taskButton);
	}

	@And("Input field for Subject as \"(.*?)\"$")
	public void inputSubject(String Subject) throws Throwable {
		elementLibrary.waitForElementToDisplay(taskSubjectInputBox);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmss");
		String formattedDate = sdf.format(date);
		newTaskSubject = Subject + formattedDate;
		elementLibrary.click(taskSubjectInputBox);
		elementLibrary.enterText(taskSubjectInputBox, newTaskSubject);

	}

	@And("Input field for primary contact as \"(.*?)\"$")
	public void inputPrimaryContactForTask(String primaryContact) throws Throwable {
		Robot robot = new Robot();
		elementLibrary.mouseOver(taskPrimaryContactInputBox);
		elementLibrary.enterText(taskPrimaryContactInputBox, primaryContact);
		Thread.sleep(10000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
	}

	@And("^Input field for Due Date as \"(.*?)\"$")
	public void selectDueDate(String DueDate) throws Throwable {
		elementLibrary.enterText(taskDueDate, DueDate);
		Thread.sleep(2000);
	}

	@And("^Input field for Due Time as \"(.*?)\"$")
	public void selectDueTime(String DueTime) throws Throwable {

		elementLibrary.click(clockIcon);
		Thread.sleep(2000);
		WebElement dueTimeVlue = driver.findElement(By.xpath("//button[@id='scheduledend_fabric_combobox-list0']"));
		elementLibrary.click(dueTimeVlue);
		Thread.sleep(3000);

	}

	@And("^Input field for Duration as \"(.*?)\"$")
	public void selectDuration(String duration) throws Throwable {
		WebElement durationInput = driver
				.findElement(By.xpath("//input[@data-id='actualdurationminutes.fieldControl-duration-combobox-text']"));
		elementLibrary.click(durationInput);
		Thread.sleep(2000);
		durationInput.sendKeys(Keys.CONTROL, "a");
		durationInput.sendKeys(Keys.DELETE);
		Thread.sleep(2000);
		elementLibrary.enterText(durationInput, duration);
		Thread.sleep(2000);
	}

	@And("^Input field for Description as \"(.*?)\"$")
	public void inputDescriptionForTask(String description) throws Throwable {
		elementLibrary.mouseOver(taskDescriptionInputBox);
		elementLibrary.enterText(taskDescriptionInputBox, description);
	}

	@Then("^Click SaveClose button$")
	public void clickSaveCloseButton() throws Throwable {
		elementLibrary.click(taskSaveCloseButton);
		Thread.sleep(5000);
	}

	@And("^Open the created task record$")
	public void openCreatedTaskRecord() throws Throwable {
		UIElement recentTab = new UIElement("recentTab", IdentifyBy.XPATH, "//span[contains(text(),'Recent')]");
		UIElement newTaskRecord = new UIElement("newTaskRecord", IdentifyBy.XPATH,
				"//span[contains(text()," + "'" + newTaskSubject + "')]");
		elementLibrary.click(recentTab);
		Thread.sleep(3000);
		elementLibrary.click(newTaskRecord);

	}

	@Then("^Validate subject fields saved successfully$")
	public void validateSubjectFieldForTask() throws Throwable {

		if (elementLibrary.getAttribute(taskSubjectInputBox, "Value").equalsIgnoreCase(newTaskSubject)) {
			log.info("The subject saved successfully");
		} else {

			Assert.fail("Expected subject : " + newTaskSubject + " Actual subject : "
					+ elementLibrary.getAttribute(taskSubjectInputBox, "Value"));
		}

	}

	@Then("^Validate primary contact saved successfully as \"(.*?)\"$")
	public void validatePrimaryContactForTask(String primaryContact) throws Throwable {
		if (elementLibrary.getAttribute(taskPrimaryContactSelected, "title").equalsIgnoreCase(primaryContact)) {
			log.info("The primary contact saved successfully");
		} else {

			Assert.fail("Expected primary contact : " + primaryContact + " Actual primary contact : "
					+ elementLibrary.getAttribute(taskPrimaryContactSelected, "title"));
		}
	}

	@Then("^Validate Due date fields as \"(.*?)\" saved successfully$")
	public void validateDueDateFieldForTask(String DueDate) throws Throwable {
		if (elementLibrary.getAttribute(taskDueDate, "Value").equalsIgnoreCase(DueDate)) {
			log.info("The Due Date saved successfully");
		} else {

			Assert.fail("Expected Due Date : " + DueDate + " Actual Due Date : "
					+ elementLibrary.getAttribute(taskDueDate, "Value"));
		}
	}

	@Then("^Validate Due time fields as \"(.*?)\" saved successfully$")
	public void validateDueTimeFieldForTask(String DueTime) throws Throwable {
		if (elementLibrary.getAttribute(taskDueTime, "Value").equalsIgnoreCase(DueTime)) {
			log.info("The Due Time saved successfully");
		} else {

			Assert.fail("Expected Due Time : " + DueTime + " Actual Due Time : "
					+ elementLibrary.getAttribute(taskDueTime, "Value"));
		}
	}

	@Then("^Validate duration as \"(.*?)\" saved successfully$")
	public void validateDurationForTask(String duration) throws Throwable {
		if (elementLibrary.getAttribute(taskDurationInputBox, "Value").equalsIgnoreCase(duration)) {
			log.info("The duration saved successfully");
		} else {

			Assert.fail("Expected duration : " + duration + " Actual duration : "
					+ elementLibrary.getAttribute(taskDurationInputBox, "Value"));
		}
	}

	@Then("^Validate description as \"(.*?)\" saved successfully$")
	public void validateDescriptionForTask(String description) throws Throwable {
		WebElement taskDescriptionInputBox = driver
				.findElement(By.xpath("//textarea[@data-id='description.fieldControl-text-box-text']"));
		if (taskDescriptionInputBox.getText().equalsIgnoreCase(description)) {
			log.info("The description saved successfully");
		} else {

			Assert.fail("Expected description : " + description + " Actual description : "
					+ taskDescriptionInputBox.getText());
		}
	}

	@Then("^Validate relationship fields as \"(.*?)\" saved successfully$")
	public void validaterelationshipFieldForTask(String relationshipRecord) throws Throwable {
		UIElement relationshipValueForTask = new UIElement("relationshipValueForTask", IdentifyBy.XPATH,
				("//div[@data-id='cs_accountid.fieldControl-LookupResultsDropdown_cs_accountid_selected_tag']"));

		if (elementLibrary.getAttribute(relationshipValueForTask, "aria-label").equalsIgnoreCase(relationshipRecord)) {
			log.info("The relationship field saved successfully");
		} else {

			Assert.fail("Expected relationship field : " + relationshipRecord + " Actual relationship field : "
					+ elementLibrary.getAttribute(relationshipValueForTask, "aria-label"));
		}
	}

	@And("^Click Meeting button under Add Activity drop down$")
	public void clickMeetingButton() throws IOException {
		elementLibrary.waitForElementToDisplay(addActivity);
		elementLibrary.click(addActivity);
		elementLibrary.waitForElementToDisplay(meetingButton);
		elementLibrary.click(meetingButton);
	}

	@And("Input subjcet field as \"(.*?)\"$")
	public void inputSubjectFieldForMeeting(String Subject) throws Throwable {

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		elementLibrary.waitForElementToDisplay(subjectFieldForMeeting);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmss");
		String formattedDate = sdf.format(date);
		newMeetingSubject = Subject + formattedDate;
		elementLibrary.click(subjectFieldForMeeting);
		elementLibrary.enterText(subjectFieldForMeeting, newMeetingSubject);
		Thread.sleep(2000);
	}

	@And("^Input primary attendee as \"(.*?)\"$")
	public void inputPrimaryAttendee(String primaryAttendee) throws Throwable {
		Robot robot = new Robot();

		elementLibrary.mouseOver(inputFieldForPrimaryAttendee);
		elementLibrary.enterText(inputFieldForPrimaryAttendee, primaryAttendee);
		Thread.sleep(10000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
	}

	@And("^Input start date as \"(.*?)\"$")
	public void inputStartDateForMeeting(String startDate) throws Throwable {
		WebElement startDateInput = driver
				.findElement(By.xpath("//input[@data-id='scheduledstart.fieldControl-date-time-input']"));
		elementLibrary.click(startDateInput);
		Thread.sleep(2000);
		elementLibrary.click(startDateInput);
		Thread.sleep(1000);
		startDateInput.sendKeys(Keys.CONTROL, "a");
		startDateInput.sendKeys(Keys.DELETE);
		Thread.sleep(2000);
		elementLibrary.enterText(startDateInput, startDate);
		Thread.sleep(2000);
	}

	@And("^Input start time as \"(.*?)\"$")
	public void inputStartTimeForMeeting(String startTime) throws Throwable {
		WebElement startTimeInput = driver.findElement(By.xpath("//input[@id='scheduledstart_fabric_combobox-input']"));
		elementLibrary.click(startTimeInput);
		Thread.sleep(2000);
		startTimeInput.sendKeys(Keys.CONTROL, "a");
		startTimeInput.sendKeys(Keys.DELETE);
		Thread.sleep(2000);
		elementLibrary.enterText(startTimeInput, startTime);
		Thread.sleep(2000);
	}

	@And("^Input end date as \"(.*?)\"$")
	public void inputEndDateForMeeting(String endDate) throws Throwable {
		WebElement endDateInput = driver
				.findElement(By.xpath("//input[@data-id='scheduledend.fieldControl-date-time-input']"));
		elementLibrary.click(endDateInput);
		Thread.sleep(2000);
		elementLibrary.click(endDateInput);
		Thread.sleep(1000);
		endDateInput.sendKeys(Keys.CONTROL, "a");
		endDateInput.sendKeys(Keys.DELETE);
		Thread.sleep(2000);
		elementLibrary.enterText(endDateInput, endDate);
		Thread.sleep(2000);
	}

	@And("^Input end time as \"(.*?)\"$")
	public void inputEndTimeForMeeting(String endTime) throws Throwable {
		WebElement endTimeInput = driver.findElement(By.xpath("//input[@id='scheduledend_fabric_combobox-input']"));
		elementLibrary.click(endTimeInput);
		Thread.sleep(2000);
		endTimeInput.sendKeys(Keys.CONTROL, "a");
		endTimeInput.sendKeys(Keys.DELETE);
		Thread.sleep(2000);
		elementLibrary.enterText(endTimeInput, endTime);
		Thread.sleep(2000);
	}

	@And("^Select location$")
	public void selectLocation() throws Throwable {
		elementLibrary.selectDropdownBasedOnIndex(selectDropDownForLocation, 1);
	}

	@And("^Input city as \"(.*?)\"$")
	public void inputCityForMeeting(String city) throws Throwable {
		elementLibrary.click(cityFieldForMeeting);
		elementLibrary.enterText(cityFieldForMeeting, city);
	}

	@And("^Select engagement type$")
	public void selectEngagementType() throws Throwable {
		elementLibrary.selectDropdownBasedOnIndex(engagementTypeForMeeting, 1);
	}

	@And("^Input notes as \"(.*?)\"$")
	public void inputNotesForMeeting(String notes) throws Throwable {
		WebDriver webdriver = webdriverServiceLibrary.getWebDriver();
		Actions action = new Actions(webdriver);
		WebElement RTCForMeeting = webdriver.findElement(By.xpath("//h2[@title='Notes']"));
		action.moveToElement(RTCForMeeting).build().perform();
		Thread.sleep(1000);
		WebElement IframeNotes = driver.findElement(By.xpath("//iframe[@id='WebResource_RichtextEditnotes']"));
		elementLibrary.switchToFrame(IframeNotes);
		elementLibrary.enterText(notesForMeeting, notes);
		driver.switchTo().defaultContent();
	}

	@And("^Select activity purpose$")
	public void selectActivityPurposeForMeeting() throws Throwable {
		UIElement crossSellVaue = new UIElement("crossSellVaue", IdentifyBy.XPATH,
				("//span[text()='Operational Support']"));
		elementLibrary.click(crossSellVaue);

	}

	@And("^Select product as \"(.*?)\"$")
	public void selectProduct(String product) throws Throwable {
		//Robot robot = new Robot();
		UIElement productSearchBox = new UIElement("externalAttendeesSearchBox", IdentifyBy.XPATH,
				("(//input[@placeholder='Filter or press Enter to search'])"));
		UIElement markText = new UIElement("markText", IdentifyBy.XPATH, ("//div[@title='" + product + "']"));
		elementLibrary.enterText(productSearchBox, product);
		Thread.sleep(5000);
		WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Filter or press Enter to search']"));
		//robot.keyPress(KeyEvent.VK_ENTER);
		searchBox.sendKeys(Keys.ENTER);
		elementLibrary.waitForElementToDisplay(markText);
		elementLibrary.click(markText);

	}

	@And("^Select RTC$")
	public void selectRTCForMeeting() throws Throwable {
		WebDriver webdriver = webdriverServiceLibrary.getWebDriver();
		Actions action = new Actions(webdriver);
		WebElement RTCForMeeting = webdriver.findElement(By.xpath("//h2[@title='Reasons to Contact (RTC)']"));
		action.moveToElement(RTCForMeeting).build().perform();
		Thread.sleep(2000);
		UIElement rtcVaue = new UIElement("rtcVaue", IdentifyBy.XPATH, ("(//input[@class='wj-cell-check'])[1]"));
		WebElement IframeRTC = driver.findElement(By.xpath("//iframe[@id='WebResource_RTCs_UCIs']"));
		elementLibrary.switchToFrame(IframeRTC);
		elementLibrary.click(rtcVaue);
		driver.switchTo().defaultContent();
	}

	@And("^Select external attendees as \"(.*?)\"$")
	public void selectExternalAttendees(String externalAttendees) throws Throwable {
		UIElement externalAttendeesSearchBox = new UIElement("externalAttendeesSearchBox", IdentifyBy.XPATH,
				("(//input[@placeholder='Filter or press Enter to search'])[3]"));
		UIElement markText = new UIElement("markText", IdentifyBy.XPATH, ("//div[@title='" + externalAttendees + "']"));
		elementLibrary.enterText(externalAttendeesSearchBox, externalAttendees);
		Thread.sleep(2000);
		elementLibrary.click(markText);
	}

	@And("^Click save button to save record$")
	public void saveMeeting() throws Throwable {
		UIElement saveMeetingButton = new UIElement("saveMeetingButton", IdentifyBy.XPATH,
				("//button[@aria-label='Save']"));
		elementLibrary.click(saveMeetingButton);
		// Thread.sleep(10000);

		WebElement meetingTitle = driver.findElement(By.xpath("//h1[@title=" + "\'" + newMeetingSubject + "\'" + "]"));

		if (meetingTitle.isDisplayed()) {

			log.info("The new meeting saved successfully");
		} else {
			Assert.fail("The new meeting saved unsuccessfully");
		}
	}

	@Then("^Validate subject fields saved successfully for meeting$")
	public void validateSubjectFieldForMeeting() throws Throwable {
		if (elementLibrary.getAttribute(subjectFieldForMeeting, "Value").equalsIgnoreCase(newMeetingSubject)) {
			log.info("The subject saved successfully");
		} else {

			Assert.fail("Expected subject : " + newMeetingSubject + " Actual subject : "
					+ elementLibrary.getAttribute(subjectFieldForMeeting, "Value"));
		}
	}

	@Then("^Validate primary attendee as \"(.*?)\" saved successfully$")
	public void validatePrimaryAttendeeForMeeting(String primaryAttendee) throws Throwable {
		if (elementLibrary.getAttribute(meetingPrimaryAttendeeInputBox, "title").equalsIgnoreCase(primaryAttendee)) {
			log.info("The primary contact saved successfully");
		} else {

			Assert.fail("Expected primary contact : " + primaryAttendee + " Actual primary contact : "
					+ elementLibrary.getAttribute(meetingPrimaryAttendeeInputBox, "title"));
		}
	}

	@Then("^Validate start date as \"(.*?)\"$")
	public void validateStartDateForMeeting(String startDate) throws Throwable {
		WebElement startDateInput = driver
				.findElement(By.xpath("//input[@data-id='scheduledstart.fieldControl-date-time-input']"));
		if (startDateInput.getAttribute("value").equalsIgnoreCase(startDate)) {
			log.info("The start date saved successfully");
		} else {

			Assert.fail("Expected start date : " + startDate + " Actual start date : "
					+ startDateInput.getAttribute("value"));
		}
	}

	@Then("^Validate start time as \"(.*?)\"$")
	public void validateStartTimeForMeeting(String startTime) throws Throwable {
		WebElement startTimeInput = driver.findElement(By.xpath("//input[@id='scheduledstart_fabric_combobox-input']"));
		if (startTimeInput.getAttribute("value").equalsIgnoreCase(startTime)) {
			log.info("The start time saved successfully");
		} else {

			Assert.fail("Expected start time : " + startTime + " Actual start time : "
					+ startTimeInput.getAttribute("value"));
		}
	}

	@Then("^Validate end date as \"(.*?)\"$")
	public void validateEndDateForMeeting(String endDate) throws Throwable {
		WebElement endDateInput = driver
				.findElement(By.xpath("//input[@data-id='scheduledend.fieldControl-date-time-input']"));
		if (endDateInput.getAttribute("value").equalsIgnoreCase(endDate)) {
			log.info("The end date saved successfully");
		} else {

			Assert.fail("Expected end date : " + endDate + " Actual end date : " + endDateInput.getAttribute("value"));
		}
	}

	@Then("^Validate end time as \"(.*?)\"$")
	public void validateEndTimeForMeeting(String endTime) throws Throwable {
		WebElement endTimeInput = driver.findElement(By.xpath("//input[@id='scheduledend_fabric_combobox-input']"));
		if (endTimeInput.getAttribute("value").equalsIgnoreCase(endTime)) {
			log.info("The end time saved successfully");
		} else {

			Assert.fail("Expected end time : " + endTime + " Actual end time : " + endTimeInput.getAttribute("value"));
		}
	}

	@Then("^Validate location as \"(.*?)\"$")

	public void validateLocationForMeeting(String location) throws Throwable {

		if (elementLibrary.getAttribute(selectDropDownForLocation, "title").equalsIgnoreCase(location)) {
			log.info("The location saved successfully");
		} else {

			Assert.fail("Expected location : " + location + " Actual location : "
					+ elementLibrary.getAttribute(selectDropDownForLocation, "title"));
		}
	}

	@Then("^Validate city as \"(.*?)\"$")

	public void validateCityForMeeting(String city) throws Throwable {

		if (elementLibrary.getAttribute(cityFieldForMeeting, "title").equalsIgnoreCase(city)) {
			log.info("The city saved successfully");
		} else {

			Assert.fail("Expected city : " + city + " Actual city : "
					+ elementLibrary.getAttribute(cityFieldForMeeting, "title"));
		}
	}

	@Then("^Validate engagement type as \"(.*?)\"$")

	public void validateEngagementTypeForMeeting(String engagement) throws Throwable {

		if (elementLibrary.getAttribute(engagementTypeForMeeting, "title").equalsIgnoreCase(engagement)) {
			log.info("The engagement saved successfully");
		} else {

			Assert.fail("Expected engagement : " + engagement + " Actual engagement : "
					+ elementLibrary.getAttribute(engagementTypeForMeeting, "title"));
		}
	}

	@Then("^Validate notes as \"(.*?)\"$")

	public void validateNoteForMeeting(String notes) throws Throwable {
		WebElement IframeNotes = driver.findElement(By.xpath("//iframe[@id='WebResource_RichtextEditnotes']"));
		elementLibrary.switchToFrame(IframeNotes);

		WebElement notesInput = driver.findElement(By.xpath("//div[@class='fr-element fr-view']/p"));

		if (notesInput.getText().equalsIgnoreCase(notes)) {
			log.info("The notes saved successfully");
		} else {

			Assert.fail("Expected notes : " + notes + " Actual notes : " + notesInput.getText());
		}

		driver.switchTo().defaultContent();
	}

	@Then("^Validate activity purpose as \"(.*?)\"$")

	public void validateActivityPurposeForMeeting(String activityPurpose) throws Throwable {
		WebElement activityPurposeSelected = driver
				.findElement(By.xpath("(//span[text()='" + activityPurpose + "'])[1]"));

		if (activityPurposeSelected.isDisplayed()) {
			log.info("The activity purpose saved successfully");
		} else {

			Assert.fail("The activity purpose saved unsuccessfully");
		}
	}

	@Then("^Validate product as \"(.*?)\"$")

	public void validateProductForMeeting(String product) throws Throwable {
		WebElement activityProductSelected = driver.findElement(By.xpath("(//span[text()='" + product + "'])[1]"));

		if (activityProductSelected.isDisplayed()) {
			log.info("The activity product saved successfully");
		} else {

			Assert.fail("The activity product saved unsuccessfully");
		}
	}

	@Then("^Validate external attendees as \"(.*?)\"$")

	public void validatExternalAttendeesForMeeting(String externalAttendees) throws Throwable {
		WebElement externalAttendeesSelected = driver
				.findElement(By.xpath("(//span[text()='" + externalAttendees + "'])[1]"));

		if (externalAttendeesSelected.isDisplayed()) {
			log.info("The external attendees saved successfully");
		} else {

			Assert.fail("The external attendees saved unsuccessfully");
		}
	}

	@Then("^Validate RTC$")
	public void validateRTC() throws Throwable {
		WebElement IframeRTC = driver.findElement(By.xpath("//iframe[@id='WebResource_RTCs_UCIs']"));
		elementLibrary.switchToFrame(IframeRTC);
		WebElement RTCSelected = driver.findElement(By.xpath("(//div[@class='wj-row'])[2]"));
		System.out.print(RTCSelected.getAttribute("aria-selected"));
		if ((RTCSelected.getAttribute("aria-selected")).equals("true")) {
			log.info("The RTC saved successfully");
		} else {

			Assert.fail("The RTC saved unsuccessfully");
			// Assert.fail("Actual rtc : "+RTCSelected.getAttribute("aria-selected"));
		}
		driver.switchTo().defaultContent();
	}

	@And("^Click on Add Opportunity button$")
	public void clickAddOpportunityButton() throws Throwable {

		String sheetName = EnvironmentConfig.getAPP();
		if (sheetName.equals("Retail")) {
			elementLibrary.waitForElementToDisplay(addOpportunity);
			elementLibrary.click(addOpportunity);
		} else if (sheetName.equals("Hybrid")) {
			elementLibrary.waitForElementToDisplay(addOpportunityDropDownButton);
			elementLibrary.click(addOpportunityDropDownButton);
			elementLibrary.waitForElementToDisplay(retailOpportunityButton);
			elementLibrary.click(retailOpportunityButton);
		}
	}

	@And("^Fill in opportunity name field as \"(.*?)\"$")
	public void fillRetailOpporName(String retailOpporName) throws Throwable {
		elementLibrary.waitForElementToDisplay(saveRetailOpporButton);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmss");
		String formattedDate = sdf.format(date);
		newRetailOpporName = retailOpporName + formattedDate;
		elementLibrary.click(retailOpporNameInputBox);
		elementLibrary.enterText(retailOpporNameInputBox, newRetailOpporName);
	}

	@And("^Fill in strategy field as \"(.*?)\"$")
	public void fillStrategeField(String strategyProduct) throws Throwable {
		Robot robot = new Robot();

		elementLibrary.mouseOver(strategyProductField);
		elementLibrary.enterText(strategyProductField, strategyProduct);
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
	}

	@And("^Fill in Est close date field as \"(.*?)\"$")
	public void fillEstCloseDateField(String estCloseDate) throws Throwable {

		elementLibrary.click(estCloseDateField);
		Thread.sleep(2000);
		elementLibrary.click(estCloseDateField);
		elementLibrary.enterText(estCloseDateField, estCloseDate);

	}

	@And("^Fill in Est size field as \"(.*?)\"$")
	public void fillEstSizeField(String estSize) throws Throwable {
		elementLibrary.mouseOver(estSizeField);
		elementLibrary.enterText(estSizeField, estSize);
	}

	@And("^Fill in description field as \"(.*?)\"$")
	public void fillDescriptionField(String description) throws Throwable {
		elementLibrary.mouseOver(descriptionFieldForRetailOppor);
		elementLibrary.enterText(descriptionFieldForRetailOppor, description);
	}

	@And("^Click Save button to save retail opportunity$")
	public void clickSave() throws Throwable {
		elementLibrary.waitForElementToDisplay(saveRetailOpporButton);
		elementLibrary.click(saveRetailOpporButton);
		Thread.sleep(100000);
	}

	@Then("^Validate retail opportunity saved successfully$")
	public void validateRetailOpporSave() throws Throwable {
		WebElement retailOpporTitle = driver
				.findElement(By.xpath("//h1[@title=" + "\'" + newRetailOpporName + "\'" + "]"));
		Thread.sleep(20000);

		if (retailOpporTitle.isDisplayed()) {

			log.info("The new retail opportunity saved successfully");
		} else {
			Assert.fail("The new retail opportunity saved unsuccessfully");
		}
	}

	@Then("^Validate retail opportunity name$")
	public void validateRetaiOpporName() throws Throwable {
		if (elementLibrary.getAttribute(retailOpporNameInputBox, "Value").equalsIgnoreCase(newRetailOpporName)) {
			log.info("The retail opportunity name saved successfully");
		} else {

			Assert.fail(
					"Expected retail opportunity name : " + newRetailOpporName + " Actual retail opportunity name : "
							+ elementLibrary.getAttribute(retailOpporNameInputBox, "Value"));
		}
	}

	@Then("^Validate strategy field as \"(.*?)\"$")
	public void validateStrategyField(String strategyProduct) throws Throwable {
		if (elementLibrary.getAttribute(strategyProductFieldSelected, "aria-label").equalsIgnoreCase(strategyProduct)) {
			log.info("The strategy product field saved successfully");
		} else {

			Assert.fail("Expected strategy product : " + strategyProduct + " Actual strategy product : "
					+ elementLibrary.getAttribute(strategyProductFieldSelected, "aria-label"));
		}
	}

	@Then("^Validate Est close date field as \"(.*?)\"$")
	public void validateEstCloseDateField(String estCloseDate) throws Throwable {
		if (elementLibrary.getAttribute(estCloseDateField, "Value").equalsIgnoreCase(estCloseDate)) {
			log.info("The Est close date saved successfully");
		} else {

			Assert.fail("Expected Est close date : " + estCloseDate + " Actual Est close date : "
					+ elementLibrary.getAttribute(estCloseDateField, "Value"));
		}
	}

	@Then("^Validate Est size field as \"(.*?)\"$")
	public void validateEstSizeField(String estSize) throws Throwable {
		estSize = "$10,000.00";
		if (elementLibrary.getAttribute(estSizeField, "Value").equalsIgnoreCase(estSize)) {
			log.info("The Est size saved successfully");
		} else {

			Assert.fail("Expected Est size : " + estSize + " Actual Est size : "
					+ elementLibrary.getAttribute(estSizeField, "Value"));
		}
	}

	@Then("^Validate description field as \"(.*?)\"$")
	public void validateDescriptionField(String description) throws Throwable {
		if (elementLibrary.getText(descriptionFieldForRetailOppor).equalsIgnoreCase(description)) {
			log.info("The description saved successfully");
		} else {

			Assert.fail("Expected description : " + description + " Actual description : "
					+ elementLibrary.getText(descriptionFieldForRetailOppor));
		}
	}

	@Then("^Click on all ribbon buttons on the relationship page and validate no error displayed$")
	public void validateAllRibbonButtonsOnRelationship() throws Throwable {
		UIElement ribbonButton_Meeting = new UIElement("ribbonButton_Meeting", IdentifyBy.XPATH,
				elementLibrary.getCellData("AllRibbonButtonsOnRelationship.xls", "Meeting"));
		UIElement ribbonButton_Phonecall = new UIElement("ribbonButton_Phonecall", IdentifyBy.XPATH,
				elementLibrary.getCellData("AllRibbonButtonsOnRelationship.xls", "Phone Call"));
		UIElement ribbonButton_Task = new UIElement("ribbonButton_Task", IdentifyBy.XPATH,
				elementLibrary.getCellData("AllRibbonButtonsOnRelationship.xls", "Task"));
		UIElement ribbonButton_PIMCOAssets = new UIElement("ribbonButton_PIMCOAssets", IdentifyBy.XPATH,
				elementLibrary.getCellData("AllRibbonButtonsOnRelationship.xls", "PIMCO Assets"));
		UIElement ribbonButton_MMDAssets = new UIElement("ribbonButton_MMDAssets", IdentifyBy.XPATH,
				elementLibrary.getCellData("AllRibbonButtonsOnRelationship.xls", "MMD Assets"));
		UIElement ribbonButton_AddOpportunity = new UIElement("ribbonButton_AddOpportunity", IdentifyBy.XPATH,
				elementLibrary.getCellData("AllRibbonButtonsOnRelationship.xls", "Add Opportunity"));
		UIElement ribbonButton_AddVulnerability = new UIElement("ribbonButton_AddVulnerability", IdentifyBy.XPATH,
				elementLibrary.getCellData("AllRibbonButtonsOnRelationship.xls", "Add Vulnerability"));
		UIElement ribbonButton_last3Years = new UIElement("ribbonButton_last3Years", IdentifyBy.XPATH,
				elementLibrary.getCellData("AllRibbonButtonsOnRelationship.xls", "Last 3 Years"));
		UIElement ribbonButton_last7Years = new UIElement("ribbonButton_last7Years", IdentifyBy.XPATH,
				elementLibrary.getCellData("AllRibbonButtonsOnRelationship.xls", "Last 7 Years"));
		UIElement ribbonButton_SinceInception = new UIElement("ribbonButton_SinceInception", IdentifyBy.XPATH,
				elementLibrary.getCellData("AllRibbonButtonsOnRelationship.xls", "Since Inception"));
		UIElement ribbonButton_RetailPortfolioAnalysis = new UIElement("ribbonButton_RetailPortfolioAnalysis",
				IdentifyBy.XPATH,
				elementLibrary.getCellData("AllRibbonButtonsOnRelationship.xls", "Retail Portfolio Analysis"));
		UIElement ribbonButton_InstSolnStudies = new UIElement("ribbonButton_InstSolnStudies", IdentifyBy.XPATH,
				elementLibrary.getCellData("AllRibbonButtonsOnRelationship.xls", "Inst.Soln.Studies"));
		UIElement ribbonButton_BusDevRequest = new UIElement("ribbonButton_BusDevRequest", IdentifyBy.XPATH,
				elementLibrary.getCellData("AllRibbonButtonsOnRelationship.xls", "Bus Dev Request"));
		UIElement ribbonButton_CoverageChangeRequest = new UIElement("ribbonButton_CoverageChangeRequest",
				IdentifyBy.XPATH,
				elementLibrary.getCellData("AllRibbonButtonsOnRelationship.xls", "Coverage Change Request"));
		UIElement ribbonButton_SpeakerRequest = new UIElement("ribbonButton_SpeakerRequest", IdentifyBy.XPATH,
				elementLibrary.getCellData("AllRibbonButtonsOnRelationship.xls", "Speaker Request"));
		UIElement ribbonButton_Deactivate = new UIElement("ribbonButton_Deactivate", IdentifyBy.XPATH,
				elementLibrary.getCellData("AllRibbonButtonsOnRelationship.xls", "Deactivate"));
		UIElement ribbonButton_Refresh = new UIElement("ribbonButton_Refresh", IdentifyBy.XPATH,
				elementLibrary.getCellData("AllRibbonButtonsOnRelationship.xls", "Refresh"));
		UIElement ribbonButton_Share = new UIElement("ribbonButton_Share", IdentifyBy.XPATH,
				elementLibrary.getCellData("AllRibbonButtonsOnRelationship.xls", "Share"));
		UIElement ribbonButton_EmailDetails = new UIElement("ribbonButton_EmailDetails", IdentifyBy.XPATH,
				elementLibrary.getCellData("AllRibbonButtonsOnRelationship.xls", "EmailDetails"));
		UIElement ribbonButton_AddInstOpportunity = new UIElement("ribbonButton_AddInstOpportunity", IdentifyBy.XPATH,
				elementLibrary.getCellData("AllRibbonButtonsOnRelationship.xls", "AddInstOpportunity"));
		UIElement ribbonButton_CSAAnalysisRequests = new UIElement("ribbonButton_CSAAnalysisRequests", IdentifyBy.XPATH,
				elementLibrary.getCellData("AllRibbonButtonsOnRelationship.xls", "CS&A Analysis Requests"));
		UIElement ribbonButton_ExportToPDF = new UIElement("ribbonButton_ExportToPDF", IdentifyBy.XPATH,
				elementLibrary.getCellData("AllRibbonButtonsOnRelationship.xls", "ExportToPDF"));
		UIElement ribbonButton_CheckAccess = new UIElement("ribbonButton_CheckAccess", IdentifyBy.XPATH,
				elementLibrary.getCellData("AllRibbonButtonsOnRelationship.xls", "CheckAccess"));
		String sheetName = EnvironmentConfig.getAPP();

		if (sheetName.equals("Institutional")) {

			UIElement[] arryTiles = { ribbonButton_Task, // 0
					ribbonButton_Meeting, // 1
					ribbonButton_Phonecall, // 2
					ribbonButton_PIMCOAssets, // 3
					ribbonButton_MMDAssets, // 4
					ribbonButton_AddVulnerability, // 5
					ribbonButton_AddOpportunity, // 6
					ribbonButton_last3Years, // 7
					ribbonButton_last7Years, // 8
					ribbonButton_SinceInception, // 9
					ribbonButton_RetailPortfolioAnalysis, // 10
					ribbonButton_CSAAnalysisRequests, // 11
					ribbonButton_BusDevRequest, // 12
					ribbonButton_CoverageChangeRequest, // 13
					ribbonButton_SpeakerRequest, // 14
					ribbonButton_Share, // 15
					ribbonButton_EmailDetails, // 16
					ribbonButton_Deactivate, // 17
					ribbonButton_Refresh, // 18
					ribbonButton_CheckAccess // 19
					 };// 20

			elementLibrary.waitForElementToDisplay(addActivity);
			String base = driver.getWindowHandle();
			for (int iLoop = 0; iLoop < arryTiles.length; iLoop++) {

				if (iLoop == 0) {

					elementLibrary.click(addActivity);
					elementLibrary.click(arryTiles[iLoop]);
					elementLibrary.waitForElementToDisplay(taskSubjectInputBox);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}
					elementLibrary.click(cancelButtonForQuickCreateTask);
//					elementLibrary.waitForElementToDisplay(cancelButton);
//					elementLibrary.click(cancelButton);
					if (!driver.findElements(By.xpath("//button[@id='cancelButton']")).isEmpty()) {
						elementLibrary.click(cancelButton);
					}

				} else if (0 < iLoop && iLoop < 3) {

					elementLibrary.click(addActivity);
					elementLibrary.click(arryTiles[iLoop]);
					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
					}
					Thread.sleep(10000);

					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}
					driver.close();
					driver.switchTo().window(base);
				} else if (iLoop == 4 || iLoop == 3) {
				
					elementLibrary.click(clientAssets);
					elementLibrary.click(arryTiles[iLoop]);
					Thread.sleep(15000);
					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
					}

					Thread.sleep(10000);

					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}
					driver.close();
					driver.switchTo().window(base);
				} else if (iLoop == 5) {
					elementLibrary.click(arryTiles[iLoop]);
//					for (String winHandle : driver.getWindowHandles()) {
//						driver.switchTo().window(winHandle);
//					}
//					Thread.sleep(10000);

					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}
					UIElement recentTab = new UIElement("recentTab", IdentifyBy.XPATH,
							"//span[contains(text(),'Recent')]");
					UIElement relationshipRecord = new UIElement("relationshipRecord", IdentifyBy.XPATH,
							"//span[text()='3M Company']");
					elementLibrary.click(recentTab);
					Thread.sleep(3000);
					elementLibrary.click(relationshipRecord);
//					driver.close();
//					driver.switchTo().window(base);
				} else if (iLoop == 6) {
					elementLibrary.click(arryTiles[iLoop]);
					Thread.sleep(5000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}
//					UIElement recentTab = new UIElement("recentTab", IdentifyBy.XPATH,
//							"//span[contains(text(),'Recent')]");
					UIElement relationshipRecord = new UIElement("relationshipRecord", IdentifyBy.XPATH,
							"//span[text()='3M Company']");
					//elementLibrary.click(recentTab);
					Thread.sleep(3000);
					elementLibrary.click(relationshipRecord);
//					elementLibrary.waitForElementToDisplay(cancelButton);
//					elementLibrary.click(cancelButton);
					if (!driver.findElements(By.xpath("//button[@id='cancelButton']")).isEmpty()) {
						elementLibrary.click(cancelButton);
					}

				} else if (iLoop > 6 && iLoop < 10) {
					elementLibrary.waitForElementToDisplay(moreCommandButtonForRelationship);
					elementLibrary.click(moreCommandButtonForRelationship);
					elementLibrary.waitForElementToDisplay(moreCommandButtonForViewActivityReport);
					elementLibrary.click(moreCommandButtonForViewActivityReport);
					elementLibrary.click(arryTiles[iLoop]);
					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
					}
					Thread.sleep(10000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}
					driver.close();
					driver.switchTo().window(base);
				} else if (iLoop == 10 || iLoop == 11) {
					elementLibrary.click(moreCommandButtonForRelationship);
					elementLibrary.waitForElementToDisplay(moreCommandButtonForCreateRequest);
					elementLibrary.click(moreCommandButtonForCreateRequest);
					elementLibrary.waitForElementToDisplay(moreCommandButtonForAnalysisRequest);
					elementLibrary.click(moreCommandButtonForAnalysisRequest);
					elementLibrary.click(arryTiles[iLoop]);
					Thread.sleep(5000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}
					UIElement relationshipRecord = new UIElement("relationshipRecord", IdentifyBy.XPATH,
							"//span[text()='3M Company']");
					elementLibrary.click(relationshipRecord);
					if (!driver.findElements(By.xpath("//button[@id='cancelButton']")).isEmpty()) {
						elementLibrary.click(cancelButton);
					}

				} else if (iLoop > 11 && iLoop < 15) {
					elementLibrary.waitForElementToDisplay(moreCommandButtonForRelationship);
					elementLibrary.click(moreCommandButtonForRelationship);
					elementLibrary.waitForElementToDisplay(moreCommandButtonForCreateRequest);
					elementLibrary.click(moreCommandButtonForCreateRequest);
					elementLibrary.waitForElementToDisplay(arryTiles[iLoop]);
					elementLibrary.click(arryTiles[iLoop]);
					Thread.sleep(5000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}
					UIElement relationshipRecord = new UIElement("relationshipRecord", IdentifyBy.XPATH,
							"//span[text()='3M Company']");
					elementLibrary.click(relationshipRecord);

					if (!driver.findElements(By.xpath("//button[@id='cancelButton']")).isEmpty()) {
						elementLibrary.click(cancelButton);
					}
				} else if (iLoop == 15) {
					elementLibrary.waitForElementToDisplay(moreCommandButtonForRelationship);
					elementLibrary.click(moreCommandButtonForRelationship);
					elementLibrary.waitForElementToDisplay(moreCommandButtonForCollaborate);
					elementLibrary.click(moreCommandButtonForCollaborate);
					elementLibrary.waitForElementToDisplay(arryTiles[iLoop]);
					elementLibrary.click(arryTiles[iLoop]);
					WebElement Iframe_Dialog = driver.findElement(By.xpath("//iframe[@id='InlineDialog_Iframe']"));
					elementLibrary.switchToFrame(Iframe_Dialog);
					elementLibrary.waitForElementToDisplay(dialogcancelButton);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}
					elementLibrary.click(dialogcancelButton);
					driver.switchTo().defaultContent();
				} else if (iLoop == 16) {
					elementLibrary.waitForElementToDisplay(moreCommandButtonForRelationship);
					elementLibrary.click(moreCommandButtonForRelationship);
					elementLibrary.waitForElementToDisplay(moreCommandButtonForCollaborate);
					elementLibrary.click(moreCommandButtonForCollaborate);
					elementLibrary.waitForElementToDisplay(arryTiles[iLoop]);
					elementLibrary.click(arryTiles[iLoop]);
					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
					}
					Thread.sleep(10000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}
					driver.close();
					driver.switchTo().window(base);

				} else if (iLoop == 17) {
					elementLibrary.waitForElementToDisplay(moreCommandButtonForRelationship);
					elementLibrary.click(moreCommandButtonForRelationship);
					elementLibrary.waitForElementToDisplay(arryTiles[iLoop]);
					elementLibrary.click(arryTiles[iLoop]);
					elementLibrary.waitForElementToDisplay(cancelDeactivateButton);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}
					elementLibrary.click(cancelDeactivateButton);
				} else if (iLoop == 18) {
					elementLibrary.waitForElementToDisplay(moreCommandButtonForRelationship);
					elementLibrary.click(moreCommandButtonForRelationship);
					elementLibrary.waitForElementToDisplay(arryTiles[iLoop]);
					elementLibrary.click(arryTiles[iLoop]);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}
				} else if (iLoop == 19) {
					elementLibrary.waitForElementToDisplay(moreCommandButtonForRelationship);
					elementLibrary.click(moreCommandButtonForRelationship);
					elementLibrary.waitForElementToDisplay(arryTiles[iLoop]);
					elementLibrary.click(arryTiles[iLoop]);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}

					elementLibrary.waitForElementToDisplay(OKButton);
					elementLibrary.click(OKButton);

				}

			}
		} else if (sheetName.equals("Retail")) {

			UIElement[] arryTiles = { ribbonButton_Task, // 0
					ribbonButton_Meeting, // 1
					ribbonButton_Phonecall, // 2
					ribbonButton_PIMCOAssets, // 3
					ribbonButton_last3Years, // 4
					ribbonButton_last7Years, // 5
					ribbonButton_SinceInception, // 6
					ribbonButton_RetailPortfolioAnalysis, // 7

					ribbonButton_BusDevRequest, // 8
					ribbonButton_CoverageChangeRequest, // 9
					ribbonButton_SpeakerRequest, // 10
					ribbonButton_Share, // 11
					ribbonButton_EmailDetails, // 12
					ribbonButton_Deactivate, // 13
					ribbonButton_Refresh // 14
					 };// 15

			elementLibrary.waitForElementToDisplay(addActivity);
			String base = driver.getWindowHandle();
			for (int iLoop = 0; iLoop < arryTiles.length; iLoop++) {

				if (iLoop == 0) {

					elementLibrary.click(addActivity);
					elementLibrary.click(arryTiles[iLoop]);
					elementLibrary.waitForElementToDisplay(taskSubjectInputBox);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}
					elementLibrary.click(cancelButtonForQuickCreateTask);
//					elementLibrary.waitForElementToDisplay(cancelButton);
//					elementLibrary.click(cancelButton);
					if (!driver.findElements(By.xpath("//button[@id='cancelButton']")).isEmpty()) {
						elementLibrary.click(cancelButton);
					}

				} else if (iLoop == 1 || iLoop == 2) {

					elementLibrary.click(addActivity);
					elementLibrary.click(arryTiles[iLoop]);
					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
					}
					Thread.sleep(10000);

					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}
					driver.close();
					driver.switchTo().window(base);
				} else if (iLoop >= 4 && iLoop < 7) {
					elementLibrary.waitForElementToDisplay(moreCommandButtonForRelationship);
					elementLibrary.click(moreCommandButtonForRelationship);
					elementLibrary.waitForElementToDisplay(moreCommandButtonForViewActivityReport);
					elementLibrary.click(moreCommandButtonForViewActivityReport);
					elementLibrary.click(arryTiles[iLoop]);
					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
					}
					Thread.sleep(10000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}
					driver.close();
					driver.switchTo().window(base);
				} else if (iLoop == 7) {
					elementLibrary.click(moreCommandButtonForRelationship);
					elementLibrary.waitForElementToDisplay(moreCommandButtonForCreateRequest);
					elementLibrary.click(moreCommandButtonForCreateRequest);
					elementLibrary.waitForElementToDisplay(moreCommandButtonForAnalysisRequest);
					elementLibrary.click(moreCommandButtonForAnalysisRequest);
					elementLibrary.click(arryTiles[iLoop]);
					Thread.sleep(5000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}
					UIElement recentTab = new UIElement("recentTab", IdentifyBy.XPATH,
							"//span[contains(text(),'Recent')]");
					elementLibrary.click(recentTab);
					UIElement relationshipRecord = new UIElement("relationshipRecord", IdentifyBy.XPATH,
							"//span[text()='3M Company']");
					elementLibrary.click(relationshipRecord);
				} else if (iLoop > 7 && iLoop < 11) {
					elementLibrary.waitForElementToDisplay(moreCommandButtonForRelationship);
					elementLibrary.click(moreCommandButtonForRelationship);
					elementLibrary.waitForElementToDisplay(moreCommandButtonForCreateRequest);
					elementLibrary.click(moreCommandButtonForCreateRequest);
					elementLibrary.waitForElementToDisplay(arryTiles[iLoop]);
					elementLibrary.click(arryTiles[iLoop]);
					Thread.sleep(5000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}
					UIElement relationshipRecord = new UIElement("relationshipRecord", IdentifyBy.XPATH,
							"//span[text()='3M Company']");
					elementLibrary.click(relationshipRecord);

					if (!driver.findElements(By.xpath("//button[@id='cancelButton']")).isEmpty()) {
						elementLibrary.click(cancelButton);
					}

				} else if (iLoop == 11) {
					elementLibrary.waitForElementToDisplay(moreCommandButtonForRelationship);
					elementLibrary.click(moreCommandButtonForRelationship);
					elementLibrary.waitForElementToDisplay(moreCommandButtonForCollaborate);
					elementLibrary.click(moreCommandButtonForCollaborate);
					elementLibrary.waitForElementToDisplay(arryTiles[iLoop]);
					elementLibrary.click(arryTiles[iLoop]);
					WebElement Iframe_Dialog = driver.findElement(By.xpath("//iframe[@id='InlineDialog_Iframe']"));
					elementLibrary.switchToFrame(Iframe_Dialog);
					elementLibrary.waitForElementToDisplay(dialogcancelButton);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}
					elementLibrary.click(dialogcancelButton);
					driver.switchTo().defaultContent();
				} else if (iLoop == 12) {
					elementLibrary.waitForElementToDisplay(moreCommandButtonForRelationship);
					elementLibrary.click(moreCommandButtonForRelationship);
					elementLibrary.waitForElementToDisplay(moreCommandButtonForCollaborate);
					elementLibrary.click(moreCommandButtonForCollaborate);
					elementLibrary.waitForElementToDisplay(arryTiles[iLoop]);
					elementLibrary.click(arryTiles[iLoop]);
					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
					}
					Thread.sleep(10000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}
					driver.close();
					driver.switchTo().window(base);

				} else if (iLoop == 13) {
					elementLibrary.waitForElementToDisplay(moreCommandButtonForRelationship);
					elementLibrary.click(moreCommandButtonForRelationship);
					elementLibrary.waitForElementToDisplay(arryTiles[iLoop]);
					elementLibrary.click(arryTiles[iLoop]);
					elementLibrary.waitForElementToDisplay(cancelDeactivateButton);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}
					elementLibrary.click(cancelDeactivateButton);
				} else if (iLoop == 14) {
					elementLibrary.waitForElementToDisplay(moreCommandButtonForRelationship);
					elementLibrary.click(moreCommandButtonForRelationship);
					elementLibrary.waitForElementToDisplay(arryTiles[iLoop]);
					elementLibrary.click(arryTiles[iLoop]);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}
				}

			}
		} else if (sheetName.equals("Hybrid")) {
			UIElement[] arryTiles = { ribbonButton_Task, // 0
					ribbonButton_Meeting, // 1
					ribbonButton_Phonecall, // 2
					ribbonButton_PIMCOAssets, // 3
					ribbonButton_AddInstOpportunity, // 4
					ribbonButton_last3Years, // 5
					ribbonButton_last7Years, // 6
					ribbonButton_SinceInception, // 7
					ribbonButton_RetailPortfolioAnalysis, // 8
					ribbonButton_CSAAnalysisRequests, // 9
					ribbonButton_BusDevRequest, // 10
					ribbonButton_CoverageChangeRequest, // 11
					ribbonButton_SpeakerRequest, // 12
					ribbonButton_Share, // 13
					ribbonButton_EmailDetails, // 14
					ribbonButton_Deactivate, // 15
					ribbonButton_Refresh // 16
					 };// 17

			elementLibrary.waitForElementToDisplay(addActivity);
			String base = driver.getWindowHandle();
			for (int iLoop = 0; iLoop < arryTiles.length; iLoop++) {

				if (iLoop == 0) {

					elementLibrary.click(addActivity);
					elementLibrary.click(arryTiles[iLoop]);
					elementLibrary.waitForElementToDisplay(taskSubjectInputBox);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}
					elementLibrary.click(cancelButtonForQuickCreateTask);
					if (!driver.findElements(By.xpath("//button[@id='cancelButton']")).isEmpty()) {
						elementLibrary.click(cancelButton);
					}

				} else if (0 < iLoop && iLoop < 3) {

					elementLibrary.click(addActivity);
					elementLibrary.click(arryTiles[iLoop]);
					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
					}
					Thread.sleep(10000);

					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}
					driver.close();
					driver.switchTo().window(base);
				} else if (iLoop == 3) {
					elementLibrary.click(arryTiles[iLoop]);
					Thread.sleep(20000);
					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
					}
					Thread.sleep(10000);

					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}
					driver.close();
					driver.switchTo().window(base);
				} else if (iLoop == 4) {
					elementLibrary.click(arryTiles[iLoop]);
					Thread.sleep(5000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}
					UIElement recentTab = new UIElement("recentTab", IdentifyBy.XPATH,
							"//span[contains(text(),'Recent')]");
					UIElement relationshipRecord = new UIElement("relationshipRecord", IdentifyBy.XPATH,
							"//span[text()='3M Company']");
					elementLibrary.click(recentTab);
					Thread.sleep(3000);
					elementLibrary.click(relationshipRecord);
					if (!driver.findElements(By.xpath("//button[@id='cancelButton']")).isEmpty()) {
						elementLibrary.click(cancelButton);
					}
				} else if (iLoop > 4 && iLoop < 8) {
					elementLibrary.waitForElementToDisplay(moreCommandButtonForRelationship);
					elementLibrary.click(moreCommandButtonForRelationship);
					elementLibrary.waitForElementToDisplay(moreCommandButtonForViewActivityReport);
					elementLibrary.click(moreCommandButtonForViewActivityReport);
					elementLibrary.click(arryTiles[iLoop]);
					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
					}
					Thread.sleep(10000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}
					driver.close();
					driver.switchTo().window(base);
				} else if (iLoop == 8 || iLoop == 9) {
					elementLibrary.click(moreCommandButtonForRelationship);
					elementLibrary.waitForElementToDisplay(moreCommandButtonForCreateRequest);
					elementLibrary.click(moreCommandButtonForCreateRequest);
					elementLibrary.waitForElementToDisplay(moreCommandButtonForAnalysisRequest);
					elementLibrary.click(moreCommandButtonForAnalysisRequest);
					elementLibrary.click(arryTiles[iLoop]);
					Thread.sleep(5000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}
					UIElement relationshipRecord = new UIElement("relationshipRecord", IdentifyBy.XPATH,
							"//span[text()='3M Company']");
					elementLibrary.click(relationshipRecord);
					if (!driver.findElements(By.xpath("//button[@id='cancelButton']")).isEmpty()) {
						elementLibrary.click(cancelButton);
					}
				} else if (iLoop > 9 && iLoop < 13) {
					elementLibrary.waitForElementToDisplay(moreCommandButtonForRelationship);
					elementLibrary.click(moreCommandButtonForRelationship);
					elementLibrary.waitForElementToDisplay(moreCommandButtonForCreateRequest);
					elementLibrary.click(moreCommandButtonForCreateRequest);
					elementLibrary.waitForElementToDisplay(arryTiles[iLoop]);
					elementLibrary.click(arryTiles[iLoop]);
					Thread.sleep(5000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}
					UIElement relationshipRecord = new UIElement("relationshipRecord", IdentifyBy.XPATH,
							"//span[text()='3M Company']");
					elementLibrary.click(relationshipRecord);
					if (!driver.findElements(By.xpath("//button[@id='cancelButton']")).isEmpty()) {
						elementLibrary.click(cancelButton);
					}

				} else if (iLoop == 13) {
					elementLibrary.waitForElementToDisplay(moreCommandButtonForRelationship);
					elementLibrary.click(moreCommandButtonForRelationship);
					elementLibrary.waitForElementToDisplay(moreCommandButtonForCollaborate);
					elementLibrary.click(moreCommandButtonForCollaborate);
					elementLibrary.waitForElementToDisplay(arryTiles[iLoop]);
					elementLibrary.click(arryTiles[iLoop]);
					WebElement Iframe_Dialog = driver.findElement(By.xpath("//iframe[@id='InlineDialog_Iframe']"));
					elementLibrary.switchToFrame(Iframe_Dialog);
					elementLibrary.waitForElementToDisplay(dialogcancelButton);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}
					elementLibrary.click(dialogcancelButton);
					driver.switchTo().defaultContent();
				} else if (iLoop == 14) {
					elementLibrary.waitForElementToDisplay(moreCommandButtonForRelationship);
					elementLibrary.click(moreCommandButtonForRelationship);
					elementLibrary.waitForElementToDisplay(moreCommandButtonForCollaborate);
					elementLibrary.click(moreCommandButtonForCollaborate);
					elementLibrary.waitForElementToDisplay(arryTiles[iLoop]);
					elementLibrary.click(arryTiles[iLoop]);
					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
					}
					Thread.sleep(10000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}
					driver.close();
					driver.switchTo().window(base);

				} else if (iLoop == 15) {
					elementLibrary.waitForElementToDisplay(moreCommandButtonForRelationship);
					elementLibrary.click(moreCommandButtonForRelationship);
					elementLibrary.waitForElementToDisplay(arryTiles[iLoop]);
					elementLibrary.click(arryTiles[iLoop]);
					elementLibrary.waitForElementToDisplay(cancelDeactivateButton);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}
					elementLibrary.click(cancelDeactivateButton);
				} else if (iLoop == 16) {
					elementLibrary.waitForElementToDisplay(moreCommandButtonForRelationship);
					elementLibrary.click(moreCommandButtonForRelationship);
					elementLibrary.waitForElementToDisplay(arryTiles[iLoop]);
					elementLibrary.click(arryTiles[iLoop]);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}
				}

			}
		}
	}

	@And("^Click on Activity Manager left side menu$")
	public void clickActivityManager() throws Throwable {
		UIElement activityManager_LeftSideMenu = new UIElement("activityManager_LeftSideMenu", IdentifyBy.XPATH,
				elementLibrary.getCellData("LeftSideMenu.xls", "Activity Manager"));
		elementLibrary.waitForElementToDisplay(activityManager_LeftSideMenu);
		elementLibrary.click(activityManager_LeftSideMenu);
		// Thread.sleep(15000);

	}

	@And("^Search Activities by user \"(.*?)\",select from \"(.*?)\" and to \"(.*?)\" then click Export to Excel button$")
	public void searchActivitesByUser(String user, String startDate, String endDate) throws Throwable {
		UIElement userInputfield = new UIElement("userInputfield", IdentifyBy.XPATH,
				"//input[@id='leadam-text-field']");
		UIElement fromfield = new UIElement("fromfield", IdentifyBy.XPATH, "(//input[@class='wj-form-control'])[1]");
		UIElement tofield = new UIElement("tofield", IdentifyBy.XPATH, "(//input[@class='wj-form-control'])[2]");
		UIElement searchButton = new UIElement("searchButton", IdentifyBy.XPATH, "//button[text()='Search']");

		UIElement dropDownItem = new UIElement("dropDownItem", IdentifyBy.XPATH,
				"//button[@class='dropdown-item active ng-star-inserted']");
		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='FullPageWebResource']"));
		elementLibrary.switchToFrame(iframe);
		elementLibrary.waitForElementToDisplay(userInputfield);
		elementLibrary.enterText(userInputfield, user);
		elementLibrary.waitForElementToDisplay(dropDownItem);
		elementLibrary.click(dropDownItem);
		
		WebElement startDateInput = driver.findElement(By.xpath("(//input[@class='wj-form-control'])[1]"));
		
		elementLibrary.click(startDateInput);
		Thread.sleep(1000);
		startDateInput.sendKeys(Keys.CONTROL, "a");
		startDateInput.sendKeys(Keys.DELETE);
		Thread.sleep(2000);
		elementLibrary.enterText(startDateInput, startDate);
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		//elementLibrary.click(fromfield);
//		elementLibrary.deleteUsingSendkeys(fromfield);
//		Thread.sleep(2000);
//		elementLibrary.enterText(fromfield, startDate);
//		Thread.sleep(2000);
         
		elementLibrary.click(searchButton);
		elementLibrary.deleteDownloadFile("MyActivitiesExport.xlsx");
		Thread.sleep(15000);
		WebElement exportToExcelButton = driver.findElement(By.xpath("//button[text()=' Export to Excel ']"));
		elementLibrary.click(exportToExcelButton);
		// elementLibrary.click(exportToExcelButton);
		Thread.sleep(10000);
	}

	@And("^Validate the counts for activities are same with the ones in exported excel$")
	public void compareCountsWithExcel() throws Throwable {
		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='wj-cells']/div"));
		System.out.println(rows.size() - 1);

		String fileName = "MyActivitiesExport.xlsx";
		String sheeName = "sheet1";
		System.out.println(elementLibrary.getRowCountFromExcel(fileName, sheeName));
		if (elementLibrary.getRowCountFromExcel(fileName, sheeName) == (rows.size() - 1)) {
			log.info("The row counts match with exported excel file");
		} else {

			Assert.fail("The row counts do not match with exported excel file");
		}

	}

	@And("^Click on Advance Search left side menu$")
	public void clickOnAdvanceSearch() throws Throwable {
		UIElement advancedSearch_LeftSideMenu = new UIElement("advancedSearch_LeftSideMenu", IdentifyBy.XPATH,
				elementLibrary.getCellData("LeftSideMenu.xls", "Advanced Search"));
		elementLibrary.waitForElementToDisplay(advancedSearch_LeftSideMenu);
		elementLibrary.click(advancedSearch_LeftSideMenu);
	}

	@And("^Search for \"(.*?)\" relationship$")
	public void searchForRelationship(String relationshipName) throws Throwable {
		WebElement iframeAdvancedSearch = driver.findElement(By.xpath("//iframe[@id='FullPageWebResource']"));
		elementLibrary.switchToFrame(iframeAdvancedSearch);
		elementLibrary.waitForElementToDisplay(relationshipTabOnAdvanceSearch);
		elementLibrary.click(relationshipTabOnAdvanceSearch);
		elementLibrary.waitForElementToDisplay(relationshipInputFieldOnAdvanceSearch);
		elementLibrary.enterText(relationshipInputFieldOnAdvanceSearch, relationshipName);
		WebDriver webdriver = webdriverServiceLibrary.getWebDriver();
		Actions action = new Actions(webdriver);
		WebElement searchButton = webdriver.findElement(By.xpath("//button[@id='btStartSearch']"));
		action.moveToElement(searchButton).build().perform();
		elementLibrary.click(searchButton);
		UIElement searchResult = new UIElement("searchResult", IdentifyBy.XPATH, "//span[@title='3M Company']");
		elementLibrary.waitForElementToDisplay(searchResult);
	}

	@And("^Search for contact as \"(.*?)\" and \"(.*?)\"$")
	public void searchForContact(String firstName, String lastName) throws Throwable {
		WebElement iframeAdvancedSearch = driver.findElement(By.xpath("//iframe[@id='FullPageWebResource']"));
		elementLibrary.switchToFrame(iframeAdvancedSearch);
		elementLibrary.waitForElementToDisplay(relationshipTabOnAdvanceSearch);
		elementLibrary.enterText(firstNameOnAdvanceSearch, firstName);
		Thread.sleep(2000);
		elementLibrary.enterText(lastNameOnAdvanceSearch, lastName);
		Thread.sleep(2000);
		WebDriver webdriver = webdriverServiceLibrary.getWebDriver();
		Actions action = new Actions(webdriver);
		WebElement searchButton = webdriver.findElement(By.xpath("//button[@id='btStartSearch']"));
		action.moveToElement(searchButton).build().perform();
		elementLibrary.click(searchButton);
		UIElement searchResult = new UIElement("searchResult", IdentifyBy.XPATH, "//div[text()='Shane']");
		elementLibrary.waitForElementToDisplay(searchResult);

	}

	@And("^Search for account as \"(.*?)\"$")
	public void searchForAccount(String accountNumber) throws Throwable {
		WebElement iframeAdvancedSearch = driver.findElement(By.xpath("//iframe[@id='FullPageWebResource']"));
		elementLibrary.switchToFrame(iframeAdvancedSearch);
		elementLibrary.waitForElementToDisplay(accountTabOnAdvanceSearch);
		elementLibrary.click(accountTabOnAdvanceSearch);
		elementLibrary.enterText(accountNumberInputField, accountNumber);

		WebDriver webdriver = webdriverServiceLibrary.getWebDriver();
		Actions action = new Actions(webdriver);
		WebElement searchButton = webdriver.findElement(By.xpath("//button[@id='btStartSearch']"));
		action.moveToElement(searchButton).build().perform();
		elementLibrary.click(searchButton);
		UIElement searchResult = new UIElement("searchResult", IdentifyBy.XPATH, "//div[text()='18']");
		elementLibrary.waitForElementToDisplay(searchResult);

	}

	@And("^Search for opportunity as \"(.*?)\"$")
	public void searchForOpportunity(String opportunityName) throws Throwable {
		WebElement iframeAdvancedSearch = driver.findElement(By.xpath("//iframe[@id='FullPageWebResource']"));
		elementLibrary.switchToFrame(iframeAdvancedSearch);
		elementLibrary.waitForElementToDisplay(opporTabOnAdvanceSearch);
		elementLibrary.click(opporTabOnAdvanceSearch);
		elementLibrary.enterText(opportunityNameInputField, opportunityName);

		WebDriver webdriver = webdriverServiceLibrary.getWebDriver();
		Actions action = new Actions(webdriver);
		WebElement searchButton = webdriver.findElement(By.xpath("//button[@id='btStartSearch']"));
		action.moveToElement(searchButton).build().perform();
		elementLibrary.click(searchButton);
		UIElement searchResult = new UIElement("searchResult", IdentifyBy.XPATH, "//span[text()='Test Opportunity']");
		elementLibrary.waitForElementToDisplay(searchResult);

	}

	@And("^Search for event as \"(.*?)\"$")
	public void searchForEvent(String eventName) throws Throwable {
		WebElement iframeAdvancedSearch = driver.findElement(By.xpath("//iframe[@id='FullPageWebResource']"));
		elementLibrary.switchToFrame(iframeAdvancedSearch);
		elementLibrary.waitForElementToDisplay(eventTabOnAdvanceSearch);
		elementLibrary.click(eventTabOnAdvanceSearch);
		elementLibrary.enterText(eventNameInputField, eventName);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(5000);
		WebDriver webdriver = webdriverServiceLibrary.getWebDriver();
//		Actions action = new Actions(webdriver);
		WebElement searchButton = webdriver.findElement(By.xpath("//button[@id='btStartSearch']"));
//		action.moveToElement(searchButton).build().perform();
		elementLibrary.click(searchButton);
		UIElement searchResult = new UIElement("searchResult", IdentifyBy.XPATH,
				"//span[text()='CFA Society Boston Event']");
		elementLibrary.waitForElementToDisplay(searchResult);

	}

	@And("^Search for invitee as \"(.*?)\" and \"(.*?)\"$")
	public void searchForInvitee(String firstName, String lastName) throws Throwable {
		WebElement iframeAdvancedSearch = driver.findElement(By.xpath("//iframe[@id='FullPageWebResource']"));
		elementLibrary.switchToFrame(iframeAdvancedSearch);
		elementLibrary.waitForElementToDisplay(inviteeTabOnAdvanceSearch);
		elementLibrary.click(inviteeTabOnAdvanceSearch);
		Thread.sleep(3000);
		elementLibrary.enterText(firstNameInputField, firstName);
		Thread.sleep(2000);
		elementLibrary.enterText(lastNameInputField, lastName);
		WebDriver webdriver = webdriverServiceLibrary.getWebDriver();
		Actions action = new Actions(webdriver);
		WebElement searchButton = webdriver.findElement(By.xpath("//button[@id='btStartSearch']"));
		action.moveToElement(searchButton).build().perform();
		elementLibrary.click(searchButton);
		UIElement searchResult = new UIElement("searchResult", IdentifyBy.XPATH, "//span[text()='William Zhang']");
		elementLibrary.waitForElementToDisplay(searchResult);

	}

	@And("^Open the result in CRM-Grid$")
	public void clickOpenResult() throws Throwable {

		elementLibrary.click(openCRMGridButtonOnAdvanceSearch);
		Thread.sleep(5000);
	}

	@And("^Click on Export to Excel button$")
	public void clickExportToExcel() throws Throwable {
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		UIElement exportToExcel = new UIElement("exportToExcel", IdentifyBy.XPATH,
				"//button[@aria-label='Export to Excel']");
		elementLibrary.waitForElementToDisplay(exportToExcel);

		elementLibrary.click(exportToExcel);
		Thread.sleep(8000);
		if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
			Assert.fail("The script error displayed");

		}
//		if(!driver.findElements(By.xpath("//h1[@id='dialogTitleText']")).isEmpty()){
//			Assert.fail("The script error displayed");
//		}

	}

	@Then("^Validate the counts for Relationship are same with the ones in exported excel$")
	public void validateExportToExcel() throws Throwable {

		Thread.sleep(10000);
		String sheetName = "MSCRM-ADDONS PowerSearch";
		String fileName = elementLibrary
				.getLastExportedExcelFileName(System.getProperty("user.dir") + "\\target\\Downloads\\");
		WebElement table = driver.findElement(By.xpath("//div[@class='wj-cells']"));
		System.out.println(table.getAttribute("data-row-count"));
		System.out.println(elementLibrary.getRowCountFromExcel(fileName, sheetName));
		if (String.valueOf(elementLibrary.getRowCountFromExcel(fileName, sheetName))
				.equals(table.getAttribute("data-row-count"))) {
			log.info("The row counts match with exported excel file");
		} else {

			Assert.fail("The row counts do not match with exported excel file");
		}

	}

	@Then("^Validate the counts for Contact are same with the ones in exported excel$")
	public void validateExportToExcelForContact() throws Throwable {

		validateExportToExcel();

	}

	@Then("^Validate the counts for Account are same with the ones in exported excel$")
	public void validateExportToExcelForAontact() throws Throwable {

		validateExportToExcel();

	}

	@Then("^Validate the counts for Opportunity are same with the ones in exported excel$")
	public void validateExportToExcelForOpportunity() throws Throwable {

		validateExportToExcel();

	}

	@Then("^Validate the counts for event are same with the ones in exported excel$")
	public void validateExportToExcelForEvent() throws Throwable {

		validateExportToExcel();

	}

	@Then("^Validate the counts for invitee are same with the ones in exported excel$")
	public void validateExportToExcelForInvitee() throws Throwable {

		validateExportToExcel();

	}

	// TC23
	@Then("^Select value in engagement type label$")
	public void selectValueInEngagementType() throws Exception {
		Thread.sleep(1000);
		elementLibrary.waitForElementToDisplay(engagementTypeContact);
		elementLibrary.selectDropdownBasedOnIndex(engagementTypeContact, 2);
		System.out.println("Select Engagement Type label successfully");

	}

	@Then("^Fill in value in notes label \"(.*?)\"$")
	public void fillInValueInNoteslabel(String notesValue) throws Exception {
		Thread.sleep(1000);
		WebElement iframeNotesForContact = driver
				.findElement(By.xpath("//iframe[@id='WebResource_Webresource_RichtextEditnotes']"));
		elementLibrary.switchToFrame(iframeNotesForContact);
//				  UIElement notesForPhoneCall = new UIElement("notesForPhoneCall",IdentifyBy.XPATH,"//div[@class='fr-element fr-view']");
		elementLibrary.click(notesForPhoneCall);
		elementLibrary.enterText(notesForPhoneCall, notesValue);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
	}

	@Then("^Select value in Products label \"(.*?)\"$")
	public void selectValueInProducts(String productsValue) throws Exception {
//		Thread.sleep(1000);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_TAB);
//		Thread.sleep(1000);
//		robot.keyPress(KeyEvent.VK_TAB);
//		Thread.sleep(1000);
//		robot.keyPress(KeyEvent.VK_TAB);
//		Thread.sleep(1000);
//		elementLibrary.enterTextUsingSendkeys(productsForPhoneCall, productsValue);
//		Thread.sleep(1000);
//		elementLibrary.click(tacOppsForPhoneCall);
//		Thread.sleep(3000);
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		elementLibrary.enterTextUsingSendkeys(productsForPhoneCall, productsValue);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		elementLibrary.click(tacOppsForPhoneCall);
		Thread.sleep(3000);
	}

	@Then("^Select value in Reasons to Contact label$")
	public void selectValueInReasonsToContact() throws Exception {
		Thread.sleep(7000);
		WebDriver webdriver = webdriverServiceLibrary.getWebDriver();
		Actions action = new Actions(webdriver);
		WebElement internalAttendeesForPhoneCall = webdriver.findElement(By.xpath("//h2[@title='Internal Attendees']"));
		action.moveToElement(internalAttendeesForPhoneCall).build().perform();
		Thread.sleep(2000);
		WebElement iframeReasonsToContact = driver.findElement(By.xpath("//iframe[@id='WebResource_RTCs']"));
		elementLibrary.switchToFrame(iframeReasonsToContact);
//			     UIElement firstValue = new UIElement("firstValue",IdentifyBy.XPATH,("(//input[@class='wj-cell-check'])[1]"));
		elementLibrary.click(firstValue);
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
	}

//		@Then("^Select value in Additional Relationships$")
//		public void selectValueInAdditionalRelationship() throws Exception {
//			WebDriver webdriver = webdriverServiceLibrary.getWebDriver();
//			Actions action = new Actions(webdriver);
//			WebElement addRelationshipsView = webdriver.findElement(By.xpath("//h2[@title='Additional Relationships']"));
//			action.moveToElement(addRelationshipsView).build().perform();
	//
//				 Thread.sleep(1000);
//				 ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
//	             Thread.sleep(2000);
//			UIElement valueForCompany = new UIElement("valueForCompany", IdentifyBy.XPATH, "//span[text()='3M Company']");
//			elementLibrary.click(valueForCompany);
//		}

	@Then("^Validate value in engagement type label$")
	public void validateValueInEnagementTypeLabel() throws Exception {
		if (elementLibrary.getAttribute(engagementTypeContact, "title").equalsIgnoreCase("Catch Up")) {
			log.info("Select value in engagement type successfully");
		} else {
			Assert.fail("Select value in engagement type unsuccessfully");
		}
	}

	@Then("^Validate value in notes label \"(.*?)\"$")
	public void validateValueInNotesLabel(String notesValue) throws Exception {
		Thread.sleep(1000);
		WebElement iframeNotesForContact = driver
				.findElement(By.xpath("//iframe[@id='WebResource_Webresource_RichtextEditnotes']"));
		elementLibrary.switchToFrame(iframeNotesForContact);
		if (elementLibrary.getAttribute(notesForPhoneCall, "text").equalsIgnoreCase(notesValue)) {
			log.info("Fill value in Notes label successfully");
		} else {
			Assert.fail("Fill value in Notes label unsuccessfully");
		}
		driver.switchTo().defaultContent();

	}

//TC32
	@Then("^Click on all ribbon buttons in contact reocrd page and make sure no error is displayed$")
	public void validateRibbonButtonsInContactPage() throws Exception {
		UIElement ribbonsInContact_Meeting = new UIElement("ribbonsInContact_Meeting", IdentifyBy.XPATH,
				elementLibrary.getCellData("RibbonButtonsOnContact.xls", "Meeting"));
		UIElement ribbonsInContact_PhoneCall = new UIElement("ribbonsInContact_PhoneCall", IdentifyBy.XPATH,
				elementLibrary.getCellData("RibbonButtonsOnContact.xls", "Phone Call"));
		UIElement ribbonsInContact_PhoneCallVM = new UIElement("ribbonsInContact_PhoneCallVM", IdentifyBy.XPATH,
				elementLibrary.getCellData("RibbonButtonsOnContact.xls", "Phone Call - VM"));
		UIElement ribbonsInContact_Task = new UIElement("ribbonsInContact_Task", IdentifyBy.XPATH,
				elementLibrary.getCellData("RibbonButtonsOnContact.xls", "Task"));
		UIElement ribbonsInContact_PIMCOAssets = new UIElement("ribbonsInContact_PIMCOAssets", IdentifyBy.XPATH,
				elementLibrary.getCellData("RibbonButtonsOnContact.xls", "PIMCO Assets"));
		UIElement ribbonsInContact_AddOpportunity = new UIElement("ribbonsInContact_AddOpportunity", IdentifyBy.XPATH,
				elementLibrary.getCellData("RibbonButtonsOnContact.xls", "Add Opportunity"));
		UIElement ribbonsInContact_AddToMarketingList = new UIElement("ribbonsInContact_AddToMarketingList",
				IdentifyBy.XPATH, elementLibrary.getCellData("RibbonButtonsOnContact.xls", "Add to Marketing List"));
		UIElement ribbonsInContact_OrderLiterature = new UIElement("ribbonsInContact_OrderLiterature", IdentifyBy.XPATH,
				elementLibrary.getCellData("RibbonButtonsOnContact.xls", "Order Literature"));

		UIElement titleForNewTask = new UIElement("titleForNewTask", IdentifyBy.XPATH,
				"//h1[text()='Quick Create: Task']");
		UIElement ribbonButton_RetailPortfolioAnalysis = new UIElement("ribbonButton_RetailPortfolioAnalysis",
				IdentifyBy.XPATH,
				elementLibrary.getCellData("RibbonButtonsOnContact.xls", "Retail Portfolio Analysis"));
//			UIElement ribbonButton_InstSolnStudies = new UIElement("ribbonButton_InstSolnStudies", IdentifyBy.XPATH,
//					elementLibrary.getCellData("RibbonButtonsOnContact.xls", "Inst.Soln.Studies"));

		UIElement ribbonButton_CoverageChangeRequest = new UIElement("ribbonButton_CoverageChangeRequest",
				IdentifyBy.XPATH, elementLibrary.getCellData("RibbonButtonsOnContact.xls", "Coverage Change Request"));
		UIElement ribbonButton_SpeakerRequest = new UIElement("ribbonButton_SpeakerRequest", IdentifyBy.XPATH,
				elementLibrary.getCellData("RibbonButtonsOnContact.xls", "Speaker Request"));
		UIElement ribbonButton_Deactivate = new UIElement("ribbonButton_Deactivate", IdentifyBy.XPATH,
				elementLibrary.getCellData("RibbonButtonsOnContact.xls", "Deactivate"));
		UIElement ribbonButton_Refresh = new UIElement("ribbonButton_Refresh", IdentifyBy.XPATH,
				elementLibrary.getCellData("RibbonButtonsOnContact.xls", "Refresh"));
		UIElement ribbonButton_Share = new UIElement("ribbonButton_Share", IdentifyBy.XPATH,
				elementLibrary.getCellData("RibbonButtonsOnContact.xls", "Share"));
		UIElement ribbonButton_EmailDetails = new UIElement("ribbonButton_EmailDetails", IdentifyBy.XPATH,
				elementLibrary.getCellData("RibbonButtonsOnContact.xls", "EmailDetails"));
//			UIElement ribbonButton_AddInstOpportunity = new UIElement("ribbonButton_AddInstOpportunity", IdentifyBy.XPATH,
//					elementLibrary.getCellData("RibbonButtonsOnContact.xls", "AddInstOpportunity"));
		UIElement ribbonButton_CSAAnalysisRequests = new UIElement("ribbonButton_CSAAnalysisRequests", IdentifyBy.XPATH,
				elementLibrary.getCellData("RibbonButtonsOnContact.xls", "CS&A Analysis Requests"));
		UIElement ribbonButton_EmailLink = new UIElement("ribbonButton_CSAAnalysisRequests", IdentifyBy.XPATH,
				elementLibrary.getCellData("RibbonButtonsOnContact.xls", "Email Link"));
		UIElement ribbonButton_exportToPDF = new UIElement("ribbonButton_exportToPDF", IdentifyBy.XPATH,
				elementLibrary.getCellData("RibbonButtonsOnContact.xls", "Export to PDF"));
		UIElement ribbonButton_InstOpportunity = new UIElement("ribbonButton_InstOpportunity", IdentifyBy.XPATH,
				elementLibrary.getCellData("RibbonButtonsOnContact.xls", "Institutional Opportunity"));
		UIElement ribbonButton_RetailOpportunity = new UIElement("ribbonButton_RetailOpportunity", IdentifyBy.XPATH,
				elementLibrary.getCellData("RibbonButtonsOnContact.xls", "Retail Opportunity"));

		String sheetName = EnvironmentConfig.getAPP();
//			String appName = EnvironmentConfig.getAPP();
//			WebDriver driver = webdriverServiceLibrary.getWebDriver();
//			Set<String> childids = driver.getWindowHandles();

		if (sheetName.equals("Institutional")) {
			UIElement[] ribbonButtonsList = { ribbonsInContact_Task, ribbonsInContact_Meeting, // 0,1
					ribbonsInContact_PhoneCall, ribbonsInContact_PhoneCallVM, // 2,3
					ribbonsInContact_PIMCOAssets, ribbonsInContact_AddOpportunity, // 4,5
					ribbonsInContact_OrderLiterature, ribbonsInContact_AddToMarketingList, // 6,7
					ribbonButton_RetailPortfolioAnalysis, ribbonButton_CSAAnalysisRequests, // 8,9
					ribbonButton_CoverageChangeRequest, ribbonButton_SpeakerRequest, // 10,11
					ribbonButton_Deactivate, ribbonButton_Refresh, // 12,13
					ribbonButton_Share, ribbonButton_EmailDetails, // 14,15
					ribbonButton_EmailLink, ribbonButton_exportToPDF }; // 16,17

			String parentWindowHandle = driver.getWindowHandle();

			Thread.sleep(1000);
			for (int iLoop = 10; iLoop < ribbonButtonsList.length; iLoop++) {
				if (iLoop == 0) {
					elementLibrary.waitForElementToDisplay(addActivity);
					elementLibrary.click(addActivity);
					elementLibrary.waitForElementToDisplay(ribbonButtonsList[iLoop]);
					elementLibrary.click(ribbonButtonsList[iLoop]);
					Thread.sleep(1000);
					elementLibrary.waitForElementToDisplay(titleForNewTask);
					if (elementLibrary.iselementDisplayed(titleForNewTask)) {
						log.info("Open new task page successfully");
					} else {
						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonsList[iLoop].getName());
						break;
					}

					elementLibrary.click(cancelButtonForQuickCreateTask);
					elementLibrary.waitForElementToDisplay(cancelButton);
					elementLibrary.click(cancelButton);

				} else if (0 < iLoop && iLoop < 4) {
					elementLibrary.click(addActivity);
					elementLibrary.waitForElementToDisplay(ribbonButtonsList[iLoop]);
					elementLibrary.click(ribbonButtonsList[iLoop]);
					System.out.println("Button name:" + ribbonButtonsList[iLoop]);
					Thread.sleep(8000);
					for (String currentWindowHandle : driver.getWindowHandles()) {
						driver.switchTo().window(currentWindowHandle);
					}
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonsList[iLoop].getName());
						break;
					}
					driver.close();
					driver.switchTo().window(parentWindowHandle);
					Thread.sleep(2000);
				} else if (iLoop == 4 || iLoop == 6) {
					Thread.sleep(3000);
					elementLibrary.click(ribbonButtonsList[iLoop]);
					Thread.sleep(8000);
					for (String currentWindowHandle : driver.getWindowHandles()) {
						driver.switchTo().window(currentWindowHandle);
					}
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonsList[iLoop].getName());
						break;
					}
					driver.close();
					driver.switchTo().window(parentWindowHandle);
					Thread.sleep(2000);
				} else if (iLoop == 5) {
					Thread.sleep(3000);
					elementLibrary.click(ribbonButtonsList[iLoop]);
					Thread.sleep(8000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonsList[iLoop].getName());
						break;
					}
					elementLibrary.click(goBackButton);
					Thread.sleep(3000);
					elementLibrary.click(discardChangesForNewINSTOpp);
					Thread.sleep(2000);
					// driver.close();
					// driver.switchTo().window(parentWindowHandle);
				} else if (iLoop == 7) {
					Thread.sleep(2000);
					elementLibrary.waitForElementToDisplay(ribbonButtonsList[iLoop]);
					elementLibrary.click(ribbonButtonsList[iLoop]);
					Thread.sleep(2000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonsList[iLoop].getName());
						break;
					}
					Thread.sleep(1000);
					elementLibrary.waitForElementToDisplay(cancelForMarketingList);
					elementLibrary.click(cancelForMarketingList);
				} else if (iLoop == 8) {
					elementLibrary.click(moreCommandsForContact);
					elementLibrary.waitForElementToDisplay(moreCommandButtonForCreateRequest);
					elementLibrary.click(moreCommandButtonForCreateRequest);
					elementLibrary.waitForElementToDisplay(moreCommandButtonForAnalysisRequest);
					elementLibrary.click(moreCommandButtonForAnalysisRequest);
					elementLibrary.click(ribbonButtonsList[iLoop]);
					Thread.sleep(7000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button: " + ribbonButtonsList[iLoop].getName());
						break;
					}
					elementLibrary.click(goBackButton);
					Thread.sleep(4000);
				} else if (iLoop == 9) {
					elementLibrary.click(moreCommandsForContact);
					elementLibrary.waitForElementToDisplay(moreCommandButtonForCreateRequest);
					elementLibrary.click(moreCommandButtonForCreateRequest);
					elementLibrary.waitForElementToDisplay(moreCommandButtonForAnalysisRequest);
					elementLibrary.click(moreCommandButtonForAnalysisRequest);
					elementLibrary.click(ribbonButtonsList[iLoop]);
					Thread.sleep(7000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button: " + ribbonButtonsList[iLoop].getName());
						break;
					}
					elementLibrary.click(goBackButton);
					Thread.sleep(3000);
					elementLibrary.click(discardChangesForNewINSTOpp);
					Thread.sleep(3000);

				} else if (iLoop == 10) {
					elementLibrary.waitForElementToDisplay(moreCommandsForContact);
					elementLibrary.click(moreCommandsForContact);
					elementLibrary.waitForElementToDisplay(moreCommandButtonForCreateRequest);
					elementLibrary.click(moreCommandButtonForCreateRequest);
					elementLibrary.waitForElementToDisplay(ribbonButtonsList[iLoop]);
					elementLibrary.click(ribbonButtonsList[iLoop]);
					Thread.sleep(5000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button: " + ribbonButtonsList[iLoop].getName());
						break;
					}
					elementLibrary.click(goBackButton);
					Thread.sleep(4000);
//						elementLibrary.waitForElementToDisplay(discardChangesForNewINSTOpp);
//					    elementLibrary.click(discardChangesForNewINSTOpp);
				}

				else if (iLoop == 11) {
					elementLibrary.waitForElementToDisplay(moreCommandsForContact);
					elementLibrary.click(moreCommandsForContact);
					elementLibrary.waitForElementToDisplay(moreCommandButtonForCreateRequest);
					elementLibrary.click(moreCommandButtonForCreateRequest);
					elementLibrary.waitForElementToDisplay(ribbonButtonsList[iLoop]);
					elementLibrary.click(ribbonButtonsList[iLoop]);
					Thread.sleep(5000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button: " + ribbonButtonsList[iLoop].getName());
						break;
					}
					elementLibrary.click(goBackButton);
					Thread.sleep(6000);
					elementLibrary.waitForElementToDisplay(discardChangesForNewINSTOpp);
					elementLibrary.click(discardChangesForNewINSTOpp);
				}

				else if (iLoop == 12) {
					elementLibrary.waitForElementToDisplay(moreCommandsForContact);
					elementLibrary.click(moreCommandsForContact);
					elementLibrary.waitForElementToDisplay(ribbonButtonsList[iLoop]);
					elementLibrary.click(ribbonButtonsList[iLoop]);
//						if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
//							Assert.fail("Pop up error when clicked ribbon button: " + ribbonButtonsList[iLoop].getName());
//							break;
//						}
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("Pop up error when clicked ribbon button: " + ribbonButtonsList[iLoop].getName());
						System.out.println(
								"Pop up error when clicked ribbon button: " + ribbonButtonsList[iLoop].getName());
					}
					Thread.sleep(4000);
					elementLibrary.waitForElementToDisplay(cancelDeactivateButtonForContact);
					elementLibrary.click(cancelDeactivateButtonForContact);
				}

				else if (iLoop == 13) {
					elementLibrary.waitForElementToDisplay(moreCommandsForContact);
					elementLibrary.click(moreCommandsForContact);
					elementLibrary.waitForElementToDisplay(ribbonButtonsList[iLoop]);
					elementLibrary.click(ribbonButtonsList[iLoop]);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button: " + ribbonButtonsList[iLoop].getName());
						break;
					}
					Thread.sleep(10000);
//				} else if (iLoop == 14) {
//					elementLibrary.waitForElementToDisplay(moreCommandsForContact);
//					elementLibrary.click(moreCommandsForContact);
//					elementLibrary.waitForElementToDisplay(moreCommandButtonForCollaborate);
//					elementLibrary.click(moreCommandButtonForCollaborate);
////						elementLibrary.waitForElementToDisplay(ribbonButtonsList[iLoop]);
////						elementLibrary.click(ribbonButtonsList[iLoop]);
//					Thread.sleep(3000);
//					elementLibrary.waitForElementToDisplay(ribbonButtonsList[iLoop]);
//					elementLibrary.click(ribbonButtonsList[iLoop]);
//					Thread.sleep(8000);
//					WebElement Iframe_Dialog = driver.findElement(By.xpath("//iframe[@id='InlineDialog_Iframe']"));
//					elementLibrary.switchToFrame(Iframe_Dialog);
//					elementLibrary.waitForElementToDisplay(dialogcancelButton);
//					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
//						Assert.fail("Pop up error when clicked ribbon button:  " + ribbonButtonsList[iLoop].getName());
//						break;
//					}
//					elementLibrary.click(dialogcancelButton);
//					Thread.sleep(2000);
				} else if (iLoop == 15) {
					elementLibrary.waitForElementToDisplay(moreCommandsForContact);
					elementLibrary.click(moreCommandsForContact);
					elementLibrary.waitForElementToDisplay(moreCommandButtonForCollaborate);
					elementLibrary.click(moreCommandButtonForCollaborate);
					elementLibrary.waitForElementToDisplay(ribbonButtonsList[iLoop]);
					elementLibrary.click(ribbonButtonsList[iLoop]);
					Thread.sleep(8000);
					for (String currentWindowHandle : driver.getWindowHandles()) {
						driver.switchTo().window(currentWindowHandle);
					}
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonsList[iLoop].getName());
						break;
					}
//						driver.close();
//						driver.switchTo().window(parentWindowHandle);
					driver.close();
					driver.switchTo().window(parentWindowHandle);
					Thread.sleep(4000);
//				} else if (iLoop == 17) {
//					elementLibrary.waitForElementToDisplay(moreCommandsForContact);
//					elementLibrary.click(moreCommandsForContact);
//					elementLibrary.waitForElementToDisplay(ribbonButtonsList[iLoop]);
//					elementLibrary.click(ribbonButtonsList[iLoop]);
//					Thread.sleep(8000);
////							WebElement Iframe_Dialog = driver.findElement(By.xpath("//iframe[@id='InlineDialog_Iframe']"));
////							elementLibrary.switchToFrame(Iframe_Dialog);
////							elementLibrary.waitForElementToDisplay(closePDFPreviewDialog);
//					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
//						Assert.fail("Pop up error when clicked ribbon button: " + ribbonButtonsList[iLoop].getName());
//						break;
//					}
				}
			}
		}
//					else if (iLoop == 16) {
//						elementLibrary.waitForElementToDisplay(moreCommandsForContact);
//						elementLibrary.click(moreCommandsForContact);
//						elementLibrary.waitForElementToDisplay(moreCommandButtonForCollaborate);
//						elementLibrary.click(moreCommandButtonForCollaborate);
//						
////						elementLibrary.waitForElementToDisplay(ribbonButtonsList[iLoop]);
////						elementLibrary.click(ribbonButtonsList[iLoop]);
//						
//						elementLibrary.waitForElementToDisplay(ribbonButtonsList[iLoop]);
//						elementLibrary.click(ribbonButtonsList[iLoop]);
//						Thread.sleep(8000);
//						if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
//							Assert.fail("Pop up error when clicked ribbon button:  " + ribbonButtonsList[iLoop].getName());
//							break;
//						}
//					}

		else if (sheetName.equals("Retail")) {
			UIElement[] ribbonButtonsList = { ribbonsInContact_Task, ribbonsInContact_Meeting, // (0,1)
					ribbonsInContact_PhoneCall, ribbonsInContact_PhoneCallVM, // (2,3)
					ribbonsInContact_PIMCOAssets, ribbonsInContact_AddOpportunity, // (4,5)
					ribbonsInContact_OrderLiterature, ribbonsInContact_AddToMarketingList, // (6,7)
					ribbonButton_RetailPortfolioAnalysis, ribbonButton_CSAAnalysisRequests, // (8,9)
					ribbonButton_CoverageChangeRequest, ribbonButton_SpeakerRequest, // (10,11)
					ribbonButton_Deactivate, ribbonButton_Refresh, // (12,13)
					ribbonButton_Share, ribbonButton_EmailDetails, // (14,15)
					ribbonButton_EmailLink, ribbonButton_exportToPDF }; // (16,17)

			elementLibrary.waitForElementToDisplay(addActivity);
			String parentWindowHandle = driver.getWindowHandle();

			Thread.sleep(1000);
			for (int iLoop = 0; iLoop < ribbonButtonsList.length; iLoop++) {
				if (iLoop == 0) {

					elementLibrary.click(addActivity);
					elementLibrary.waitForElementToDisplay(ribbonButtonsList[iLoop]);
					elementLibrary.click(ribbonButtonsList[iLoop]);
					Thread.sleep(1000);
					elementLibrary.waitForElementToDisplay(titleForNewTask);
					if (elementLibrary.iselementDisplayed(titleForNewTask)) {
						log.info("Open new task page successfully");
					} else {
						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonsList[iLoop].getName());
						break;
					}

					elementLibrary.click(cancelButtonForQuickCreateTask);
					elementLibrary.waitForElementToDisplay(cancelButton);
					elementLibrary.click(cancelButton);

				} else if (0 < iLoop && iLoop < 4) {
					elementLibrary.click(addActivity);
					elementLibrary.waitForElementToDisplay(ribbonButtonsList[iLoop]);
					elementLibrary.click(ribbonButtonsList[iLoop]);
					System.out.println("Button name:" + ribbonButtonsList[iLoop]);
					Thread.sleep(8000);
					for (String currentWindowHandle : driver.getWindowHandles()) {
						driver.switchTo().window(currentWindowHandle);
					}
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonsList[iLoop].getName());
						break;
					}
					driver.close();
					driver.switchTo().window(parentWindowHandle);
					Thread.sleep(2000);
				} else if (iLoop == 4 || iLoop == 6) {
					Thread.sleep(3000);
					elementLibrary.click(ribbonButtonsList[iLoop]);
					Thread.sleep(8000);
					for (String currentWindowHandle : driver.getWindowHandles()) {
						driver.switchTo().window(currentWindowHandle);
					}
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonsList[iLoop].getName());
						break;
					}
					driver.close();
					driver.switchTo().window(parentWindowHandle);
					Thread.sleep(2000);
				} else if (iLoop == 5) {
					Thread.sleep(3000);
					elementLibrary.click(ribbonButtonsList[iLoop]);
					Thread.sleep(8000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonsList[iLoop].getName());
						break;
					}
					elementLibrary.click(goBackButton);
					Thread.sleep(3000);
					elementLibrary.click(discardChangesForNewINSTOpp);
					Thread.sleep(2000);
					// driver.close();
					// driver.switchTo().window(parentWindowHandle);
				} else if (iLoop == 7) {
					Thread.sleep(2000);
					elementLibrary.waitForElementToDisplay(ribbonButtonsList[iLoop]);
					elementLibrary.click(ribbonButtonsList[iLoop]);
					Thread.sleep(2000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonsList[iLoop].getName());
						break;
					}
					Thread.sleep(1000);
					elementLibrary.waitForElementToDisplay(cancelForMarketingList);
					elementLibrary.click(cancelForMarketingList);
				} else if (iLoop == 8) {
					elementLibrary.click(moreCommandsForContact);
					elementLibrary.waitForElementToDisplay(moreCommandButtonForCreateRequest);
					elementLibrary.click(moreCommandButtonForCreateRequest);
					elementLibrary.waitForElementToDisplay(moreCommandButtonForAnalysisRequest);
					elementLibrary.click(moreCommandButtonForAnalysisRequest);
					elementLibrary.click(ribbonButtonsList[iLoop]);
					Thread.sleep(7000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button: " + ribbonButtonsList[iLoop].getName());
						break;
					}
					elementLibrary.click(goBackButton);
					Thread.sleep(4000);
				} else if (iLoop == 9) {
					elementLibrary.click(moreCommandsForContact);
					elementLibrary.waitForElementToDisplay(moreCommandButtonForCreateRequest);
					elementLibrary.click(moreCommandButtonForCreateRequest);
					elementLibrary.waitForElementToDisplay(moreCommandButtonForAnalysisRequest);
					elementLibrary.click(moreCommandButtonForAnalysisRequest);
					elementLibrary.click(ribbonButtonsList[iLoop]);
					Thread.sleep(7000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button: " + ribbonButtonsList[iLoop].getName());
						break;
					}
					elementLibrary.click(goBackButton);
					Thread.sleep(3000);
					elementLibrary.click(discardChangesForNewINSTOpp);
					Thread.sleep(3000);

				} else if (iLoop == 10) {
					elementLibrary.waitForElementToDisplay(moreCommandsForContact);
					elementLibrary.click(moreCommandsForContact);
					elementLibrary.waitForElementToDisplay(moreCommandButtonForCreateRequest);
					elementLibrary.click(moreCommandButtonForCreateRequest);
					elementLibrary.waitForElementToDisplay(ribbonButtonsList[iLoop]);
					elementLibrary.click(ribbonButtonsList[iLoop]);
					Thread.sleep(5000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button: " + ribbonButtonsList[iLoop].getName());
						break;
					}
					elementLibrary.click(goBackButton);
					Thread.sleep(4000);
//								elementLibrary.waitForElementToDisplay(discardChangesForNewINSTOpp);
//							    elementLibrary.click(discardChangesForNewINSTOpp);
				}

				else if (iLoop == 11) {
					elementLibrary.waitForElementToDisplay(moreCommandsForContact);
					elementLibrary.click(moreCommandsForContact);
					elementLibrary.waitForElementToDisplay(moreCommandButtonForCreateRequest);
					elementLibrary.click(moreCommandButtonForCreateRequest);
					elementLibrary.waitForElementToDisplay(ribbonButtonsList[iLoop]);
					elementLibrary.click(ribbonButtonsList[iLoop]);
					Thread.sleep(5000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button: " + ribbonButtonsList[iLoop].getName());
						break;
					}
					elementLibrary.click(goBackButton);
					Thread.sleep(4000);
					elementLibrary.waitForElementToDisplay(discardChangesForNewINSTOpp);
					elementLibrary.click(discardChangesForNewINSTOpp);
				}

				else if (iLoop == 12) {
					elementLibrary.waitForElementToDisplay(moreCommandsForContact);
					elementLibrary.click(moreCommandsForContact);
					elementLibrary.waitForElementToDisplay(ribbonButtonsList[iLoop]);
					elementLibrary.click(ribbonButtonsList[iLoop]);
//								if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
//									Assert.fail("Pop up error when clicked ribbon button: " + ribbonButtonsList[iLoop].getName());
//									break;
//								}
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("Pop up error when clicked ribbon button: " + ribbonButtonsList[iLoop].getName());
						System.out.println(
								"Pop up error when clicked ribbon button: " + ribbonButtonsList[iLoop].getName());
					}
					Thread.sleep(4000);
					elementLibrary.waitForElementToDisplay(cancelDeactivateButtonForContact);
					elementLibrary.click(cancelDeactivateButtonForContact);
				}

				else if (iLoop == 13) {
					elementLibrary.waitForElementToDisplay(moreCommandsForContact);
					elementLibrary.click(moreCommandsForContact);
					elementLibrary.waitForElementToDisplay(ribbonButtonsList[iLoop]);
					elementLibrary.click(ribbonButtonsList[iLoop]);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button: " + ribbonButtonsList[iLoop].getName());
						break;
					}
					Thread.sleep(10000);
//				} else if (iLoop == 14) {
//					elementLibrary.waitForElementToDisplay(moreCommandsForContact);
//					elementLibrary.click(moreCommandsForContact);
//					elementLibrary.waitForElementToDisplay(moreCommandButtonForCollaborate);
//					elementLibrary.click(moreCommandButtonForCollaborate);
////								elementLibrary.waitForElementToDisplay(ribbonButtonsList[iLoop]);
////								elementLibrary.click(ribbonButtonsList[iLoop]);
//					Thread.sleep(3000);
//					elementLibrary.waitForElementToDisplay(ribbonButtonsList[iLoop]);
//					elementLibrary.click(ribbonButtonsList[iLoop]);
//					Thread.sleep(8000);
//					WebElement Iframe_Dialog = driver.findElement(By.xpath("//iframe[@id='InlineDialog_Iframe']"));
//					elementLibrary.switchToFrame(Iframe_Dialog);
//					elementLibrary.waitForElementToDisplay(dialogcancelButton);
//					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
//						Assert.fail("Pop up error when clicked ribbon button:  " + ribbonButtonsList[iLoop].getName());
//						break;
//					}
//					elementLibrary.click(dialogcancelButton);
				} else if (iLoop == 15) {
					elementLibrary.waitForElementToDisplay(moreCommandsForContact);
					elementLibrary.click(moreCommandsForContact);
					elementLibrary.waitForElementToDisplay(moreCommandButtonForCollaborate);
					elementLibrary.click(moreCommandButtonForCollaborate);
					elementLibrary.waitForElementToDisplay(ribbonButtonsList[iLoop]);
					elementLibrary.click(ribbonButtonsList[iLoop]);
					Thread.sleep(8000);
					for (String currentWindowHandle : driver.getWindowHandles()) {
						driver.switchTo().window(currentWindowHandle);
					}
//								WebElement Iframe_Dialog = driver.findElement(By.xpath("//iframe[@id='InlineDialog_Iframe']"));
//								elementLibrary.switchToFrame(Iframe_Dialog);
//								elementLibrary.waitForElementToDisplay(dialogcancelButton);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonsList[iLoop].getName());
						break;
					}
					driver.close();
					driver.switchTo().window(parentWindowHandle);
					Thread.sleep(4000);

//				} else if (iLoop == 17) {
//					elementLibrary.waitForElementToDisplay(moreCommandsForContact);
//					elementLibrary.click(moreCommandsForContact);
//					elementLibrary.waitForElementToDisplay(ribbonButtonsList[iLoop]);
//					elementLibrary.click(ribbonButtonsList[iLoop]);
//					Thread.sleep(8000);
////								WebElement Iframe_Dialog = driver.findElement(By.xpath("//iframe[@id='InlineDialog_Iframe']"));
////								elementLibrary.switchToFrame(Iframe_Dialog);
////								elementLibrary.waitForElementToDisplay(closePDFPreviewDialog);
//					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
//						Assert.fail("Pop up error when clicked ribbon button: " + ribbonButtonsList[iLoop].getName());
//						break;
//					}

				}
			}
		}

		else if (sheetName.equals("Hybrid")) {
			UIElement[] ribbonButtonsList = { ribbonsInContact_Task, ribbonsInContact_Meeting, // (0,1)
					ribbonsInContact_PhoneCall, ribbonsInContact_PhoneCallVM, // (2,3)
					ribbonsInContact_PIMCOAssets, ribbonButton_InstOpportunity, // (4,5)
					ribbonsInContact_OrderLiterature, ribbonsInContact_AddToMarketingList, // (6,7)
					ribbonButton_RetailPortfolioAnalysis, ribbonButton_CSAAnalysisRequests, // (8,9)
					ribbonButton_CoverageChangeRequest, ribbonButton_SpeakerRequest, // (10,11)
					ribbonButton_Deactivate, ribbonButton_Refresh, // (12,13)
					ribbonButton_Share, ribbonButton_EmailDetails, // (14,15)
					ribbonButton_EmailLink, ribbonButton_RetailOpportunity, // (16,17)
					ribbonButton_exportToPDF // (18)
			};
			elementLibrary.waitForElementToDisplay(addActivity);
			String parentWindowHandle = driver.getWindowHandle();

			Thread.sleep(1000);
			for (int iLoop = 0; iLoop < ribbonButtonsList.length; iLoop++) {
				if (iLoop == 0) {

					elementLibrary.click(addActivity);
					elementLibrary.waitForElementToDisplay(ribbonButtonsList[iLoop]);
					elementLibrary.click(ribbonButtonsList[iLoop]);
					Thread.sleep(1000);
					elementLibrary.waitForElementToDisplay(titleForNewTask);
					if (elementLibrary.iselementDisplayed(titleForNewTask)) {
						log.info("Open new task page successfully");
					} else {
						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonsList[iLoop].getName());
						break;
					}

					elementLibrary.click(cancelButtonForQuickCreateTask);
					elementLibrary.waitForElementToDisplay(cancelButton);
					elementLibrary.click(cancelButton);

				} else if (0 < iLoop && iLoop < 4) {
					elementLibrary.click(addActivity);
					elementLibrary.waitForElementToDisplay(ribbonButtonsList[iLoop]);
					elementLibrary.click(ribbonButtonsList[iLoop]);
					System.out.println("Button name:" + ribbonButtonsList[iLoop]);
					Thread.sleep(8000);
					for (String currentWindowHandle : driver.getWindowHandles()) {
						driver.switchTo().window(currentWindowHandle);
					}
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonsList[iLoop].getName());
						break;
					}
					driver.close();
					driver.switchTo().window(parentWindowHandle);
					Thread.sleep(2000);
				} else if (iLoop == 4) {
					Thread.sleep(3000);
					elementLibrary.click(ribbonButtonsList[iLoop]);
					Thread.sleep(8000);
					for (String currentWindowHandle : driver.getWindowHandles()) {
						driver.switchTo().window(currentWindowHandle);
					}
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonsList[iLoop].getName());
						break;
					}
					driver.close();
					driver.switchTo().window(parentWindowHandle);
					Thread.sleep(2000);
				}

				else if (iLoop == 6) {
					Thread.sleep(3000);
					elementLibrary.click(moreCommandsForContact);
					elementLibrary.click(ribbonButtonsList[iLoop]);
					Thread.sleep(8000);
					for (String currentWindowHandle : driver.getWindowHandles()) {
						driver.switchTo().window(currentWindowHandle);
					}
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonsList[iLoop].getName());
						break;
					}
					driver.close();
					driver.switchTo().window(parentWindowHandle);
					Thread.sleep(2000);
				}

				else if (iLoop == 5) {
					Thread.sleep(2000);
					elementLibrary.waitForElementToDisplay(addOpportunityDropDownButton);
					elementLibrary.click(addOpportunityDropDownButton);
					elementLibrary.waitForElementToDisplay(ribbonButtonsList[iLoop]);
					elementLibrary.click(ribbonButtonsList[iLoop]);

					Thread.sleep(8000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonsList[iLoop].getName());
						break;
					}
					elementLibrary.click(goBackButton);
					Thread.sleep(4000);
					elementLibrary.click(discardChangesForNewINSTOpp);
					Thread.sleep(2000);

				} else if (iLoop == 7) {
					Thread.sleep(2000);
					elementLibrary.waitForElementToDisplay(ribbonButtonsList[iLoop]);
					elementLibrary.click(ribbonButtonsList[iLoop]);
					Thread.sleep(2000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonsList[iLoop].getName());
						break;
					}
					Thread.sleep(1000);
					elementLibrary.waitForElementToDisplay(cancelForMarketingList);
					elementLibrary.click(cancelForMarketingList);
				} else if (iLoop == 8) {
					elementLibrary.click(moreCommandsForContact);
					elementLibrary.waitForElementToDisplay(moreCommandButtonForCreateRequest);
					elementLibrary.click(moreCommandButtonForCreateRequest);
					elementLibrary.waitForElementToDisplay(moreCommandButtonForAnalysisRequest);
					elementLibrary.click(moreCommandButtonForAnalysisRequest);
					elementLibrary.click(ribbonButtonsList[iLoop]);
					Thread.sleep(7000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button: " + ribbonButtonsList[iLoop].getName());
						break;
					}
					elementLibrary.click(goBackButton);
					Thread.sleep(4000);
				} else if (iLoop == 9) {
					elementLibrary.click(moreCommandsForContact);
					elementLibrary.waitForElementToDisplay(moreCommandButtonForCreateRequest);
					elementLibrary.click(moreCommandButtonForCreateRequest);
					elementLibrary.waitForElementToDisplay(moreCommandButtonForAnalysisRequest);
					elementLibrary.click(moreCommandButtonForAnalysisRequest);
					elementLibrary.click(ribbonButtonsList[iLoop]);
					Thread.sleep(7000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button: " + ribbonButtonsList[iLoop].getName());
						break;
					}
					elementLibrary.click(goBackButton);
					Thread.sleep(3000);
					elementLibrary.click(discardChangesForNewINSTOpp);
					Thread.sleep(3000);

				} else if (iLoop == 10) {
					elementLibrary.waitForElementToDisplay(moreCommandsForContact);
					elementLibrary.click(moreCommandsForContact);
					elementLibrary.waitForElementToDisplay(moreCommandButtonForCreateRequest);
					elementLibrary.click(moreCommandButtonForCreateRequest);
					elementLibrary.waitForElementToDisplay(ribbonButtonsList[iLoop]);
					elementLibrary.click(ribbonButtonsList[iLoop]);
					Thread.sleep(5000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button: " + ribbonButtonsList[iLoop].getName());
						break;
					}
					elementLibrary.click(goBackButton);
					Thread.sleep(4000);
//										elementLibrary.waitForElementToDisplay(discardChangesForNewINSTOpp);
//									    elementLibrary.click(discardChangesForNewINSTOpp);
				}

				else if (iLoop == 11) {
					elementLibrary.waitForElementToDisplay(moreCommandsForContact);
					elementLibrary.click(moreCommandsForContact);
					elementLibrary.waitForElementToDisplay(moreCommandButtonForCreateRequest);
					elementLibrary.click(moreCommandButtonForCreateRequest);
					elementLibrary.waitForElementToDisplay(ribbonButtonsList[iLoop]);
					elementLibrary.click(ribbonButtonsList[iLoop]);
					Thread.sleep(5000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button: " + ribbonButtonsList[iLoop].getName());
						break;
					}
					elementLibrary.click(goBackButton);
					Thread.sleep(4000);
					elementLibrary.waitForElementToDisplay(discardChangesForNewINSTOpp);
					elementLibrary.click(discardChangesForNewINSTOpp);
				}

				else if (iLoop == 12) {
					elementLibrary.waitForElementToDisplay(moreCommandsForContact);
					elementLibrary.click(moreCommandsForContact);
					elementLibrary.waitForElementToDisplay(ribbonButtonsList[iLoop]);
					elementLibrary.click(ribbonButtonsList[iLoop]);
//										if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
//											Assert.fail("Pop up error when clicked ribbon button: " + ribbonButtonsList[iLoop].getName());
//											break;
//										}
					if (elementLibrary.isAlertPresent(driver)) {
						Assert.fail("Pop up error when clicked ribbon button: " + ribbonButtonsList[iLoop].getName());
						System.out.println(
								"Pop up error when clicked ribbon button: " + ribbonButtonsList[iLoop].getName());
					}
					Thread.sleep(4000);
					elementLibrary.waitForElementToDisplay(cancelDeactivateButtonForContact);
					elementLibrary.click(cancelDeactivateButtonForContact);
				}

				else if (iLoop == 13) {
					elementLibrary.waitForElementToDisplay(moreCommandsForContact);
					elementLibrary.click(moreCommandsForContact);
					elementLibrary.waitForElementToDisplay(ribbonButtonsList[iLoop]);
					elementLibrary.click(ribbonButtonsList[iLoop]);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button: " + ribbonButtonsList[iLoop].getName());
						break;
					}
					Thread.sleep(10000);
//				} else if (iLoop == 14) {
//					elementLibrary.waitForElementToDisplay(moreCommandsForContact);
//					elementLibrary.click(moreCommandsForContact);
//					elementLibrary.waitForElementToDisplay(moreCommandButtonForCollaborate);
//					elementLibrary.click(moreCommandButtonForCollaborate);
////										elementLibrary.waitForElementToDisplay(ribbonButtonsList[iLoop]);
////										elementLibrary.click(ribbonButtonsList[iLoop]);
//					Thread.sleep(3000);
//					elementLibrary.waitForElementToDisplay(ribbonButtonsList[iLoop]);
//					elementLibrary.click(ribbonButtonsList[iLoop]);
//					Thread.sleep(8000);
//					WebElement Iframe_Dialog = driver.findElement(By.xpath("//iframe[@id='InlineDialog_Iframe']"));
//					elementLibrary.switchToFrame(Iframe_Dialog);
//					elementLibrary.waitForElementToDisplay(dialogcancelButton);
//					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
//						Assert.fail("Pop up error when clicked ribbon button:  " + ribbonButtonsList[iLoop].getName());
//						break;
//					}
//					elementLibrary.click(dialogcancelButton);
				} else if (iLoop == 15) {
					Thread.sleep(3000);
					elementLibrary.waitForElementToDisplay(moreCommandsForContact);
					elementLibrary.click(moreCommandsForContact);
					elementLibrary.waitForElementToDisplay(moreCommandButtonForCollaborate);
					elementLibrary.click(moreCommandButtonForCollaborate);
					elementLibrary.waitForElementToDisplay(ribbonButtonsList[iLoop]);
					elementLibrary.click(ribbonButtonsList[iLoop]);
					Thread.sleep(8000);
					for (String currentWindowHandle : driver.getWindowHandles()) {
						driver.switchTo().window(currentWindowHandle);
					}
//										WebElement Iframe_Dialog = driver.findElement(By.xpath("//iframe[@id='InlineDialog_Iframe']"));
//										elementLibrary.switchToFrame(Iframe_Dialog);
//										elementLibrary.waitForElementToDisplay(dialogcancelButton);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonsList[iLoop].getName());
						break;
					}
					driver.close();
					driver.switchTo().window(parentWindowHandle);
					Thread.sleep(4000);

//				} else if (iLoop == 18) {
//					elementLibrary.waitForElementToDisplay(moreCommandsForContact);
//					elementLibrary.click(moreCommandsForContact);
//					elementLibrary.waitForElementToDisplay(ribbonButtonsList[iLoop]);
//					elementLibrary.click(ribbonButtonsList[iLoop]);
//					Thread.sleep(8000);
////										WebElement Iframe_Dialog = driver.findElement(By.xpath("//iframe[@id='InlineDialog_Iframe']"));
////										elementLibrary.switchToFrame(Iframe_Dialog);
////										elementLibrary.waitForElementToDisplay(closePDFPreviewDialog);
//					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
//						Assert.fail("Pop up error when clicked ribbon button: " + ribbonButtonsList[iLoop].getName());
//						break;
//					}

				}

			}
		}

	}

	@Then("^Click on all ribbon buttons on the Retail opportunity \"(.*?)\" page and validate no error displayed$")
	public void validateAllRibbonButtonsOnRetailOpportunity(String opportunityName) throws Throwable {
		validateAllRibbonButtonsOnInstOpportunity(opportunityName);
	}

	@Then("^Click on all ribbon buttons on the Inst opportunity \"(.*?)\" page and validate no error displayed$")
	public void validateAllRibbonButtonsOnInstOpportunity(String opportunityName) throws Throwable {
		UIElement ribbonButton_Save = new UIElement("ribbonButton_Save", IdentifyBy.XPATH,
				elementLibrary.getCellData("AllRibbonButtonsOnInstOpportunity.xls", "Save"));
		UIElement ribbonButton_EmailOpportunity = new UIElement("ribbonButton_EmailOpportunity", IdentifyBy.XPATH,
				elementLibrary.getCellData("AllRibbonButtonsOnInstOpportunity.xls", "Email Opportunity"));
		UIElement ribbonButton_BusDevRequest = new UIElement("ribbonButton_BusDevRequest", IdentifyBy.XPATH,
				elementLibrary.getCellData("AllRibbonButtonsOnInstOpportunity.xls", "Bus Dev Request"));
		UIElement ribbonButton_Refresh = new UIElement("ribbonButton_Refresh", IdentifyBy.XPATH,
				elementLibrary.getCellData("AllRibbonButtonsOnInstOpportunity.xls", "Refresh"));
		UIElement ribbonButton_ExporttoPDF = new UIElement("ribbonButton_ExporttoPDF", IdentifyBy.XPATH,
				elementLibrary.getCellData("AllRibbonButtonsOnInstOpportunity.xls", "Export to PDF"));
		UIElement ribbonButton_CloseasLostCanceled = new UIElement("ribbonButton_CloseasLostCanceled", IdentifyBy.XPATH,
				elementLibrary.getCellData("AllRibbonButtonsOnInstOpportunity.xls", "Close as Lost/Canceled"));

		String sheetName = EnvironmentConfig.getAPP();

		if (sheetName.equals("Institutional")) {
			UIElement[] arryTiles = { ribbonButton_Save, ribbonButton_EmailOpportunity, ribbonButton_BusDevRequest,
					ribbonButton_Refresh,ribbonButton_CloseasLostCanceled };

			String base = driver.getWindowHandle();
			for (int iLoop = 0; iLoop < arryTiles.length; iLoop++) {

				if (iLoop == 0) {

					elementLibrary.click(arryTiles[iLoop]);
					Thread.sleep(5000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}

				} else if (iLoop == 1) {

					elementLibrary.click(arryTiles[iLoop]);
					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
					}
					Thread.sleep(10000);

					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}
					driver.close();
					driver.switchTo().window(base);
				} else if (iLoop == 2) {
					elementLibrary.click(moreCommandButtonForCreateRequest);
					elementLibrary.click(arryTiles[iLoop]);
					Thread.sleep(5000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}

					UIElement recentTab = new UIElement("recentTab", IdentifyBy.XPATH,
							"//span[contains(text(),'Recent')]");
					UIElement instOpporRecord = new UIElement("instOpporRecord", IdentifyBy.XPATH,
							"//span[text()='" + opportunityName + "']");
					elementLibrary.click(recentTab);
					Thread.sleep(3000);
					elementLibrary.click(instOpporRecord);
				} else if (iLoop == 3) {
					elementLibrary.click(arryTiles[iLoop]);
					Thread.sleep(5000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}
				} else if (iLoop == 4) {
					elementLibrary.click(arryTiles[iLoop]);
					Thread.sleep(10000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}
				}

			}
		} else if (sheetName.equals("Hybrid") || sheetName.equals("Retail")) {
			UIElement[] arryTiles = { ribbonButton_Save, ribbonButton_BusDevRequest, ribbonButton_Refresh,
					 ribbonButton_CloseasLostCanceled };

			for (int iLoop = 0; iLoop < arryTiles.length; iLoop++) {

				if (iLoop == 0) {

					elementLibrary.click(arryTiles[iLoop]);
					Thread.sleep(5000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}

				} else if (iLoop == 1) {
					elementLibrary.click(moreCommandButtonForCreateRequest);
					elementLibrary.click(arryTiles[iLoop]);
					Thread.sleep(5000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}

					UIElement recentTab = new UIElement("recentTab", IdentifyBy.XPATH,
							"//span[contains(text(),'Recent')]");
					UIElement instOpporRecord = new UIElement("instOpporRecord", IdentifyBy.XPATH,
							"//span[text()='" + opportunityName + "']");
					elementLibrary.click(recentTab);
					Thread.sleep(3000);
					elementLibrary.click(instOpporRecord);
				} else if (iLoop == 2) {
					elementLibrary.click(arryTiles[iLoop]);
					Thread.sleep(5000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}
				}  else if (iLoop == 3) {
					elementLibrary.click(arryTiles[iLoop]);
					Thread.sleep(10000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}
				}

			}
		}
	}

	@And("^Search an account \"(.*?)\" to Open$")
	public void openAnAccount(String accountNumber) throws Exception {
		UIElement accounName = new UIElement("accounName", IdentifyBy.XPATH, "//span[text()='3M VIP Credit']");
		Robot robot = new Robot();
		Thread.sleep(2000);
		elementLibrary.waitForElementToDisplay(relevanceSearchNew);
		elementLibrary.click(relevanceSearchNew);
		Thread.sleep(1000);
		elementLibrary.enterText(relevanceSearchNew, accountNumber);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(3000);
//
//		UIElement cancelButton = new UIElement("cancelButton", IdentifyBy.XPATH, "//button[@title='Close']//span[1]");
//		if (!driver.findElements(By.xpath("//h1[text()='Error']")).isEmpty()) {
//			elementLibrary.click(cancelButton);
//		}
//
//		elementLibrary.waitForElementToDisplay(relevanceSearchNew);
//		elementLibrary.click(relevanceSearchNew);
//		Thread.sleep(1000);
//		elementLibrary.enterText(relevanceSearchNew, accountNumber);
//		Thread.sleep(1000);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(3000);
		elementLibrary.waitForElementToDisplay(accounName);
		elementLibrary.click(accounName);
		browserLibrary.waitForLoad();
	}

	@Then("^Click on all ribbon buttons on the account and validate no error displayed$")
	public void validateAllRibbonButtonsOnAccount() throws Throwable {
		UIElement ribbonButton_HistoricalHoldings = new UIElement("ribbonButton_HistoricalHoldings", IdentifyBy.XPATH,
				elementLibrary.getCellData("AllRibbonButtonsOnAccount.xls", "Historical Holdings"));
		UIElement ribbonButton_ExporttoPDF = new UIElement("ribbonButton_ExporttoPDF", IdentifyBy.XPATH,
				elementLibrary.getCellData("AllRibbonButtonsOnAccount.xls", "Export to PDF"));
		UIElement ribbonButton_Refresh = new UIElement("ribbonButton_Refresh", IdentifyBy.XPATH,
				elementLibrary.getCellData("AllRibbonButtonsOnAccount.xls", "Refresh"));
		String sheetName = EnvironmentConfig.getAPP();

		if (sheetName.equals("Institutional") || sheetName.equals("Hybrid")) {
			UIElement[] arryTiles = { ribbonButton_HistoricalHoldings, ribbonButton_Refresh
					};

			String base = driver.getWindowHandle();
			for (int iLoop = 0; iLoop < arryTiles.length; iLoop++) {

				if (iLoop == 0) {

					elementLibrary.click(arryTiles[iLoop]);
					Thread.sleep(5000);
					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
					}
					Thread.sleep(10000);

					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}
					driver.close();
					driver.switchTo().window(base);

				} else if (iLoop == 1) {

					elementLibrary.click(arryTiles[iLoop]);
					Thread.sleep(3000);

					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}

				} 
			}
		}
	}

	@And("^Change area as \"(.*?)\"$")
	public void changeArea(String areaName) throws Throwable {

		UIElement area = new UIElement("area", IdentifyBy.XPATH, "//span[text()='" + areaName + "']");
		elementLibrary.waitForElementToDisplay(areaSwichButton);
		elementLibrary.click(areaSwichButton);
		elementLibrary.waitForElementToDisplay(area);
		elementLibrary.click(area);
	}

	@And("^Click new button on marketing list search page$")
	public void clickNewButton() throws Throwable {
		elementLibrary.waitForElementToDisplay(newMarketingListButton);
		elementLibrary.click(newMarketingListButton);
		browserLibrary.waitForLoad();
	}

	@Then("^Validate if the target page is opening without any error$")
	public void validateNewMarketingListPage() throws Throwable {
		if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
			Assert.fail("The script error displayed on the new marketing list page");

		}
	}

	@And("^Click Order Literature button$")
	public void clickOrderLiteratureButton() throws Throwable {
		
		UIElement moreCommandsForContact = new UIElement("moreCommandsForContact", IdentifyBy.XPATH,
				"//button[@aria-label='More commands for Contact']");
		UIElement ribbonsInContact_OrderLiterature = new UIElement("ribbonsInContact_OrderLiterature", IdentifyBy.XPATH,
				"//span[text()='Order Literature']");
		elementLibrary.waitForElementToDisplay(moreCommandsForContact);
		elementLibrary.click(moreCommandsForContact);
		elementLibrary.waitForElementToDisplay(ribbonsInContact_OrderLiterature);
		elementLibrary.click(ribbonsInContact_OrderLiterature);
	}

	@Then("^Validate if the Order Literature page is opening without any error$")
	public void validateOrderLiteraturePage() throws Throwable {

		Thread.sleep(5000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
			Assert.fail("The script error displayed on the new marketing list page");

		}
	}

	// TC35
	@And("^Search out and open the existing other contact record \"(.*?)\"$")
	public void openOtherExistingContact(String contactName) throws Exception {
		Robot robot = new Robot();
		Thread.sleep(2000);
		elementLibrary.waitForElementToDisplay(relevanceSearchNew);
		elementLibrary.click(relevanceSearchNew);
		Thread.sleep(1000);
		elementLibrary.enterText(relevanceSearchNew, contactName);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(4000);
//		//error dialog
//				elementLibrary.waitForElementToDisplay(okInErrorDialog);
//				Thread.sleep(1000);
//				elementLibrary.click(okInErrorDialog);
//				Thread.sleep(6000);
//				elementLibrary.waitForElementToDisplay(relevanceSearchNew);
//				elementLibrary.click(relevanceSearchNew);
//				Thread.sleep(1000);
//				elementLibrary.enterText(relevanceSearchNew, contactName);
//				Thread.sleep(1000);
//				robot.keyPress(KeyEvent.VK_ENTER);
//				Thread.sleep(5000);

//		elementLibrary.waitForElementToDisplay(fullNameForOtherContact);
//		elementLibrary.click(fullNameForOtherContact);
	}

	@Then("^Click on all ribbon buttons in phone call reocrd page and make sure no error is displayed$")
	public void validateRibbonButtonsInPhoneCallPage() throws Exception {
		Thread.sleep(5000);
		elementLibrary.waitForElementToDisplay(fullNameForOtherContact);
		elementLibrary.click(fullNameForOtherContact);
		Thread.sleep(7000);
		elementLibrary.waitForElementToDisplay(aCTIVITIESInContact);
		elementLibrary.click(aCTIVITIESInContact);
		Thread.sleep(5000);
		WebElement iframeActivityTabInContact = driver.findElement(By.xpath("//iframe[@id='WebResource_Activities']"));
		elementLibrary.switchToFrame(iframeActivityTabInContact);
		elementLibrary.click(phoneCallDataInContact);
		Thread.sleep(5000);

		UIElement ribbonsInPhoneCall_SaveButton = new UIElement("ribbonsInPhoneCall_SaveButton", IdentifyBy.XPATH,
				elementLibrary.getCellData("PhoneCallLabel.xls", "saveForPhoneCall"));
		UIElement ribbonsInPhoneCall_CopyActivity = new UIElement("ribbonsInPhoneCall_CopyActivity", IdentifyBy.XPATH,
				elementLibrary.getCellData("PhoneCallLabel.xls", "copyActivityForPhoneCall"));
		UIElement ribbonsInPhoneCall_MakeComplete = new UIElement("makeCompleteForPhoneCal", IdentifyBy.XPATH,
				elementLibrary.getCellData("PhoneCallLabel.xls", "makeCompleteForPhoneCall"));
		UIElement ribbonsInPhoneCall_CompleteClose = new UIElement("completeCloseForPhoneCall", IdentifyBy.XPATH,
				elementLibrary.getCellData("PhoneCallLabel.xls", "completeCloseForPhoneCall"));
		UIElement ribbonsInPhoneCall_EmailSummary = new UIElement("emailSummaryForPhoneCall", IdentifyBy.XPATH,
				elementLibrary.getCellData("PhoneCallLabel.xls", "emailSummaryForPhoneCall"));
		UIElement ribbonsInPhoneCall_Refresh = new UIElement("refreshForPhoneCall", IdentifyBy.XPATH,
				elementLibrary.getCellData("PhoneCallLabel.xls", "refreshForPhoneCall"));
		UIElement ribbonsInPhoneCall_delete = new UIElement("deleteForPhoneCalll", IdentifyBy.XPATH,
				elementLibrary.getCellData("PhoneCallLabel.xls", "deleteForPhoneCall"));
		UIElement ribbonsInPhoneCall_convertToVoiceMail = new UIElement("convertToVoiceMailForPhoneCall",
				IdentifyBy.XPATH, elementLibrary.getCellData("PhoneCallLabel.xls", "convertToVoiceMailForPhoneCall"));

		String sheetName = EnvironmentConfig.getAPP();

		if (sheetName.equals("Institutional")) {

			UIElement[] ribbonButtonList = { ribbonsInPhoneCall_SaveButton, ribbonsInPhoneCall_CopyActivity,
					ribbonsInPhoneCall_MakeComplete, ribbonsInPhoneCall_CompleteClose, ribbonsInPhoneCall_EmailSummary,
					ribbonsInPhoneCall_Refresh, ribbonsInPhoneCall_delete

			};

			String parentWindowHandle = driver.getWindowHandle();

			Thread.sleep(1000);
			for (int iLoop = 0; iLoop < ribbonButtonList.length; iLoop++) {

				if (iLoop == 0) {
					elementLibrary.click(ribbonButtonList[iLoop]);
					Thread.sleep(2000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonList[iLoop].getName());
						break;
					}
				}

				if (iLoop == 1) {
					elementLibrary.click(ribbonButtonList[iLoop]);
					Thread.sleep(2000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonList[iLoop].getName());
						break;
					}
					Thread.sleep(2000);
					driver.switchTo().window(parentWindowHandle);
				}

				if (iLoop == 4) {
					Thread.sleep(2000);
					elementLibrary.click(ribbonButtonList[iLoop]);
					Thread.sleep(2000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonList[iLoop].getName());
						break;
					}
					Thread.sleep(2000);
					driver.switchTo().window(parentWindowHandle);
				}

				if (iLoop == 5) {
					elementLibrary.click(ribbonButtonList[iLoop]);
					Thread.sleep(2000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonList[iLoop].getName());
						break;
					}
				}
//				if (iLoop == 6) {
//					elementLibrary.click(ribbonButtonList[iLoop]);
//					Thread.sleep(2000);
//					elementLibrary.waitForElementToDisplay(cancelForPhoneCall);
//					Thread.sleep(4000);
//					elementLibrary.click(cancelForPhoneCall);
//					Thread.sleep(2000);
//					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
//						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonList[iLoop].getName());
//						break;
//					}
//				}
//
//				if (iLoop == 2) {
//					Thread.sleep(2000);
//					elementLibrary.click(ribbonButtonList[iLoop]);
//					Thread.sleep(2000);
//					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
//						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonList[iLoop].getName());
//						break;
//					}
//				}
			}
		} else if (sheetName.equals("Hybrid")) {
			UIElement[] ribbonButtonList = { ribbonsInPhoneCall_SaveButton, ribbonsInPhoneCall_CopyActivity,
					ribbonsInPhoneCall_MakeComplete, ribbonsInPhoneCall_CompleteClose, ribbonsInPhoneCall_EmailSummary,
					ribbonsInPhoneCall_Refresh, ribbonsInPhoneCall_delete, ribbonsInPhoneCall_convertToVoiceMail };

			String parentWindowHandle = driver.getWindowHandle();

			Thread.sleep(1000);
			for (int iLoop = 0; iLoop < ribbonButtonList.length; iLoop++) {

				if (iLoop == 0) {
					elementLibrary.click(ribbonButtonList[iLoop]);
					Thread.sleep(2000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonList[iLoop].getName());
						break;
					}
				}

				if (iLoop == 1) {
					elementLibrary.click(ribbonButtonList[iLoop]);
					Thread.sleep(2000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonList[iLoop].getName());
						break;
					}
					Thread.sleep(2000);
					driver.switchTo().window(parentWindowHandle);
				}

				if (iLoop == 4) {
					Thread.sleep(2000);
					elementLibrary.click(ribbonButtonList[iLoop]);
					Thread.sleep(2000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonList[iLoop].getName());
						break;
					}
					Thread.sleep(2000);
					driver.switchTo().window(parentWindowHandle);
				}

				if (iLoop == 5) {
					elementLibrary.click(ribbonButtonList[iLoop]);
					Thread.sleep(2000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonList[iLoop].getName());
						break;
					}
				}
				if (iLoop == 6) {
					elementLibrary.click(ribbonButtonList[iLoop]);
					Thread.sleep(2000);
					elementLibrary.waitForElementToDisplay(cancelForPhoneCall);
					Thread.sleep(4000);
					elementLibrary.click(cancelForPhoneCall);
					Thread.sleep(2000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonList[iLoop].getName());
						break;
					}
				}
//				if (iLoop == 7) {
//					elementLibrary.click(ribbonButtonList[iLoop]);
//					Thread.sleep(6000);
//					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
//						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonList[iLoop].getName());
//						break;
//					}
//				}
//
//				if (iLoop == 2) {
//					Thread.sleep(2000);
//					elementLibrary.click(ribbonButtonList[iLoop]);
//					Thread.sleep(2000);
//					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
//						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonList[iLoop].getName());
//						break;
//					}
//				}
			}

		} else if (sheetName.equals("Retail")) {
			UIElement[] ribbonButtonList = { ribbonsInPhoneCall_SaveButton, ribbonsInPhoneCall_CopyActivity,
					ribbonsInPhoneCall_MakeComplete, ribbonsInPhoneCall_CompleteClose, ribbonsInPhoneCall_EmailSummary,
					ribbonsInPhoneCall_Refresh, ribbonsInPhoneCall_delete, ribbonsInPhoneCall_convertToVoiceMail };

			String parentWindowHandle = driver.getWindowHandle();

			Thread.sleep(1000);
			for (int iLoop = 0; iLoop < ribbonButtonList.length; iLoop++) {

				if (iLoop == 0) {
					elementLibrary.click(ribbonButtonList[iLoop]);
					Thread.sleep(2000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonList[iLoop].getName());
						break;
					}
				}

				if (iLoop == 1) {
					elementLibrary.click(ribbonButtonList[iLoop]);
					Thread.sleep(2000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonList[iLoop].getName());
						break;
					}
					Thread.sleep(2000);
					driver.switchTo().window(parentWindowHandle);
				}

				if (iLoop == 4) {
					Thread.sleep(2000);
					elementLibrary.click(ribbonButtonList[iLoop]);
					Thread.sleep(2000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonList[iLoop].getName());
						break;
					}
					Thread.sleep(2000);
					driver.switchTo().window(parentWindowHandle);
				}

				if (iLoop == 5) {
					elementLibrary.click(ribbonButtonList[iLoop]);
					Thread.sleep(2000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonList[iLoop].getName());
						break;
					}
				}
//				if (iLoop == 6) {
//					elementLibrary.click(ribbonButtonList[iLoop]);
//					Thread.sleep(2000);
//					elementLibrary.waitForElementToDisplay(cancelForPhoneCall);
//					Thread.sleep(4000);
//					elementLibrary.click(cancelForPhoneCall);
//					Thread.sleep(2000);
//					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
//						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonList[iLoop].getName());
//						break;
//					}
//				}
				if (iLoop == 7) {
					elementLibrary.click(ribbonButtonList[iLoop]);
					Thread.sleep(6000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonList[iLoop].getName());
						break;
					}
				}

//				if (iLoop == 2) {
//					Thread.sleep(2000);
//					elementLibrary.click(ribbonButtonList[iLoop]);
//					Thread.sleep(2000);
//					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
//						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonList[iLoop].getName());
//						break;
//					}
//				}
			}
		}
	}

	@Then("^Click on all ribbon buttons on the meeting page and make sure no error is displayed$")
	public void validateRibbuonButtonsOnMeeting() throws Throwable {
		UIElement ribbonButton_CopyActivity = new UIElement("ribbonButton_CopyActivity", IdentifyBy.XPATH,
				elementLibrary.getCellData("AllRibbonButtonsOnMeeting.xls", "Copy Activity"));
		UIElement ribbonButton_EmailSummary = new UIElement("ribbonButton_EmailSummary", IdentifyBy.XPATH,
				elementLibrary.getCellData("AllRibbonButtonsOnMeeting.xls", "Email Summary"));
		UIElement ribbonButton_EditActivity = new UIElement("ribbonButton_EditActivity", IdentifyBy.XPATH,
				elementLibrary.getCellData("AllRibbonButtonsOnMeeting.xls", "Edit Activity"));
		UIElement ribbonButton_CompleteClose = new UIElement("ribbonButton_CompleteClose", IdentifyBy.XPATH,
				elementLibrary.getCellData("AllRibbonButtonsOnMeeting.xls", "Complete & Close"));
		UIElement ribbonButton_Refresh = new UIElement("ribbonButton_Refresh", IdentifyBy.XPATH,
				elementLibrary.getCellData("AllRibbonButtonsOnMeeting.xls", "Refresh"));
		UIElement ribbonButton_MarketComplete = new UIElement("ribbonButton_MarketComplete", IdentifyBy.XPATH,
				elementLibrary.getCellData("AllRibbonButtonsOnMeeting.xls", "Mark Complete"));
		UIElement ribbonButton_Delete = new UIElement("ribbonButton_Delete", IdentifyBy.XPATH,
				elementLibrary.getCellData("AllRibbonButtonsOnMeeting.xls", "Delete"));
		String sheetName = EnvironmentConfig.getAPP();

		if (sheetName.equals("Institutional") || sheetName.equals("Retail") || sheetName.equals("Hybrid")) {
			UIElement[] arryTiles = { ribbonButton_CopyActivity, // 0
					ribbonButton_EmailSummary, // 1
					ribbonButton_Refresh, // 2
					ribbonButton_MarketComplete, // 3
					ribbonButton_EditActivity, // 4
					ribbonButton_Delete, // 5
					ribbonButton_CompleteClose// 6
			};

			String base = driver.getWindowHandle();

			for (int iLoop = 0; iLoop < arryTiles.length; iLoop++) {

				if (iLoop == 0 || iLoop == 1) {
					elementLibrary.waitForElementToDisplay(arryTiles[iLoop]);
					elementLibrary.click(arryTiles[iLoop]);

					Thread.sleep(5000);

					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}

					driver.switchTo().window(base);

				} else if (iLoop > 1 && iLoop < 5) {

					elementLibrary.click(arryTiles[iLoop]);
					Thread.sleep(3000);

					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}

				} else if (iLoop == 5) {

					elementLibrary.click(arryTiles[iLoop]);
					Thread.sleep(5000);
					if (elementLibrary.iselementDisplayed(scriptErrorDialogWindown)) {
						Assert.fail("The script error displayed when ribbon button " + arryTiles[iLoop].getName()
								+ "clicked");
						break;
					}

					elementLibrary.waitForElementToDisplay(cancelButton);
					elementLibrary.click(cancelButton);

				}
			}
		}
	}

	@And("^Click on Service Now button on header$")
	public void clickServiceNowButton() throws Throwable {
		elementLibrary.waitForElementToDisplay(serviceNowButton);
		elementLibrary.click(serviceNowButton);
	}

	@Then("^Validate the SNOW page should be opened in new window$")
	public void validateSNOWPage() {
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		browserLibrary.waitForLoad();
		UIElement uiElement = new UIElement("uiElement", IdentifyBy.XPATH, "//h2[text()='CRM Support Form']");
		if (elementLibrary.iselementDisplayed(uiElement) == false) {
			Assert.fail("Open SNOW page in the new window failed");
		}
	}

	// TC42
	@And("^Open new email page$")
	public void openNewEmailPage() throws Exception {
		Thread.sleep(4000);
		elementLibrary.waitForElementToDisplay(moreCommandsForContact);
		elementLibrary.click(moreCommandsForContact);
		elementLibrary.waitForElementToDisplay(moreCommandButtonForCollaborate);
		elementLibrary.click(moreCommandButtonForCollaborate);
		Thread.sleep(2000);
		elementLibrary.waitForElementToDisplay(emailDetailForContact);
		elementLibrary.click(emailDetailForContact);
	}

	@And("^Fill in required label \"(.*?)\"$")
	public void fillInRequiredLabel(String toLabelValue) throws Exception {
		Thread.sleep(4000);
		WebDriver driver = webdriverServiceLibrary.getWebDriver();
		Set<String> childids = driver.getWindowHandles();

		for (String s : childids) {
			if (driver.switchTo().window(s).getTitle().contains("Email: Email: New Email - Dynamics 365")) {
				Thread.sleep(4000);
				Robot robot = new Robot();
				elementLibrary.waitForElementToDisplay(toLabelForEmail);
				System.out.println("open new email page successfully");
				Thread.sleep(2000);
				elementLibrary.click(toLabelForEmail);
				elementLibrary.enterText(toLabelForEmail, toLabelValue);
				Thread.sleep(2000);
				robot.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				robot.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				robot.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				robot.keyPress(KeyEvent.VK_ENTER);
				System.out.println("fill value in To label successfully");
				Thread.sleep(2000);
				driver.switchTo().defaultContent();
				break;
			}
		}
	}

	@And("^Click Save button$")
	public void saveNewEmail() throws Exception {
		Thread.sleep(2000);
		elementLibrary.click(saveForEmail);
		Thread.sleep(4000);
		System.out.println("Create new email successfully");
	}

	@Then("^Click on buttons in email reocrd page and make sure no error is displayed$")
	public void clickOnRibbonsInEmail() throws Exception {
		UIElement ribbonsInEmaill_saveForEmail = new UIElement("ribbonsInEmaill_saveForEmail", IdentifyBy.XPATH,
				elementLibrary.getCellData("RibbonButtonsOnEmail.xls", "saveForEmail"));
		UIElement ribbonsInEmaill_sendForEmail = new UIElement("ribbonsInEmaill_sendForEmail", IdentifyBy.XPATH,
				elementLibrary.getCellData("RibbonButtonsOnEmail.xls", "sendForEmail"));
		UIElement ribbonsInEmaill_assignForEmail = new UIElement("ribbonsInEmaill_assignForEmail", IdentifyBy.XPATH,
				elementLibrary.getCellData("RibbonButtonsOnEmail.xls", "assignForEmail"));
		UIElement ribbonsInEmaill_refreshForEmail = new UIElement("ribbonsInEmaill_refreshForEmail", IdentifyBy.XPATH,
				elementLibrary.getCellData("RibbonButtonsOnEmail.xls", "refreshForEmail"));
		UIElement ribbonsInEmaill_attachFileForEmail = new UIElement("ribbonsInEmaill_attachFileForEmail",
				IdentifyBy.XPATH, elementLibrary.getCellData("RibbonButtonsOnEmail.xls", "attachFileForEmail"));
		UIElement ribbonsInEmaill_insertSignatureForEmail = new UIElement("ribbonsInEmaill_insertSignatureForEmail",
				IdentifyBy.XPATH, elementLibrary.getCellData("RibbonButtonsOnEmail.xls", "insertSignatureForEmail"));
		UIElement ribbonsInEmaill_deleteForEmail = new UIElement("ribbonsInEmaill_deleteForEmail", IdentifyBy.XPATH,
				elementLibrary.getCellData("RibbonButtonsOnEmail.xls", "deleteForEmail"));

		UIElement[] ribbonButtonList = { ribbonsInEmaill_saveForEmail, ribbonsInEmaill_sendForEmail,
				ribbonsInEmaill_assignForEmail, ribbonsInEmaill_refreshForEmail,
				ribbonsInEmaill_insertSignatureForEmail, ribbonsInEmaill_deleteForEmail,
				ribbonsInEmaill_attachFileForEmail };

		// String parentWindowHandle = driver.getWindowHandle();
		String parentWindowHandle = driver.getWindowHandle();

		for (int iLoop = 0; iLoop < ribbonButtonList.length; iLoop++) {
			if (iLoop == 0) {
				elementLibrary.click(ribbonButtonList[iLoop]);
				Thread.sleep(3000);
				if (elementLibrary.iselementDisplayed(scriptErrorDialog)) {
					Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonList[iLoop].getName());
					break;
				}
			}

			if (iLoop == 1) {
				elementLibrary.click(ribbonButtonList[iLoop]);
				Thread.sleep(4000);
				if (elementLibrary.iselementDisplayed(scriptErrorDialog)) {
					Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonList[iLoop].getName());
					break;
				}
			}

			if (iLoop == 2) {
				Thread.sleep(9000);
				elementLibrary.click(ribbonButtonList[iLoop]);
				Thread.sleep(4000);
				if (elementLibrary.iselementDisplayed(scriptErrorDialog)) {
					Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonList[iLoop].getName());
					break;
				}
				elementLibrary.waitForElementToDisplay(cancelForEmail);
				elementLibrary.click(cancelForEmail);
			}

			if (iLoop == 3) {
				elementLibrary.click(ribbonButtonList[iLoop]);
				Thread.sleep(3000);
				if (elementLibrary.iselementDisplayed(scriptErrorDialog)) {
					Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonList[iLoop].getName());
					break;
				}
			}
			if (iLoop == 4) {
				elementLibrary.waitForElementToDisplay(moreCommandForEmail);
				elementLibrary.click(moreCommandForEmail);
				Thread.sleep(2000);
				elementLibrary.click(ribbonButtonList[iLoop]);
				Thread.sleep(4000);
				if (elementLibrary.iselementDisplayed(scriptErrorDialog)) {
					Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonList[iLoop].getName());
					break;
				}
				elementLibrary.waitForElementToDisplay(cancelForEmail);
				elementLibrary.click(cancelForEmail);
			}

			if (iLoop == 5) {
				elementLibrary.waitForElementToDisplay(moreCommandForEmail);
				elementLibrary.click(moreCommandForEmail);
				Thread.sleep(4000);
				elementLibrary.click(ribbonButtonList[iLoop]);
				Thread.sleep(3000);
				if (elementLibrary.iselementDisplayed(scriptErrorDialog)) {
					Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonList[iLoop].getName());
					break;
				}
				elementLibrary.waitForElementToDisplay(cancelForEmail);
				elementLibrary.click(cancelForEmail);
			}
			if (iLoop == 6) {
				elementLibrary.click(ribbonButtonList[iLoop]);
				Thread.sleep(3000);
				if (elementLibrary.iselementDisplayed(scriptErrorDialog)) {
					Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonList[iLoop].getName());
					break;
				}
			}
		}
	}

	@And("^Click on Advance Find button on header$")
	public void clickAdvanceFindButton() throws Throwable {

		elementLibrary.waitForElementToDisplay(advanceFindButton);
		elementLibrary.click(advanceFindButton);

	}

	@Then("^Validate the Advance Find should be opened in new window$")
	public void validateAdvanceFind() {
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		browserLibrary.waitForLoad();
		UIElement uiElement = new UIElement("uiElement", IdentifyBy.XPATH, "//li[@id='Mscrm.AdvancedFind-title']");
		if (elementLibrary.iselementDisplayed(uiElement) == false) {
			Assert.fail("Open Advance find in the new window failed");
		}
	}

	@And("^Switch to RTCs dashboard view$")
	public void switchToRTCsDashoard() throws Throwable {
		UIElement MyDashboard = new UIElement("MyDashboard", IdentifyBy.XPATH, "//span[text()='My Dashboard']");
		UIElement RTCs = new UIElement("RTCs", IdentifyBy.XPATH, "//span[text()='RTCs']");
		elementLibrary.waitForElementToDisplay(MyDashboard);
		elementLibrary.click(MyDashboard);
		elementLibrary.waitForElementToDisplay(RTCs);
		elementLibrary.click(RTCs);
	}

	@Then("^Validate Data should load on page when the \"(.*?)\" selected$")
	public void validateDataLoad(String user) throws Throwable {
		browserLibrary.waitForLoad();
		WebElement iframe = driver.findElement(
				By.xpath("//iframe[@id='46c0b665-a450-4242-b121-e714a57e7024_WebResource_UCI_Retail_RTC']"));
		elementLibrary.switchToFrame(iframe);
		UIElement viewListBox = new UIElement("viewListBox", IdentifyBy.XPATH, "//input[@class='wj-form-control']");
		UIElement userSelected = new UIElement("userSelected", IdentifyBy.XPATH, "//div[@role='listbox']//div[1]");
  
		elementLibrary.click(viewListBox);
		Thread.sleep(2000);
		elementLibrary.deleteUsingSendkeys(viewListBox);
		elementLibrary.enterText(viewListBox, user);
		elementLibrary.waitForElementToDisplay(userSelected);
		elementLibrary.click(userSelected);
		
		Thread.sleep(20000);
		List<WebElement> xpathCount = driver.findElements(By.xpath("//div[@class='wj-cells']/div[@class='wj-row']"));
		System.out.println(xpathCount.size());
		if (xpathCount.size() == 1) {
			Assert.fail("No any data load on page");
		}
	}

	// TC41
	@And("^Open the quick create new phone call record page$")
	public void openTheQuickCreateNewPhoneCall() throws Exception {
		Thread.sleep(4000);
		elementLibrary.waitForElementToDisplay(quickNewButtonInContact);
		elementLibrary.click(quickNewButtonInContact);
		Thread.sleep(2000);
		elementLibrary.waitForElementToDisplay(activitiesInquickNewButtonOnContact);
		elementLibrary.click(activitiesInquickNewButtonOnContact);
		Thread.sleep(2000);
		elementLibrary.waitForElementToDisplay(quickNewPhoneCall);
		elementLibrary.click(quickNewPhoneCall);
		Thread.sleep(6000);
	}

	@And("^Fill in required label$")
	public void fillInRequiredLabels() throws Exception {
		String appName = EnvironmentConfig.getAPP();
		elementLibrary.waitForElementToDisplay(subjectInquickNewPhoneCall);
		Robot robot = new Robot();

		phoneCallNameA = getDate();
		phoneCallNameValue = appName + " Test quick create phone call " + phoneCallNameA;
		elementLibrary.click(subjectInquickNewPhoneCall);
		elementLibrary.enterText(subjectInquickNewPhoneCall, phoneCallNameValue);
		Thread.sleep(1000);

		elementLibrary.click(relationshipInquickNewPhoneCall);
		elementLibrary.enterText(relationshipInquickNewPhoneCall, "3M Company");
		Thread.sleep(20000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(4000);

		elementLibrary.click(primaryContactInquickNewPhoneCall);
		elementLibrary.enterText(primaryContactInquickNewPhoneCall, "Barb Larson");
		Thread.sleep(20000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(4000);

		elementLibrary.waitForElementToDisplay(whoAmITlakToInquickNewPhoneCall);
		elementLibrary.selectDropdownBasedOnIndex(whoAmITlakToInquickNewPhoneCall, 2);
		Thread.sleep(2000);
		System.out.println("Select Voicemail in who Am I Talking To label successfully");
	}

	@Then("^Click Save and Close button$")
	public void clickSaveAndCloseButton() throws Exception {
		Thread.sleep(2000);
		elementLibrary.waitForElementToDisplay(saveAndCloseInquickNewPhoneCall);
		elementLibrary.click(saveAndCloseInquickNewPhoneCall);
		Thread.sleep(7000);
		if (elementLibrary.iselementDisplayed(scriptErrorDialog)) {
			Assert.fail("Pop up error when clicked save and close button");
		}
	}

	// TC38
	@Then("^Click on all ribbon buttons in email reocrd page and make sure no error is displayed$")
	public void clickOnRibbonInEmail() throws Exception {
		Thread.sleep(2000);
		elementLibrary.waitForElementToDisplay(fullNameForOneContact);
		elementLibrary.click(fullNameForOneContact);
		Thread.sleep(7000);
		elementLibrary.waitForElementToDisplay(aCTIVITIESInContact);
		elementLibrary.click(aCTIVITIESInContact);
		Thread.sleep(5000);
		WebElement iframeActivityTabInContact = driver.findElement(By.xpath("//iframe[@id='WebResource_Activities']"));
		elementLibrary.switchToFrame(iframeActivityTabInContact);
		elementLibrary.waitForElementToDisplay(emaillDataInContact);
		elementLibrary.click(emaillDataInContact);
		Thread.sleep(5000);

		UIElement ribbonsInEmaill_saveForEmail = new UIElement("ribbonsInEmaill_saveForEmail", IdentifyBy.XPATH,
				elementLibrary.getCellData("RibbonButtonsOnEmail.xls", "saveForEmail"));
		UIElement ribbonsInEmaill_sendForEmail = new UIElement("ribbonsInEmaill_sendForEmail", IdentifyBy.XPATH,
				elementLibrary.getCellData("RibbonButtonsOnEmail.xls", "sendForEmail"));
		UIElement ribbonsInEmaill_assignForEmail = new UIElement("ribbonsInEmaill_assignForEmail", IdentifyBy.XPATH,
				elementLibrary.getCellData("RibbonButtonsOnEmail.xls", "assignForEmail"));
		UIElement ribbonsInEmaill_refreshForEmail = new UIElement("ribbonsInEmaill_refreshForEmail", IdentifyBy.XPATH,
				elementLibrary.getCellData("RibbonButtonsOnEmail.xls", "refreshForEmail"));
		UIElement ribbonsInEmaill_attachFileForEmail = new UIElement("ribbonsInEmaill_attachFileForEmail",
				IdentifyBy.XPATH, elementLibrary.getCellData("RibbonButtonsOnEmail.xls", "attachFileForEmail"));
		UIElement ribbonsInEmaill_insertSignatureForEmail = new UIElement("ribbonsInEmaill_insertSignatureForEmail",
				IdentifyBy.XPATH, elementLibrary.getCellData("RibbonButtonsOnEmail.xls", "insertSignatureForEmail"));
		UIElement ribbonsInEmaill_deleteForEmail = new UIElement("ribbonsInEmaill_deleteForEmail", IdentifyBy.XPATH,
				elementLibrary.getCellData("RibbonButtonsOnEmail.xls", "deleteForEmail"));

		UIElement[] ribbonButtonList = { ribbonsInEmaill_saveForEmail, ribbonsInEmaill_sendForEmail,
				ribbonsInEmaill_assignForEmail, ribbonsInEmaill_refreshForEmail,
				ribbonsInEmaill_insertSignatureForEmail, ribbonsInEmaill_deleteForEmail,
				ribbonsInEmaill_attachFileForEmail };

		// String parentWindowHandle = driver.getWindowHandle();
		String parentWindowHandle = driver.getWindowHandle();

		for (int iLoop = 2; iLoop < ribbonButtonList.length; iLoop++) {
//				if (iLoop == 0) {
//					elementLibrary.click(ribbonButtonList[iLoop]);
//					Thread.sleep(3000);
//					if (elementLibrary.iselementDisplayed(scriptErrorDialog)) {
//						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonList[iLoop].getName());
//						break;
//					}
//				}

//				if (iLoop == 1) {
//					elementLibrary.click(ribbonButtonList[iLoop]);
//					Thread.sleep(4000);
//					if (elementLibrary.iselementDisplayed(scriptErrorDialog)) {
//						Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonList[iLoop].getName());
//						break;
//					}
//				}

			if (iLoop == 2) {
				Thread.sleep(9000);
				elementLibrary.click(ribbonButtonList[iLoop]);
				Thread.sleep(4000);
				if (elementLibrary.iselementDisplayed(scriptErrorDialog)) {
					Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonList[iLoop].getName());
					break;
				}
				elementLibrary.waitForElementToDisplay(cancelForEmail);
				elementLibrary.click(cancelForEmail);
			}

			if (iLoop == 3) {
				elementLibrary.click(ribbonButtonList[iLoop]);
				Thread.sleep(3000);
				if (elementLibrary.iselementDisplayed(scriptErrorDialog)) {
					Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonList[iLoop].getName());
					break;
				}
			}
			if (iLoop == 4) {
				elementLibrary.waitForElementToDisplay(moreCommandForEmail);
				elementLibrary.click(moreCommandForEmail);
				Thread.sleep(2000);
				elementLibrary.click(ribbonButtonList[iLoop]);
				Thread.sleep(4000);
				if (elementLibrary.iselementDisplayed(scriptErrorDialog)) {
					Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonList[iLoop].getName());
					break;
				}
				elementLibrary.waitForElementToDisplay(cancelForEmail);
				elementLibrary.click(cancelForEmail);
			}

			if (iLoop == 5) {
				elementLibrary.waitForElementToDisplay(moreCommandForEmail);
				elementLibrary.click(moreCommandForEmail);
				Thread.sleep(4000);
				elementLibrary.click(ribbonButtonList[iLoop]);
				Thread.sleep(3000);
				if (elementLibrary.iselementDisplayed(scriptErrorDialog)) {
					Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonList[iLoop].getName());
					break;
				}
				elementLibrary.waitForElementToDisplay(cancelForEmail);
				elementLibrary.click(cancelForEmail);
			}
			if (iLoop == 6) {
				elementLibrary.click(ribbonButtonList[iLoop]);
				Thread.sleep(3000);
				if (elementLibrary.iselementDisplayed(scriptErrorDialog)) {
					Assert.fail("Pop up error when clicked ribbon button:" + ribbonButtonList[iLoop].getName());
					break;
				}
			}
		}
	}

	@And("^Search Activities by user \"(.*?)\",select from \"(.*?)\"$")
	public void searchMeetingRecord(String user, String startDate) throws Throwable {
		
		UIElement userInputfield = new UIElement("userInputfield", IdentifyBy.XPATH,
				"//input[@id='leadam-text-field']");
		
		UIElement searchButton = new UIElement("searchButton", IdentifyBy.XPATH, "//button[text()='Search']");

		UIElement dropDownItem = new UIElement("dropDownItem", IdentifyBy.XPATH,
				"//button[@class='dropdown-item active ng-star-inserted']");
		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='FullPageWebResource']"));
		elementLibrary.switchToFrame(iframe);
		elementLibrary.waitForElementToDisplay(userInputfield);
		elementLibrary.enterText(userInputfield, user);
		elementLibrary.waitForElementToDisplay(dropDownItem);
		elementLibrary.click(dropDownItem);
		
		WebElement startDateInput = driver.findElement(By.xpath("(//input[@class='wj-form-control'])[1]"));
		
		elementLibrary.click(startDateInput);
		Thread.sleep(1000);
		startDateInput.sendKeys(Keys.CONTROL, "a");
		startDateInput.sendKeys(Keys.DELETE);
		Thread.sleep(2000);
		elementLibrary.enterText(startDateInput, startDate);
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		elementLibrary.click(searchButton);
//		UIElement userInputfield = new UIElement("userInputfield", IdentifyBy.XPATH,
//				"//input[@id='leadam-text-field']");
//		UIElement fromfield = new UIElement("fromfield", IdentifyBy.XPATH, "(//input[@class='wj-form-control'])[1]");
//		UIElement searchButton = new UIElement("searchButton", IdentifyBy.XPATH, "//button[contains(@class,'btn btn-primary')]");
//
//		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='FullPageWebResource']"));
//		elementLibrary.switchToFrame(iframe);
//		elementLibrary.waitForElementToDisplay(userInputfield);
//		//enter user
//		elementLibrary.enterText(userInputfield, user);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_TAB);
//		//enter start date
//		elementLibrary.click(fromfield);
//		Thread.sleep(2000);
//		elementLibrary.deleteUsingSendkeys(fromfield);
//		Thread.sleep(2000);
//		elementLibrary.enterText(fromfield, startDate);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(2000);
//		//click search button
//		robot.keyPress(KeyEvent.VK_ENTER);
//		//elementLibrary.click(searchButton);
//		Thread.sleep(10000);
	}

	@And("^Open the meeting record \"(.*?)\" on the grid$")
	public void openMeetingRecord(String meetingRecord) throws Throwable {

		UIElement meetingSubject = new UIElement("meetingSubject", IdentifyBy.XPATH,
				"//a[@title='" + meetingRecord + "']");
		elementLibrary.waitForElementToDisplay(meetingSubject);
		elementLibrary.click(meetingSubject);
		driver.close();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

	}
	
	@And("^Open the quick create new \"(.*?)\" activity record page$")
	public void openQuickCreateActivitypage(String activity) throws Exception {
		UIElement quickCreateActivities = new UIElement("quickCreateActivities", IdentifyBy.XPATH,
				"//span[text()='" + activity + "']");
		Thread.sleep(4000);
		elementLibrary.waitForElementToDisplay(quickNewButtonInContact);
		elementLibrary.click(quickNewButtonInContact);
		Thread.sleep(2000);
		elementLibrary.waitForElementToDisplay(activitiesInquickNewButtonOnContact);
		elementLibrary.click(activitiesInquickNewButtonOnContact);
		Thread.sleep(2000);
		elementLibrary.waitForElementToDisplay(quickCreateActivities);
		elementLibrary.click(quickCreateActivities);
		Thread.sleep(6000);
	}

	@And("^Input field for Relationship \"(.*?)\"$")
	public void inputFildForRelationship(String relationshipRecord) throws Throwable {
		UIElement relationshipField = new UIElement("relationshipField", IdentifyBy.XPATH,
				"//input[@data-id='cs_accountid.fieldControl-LookupResultsDropdown_cs_accountid_textInputBox_with_filter_new']");
		
		Robot robot = new Robot();

		elementLibrary.mouseOver(relationshipField);
		elementLibrary.enterText(relationshipField, relationshipRecord);

		Thread.sleep(20000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

	}
	
	//TC44
		 @And ("^Open the quick create new meeting record page$")
		 public void openTheQuickCreateNewMeeting() throws Exception{
			 Thread.sleep(4000);
			 elementLibrary.waitForElementToDisplay(quickNewButtonInContact);
			 elementLibrary.click(quickNewButtonInContact);
			 Thread.sleep(2000);
			 elementLibrary.waitForElementToDisplay(activitiesInquickNewButtonOnContact);
			 elementLibrary.click(activitiesInquickNewButtonOnContact);
			 Thread.sleep(2000);
			 elementLibrary.waitForElementToDisplay(quickNewMeeting);
			 elementLibrary.click(quickNewMeeting);
			 Thread.sleep(6000);
		 }
		 
		 
		 @And("^Fill in required label in new meeting record page$")
		 public void  fillInRequiredLabelInNewMeeting() throws Exception{
			 Thread.sleep(3000);
		     String appName = EnvironmentConfig.getAPP();
		     elementLibrary.waitForElementToDisplay(subjectInquickNewMeeting);
		     Robot robot = new Robot();
		     quickNewMeetingA = getDate();
		     quickNewMeetingValue = appName + " Test quick create meeting " + quickNewMeetingA;
		     elementLibrary.click(subjectInquickNewMeeting);
		     elementLibrary.enterText(subjectInquickNewMeeting,quickNewMeetingValue);
		     Thread.sleep(2000);
		     
		     elementLibrary.click(relationshipInquickNewMeeting);
		     elementLibrary.enterText(relationshipInquickNewMeeting,"3M Company");
		     Thread.sleep(13000);
		     robot.keyPress(KeyEvent.VK_TAB);
			 Thread.sleep(1000);
			 robot.keyPress(KeyEvent.VK_TAB);
			 Thread.sleep(1000);
			 robot.keyPress(KeyEvent.VK_TAB);
			 Thread.sleep(1000);
			 robot.keyPress(KeyEvent.VK_ENTER);
		     Thread.sleep(8000);
		     
		     elementLibrary.click(primaryAttendeeInquickMeeting);
		     elementLibrary.enterText(primaryAttendeeInquickMeeting,"Barb Larson");
		     Thread.sleep(10000);
			 robot.keyPress(KeyEvent.VK_TAB);
			 Thread.sleep(1000);
			 robot.keyPress(KeyEvent.VK_TAB);
			 Thread.sleep(1000);
			 robot.keyPress(KeyEvent.VK_ENTER);
			 Thread.sleep(6000);
			 
//			 //activityPurpose
////			 elementLibrary.waitForElementToDisplay(activityPurposeInquickMeeting);
////			 elementLibrary.click(activityPurposeInquickMeeting);
////			 Thread.sleep(1000);
//			 elementLibrary.waitForElementToDisplay(buttonInActivityPurposeForquickMeeting);
//			 elementLibrary.click(buttonInActivityPurposeForquickMeeting);
//			 Thread.sleep(5000);
//			 elementLibrary.waitForElementToDisplay(servicingInquickMeeting);
//			 elementLibrary.click(servicingInquickMeeting);
//			 Thread.sleep(5000);
//			 
//			 //fill value in Internal Attendees
//			 elementLibrary.waitForElementToDisplay(internalAttendeesInquickMeeting);
//			 elementLibrary.click(internalAttendeesInquickMeeting);			 
//			 elementLibrary.enterText(internalAttendeesInquickMeeting,"Tony Han");
//			 Thread.sleep(2000);
//			 robot.keyPress(KeyEvent.VK_ENTER);
//			 Thread.sleep(5000);
//			 elementLibrary.click(itemInternalAttendeeForquickMeeting);
		 }
		 
		//TC45
		 @And ("^Open the quick create new task record page$")
		 public void openTheQuickCreateNewTask() throws Exception{
			 Thread.sleep(4000);
			 elementLibrary.waitForElementToDisplay(quickNewButtonInContact);
			 elementLibrary.click(quickNewButtonInContact);
			 Thread.sleep(2000);
			 elementLibrary.waitForElementToDisplay(activitiesInquickNewButtonOnContact);
			 elementLibrary.click(activitiesInquickNewButtonOnContact);
			 Thread.sleep(2000);
			 elementLibrary.waitForElementToDisplay(quickNewTask);
			 elementLibrary.click(quickNewTask);
			 Thread.sleep(6000);
			 
			 Robot robot = new Robot();
			 //Fill in value in relationship column
			 elementLibrary.click(relationshipInquickNewMeeting);
		     elementLibrary.enterText(relationshipInquickNewMeeting,"3M Company");
		     Thread.sleep(13000);
		     robot.keyPress(KeyEvent.VK_TAB);
			 Thread.sleep(1000);
			 robot.keyPress(KeyEvent.VK_TAB);
			 Thread.sleep(1000);
			 robot.keyPress(KeyEvent.VK_TAB);
			 Thread.sleep(1000);
			 robot.keyPress(KeyEvent.VK_ENTER);
		     Thread.sleep(8000);
		 }
}
