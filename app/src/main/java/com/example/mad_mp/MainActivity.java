
package com.example.mad_mp;

        import androidx.appcompat.app.AppCompatActivity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.WindowManager;
        import android.window.SplashScreen;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Thread td = new Thread(){

            @Override
            public void run() {
                try {

                    sleep(1000);

                }catch (Exception exception){
                    exception.printStackTrace();
                }finally {

                    Intent intent = new Intent(MainActivity.this, Activity2.class);
                    startActivity(intent);
                    finish();

                }
            }
        };td.start();
    }
}