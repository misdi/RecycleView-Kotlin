package id.skysoft.kotlin.recycleview.recycleviewapps.data

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import id.skysoft.kotlin.recycleview.recycleviewapps.DetailActivity
import id.skysoft.kotlin.recycleview.recycleviewapps.R
import id.skysoft.kotlin.recycleview.recycleviewapps.model.Person
import kotlinx.android.synthetic.main.list_row.view.*

class PersonListAdapter(private val list: ArrayList<Person>,
                        private val context: Context): RecyclerView.Adapter<PersonListAdapter.ViewHolder>(){

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        //Create our view from our xml file
        val view = LayoutInflater.from(context).inflate(R.layout.list_row,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.binditem(list[position])
    }

    inner class ViewHolder(itemview: View): RecyclerView.ViewHolder(itemview) {
        fun binditem(person: Person){
            var name:TextView = itemView.findViewById(R.id.name) as TextView
            var age:TextView = itemView.findViewById(R.id.age) as TextView
            var detail:TextView = itemView.findViewById(R.id.detailText) as TextView

            name.text = person.name
            age.text = person.age.toString()
            detail.text = person.detail.toString()

            itemView.setOnClickListener{
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("name", person.name)
                intent.putExtra("age",person.age)
                context.startActivity(intent)
               // Toast.makeText(context, name.text, Toast.LENGTH_LONG).show()
            }
        }
    }

}