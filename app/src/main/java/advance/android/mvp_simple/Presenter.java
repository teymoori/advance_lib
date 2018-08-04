package advance.android.mvp_simple;

public class Presenter implements Contract.Presenter {

    Contract.View view;

    Model model = new Model();;

    @Override
    public void attachView(Contract.View view) {
        this.view = view;
        model.attachPresenter(this);
    }

    @Override
    public void onClick() {
        model.getResult();
    }

    @Override
    public void onResult(String result) {
        view.showResult(result);
    }


}
