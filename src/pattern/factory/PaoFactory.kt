package pattern.factory

interface IPao {
	fun tipo(): String
	fun quantidadeCalorias(): Double
	fun valor(): Double
}


class Baguete : IPao {
	override fun tipo(): String {
		return "Baguete"
	}

	override fun quantidadeCalorias(): Double {
		return 356.00
	}

	override fun valor(): Double {
		return 15.30
	}

	override fun toString(): String {
		return "Fabrincando o Pão do tipo ${Baguete()?.tipo()} contendo ${Baguete()?.quantidadeCalorias()} kcal no valor de R$ ${Baguete()?.valor()} Kg"
	}

}

class PaoForma : IPao {
	override fun tipo(): String {
		return "Forma"
	}

	override fun quantidadeCalorias(): Double {
		return 120.00
	}

	override fun valor(): Double {
		return 5.90
	}

	override fun toString(): String {
		return "Fabrincando o Pão do tipo ${PaoForma()?.tipo()} contendo ${PaoForma()?.quantidadeCalorias()} kcal no valor de R$ ${PaoForma()?.valor()} Kg"
	}

}


class Sovado : IPao {
	override fun tipo(): String {
		return "Sovado"
	}

	override fun quantidadeCalorias(): Double {
		return 175.00
	}

	override fun valor(): Double {
		return 15.30
	}

	override fun toString(): String {
		return "Fabrincando o Pão do tipo ${Sovado()?.tipo()} contendo ${Sovado()?.quantidadeCalorias()} kcal no valor de R$ ${Sovado()?.valor()} Kg"
	}

}

enum class Pao {
	Forma, Sovado, Baguete
}

//fun pao(pao: Pao): String? {
//	when (pao) {
//		Pao.Forma -> return "Fabrincando o Pão do tipo ${PaoForma()?.tipo()} contendo ${PaoForma()?.quantidadeCalorias()} kcal no valor de R$ ${PaoForma()?.valor()} Kg"
//		Pao.Baguete -> return "Fabrincando o Pão do tipo ${Baguete()?.tipo()} contendo ${Baguete()?.quantidadeCalorias()} kcal no valor de R$ ${Baguete()?.valor()} Kg"
//		Pao.Sovado -> return "Fabrincando o Pão do tipo ${Sovado()?.tipo()} contendo ${Sovado()?.quantidadeCalorias()} kcal no valor de R$ ${Sovado()?.valor()} Kg"
//		else -> return null
//	}
//}

fun pao(pao: Pao): IPao? {
	when (pao) {
		Pao.Forma -> return PaoForma()
		Pao.Baguete -> return Baguete()
		Pao.Sovado -> return Sovado()
		else -> return null
	}
}

fun main(args: Array<String>) {
	println(pao(Pao.Sovado).toString())
	println(pao(Pao.Baguete).toString())
	println(pao(Pao.Forma).toString())
}