# Ahmet Erbay Case Projesi

Bu proje, **Selenium** ve **TestNG** kullanarak web otomasyon testlerini çalıştırmak için hazırlanmıştır. **Allure** ile test raporlaması yapılmaktadır.

## Teknolojiler

* Java 22
* Maven
* Selenium 4.23.0
* WebDriverManager 5.8.0
* TestNG 7.10.2
* Allure 2.27.0

## Kurulum

1. Projeyi bilgisayara klonlayın:

```bash
git clone "https://github.com/ahmeterbay020/ahmet-erbay-case"
```

2. Maven bağımlılıklarını yükleyin:

```bash
mvn clean install
```

3. Java 22 yüklü olmalıdır.

## Testleri Çalıştırma

### TestNG ile:

```bash
mvn test
```

### Allure raporu oluşturma ve görüntüleme:

```bash
mvn allure:serve
```

> Bu komut test çalıştıktan sonra Allure raporunu tarayıcıda açar.

## Proje Yapısı

* `src/main/java` → Yardımcı ve sayfa sınıfları (Page Object)
* `src/test/java` → TestNG test sınıfları
* `pom.xml` → Maven yapılandırması ve bağımlılıklar

## Notlar

* WebDriverManager sayesinde tarayıcı sürücülerini manuel indirmeye gerek yoktur.
* Testler varsayılan olarak **Chrome** üzerinde çalışır. Başka tarayıcı için WebDriver ayarları değiştirilebilir.

