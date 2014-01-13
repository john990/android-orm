package com.android.orm;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class TestActivity extends Activity {
	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		QueryHelper.init(new DbHelper(this));

		String sql1 = "select id,name from test";
		String sql2 = "insert into test values (?,?)";
//		for(int i=0;i<100;i++){
//			QueryHelper.update(sql2, new String[]{i + "", "name" + i}, null);
//		}

		QueryHelper.findBeans(TestBean.class,sql1,null, new QueryHelper.FindBeansCallBack<TestBean>() {
			@Override
			public void onFinish(List<TestBean> beans) {
				for(TestBean bean : beans){
					Log.i("test", bean.toString());
				}
			}
		});
	}
}
