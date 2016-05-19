cd c:\
echo on
set GITHUB_ACCOUNT=Veta99
set WS_DIR=Workspace
set REPO_NAME=HW_45_Parsing
set APP_VERSION=%1
::set MAIN_CLASS=%2
if "%JAVA_HOME%" == "" GOTO EXIT_JAVA
echo Java installed
if "%M2%" == "" GOTO EXIT_MVN
echo Maven installed
call git --version > nul 2>&1
if NOT %ERRORLEVEL% == 0 GOTO EXIT_GIT
echo Git installed
goto next
:next
if not exist C:\%WS_DIR% goto NO_WORKSPACE
if exist C:\%WS_DIR% goto next
:next
cd C:\%WS_DIR%
git clone https://github.com/%GITHUB_ACCOUNT%/%REPO_NAME%.git
cd %REPO_NAME%
call mvn clean package -Dmaven.test.skip=true -Dbd.version="1.1" 
ECHO.
ECHO Executing Java programm ...
java -cp C:\%WS_DIR%\%REPO_NAME%\target\%REPO_NAME%-1.1.jar core.DOM_XPath
java -cp C:\%WS_DIR%\%REPO_NAME%\target\%REPO_NAME%-1.1.jar core.DOM
java -cp C:\%WS_DIR%\%REPO_NAME%\target\%REPO_NAME%-1.1.jar core.SAX
java -cp C:\%WS_DIR%\%REPO_NAME%\target\%REPO_NAME%-1.1.jar core.StAX
:EXIT_JAVA
ECHO No Java installed
GOTO END
:EXIT_MVN
ECHO No Maven installed
GOTO END
:EXIT_GIT
ECHO No Git installed
GOTO END
:NO_Workspace
ECHO %WS_DIR% is not exists
GOTO END
:END
cd ..
cd ..
PAUSE

