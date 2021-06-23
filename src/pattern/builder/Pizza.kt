package pattern.builder

class Pizza private constructor(
	val pedacos:Int,
	val sabores:  MutableList<Sabores>?,
val bordas: Bordas,
val observacao: String?){

	class Builder(
		var pedacos: Int = 6,
		var sabores: MutableList<Sabores>? = null,
		var bordas: Bordas = Bordas.NAO,
		var observacao: String? = null){

		fun buildPedacos(pedacos: Int) = apply {this.pedacos = pedacos}
		fun buildSabores(sabores: MutableList<Sabores>) = apply { this.sabores = sabores }
		fun buildBordas(bordas: Bordas) = apply {this.bordas = bordas}
		fun buildObservacao(observacao: String) = apply {this.observacao = observacao}

		fun build() = Pizza(pedacos, sabores, bordas, observacao)
	}

	override fun toString(): String {
		return "Pedido da pizza \n" +
				"Tamanho: "  + tamanho() +
				"Sabores: "+ sabores + "\n" +
		"Borda catupiry: " + bordas() + "\n" +
		"${if(observacao!=null) "Obs.:$observacao" else ""}\n"

	}

	private fun tamanho():String {
		if(pedacos === 6){
			return "Pizza média (6 pedaços) \n"
		} else if(pedacos === 8) {
			return "Pizza Grande (8 pedaços) \n"
		}else if(pedacos === 10) {
			return "Pizza Gigante (10 pedaços) \n"
		}else{
			return "Tamanho inválido\n"
		}
	}

	private fun bordas():String {
		when (bordas) {
			Bordas.NAO -> return "Não"
			Bordas.SIM -> return "Sim"
			else -> return "Não"
		}
	}

}

enum class Sabores{
	FrangoComCatupiry,
	Portuguesa,
	Brigadeiro,
	Siciliana,
	Calabresa,
	Mucarela,
	Milho,
	Napolitana,
	Palmito,
	QuatroQueijos
}

enum class Bordas{
	SIM,
	NAO
}