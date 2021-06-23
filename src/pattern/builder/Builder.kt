package pattern.builder

fun main(args: Array<String>) {
	val minhaPizza = Pizza.Builder()
		.buildPedacos(8)
		.buildBordas(Bordas.SIM)
		.buildSabores(mutableListOf(Sabores.Brigadeiro,Sabores.Mucarela, Sabores.FrangoComCatupiry))
		.build()

	println(minhaPizza.toString())

	val minhaPizza2 = Pizza.Builder()
		.buildPedacos(6)
		.buildSabores(mutableListOf(Sabores.Calabresa))
		.buildBordas(Bordas.NAO)
		.buildObservacao("Muita cebola por favor")
		.build()

	println(minhaPizza2.toString())
}