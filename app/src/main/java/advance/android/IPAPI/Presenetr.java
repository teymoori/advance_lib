package advance.android.IPAPI;

public class Presenetr implements Contract.Presenter {
    private Contract.View v;
    Model model = new Model();

    @Override
    public void attachView(Contract.View v) {
        this.v = v;
        model.attachPresenter(this);
        model.getDetail();
    }

    @Override
    public void onReceiveDetail(IPAPIModel model) {
        v.onReceiveDetail(model);
    }
}
