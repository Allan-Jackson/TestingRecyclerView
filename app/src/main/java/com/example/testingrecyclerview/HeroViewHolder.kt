package com.example.testingrecyclerview
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//a classe RecyclerView.ViewHolder tem um construtor que recebe uma View,
//logo, para herdar a classe, é necessário ter essa view no construtor
class HeroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val textIcon = itemView.findViewById<TextView>(R.id.text_icon)
    val textHeroName = itemView.findViewById<TextView>(R.id.text_heroName)
    val textRealName = itemView.findViewById<TextView>(R.id.text_realName)
    val buttonDelete = itemView.findViewById<ImageButton>(R.id.image_trash)
}