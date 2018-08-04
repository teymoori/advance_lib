package advance.android.FCM;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.orhanobut.hawk.Hawk;

public class FCMGetToken
        extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Hawk.put("fcm_token", refreshedToken);
        //send to webservice
        Log.d("fcm_", "onTokenRefresh: " + refreshedToken);





    }
}
