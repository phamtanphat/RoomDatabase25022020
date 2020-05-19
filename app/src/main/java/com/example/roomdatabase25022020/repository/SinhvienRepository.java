package com.example.roomdatabase25022020.repository;

import android.content.Context;

import com.example.roomdatabase25022020.database.SinhvienDao;
import com.example.roomdatabase25022020.database.SinhvienDatabase;
import com.example.roomdatabase25022020.model.entity.Sinhvien;

import java.util.List;

public class SinhvienRepository {
    private static SinhvienRepository sinhvienRepository = null;
    private SinhvienDao sinhvienDao;

    public SinhvienRepository(Context context) {
        sinhvienDao = SinhvienDatabase.getInstance(context).sinhvienDao();
    }

    public static SinhvienRepository getInstance(Context context) {
        if (sinhvienRepository == null) {
            sinhvienRepository = new SinhvienRepository(context);
        }
        return sinhvienRepository;
    }

    public List<Sinhvien> getListSinhvien() {
        return sinhvienDao.getSinhvien();
    }
}
