//Elektrik Faturas�n� Hesaplay�n: Fabrika Y�ntemine Ger�ek Bir D�nya �rne�


// Adim1 :Bir Plan soyut s�n�f� olu�turun.

import java.io.*;
     abstract class Plan
   {
            protected double rate;
            abstract void getRate();
            public void calculateBill(int units)
          {
              System.out.println(units*rate);
          }
   }// Plan s�n�f�n�n sonu.
// Ad�m2:Plan soyut s�n�f�n� geni�leten somut s�n�flar olu�turun.
    class  DomesticPlan extends Plan
   {
        //@override
         public void getRate()
        {
             rate=3.50;
        }
   }// DomesticPlan s�n�f�n�n sonu.
     class  CommercialPlan extends Plan
   {
        //@override
         public void getRate()
        {
             rate=7.50;
        }
   }//CommercialPlan s�n�f�n�n sonu  .
     class  InstitutionalPlan extends Plan
   {
        //@override
         public void getRate()
        {
             rate=5.50;
        }
   }//InstitutionalPlan s�n�f�n�n sonu  .
//Ad�m 3: Verilen bilgilere dayanarak somut s�n�flar nesnesi olu�turmak i�in bir GetPlanFactory olu�turun ..
 class GetPlanFactory
{
   // Plan t�r�ndeki nesneleri almak i�in getPlan y�ntemini kullan�n
     public Plan getPlan(String planType)    {
            if(planType == null)           {
             return null;           }
	      if(planType.equalsIgnoreCase("DOMESTICPLAN"))           {
             return new DomesticPlan();           }
           else if(planType.equalsIgnoreCase("COMMERCIALPLAN"))          {
            return new CommercialPlan();
          }
          else if(planType.equalsIgnoreCase("INSTITUTIONALPLAN"))
          {
            return new InstitutionalPlan();
          }
      return null;
   }
}// GetPlanFactory s�n�f�n�n sonu.
// Ad�m 4: Plan tipi DOMESTICPLAN veya COMMERCIALPLAN veya
//INSTITUTIONALPLAN gibi bilgileri aktararak somut s�n�flar�n
//nesnesini elde etmek i�in GetPlanFactory kullanarak Bill olu�turun.
  class GenerateBill
{
    public static void main(String args[])throws IOException
   {
      GetPlanFactory planFactory = new GetPlanFactory();
      System.out.print("Faturan�n olu�turulaca�� plan�n ad�n� girin:");
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      String planName=br.readLine();
      System.out.print("Fatura i�in hesaplanacak birim say�s�n� girin:");
      int units=Integer.parseInt(br.readLine());
      Plan p = planFactory.getPlan(planName);
       // DomesticPaln'�n getRate () y�ntemini ve calculateBill () y�ntemini �a��r�n.
       System.out.print("Bill amount for "+planName+" of  "+units+" units is: ");
           p.getRate();
           p.calculateBill(units);

           }
    }//end of GenerateBill class.
