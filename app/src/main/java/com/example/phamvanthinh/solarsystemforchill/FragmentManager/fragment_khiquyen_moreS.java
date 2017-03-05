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
 * Created by nickpham on 26/08/2016.
 */
public class fragment_khiquyen_moreS extends Fragment {

    String KhiQuyenThis;
    int KichThuoc = 18;

    public fragment_khiquyen_moreS(){}


    @SuppressLint("ValidFragment")
    public fragment_khiquyen_moreS(String khiquyenNoidung){
        this.KhiQuyenThis = khiquyenNoidung;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewRop = inflater.inflate(R.layout.fragment_khiquyen_planet_layout,container,false);
        final TextView txtValue = (TextView)viewRop.findViewById(R.id.hienthikhiquyen);
        txtValue.setText(KhiQuyenThis);

        ImageButton btnTangKichThuoc = (ImageButton) viewRop.findViewById(R.id.btnTangKichThuoc);
        btnTangKichThuoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (KichThuoc < 40){
                    KichThuoc += 2;
                    txtValue.setTextSize(TypedValue.COMPLEX_UNIT_SP, KichThuoc);
            }

            }
        });

        ImageButton btnGiamKichThuoc = (ImageButton)viewRop.findViewById(R.id.btnGiamKichThuoc);
        btnGiamKichThuoc.setOnClickListener(new View.OnClickListener() {
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
