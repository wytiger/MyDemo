package com.wytiger.mydemo;

import android.view.View;

/**
 * View包装类，提供设置View的宽高的方法
 * 
 * @author wytiger
 * @date 2016-7-21
 */
public class ViewWrapper {
	private View mTarget;

	public ViewWrapper(View target) {
		mTarget = target;
	}

	public int getWidth() {
		return mTarget.getLayoutParams().width;
	}

	public void setWidth(int width) {
		mTarget.getLayoutParams().width = width;
		mTarget.requestLayout();
	}

	public int getHeight() {
		return mTarget.getLayoutParams().height;
	}

	public void setHeight(int height) {
		mTarget.getLayoutParams().height = height;
		mTarget.requestLayout();
	}
}
