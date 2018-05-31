
setlocal
cd ..
set "CURRENT_DIR=%cd%"
echo %CURRENT_DIR%


setlocal enableextensions enabledelayedexpansion

set classpath=.
for %%c in (%CURRENT_DIR%\lib\*.jar) do set classpath=!classpath!;%%c

start java -Dfile.encoding=UTF-8 -classpath %classpath% com.future.market.service.MarketMain

