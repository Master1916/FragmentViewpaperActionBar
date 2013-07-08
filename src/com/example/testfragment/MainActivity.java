package com.example.testfragment;

 
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends FragmentActivity  implements ActionBar.TabListener{

	MyViewPagerAdapter myAdapter;
	ActionBar actionbar;
	private ViewPager pager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		actionbar=getActionBar();
		//actionbar.setHomeButtonEnabled(false);
	    actionbar.setDisplayShowHomeEnabled(false);
		actionbar.setDisplayShowTitleEnabled(false);
		actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		 
		pager = (ViewPager) findViewById(R.id.viewpager);
		myAdapter=new MyViewPagerAdapter(getSupportFragmentManager());
		pager.setAdapter(myAdapter);
		
		pager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
			 
				//当选择Actionbar时 viewpager 会根据你的选择切换不同的界面
				actionbar.setSelectedNavigationItem(position);
			}
			
		});
		
		//初始化actionBar Tab
		for(int i=0;i<myAdapter.getCount();i++){
			if(i==0){
				actionbar.addTab(
					actionbar.newTab().
					setText("词典").
					setTabListener(this));
			}else if(i==1){
				actionbar.addTab(
						actionbar.newTab().
						setText("翻译").
						setTabListener(this));
			}else if(i==2){
				actionbar.addTab(
						actionbar.newTab().
						setText("单词本").
						setTabListener(this));
				
			}else if(i==3){
				actionbar.addTab(
						actionbar.newTab().
						setText("云图书").
						setTabListener(this));
				
			}
			
		}
		
	}
	public class MyViewPagerAdapter extends FragmentPagerAdapter {

		public MyViewPagerAdapter(FragmentManager fm) {
			super(fm);

		}

		@Override
		public Fragment getItem(int arg0) {
			// TODO Auto-generated method stub
			
			switch (arg0) {
			case 0:
				
				MyFragment_one one =new MyFragment_one();
				return one;
			case 1:
				MyFragment_two two=new MyFragment_two();
				return two;
			case 2:
				MyFragment_three three=new MyFragment_three();
				return three;
			case 3:
				MyFragment_four four=new MyFragment_four();
				return four;
			default:
				break;
			}
			
			return null;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 4;
		}
		@Override
		public CharSequence getPageTitle(int position) {
			// TODO Auto-generated method stub
			
			return super.getPageTitle(position);
			
		}
		

	}

  public class MyFragment_one extends Fragment {
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			    View view=inflater.inflate(R.layout.fragment_one, container,false);
		 
			return view;
		}

	}

	public class MyFragment_two extends Fragment {
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
			   Bundle savedInstanceState) {
			   View view=inflater.inflate(R.layout.fragment_one, container,false);
			 
			   return view;
		}
	}

	public class MyFragment_three extends Fragment {
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			    View view=inflater.inflate(R.layout.fragment_one, container,false);
			 
				return view;
		}
	}

	public class MyFragment_four extends Fragment {
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			 View view=inflater.inflate(R.layout.fragment_one, container,false);
			 
				return view;
		}
	}
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		pager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

}