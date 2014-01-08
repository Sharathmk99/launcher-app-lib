package com.shashi.lib.launcherapps;

import android.graphics.drawable.Drawable;

public class LauncherAppDescripition {

	String PackageName,AppName,ActivityName;
	int Uid,TargetSDKVersion;
	Drawable icon;
	public LauncherAppDescripition() {
		// TODO Auto-generated constructor stub
	}
	
	public  LauncherAppDescripition(String packagename,String appname, String activityname,Drawable icon,int targetsdk,int uid) {
		PackageName = packagename;
		AppName = appname;
		ActivityName = activityname;
		this.icon = icon;
		TargetSDKVersion = targetsdk;
		Uid = uid;
	}
	
	public String getPackageName() {
		return PackageName;
	}
	
	public String getAppName() {
		return AppName;
	}
	
	public String getActivityName() {
		return ActivityName;
	}
	
	public Drawable getIcon() {
		return icon;
	}
	
	public int getTargetSdkVersio() {
		return TargetSDKVersion;
	}
	
	public int getUid() {
		return Uid; 
	}
}
