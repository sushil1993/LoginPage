package sushillogin.presenter

import android.text.TextUtils
import android.util.Log
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import sushillogin.contracts.LoginContract
import sushillogin.database.LoginDao
import sushillogin.database.LoginDetailEntity
import sushillogin.database.RoomSingleton
import sushillogin.models.LoginModel
import sushillogin.network.ApiClient

class LoginPresenter constructor(var mView: LoginContract.LoginView, var db: RoomSingleton) :
    LoginContract.LoginPresenter, LoginDao {


    val apiClient = ApiClient.getApiClient()


    override fun validation(email: String, password: String) {
        if (TextUtils.isEmpty(email) || email.equals("")) {
            mView.showErrorMessage()
        } else if (TextUtils.isEmpty(password) || password.equals("")) {
            mView.showErrorMessage()
        } else {
            doLogin(email, password)
        }
    }

    override fun doLogin(email: String, password: String) {
        apiClient.login(email, password).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<LoginModel> {
                override fun onComplete() {
                    mView.showSuccessMessage()
                    Log.e("DATA", getLoginDetail().get(0).last_name)
                }

                override fun onSubscribe(d: Disposable) {
                    mView.showSuccessMessage()
                }

                override fun onNext(t: LoginModel) {
                    insetdb(t)

                    //
                }

                override fun onError(e: Throwable) {
                    Log.e("error", e.message)

                    mView.showErrorMessage()
                }
            })
    }


    override fun insetdb(model: LoginModel) {
        Log.e("LoginModel", model.data?.email)


        var name = LoginDetailEntity(

            model.data!!.id!!.toInt(), model.data!!.role_id!!,
            model.data!!.first_name!!, model.data!!.last_name!!, model.data!!.email!!, model.data!!.username!!,
            model.data!!.gender!!, model.data!!.phone_no!!
        )
        var value = insert(name)

        Observable.just(db.LoginDao().insert(name))
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe()

        //insert(name)


    }

    override fun getLoginDetail(): List<LoginDetailEntity> {
        var detailEntity = db.LoginDao().getLoginDetail();
        return detailEntity
    }

    override fun insert(loginDetailEntity: LoginDetailEntity) {
        mView.onDataInserted()
    }

}