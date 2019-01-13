package kr.tjeit.finaltest.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import kr.tjeit.finaltest.R;
import kr.tjeit.finaltest.datas.DeliveryCompany;

public class DeliveryCompanyAdapter extends ArrayAdapter<DeliveryCompany> {

    Context mContext;
    List<DeliveryCompany> mList;
    LayoutInflater inf;

    public  DeliveryCompanyAdapter(Context context, List<DeliveryCompany> list){

        super(context , R.layout.deliverycompany_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);


    }


    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {

        View row = convertView;
        if (row == null){

            row= inf.inflate(R.layout.deliverycompany_list_item,null);


        }

        ImageView logoImgView = row.findViewById( R.id.logoImgView);
        TextView DCNameTxt = row.findViewById(R.id.DCNameTxt);

        DeliveryCompany data = mList.get(position);

        Glide.with(mContext).load(data.getLogoUrl()).into(logoImgView);

        DCNameTxt.setText(data.getDCName());

        return row;


    }
}
