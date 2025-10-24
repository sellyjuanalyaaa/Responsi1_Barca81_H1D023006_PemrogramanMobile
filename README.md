# Responsi1_Barca81_H1D023006_PemrogramanMobile

 Nama Sellyjuan Alya Rosalina
 NIM H1D023006
 Shift A/C


# 81 Barcelona FC
Aplikasi mobile berbasis **Android (Kotlin)** yang dirancang untuk menampilkan informasi lengkap mengenai tim sepak bola, termasuk daftar pemain, pelatih, dan sejarah klub. Data diambil secara real-time dari API eksternal.
# ![](Responsi_Barca81_H1D023006%20(1).gif)

---

## Fitur Aplikasi

- Sejarah Klub  
- Info Pelatih  
- Daftar Pemain  

---

## Komponen Utama

- `Model Data`  
- `API Interface`  
- `Retrofit Instance`  
- `ViewModel`  
- `LiveData / StateFlow`  
- `Activity / Fragment`  
- `Adapter`  

---

## Alur Kerja Penggunaan API

1. **Meminta Data**  
   Pengguna membuka layar, lalu `Activity` memanggil `ViewModel` untuk mengambil data dari server melalui Retrofit.

2. **Mengambil dari Server**  
   Retrofit mengirim permintaan ke API secara asynchronous agar aplikasi tetap responsif.

3. **Menerjemahkan JSON**  
   Server mengirim data mentah (JSON), lalu Retrofit dan Model Data mengubahnya menjadi objek Kotlin.

4. **Menyimpan Status**  
   `ViewModel` menyimpan data dalam `LiveData` atau `StateFlow`.

5. **Menampilkan ke UI**  
   `Activity` atau `Fragment` mengamati perubahan data dan otomatis memperbarui tampilan (misalnya daftar pemain).

---

## Teknologi yang Digunakan

- Kotlin  
- Retrofit  
- ViewModel + LiveData  
- ViewBinding  
- RESTful API  




