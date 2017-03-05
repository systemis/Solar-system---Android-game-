package com.example.phamvanthinh.solarsystemforchill.FragmentManager;

import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.phamvanthinh.solarsystemforchill.GAS.DacDiemVatLy;
import com.example.phamvanthinh.solarsystemforchill.R;

/**
 * Created by nickpham on 25/08/2016.
 */
public class fragment_physic_characterisic_moreS extends Fragment {


    DacDiemVatLy diemVatLy;
    int ImagePath;

    public static TextView txtSPlanet, txtRPlanet, txtVPlanet
            , txtmPlanet, txtDPlanet, txtTDQVTC2Planet, txtCKQPlanet, txtTDQTXDPlanet;
    private static ImageView imgAboutPlanetDacDiemDiaLy;
    private static Button btnTangKichThuoc;

    public fragment_physic_characterisic_moreS(){}

    @SuppressLint("ValidFragment")
    public fragment_physic_characterisic_moreS(DacDiemVatLy diemVatLy, int ImagePath){
        this.diemVatLy = diemVatLy;
        this.ImagePath = ImagePath;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewRop = inflater.inflate(R.layout.fragment_physic_characterisic_planet_layout,container,false);

        // Tim ViewGroups
        Anhxa(viewRop);

        // Gan gia tri
        SetValueForViewGroup();

        return viewRop;
    }

    void Anhxa(View viewRop){
        imgAboutPlanetDacDiemDiaLy = (ImageView)viewRop.findViewById(R.id.imageAboutPlanetDacDiemDiaLy);

        txtSPlanet = (TextView)viewRop.findViewById(R.id.showSPlanet);
        txtRPlanet = (TextView)viewRop.findViewById(R.id.showRPlanet);
        txtVPlanet = (TextView)viewRop.findViewById(R.id.showVPlanet);
        txtmPlanet = (TextView)viewRop.findViewById(R.id.showmPlanet);
        txtDPlanet = (TextView)viewRop.findViewById(R.id.showDPlanet);
        txtTDQVTC2Planet = (TextView)viewRop.findViewById(R.id.showTDVTC2Planet);
        txtCKQPlanet = (TextView)viewRop.findViewById(R.id.showChuKyQuayPlanet);
        txtTDQTXDPlanet = (TextView)viewRop.findViewById(R.id.showVTQTXDPlanet);

    }

    void SetValueForViewGroup(){
        imgAboutPlanetDacDiemDiaLy.setImageResource(ImagePath);

        txtSPlanet.setText(diemVatLy.getArea());
        txtRPlanet.setText(diemVatLy.getRPlanet());
        txtVPlanet.setText(diemVatLy.getVPlanet());

        txtmPlanet.setText(diemVatLy.getKhoiLuong());
        txtDPlanet.setText(diemVatLy.getKhoiLuongRieng());
        txtTDQVTC2Planet.setText(diemVatLy.getTocDoVuTruCap2());
        txtCKQPlanet.setText(diemVatLy.getChuKiQuay());
        txtTDQTXDPlanet.setText(diemVatLy.getTocDoQuayTaiXichDao());


    }

}
