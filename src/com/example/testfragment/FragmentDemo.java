package com.example.testfragment;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class FragmentDemo extends FragmentActivity {
	MyAdapter myadapter;

	ActionBar actionbar;

	ViewPager pager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragmentlayout);
		pager = (ViewPager) findViewById(R.id.pager);
		myadapter = new MyAdapter(getSupportFragmentManager());
		pager.setAdapter(myadapter);
		
		actionbar = getActionBar();
		actionbar.setHomeButtonEnabled(true);
		actionbar.setDisplayShowHomeEnabled(true);
		// 返回home的地方会有一个 箭头
		actionbar.setDisplayHomeAsUpEnabled(true);
	}

	public class MyAdapter extends FragmentStatePagerAdapter {

		public MyAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int arg0) {
			// TODO Auto-generated method stub
			switch (arg0) {
			case 0:
				MyFragment_one one = new MyFragment_one();
				return one;
			case 1:
				MyFragment_two two = new MyFragment_two();
				return two;
			case 2:
				MyFragment_three three = new MyFragment_three();
				return three;
			case 3:
				MyFragment_four four = new MyFragment_four();
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
			switch (position) {
			case 0:

				return "已下载";
			case 1:

				return "正在运行";
			case 2:

				return "全部";
			case 3:

				return "服务";
			default:
				break;
			}
			return null;
		}

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if (item.getItemId() == android.R.id.home) {
			Intent upIntent = new Intent(this, MainActivity.class);
			if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
				System.out
						.println("NavUtils.shouldUpRecreateTask(this, upIntent)");
				// This activity is not part of the application's task, so
				// create a new task
				// with a synthesized back stack.
				// 上级 Activity 没有起动过， 需要创建一个新的导航栈道
				TaskStackBuilder.from(this)
				// If there are ancestor activities, they should be added here.
						.addNextIntent(upIntent).startActivities();
				finish();
			} else {
				System.out.println("NavUtils.navigateUpTo(this, upIntent);");
				// This activity is part of the application's task, so simply
				// navigate up to the hierarchical parent activity.
				NavUtils.navigateUpTo(this, upIntent);
			}

		}

		return super.onOptionsItemSelected(item);
	}

	public class MyFragment_one extends Fragment {
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View view = inflater.inflate(R.layout.fragment_one, container,
					false);

			return view;
		}

	}

	public class MyFragment_two extends Fragment {
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View view = inflater.inflate(R.layout.fragment_one, container,
					false);
			return view;
		}
	}

	public class MyFragment_three extends Fragment {
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View view = inflater.inflate(R.layout.fragment_one, container,
					false);

			return view;
		}
	}

	public class MyFragment_four extends Fragment {
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View view = inflater.inflate(R.layout.fragment_one, container,
					false);

			return view;
		}
	}

}
