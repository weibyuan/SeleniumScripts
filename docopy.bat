@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set COPYFOLDERNAME=allure-results

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.

mkdir %COPYFOLDERNAME%
xcopy %DIRNAME%target\allure-results %DIRNAME%%COPYFOLDERNAME% /Y /C /V
