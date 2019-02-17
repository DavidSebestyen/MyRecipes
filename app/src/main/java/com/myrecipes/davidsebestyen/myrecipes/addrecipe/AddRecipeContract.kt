package com.myrecipes.davidsebestyen.myrecipes.addrecipe

import com.myrecipes.davidsebestyen.myrecipes.base.BaseContract

interface AddRecipeContract {

    interface View: BaseContract.BaseView{

    }

    interface Presenter: BaseContract.BasePresenter<View>{

    }
}