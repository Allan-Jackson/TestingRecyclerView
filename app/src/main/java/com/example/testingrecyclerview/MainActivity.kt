package com.example.testingrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testingrecyclerview.repository.HeroRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: HeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecycler() //faz todas as preparações necessárias para o nosso recycler funcionar

        //esconde a action bar
        supportActionBar?.hide()
    }

    fun setupRecycler(){
        //cria uma referência para o nosso RecyclerView
        mRecyclerView = recycle_hero

        //cria um adapter de herói passando a lista com os modelos de heróis - as data classes
        mAdapter = HeroAdapter(HeroRepository.getInstance().getList())

        mRecyclerView.adapter = mAdapter //seta o Adapter do RecyclerView

        val linearLayout: LinearLayoutManager = LinearLayoutManager(this) //cria um LayoutManager
        linearLayout.orientation = LinearLayoutManager.VERTICAL //seta a orientação para vertical
        mRecyclerView.layoutManager = linearLayout //seta o layout do nosso RecyclerView para o LinearLayoutManager criado

        /*
         *Cria uma linha divisória entre os itens da lista, pegando desde o ínicio
         *da View até o final, neste projeto eu prefiri continuar usando meu elemento View
         *personalizado que cria uma linha do final até chegar no ícone do herói

          mRecyclerView.addItemDecoration(
              DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
          )
        */
    }

}