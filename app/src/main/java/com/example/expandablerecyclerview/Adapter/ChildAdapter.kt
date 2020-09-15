package com.example.expandablerecyclerview.Adapter

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.expandablerecyclerview.ChildModel
import com.example.expandablerecyclerview.ParentModel

import com.example.expandablerecyclerview.R
import kotlinx.android.synthetic.main.item_child_layout.view.*

class ChildAdapter(var context: Context, var dataCount : Int, var adapterPos : Int,var parentModel : ArrayList<ChildParentModel>,var arrayList : ArrayList<ParentModel>) :
    RecyclerView.Adapter<ChildAdapter.ViewHolder>() {
    var name: String? = null
    var number: Int? = null
    var email: String? = null
    var adapterPosition: Int? = null
    var arrayLists = ArrayList<ChildModel>()
    var childParentModel = ArrayList<ChildParentModel>()
   // var arrayList = ArrayList<ChildModel>()

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.item_child_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataCount
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       /* childParentModel.add(holder.adapterPosition,ChildParentModel(holder.adapterPosition,
            arrayList
        ))*/
        Log.d("dataCount", "onBindViewHolder: "+dataCount)
      /*  arrayList.add(position,ChildModel("","",""))*/
        Log.d("arrayChildList", "onBindViewHolder: "+arrayList.size)

       // Log.d("arrayChild", "onBindViewHolder: "+arrayChildList.size+adapterPos)
        adapterPosition = holder.adapterPosition
        if(!(adapterPosition == 0))
        {
            adapterPosition = holder.adapterPosition - 1
        }
        holder.itemView.setOnClickListener {
            for (i in 0 until arrayList.size) {
                Log.e(
                    "Name $i",
                    arrayList.get(i).name.toString() + " "+i
                )
                Log.e(
                    "Pass $i",
                    arrayList.get(i).number.toString() +  " "+i
                )
                Log.e(
                    "PHONE $i",
                    arrayList.get(i).email.toString() +  " "+i
                )
            }

            for (i in 0 until parentModel.size) {
                for(k in 0 until arrayList.size)
                {
                    Log.e(
                        "ChildParentNames $i",
                        parentModel.get(adapterPos).childModel!!.get(k).name + " "

                    )
                    Log.e(
                        "ChildParentPasss $i",
                        parentModel.get(adapterPos).childModel!!.get(k).number +  " "
                    )
                    Log.e(
                        "ChildParentPHONES $i",
                        parentModel.get(adapterPos).childModel!!.get(k).email +  " "
                    )
                }
            }
        }

        holder.itemView.edtName.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d("AdapterPositions", "onTextChanged: "+holder.adapterPosition+adapterPosition)
                val addMorePOJO: ParentModel? = arrayList!!.get(position)
                addMorePOJO!!.name = p0.toString()
                arrayList!!.set(position,addMorePOJO)
            }
        })
        holder.itemView.edtcontact.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d("AdapterPositions", "onTextChanged: "+holder.adapterPosition+adapterPosition)
                val addMorePOJO: ParentModel? = arrayList!!.get(holder.adapterPosition)
                addMorePOJO!!.number = p0.toString()
                arrayList!!.set(holder.adapterPosition,addMorePOJO)
            }
        })
        holder.itemView.edtemail.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {

            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d("AdapterPositions", "onTextChanged: "+holder.adapterPosition+adapterPosition)
                val addMorePOJO: ParentModel? = arrayList!!.get(holder.adapterPosition)
                addMorePOJO!!.email = p0.toString()

            }
        })
        /*holder.itemView.edtName.setText(parentModel.get(adapterPos).childModel!!.get(position).name)
        holder.itemView.edtcontact.setText(parentModel.get(adapterPos).childModel!!.get(position).number.toString())
        holder.itemView.edtemail.setText(parentModel.get(adapterPos).childModel!!.get(position).email)
*/
        Log.d("CheckPosityion", "onBindViewHolder: "+position)

         if(parentModel.get(position).childModel!!.count() > 0)
           {
                   holder.itemView.edtName.setText(parentModel.get(adapterPos).childModel!!.get(position).name)
                   holder.itemView.edtcontact.setText(parentModel.get(adapterPos).childModel!!.get(position).number.toString())
                   holder.itemView.edtemail.setText(parentModel.get(adapterPos).childModel!!.get(position).email)

           }
    }
}