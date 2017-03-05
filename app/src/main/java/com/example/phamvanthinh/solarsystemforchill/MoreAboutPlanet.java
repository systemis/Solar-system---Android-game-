package com.example.phamvanthinh.solarsystemforchill;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.phamvanthinh.solarsystemforchill.FragmentManager.fragment_khiquyen_moreS;
import com.example.phamvanthinh.solarsystemforchill.FragmentManager.fragment_overview_moreS;
import com.example.phamvanthinh.solarsystemforchill.FragmentManager.fragment_physic_characterisic_moreS;
import com.example.phamvanthinh.solarsystemforchill.GAS.DacDiemVatLy;
import com.example.phamvanthinh.solarsystemforchill.GAS.KhiQuyen;
import com.example.phamvanthinh.solarsystemforchill.GAS.PlanetPhysicCharacteristics;
import com.example.phamvanthinh.solarsystemforchill.GAS.PlanetsAOverview;
import com.example.phamvanthinh.solarsystemforchill.GAS.QuotationsAboutNatural;

import java.util.Random;

public class MoreAboutPlanet extends AppCompatActivity {

    int ImagePathPlanet,Planet;
    String PlanetName, PlanetEnglishName;

    String overS;

    private static FragmentTransaction fragTransaction;

    private static DrawerLayout layoutThisMore;
    private static Toolbar toolbarMoreAboutPlanet;
    private static FrameLayout frameLayoutshowAboutPlanet;
    private static NavigationView naviMoreAboutPlanetScreen;

