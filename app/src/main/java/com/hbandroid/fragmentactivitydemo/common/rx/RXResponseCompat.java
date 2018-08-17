package com.hbandroid.fragmentactivitydemo.common.rx;

import com.hbandroid.fragmentactivitydemo.db.http.entity.ResponseEntity;
import com.hbandroid.fragmentactivitydemo.db.http.entity.ResponseListEntity;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
//import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


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

//    public static <T> Observable.Transformer<ResponseListEntity<T>, List<T>> compatListResult() {
//        return new Observable.Transformer<ResponseListEntity<T>, List<T>>() {
//            @Override
//            public Observable<List<T>> call(Observable<ResponseListEntity<T>> responseListEntityObservable) {
//                return responseListEntityObservable.flatMap(new Func1<ResponseListEntity<T>, Observable<List<T>>>() {
//                    @Override
//                    public Observable<List<T>> call(final ResponseListEntity<T> tResponseListEntity) {
//                        if (tResponseListEntity.success()) {
//                            return Observable.create(new Observable.OnSubscribe<List<T>>() {
//                                @Override
//                                public void call(Subscriber<? super List<T>> subscriber) {
//                                    try {
//                                        subscriber.onNext(tResponseListEntity.getData());
//                                        subscriber.onCompleted();
//                                    } catch (Exception e) {
//                                        Observable.error(e);
//                                    }
//                                }
//                            });
//                        } else {
//                            return Observable.error(new Exception(tResponseListEntity.getMsg()));
//                        }
//                    }
//                }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());
//            }
//        };
//    }

    public static <T> ObservableTransformer<ResponseListEntity<T>, List<T>> compatListResult() {
        return new ObservableTransformer<ResponseListEntity<T>, List<T>>() {
            @Override
            public ObservableSource<List<T>> apply(Observable<ResponseListEntity<T>> upstream) {
                return
            }
        };
    }

    public static <T> Observable.Transformer<ResponseEntity<T>, T> compatResult() {
        return new Observable.Transformer<ResponseEntity<T>, T>() {
            @Override
            public Observable<T> call(Observable<ResponseEntity<T>> responseListEntityObservable) {
                return responseListEntityObservable.flatMap(new Func1<ResponseEntity<T>, Observable<T>>() {
                    @Override
                    public Observable<T> call(final ResponseEntity<T> tResponseListEntity) {
                        if(tResponseListEntity.success()){
                            return Observable.create(new Observable.OnSubscribe<T>() {
                                @Override
                                public void call(Subscriber<? super T> subscriber) {
                                    try {
                                        subscriber.onNext(tResponseListEntity.getData());
                                        subscriber.onCompleted();
                                    } catch (Exception e) {
                                        Observable.error(e);
                                    }
                                }
                            });
                        }else {
                            return Observable.error(new Exception(tResponseListEntity.getMsg()));
                        }
                    }
                }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());
            }
        };
    }

}
