package com.indialone.androidanimationdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.indialone.androidanimationdemo.databinding.ActivityRvListItemBinding
import com.indialone.androidanimationdemo.model.Person

class RvLIstItemActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityRvListItemBinding
    private var person: Person? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityRvListItemBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        if (intent.hasExtra("person")) {
            person = intent.getParcelableExtra("person")
        }

        if (person != null) {
            Glide.with(this)
                .load(person!!.image)
                .centerCrop()
                .into(mBinding.ivProfileImage)

            mBinding.tvUsername.text = person!!.name
            mBinding.tvAbout.text = person!!.about
        }


    }
}