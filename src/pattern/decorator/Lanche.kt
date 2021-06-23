package pattern.decorator

//Desenvolva uma classe Decorator para a montagem de um Lanche.
//Neste exemplo, você precisa exibir os ingredientes do lanche, onde você deve incrementar o lanche tendo as seguintes fases:
//Lanche Simples possui apenas: Pão com Maionese
//Lanche de Frango possui: Além do Pão com Maionese, Filé de Frango grelhado, Tomate, Alface
//Lanche de Carne possui: Além do Pão com Maionese, Bife, Cebola Roxa, Tomate, Alface
//Molhos para o Lanche possui: Mostarda e Ketchup.
//Após a montagem de toda sua estrutura de DECORATOR,  você precisa criar um exemplo executando, tendo os seguinte cenário:
//- Lanche de Frango SEM MOLHO
//- Lanche DE Carne COM MOLHO.
//
//Exemplo de saída da execução desse script no console:
//
//"Lanche de Frango COM MOLHO: Pão com Maionese, Filé de Frango grelhado, Tomate, Alface, Mostarda e Ketchup"


interface Lanche {
	fun listarIngredientes():String
}


open class LancheDecorator(protected  var lanche: Lanche):Lanche{
	override fun listarIngredientes(): String {
		return lanche.listarIngredientes()
	}
}

class LancheSimples:Lanche{
	override fun listarIngredientes(): String {
		return "Pão com Maionese,"
	}
}

class LancheFrango(lanche: Lanche):LancheDecorator(lanche){
	override fun listarIngredientes(): String {
		return lanche.listarIngredientes() + " Filé de Frango grelhado, Tomate, Alface"
	}
}

class LancheCarne(lanche: Lanche):LancheDecorator(lanche){
	override fun listarIngredientes(): String {
		return lanche.listarIngredientes() + " Bife, Cebola Roxa, Tomate, Alface"
	}
}


class LancheMolho(lanche: Lanche):LancheDecorator(lanche) {
	override fun listarIngredientes(): String {
		if(lanche === LancheFrango(lanche)){
			return "Lanche de Frango SEM MOLHO: " + lanche.listarIngredientes()
		}else{
			return "Lanche de Carne SEM MOLHO: " + lanche.listarIngredientes()
		}

	}

	fun listarIngredientesMolho(molho:Molho):String{
		if(lanche === LancheFrango(lanche)){
			return "Lanche de Frango COM MOLHO: " +  lanche.listarIngredientes() + ", ${molho}"
		}else{
			return "Lanche de Carne COM MOLHO: " +  lanche.listarIngredientes() + ", ${molho}"
		}
	}
}


enum class Molho{
	Mostarda, Ketchup
}