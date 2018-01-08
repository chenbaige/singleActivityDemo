package com.hbandroid.fragmentactivitydemo.common.rx;

import com.hbandroid.fragmentactivitydemo.db.http.entity.ResponseEntity;
import com.hbandroid.fragmentactivitydemo.db.http.entity.ResponseListEntity;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

//import rx.Observable;
//import rx.Subscriber;
//import rx.android.schedulers.AndroidSchedulers;
//import rx.functions.Func1;
//import rx.schedulers.Schedulers;

//import rx.android.schedulers.AndroidSchedulers;

/**
 * Title: basicmvpframwork
 * <p>
 * Description:
 * <p>
 * Author:baigege (baigegechen@gmail.com)
 * <p>
 * Date:2017-05-24
 */
public class RXResponseCompat {

    public static <T> ObservableTransformer<ResponseListEntity<T>, List<T>> compatListResult() {
        return new ObservableTransformer<ResponseListEntity<T>, List<T>>() {
            @Override
            public ObservableSource<List<T>> apply(Observable<ResponseListEntity<T>> upstream) {
                return upstream.flatMap(new Function<ResponseListEntity<T>, ObservableSource<List<T>>>() {
                    @Override
                    public ObservableSource<List<T>> apply(final ResponseListEntity<T> tResponseListEntity) throws Exception {
                        if (tResponseListEntity.success()) {
                            return Observable.create(new ObservableOnSubscribe<List<T>>() {
                                @Override
                                public void subscribe(ObservableEmitter<List<T>> e) throws Exception {
                                    try {
                                        e.onNext(tResponseListEntity.getData());
                                        e.onComplete();
                                    } catch (Exception e1) {
                                        Observable.error(e1);
                                    }
                                }
                            });
                        } else {
                            return Observable.error(new Exception(tResponseListEntity.getMsg()));
                        }
                    }
                }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static <T> ObservableTransformer<ResponseEntity<T>, T> compatResult() {
        return new ObservableTransformer<ResponseEntity<T>, T>() {
            @Override
            public ObservableSource<T> apply(Observable<ResponseEntity<T>> upstream) {
                return upstream.flatMap(new Function<ResponseEntity<T>, ObservableSource<T>>() {
                    @Override
                    public ObservableSource<T> apply(final ResponseEntity<T> tResponseEntity) throws Exception {
                        if (tResponseEntity.success()) {
                            return Observable.create(new ObservableOnSubscribe<T>() {
                                @Override
                                public void subscribe(ObservableEmitter<T> subscriber) throws Exception {
                                    try {
                                        subscriber.onNext(tResponseEntity.getData());
                                        subscriber.onComplete();
                                    } catch (Exception e) {
                                        Observable.error(e);
                                    }
                                }
                            });
                        } else {
                            return Observable.error(new Exception(tResponseEntity.getMsg()));
                        }
                    }
                }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }


}
