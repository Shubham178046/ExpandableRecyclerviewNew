package com.example.expandablerecyclerview

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expandablerecyclerview.Adapter.ChildAdapter
import com.example.expandablerecyclerview.Adapter.ChildParentModel
import com.example.expandablerecyclerview.Adapter.ParentAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object
    {
        var parentAdapter : ParentAdapter? = null
        var childAdapter: ChildAdapter? = null
        var arrayList: ArrayList<ChildModel> = ArrayList()
        var positions : Int = 0
        var childParentModel = ArrayList<ChildParentModel>()
        var adapterPos : Int?=null
        var parentDemo = ArrayList<ChildParentModel>()
        var parentModel = ArrayList<ChildParentModel>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrayList0  = ArrayList<ParentModel>()
        arrayList0.add(ParentModel("","",""))
       /* arrayList0.add(ParentModel("jagdish","454546","shubham1998"))
        arrayList0.add(ParentModel("arbaaz","342424","shubham1998"))
        arrayList0.add(ParentModel("shivam","132424","shubham1998"))
        arrayList0.add(ParentModel("dhairya","878855","shubham1998"))
*/
        val arrayList1  = ArrayList<ParentModel>()
        arrayList1.add(ParentModel("dhairya","315478","shubham1998"))
        arrayList1.add(ParentModel("shivam","65758","shubham1998"))
        arrayList1.add(ParentModel("arbaaz","56575","shubham1998"))
        arrayList1.add(ParentModel("shubham","86878","shubham1998"))
        arrayList1.add(ParentModel("jagdish","344647","shubham1998"))

        val arrayList2  = ArrayList<ParentModel>()
        arrayList2.add(ParentModel("arbaaz","875754","shubham1998"))
        arrayList2.add(ParentModel("jagdish","979797","shubham1998"))
        arrayList2.add(ParentModel("arbaaz","1214251","shubham1998"))
        arrayList2.add(ParentModel("dhairya","132424","shubham1998"))
        arrayList2.add(ParentModel("shubham","142525","shubham1998"))


        /*parentModel.add(ChildParentModel(0,arrayList0))
        parentModel.add(ChildParentModel(1,arrayList1))
        parentModel.add(ChildParentModel(2,arrayList2))*/

        for(i in 0 until 6)
        {
            parentDemo.add(i, ChildParentModel(i, arrayList0))
        }

        recyclerview_list.layoutManager = LinearLayoutManager(this)
        parentAdapter = ParentAdapter(applicationContext,parentDemo,arrayList0)

       // val pojoArrayList: ArrayList<ParentModel> = parentAdapter!!.arrayList0
       /* childParentModel.add(adapterPos,ChildParentModel(adapterPos,
            arrayList
        ))*/

        Log.d("ParentDemoSize", "onCreate: "+ parentDemo.size)
       // Log.d("ParentChild", "onCreate: " + parentDemo.get(0).childModel!!.size + parentDemo.get(1).childModel!!.size + parentDemo.get(2).childModel!!.size + parentDemo.get(3).childModel!!.size +  parentDemo.get(4).childModel!!.size)
        Log.d("AdapterPos", "onCreate: "+adapterPos)
        Log.d("ArrayListss", "onBindViewHolder: "+parentModel.size)
        recyclerview_list.adapter = parentAdapter

        for(i in 0 until parentAdapter!!.itemCount)
        {
            Log.d("DemoData", "onCreate: " + parentDemo.get(i).position + " " + parentDemo.get(i).childModel!!.get(0).name + " " + parentDemo.get(i).childModel!!.get(0).email + " " + parentDemo.get(i).childModel!!.get(0).number)
        }

    }
}