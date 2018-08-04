package advance.android.IPAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Model implements Contract.Model {
    private Contract.Presenter p;

    @Override
    public void attachPresenter(Contract.Presenter p) {
        this.p = p;
    }

    @Override
    public void getDetail() {
        Generator.createService(EndPoints.class)
                .getDetails().enqueue(new Callback<IPAPIModel>() {
            @Override
            public void onResponse(Call<IPAPIModel> call, Response<IPAPIModel> response) {
                p.onReceiveDetail(response.body());
            }

            @Override
            public void onFailure(Call<IPAPIModel> call, Throwable t) {

            }
        });
    }
}
