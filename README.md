PizzaBtn-Android
============

What the PizzaBtn is?
---------------------------

PizzaBtn is an interactive element that used to show custom content inside your application. If the button is tapped then the window with WebView would open. The url in the WebView is set using settings on our server.

How to use PizzaBtn SDK
-----

1. First you have to register on pizzabtn.heroku.com
2. Register your app: create new application, select it's platform (Android) and fill BundleID field (root package name of your app)
3. Choose the site to promote in your application.
4. Finally you have to embed PizzaBtn into your app.

Integrating PizzaBtn SDK with your Android application
-----

1. Clone repository or download project ZIP
2. Add PizzaButton.jar library to your project module and dependencies
3. Add INTERNET permission to your AndroidManifest.xml 
(<uses-permission android:name="android.permission.INTERNET"/>)
4. For targets with API level >= 14 all is you need is just to add the following line to onCreate method of the root activity:

	PizzaBtn.activate(this);
	
For targets with lower APi levels you also need to set up the following callbacks for each activity in your app:

	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    if (android.os.Build.VERSION.SDK_INT < 11) {
	        PizzaBtn.onActivityCreated();
	    }
	    ...
	}

	@Override
	protected void onResume() {
	super.onResume();
	    if (android.os.Build.VERSION.SDK_INT < 11) {
	        PizzaBtn.onActivityResumed(this);
	    }
	    ...
	}

	@Override
	protected void onPause() {
	    if (android.os.Build.VERSION.SDK_INT < 11) {
	        PizzaBtn.onActivityPaused();
	    }
	    super.onPause();
	    ...
	}

	@Override
	protected void onDestroy() {
	    if (android.os.Build.VERSION.SDK_INT < 11) {
	        PizzaBtn.onActivityDestroyed(this);
	    }
	    super.onDestroy();
	    ...
	}

	
Server side
---------------

All the settings are taken from the server so you can customize the appiarence of the button by simply changing the on the serverside. 
The server adress is pizzabtn.heroku.com. After all the data loaded from the server the button would appear automatically.


