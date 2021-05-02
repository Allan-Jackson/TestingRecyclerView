package com.example.testingrecyclerview.repository


//cria uma data class para servir de repositório
data class HeroModel(
    val heroName: String,
    val realName: String
)
class HeroRepository private constructor(){

    //Singleton
    companion object{
        //instância única
        private val INSTANCE = HeroRepository()
        fun getInstance() = INSTANCE
    }

    private val mHeroList = listOf(
        HeroModel("Batman","Bruce Wayner"),
        HeroModel("Superman","Clark Kent"),
        HeroModel("Wonder Woman","Diana Prince"),
        HeroModel("Green Arrow","Oliver Queen"),
        HeroModel("Flash","Wally West")
    )
    fun getList(): List<HeroModel> = mHeroList
}
