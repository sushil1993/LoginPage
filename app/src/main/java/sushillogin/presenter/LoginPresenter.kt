package sushillogin.presenter

import android.text.TextUtils
import android.util.Log
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import sushillogin.Contracts.LoginContract
import sushillogin.models.LoginModel
import sushillogin.network.ApiClient

class LoginPresenter constructor(var mView: LoginContract.LoginView) : LoginContract.LoginPresenter {

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
                }

                override fun onSubscribe(d: Disposable) {
                    mView.showSuccessMessage()

                }

                override fun onNext(t: LoginModel) {
                 Log.e("LoginModel", t.data?.email)
                    //
                }

                override fun onError(e: Throwable) {
                    Log.e("error", e.message)

                    mView.showErrorMessage()
                }
            })
    }


}