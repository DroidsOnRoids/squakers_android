package com.droidsonroids.squakers.dashboard.list

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.droidsonroids.squakers.dashboard.model.ServiceDescriptor
import kotlinx.android.synthetic.main.service_item.view.*


class ServiceAdapter(val serviceList: List<ServiceDescriptor>) : RecyclerView.Adapter<ServiceViewHolder>(){
    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        holder.bind(serviceList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val view = ServiceItemLayout(parent.context)
        return ServiceViewHolder(view)
    }

    override fun getItemCount() = serviceList.size

}

class ServiceViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(serviceDescriptor: ServiceDescriptor) {
        itemView.image.setImageDrawable(ContextCompat.getDrawable(itemView.context, serviceDescriptor.imageDrawableId))
        itemView.text.text = itemView.context.getString(serviceDescriptor.nameId)
    }

}
