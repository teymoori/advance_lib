package advance.android.mvp_simple;

public class Model implements Contract.Model {
    private Contract.Presenter presenter;

    @Override
    public void attachPresenter(Contract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getResult() {
        String res = "Salam MVP!";
        presenter.onResult(res);
    }
}
