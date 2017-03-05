package com.example.phamvanthinh.solarsystemforchill;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.phamvanthinh.solarsystemforchill.GAS.PlanetPhysicCharacteristics;

public class ManHinhChinh extends AppCompatActivity {

    private static ImageView imageViewMercury, imageViewVenus, imageViewEarth, imageViewMars, imageViewJupiter, imageViewSaturn,
                            imageViewUranus, imageViewNeptune;

    int[] ImageAboutPlaner = {R.mipmap.saothuy,R.mipmap.venus1,R.mipmap.traidat1,R.mipmap.saohoa2,R.mipmap.jupiter1,R.mipmap.saturn
                            , R.mipmap.uranus,R.mipmap.neptune};

    int[] PlanetName       = {R.string.MercuryName,R.string.VenusName,R.string.EarthName,R.string.MarsName,R.string.JupiterName,R.string.SaturnName
                            ,R.string.UranusName,R.string.Neptune};

    int[] PlanerNameEnglish = {R.string.MercuryNameE,R.string.VenusNameE,R.string.EarthNameE, R.string.MarsNameE,R.string.JupiterNameE,R.string.SaturnNameE
                            ,R.string.UranusNameE,R.string.NeptuneE};

    String[] PlanetArea = {"74.800.000 KiLoMet Vuông","460.200.000 km²","510.100.000 km²","144.800.000 km"
                            , "61.419.000.000 km²","42.700.000.000 km²","8.115.600.000 km²","7.618.300.000 km²"};

    String[] PlanetR = {" 2.440 KiLoMet","6.052 KiLoMet","6.371 KiLoMet","3.390 KiLoMet"
                        , "69.911 KiLoMet","58.232 KiLoMet"," 25.362 KiLoMet","24.622 KiLoMet"};

    String[] PlanetV = {"9,28×1011 KiLoMet Khối","6,083×1010 KiLomet Khối","1083,2073 × 109 km³","1,6318×1011 KiLoMet Khối"
                        , "1,4313×1015 km3","8,2713×1014 km3","6,833×1013 km3","6,254×1013 km3"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chinh);

        Anhxa();

