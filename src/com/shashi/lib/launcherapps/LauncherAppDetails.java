package com.shashi.lib.launcherapps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;

public class LauncherAppDetails {

	Context mcontext;
	static LauncherAppDetails instance = null;
	List<LauncherAppDescripition> mdescripition = new ArrayList<LauncherAppDescripition>();
	
	public LauncherAppDetails(Context context) {
		// TODO Auto-generated constructor stub
		mcontext = context;
		final PackageManager pm = context.getPackageManager();
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> appList = pm.queryIntentActivities(mainIntent, 0);
        Collections.sort(appList, new ResolveInfo.DisplayNameComparator(pm));
        for (ResolveInfo temp : appList) {
        	try {
				PackageInfo mpackageinfo = pm.getPackageInfo(temp.activityInfo.packageName, 0);
				LauncherAppDescripition instance = new LauncherAppDescripition(temp.activityInfo.packageName,
						mpackageinfo.applicationInfo.loadLabel(pm).toString(), temp.activityInfo.name,
						mpackageinfo.applicationInfo.loadIcon(pm),temp.activityInfo.applicationInfo.targetSdkVersion
						,temp.activityInfo.applicationInfo.uid);
				mdescripition.add(instance);
			} catch (NameNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        Sort();
	}
	
	private void Sort() {
		// TODO Auto-generated method stub
		LauncherAppDescripition temp;
		for(int i=0;i<mdescripition.size();i++){
			for(int j=0;j<mdescripition.size();j++){
				if(mdescripition.get(i).getAppName().compareToIgnoreCase(mdescripition.get(j).getAppName()) < 0){
					temp = mdescripition.get(i);
					mdescripition.set(i, mdescripition.get(j));
					mdescripition.set(j, temp);
				}
			}
		}
	}
	
	public static LauncherAppDetails getInstance(Context context) {
		if(instance == null)
			instance =  new LauncherAppDetails(context);
		return instance;
	}
	
	public int Size() {
		return mdescripition.size();
	}
	
	public String getPackageName(int index) {
		return mdescripition.get(index).getPackageName();
	}
	
	public String getAppName(int index) {
		return mdescripition.get(index).getAppName();
	}
	
	public String getActivityName(int index) {
		return mdescripition.get(index).getActivityName();
	}
	
	public Drawable getIcon(int index) {
		return mdescripition.get(index).getIcon();
	}
	
	public int gettargetSdkVersion(int index) {
		return mdescripition.get(index).getTargetSdkVersio();
	}
	
	public int getuid(int index) {
		return mdescripition.get(index).getUid();
	}
	
	public ArrayList<String> getAllAppNames() {
		ArrayList<String> mtemp = new ArrayList<String>();
		for(int i=0;i<Size();i++)
			mtemp.add(mdescripition.get(i).getAppName());
		return mtemp;
	}
	
	public ArrayList<String> getAllPackageName() {
		ArrayList<String> mtemp = new ArrayList<String>();
		for(int i=0;i<Size();i++)
			mtemp.add(mdescripition.get(i).getPackageName());
		return mtemp;
	}
	
	public ArrayList<Drawable> getAllIcon() {
		ArrayList<Drawable> mtemp = new ArrayList<Drawable>();
		for(int i=0;i<Size();i++)
			mtemp.add(mdescripition.get(i).getIcon());
		return mtemp;
	}
	
	public ArrayList<String> getAllActivityName() {
		ArrayList<String> mtemp = new ArrayList<String>();
		for(int i=0;i<Size();i++)
			mtemp.add(mdescripition.get(i).getActivityName());
		return mtemp;
	}
	
	public ArrayList<Integer> getAllTargetSdkVer() {
		ArrayList<Integer> mtemp = new ArrayList<Integer>();
		for(int i=0;i<Size();i++)
			mtemp.add(mdescripition.get(i).getTargetSdkVersio());
		return mtemp;
	}
	
	public ArrayList<Integer> getAllUid() {
		ArrayList<Integer> mtemp = new ArrayList<Integer>();
		for(int i=0;i<Size();i++)
			mtemp.add(mdescripition.get(i).getUid());
		return mtemp;
	}
	
	public void RefreshList() {
		instance = new LauncherAppDetails(mcontext);
	}
}
