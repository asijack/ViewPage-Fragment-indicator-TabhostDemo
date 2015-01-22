package com.asijack.viewpagerindicator;

import com.viewpagerindicator.PageIndicator;
import com.viewpagerindicator.UnderlinePageIndicator;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;
public class MainActivity extends FragmentActivity {
	
	MyFragmentAdapter mAdapter;
    ViewPager mPager;
    private TextView view1,view2,view3,view4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//初始化textview
		initTextView();
		
        mAdapter = new MyFragmentAdapter(getSupportFragmentManager());

        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

        //指示器
        UnderlinePageIndicator indicator = (UnderlinePageIndicator)findViewById(R.id.indicator);
        indicator.setViewPager(mPager);
        //设置静止时不消失
        indicator.setFades(false);
	}

	private void initTextView() {
		//每个fragment(view) 对应的 textview
		view1=(TextView) findViewById(R.id.tv_guid1);
		view2=(TextView) findViewById(R.id.tv_guid2);
		view3=(TextView) findViewById(R.id.tv_guid3);
		view4=(TextView) findViewById(R.id.tv_guid4);
		//设置监听
		view1.setOnClickListener(new TxListener(0));
		view2.setOnClickListener(new TxListener(1));
		view3.setOnClickListener(new TxListener(2));
		view4.setOnClickListener(new TxListener(3));
	}
	
	public class TxListener implements View.OnClickListener{
		private int index=0;
		
		public TxListener (int i){
			index=i;
		}
		@Override
		public void onClick(View view) {
			mPager.setCurrentItem(index);
		}
		
	}

}
