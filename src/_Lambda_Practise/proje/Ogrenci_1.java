package _Lambda_Practise.proje;

public class Ogrenci_1 {

    //bir ogrenci listesi olusturun -> Main Class
    // Task 01 -> ad soyad yas diplomaNotu cinsiyet -> Ogrenci Class
    // Task 02 -> toString methodu ile ogrenci bilgilerin yazdirin
    // Task 03 -> Öğrenci notlarını alt ve üst limitlere göre sıralayarak  yazdirin
    // Task 04 -> Öğrencileri yaşlarına göre sıralayark yazdırin
    // Task 04 -> Öğrencileri belirli bir yaşa ve cinsiyete göre sıralayarak listeleyin
    // Task 05 -> Öğrencileri isimlerine göre yazdırın
    // Task 06 -> Öğrencileri soyisimlerine göre yazdırin
    // Task 07 -> Öğrencileri cinsiyetlerine göre yazdıran
    // Task 08 -> listeyi yazdırırken içinde veri var mı diye kontrol edin
    // Task 09 -> reduce metoduyla ortalama hesaplayin
    // Task 10 -> Girilen ogrenci ismini sil
    // Task 11 -> Test amaçlı Öğrenci nesneleri oluşturun.

    String ad;
    String soyAd;
    int yas;
    double diplomaNotu;
    String cinsiyet;

    @Override
    public String toString() {
        return "Ogrenci_1{" +
                "ad='" + ad + '\'' +
                ", soyAd='" + soyAd + '\'' +
                ", yas=" + yas +
                ", diplomaNotu=" + diplomaNotu +
                ", cinsiyet='" + cinsiyet + '\'' +
                '}';
    }

    public Ogrenci_1(String ad, String soyAd, int yas, double diplomaNotu, String cinsiyet) {
        this.ad = ad;
        this.soyAd = soyAd;
        this.yas = yas;
        this.diplomaNotu = diplomaNotu;
        this.cinsiyet = cinsiyet;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyAd() {
        return soyAd;
    }

    public void setSoyAd(String soyAd) {
        this.soyAd = soyAd;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public double getDiplomaNotu() {
        return diplomaNotu;
    }

    public void setDiplomaNotu(double diplomaNotu) {
        this.diplomaNotu = diplomaNotu;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }
}
