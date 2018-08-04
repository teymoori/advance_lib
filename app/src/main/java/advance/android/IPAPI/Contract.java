package advance.android.IPAPI;

public interface Contract {
    interface View {
        void onReceiveDetail(IPAPIModel model) ;
    }

    interface Presenter {
        void attachView(View v);
        void onReceiveDetail(IPAPIModel model) ;
    }

    interface Model {
        void attachPresenter(Presenter p);
        void getDetail() ;
    }
}
