package com.cntn2017_mobiledev.batchuduoihinh.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.cntn2017_mobiledev.batchuduoihinh.R
import com.cntn2017_mobiledev.batchuduoihinh.models.User
import java.util.ArrayList

class RankingAdapter(context: Context) : BaseAdapter() {


    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    var items = ArrayList<User>()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val info = items.get(position)

        if (convertView == null) {
                view = inflater.inflate(R.layout.row_item_ranking, parent, false)
        } else {
            view = convertView
        }
        var name = view.findViewById(R.id.textviewUserName) as TextView
        var point = view.findViewById(R.id.textViewScore) as TextView
        if(position==0){
            var ima = view.findViewById<ImageView>(R.id.imageViewRanking)
            ima.setImageResource(R.drawable.rand_first)
        }
        else if(position==1){
            var ima = view.findViewById<ImageView>(R.id.imageViewRanking)
            ima.setImageResource(R.drawable.rand_second)
        }else if(position==2){
            var ima = view.findViewById<ImageView>(R.id.imageViewRanking)
            ima.setImageResource(R.drawable.rank_third)
        }
        name.text = info.userName
        point.text = info.totalPoint

        return view
    }

    fun setItem(list: ArrayList<User>) {
        this.items = list
        notifyDataSetChanged()
    }

    override fun getItem(p0: Int): Any {
        return items.get(p0)
    }

    override fun getCount(): Int {
        return items.size
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }
}