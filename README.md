# MayinTarlasi
3. Hafta Mayın Tarlası Ödevi

Merhaba. Mayın Tarlası oyununun yapım aşamasını olabildiğince sade bir şekilde burada açıklamaya çalışacağım.

Öncelikle oyunumuzun algoritmasını çıkarmamız gerekiyor. Verilen kurallara riayet ederek şöyle bir pseudo kod hazırlamıştım;

1-	Öncelikle oyuncudan, oyun tahtasını oluşturması için satır ve sütun değeri al.
2-	Bu değerlere göre boş bir oyun tahtası hazırla.
3-	Oyun tahtası değerinin 4’de 1’i olacak sayıda mayın rastgele olacak şekilde bu matrise yerleştirilir.
4-	Kullanıcı oyuna başlar. Oyuncudan, seçeceği satır ve sütun bilgisi girmesini iste.
5-	Seçilen hücrede mayın varsa;
a)	Oyun biter, oyuncu kaybeder
b)	Yoksa, diğer satıra geç
6-	Seçilen hücrenin etrafındaki hücreleri kontrol et. Belirlenen mayın sayısını bu hücre içine yaz.
7-	Tekrar 4. Satırdaki oyuncu seçimine gelinir.
8-	Mayına denk gelmediği sürece, mayın dışındaki tüm hücreleri açan oyuncu oyunu kazanır.

Oyun kodlarının MineSweeper adlı bir sınıfta çalıştırılması istendiği için öncelikle “MineSweeper” isminde bir sınıf yaratıyoruz. Ardından, oyunu çalıştıracağımız ve giriş ekranının olacağı “main” sınıfını yaratıyoruz.

Daha sonra değişkenlerimizi tanımlıyoruz;
-	Field: Oyun alanı çoklu matrisi
-	Mines: Mayınların olduğu çoklu matris
-	Rows: Int değerinde satır sayısı
-	Cols: Int değerinde sütun sayısı
-	openedCells: Int değerinde açılan hücre sayısı (buradan oyunu bitirme koşulunu tetikleyeceğiz)
-	gameOver: Boolean değerinde değişkenimiz, false olduğu sürece oyun devam eder.

Main sınıfında kullanıcı oyunun hoş geldin ekranı ile karşılaşır ve istenen büyüklükte oyun alanı belirlemek için oyuncudan satı ve sütun sayısı bilgisi ister.

Daha sonra MineSweeper sınıfı içerisinde gerekli tanımları yaptıktan sonra ilk önce istenen özellikle bir oyun tahtası tanımlanır.

Daha sonra java.util.Random kütüphanesi ile rastgele üretilen sayılarla oyun alanının 4’de 1’i kadar mayın, oluşturulan satır ve sütunlara dağıtılır.
Her bir hücre için “-“ işareti ve hücreler arasını ayırmak için “|” işareti kullanılarak görsel alan oluşturulur. Burada satır ve sütun bilgileri “field”  matrisine yazdırılır.

Oyuncudan seçim yapacağı hücrenin satır ve sütun bilgileri girilmesi istenir. Burada, oyun alanı dışındaki bir değer girilmesi durumunda hata ekranının çıkması sağlanır. Bunun için girilen değerin sıfırdan büyük ya da eşit ve başta girilen satır ve sütun değerinden küçük olması beklenir. Aynı hücrede “-“ işareti olması o hücrenin açık olmadığını gösterir, aksi halde yine aynı hata ekranı çıkacaktır.

Seçilen hücrede mayın varsa gameOver değişkeni true tanımlanı ve oyun “Kazanılamadı” ibaresi ile bitirilir. Eğer değilse ilgili hücrenin dört bir tarafı kontrol edilir (üst, alt, sağ ve sol) ve ilgili alanlardaki mayın sayısı toplanarak bu hücreye Char değerinde yazılır.
Not: Burada çaprazlardaki hücrelere nasıl erişileceğini bulamadım, sadece dört yönü yazabildim.

Burada while döngüsü gameOver değişkeni true olana kadar devam eder. Ancak oyun tahtasındaki hücre sayısından mayın sayısını çıkardığımızdaki değer ile oyunun başından bu yana döndürdüğümüz count (hamle) değeri eşitlenirse artık oyun tahtasından mayın dışında boş hücre kalmadığı anlaşılmış olur ve gameOver değişkeni tekrar True değerini alır. “Kazandınız” ibaresi ile oyun bitirilir.

Bu oyunda rastgele sayı ve kullanıcıdan veri alma kütüphaneleri kullanılmıştır. Ayrıca çoklu matris, if, for, while döngüleri ve metot kullanımları sağlanmıştır.
