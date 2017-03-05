package com.example.phamvanthinh.solarsystemforchill.FragmentManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.phamvanthinh.solarsystemforchill.R;


/**
 * Created by nickpham on 25/08/2016.
 */
public class fragment_overview_moreS extends Fragment {

    int ImagePathAboutPlanet;
    String OverviewS;

    int KichThuoc = 18;

    public fragment_overview_moreS(){}

    @SuppressLint("ValidFragment")
    public fragment_overview_moreS(int ipp, String ovs){
        this.ImagePathAboutPlanet = ipp;
        this.OverviewS = ovs;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewRop = inflater.inflate(R.layout.fragment_overview_planet_layout,container,false);

        Log.d("OverviewSSS",OverviewS);
        final TextView txtValue = (TextView)viewRop.findViewById(R.id.showAboutOverview);
        txtValue.setText(OverviewS);

        ImageButton btnTangKichThuocOverView = (ImageButton) viewRop.findViewById(R.id.btnTangKichThuocTongQuan);
        btnTangKichThuocOverView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("D", String.valueOf(txtValue.getTextSize()));
                if (KichThuoc < 40)
                {
                    KichThuoc += 2;
                    txtValue.setTextSize(TypedValue.COMPLEX_UNIT_SP, KichThuoc);
                }
            }
        });

        ImageButton btnGiamKichThuocOverView = (ImageButton)viewRop.findViewById(R.id.btnGiamKichThuocTongQuan);
        btnGiamKichThuocOverView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(KichThuoc>18) {
                    KichThuoc -= 2;
                    txtValue.setTextSize(TypedValue.COMPLEX_UNIT_SP, KichThuoc);
                }
            }
        });

        return viewRop;
    }
}
