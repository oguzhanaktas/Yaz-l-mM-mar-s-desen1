//Elektrik Faturasýný Hesaplayýn: Fabrika Yöntemine Gerçek Bir Dünya Örneð


// Adim1 :Bir Plan soyut sýnýfý oluþturun.

import java.io.*;
     abstract class Plan
   {
            protected double rate;
            abstract void getRate();
            public void calculateBill(int units)
          {
              System.out.println(units*rate);
          }
   }// Plan sýnýfýnýn sonu.
// Adým2:Plan soyut sýnýfýný geniþleten somut sýnýflar oluþturun.
    class  DomesticPlan extends Plan
   {
        //@override
         public void getRate()
        {
             rate=3.50;
        }
   }// DomesticPlan sýnýfýnýn sonu.
     class  CommercialPlan extends Plan
   {
        //@override
         public void getRate()
        {
             rate=7.50;
        }
   }//CommercialPlan sýnýfýnýn sonu  .
     class  InstitutionalPlan extends Plan
   {
        //@override
         public void getRate()
        {
             rate=5.50;
        }
   }//InstitutionalPlan sýnýfýnýn sonu  .
//Adým 3: Verilen bilgilere dayanarak somut sýnýflar nesnesi oluþturmak için bir GetPlanFactory oluþturun ..
 class GetPlanFactory
{
   // Plan türündeki nesneleri almak için getPlan yöntemini kullanýn
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
}// GetPlanFactory sýnýfýnýn sonu.
// Adým 4: Plan tipi DOMESTICPLAN veya COMMERCIALPLAN veya
//INSTITUTIONALPLAN gibi bilgileri aktararak somut sýnýflarýn
//nesnesini elde etmek için GetPlanFactory kullanarak Bill oluþturun.
  class GenerateBill
{
    public static void main(String args[])throws IOException
   {
      GetPlanFactory planFactory = new GetPlanFactory();
      System.out.print("Faturanýn oluþturulacaðý planýn adýný girin:");
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      String planName=br.readLine();
      System.out.print("Fatura için hesaplanacak birim sayýsýný girin:");
      int units=Integer.parseInt(br.readLine());
      Plan p = planFactory.getPlan(planName);
       // DomesticPaln'ýn getRate () yöntemini ve calculateBill () yöntemini çaðýrýn.
       System.out.print("Bill amount for "+planName+" of  "+units+" units is: ");
           p.getRate();
           p.calculateBill(units);

           }
    }//end of GenerateBill class.
