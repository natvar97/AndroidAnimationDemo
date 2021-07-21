package com.indialone.androidanimationdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.indialone.androidanimationdemo.adapter.RvAdapter
import com.indialone.androidanimationdemo.databinding.ActivityRecyclerViewBinding
import com.indialone.androidanimationdemo.model.Person

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.recyclerview.layoutManager = LinearLayoutManager(this)
        mBinding.recyclerview.adapter = RvAdapter(this, getList())

    }

    fun getList(): ArrayList<Person> {
        return arrayListOf(
            Person(R.drawable.mypic, "Natavar Prajapati", "Android Developer"),
            Person(R.drawable.image_rdj, "RDJ", "IronMan, Sherlock Holmes"),
            Person(R.drawable.image_christian_bale, "Christian Bale", "Bruce Wayne - Batman"),
            Person(
                R.drawable.image_johny_depp,
                "Johny Depp",
                "Pirates of Carribean - Jack Sparrow"
            ),
            Person(R.drawable.image_akshay, "Akshay Kumar", "Khiladi and Comedian"),
            Person(
                R.drawable.image_leonardo,
                "Leonardo De Caprio",
                "Once upon a time in Hollywood"
            ),
            Person(R.drawable.image_allu_arjun, "Allu Arjun", "South Indian Actor known as Bunny"),
            Person(R.drawable.image_rashmika, "Rashmika Mandana", "Tamil Actress - Geeta Govindam"),
            Person(R.drawable.image_kajal, "Kajal Agrawal", "South Indian Actress - Most Beautiful")
        )
    }

}