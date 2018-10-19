package com.example.asus.tugas2_listmovie;

import java.io.Serializable;

public class TampilMovie{
    String judul;
    Double rate;
    String status;
    public TampilMovie(String judul, Double rate, String status) {
        this.judul = judul;
        this.rate= rate;
        this.status = status;
    }
}
