## Yazılım Mimarisi ve Tasarımı


## Proxy Kalıbı
Basitçe, proxy başka bir nesneyi temsil eden bir nesne anlamına gelir.
GoF'a göre, bir Proxy Deseni "orijinal nesneye erişim kontrolü sağlar".
Böylece, orijinal nesne bilgilerini gizleme, talep üzerine yükleme vb. Birçok işlemi gerçekleştirebiliriz.
Proxy şablonu ayrıca Yedek veya Yer Tutucu olarak da bilinir.
Orijinal nesneye dış dünyadan koruma sağlar.
Bu kullanılabilen Sanal Vekil büyük boy ayıklamak için birden fazla veritabanı çağrı var bir durum düşünün --- senaryo. Bu pahalı bir işlem olduğundan, burada birden çok proxy oluşturacak ve daha fazla işlem için büyük boyutlu bellek tüketen nesneye işaret eden proxy desenini kullanabiliriz. Gerçek nesne yalnızca bir istemci nesneyi ilk istediğinde / ona eriştiğinde oluşturulur ve bundan sonra nesneyi yeniden kullanmak için proxy'ye başvurabiliriz. Bu, nesnenin kopyalanmasını ve dolayısıyla bellek tasarrufu yapılmasını önler.Koruyucu Proxy senaryosunda kullanılabilir --- Gerçek kullanıcının uygun içeriğe erişip erişmediğini doğrulamak için bir yetkilendirme katmanı görevi görür. Örneğin, ofiste internet erişimi üzerinde kısıtlama sağlayan bir proxy sunucusu. Yalnızca geçerli web sitelerine ve içeriklere izin verilecek ve geri kalanlar engellenecektir

```java
//Bir OfficeInternetAccess arabirimi oluşturduk.
public interface OfficeInternetAccess {  
    public void grantInternetAccess();  
}  

//Bir oluşturun RealInternetAccess uygulayacak sınıfı OfficeInternetAccess belirli çalışana izin verilmesi için arayüz.

public class RealInternetAccess implements OfficeInternetAccess {  
    private String employeeName;  
    public RealInternetAccess(String empName) {  
        this.employeeName = empName;  
    }  
    @Override  
    public void grantInternetAccess() {  
        System.out.println("Internet Access granted for employee: "+ employeeName);  
    }  
} 

//Bir oluşturun ProxyInternetAccess uygulayacak sınıfı OfficeInternetAccess nesne sağlamak için arayüz RealInternetAccess sınıfında.
public class ProxyInternetAccess implements OfficeInternetAccess {  
           private String employeeName;  
           private RealInternetAccess  realaccess;  
               public ProxyInternetAccess(String employeeName) {  
            this.employeeName = employeeName;  
        }  
        @Override  
        public void grantInternetAccess()   
        {  
            if (getRole(employeeName) > 4)   
            {  
                realaccess = new RealInternetAccess(employeeName);  
                realaccess.grantInternetAccess();  
            }   
            else   
            {  
                System.out.println("İnternet erişimi verilmedi. İş düzeyiniz 5'in altında");  
            }  
        }  
        public int getRole(String emplName) {  
            // Ad ve atamaya dayalı olarak veritabanındaki rolü denetleme  
            // iş seviyesi veya iş ataması. 
            return 9;  
        }  
} 

//Şimdi, aslında internete erişebilen bir ProxyPatternClient sınıfı oluşturduk. .
public class ProxyPatternClient {  
    public static void main(String[] args)   
    {  
        OfficeInternetAccess access = new ProxyInternetAccess("Ashwani Rajput");  
        access.grantInternetAccess();  
    }  
}  

/* çıktı*/
/*İnternet erişimi verilmedi. İş seviyeniz 5'in altında  */