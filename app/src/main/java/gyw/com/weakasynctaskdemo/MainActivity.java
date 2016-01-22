package gyw.com.weakasynctaskdemo;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.tv)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        new MyTask(this).execute();

    }

    private static class MyTask extends WeakAsyncTask<Void, Void, String, MainActivity> {

        public MyTask(MainActivity target) {
            super(target);
        }

        @Override
        protected String doInBackground(MainActivity target, Void... params) {
            //获取context
//            Context context = target;

            SystemClock.sleep(2000);
            return "Hello Android    !!!!!";
        }

        @Override
        protected void onPostExecute(MainActivity target, String s) {
            target.tv.setText(s);
        }
    }
}
