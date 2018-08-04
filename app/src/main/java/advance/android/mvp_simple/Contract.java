package advance.android.mvp_simple;

public interface Contract {

    interface View{
        void showResult(String result);
    }

    interface Presenter{
        void attachView(View view) ;
        void onClick() ;
        void onResult(String result) ;
    }
    interface Model{
        void attachPresenter(Presenter presenter) ;
        void getResult() ;
    }

}
