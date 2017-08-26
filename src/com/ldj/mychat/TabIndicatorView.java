package com.ldj.mychat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TabIndicatorView extends RelativeLayout {

	private ImageView ivTabIcon;//图标
	private TextView tvTabHint;//图标下面的文字标题
	private TextView tvTabUnRead;//图标右上角的未读数字
	
	
	private int normalIconId;
	private int focusIconId;
	
	public TabIndicatorView(Context context) {
		this(context, null);
	}

	
	public TabIndicatorView(Context context, AttributeSet attrs) {
		super(context, attrs);

		//将布局文件和代码进行绑定
		View.inflate(context, R.layout.tab_indicator, this);

		ivTabIcon = (ImageView) findViewById(R.id.tab_indicator_icon);
		tvTabHint = (TextView) findViewById(R.id.tab_indicator_hint);
		tvTabUnRead = (TextView) findViewById(R.id.tab_indicator_unread);
		//初始化未读未0
		setTabUnreadCount(0);
	}
	
	//设置图标下面的文字标题
	public void setTabTitle(String title) {
		tvTabHint.setText(title);
	}
	
	//设置图标下面的文字标题
	public void setTabTitle(int titleId) {
		tvTabHint.setText(titleId);
	}
	
	//初始化选中/未选中/未读三种图标资源
	public void setTabIcon(int normalIconId, int focusIconId) {
		this.normalIconId = normalIconId;
		this.focusIconId = focusIconId;

		ivTabIcon.setImageResource(normalIconId);
	}
	
	
	//设置选中/未选中Tab时的图片切换
	public void setTabSelected(boolean selected) {
		if (selected) {
			ivTabIcon.setImageResource(focusIconId);
		} else {
			ivTabIcon.setImageResource(normalIconId);
		}
	}
	
	//设置图标右上角的未读数字以及红色图标可见
	public void setTabUnreadCount(int unreadCount) {
		if (unreadCount <= 0) {
			//无未读，红色图标不可见
			tvTabUnRead.setVisibility(View.GONE);
		} else {
			if (unreadCount <= 99) {
				//有未读信息
				tvTabUnRead.setText(unreadCount + "");
			} else {
				//超过99条未读信息
				tvTabUnRead.setText("99+");
			}
			//未读，红色图标可见
			tvTabUnRead.setVisibility(View.VISIBLE);
		}
	}
	
	
	//设置图标右上角的红色图标可见
	public void setTabUnread(boolean isUnread) {
		if (!isUnread) {
			//无未读，红色图标不可见
			tvTabUnRead.setVisibility(View.GONE);
		} else {
			//未读，红色图标可见
			tvTabUnRead.setText("");
			tvTabUnRead.setVisibility(View.VISIBLE);
		}
	}

	
	
}
