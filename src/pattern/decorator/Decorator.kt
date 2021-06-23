package pattern.decorator

fun main(args: Array<String>) {
	val lancheSimples = LancheSimples()

	println(lancheSimples.listarIngredientes())

	val lancheCarne = LancheCarne(lancheSimples)

	println(lancheCarne.listarIngredientes())

	val lancheFrango = LancheFrango(lancheSimples)

	println(lancheFrango.listarIngredientes())

	val lancheMolhoFrango = LancheMolho(lancheFrango)

	println(lancheMolhoFrango.listarIngredientesMolho(Molho.Ketchup))

	val lancheMolhoCarne = LancheMolho(lancheCarne)

	println(lancheMolhoCarne.listarIngredientesMolho(Molho.Mostarda))

	val lancheFrangoSemMolho = LancheMolho(lancheFrango)

	println(lancheFrangoSemMolho.listarIngredientes())

}