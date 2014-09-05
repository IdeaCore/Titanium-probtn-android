ProBtn-Android
============

What the ProBtn is?
---------------------------

ProBtn is an interactive element that used to show custom content inside your application. If the button is tapped then the window with WebView would open. The url in the WebView is set using settings on our server.

Real example:
-----
![ScreenShot](http://beta.hstor.org/getpro/habr/post_images/b10/783/d3e/b10783d3ea2cd950f54326d77b85c3e8.gif)

How to use ProBtn SDK
-----

1. Sign up to admin.probtn.com
2. Register your app: create new application, select it's platform (Android) and BundleID (root package name of your app)
3. Choose the site to promote in your application.
4. Integrate ProButton with your application using the following instructions:

Integrating ProBtn SDK with your Android application
-----

1. Clone repository or download project ZIP
2. Add ProBtn.jar library to your project module and dependencies
3. Add the following permissions to your AndroidManifest.xml 

    	<uses-permission android:name="android.permission.SYSTEM_ALERT_WINDOW"/>
    	<uses-permission android:name="android.permission.INTERNET"/>
    	<uses-permission android:name="android.permission.VIBRATE"/>
    	<uses-permission android:name="android.permission.REORDER_TASKS"/>
    	<uses-permission android:name="android.permission.GET_TASKS"/> 
    	<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>  // optional
    	<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>  // optional
    	
and declare a service

    	<service android:name="ru.hintsolutions.ProBtn.ProBtnService" >
    		<intent-filter>
    			<action android:name="android.intent.action.CONFIGURATION_CHANGED"/>
    		</intent-filter>
    	</service>


4. For targets with API level >= 14 you need to add the following code into yout root activity:

    	@Override
    	public void onCreate(Bundle savedInstanceState) {
    	    super.onCreate(savedInstanceState);
    	    ...
    	    ProBtn.open(MainActivity.this);
    	}
    	
    	@Override
    	protected void onDestroy() {
            ProBtn.close(this);
            super.onDestroy();
        }
	
For targets with lower API levels you also need to set up the following callbacks for each activity in your app:

	@Override
	protected void onResume() {
	super.onResume();
	    if (android.os.Build.VERSION.SDK_INT < 14) {
	        ProBtn.onActivityResumed(this);
	    }
	    ...
	}

	@Override
	protected void onPause() {
	    if (android.os.Build.VERSION.SDK_INT < 14) {
	        ProBtn.onActivityPaused(this);
	    }
	    super.onPause();
	    ...
	}

5. Feel free to control the button at any time by calling ProBtn.showProBtn() and  ProBtn.hideProBtn() methods.
6. Button usage statistics for current package can be taken using the following method with callback:
    
    	ProBtn.getUsageStatistics(new ProBtn.ProButtonStatisticsCallback() {
    	@Override
        	public void done(JSONObject jsonObject, Exception e) {
            	// insert your code here
        	}
    	});
    
How to run example project? (using Intellij IDEA)
---------------
1. File->Import project..
2. Choose directory with example sources and press "OK"
3. "Create project from existing sources"
4. Specify project name and press "Next"
5. Select all directories and press "Next" 
6. Mark "ProBtn" library as used in the project, press "Next"
7. Include selected module to the project and press "Next"
8. Choose project SDK (Android 4.x.x Platform recommended), press "Next"
9. Press "Next"
10. Example project is ready to run.
	
Server side
---------------

All the settings are taken from the server so you can customize the appearance of the button by simply changing the on the server side. 
The server address is [admin.probtn.com](http://admin.probtn.com/ "admin.probtn.com"). After all the data loaded from the server the button would appear automatically.

Now ProBtn is not visible on the devices with Android lower than 4.1. You can enable ProBtn for older Andoird versions changing "Android Min Api Level" parameter ("Fine Tuning" tab).

Known issues
---------------

If your targetSdkVersion parameter is lower than 14, you need to add "android:hardwareAccelerated="true"" to every activity declaration in AndroidManifest.xml to avoid some performance issues. 

