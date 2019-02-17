package com.myrecipes.davidsebestyen.myrecipes.base

import android.view.View
import com.myrecipes.davidsebestyen.myrecipes.main.MainContract

interface BaseContract {

    interface BasePresenter<V: BaseView>{

        fun getView(): V?
        /**
         * Called when an `MvpView` is attached to this presenter.
         *
         * @param view The attached `BaseView`
         */
        fun attachView(view: V)

        /**
         * Called when the view is resumed according to Android components
         * NOTE: this method will only be called for presenters that override it.
         */
        fun onResume()

        /**
         * Called when an `BaseView` is detached from this presenter.
         */
        fun onDetach()

    }

    interface BaseView{

    }
}