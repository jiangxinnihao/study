package com.example.test6;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends Activity {
	ViewPager viewpager;
	private List<ImageView> imaageviews = new ArrayList<ImageView>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        initviews();
        viewpager.setAdapter(new MyPageView<ImageView>(this,imaageviews));
    }
	private void initviews() {
		int[] items = new int[]{R.drawable.a,R.drawable.b,R.drawable.c};
		ImageView imageview;
		for(int i=0;i<items.length;i++){
			imageview = new ImageView(this);
			imageview.setImageResource(items[i]);
			imaageviews.add(imageview);
		}
		
	}
	private class MyPageView<T> extends PagerAdapter{
		List<T> views;
		Context mcontext;
		private MyPageView(Context context,List<T> views) {
			this.views = views;
			this.mcontext = context;

		}
		@Override
		public int getCount() {
			
			return views.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {

			return arg0==arg1;
		}
		@Override
		public Object instantiateItem(View container, int position) {
				((ViewGroup)container).addView(imaageviews.get(position));
			return imaageviews.get(position);
		}
		@Override
		public void destroyItem(View container, int position, Object object) {
			
			((ViewGroup)container).removeView(imaageviews.get(position));
		}

	
	}
}
