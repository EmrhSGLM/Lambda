package _Lambda_;

public class TechPro {

   private String batch;
   private String batchName;
   private int batchOrt;
   private int ogrcSayisi;

   public TechPro () {
   }


   public TechPro(String batch, String batchName, int batchOrt, int ogrcSayisi) {
      this.batch = batch;
      this.batchName = batchName;
      this.batchOrt = batchOrt;
      this.ogrcSayisi = ogrcSayisi;
   }

   public String getBatchName() {   return batchName;   }

   public void setBatchName(String batchName) {   this.batchName = batchName;  }

   public int getOgrcSayisi() {return ogrcSayisi;  }

   public void setOgrcSayisi(int ogrcSayisi) {this.ogrcSayisi = ogrcSayisi;  }

   public int getBatchOrt() { return batchOrt;  }

   public void setBatchOrt(int batchOrt) {this.batchOrt = batchOrt;   }

   public static String getBatch() { return "batch";   }

   public void setBatch(String batch) {this.batch = batch;   }

   @Override
   public String toString() {
      return "TechPro{" +
              "batch='" + batch + '\'' +
              ", batchName='" + batchName + '\'' +
              ", batchOrt='" + batchOrt + '\'' +
              ", ogrcSayisi='" + ogrcSayisi + '\'' +
              '}';
   }


}