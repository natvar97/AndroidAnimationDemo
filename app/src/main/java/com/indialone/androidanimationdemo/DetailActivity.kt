package com.indialone.androidanimationdemo

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.util.Pair
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.indialone.androidanimationdemo.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        mBinding.cardView.setOnClickListener {

            val fullDetailsIntent = Intent(this, FullDetailsActivity::class.java)

            val options: ActivityOptions =
                ActivityOptions.makeSceneTransitionAnimation(
                    this@DetailActivity,
                    Pair<View, String>(mBinding.ivProfile, "profileTransition"),
                    Pair<View, String>(mBinding.tvUsername, "usernameTransition"),
                    Pair<View, String>(mBinding.tvAbout, "aboutTransition")
                )


            startActivity(fullDetailsIntent, options.toBundle())

        }

    }
}