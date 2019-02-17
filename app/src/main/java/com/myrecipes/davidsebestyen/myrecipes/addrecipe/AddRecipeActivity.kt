package com.myrecipes.davidsebestyen.myrecipes.addrecipe

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.myrecipes.davidsebestyen.myrecipes.R
import com.myrecipes.davidsebestyen.myrecipes.base.BaseActivity
import com.myrecipes.davidsebestyen.myrecipes.databinding.ActivityAddRecipeBinding

class AddRecipeActivity: BaseActivity<AddRecipeContract.View, AddRecipeContract.Presenter>() {
    override fun createPresenter(): AddRecipeContract.Presenter {
        return AddRecipePresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityAddRecipeBinding>(this, R.layout.activity_add_recipe)
        binding.presenter = presenter
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}