android-orm
===========
参考了[Apache dbutils](http://commons.apache.org/proper/commons-dbutils/)

#### 简单的ORM,直接使用SQL操作数据库
功能：

- 异步加载
- 查询直接返回bean

####How to use

	String sql = "select id,name from test";
	QueryHelper.findBeans(TestBean.class,sql,null, new QueryHelper.FindBeansCallBack<TestBean>() {
		@Override
		public void onFinish(List<TestBean> beans) {
			for(TestBean bean : beans){
				Log.i("test", bean.toString());
			}
		}
	});