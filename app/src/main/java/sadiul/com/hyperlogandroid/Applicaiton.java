package sadiul.com.hyperlogandroid;

import android.app.Application;
import android.util.Log;

import com.hypertrack.hyperlog.HyperLog;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 1/23/18.
 */

public class Applicaiton extends Application {

    // uncaught exception handler variable
    private Thread.UncaughtExceptionHandler defaultUEH;


    public static String   convertTime(long time){
        Date date = new Date(time);
        Format format = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
        return format.format(date);
    }


    // handler listener
    private Thread.UncaughtExceptionHandler _unCaughtExceptionHandler =
            new Thread.UncaughtExceptionHandler() {
                @Override
                public void uncaughtException(Thread thread, Throwable ex) {


                    long l = System.currentTimeMillis();
                    String s = convertTime(l);

                    HyperLog.e("application", "application"+s);

                    android.os.Process.killProcess(android.os.Process.myPid());






                }
            };


    @Override
    public void onCreate() {
        super.onCreate();


        HyperLog.initialize(this);
        HyperLog.setLogLevel(Log.VERBOSE);



        defaultUEH = Thread.getDefaultUncaughtExceptionHandler();
//
//        // setup handler for uncaught exception
        Thread.setDefaultUncaughtExceptionHandler(_unCaughtExceptionHandler);


    }
}