        SetListenerPlanet();

    }

    // Anh xa gia tri ViewGroups voi xml
    void Anhxa(){
        imageViewMercury = (ImageView)this.findViewById(R.id.ImageView_Mercury_ManHinhChinh);
        imageViewVenus = (ImageView)this.findViewById(R.id.ImageView_Venus_ManHinhChinh);
        imageViewEarth = (ImageView)this.findViewById(R.id.ImageView_Earth_ManHinhChinh);
        imageViewMars = (ImageView)this.findViewById(R.id.Imageview_Mars_ManHinhChinh);
        imageViewJupiter = (ImageView)this.findViewById(R.id.ImageView_Jupiter_ManHinhChinh);
        imageViewSaturn = (ImageView)this.findViewById(R.id.ImageView_Saturn_ManHinhChinh);
        imageViewUranus = (ImageView)this.findViewById(R.id.ImageView_Uranus_ManHinhChinh);
        imageViewNeptune = (ImageView)this.findViewById(R.id.ImageView_Neptune_ManHinhChinh);
    }

    // Gan su kien nhan cho ViewGroup
    int SetListenerPlanet(){
        View.OnClickListener listenerPlanet = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()){
                    case R.id.ImageView_Mercury_ManHinhChinh:
                        dialogAboutPlanetClicked(0).show();
                        break;
                    case R.id.ImageView_Venus_ManHinhChinh:
                        dialogAboutPlanetClicked(1).show();
                        break;

                    case R.id.ImageView_Earth_ManHinhChinh:
                        dialogAboutPlanetClicked(2).show();
                        break;

                    case R.id.Imageview_Mars_ManHinhChinh:
                        dialogAboutPlanetClicked(3).show();
                        break;
                    case R.id.ImageView_Jupiter_ManHinhChinh:
                        dialogAboutPlanetClicked(4).show();
                        break;

                    case R.id.ImageView_Saturn_ManHinhChinh:
                        dialogAboutPlanetClicked(5).show();
                        break;

                    case R.id.ImageView_Uranus_ManHinhChinh:
                        dialogAboutPlanetClicked(6).show();
                        break;

                    case R.id.ImageView_Neptune_ManHinhChinh:
                        dialogAboutPlanetClicked(7).show();
                        break;
                }

            }
        };

        imageViewMercury.setOnClickListener(listenerPlanet);
        imageViewVenus.setOnClickListener(listenerPlanet);
        imageViewEarth.setOnClickListener(listenerPlanet);
        imageViewMars.setOnClickListener(listenerPlanet);
        imageViewJupiter.setOnClickListener(listenerPlanet);
        imageViewSaturn.setOnClickListener(listenerPlanet);
        imageViewUranus.setOnClickListener(listenerPlanet);
        imageViewNeptune.setOnClickListener(listenerPlanet);

        return 0;
    }

    public Dialog dialogAboutPlanetClicked(int planet){
        Dialog mDialog = new Dialog(ManHinhChinh.this);
        mDialog.setContentView(R.layout.layout_dialog_show_information_planet);
        mDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);

        SetViewGroupValueDialogPlaner(mDialog,planet);

        return mDialog;
    }

    void SetViewGroupValueDialogPlaner(Dialog mDialog,int planet){
        TextView txtShowPlanerName = (TextView)mDialog.findViewById(R.id.showPlanetName);
        ImageView imgShowPlaner = (ImageView) mDialog.findViewById(R.id.ShowPlanetImage);

        TextView txtShowPlanetEnglishName = (TextView) mDialog.findViewById(R.id.showPlanetEnglish);

        TextView txtShowPlanetS = (TextView)mDialog.findViewById(R.id.showPlanerSB);
        TextView txtShowPlanetR = (TextView)mDialog.findViewById(R.id.showPlanerR);
        TextView txtShowPlanetV = (TextView)mDialog.findViewById(R.id.showPlanerV);

        Button btnMoreDialog = (Button)mDialog.findViewById(R.id.btnClickIntroductionPlanetManHinhChinMore);
        Button btnExitDialog = (Button)mDialog.findViewById(R.id.btnClickIntroductionPlanetManHinhChinExit);

        txtShowPlanerName.setText(getResources().getString(PlanetName[planet]));
        imgShowPlaner.setImageResource(ImageAboutPlaner[planet]);

        if (planet<PlanetArea.length){
            PlanetPhysicCharacteristics physicCharacteristics = new PlanetPhysicCharacteristics();


            txtShowPlanetS.setText(physicCharacteristics.getPlanetArea()[planet]);
            txtShowPlanetR.setText(physicCharacteristics.getPlanetR()[planet]);
            txtShowPlanetV.setText(physicCharacteristics.getPlanetV()[planet]);
        }else {
            // Do something while Error
        }

        txtShowPlanetEnglishName.setText(getResources().getString(PlanerNameEnglish[planet]));
        listenerAboutPlanerIntroductionDialog(btnMoreDialog,btnExitDialog, planet, mDialog);

    }

    boolean listenerAboutPlanerIntroductionDialog(Button btnMoreDialog, final Button btnExitDialog, final int planet, final Dialog mDialog){
        View.OnClickListener listenerAboutPlanerIntroductionDialog1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btnClickIntroductionPlanetManHinhChinMore:
                        MoveMoreIntent(planet);
                        mDialog.dismiss();
                        finish();
                        break;

                    case R.id.btnClickIntroductionPlanetManHinhChinExit:
                        mDialog.dismiss();
                        break;
                }
            }
        };

        btnMoreDialog.setOnClickListener(listenerAboutPlanerIntroductionDialog1);
        btnExitDialog.setOnClickListener(listenerAboutPlanerIntroductionDialog1);

        return true;
    }

    void MoveMoreIntent(final int Planet){
        Bundle DataFromManHinhChinh = new Bundle();

        DataFromManHinhChinh.putInt("ImagePath", ImageAboutPlaner[Planet]);
        DataFromManHinhChinh.putInt("Planet",Planet);

        DataFromManHinhChinh.putString("PlanetName",getResources().getString(PlanetName[Planet]));
        DataFromManHinhChinh.putString("PlanetNameEnglish",getResources().getString(PlanerNameEnglish[Planet]));

        //DataFromManHinhChinh.putString("DienTichBeMat",PlanetArea[Planet]);
        //DataFromManHinhChinh.putString("BanKinhTrungBinh",PlanetR[Planet]);
        //DataFromManHinhChinh.putString("TheTich",PlanetV[Planet]);

        Intent MoreIntent = new Intent(ManHinhChinh.this,MoreAboutPlanet.class);
        MoreIntent.putExtra("DulieuMore", DataFromManHinhChinh);

        startActivity(MoreIntent);

    }

}