Parameters description for PizzaBtn
-------------------------------
	BundleID = BundleId of your application
	Settings = {
		BaseInsets = { // Distance from the edges of the screen including status bar
			T = 4.0
			B = 4.0
			L = 4.0
			R = 4.0
		}
	
		ButtonEnabled = true // Is active or not. It means could you move it or not
		ButtonVisible = true // Is visible or not
	
		// Visual settings of the button
	
		ButtonOpenInsets = { // Distance from the edges of the screen when WevbView is opened
			T = 32.0
			B = 32.0
			L = 32.0
			R = 32.0
		}
		ButtonPosition = { // Start position in percent (0-100)
			X = // 50% by default
			Y = // 80% by default
		}
		ButtonSize = { // Size
			W = 64.0
			H = 64.0
		}
		ButtonDragSize = { // Size of the button when its dragged
			W = 68.0
			H = 68.0
		}
		ButtonOpenSize = { // Button size when the WebView is opened
			W = 64.0
			H = 64.0
		}
		ButtonInactiveSize = { // Button size when its inactive
			W = 64.0
			H = 64.0
		}
		ButtonOpacity = 0.8 // Opacity
		ButtonDragOpacity = 1.0 // Opacity during movement
		ButtonOpenOpacity = 1.0 // Opacity of the button when WebView is opened
		ButtonInactiveOpacity = 0.5 // Opacity when button is inactive
		ButtonImage = // Link to image when the button is in normal state
		ButtonDragImage = // Link to image shown during movements
		ButtonOpenImage = // Link to image when the WebView is shown
		ButtonInactiveImage = // Link to image when it is in inactive state
	
		// Visial settings of the closing region
		
		ClosePosition = { // Position
			X = // By default it centers on the screen
			Y = // By default it centers on the screen
		}
		CloseSize = { // Size
			W = 64.0
			H = 64.0
		}
		CloseActiveSize = { // Size of the closing region in active state
			W = 72.0
			H = 72.0
		}
		CloseOpacity = 0.6 // Opacity
		CloseActiveOpacity = 1.0 // Opacity in active state
		CloseImage = // Link to image
		CloseActiveImage = // Link to image in active state
	
		// Hint visual settings
	
		HintInsets = { // Distance from the screen edges
			T = 4.0
			B = 4.0
			L = 4.0
			R = 4.0
		}
		HintLabelInsets = { // Offcets for text
			T = 4.0
			B = 4.0
			L = 4.0
			R = 4.0
		}
		HintImageInsets = { // Borders for backgroud image
			T = 8.0
			B = 8.0
			L = 8.0
			R = 8.0
		}
		HintText = This is HintButton // Text
		HintFont = { // Font parameters
			Family = Arial
			Size = 18
		}
		HintFontColor = { // Font color
			R = 1.0
			G = 1.0
			B = 1.0
			A = 1.0
		}
		HintOpacity = 0.8 // Opacity
		HintImage = // Link to image
	
		HintArrowSize = { // Arrow size
			W = 8.0
			H = 8.0
		}
		HintArrowOffset = { // Overlap of the arrow and button
			T = 0.0
			B = 0.0
			L = 0.0
			R = 0.0
		}
		HintArrowImageT = // Link to image
		HintArrowImageB = // Link to image
		HintArrowImageL = // Link to image
		HintArrowImageR = // Link to image
	
		// Content visual settings
	
		ContentInsets = { // Distance from the screen edges
			T = -2.0
			B = -2.0
			L = -2.0
			R = -2.0
		}
		ContentWebViewInsets = { // Offset for WebView
			T = 12.0
			B = 12.0
			L = 12.0
			R = 12.0
		}
		ContentImageInsets = { // Borders for image
			T = 32.0
			B = 32.0
			L = 32.0
			R = 32.0
		}
		ContentURL = http://pizzabtn.com // Link to site to promote
		ContentOpacity = 1.0 // Content opacity
		ContentActivityColor = { // Loading indicator color
			R = 0.0
			G = 0.0
			B = 0.0
			A = 1.0
		}
		ContentImage = // Link to image
	
		ContentArrowSize = { // Content arrow size
			W = 14.0
			H = 14.0
		}
		ContentArrowOffset = { // // Overlap of the arrow and content
			T = 8.0
			B = 8.0
			L = 9.0
			R = 9.0
		}
		ContentArrowImageT = // Link to image with arrow for content
		ContentArrowImageB = // Link to image with arrow for content
		ContentArrowImageL = // Link to image with arrow for content
		ContentArrowImageR = // Link to image with arrow for content
	
		// Animation settings
	
		DefaultDuration = 0.1 // Defaul duration of the animation
		DefaultDelay = 0.0 // Defaul delay of the animation
	
		OpenDuration = 0.2 // Duration for the "Open" animation
		OpenDelay = 0.5 // Delay for the "Open" animation
		CloseDuration = 0.2 // Duration for the "Close" animation
		CloseDelay = 0.5 // Delay for the "CLose" animation
	
		ButtonShowDuration = 0.2 // Duration for the "Show" animation
		ButtonShowDelay = 0.0 // Delay for the  "Show" animation
		ButtonHideDuration = 0.2 // Duration for the "Hide" animation
		ButtonHideDelay = 0.0 // Delay for the "Hide" animation
		ButtonDragDuration = 0.1 // Duration for the "Start moving" animation
		ButtonDragDelay = 0.0 // Delay for the "Start moving" animation
		ButtonUndragDuration = 0.2 //Duration for the "Stop moving" animation
		ButtonUndragDelay = 0.0 // Delay for the "Stop moving" animation
		ButtonInactiveDuration = 0.1 //Duration for the "Inactive" animation 
		ButtonInactiveDelay = 5.0 // The time before the button would switch to "Inactive"
		ButtonInertiaSpeed = 512.0 // The speed of the "Inertion" animation
		ButtonInertiaSpeedMin = 32.0 // The maximum speed of "Inertion" animation
		ButtonInertiaSpeedMax = 1024.0 // The minimum speed of the "Inertion" animation
		ButtonInertiaFactor = 6.0 // Factor for the "Inertion" animation
	
		CloseShowDuration = 0.1 // Duration for the "Show closing area" animation
		CloseShowDelay = 0.0 // Delay for the "Show closing area" animation
		CloseHideDuration = 0.2 // Duration for the "Open closing area" animation
		CloseHideDelay = 0.0 // Delay for the "Open closing area" animation
		CloseActiveDuration = 0.1 // Duration for the "Activate closing area" animation
		CloseActiveDelay = 0.0 // Delay for the "Activate closing area" animation
		CloseUnactiveDuration = 0.1 //Duration for the "Deactivate closing area" animation
		CloseUnactiveDelay = 0.0 // Delay for the "Deactivate closing area" animation
	
		HintLaunchDuration = 3.0 // Duration for the "Show hint at start" animation
		HintLaunchDelay = 0.0 // Delay for the  "Show hint at start" animation
		HintShowDuration = 0.1 // Duration for the "Show hint" animation
		HintShowDelay = 0.0 // Delay for the "Show hint" animation
		HintHideDuration = 0.2 // Duration for the "Hide hint" animation
		HintHideDelay = 0.0 // Delay for the "Hide hint" animation
	
		ContentShowDuration = 0.1 // Duration for the "Show content" animation
		ContentShowDelay = 0.0 // Delay for the "Show content" animation
		ContentHideDuration = 0.2 // Duration for the "Hide content" animation
		ContentHideDelay = 0.0 // Delay for the "Hide content" animation
	}