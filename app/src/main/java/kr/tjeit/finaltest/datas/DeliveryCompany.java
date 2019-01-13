package kr.tjeit.finaltest.datas;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class DeliveryCompany  implements Serializable {


    private int id;
    private String DCName;
    private String logoUrl;


    public  static DeliveryCompany getCompanyFromJson (JSONObject companyJson){


        DeliveryCompany deliveryCompany = new DeliveryCompany();

        try {
            deliveryCompany.setId(companyJson.getInt("id"));
            deliveryCompany.setDCName(companyJson.getString("name"));
            deliveryCompany.setLogoUrl(companyJson.getString("logo"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return deliveryCompany;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDCName() {
        return DCName;
    }

    public void setDCName(String DCName) {
        this.DCName = DCName;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
