package edu.unikom.latihanparsingapipublik.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import edu.unikom.latihanparsingapipublik.R
import edu.unikom.latihanparsingapipublik.model.DataItem
import kotlin.collections.addAll
import kotlin.text.clear

class UserAdapter(private val users:MutableList<DataItem>) : RecyclerView.Adapter<UserAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list_user, parent, false)

        return ListViewHolder(view)
    }

    fun setUsers(newUsers: List<DataItem>) {
        users.clear()
        users.addAll(newUsers)
        notifyDataSetChanged()
    }

    fun addUser(newUsers: DataItem) {
        users.add(newUsers)
        notifyItemInserted(users.lastIndex)
    }

    fun clear(){
        users.clear()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val user = users[position]

        holder.tvUsername.text = "${user.firstName} ${user.lastName}"
        holder.tvEmail.text = user.email

        Glide.with(holder.itemView.context)
            .load(user.avatar)
            .apply(RequestOptions().override(88,88).placeholder(R.drawable.icon_avatar))
            .transform(CircleCrop())
            .into(holder.ivAvatar)
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvUsername: TextView = itemView.findViewById(R.id.itemName)
        var tvEmail: TextView = itemView.findViewById(R.id.itemEmail)
        val ivAvatar: ImageView = itemView.findViewById(R.id.itemAvatar)
    }
}