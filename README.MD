#BDD FRAMEWORK# 
Framework is broadly  distributed into four Maven project 
* First : Automation Library
    * Reusable across multiple application
    * Contain web driver, browsers, page and all Generic UIElement actions
    * Extendable to add any new browser driver,
    * Screen capture (failure test cases or both cases)

* Second : Cucumber TestNG
    * Reusable across multiple application
    * Support parallel execution on multiple browsers and Operating system combination
    * Use Grid
    * Reports & logs

* Third: Data Comparator
    * Available database connector with MySQL and Oracle
    * Extendable to add new database
    * Reusable across multiple application

* Fourth: Application
    * Application specific config & environment properties files
    * Optional OR
        * Page model
        * Data base model
    * Features files include common & page specific operations
