# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/maciek/Library/Android/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-dontwarn okio.**

# OKHTTP
-dontwarn com.squareup.okhttp.*

# ACRA
-keep class org.acra.ACRA { *; }
-keep class org.acra.ReportingInteractionMode { *; }
-keep class org.acra.annotation.* {    *;}
-keep class org.acra.ACRAConfiguration {    *;}
-keep class org.acra.log.ACRALog {    *;}
-keepnames class org.acra.ReportField {    *;}
-keep public class org.acra.ErrorReporter {
    public void addCustomData(java.lang.String,java.lang.String);
    public void putCustomData(java.lang.String,java.lang.String);
    public void removeCustomData(java.lang.String);
    public void handleSilentException(java.lang.Throwable);
    public void handleException(java.lang.Throwable);
}