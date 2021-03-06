package com.example.roomdatabase25022020.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.database.Observable;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.roomdatabase25022020.R;
import com.example.roomdatabase25022020.database.SinhvienDatabase;
import com.example.roomdatabase25022020.model.entity.Sinhvien;
import com.example.roomdatabase25022020.repository.SinhvienRepository;
import com.example.roomdatabase25022020.viewmodel.MainViewModel;

import org.reactivestreams.Subscription;

import java.io.ByteArrayOutputStream;
import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    MainViewModel mMainViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMainViewModel = new MainViewModel();
        // Giu lai thong tin cho activity
        mMainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // Chia se vong doi qua cho viewmodel
        getLifecycle().addObserver(mMainViewModel);

        // observer (Lang nghe du lieu)
        observer();
        //setListener(Goi chuc nang)
        setListener();
        //Lay du lieu
//        SinhvienRepository
//                .getInstance(this)
//                .getListSinhvien()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<List<Sinhvien>>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(List<Sinhvien> sinhviens) {
//                        Log.d("BBB",sinhviens.size() + "");
//                        SinhvienRepository
//                                .getInstance(MainActivity.this)
//                                .deleteSinhvien(sinhviens.get(0))
//                                .subscribeOn(Schedulers.io())
//                                .observeOn(AndroidSchedulers.mainThread())
//                                .subscribe(new CompletableObserver() {
//                                    @Override
//                                    public void onSubscribe(Disposable d) {
//
//                                    }
//
//                                    @Override
//                                    public void onComplete() {
//                                        Toast.makeText(MainActivity.this, "Xoa thanh cong", Toast.LENGTH_SHORT).show();
//                                    }
//
//                                    @Override
//                                    public void onError(Throwable e) {
//
//                                    }
//                                });
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });

        // THem du lieu
//        Bitmap bitmap =
//                BitmapFactory.decodeResource(getResources(),R.drawable.hinhdemo);
//        ByteArrayOutputStream stream = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
//        byte[] byteArrayImage = stream.toByteArray();
//
//        Sinhvien sinhvien = new Sinhvien();
//        sinhvien.setName("Nguyen Van A");
//        sinhvien.setAddress("Quan 1");
//        sinhvien.setImage(byteArrayImage);
//        SinhvienRepository
//                .getInstance(this)
//                .insertSinhvien(sinhvien)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<Long>() {
//                    @Override
//                    public void accept(Long aLong) throws Exception {
//                        Toast.makeText(MainActivity.this, aLong + "", Toast.LENGTH_SHORT).show();
//                        Log.d("BBB",aLong + "");
//                    }
//                });

        // Cap nhat sinh vien
//        Sinhvien sinhvien = new Sinhvien();
//        sinhvien.setId(1);
//        sinhvien.setName("Nguyen Van B");
//        sinhvien.setAddress("Quan 2");

//        SinhvienRepository
//                .getInstance(this)
//                .updateSinhvien(sinhvien)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new CompletableObserver() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Toast.makeText(MainActivity.this, "Cap nhat thanh cong", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//                });
    }

    private void observer() {
        mMainViewModel.getSinhvienSuccess().observe(this, new Observer<List<Sinhvien>>() {
            @Override
            public void onChanged(List<Sinhvien> sinhviens) {
                Toast.makeText(MainActivity.this, sinhviens.size() + "", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void setListener() {
        mMainViewModel.getAllSinhVien(this);
    }
}
