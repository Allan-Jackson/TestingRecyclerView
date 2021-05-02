package com.example.testingrecyclerview

import android.graphics.BlendMode
import android.graphics.BlendMode.COLOR
import android.graphics.BlendModeColorFilter
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.drawable.Drawable
import android.graphics.drawable.ShapeDrawable
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.testingrecyclerview.repository.HeroModel

class HeroAdapter(heroList: List<HeroModel>) : RecyclerView.Adapter<HeroViewHolder>() {

    private val mHeroList: List<HeroModel> = heroList

    //aqui é onde setamos os valores dos elementos do nosso layout de cada item da lista
    //holder é a nossa ViewHolder e position é a posição do item atual, é como se fosse um for_each
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        with(holder){
            textHeroName.text = mHeroList[position].heroName
            textRealName.text = mHeroList.get(position).realName
            textIcon.text = mHeroList.get(position).heroName.first().toString() //pega o primeiro caracter do nome do herói

            //pega o hash do nome do herói para pintar o fundo de forma aleatória
            val hash = mHeroList[position].heroName.hashCode()

            /* textIcon.setBackgroundColor(Color.rgb(hash, hash/2, 0))
             * A linha acima não dá certo, pois ao setar uma cor para o background
             * o background drawable é substituido pela cor, voltando a ficar quadrado
             * ou seja, para mudar o fundo, precisamos criar um drawable de shape oval
             * e então mudar a sua cor */
            //isso é feito no projeto RecyclerViewMaster

            /* Ou então podemos usar um colorFilter no background
             * que já é uma propriedade de Drawable e vai apenas
             * mudar a cor do seu fundo */
            textIcon.background.colorFilter = BlendModeColorFilter(
                Color.rgb(hash/3, hash/2, hash),
                COLOR
            )

            //todo: fazer a lógica do botão de deletar item

        }
    }

    //infla o layout dos itens da lista e anexa a view gerada pelo inflater na viewHolder que será retornada
    //a ViewHolder representa o justamente o layout de cada item da lista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        //para gerar um objeto LayoutInflater é necessário um contexto, por isso usamos o metodo estático LayoutInflater.from(context)
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)

        //inflate serve para retornar um layout XML como um objeto View
        val view: View = inflater.inflate(R.layout.hero_list_item,parent,false)
        return HeroViewHolder(view) //por fim retornamos nossa ViewHolder
    }

    //retorna o tamanho da lista
    override fun getItemCount(): Int = mHeroList.size
}