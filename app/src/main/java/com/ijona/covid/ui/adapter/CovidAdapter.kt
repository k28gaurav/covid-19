package com.ijona.covid.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ijona.covid.R
import com.ijona.covid.data.database.model.Area
import kotlinx.android.synthetic.main.item_country_second.view.*

class CovidAdapter(private val context: Context) :
    RecyclerView.Adapter<CovidAdapter.CardViewViewHolder>() {

    private var confirmCase: MutableList<Area> = mutableListOf()

    fun covidAreaList(entryList: List<Area>) {

        confirmCase.clear()
        confirmCase.addAll(entryList)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CardViewViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_country_second, viewGroup, false)
        return CardViewViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        holder.bind(confirmCase[position])
    }

    override fun getItemCount(): Int = confirmCase.size - 1

    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(entry: Area) {

            itemView.tvTitle.text = entry.displayName
            itemView.tvCases.text = entry.totalConfirmed.toString()
            itemView.tvDeathCase.text = entry.totalDeaths.toString()
            itemView.tvRecoverCase.text = entry.totalRecovered.toString()
        }
    }
}


