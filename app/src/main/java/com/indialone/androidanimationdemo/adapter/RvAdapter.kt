package com.indialone.androidanimationdemo.adapter

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.util.Pair
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.indialone.androidanimationdemo.RecyclerViewActivity
import com.indialone.androidanimationdemo.RvLIstItemActivity
import com.indialone.androidanimationdemo.databinding.ItemListLayoutBinding
import com.indialone.androidanimationdemo.model.Person

class RvAdapter(
    private val activity: RecyclerViewActivity,
    private val list: ArrayList<Person>
) : RecyclerView.Adapter<RvAdapter.RvViewHolder>() {
    class RvViewHolder(itemView: ItemListLayoutBinding) : RecyclerView.ViewHolder(itemView.root) {
        val image = itemView.ivProfile
        val name = itemView.tvUsername
        val about = itemView.tvAbout
        val cardview = itemView.cardView

        fun bind(person: Person) {
            Glide.with(itemView.context)
                .load(person.image)
                .centerCrop()
                .into(image)

            name.text = person.name
            about.text = person.about

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        val view = ItemListLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RvViewHolder(view)
    }

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        holder.bind(list[position])

        holder.itemView.setOnClickListener {
            val intent = Intent(activity, RvLIstItemActivity::class.java)
            intent.putExtra("person", list[position])

            val options = ActivityOptions.makeSceneTransitionAnimation(
                activity,
                Pair<View, String>(holder.image, "profileTransition"),
                Pair<View, String>(holder.name, "usernameTransition"),
                Pair<View, String>(holder.about, "aboutTransition")
            )

            activity.startActivity(intent, options.toBundle())


        }
    }


    override fun getItemCount(): Int {
        return list.size
    }
}