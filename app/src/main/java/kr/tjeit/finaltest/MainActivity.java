package kr.tjeit.finaltest;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import kr.tjeit.finaltest.adpater.DeliveryCompanyAdapter;
import kr.tjeit.finaltest.datas.DeliveryCompany;
import kr.tjeit.finaltest.utils.ConnectServer;

public class MainActivity extends BaseActivity {

    List<DeliveryCompany> deliveryCompanyList = new ArrayList<DeliveryCompany>();
    ListView dComListView;


    DeliveryCompanyAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        bindView();
        setupEvents();
        setValues();


    }

    @Override
    public void setupEvents() {


    }

    @Override
    public void setValues() {

        mAdapter =new DeliveryCompanyAdapter(mContext, deliveryCompanyList);

        dComListView.setAdapter(mAdapter);

        getCompanyFromServer();

    }

    void  getCompanyFromServer(){

        ConnectServer.getRequestCompanyInfo(mContext, new ConnectServer.JsonResponseHandler() {
            @Override
            public void onResponse(JSONObject json) {
                Log.d("택배회사목록",json.toString());

                try {

                    int code = json.getInt("code");

                    if (code == 200) {

                        JSONObject data = json.getJSONObject("data");
                        JSONArray company = data.getJSONArray("company");

                        for (int i =0; i <company.length(); i++){

                            JSONObject companyJson = company.getJSONObject(i);

                            DeliveryCompany companyObject = DeliveryCompany.getCompanyFromJson(companyJson);
                            deliveryCompanyList.add(companyObject);

                        }


                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        });


    }

    @Override
    public void bindView() {

        this.dComListView = (ListView) findViewById(R.id.dComListView);


    }
}
