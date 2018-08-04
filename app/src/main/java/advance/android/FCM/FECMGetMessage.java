package advance.android.FCM;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;


public class FECMGetMessage extends
        FirebaseMessagingService {


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Log.d("fcm_", "From: " + remoteMessage.getFrom());


        Handler handler = new Handler(Looper.getMainLooper()) ;

        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(FECMGetMessage.this, remoteMessage.getNotification().getTitle()
                        + " " + remoteMessage.getNotification().getBody(), Toast.LENGTH_SHORT).show();
            }
        });




        // Check if message contains a data payload.
//        if (remoteMessage.getData().size() > 0) {
//            Log.d("fcm_", "Message data payload: " + remoteMessage.getData());
//
//
//        }


        }
}
