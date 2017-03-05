package com.example.phamvanthinh.solarsystemforchill.GAS;

/**
 * Created by nickpham on 25/08/2016.
 */
public class PlanetPhysicCharacteristics {

    String[] KhoiLuong = {"3,3022×10^23 kg","4,867E24 kg","5,972E24 kg","6,4185×10^23 kg","1,8986×10^27 kg","5,6846×10^26 kg","(8,6810 ± 0,0013)×10^25","1,0243×10^26 kg"};
    String[] KhoiLuongRiengTrungBinh = {"5,427 g/cm3","5,243 g/cm3","m/v","3,9335 ± 0,0004 g/cm3","1,326 g/cm3","0,687 g/cm3","1,27 g/cm3","1,638 g/cm3"};
    String[] TongDoVutruCap2 = {"4,25 km/s","10,36 km/s","11,186 km/s","5,027 km/s","59,5 km/s","35,5 km/s","21,3 km/s","23,5 km/s "};
    String[] ChuKyTuQuay = {"58,646 ngày(1407,5 h)","5 ngày","23,934 giờ","24,622 9 h","9,925 h","10 giờ 34 phút","17 h 14 min","16 h 6 min 36 s "};
    String[] VanTocQuayTayXichdao = {"10,892 km/h","6,52 km/h","1674,38 km/h","868,22 km/h","45.300 km/h","35.500 km/h","9.320 km/h","9.660 km/h "};


    String[] PlanetArea = {"74.800.000 KiLoMet Vuông","460.200.000 km²","510.100.000 km²","144.800.000 km"
            , "61.419.000.000 km²","42.700.000.000 km²","8.115.600.000 km²","7.618.300.000 km²"};

    String[] PlanetR = {" 2.440 KiLoMet","6.052 KiLoMet","6.371 KiLoMet","3.390 KiLoMet"
            , "69.911 KiLoMet","58.232 KiLoMet"," 25.362 KiLoMet","24.622 KiLoMet"};

    String[] PlanetV = {"9,28×10^11 KiLoMet Khối","6,083×10^10 KiLomet Khối","1083,2073 × 10^9 km³","1,6318×10^11 KiLoMet Khối"
            , "1,4313×10^15 km3","8,2713×10^14 km3","6,833×10^13 km3","6,254×10^13 km3"};



    public String[] getPlanetArea() {
        return PlanetArea;
    }

    public String[] getPlanetR() {
        return PlanetR;
    }

    public String[] getPlanetV() {
        return PlanetV;
    }

    public String[] getVanTocQuayTayXichdao() {
        return VanTocQuayTayXichdao;
    }

    public String[] getKhoiLuong() {
        return KhoiLuong;
    }

    public String[] getKhoiLuongRiengTrungBinh() {
        return KhoiLuongRiengTrungBinh;
    }

    public String[] getTongDoVutruCap2() {
        return TongDoVutruCap2;
    }

    public String[] getChuKyTuQuay() {
        return ChuKyTuQuay;
    }
}