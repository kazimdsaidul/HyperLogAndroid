package sadiul.com.hyperlogandroid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.hypertrack.hyperlog.HLCallback;
import com.hypertrack.hyperlog.HyperLog;
import com.hypertrack.hyperlog.error.HLErrorResponse;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();


    private Button btGenerator;
    private Button btSend;
    private Button btError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HyperLog.initialize(this);
        HyperLog.setLogLevel(Log.VERBOSE);


        HyperLog.d(TAG,"Debug Log");
        HyperLog.d(TAG,"Debug Log22");
        HyperLog.d("1", "2");


        btGenerator = findViewById(R.id.btGenerator);
        btSend = findViewById(R.id.btSend);
        btError = findViewById(R.id.btError);


        btGenerator.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                long l = System.currentTimeMillis();
                HyperLog.e("saidul", "saidul");

            }
        });


        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HyperLog.setURL("https://requestb.in/sl9lsysl");
               HyperLog.pushLogs(MainActivity.this, false, new HLCallback() {
                    @Override
                    public void onSuccess(@NonNull Object response) {
                        Log.e(TAG, "onSuccess: ");
                    }

                    @Override
                    public void onError(@NonNull HLErrorResponse HLErrorResponse) {

                        Log.e(TAG, "onError: ");
                    }
                });
            }
        });

        btError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Object o = new ArrayList<>().get(100);


            }
        });





    }
}
