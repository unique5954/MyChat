package com.ldj.mychat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TabIndicatorView extends RelativeLayout {

	private ImageView ivTabIcon;//ͼ��
	private TextView tvTabHint;//ͼ����������ֱ���
	private TextView tvTabUnRead;//ͼ�����Ͻǵ�δ������
	
	
	private int normalIconId;
	private int focusIconId;
	
	public TabIndicatorView(Context context) {
		this(context, null);
	}

	
	public TabIndicatorView(Context context, AttributeSet attrs) {
		super(context, attrs);

		//�������ļ��ʹ�����а�
		View.inflate(context, R.layout.tab_indicator, this);

		ivTabIcon = (ImageView) findViewById(R.id.tab_indicator_icon);
		tvTabHint = (TextView) findViewById(R.id.tab_indicator_hint);
		tvTabUnRead = (TextView) findViewById(R.id.tab_indicator_unread);
		//��ʼ��δ��δ0
		setTabUnreadCount(0);
	}
	
	//����ͼ����������ֱ���
	public void setTabTitle(String title) {
		tvTabHint.setText(title);
	}
	
	//����ͼ����������ֱ���
	public void setTabTitle(int titleId) {
		tvTabHint.setText(titleId);
	}
	
	//��ʼ��ѡ��/δѡ��/δ������ͼ����Դ
	public void setTabIcon(int normalIconId, int focusIconId) {
		this.normalIconId = normalIconId;
		this.focusIconId = focusIconId;

		ivTabIcon.setImageResource(normalIconId);
	}
	
	
	//����ѡ��/δѡ��Tabʱ��ͼƬ�л�
	public void setTabSelected(boolean selected) {
		if (selected) {
			ivTabIcon.setImageResource(focusIconId);
		} else {
			ivTabIcon.setImageResource(normalIconId);
		}
	}
	
	//����ͼ�����Ͻǵ�δ�������Լ���ɫͼ��ɼ�
	public void setTabUnreadCount(int unreadCount) {
		if (unreadCount <= 0) {
			//��δ������ɫͼ�겻�ɼ�
			tvTabUnRead.setVisibility(View.GONE);
		} else {
			if (unreadCount <= 99) {
				//��δ����Ϣ
				tvTabUnRead.setText(unreadCount + "");
			} else {
				//����99��δ����Ϣ
				tvTabUnRead.setText("99+");
			}
			//δ������ɫͼ��ɼ�
			tvTabUnRead.setVisibility(View.VISIBLE);
		}
	}
	
	
	//����ͼ�����Ͻǵĺ�ɫͼ��ɼ�
	public void setTabUnread(boolean isUnread) {
		if (!isUnread) {
			//��δ������ɫͼ�겻�ɼ�
			tvTabUnRead.setVisibility(View.GONE);
		} else {
			//δ������ɫͼ��ɼ�
			tvTabUnRead.setText("");
			tvTabUnRead.setVisibility(View.VISIBLE);
		}
	}

	
	
}
