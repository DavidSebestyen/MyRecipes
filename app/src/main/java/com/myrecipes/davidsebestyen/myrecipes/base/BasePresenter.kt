package com.myrecipes.davidsebestyen.myrecipes.base

import java.lang.ref.WeakReference

abstract class BasePresenter<V: BaseContract.BaseView> : BaseContract.BasePresenter<V>{

    private var viewRef: WeakReference<V>? = null

    override fun getView(): V? = if (viewRef == null) null else viewRef?.get()


    override fun attachView(view: V) {
        viewRef = WeakReference(view)
    }

    override fun onResume() {
    }

    override fun onDetach() {
        viewRef?.clear()
        viewRef = null    }

    /**
     * @return True if the view this presenter is attached to still exists and not garbage collected
     * since we are holding it through a `WeakReference`
     */
    protected fun isViewAttached(): Boolean {
        return viewRef != null && viewRef!!.get() != null
    }
}