package sunny.example.lianswiperefreshlayout;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.Handler;
//import android.view.Window;
import android.widget.TextView;

/**
 * 使用SwipeRefreshLayout下拉刷新效果，顶端有颜色变换，Cool*/
/*SwipeRefreshLayout
public class SwipeRefreshLayout 
extends ViewGroup implements NestedScrollingParent, NestedScrollingChild

java.lang.Object
   ↳	android.view.View
 	   ↳	android.view.ViewGroup
 	 	   ↳	android.support.v4.widget.SwipeRefreshLayout*/
public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		final TextView mTextView = (TextView)findViewById(R.id.refresh);
		final SwipeRefreshLayout mSwipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipe_refresh_layout);
		mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_blue_light, android.R.color.holo_green_light, android.R.color.holo_orange_light);
		mSwipeRefreshLayout.setOnRefreshListener(new OnRefreshListener(){
							@Override
			               public void onRefresh() {
				  			mTextView.setText("正在刷新");
			                 // TODO Auto-generated method stub
				  			//boolean android.os.Handler.postDelayed(Runnable r, long delayMillis)
			                  new Handler().postDelayed(new Runnable() {
			                     
			                     @Override
			                    public void run() {
			                         // TODO Auto-generated method stub
			                    	 mTextView.setText("刷新完成");
			                    	 mSwipeRefreshLayout.setRefreshing(false);
			                     }
			                 }, 5000);
			            }
		});
	}

	
}
