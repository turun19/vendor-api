CRUD Vendor

Disini saya menggunakan Java 17, Maven 3.9.9, PostgreSQL 16 dan IntelliJ IDEA.
Untuk yang pertama, bisa install: 
- Java 17 [LINK](https://www.oracle.com/java/technologies/downloads/#jdk17-windows)
- Maven 3.9.9 [(LINK)](https://maven.apache.org/download.cgi) pilih dibagian zip
- PostgreSQL 16 [(LINK)](https://sbp.enterprisedb.com/getfile.jsp?fileid=1259129)
- IntelliJ IDEA [(LINK)](https://www.jetbrains.com/idea/download/download-thanks.html?platform=windows&code=IIC)

Setelah terinstall set environment variable kedalam system yang ada di PATH

- Instalasi Java 
1.	Setelah Terinstall bisa untuk mencari 

![image](https://github.com/user-attachments/assets/ef497e21-ebf1-4929-afa2-ff227bd01df1)


2.	Lalu bisa pilih Environtment Variables


![image](https://github.com/user-attachments/assets/f341a830-1b9b-42fb-935a-372767fcd3f7)







3.	Setelah ke halaman Environtment Variables 
Set JAVA_HOME
Pilih New pada System variable. 
Masukkan variable name dengan JAVA_HOME dan variable value dengan lokasi file Java sesuai dengan tempat Java terinstall seperti :
c: \ Program Files \ Java \ jdk1.8.0_xx \ bin 
(tetapi ganti bagian “8.0_xx” dengan versi SDK yang diinstall, nggak perlu diubah). Lalu Klik “OK.”
![image](https://github.com/user-attachments/assets/b0988c95-55ff-43dc-b93f-faa9a2bf8db7)

 
4.	Setelah ditambahkan di System Variable klik Path 2 kali
![image](https://github.com/user-attachments/assets/83869501-4505-433b-93d4-6c6ac00c9c14)

 

5.	Setelah di halaman edit environment variables di PATH silahkan pilih new dan tambahkan
%JAVA_HOME%\bin, lalu klik “OK”
![image](https://github.com/user-attachments/assets/a4590859-ccec-4977-b34d-38000a5e6945)


 
6.	Buat memastikan apakah Java sudah terinstall dengan benar, buka terminal cmd. Lalu ketik java –version. Kalau berhasil, maka informasi versi pada Java akan muncul seperti gambar berikut
![image](https://github.com/user-attachments/assets/1a04fc9e-ad5c-42b9-9756-380a0c8e68d5)

- Install Maven :
1.	Setelah Terdownload Maven 3.9.1, Extract file zip yang telah didownload dan letakan folder hasil extract ke direktori yang diinginkan
2.	Lalu bisa pilih Environtment Variables
![image](https://github.com/user-attachments/assets/dcfaf5d9-8cef-4807-9f59-a937d6bc4f90)








3.	Set MAVEN_HOME
Pilih New pada System variable. Masukkan variable name dengan MAVEN_HOME dan variable value dengan lokasi file apache maven yang sudah di extract tadi,seperti contoh:
C:\Users\any_user\Downloads\apache-maven-3.8.1-bin\apache-maven-3.8.1
4.	Pada bagian System Variables, klik 2x opsi Path lalu pilih New. Tambahkan:
%MAVEN_HOME%\bin, lalu klik “OK”.
![image](https://github.com/user-attachments/assets/5dd798b9-6ae1-417b-a98e-8e97d90cf7be)

 

Lalu buka terminal / command prompt lalu ketik mvn –version untuk memastikan jika apache maven telah terinstall
- Install Intellij IDEA
1.	Setelah Download link yang diatas untuk intellij, install dengan setting default
2.	Setelah proses selesai, buka intellij idea apakah sudah terinstall dengan baik
Install PostgreSQL
1.	Setelah Download selesai dengan link diatas, install PostgreSQL
2.	Setelah itu lakukan penginstalan seperti biasa, dan jangan lupa untuk set passwordnya dan untuk portnya default saja 5432
3.	Dan untuk database clusternya silahkan pilih default locale saja. Dan tunggu hingga kelar


- Menjalankan Code di Local
1.	Setelah semuanya terinstall, kitab isa langsung ke Get from VCS
![image](https://github.com/user-attachments/assets/07161c1d-80bc-42f6-aff0-c56ef043a126)


2.	Silahkan untuk memasukan link URL[(LINK)](https://github.com/turun19/vendor-api.git) untuk mengclone repository
3.	Setelah sudah tunggu beberapa saat karna sedang membuild mavennya dan javanya
4.	Sebelum itu, kita buat database terlebih dahulu di pgadmin4 yang sudah terinstal, lalu buat database baru dan restore database yang sudah tersedia di project tersebut di package database. Dan untuk pembuatan databasenya samakan saja dengan nama database yang sudah diekspor agar memudahkan saat dijalankan nanti
5.	Setelah restore selesai, kita Kembali ke intellij, pergi ke application properties yang tepatnya berada di package resource, dan ubah saja di bagian passwordnya.
![image](https://github.com/user-attachments/assets/4fb06ca5-b123-44c9-9bdc-4453144e4d01)

6.	Lalu di bagian spring datasource password ubah password sesuai dengan yang tadi dimasukan passwordnya saat diinstal
7.	Setelah terbuka, install lombok pada intellij, untuk installnya ke File -> Setting -> Plugins -> Search Lombok -> Install
![image](https://github.com/user-attachments/assets/b258f7df-f879-4f3b-acdc-af6324c75120)

8. Setelah terinstall kita langsung running, untuk running bisa menggunakan tombol diatas, atau bisa ke yang ada di gambar
![image](https://github.com/user-attachments/assets/0d7393ae-eec3-4277-bdc0-5665bb7c938f)

9.	Setelah selesai, running code di intellij menggunakan tombol running di atas dan tunggu sampai ada pemberitahuan “Started TechnicalTestPtsisiApplication in 4.336 seconds”
![image](https://github.com/user-attachments/assets/5f376472-94c1-47b5-b353-5e391751d343)

10.	Setelah programnya berjalan, bisa buka chrome dan masukan link tsb untuk melihat dokumentasi, untuk melihat dokumentasinya bisa klik link berikut
http://localhost:8080/swagger-ui/index.html#/
11.	Lalu coba untuk hit api yang telah dibuat ada untuk register, login, menambah vendor, mengupdate vendor, melihat nama vendor yang sudah ditambahkan dan juga bisa menghapus vendor juga dari yang sudah ditambahkan.
12.	atau juga bisa login dengan akun yang sudah terbuat dengan 
email : fulan@gmail.com
password : fulan123
dan langsung mendapatkan token untuk mendapatkan akses ke endpoint yang membutuhkan token