    DacDiemVatLy diemVatLyPlanet = new DacDiemVatLy();
    PlanetsAOverview ls = new PlanetsAOverview();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_about_planet);

        GetBundle();


        Log.d("Ten_HanhTinh",PlanetName);

        // Anh xa
        Anhxa();

        diemVatLyPlanet = SosanhvaLayGiatri();

        fragTransaction = this.getSupportFragmentManager().beginTransaction();
        fragTransaction.add(R.id.showAboutPlanet, new fragment_overview_moreS(ImagePathPlanet, overS));
        fragTransaction.commit();

        // Nhung thu lien quan den thanh tren
        isAboutActioBar();
        // Nhung thu lien quan den dau trang cua NavigationView
        AboutHeaderNaviThis();


    }

    int GetBundle(){
        Bundle dataFromManHinhChinh = getIntent().getBundleExtra("DulieuMore");

        ImagePathPlanet = dataFromManHinhChinh.getInt("ImagePath");
        Planet = dataFromManHinhChinh.getInt("Planet");

        PlanetName = dataFromManHinhChinh.getString("PlanetName");
        PlanetEnglishName = dataFromManHinhChinh.getString("PlanetNameEnglish");

        //PlanetS = dataFromManHinhChinh.getString("DienTichBeMat");
        //PlanetR = dataFromManHinhChinh.getString("BanKinhTrungBinh");
        //PlanetV = dataFromManHinhChinh.getString("TheTich");


        return  0;
    }

    void Anhxa(){
        layoutThisMore = (DrawerLayout)this.findViewById(R.id.layoutMainMorePlanetScreen);
        toolbarMoreAboutPlanet = (Toolbar)this.findViewById(R.id.actionbarMoreScreen);
        frameLayoutshowAboutPlanet = (FrameLayout)this.findViewById(R.id.showAboutPlanet);
        naviMoreAboutPlanetScreen = (NavigationView)this.findViewById(R.id.naviMoreScreen);
    }

    boolean isAboutActioBar(){
        //toolbarMoreAboutPlanet.setTitle(PlanetName);
        //toolbarMoreAboutPlanet.setTitleTextColor(R.color.colorTrang);

        this.setSupportActionBar(toolbarMoreAboutPlanet);
        this.getSupportActionBar().setTitle(getResources().getString(R.string.titleOverviewItemMenuNaviMore));
        this.getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Oncreate Listenner drawer of layoutThisMore
        ActionBarDrawerToggle dn = new ActionBarDrawerToggle(
                MoreAboutPlanet.this, layoutThisMore, toolbarMoreAboutPlanet,R.string.OpenTitle, R.string.CloseTitle
                ){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        layoutThisMore.setDrawerListener(dn);
        dn.syncState();

        // Listenet when Item of navigationview clicked
        naviMoreAboutPlanetScreen.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item_navi_more_screen_tongquan:
                        fragTransaction = MoreAboutPlanet.this.getSupportFragmentManager().beginTransaction();
                        fragTransaction.replace(R.id.showAboutPlanet, new fragment_overview_moreS(ImagePathPlanet,overS));
                        fragTransaction.commit();
                        break;

                    case R.id.item_navi_more_screen_back_manhinchinh:
                        startActivity(new Intent(MoreAboutPlanet.this, ManHinhChinh.class));
                        finish();
                        break;

                    case R.id.item_navi_more_screen_dacdiemdialy:
                        fragTransaction = MoreAboutPlanet.this.getSupportFragmentManager().beginTransaction();
                        fragTransaction.replace(R.id.showAboutPlanet, new fragment_physic_characterisic_moreS(diemVatLyPlanet,ImagePathPlanet));
                        fragTransaction.commit();
                        break;

                    case R.id.item_navi_more_khiquen_manhinchinh:
                        fragTransaction = MoreAboutPlanet.this.getSupportFragmentManager().beginTransaction();
                        fragTransaction.replace(R.id.showAboutPlanet, new fragment_khiquyen_moreS(new KhiQuyen().getKiQuyen()[Planet]));
                        fragTransaction.commit();
                        break;

                }

                if(item.getItemId()!=R.id.item_navi_more_screen_back_manhinchinh) {
                    MoreAboutPlanet.this.getSupportActionBar().setTitle(item.getTitle().toString());
                    layoutThisMore.closeDrawers();
                }
                return true;
            }
        });
        return true;
    }

    void AboutHeaderNaviThis(){
        View headerNavi = naviMoreAboutPlanetScreen.inflateHeaderView(R.layout.header_navi_more_planet);

        ImageView imgHeaderAboutPlanet = (ImageView) headerNavi.findViewById(R.id.imageView_logo_app_header_navi_screenMore);
        TextView txtHeaderPlanetName = (TextView) headerNavi.findViewById(R.id.titlePlanetNameHeaderNaviMoreScreen);
        TextView txtHeaderQuotations = (TextView)headerNavi.findViewById(R.id.titleDanhNgonThienNhien);

        imgHeaderAboutPlanet.setImageResource(ImagePathPlanet);
        txtHeaderPlanetName.setText(PlanetName);
        txtHeaderQuotations.setText(Quatations());

    }

    // Lay Danh Ngon
    String Quatations(){
        String DNVietNam = "";
        String[] Quotations = new QuotationsAboutNatural().LayDanhNgonTV();
        int positionToGetQuotations = new Random().nextInt(Quotations.length);

        DNVietNam = Quotations[positionToGetQuotations];

        return DNVietNam;
    }

    // Lay gia tri cho man hinh tong quan
    DacDiemVatLy SosanhvaLayGiatri(){
        DacDiemVatLy diemVatLy = new DacDiemVatLy();
        switch (Planet){
            case 0:
                overS = ls.getMercury();
                break;
            case 1:
                overS = ls.getVenus();
                break;
            case 2:
                overS = ls.getEarth();
                break;
            case 3:
                overS = ls.Mars;
                break;

            case 4:
                overS = ls.getJupiter();
                break;
            case 5:
                overS = ls.getSaturn();
                break;
            case 6:
                overS = ls.getUranus();
                break;
            case 7:
                overS = ls.getNeptune();
                break;
            default:
                break;
        }

        PlanetPhysicCharacteristics physicCharacteristics = new PlanetPhysicCharacteristics();

        diemVatLy.setArea(physicCharacteristics.getPlanetArea()[Planet]);
        diemVatLy.setRPlanet(physicCharacteristics.getPlanetR()[Planet]);
        diemVatLy.setVPlanet(physicCharacteristics.getPlanetV()[Planet]);

        diemVatLy.setKhoiLuong(physicCharacteristics.getKhoiLuong()[Planet]);
        diemVatLy.setKhoiLuongRieng(physicCharacteristics.getKhoiLuongRiengTrungBinh()[Planet]);
        diemVatLy.setTocDoVuTruCap2(physicCharacteristics.getTongDoVutruCap2()[Planet]);
        diemVatLy.setChuKiQuay(physicCharacteristics.getChuKyTuQuay()[Planet]);
        diemVatLy.setTocDoQuayTaiXichDao(physicCharacteristics.getVanTocQuayTayXichdao()[Planet]);

        return diemVatLy;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
        }
        return super.onOptionsItemSelected(item);
    }
}
