package com.ldj.mychat;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;

public class HomeActivity extends FragmentActivity implements OnTabChangeListener{
	private final static String TAG_CHAT = "chat";
	private final static String TAG_CONTACT = "contact";
	private final static String TAG_DISCOVER = "discover";
	private final static String TAG_ME = "me";
	
	private FragmentTabHost tabHost;
	
	private TabIndicatorView chatIndicator;
	private TabIndicatorView contactIndicator;
	private TabIndicatorView discoverIndicator;
	private TabIndicatorView meIndicator;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_home);
        

		//1、初始化TabHost
		tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		tabHost.setup(this, getSupportFragmentManager(), R.id.activity_home_container);
		
		//2、新建TabSpec
		TabSpec spec = tabHost.newTabSpec(TAG_CHAT);
		chatIndicator = new TabIndicatorView(this);
		chatIndicator.setTabTitle("消息");
		chatIndicator.setTabIcon(R.drawable.tab_icon_chat_normal, R.drawable.tab_icon_chat_focus);
		chatIndicator.setTabUnreadCount(10);
		spec.setIndicator(chatIndicator);
		//3、添加TabSpec
		tabHost.addTab(spec, MyFragment.class, null);
		
		//2、新建TabSpec
		spec = tabHost.newTabSpec(TAG_CONTACT);
		contactIndicator = new TabIndicatorView(this);
		contactIndicator.setTabTitle("通讯录");
		contactIndicator.setTabIcon(R.drawable.tab_icon_contact_normal, R.drawable.tab_icon_contact_focus);
		contactIndicator.setTabUnreadCount(100);
		spec.setIndicator(contactIndicator);
		//3、添加TabSpec
		tabHost.addTab(spec, MyFragment.class, null);
		
		//2、新建TabSpec
		spec = tabHost.newTabSpec(TAG_DISCOVER);
		discoverIndicator = new TabIndicatorView(this);
		discoverIndicator.setTabTitle("发现");
		discoverIndicator.setTabIcon(R.drawable.tab_icon_discover_normal, R.drawable.tab_icon_discover_focus);
		discoverIndicator.setTabUnread(true);
		spec.setIndicator(discoverIndicator);
		//3、添加TabSpec
		tabHost.addTab(spec, MyFragment.class, null);
		
		//2、新建TabSpec
		spec = tabHost.newTabSpec(TAG_ME);
		meIndicator = new TabIndicatorView(this);
		meIndicator.setTabTitle("我");
		meIndicator.setTabIcon(R.drawable.tab_icon_me_normal, R.drawable.tab_icon_me_focus);
		meIndicator.setTabUnreadCount(8);
		spec.setIndicator(meIndicator);
		//3、添加TabSpec
		tabHost.addTab(spec, MyFragment.class, null);
		
		//tab之间的分隔符去色
//		tabHost.getTabWidget().setDividerDrawable(android.R.color.white);

		//当前选中的Tab
		tabHost.setCurrentTabByTag(TAG_CHAT);
		//设置选中Tab的图片
		chatIndicator.setTabSelected(true);
		
		
		//设置tabHost的选中事件
		tabHost.setOnTabChangedListener(this);
    }

	@Override
	public void onTabChanged(String tabId) {
		//取消所有的Tab选中图片(变灰色图)
		chatIndicator.setTabSelected(false);
		contactIndicator.setTabSelected(false);
		discoverIndicator.setTabSelected(false);
		meIndicator.setTabSelected(false);
		//根据当前选中的Tab切换图片
		if(TAG_CHAT.equals(tabId)){
			chatIndicator.setTabSelected(true);
		}else if(TAG_CONTACT.equals(tabId)){
			contactIndicator.setTabSelected(true);
		}else if(TAG_DISCOVER.equals(tabId)){
			discoverIndicator.setTabSelected(true);
		}else if(TAG_ME.equals(tabId)){
			meIndicator.setTabSelected(true);
		}
	}


    
}
