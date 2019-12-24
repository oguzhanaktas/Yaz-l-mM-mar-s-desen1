## Yazılım Mimarisi ve Tasarımı


## Factory Method Pattern(Fabrika yöntemi desen)
Fabrika yordam tasarım deseni, nesne yaratma sorumluluğunun bir yordama verilmesidir. Yaratılan nesne, bir sınıf hiyerarşisindeki alt sınıflardan biridir. Hangi alt sınıfın yaratılacağı kararı fabrika yordam içinde verilir. Bu yordam ile belirli bir sınıf hiyerarşisindeki alt nesnelerden birinin yaratma sorumluluğu belirli bir arayüze verilerek sistemden soyutlanmış olur. Böylece nesneleri yaratma kodlarında, kod tekrarları önlenmiş olur. Sistem içinde sınıfların yaratılacağı yer tek olduğu için, ilgili mantıklar tek bir yerde toplanabilir.

```java
//Elektrik Faturasını Hesaplayın: Fabrika Yöntemine Gerçek Bir Dünya Örneğ


// Adim1 :Bir Plan soyut sınıfı oluşturun.

import java.io.*;      /*we are using io concept in our class that's why we are importing io pacakage.*/

     abstract class Plan

   {
            protected double rate;

            abstract void getRate();


            public void calculateBill(int units)

          {

              System.out.println(units*rate);
          }

   }// Plan sınıfının sonu.


// Adım2:Plan soyut sınıfını genişleten somut sınıflar oluşturun.


     class  DomesticPlan extends Plan
   {
        //@override
         public void getRate()
        {
             rate=3.50;
        }
   }// DomesticPlan sınıfının sonu.



     class  CommercialPlan extends Plan
   {
        //@override
         public void getRate()
        {
             rate=7.50;
        }
   }//CommercialPlan sınıfının sonu  .



     class  InstitutionalPlan extends Plan
   {
        //@override
         public void getRate()
        {
             rate=5.50;
        }
   }//InstitutionalPlan sınıfının sonu  .



//Adım 3: Verilen bilgilere dayanarak somut sınıflar nesnesi oluşturmak için bir GetPlanFactory oluşturun ..

 class GetPlanFactory
{
   // Plan türündeki nesneleri almak için getPlan yöntemini kullanın
     public Plan getPlan(String planType)
    {
            if(planType == null)
           {
             return null;
           }
	      if(planType.equalsIgnoreCase("DOMESTICPLAN"))
           {
             return new DomesticPlan();
           }
           else if(planType.equalsIgnoreCase("COMMERCIALPLAN"))
          {
            return new CommercialPlan();
          }

          else if(planType.equalsIgnoreCase("INSTITUTIONALPLAN"))
          {
            return new InstitutionalPlan();
          }
      return null;
   }
}// GetPlanFactory sınıfının sonu.


// Adım 4: Plan tipi DOMESTICPLAN veya COMMERCIALPLAN veya
//INSTITUTIONALPLAN gibi bilgileri aktararak somut sınıfların
//nesnesini elde etmek için GetPlanFactory kullanarak Bill oluşturun.
  class GenerateBill
{

    public static void main(String args[])throws IOException
   {
      GetPlanFactory planFactory = new GetPlanFactory();
      System.out.print("Faturanın oluşturulacağı planın adını girin:");
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      String planName=br.readLine();
      System.out.print("Fatura için hesaplanacak birim sayısını girin:");
      int units=Integer.parseInt(br.readLine());
      Plan p = planFactory.getPlan(planName);
       // DomesticPaln'ın getRate () yöntemini ve calculateBill () yöntemini çağırın.
       System.out.print("Bill amount for "+planName+" of  "+units+" units is: ");
           p.getRate();
           p.calculateBill(units);

           }
    }//end of GenerateBill class.

