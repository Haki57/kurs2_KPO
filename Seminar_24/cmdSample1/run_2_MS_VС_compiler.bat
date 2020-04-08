cd ..\src\sample1
call "C:\Program Files (x86)\Microsoft Visual Studio\2019\Community\VC\Auxiliary\Build\vcvars64.bat"
"C:\Program Files (x86)\Microsoft Visual Studio\2019\Community\VC\Tools\MSVC\14.25.28610\bin\Hostx64\x64\Cl.exe" -I"C:\Program Files\Java\jdk-11.0.6\include" -I"C:\Program Files\Java\jdk-11.0.6\include\win32" -I"." -MT -LD JNIHelloWorld.c -FeJNIHelloWorld.dll
