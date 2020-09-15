package com.example.expandablerecyclerview.Adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.expandablerecyclerview.ChildModel
import com.example.expandablerecyclerview.MainActivity
import com.example.expandablerecyclerview.ParentModel
import com.example.expandablerecyclerview.R
import kotlinx.android.synthetic.main.item_recyclerview.view.*

class ParentAdapter(var context : Context,var parentModel : ArrayList<ChildParentModel>,var arrayList :  ArrayList<ParentModel>) : RecyclerView.Adapter<ParentAdapter.ViewHolder>() {
     var childAdapter: ChildAdapter? = null
    var sizeCount : Int = 0
    var positions : Int = 0
    var childParentModel = ArrayList<ChildParentModel>()
    //var arrayList =  ArrayList<ParentModel>()
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return 6
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.details.layoutManager = LinearLayoutManager(context)

       /* childParentModel.add(holder.adapterPosition,ChildParentModel(holder.adapterPosition,
            arrayList
        ))*/
        holder.itemView.add.setOnClickListener {
          //  sizeCount  = sizeCount + 1
            if(holder.itemView.details.childCount == 0)
            {
                sizeCount  = 1
            }
            else
            {
                sizeCount  = childAdapter!!.itemCount + 1
            }
            var add = Integer.parseInt(holder.itemView.count.text.toString())  + 1
            holder.itemView.count.setText(add.toString())
            holder.itemView.details.visibility = View.VISIBLE

            childAdapter = ChildAdapter(context,sizeCount,holder.adapterPosition,parentModel,arrayList)
            arrayList.add(ParentModel("","",""))
            childAdapter!!.notifyDataSetChanged()

            Log.d("NotNUll", "onBindViewHolder: " +  childAdapter!!.itemCount)
            holder.itemView.details.adapter = childAdapter
            /*for (i in 0 until arrayList.size) {
                Log.e(
                    "Name $i",
                    arrayList.get(i).name.toString() + " "
                )
                Log.e(
                    "Pass $i",
                    arrayList.get(i).number.toString() +  " "
                )
                Log.e(
                    "PHONE $i",
                    arrayList.get(i).email.toString() +  " "
                )
            }*/
         /*   for (i in 0 until childParentModel.size) {
                Log.e(
                    "ChildParentName $i",
                    childParentModel.get(holder.adapterPosition).childModel.get(i).name + " " + i

                )
                Log.e(
                    "ChildParentPass $i",
                    childParentModel.get(holder.adapterPosition).childModel.get(i).number +  " " + i
                )
                Log.e(
                    "ChildParentPHONE $i",
                    childParentModel.get(holder.adapterPosition).childModel.get(i).email +  " " + i
                )
            }*/
          // positions = positions + 1


        }

        Log.d("Size", "onBindViewHolder: "+parentModel.size)
        holder.itemView.minus.setOnClickListener {
            if(!(holder.itemView.count.text.toString().equals("0")))
            {
                var add = Integer.parseInt(holder.itemView.count.text.toString())  - 1
                holder.itemView.count.setText(add.toString())
                sizeCount =  sizeCount - 1
                childAdapter!!.notifyItemRemoved(childAdapter!!.itemCount - 1)
                parentModel.get(holder.adapterPosition).childModel!!.removeAt(childAdapter!!.itemCount -1)
                childAdapter = ChildAdapter(context,sizeCount,holder.adapterPosition,parentModel,arrayList)
                holder.itemView.details.adapter = childAdapter
            //    positions = positions - 1
                childAdapter!!.notifyDataSetChanged()
            }
        }

        holder.itemView.setOnClickListener {
            Log.d("Position", "onBindViewHolder: "+position)
        }
    }
    interface OnClick{ fun onClick() }
}